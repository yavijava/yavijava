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
