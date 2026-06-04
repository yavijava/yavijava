# Upgrade Notes — 9.0

This document covers breaking changes and things to verify before upgrading your application to this version.

---

## 9.0.2 — Bug Fixes

No breaking changes from 9.0.1. Bug fixes only:

- **`ManagedObject.getCurrentProperty()` `IllegalArgumentException: Unable to convertProperty on null object.` (#360).** `getCurrentProperty` guarded `dynaProps[0] != null` but not `dynaProps[0].getVal() != null`, then passed the value straight into `PropertyCollectorUtil.convertProperty`, which throws on null input. Reachable when the `XmlGenDom` deserializer cannot resolve an `ArrayOf*` xsi:type on a `DynamicProperty.val` and leaves the field unset (see #320), or via any other code path that lands a present-but-null val on `ObjectContent.propSet`. This affected every thin accessor built on `getCurrentProperty` — for example `ManagedEntity.getCustomValue()` and `VirtualMachine.getSnapshot()`. The accessor now returns `null` for a present-but-null property, restoring the expected behavior for unset optional managed-object properties.

---

## 9.0.1 — Bug Fixes

No breaking changes from 9.0. Bug fixes only:

- **`VirtualMachine.getConfig()` `IllegalArgumentException` for VMs with vTPM (#352).** `XmlGenDom.fromXml()` collapsed `byte[][]` fields (`VirtualTPM.endorsementKeyCertificateSigningRequest`, `VirtualTPM.endorsementKeyCertificate`) to `byte[]` via a single `getComponentType()` call, then tried to assign the resulting `byte[]` to the `byte[][]` field. Any VM with a virtual TPM device — Windows 11 mandates one by default — threw on `getConfig()`. The deserializer now special-cases `byte[][]` fields and base64-decodes each element into the outer array.
- **`ERROR` log spam from `serialVersionUID` on every serialization (#353).** `XmlGen.toXML()` iterated all declared fields and filtered only `transient`, so the `private static final long serialVersionUID` on every `Serializable` `ArrayOf*` class hit `Field.get()` and triggered an `IllegalAccessException` that was caught and logged at `ERROR`. Wire output was correct, but the noise was per-call. The field-iteration guard now also skips `static` fields.

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

## New Features

### `Task.waitForTask` — Bounded Wait with `TimeoutException`

Two new overloads give callers a deadline instead of an infinite wait:

```java
task.waitForTask(long maxWaitMillis);
task.waitForTask(int runningDelay, int queuedDelay, long maxWaitMillis);
```

Both throw `java.util.concurrent.TimeoutException` if the task has not reached a terminal state within the deadline. The existing zero- and two-argument overloads are unchanged and still wait indefinitely.

---

### `ServiceInstance` — Locale-Aware Constructors

Two new constructors accept a `locale` string and pass it through to `login()`:

```java
new ServiceInstance(URL url, String username, String password, boolean ignoreCert, String locale);
new ServiceInstance(URL url, String username, String password, boolean ignoreCert, String appName, String locale);
```

Existing constructors are unchanged and continue to pass `null` for locale.

---

### `InventoryNavigator.searchManagedEntitiesWithProperties`

New method that performs the same inventory traversal as `searchManagedEntities` but pre-populates each returned entity's property cache from the `PropertyCollector` results. Subsequent calls to typed getters (e.g. `vm.getName()`, `vm.getRuntime()`) return the pre-fetched value without a round-trip to vSphere.

The existing `searchManagedEntities(typeinfo, recurse)` overload is unchanged; it discards the retrieved property values as before.

---

### `CacheInstance.awaitReady(long timeoutMillis)`

New method that blocks until the cache delivers its first `onUpdate` event (i.e. is populated and ready to serve reads), removing the start()/get() race window where callers polled `isReady()` in a loop.

`destroy()` is also hardened: it now calls `pc.cancelWaitForUpdates()` to break any in-flight long-poll so the watcher thread exits promptly, joins the thread (5 s) before returning, tolerates being called before `start()`, and is idempotent on repeated invocations. Call `destroy()` before disconnecting the `ServerConnection`.

---

### `vim25` Data Classes Implement `Serializable`

`DynamicData` (root of ~1 174 data-object subclasses), `DynamicProperty`, `DynamicArray`, `ManagedObjectReference`, and all 614 `ArrayOf*` wrapper classes now implement `java.io.Serializable` (with `serialVersionUID = 1L`). This enables callers to snapshot vSphere state to disk, send it over Java serialization streams, or store it in a serialization-based cache.

The `mo/` wrapper layer (`ServerConnection`, `WSClient`, managed-object classes) is intentionally **not** serializable — those hold live HTTP connections.

---

### `FailoverClusterConfigurator` and `FailoverClusterManager` Wrappers

Two new `mo/` wrapper classes for the vSphere High Availability (VCHA) API that have been present in the WSDL since vSphere 6.5 but were previously unwrapped:

- **`FailoverClusterConfigurator`**: `configureVcha_Task`, `createPassiveNode_Task`, `createWitnessNode_Task`, `deployVcha_Task`, `destroyVcha_Task`, `getVchaConfig`, `prepareVcha_Task`
- **`FailoverClusterManager`**: `getClusterMode`, `getVchaClusterHealth`, `initiateFailover_Task`, `setClusterMode_Task`

Accessible via `ServiceInstance.getFailoverClusterConfigurator()` and `ServiceInstance.getFailoverClusterManager()`.

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

### `InventoryNavigator` — OOM on Large Inventories

`searchManagedEntities` previously called the deprecated `retrieveProperties` which fetches the entire inventory in one unbounded response. On large vCenter environments this caused `OutOfMemoryError`. The implementation now uses `retrievePropertiesEx` + `continueRetrievePropertiesEx` to page through results in bounded chunks.

**What to check:**

- No API change. The method returns the same results. Memory usage on large inventories is now proportional to the page size rather than the full inventory.

---

### `WSClient` — `HostnameVerifier` Not Applied Per-Connection When `ignoreCert=true`

Connecting to vSphere by IP address with `ignoreCert=true` failed with "No subject alternative names matching IP address" because the `NoopHostnameVerifier` was applied globally via `HttpsURLConnection.setDefaultHostnameVerifier` — a JVM-wide, timing-fragile call. Connections that captured the JDK default before the override took effect ignored it and rejected the IP. Now applied per-connection via `applyHttpsConfig`, affecting only connections from this client.

**What to check:**

- No API change. If you were connecting to vSphere by IP with `ignoreCert=true` and saw hostname verification failures, this resolves them.

---

### `ManagedObjectWatcher` — Crash on Null `UpdateSet` / Deprecated `waitForUpdates`

`CacheInstance.get()` returned null because the watcher thread crashed on its first iteration: `pc.waitForUpdates(version)` is deprecated as of SDK 4.1 and vCenter 6+ deserializes its response to a null `UpdateSet`, causing an NPE that spun the loop forever without populating the cache. Switched to `pc.waitForUpdatesEx(version, options)` and null `UpdateSet` responses are now skipped cleanly.

**What to check:**

- No API change. If you used `CacheInstance` and observed persistent null returns, this resolves it.

---

### `ServiceInstance` — Session-String Constructor Fails Fast on Invalid Session

The session-string constructor previously silently stored a null `UserSession` when `getCurrentUserSession()` returned null (invalid or expired cookie), causing an NPE at the use-site far from the root cause. The constructor now throws `RemoteException` with a descriptive message at construction time.

**What to check:**

- Code that previously caught an NPE from a method call (after constructing `ServiceInstance` with an invalid session) will now see `RemoteException` from the constructor. Update error handling accordingly.

---

### `XmlGenDom` — NPE on Unknown `xsi:type`s and `ArrayOf*` Wrappers

Two gaps in the XML deserializer:
1. An `ArrayOf*` `xsi:type` on an `Object` field (e.g. `DynamicProperty.val` with `xsi:type="ArrayOfPerfCounterInfo"`) fell into the basic-type branch and threw NPE. Now detected upfront and deserialized as a typed array.
2. An array element with an `xsi:type` that `TypeUtil` cannot resolve (unknown vSphere types introduced in newer API versions) threw `ClassNotFoundException`, aborting the entire parse. Now logs a warning and skips the unknown element.

**What to check:**

- No API change. Responses containing types not in the current Java model are now skipped gracefully instead of crashing the call.

---

### `missingSet` Fault Parsing — Real Error Swallowed by `NoSuchFieldException`

Unknown XML elements in `MethodFault` subtypes (fields returned by newer vSphere API versions not yet in the Java model) caused `NoSuchFieldException` to propagate through `fromXml`, aborting `ObjectContent` parsing and swallowing the server-side fault entirely. The parser now logs unrecognised elements at DEBUG and continues, so `LocalizedMethodFault` is fully populated and `getCurrentProperty` surfaces the localized error message instead of an unhelpful class name.

**What to check:**

- No API change. Calls that were silently returning null or throwing cryptic exceptions due to missing fields now correctly surface the localized server error message.

---

### Backward-Compatible Method Aliases Restored

The 9.0 WSDL regeneration renamed several public methods (dropping common prefixes/suffixes). Building the `yavijava-samples` project against the 9.0-SNAPSHOT revealed the breaks. The original method names are restored as thin delegating aliases alongside the new names; both compile and behave identically.

Affected classes and method pairs (old → new, both available):
- `AuthorizationManager.updateAuthorizationRole` → `updateRole`
- `ComputeResource.getNetworks` → `getNetwork`
- `Datastore.getVms` → `getVm`
- `DiagnosticManager.generateLogBundles_Task` → `generateLogBundles`
- `DistributedVirtualSwitch.addDVPortgroup_Task(spec[])` → `addDVPortgroups_Task`
- `DistributedVirtualSwitchManager.dVSManagerLookupDvPortGroup` and other `dVSManager*` prefix drops

**What to check:**

- Code using the old names continues to compile. Code using the new shorter names also compiles. No behaviour change.

---

### `double[]` Missing from `ReflectUtil.setObjectArrayField`

`ReflectUtil.setObjectArrayField` was missing a dispatch case for `double[]`, causing a `RuntimeException` when deserializing objects with `double[]` fields (e.g. `StoragePerformanceSummary`). The existing `toDoubleArray()` helper was wired in.

**What to check:**

- No API change. Calls to APIs that return objects with `double[]` fields (e.g. storage performance queries) no longer throw a `RuntimeException` during deserialization.

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
