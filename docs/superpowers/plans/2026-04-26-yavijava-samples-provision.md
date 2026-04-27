# yavijava-samples Build Modernization + ProvisionFromScratch Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Bump yavijava to version `9.0-SNAPSHOT`, publish it to mavenLocal, clone and modernize the `yavijava-samples` build, and add a `ProvisionFromScratch` sample that connects to vCenter, creates a datacenter, adds an ESXi host, and provisions a PXE-booting VM for DRP discovery.

**Architecture:** Two repos. Phase 1 is entirely in `~/programs/personal/yavijava` (version bump + publish). Phase 2 is entirely in `~/programs/personal/yavijava-samples` (clone, build modernization, new sample). The samples project resolves yavijava from `~/.m2` via `mavenLocal()` — Phase 1 must complete before Phase 2 can compile.

**Tech Stack:** Java 21, Gradle 8.13, yavijava vSphere SDK (com.toastcoders:yavijava:9.0-SNAPSHOT), vCenter SOAP API via yavijava `mo/*` wrappers.

---

## File Structure

```
~/programs/personal/yavijava/
  build.gradle                          MODIFY: version string only

~/programs/personal/yavijava-samples/   (cloned fresh)
  settings.gradle                       CREATE
  build.gradle                          REPLACE entirely
  gradle/wrapper/gradle-wrapper.properties  UPDATE: Gradle 8.13
  src/main/java/com/vmware/vim25/mo/samples/vm/
    ProvisionFromScratch.java           CREATE
```

---

## Task 1: Bump yavijava version to `9.0-SNAPSHOT`

**Working directory:** `~/programs/personal/yavijava`
**Branch:** `feature/vsphere-9-parity`

**Files:**
- Modify: `build.gradle:12`

- [ ] **Step 1: Edit the version line**

Open `build.gradle`. Line 12 currently reads:
```groovy
version = '6.5.01-SNAPSHOT'
```
Change it to:
```groovy
version = '9.0-SNAPSHOT'
```

- [ ] **Step 2: Verify the build still compiles**

```bash
cd ~/programs/personal/yavijava
./gradlew compileJava
```
Expected: `BUILD SUCCESSFUL`

- [ ] **Step 3: Commit**

```bash
git add build.gradle
git commit -m "chore: bump version to 9.0-SNAPSHOT for vSphere 9.0 parity release"
```

---

## Task 2: Publish yavijava to mavenLocal

**Working directory:** `~/programs/personal/yavijava`

- [ ] **Step 1: Run publishToMavenLocal**

```bash
./gradlew publishToMavenLocal
```
Expected: `BUILD SUCCESSFUL`

- [ ] **Step 2: Verify the artifact landed in ~/.m2**

```bash
ls ~/.m2/repository/com/toastcoders/yavijava/9.0-SNAPSHOT/
```
Expected: files including `yavijava-9.0-SNAPSHOT.jar` and `yavijava-9.0-SNAPSHOT.pom`.

---

## Task 3: Clone yavijava-samples

- [ ] **Step 1: Clone to the personal projects directory**

```bash
git clone git@github.com:yavijava/yavijava-samples.git ~/programs/personal/yavijava-samples
```
Expected: `Cloning into '...yavijava-samples'...` then done.

- [ ] **Step 2: Confirm structure**

```bash
ls ~/programs/personal/yavijava-samples/
```
Expected: `build.gradle  docs  License.txt  README.txt  rel-note.txt  src`

---

## Task 4: Replace `build.gradle` and add `settings.gradle`

**Working directory:** `~/programs/personal/yavijava-samples`

**Files:**
- Replace: `build.gradle`
- Create: `settings.gradle`

- [ ] **Step 1: Overwrite `build.gradle`**

Replace the entire contents of `build.gradle` with:

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

- [ ] **Step 2: Create `settings.gradle`**

Create `settings.gradle` with contents:

```groovy
rootProject.name = 'yavijava-samples'
```

---

## Task 5: Update the Gradle wrapper to 8.13

**Working directory:** `~/programs/personal/yavijava-samples`

**Files:**
- Modify: `gradle/wrapper/gradle-wrapper.properties`

The repo has no wrapper yet. Bootstrap it, then pin to 8.13.

- [ ] **Step 1: Check whether a wrapper already exists**

```bash
ls ~/programs/personal/yavijava-samples/gradle/wrapper/ 2>/dev/null || echo "NO WRAPPER"
```

