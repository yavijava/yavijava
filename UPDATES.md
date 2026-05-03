# Upgrade Notes — 9.0

This document covers breaking changes and things to verify before upgrading your application to this version.

---

## Breaking Changes

### `com.vmware.vim.rest` Package Removed

The `com.vmware.vim.rest` package (`RestClient`, `RestManagedObject`, `CachedManagedObject`, `ResultConverter`, and the bundled `RestAppDemo` sample) has been removed.

This package parsed VMware Managed Object Browser (MOB) HTML responses using a hand-rolled recursive parser. It was not compatible with modern vSphere, had no test coverage, and contained a stack overflow vulnerability (CVE-2023-51084) in `ResultConverter.convert2Xml` caused by unbounded mutual recursion on deeply nested HTML tables.

**What to check:**

- If your application imports anything from `com.vmware.vim.rest.*`, those imports will no longer compile. There is no replacement — use the SOAP-based `mo/` wrapper layer instead.

---

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

- If you call `VRPResourceManager.*` or the single-arg `queryVmfsDatastoreCreateOptions(String)` overload, your code will no longer compile. Migrate or delete those call sites.
- If you consume the return value of `CryptoManagerKmip.updateKmipServer`, drop the assignment.
- Other callers continue to work without changes.

---

### mo/ Layer Regenerated to vSphere 9.0 API Parity

The `mo/*` convenience wrappers (115 existing classes + 18 new classes) have been regenerated to match the vSphere 9.0 WSDL. All new methods available in the stub are now surfaced via typed wrapper methods.

**New managed-object wrapper classes:**

| Class | Notes |
|---|---|
| `CryptoManagerHost` | Host-side key management |
| `CryptoManagerHostKMS` | Host KMS management |
| `DirectPathProfileManager` | DirectPath profile CRUD |
| `HealthUpdateManager` | Custom health provider registration |
| `HostAssignableHardwareManager` | Host assignable hardware config |
| `HostNvdimmSystem` | NVDIMM namespace management |
| `HostSpecificationManager` | Host specification queries |
| `HostVStorageObjectManager` | Host-side FCD (First Class Disk) management |
| `ServiceManager` | Guest service enumeration |
| `SimpleCommand` | Simple command execution |
| `SiteInfoManager` | Site info queries |
| `StorageQueryManager` | Storage-related host queries |
| `TenantTenantManager` | Tenant/service-provider entity management |
| `VStorageObjectManagerBase` | Shared base for FCD managers |
| `VcenterVStorageObjectManager` | vCenter-side FCD management |
| `VirtualMachineGuestCustomizationManager` | In-guest customization tasks |
| `VirtualizationManager` | Virtualization manager stub |

**Caller-visible API changes in existing classes:**

- `ServiceInstance` — public URL/session constructors were moved into the custom fence (preserved across regeneration). No change to call sites.
- `SessionManager.cloneSession()` — uses `new ServiceInstance(ServerConnection)` internally (no public API change).
- `StorageResourceManager` — several methods that previously returned `void` or wrong types now correctly return `Task` and match the stub: `applyRecommendation`, `applyRecommendationToPod`, `configureDatastoreIORM`, `configureStorageDrsForPod`, `refreshRecommendationsForPod`.
- `StorageResourceManager.validateStoragePodConfig` — return type corrected to `LocalizedMethodFault` (was `MethodFault[]`).
- `HostStorageSystem` — `markPerenniallyReservedEx`, `resolveMultipleUnresolvedVmfsVolumesEx`, `turnDiskLocatorLedOff`, `turnDiskLocatorLedOn` corrected from `Task[]` to single `Task`.
- `HealthUpdateManager.queryFilterEntities`, `queryMonitoredEntities`, `queryUnmonitoredHosts` — return `ManagedObjectReference[]` instead of typed arrays (matches stub).
- `TenantTenantManager.retrieveServiceProviderEntities` — returns `ManagedObjectReference[]` instead of `ManagedEntity[]`.

**What to check:**

- Code calling any of the `StorageResourceManager` methods listed above should verify it handles the `Task` return correctly.
- Code consuming `HealthUpdateManager.queryFilterEntities` / `queryMonitoredEntities` / `queryUnmonitoredHosts` now receives `ManagedObjectReference[]` — wrap with `MorUtil.createExactManagedObject` if a typed object is needed.
- New classes are purely additive; existing call sites continue to compile unchanged.

---

### vSphere 6.5 API Support Added

The vSphere 6.5 API surface has been merged in. The default SOAP action for **unknown API versions** has changed from `urn:vim25/6.0` to `urn:vim25/6.5`.

**What to check:**

- If you were relying on the fallback behavior of `setSoapActionOnApiVersion()` for unrecognized version strings, calls will now negotiate at the 6.5 level instead of 6.0. Test against your vSphere environment to confirm compatibility.
- New managed objects are available: `CryptoManager` and `CryptoManagerKmip`.
- New data objects, fault types, and enums covering the 6.5 API are now included.

---

### SOAP Action Negotiation Now Recognizes vSphere 6.7 / 7.0 / 8.0 / 9.0

`setSoapActionOnApiVersion()` previously had explicit cases only through 6.5 — anything newer fell through to the 6.5 default. When connected to a vCenter 7.x/8.x/9.x, this caused the server to negotiate at the 6.5 protocol level, which silently returned a 6.5-era subset of `ServiceContent` and `HostConfigManager` (no `tenantManager`, `siteInfoManager`, `storageQueryManager`, `directPathProfileManager`, `guestCustomizationManager`, `assignableHardwareManager`, `nvdimmSystem`, etc.). Calls would compile and not error — fields would just come back `null`.

