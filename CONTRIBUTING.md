# Contributing to yavijava

Thanks for considering a contribution. This guide covers what you need to know to land a clean pull request.

For project background, see the [README](README.md). For the rules of engagement, see the [Code of Conduct](CODE_OF_CONDUCT.md). For security issues, see [SECURITY.md](SECURITY.md) — please don't open public issues for vulnerabilities.

---

## Getting started

### Prerequisites

- **JDK 21** (Temurin or any other distribution). The project is compiled and tested against JDK 21; the CI matrix is single-version.
- The Gradle wrapper handles Gradle itself — you don't need a system Gradle install.
- A POSIX shell for the `./gradlew` commands. Windows users: WSL or Git Bash work; native PowerShell with `gradlew.bat` is untested but should function.

### Clone and build

```bash
git clone git@github.com:yavijava/yavijava.git
cd yavijava
./gradlew check
```

`check` compiles, runs all unit tests, and runs SpotBugs. It should complete in well under a minute on modern hardware. If it doesn't pass on a clean checkout, that's a bug — please open an issue.

---

## Branch workflow

**The default branch is `gradle`**, not `main` or `master`. All work goes through pull requests targeting `gradle`.

Don't commit directly to `gradle`. Create a feature branch:

```bash
git checkout -b fix/short-topic-name gradle
```

Branch naming follows the same prefix convention as commit messages — `fix/...`, `feat/...`, `chore/...`, `docs/...`, `test/...`. Issue numbers in the name are optional but help; e.g. `fix/352-vtpm-bytearray-deserialization`.

---

## Commit conventions

yavijava uses [Conventional Commits 1.0](https://www.conventionalcommits.org/en/v1.0.0/) for commit messages and PR titles. The format is:

```
<type>(<scope>): <short imperative description>

<optional longer body>

<optional footers>
```

Types in active use:

| Type | When |
|---|---|
| `fix` | Bug fix |
| `feat` | New user-visible capability |
| `chore` | Build, CI, deps, housekeeping |
| `docs` | Documentation only |
| `test` | Tests only (no production change) |
| `refactor` | Code restructure without behavior change |
| `perf` | Performance improvement |

Scopes mirror package boundaries — most common are `ws`, `mo`, `mox`, `cf`, `util`, `gen`, `build`, `ci`, `deps`, `security`. Use the most specific scope that fits.

Examples from recent history:

```
fix(ws): handle byte[][] fields in XmlGenDom deserializer (#352)
chore(ci): bump Node 20 actions and auto-create GitHub Releases
test(ws): add failing test for VirtualTPM byte[][] deserialization (#352)
```

If your change closes an issue, include `Fixes #N` in the PR description (not the commit message) so GitHub auto-closes the issue on merge.

---

## Code organization

The source tree is split into two worlds. Knowing which one you're touching prevents most reviewer churn.

### Generated code — do not hand-edit

`src/main/java/com/vmware/vim25/` (the flat package, ~4 000 files) contains data-transfer objects, enums, and fault types produced by the `yavijava_generator` from the vSphere WSDL. `ws/VimStub.java` is also generated.

**These files are overwritten on every WSDL regen.** Edits are silently lost. SpotBugs is fully suppressed for this package.

If you need to change something in the generated layer, the right path is to update the generator and regenerate — see [REGEN-NOTES.md](REGEN-NOTES.md) for the procedure and the two hand-applied fixes that must be reapplied each regen.

### Hand-written code — everything else

| Package | Purpose |
|---|---|
| `com.vmware.vim25.ws` | SOAP serialization, HTTP transport, stub dispatch, pluggable `Client` interface |
| `com.vmware.vim25.mo` | Managed object wrappers — typed Java facades over vSphere managed objects |
| `com.vmware.vim25.mox` | Extended utilities on top of `mo/` |
| `com.vmware.vim25.util` | Misc utilities |
| `com.vmware.vim.cf` | Caching framework |
| `org.doublecloud.ws.util` | Reflection and type mapping for the XML deserializer |

This is where your change probably belongs.

---

## Tests

### Unit tests

`./gradlew test` runs the unit suite. Tests mix JUnit 4, JUnit 5 (via `junit-vintage-engine`), and Spock (Groovy). All run via `useJUnitPlatform()`.

Most deserializer tests in `src/test/java/com/vmware/vim25/ws/` use real XML fixtures (under `src/test/resources/xml/` or `src/test/java/com/vmware/vim25/ws/xml/`) to exercise the code without a live vCenter. Follow that pattern — fixtures are easier to reason about than mocks.

To run a single test class:

```bash
./gradlew test --tests "com.vmware.vim25.ws.XmlGenDomTest"
```

### Integration tests

`./gradlew intTest` runs the integration suite under `src/intTest/`. These tests need a vSphere endpoint. Two paths:

- **Real vCenter**: edit `src/intTest/java/VcenterInfo.properties` with your endpoint credentials.
- **vcsim** (recommended for local dev): vcsim is a vSphere API mock from [vmware/govmomi](https://github.com/vmware/govmomi). The yavijava development environment ships a pre-built `vcsim` binary at `../esx/vcsim`; start it on `https://user:pass@127.0.0.1:8989/sdk` and point `VcenterInfo.properties` at that URL.

### Release-notes tests

`ReleaseNotesTest` runs as part of `./gradlew check` and asserts that `UPDATES.md` and `rel-note.txt` document specific items. When you ship a notable user-visible change, update both files and (if appropriate) add a new assertion to `ReleaseNotesTest` so the documentation stays in sync.

### SpotBugs and OWASP

SpotBugs runs as part of `check`. Exclusions live in `config/spotbugs/exclude.xml` and are documented inline with the reason. If SpotBugs flags real code (i.e. outside the generated package), fix the issue rather than suppressing it.

OWASP Dependency-Check runs weekly in CI and on demand via `./gradlew dependencyCheckAnalyze`. It downloads a ~200 MB NVD database the first time. Suppressions live in `config/owasp/suppressions.xml`.

---

## Submitting a pull request

1. Push your branch and open a PR against `gradle`. The PR template will prompt you for a summary, change list, and test plan.
2. CI (`.github/workflows/ci.yml`) runs `./gradlew check` automatically on every push to the PR. Wait for it to pass.
3. If you touched generated code, confirm `REGEN-NOTES.md` still reflects reality.
4. If your change is user-visible, update `UPDATES.md` and `rel-note.txt`. If you can add a `ReleaseNotesTest` assertion that pins the documentation, even better.
5. A maintainer will review. Be ready for review comments — most go through a round or two.

What reviewers look for:

- The change does what the PR description says, and nothing else (no surprise scope).
- Tests that would have caught the bug exist and demonstrably fail without the fix.
- Hand-written code paths are exercised by unit tests; integration tests are for end-to-end coverage.
- Commit messages and PR title follow Conventional Commits.

---

## Releases

Releases are cut by maintainers, not contributors. The short version: bump `version` in `build.gradle`, update `UPDATES.md` and `rel-note.txt` with a new section, merge, tag `vX.Y.Z`, and push the tag. `.github/workflows/publish.yml` handles signing, publishing to Maven Central, and creating the GitHub Release.

If you're submitting a fix you'd like in a specific release, mention that in the PR description and we'll triage accordingly.