- [ ] **Step 2a: If NO wrapper — copy from yavijava**

```bash
mkdir -p ~/programs/personal/yavijava-samples/gradle/wrapper
cp ~/programs/personal/yavijava/gradle/wrapper/gradle-wrapper.jar \
   ~/programs/personal/yavijava-samples/gradle/wrapper/
cp ~/programs/personal/yavijava/gradlew \
   ~/programs/personal/yavijava-samples/
cp ~/programs/personal/yavijava/gradlew.bat \
   ~/programs/personal/yavijava-samples/
chmod +x ~/programs/personal/yavijava-samples/gradlew
```

Then create `gradle/wrapper/gradle-wrapper.properties`:

```properties
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-8.13-bin.zip
```

- [ ] **Step 2b: If wrapper already exists — just update the distributionUrl line**

Edit `gradle/wrapper/gradle-wrapper.properties` so `distributionUrl` reads:
```
distributionUrl=https\://services.gradle.org/distributions/gradle-8.13-bin.zip
```

- [ ] **Step 3: Verify Gradle resolves**

```bash
cd ~/programs/personal/yavijava-samples
./gradlew --version
```
Expected: output includes `Gradle 8.13`.

---

## Task 6: Verify all existing samples compile

**Working directory:** `~/programs/personal/yavijava-samples`

- [ ] **Step 1: Run compileJava**

```bash
./gradlew compileJava 2>&1 | tail -20
```
Expected: `BUILD SUCCESSFUL`. If you see errors they will be unrelated to our changes (pre-existing source issues in the old samples). Fix any that are directly caused by the dependency update — the most likely culprits are import changes between dom4j 2.0 and 2.1.

- [ ] **Step 2: Commit the build modernization**

```bash
cd ~/programs/personal/yavijava-samples
git add build.gradle settings.gradle gradlew gradlew.bat gradle/
git commit -m "chore: modernize build to Gradle 8.13 / Java 21, pull yavijava 9.0-SNAPSHOT from mavenLocal"
```

---

## Task 7: Write `ProvisionFromScratch.java`

**Working directory:** `~/programs/personal/yavijava-samples`

**Files:**
- Create: `src/main/java/com/vmware/vim25/mo/samples/vm/ProvisionFromScratch.java`

- [ ] **Step 1: Create the file**

