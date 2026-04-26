# yavijava-samples: build modernization + ProvisionFromScratch sample

## Goal

Modernize the `yavijava-samples` repo build system, wire it to the vSphere 9.0 yavijava jar, and add a working end-to-end sample that provisions a datacenter, adds a bare-metal ESXi host, and creates a PXE-booting VM suitable for DRP (Digital Rebar Provisioner) discovery.

## Architecture

Two sequential phases:

1. **Version bump + publish** — update yavijava's own version string to `9.0-SNAPSHOT` and publish to mavenLocal so the samples project can resolve it.
2. **Samples repo setup** — clone to `~/programs/personal/yavijava-samples`, modernize the Gradle build, add `ProvisionFromScratch.java`.

---

## Phase 1 — yavijava version bump

**File:** `yavijava/build.gradle`

Change:
```
version = '6.5.01-SNAPSHOT'
```
to:
```
version = '9.0-SNAPSHOT'
```

Then run:
```
./gradlew publishToMavenLocal
```

This publishes `com.toastcoders:yavijava:9.0-SNAPSHOT` to `~/.m2/repository`.

---

## Phase 2 — yavijava-samples repo

### Setup

Clone `git@github.com:yavijava/yavijava-samples.git` into `~/programs/personal/yavijava-samples`.

### Build modernization

Replace the existing `build.gradle` entirely. Key changes:

| Before | After |
|---|---|
| `apply plugin: 'java'` (legacy) | `plugins { id 'java' }` (modern) |
| `version = '5.5.10'` | `version = '9.0-SNAPSHOT'` |
| `compile` configuration | `implementation` |
| `yavijava:6.0.04` from Maven Central | `yavijava:9.0-SNAPSHOT` from `mavenLocal()` |
| No Java version set | `sourceCompatibility = JavaVersion.VERSION_21` / `targetCompatibility = JavaVersion.VERSION_21` |
| No `settings.gradle` | Add `settings.gradle` with `rootProject.name = 'yavijava-samples'` |
| Gradle wrapper version unknown | Bump wrapper to Gradle 8.13 (matches yavijava) |

All existing sample source files must continue to compile. The only compile-breaking change from the yavijava 9.0 API is `VRPResourceManager` removal and `AlarmManager.setAlarmStatus` restoration — no existing samples reference either.

**New `build.gradle`:**
```groovy
plugins {
    id 'java'
    id 'idea'
    id 'eclipse'
}

group = 'com.toastcoders'
version = '9.0-SNAPSHOT'

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation 'com.toastcoders:yavijava:9.0-SNAPSHOT'
    implementation 'org.dom4j:dom4j:2.1.4'
    implementation 'javax.mail:mail:1.4.7'
    implementation 'javax.servlet:javax.servlet-api:3.1.0'
}
```

**New `settings.gradle`:**
```groovy
rootProject.name = 'yavijava-samples'
```

### New sample: `ProvisionFromScratch.java`

**Location:** `src/main/java/com/vmware/vim25/mo/samples/vm/ProvisionFromScratch.java`

**Purpose:** End-to-end provisioning demo — connect to vCenter, create a datacenter, add a standalone ESXi host, and create a PXE-booting VM for DRP discovery.

**CLI usage:**
```
java ProvisionFromScratch <vcenter-url> <vc-username> <vc-password> <dc-name> <host-username> <host-password>
```

**Lab constants (hardcoded, easy to change at top of class):**
```java
static final String HOST_IP       = "192.168.1.213";
static final String DATASTORE     = "bigdog";
static final String NETWORK       = "VM Network";
static final String VM_NAME       = "drp-discovery-vm";
static final String GUEST_OS_ID   = "ubuntu64Guest";
static final long   MEMORY_MB     = 4096L;
static final int    CPU_COUNT     = 1;
static final long   DISK_SIZE_KB  = 20 * 1024 * 1024L;  // 20 GB
```

**Execution steps:**

1. **Connect** — `new ServiceInstance(url, vcUser, vcPass, true)` (ignore SSL certs, suitable for lab)
2. **Create datacenter** — `si.getRootFolder().createDatacenter(dcName)` returns `Datacenter`
3. **Add host** — build `HostConnectSpec` with `HOST_IP`, `host-username`, `host-password`, `sslThumbprint = null` (force=true implied by ignoring certs); call `dc.getHostFolder().addStandaloneHost_Task(spec, null, true)`; call `task.waitForMe()`, assert `Task.SUCCESS`
4. **Find resource pool** — `new InventoryNavigator(dc).searchManagedEntities("ResourcePool")[0]`; also retrieve `HostSystem` via `searchManagedEntity("HostSystem", HOST_IP)` for the `createVM_Task` host arg
5. **Build VM config spec:**
   - `VirtualMachineConfigSpec`: name, guestId, memoryMB, numCPUs
   - `VirtualMachineFileInfo`: vmPathName `[bigdog]`
   - `VirtualDeviceConfigSpec` for `VirtualLsiLogicController` (key=1000, bus=0)
   - `VirtualDeviceConfigSpec` for `VirtualDisk`: 20 GB thin-provisioned, backing on `[bigdog]`, controller key=1000, unit=0
   - `VirtualDeviceConfigSpec` for `VirtualVmxnet3` NIC: backing = `VirtualEthernetCardNetworkBackingInfo(NETWORK)`, addressType="generated" — vmxnet3 is required for PXE; PCNet32 does not support PXE boot
   - `VirtualMachineBootOptions` with `bootOrder = [new VirtualMachineBootOptionsBootableEthernetDevice()]` so the VM network-boots on first power-on and DRP can discover it
6. **Create VM** — `dc.getVmFolder().createVM_Task(vmSpec, rp, host)`; `task.waitForMe()`, assert `Task.SUCCESS`
7. **Print confirmation** — VM name and MOR id

**Error handling:** every `waitForMe()` result is checked; on failure, print task error description and `System.exit(1)`.

---

## What is NOT in scope

- Powering the VM on (DRP discovers it on first boot; the sample only creates it)
- Cleaning up / teardown
- SSL thumbprint pinning (lab uses `ignoreCerts=true`)
- Updating any existing samples
- Any changes to test files

---

## Files changed

| Repo | File | Change |
|---|---|---|
| `yavijava` | `build.gradle` | version `6.5.01-SNAPSHOT` → `9.0-SNAPSHOT` |
| `yavijava-samples` | `build.gradle` | full replacement (modernize) |
| `yavijava-samples` | `settings.gradle` | new file |
| `yavijava-samples` | `gradle/wrapper/gradle-wrapper.properties` | bump to Gradle 8.13 |
| `yavijava-samples` | `src/main/java/com/vmware/vim25/mo/samples/vm/ProvisionFromScratch.java` | new file |
