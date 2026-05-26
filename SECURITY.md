# Security Policy

## Reporting a vulnerability

Email [help@yavijava.com](mailto:help@yavijava.com) with the details. Please **do not** open a public GitHub issue for a suspected security problem — that puts users at risk before a fix is available.

A useful report includes:

- The affected yavijava version (and ideally the affected vSphere/vCenter version, if relevant).
- A clear description of the vulnerability and its impact.
- Steps to reproduce, or a minimal proof-of-concept.
- Any suggested mitigation or fix you have in mind.

If you'd prefer to coordinate disclosure with us, say so in the initial message and we'll work with you on a timeline.

## What to expect

- **Acknowledgment**: we'll confirm receipt within a few business days. The reply will come from the same address.
- **Triage**: we'll let you know whether the report is something we can fix in yavijava, something that belongs upstream (e.g. in a transitive dependency), or out of scope.
- **Fix and disclosure**: once a fix is ready, we'll cut a release and credit you in the release notes if you'd like. We don't commit to a fixed timeline — yavijava is maintained on a best-effort basis — but we won't sit on a confirmed report.

## Supported versions

Security fixes are made on a best-effort basis across actively-used major versions. The current major (see `build.gradle`) gets first attention. Older majors may receive a fix if the change is straightforward to backport and there's a credible user base still on that line.

If you're running a version older than the current major and can upgrade, that's the most reliable path to a fixed build.
