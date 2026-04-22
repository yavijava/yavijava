[![CI](https://github.com/yavijava/yavijava/actions/workflows/ci.yml/badge.svg?branch=gradle)](https://github.com/yavijava/yavijava/actions/workflows/ci.yml)

Welcome to the YAVI Java API

## WHAT IS YAVI JAVA API?
It is a fork of the VI Java API which is a set of Java libraries that aim to ease the usage of VI 
SDK Web Services interfaces. It's open-sourced under a mixed BSD license and Apache-2.0 license.

It provides the following benefits to Java developers:
* Enables OO programming with a well defined managed object model
* Reduces the need to use ManagedObjectReference and enables compile time type checking
* Hides the complexity of the PropertyCollector
* Provides utility classes to simplify VI SDK web interfaces
* High performance — 4+ times faster than AXIS engine
* Supports pluggable HTTP clients
* Logging via SLF4J (bring your own implementation — Logback, Log4j 2, etc.)
* Gradle-based build system
* vSphere 6.5 API support (data objects, CryptoManager, SOAP action 6.5)

As a result, application code using this API is much shorter (70% less) and much more readable 
than the equivalent using web service interfaces directly.

## WHO CREATED THE API?
To find out more about the original VI Java API see http://vijava.sf.net

This fork (YAVI Java) was created by [Michael Rice](https://github.com/michaelrice).

## Whats with the name?

YAVI means simply Yet Another VI Java. I forked this project and moved it to GitHub because 
the project seemed stale and needed new life — GitHub, custom HTTP clients, logging, tests, 
and more.

## Do I have to change my code to use this?

No. This is a drop-in replacement requiring no code changes, but check UPDATES.md for 
dependency-level breaking changes when upgrading versions.

Current dependencies (always check `build.gradle` for the latest):

```groovy
dependencies {
    implementation 'org.dom4j:dom4j:2.1.4'
    implementation 'org.slf4j:slf4j-api:2.0.17'
    implementation 'org.apache.httpcomponents.client5:httpclient5:5.4.1'
}
```

> **Note:** SLF4J requires a logging implementation at runtime. Add one to your project,
> for example `ch.qos.logback:logback-classic` or `org.slf4j:slf4j-simple`.

> **Note:** HttpClient 5 (`httpclient5`) is a breaking upgrade from HttpClient 4. If your
> application also uses HttpClient directly, see UPDATES.md for migration guidance.

## Java Requirements

| Action | Minimum JDK |
|--------|------------|
| Use the compiled jar | Java 11 |
| Build from source | Java 21 |

## WHERE CAN I GET HELP?
File a bug: https://github.com/yavijava/yavijava/issues

## COPYRIGHT & LICENSE
BSD. See the License.txt file for details.

## What happened to the samples?

They were removed from the core project and are maintained separately:
https://github.com/yavijava/yavijava-samples

## Testing

Testing is split into two packages. Pull requests that fix bugs or add functionality 
must include tests.

### Unit

Unit tests live in `src/test`. Tests can be written in Java or Groovy (JUnit or Spock).
They run automatically in CI on every pull request.

```bash
./gradlew test
```

### Integration

Integration tests live in `src/intTest` and require a live vCenter or HostSystem.
Edit the properties file in that directory with your environment's URL, username, and password.

```bash
./gradlew intTest
```