```java
package com.vmware.vim25.mo.samples.vm;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;

import java.net.URL;
import java.rmi.RemoteException;

/**
 * End-to-end provisioning sample for DRP (Digital Rebar Provisioner) discovery.
 *
 * Creates a datacenter, adds a standalone ESXi host, then provisions a
 * PXE-booting VM so DRP can discover and provision it on first power-on.
 *
 * Usage:
 *   java ProvisionFromScratch <vcenter-url> <vc-username> <vc-password>
 *                             <dc-name> <host-username> <host-password>
 *
 * Lab constants (edit these for your environment):
 */
public class ProvisionFromScratch {

    // -------------------------------------------------------------------------
    // Lab constants — customize for your environment
    // -------------------------------------------------------------------------
    static final String HOST_IP      = "192.168.1.213";
    static final String DATASTORE    = "bigdog";
    static final String NETWORK      = "VM Network";
    static final String VM_NAME      = "drp-discovery-vm";
    static final String GUEST_OS_ID  = "ubuntu64Guest";
    static final long   MEMORY_MB    = 4096L;
    static final int    CPU_COUNT    = 1;
    static final long   DISK_SIZE_KB = 20L * 1024 * 1024; // 20 GB
    // NIC device key — must match the key set on the NIC device below so that
    // VirtualMachineBootOptions can reference it for PXE boot ordering.
    static final int    NIC_KEY      = 4000;
    // -------------------------------------------------------------------------

    public static void main(String[] args) throws Exception {
        if (args.length != 6) {
            System.out.println("Usage: java ProvisionFromScratch <vcenter-url> <vc-username> <vc-password>" +
                               " <dc-name> <host-username> <host-password>");
            System.exit(1);
        }

        String vcUrl      = args[0];
        String vcUser     = args[1];
        String vcPass     = args[2];
        String dcName     = args[3];
        String hostUser   = args[4];
        String hostPass   = args[5];

        // Step 1: Connect
        System.out.println("Connecting to vCenter: " + vcUrl);
        ServiceInstance si = new ServiceInstance(new URL(vcUrl), vcUser, vcPass, true);
        System.out.println("Connected. API version: " + si.getAboutInfo().getApiVersion());

        // Step 2: Create datacenter
        System.out.println("Creating datacenter: " + dcName);
        Folder rootFolder = si.getRootFolder();
        Datacenter dc = rootFolder.createDatacenter(dcName);
        System.out.println("Datacenter created: " + dc.getName());

        // Step 3: Add standalone host
        System.out.println("Adding host: " + HOST_IP);
        HostConnectSpec hostSpec = new HostConnectSpec();
        hostSpec.setHostName(HOST_IP);
        hostSpec.setUserName(hostUser);
        hostSpec.setPassword(hostPass);
        hostSpec.setForce(true);

        Task addHostTask = dc.getHostFolder()
                .addStandaloneHost_Task(hostSpec, null, true);
        waitForTask(addHostTask, "Add host " + HOST_IP);

        // Step 4: Find the host and its resource pool
        System.out.println("Locating host and resource pool in inventory...");
        InventoryNavigator inv = new InventoryNavigator(dc);
        HostSystem host = (HostSystem) inv.searchManagedEntity("HostSystem", HOST_IP);
        if (host == null) {
            System.err.println("ERROR: Could not find HostSystem '" + HOST_IP + "' after adding it.");
            System.exit(1);
        }
        ResourcePool rp = (ResourcePool) inv.searchManagedEntities("ResourcePool")[0];
        System.out.println("Using resource pool: " + rp.getName());

        // Step 5: Build VM config spec
        System.out.println("Building VM config spec for: " + VM_NAME);
        VirtualMachineConfigSpec vmSpec = buildVmSpec();

        // Step 6: Create VM
        System.out.println("Creating VM in datacenter VM folder...");
        Folder vmFolder = dc.getVmFolder();
        Task createTask = vmFolder.createVM_Task(vmSpec, rp, host);
        waitForTask(createTask, "Create VM " + VM_NAME);

        System.out.println("Done. VM '" + VM_NAME + "' created successfully.");
        System.out.println("Power it on to trigger PXE boot and DRP discovery.");

        si.getServerConnection().logout();
    }

    // -------------------------------------------------------------------------
    // VM spec construction
    // -------------------------------------------------------------------------

    private static VirtualMachineConfigSpec buildVmSpec() {
        VirtualMachineConfigSpec vmSpec = new VirtualMachineConfigSpec();
        vmSpec.setName(VM_NAME);
        vmSpec.setGuestId(GUEST_OS_ID);
        vmSpec.setMemoryMB(MEMORY_MB);
        vmSpec.setNumCPUs(CPU_COUNT);

        // vmx file location
        VirtualMachineFileInfo fileInfo = new VirtualMachineFileInfo();
        fileInfo.setVmPathName("[" + DATASTORE + "]");
        vmSpec.setFiles(fileInfo);

        vmSpec.setDeviceChange(new VirtualDeviceConfigSpec[]{
            buildScsiController(),
            buildDisk(),
            buildNic()
        });

        // PXE boot: boot from NIC first so DRP can discover the VM on power-on
        VirtualMachineBootOptions bootOptions = new VirtualMachineBootOptions();
        VirtualMachineBootOptionsBootableEthernetDevice netBoot =
            new VirtualMachineBootOptionsBootableEthernetDevice();
        netBoot.setDeviceKey(NIC_KEY);
        bootOptions.setBootOrder(new VirtualMachineBootOptionsBootableDevice[]{netBoot});
        vmSpec.setBootOptions(bootOptions);

        return vmSpec;
    }

    private static VirtualDeviceConfigSpec buildScsiController() {
        VirtualLsiLogicController scsi = new VirtualLsiLogicController();
        scsi.setKey(1000);
        scsi.setBusNumber(0);
        scsi.setSharedBus(VirtualSCSISharing.noSharing);

        VirtualDeviceConfigSpec spec = new VirtualDeviceConfigSpec();
        spec.setOperation(VirtualDeviceConfigSpecOperation.add);
        spec.setDevice(scsi);
        return spec;
    }

    private static VirtualDeviceConfigSpec buildDisk() {
        VirtualDiskFlatVer2BackingInfo backing = new VirtualDiskFlatVer2BackingInfo();
        backing.setFileName("[" + DATASTORE + "]");
        backing.setDiskMode("persistent");
        backing.setThinProvisioned(true);

        VirtualDisk disk = new VirtualDisk();
        disk.setKey(2000);
        disk.setControllerKey(1000);
        disk.setUnitNumber(0);
        disk.setCapacityInKB(DISK_SIZE_KB);
        disk.setBacking(backing);

        VirtualDeviceConfigSpec spec = new VirtualDeviceConfigSpec();
        spec.setOperation(VirtualDeviceConfigSpecOperation.add);
        spec.setFileOperation(VirtualDeviceConfigSpecFileOperation.create);
        spec.setDevice(disk);
        return spec;
    }

    private static VirtualDeviceConfigSpec buildNic() {
        VirtualEthernetCardNetworkBackingInfo backing =
            new VirtualEthernetCardNetworkBackingInfo();
        backing.setDeviceName(NETWORK);

        // vmxnet3 is required for PXE; PCNet32 does not support PXE boot
        VirtualVmxnet3 nic = new VirtualVmxnet3();
        nic.setKey(NIC_KEY);
        nic.setAddressType("generated");
        nic.setBacking(backing);

        Description info = new Description();
        info.setLabel("Network Adapter 1");
        info.setSummary(NETWORK);
        nic.setDeviceInfo(info);

        VirtualDeviceConfigSpec spec = new VirtualDeviceConfigSpec();
        spec.setOperation(VirtualDeviceConfigSpecOperation.add);
        spec.setDevice(nic);
        return spec;
    }

    // -------------------------------------------------------------------------
    // Task helper
    // -------------------------------------------------------------------------

    private static void waitForTask(Task task, String description)
            throws RemoteException, InterruptedException {
        System.out.println("  Waiting for task: " + description + "...");
        String result = task.waitForMe();
        if (!Task.SUCCESS.equals(result)) {
            System.err.println("ERROR: Task failed: " + description);
            System.err.println("  Result: " + result);
            System.exit(1);
        }
        System.out.println("  Task succeeded: " + description);
    }
}
```

