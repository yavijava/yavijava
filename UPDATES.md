# Upgrade Notes — 6.5.01-SNAPSHOT

This document covers breaking changes and things to verify before upgrading your application to this version.

---

## Breaking Changes

### Apache HttpClient 4 → 5

The HTTP transport layer has been migrated from `org.apache.httpcomponents:httpclient` (4.x) to `org.apache.httpcomponents.client5:httpclient5` (5.x).

**What to check:**

- If your application depends directly on `httpclient` 4.x alongside yavijava, the two versions cannot share the same classpath without shading. Upgrade your own `httpclient` usage to `httpclient5` as well.
- Classes that were previously in `org.apache.http.*` are now in `org.apache.hc.client5.http.*` and `org.apache.hc.core5.http.*`. Any code that imported or referenced these classes directly will need to be updated.
- `RequestConfig.setSocketTimeout(int)` has been renamed to `setResponseTimeout(Timeout)`. If you were passing a custom `RequestConfig`, update accordingly.
- `AllowAllHostnameVerifier` has been removed; replace it with `NoopHostnameVerifier.INSTANCE`.
- SSL socket factory configuration on `HttpClientBuilder` (`setSSLSocketFactory`) has been removed. SSL is now configured through `PoolingHttpClientConnectionManagerBuilder`.

---

### Java Source / Target Compatibility — Java 11 → 21

yavijava now compiles targeting Java 21. The minimum JDK required to **build** the library has increased to Java 21.

**What to check:**

- Applications running on Java 11 or 17 can still **use** the compiled jar, but you can no longer build yavijava from source with a JDK older than 21.
- If your build toolchain pins a JDK version, update it to 21 or later.

---

### Observable/Observer Removed

The internal cache notification mechanism has been refactored away from the deprecated `java.util.Observable` / `java.util.Observer` classes (removed in Java 9+) to a typed functional interface.

**What to check:**

- If you were directly implementing `java.util.Observer` and registering it with `ManagedObjectWatcher` via `addObserver()`, that API no longer exists.
- Replace `Observer` implementations with `PropertyFilterUpdateListener` and register via `mom.addListener(listener)`.

  **Before:**
  ```java
  class MyListener implements Observer {
      public void update(Observable o, Object arg) {
          PropertyFilterUpdate[] updates = (PropertyFilterUpdate[]) arg;
          // handle updates
      }
  }
  mom.addObserver(new MyListener());
  ```

  **After:**
  ```java
  mom.addListener(updates -> {
      // handle updates
  });
  ```

---

### vSphere 9.0 WSDL Bump

The WSDL (and the regenerated `vim25/*` data objects, enums, and `VimStub`) is now at vSphere 9.0. Several `mo/*` wrapper signatures changed to match. Most are additive (new optional params nulled internally), but a handful are caller-visible breaks.

**Public API removals:**

- `AlarmManager.setAlarmStatus(Alarm, ManagedEntity, String)` — the underlying WSDL operation is gone in 9.0. There is no replacement.
- `VRPResourceManager` (entire class) — VRP (Virtual Resource Pool) was removed by VMware in vSphere 9.0. All twelve underlying stub methods (`createVRP`, `deleteVRP`, `deployVM`, `getAllVRPIds`, `getChildRPforHub`, `getRPSettings`, `getVRPofVM`, `getVRPSettings`, `getVRPUsage`, `setManagedByVDC`, `undeployVM`, `updateVRP`) are gone. The generated `VRPEditSpec` and `VrpResourceAllocationInfo` data objects remain (regen output, harmless).
- `HostDatastoreSystem.queryVmfsDatastoreCreateOptions(String)` (the SDK4.1 single-arg overload) — removed from the 9.0 stub. Use `queryVmfsDatastoreCreateOptions(String devicePath, int vmfsMajorVersion)` (the SDK5.0 overload) instead.

**Public API signature changes:**

- `CryptoManagerKmip.updateKmipServer(KmipServerSpec)` — return type changed from `String` to `void`. Drop any call-site usage of the return value.

**Public API additions (new overloads, existing call sites still compile):**

- `CryptoManager.listKeys(int limit)` — new required `limit` is surfaced as a wrapper arg. The no-arg `listKeys()` overload is retained and delegates with `limit = 0` (WSDL convention for "no limit"; verify against your vCenter if uncertain).
- `DatastoreNamespaceManager.createDirectory(Datastore, String, String, long size)` — new 4-arg overload accepting `size`. The existing 3-arg overload is retained and delegates with `size = 0L`.
- `HostStorageSystem.removeInternetScsiSendTargets(String, HostInternetScsiHbaSendTarget[], boolean force)` — new 3-arg overload accepting `force`. The existing 2-arg overload is retained and delegates with `force = false` (preserves prior non-forced behavior).

**Internal changes (no public API impact):**

- The stub call inside `HostAccessManager.changeLockdownMode` was renamed from `changeHostLockdownMode` to `changeLockdownMode` to track the WSDL rename. The public wrapper method name is unchanged.
- A defensive `List` → `String[]` cast in `VimStub.fetchDVPortKeys` (originally added in commit `6eb81f6a` for issue-28) had to be reapplied after the regen. See `REGEN-NOTES.md` for the list of hand-fixes that future WSDL regens must preserve.

**What to check:**

- If you call `AlarmManager.setAlarmStatus`, `VRPResourceManager.*`, or the single-arg `queryVmfsDatastoreCreateOptions(String)` overload, your code will no longer compile. Migrate or delete those call sites.
- If you consume the return value of `CryptoManagerKmip.updateKmipServer`, drop the assignment.
- Other callers continue to work without changes.

---

### vSphere 6.5 API Support Added

The vSphere 6.5 API surface has been merged in. The default SOAP action for **unknown API versions** has changed from `urn:vim25/6.0` to `urn:vim25/6.5`.

**What to check:**

- If you were relying on the fallback behavior of `setSoapActionOnApiVersion()` for unrecognized version strings, calls will now negotiate at the 6.5 level instead of 6.0. Test against your vSphere environment to confirm compatibility.
- New managed objects are available: `CryptoManager` and `CryptoManagerKmip`.
- New data objects, fault types, and enums covering the 6.5 API are now included.

---

## Bug Fixes

### `CacheInstance.getCopy(ManagedObjectReference, String)` — Infinite Recursion

This method was silently broken since it was introduced: it called itself recursively, causing a `StackOverflowError` on every invocation. It now correctly retrieves the cached value and returns a deep copy.

**What to check:**

- Any code path that called `cacheInstance.getCopy(mor, propertyName)` (with a `ManagedObjectReference` argument, not a `ManagedObject`) was throwing `StackOverflowError` at runtime. That code will now work correctly.
- The method also now returns `null` for unknown MORs or missing property keys instead of throwing an exception.

---

## Dependency Version Bumps

| Dependency | Old | New |
|---|---|---|
| Apache HttpClient | `httpclient:4.5.14` | `httpclient5:5.4.1` |
| SLF4J API | 1.x | 2.0.17 |
| dom4j | 1.6.1 | 2.1.4 |
| Lombok | 1.16.x | 1.18.36 |
| JUnit | 4.12 | 4.13.2 |

---

## No-Impact Changes

The following changes are internal and do not affect your application code:

- Gradle build upgraded from 2.2 to 8.13
- CI pipeline added (GitHub Actions, JDK 21 Temurin)
- log4j replaced with SLF4J throughout (no log4j on the classpath)
- Comprehensive unit test suite added across the `ws` and `cf` packages