**What changed:**

- New enum constants: `SOAP_ACTION_V67`, `SOAP_ACTION_V70`, `SOAP_ACTION_V80`, `SOAP_ACTION_V90`.
- `setSoapActionOnApiVersion()` now normalizes the four-part `apiVersion` string that 7.0+ servers report (e.g. `9.0.0.0` → matched as `9.0`) before looking up the SOAP action.
- The default SOAP action for **unknown future API versions** is now `urn:vim25/9.0` (was `urn:vim25/6.5`).

**What to check:**

- If you talked to a vSphere 7.x/8.x/9.x server before and saw fields you expected to be populated coming back `null`, this fix likely resolves them. Re-test inventory walks and `ServiceContent` consumers.
- If you explicitly want the old behavior (negotiate at 6.5), call `getWsc().setSoapActionOnApiVersion("6.5")` after connection setup.

---

## Bug Fixes

### Guest Manager Null-Return NPE (`GuestFileManager`, `GuestProcessManager`, `GuestAuthManager`)

Several guest-operation wrapper methods could receive a `null` result from the vSphere API and then unconditionally dereference it, throwing `NullPointerException`. Affected methods now guard against null before returning.

**What to check:**

- Code that previously relied on an NPE as an implicit error signal from these methods should add an explicit null check instead.

---

### Charset Fixes (`SoapClient`, `VerUtil`)

SOAP request encoding and HTTP response parsing now explicitly use UTF-8 instead of the platform default charset. This prevents corrupted request bodies or misread responses on hosts where the default charset is not UTF-8 (e.g. Windows hosts with a non-UTF-8 system locale).

**What to check:**

- No API change. If you were on a non-UTF-8 host and saw garbled characters or parse failures, this resolves them.

---

### Integer Overflow in `VirtualMachineDeviceManager.createHardDisk`

The disk-size calculation `diskSizeMB * 1024` was `int * int`, silently overflowing to a negative or wrong value for disks larger than 2 TB. Fixed to `(long) diskSizeMB * 1024L`.

**What to check:**

- No API change. Code creating disks ≥ 2 TB will now send the correct capacity to vSphere instead of a wrapped negative value.

---

### Resource Leak in `ApacheHttpClient.post()`

`CloseableHttpClient` and `CloseableHttpResponse` were created but never closed, leaking HTTP connections on every SOAP call. Both are now wrapped in try-with-resources; the response body is buffered into a `ByteArrayInputStream` before the connection is released.

**What to check:**

- No API change. The `InputStream` returned from `post()` is now a self-contained `ByteArrayInputStream`; callers that closed or streamed it continue to work correctly.

---

### `CacheInstance.getCopy(ManagedObjectReference, String)` — Infinite Recursion

This method was silently broken since it was introduced: it called itself recursively, causing a `StackOverflowError` on every invocation. It now correctly retrieves the cached value and returns a deep copy.

**What to check:**

- Any code path that called `cacheInstance.getCopy(mor, propertyName)` (with a `ManagedObjectReference` argument, not a `ManagedObject`) was throwing `StackOverflowError` at runtime. That code will now work correctly.
- The method also now returns `null` for unknown MORs or missing property keys instead of throwing an exception.

---

## Dependency Version Bumps

| Dependency | Old | New |
|---|---|---|
| Apache HttpClient | `httpclient:4.5.14` | `httpclient5:5.5.2` |
| SLF4J API | 1.x | 2.0.17 |
| dom4j | 1.6.1 | 2.1.4 |
| Lombok | 1.16.x | 1.18.38 |
| objenesis | — | 3.4 |
| JUnit | 4.12 | 4.13.2 |

---

## No-Impact Changes

The following changes are internal and do not affect your application code:

- Gradle build upgraded from 2.2 to 8.13
- CI pipeline added (GitHub Actions, JDK 21 Temurin)
- log4j replaced with SLF4J throughout (no log4j on the classpath)
- Comprehensive unit test suite added across the `ws` and `cf` packages
- CRLF → LF: all source and configuration files converted from Windows line endings to Unix line endings (dos2unix)
- SpotBugs and OWASP Dependency-Check wired into the Gradle build (`check` and `dependencyCheckAnalyze`)
- Deprecated Java reflection APIs in `XmlGenDom` updated for Java 9+ (`isAccessible()` → `canAccess()`, `newInstance()` → `getDeclaredConstructor().newInstance()`)
- `dom4j` exception unwrapping in `XmlGenDom` corrected to use `getCause()` instead of `getNestedException()`, which returned `null` for SAX parse errors
- Raw `Hashtable` in `ManagedObject` / `PropertyCollectorUtil` parameterised to `Hashtable<String, Object>`
- `TaskManager.getDescriptioin()` typo-method removed (the correctly-spelled `getDescription()` is unaffected)
- Missing `@Deprecated` annotations added to eleven managed-object methods that carried the `@deprecated` Javadoc tag without the corresponding annotation
- `@apiNote` security warnings added to `ApacheTrustSelfSigned.trust()`, `CustomSSLTrustContextCreator.getTrustContext()`, and `VerUtil.getTargetNameSpace()`
