package com.vmware.vim25;

/**
 * Created by Michael Rice on Wed May 20 23:39:35 CDT 2015
 *
 * Copyright 2015 Michael Rice
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @since 6.0
 */

public class HbrDiskMigrationAction extends ClusterAction {
    public String collectionId;

    public String collectionName;

    public String[] diskIds;

    public ManagedObjectReference source;

    public ManagedObjectReference destination;

    public long sizeTransferred;

    public float spaceUtilSrcBefore;

    public float spaceUtilDstBefore;

    public float spaceUtilSrcAfter;

    public float spaceUtilDstAfter;

    public float ioLatencySrcBefore;

    public float ioLatencyDstBefore;

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String[] getDiskIds() {
        return diskIds;
    }

    public void setDiskIds(String[] diskIds) {
        this.diskIds = diskIds;
    }

    public ManagedObjectReference getSource() {
        return source;
    }

    public void setSource(ManagedObjectReference source) {
        this.source = source;
    }

    public ManagedObjectReference getDestination() {
        return destination;
    }

    public void setDestination(ManagedObjectReference destination) {
        this.destination = destination;
    }

    public long getSizeTransferred() {
        return sizeTransferred;
    }

    public void setSizeTransferred(long sizeTransferred) {
        this.sizeTransferred = sizeTransferred;
    }

    public float getSpaceUtilSrcBefore() {
        return spaceUtilSrcBefore;
    }

    public void setSpaceUtilSrcBefore(float spaceUtilSrcBefore) {
        this.spaceUtilSrcBefore = spaceUtilSrcBefore;
    }

    public float getSpaceUtilDstBefore() {
        return spaceUtilDstBefore;
    }

    public void setSpaceUtilDstBefore(float spaceUtilDstBefore) {
        this.spaceUtilDstBefore = spaceUtilDstBefore;
    }

    public float getSpaceUtilSrcAfter() {
        return spaceUtilSrcAfter;
    }

    public void setSpaceUtilSrcAfter(float spaceUtilSrcAfter) {
        this.spaceUtilSrcAfter = spaceUtilSrcAfter;
    }

    public float getSpaceUtilDstAfter() {
        return spaceUtilDstAfter;
    }

    public void setSpaceUtilDstAfter(float spaceUtilDstAfter) {
        this.spaceUtilDstAfter = spaceUtilDstAfter;
    }

    public float getIoLatencySrcBefore() {
        return ioLatencySrcBefore;
    }

    public void setIoLatencySrcBefore(float ioLatencySrcBefore) {
        this.ioLatencySrcBefore = ioLatencySrcBefore;
    }

    public float getIoLatencyDstBefore() {
        return ioLatencyDstBefore;
    }

    public void setIoLatencyDstBefore(float ioLatencyDstBefore) {
        this.ioLatencyDstBefore = ioLatencyDstBefore;
    }

}
