# REGEN-NOTES

Hand-applied fixes that live in generated files. **After every WSDL regen, reapply each item below or the regression returns.**

Search the codebase for the marker `REGEN-PRESERVE` to find the call sites:

```
grep -rn "REGEN-PRESERVE" src/main/java/
```

## Active fixes

### `VimStub.fetchDVPortKeys` — coerce `List` to `String[]`

- **Origin:** commit `6eb81f6a` (`Fix Task sleep bug, fetchDVPortKeys ClassCast, and XXE vulnerability`), referenced in `WSClient.java:101` and the original issue-28.
- **What the regen produces:** a plain `(String[]) getWsc().invoke(...)` cast.
- **What it must be:** check whether `invoke` returned a `java.util.List`, and if so call `list.toArray(new String[0])` before returning. Otherwise the production SOAP path can throw `ClassCastException` for some servers.
- **Test that catches a missing reapply:** `src/test/java/com/vmware/vim25/ws/VimStubFetchDVPortKeysTest.java`.

### `VimStub.setAlarmStatus` — undocumented SOAP operation

- **Origin:** discovered via the Onyx and doublecloud proxies. The `SetAlarmStatus` SOAP operation is not part of the published vCenter WSDL, so the regen does not emit a stub for it. The operation does work against real vCenter and is the only way to programmatically reset an alarm's `ManagedEntityStatus` from red back to green — `AcknowledgeAlarm` does not change the status.
- **What the regen produces:** nothing (the method is silently dropped).
- **What it must be:** a hand-added `setAlarmStatus(MOR _this, MOR alarm, MOR entity, String status)` method that invokes the `SetAlarmStatus` SOAP action with four arguments (`_this`, `alarm`, `entity`, `status`). The corresponding wrapper `AlarmManager.setAlarmStatus(Alarm, ManagedEntity, String)` calls it.
- **How to recognize a missing reapply:** `AlarmManager.java` will fail to compile with `cannot find symbol method setAlarmStatus(...)` against `VimStub`.

## Procedure when regenerating `VimStub.java`

1. Run the regen.
2. `grep -rn "REGEN-PRESERVE" src/main/java/` will return nothing — the regen wiped the markers.
3. For each entry above, reapply the diff (the file's git history shows the prior version).
4. Run `./gradlew test` and confirm `VimStubFetchDVPortKeysTest` passes.
5. Add the marker comment back at every reapplied site so the next regen catches it.

## Long-term fix

Push the coercion into `WSClient.unMarshall` (or the deserializer it delegates to) so the defense lives in non-generated code and survives regen. Out of scope for the vSphere 9.0 parity branch.