- [ ] **Step 2: Verify it compiles**

```bash
cd ~/programs/personal/yavijava-samples
./gradlew compileJava 2>&1 | tail -10
```
Expected: `BUILD SUCCESSFUL` with no errors referencing `ProvisionFromScratch.java`.

- [ ] **Step 3: Commit**

```bash
git add src/main/java/com/vmware/vim25/mo/samples/vm/ProvisionFromScratch.java
git commit -m "feat: add ProvisionFromScratch sample for DRP discovery workflow

Connects to vCenter, creates a datacenter, adds standalone ESXi host
192.168.1.213, and provisions a PXE-booting VM (ubuntu64Guest, 4 GB RAM,
1 CPU, 20 GB thin disk on bigdog datastore, vmxnet3 NIC on VM Network).
Boot order is set to network-first via VirtualMachineBootOptionsBootableEthernetDevice
so DRP can discover the VM on first power-on."
```

---

## Task 8: Push the samples repo

- [ ] **Step 1: Push to origin**

```bash
cd ~/programs/personal/yavijava-samples
git push
```
Expected: branch pushed to `git@github.com:yavijava/yavijava-samples.git`.

---

## Running the sample

After all tasks are complete, run with:

```bash
cd ~/programs/personal/yavijava-samples
./gradlew compileJava

# Then run (substitute your vCenter details):
java -cp build/classes/java/main:\
$(find ~/.m2/repository/com/toastcoders/yavijava/9.0-SNAPSHOT -name "*.jar"):\ 
$(find ~/.m2/repository -name "httpclient5-*.jar" | head -1):\
$(find ~/.m2/repository -name "dom4j-2*.jar" | head -1):\
$(find ~/.m2/repository -name "slf4j-api-*.jar" | head -1):\
$(find ~/.m2/repository -name "httpcore5-*.jar" | head -1) \
com.vmware.vim25.mo.samples.vm.ProvisionFromScratch \
https://vcenter.local/sdk administrator@vsphere.local password MyDatacenter root esxipassword
```

Or build a fat jar first (add `id 'application'` plugin with `mainClass` set, then `./gradlew jar`) — out of scope for this task but a natural follow-on.

---

## Acceptance criteria

- `./gradlew compileJava` passes in `yavijava-samples` with no errors
- `~/.m2/repository/com/toastcoders/yavijava/9.0-SNAPSHOT/yavijava-9.0-SNAPSHOT.jar` exists
- `ProvisionFromScratch.java` compiles cleanly
- Both repos have clean `git status` after all commits
