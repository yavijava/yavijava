/*================================================================================
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, 
this list of conditions and the following disclaimer.

 * Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the following disclaimer in the documentation 
and/or other materials provided with the distribution.

 * Neither the name of VMware, Inc. nor the names of its contributors may be used
to endorse or promote products derived from this software without specific prior 
written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL VMWARE, INC. OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
================================================================================*/
package com.vmware.vim25.mo.samples.ovf;

/* **********************************************************
 * 
 * VMware Confidential
 * **********************************************************/

/**
 * Copyright 2009 VMware, Inc. All rights reserved.
 * 
 * #############################################################################
 * DISCLAIMER. THIS SCRIPT IS PROVIDED TO YOU "AS IS" WITHOUT WARRANTIES OR
 * CONDITIONS # OF ANY KIND, WHETHER ORAL OR WRITTEN, EXPRESS OR IMPLIED. THE
 * AUTHOR SPECIFICALLY # DISCLAIMS ANY IMPLIED WARRANTIES OR CONDITIONS OF
 * MERCHANTABILITY, SATISFACTORY # QUALITY, NON-INFRINGEMENT AND FITNESS FOR A
 * PARTICULAR PURPOSE.
 * #############################################################################
 */

/**
 * Deploy VMs from local disk to an ESX(i) server
 * @author Steve Jin (sjin@vmware.com)
 */
import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import com.vmware.vim25.*;
import com.vmware.vim25.mo.ComputeResource;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.HttpNfcLease;
import com.vmware.vim25.mo.ResourcePool;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin (sjin@vmware.com)
 */

public class ImportLocalOvfVApp 
{
	private static final int CHUCK_LEN = 64 * 1024;
	
	public static LeaseProgressUpdater leaseUpdater;

	public static void main(String[] args) throws Exception 
	{
		if (args.length < 6) 
		{
			System.out.println(
			"java ImportLocalOvfVApp <targetURL> <username> <password> <hostip> <OVFFile LocalPath> <NewVMName>");
			System.out.println(
			"java ImportLocalOvfVApp https://10.20.140.47/sdk Administrator password 10.17.204.115 E:/Downloads/Nostalgia.ovf NewVM");
			return;
		}
		
		ServiceInstance si = new ServiceInstance(new URL(args[0]), args[1], args[2], true);

		String ovfLocal = args[4];
		String hostip = args[3];
		String newVmName = args[5];
		
		HostSystem host = (HostSystem) si.getSearchIndex().findByIp(null, hostip, false); 
			
		System.out.println("Host Name : " + host.getName());
		System.out.println("Network : " + host.getNetworks()[0].getName());
		System.out.println("Datastore : " + host.getDatastores()[0].getName());

		Folder vmFolder = (Folder) host.getVms()[0].getParent();

		OvfCreateImportSpecParams importSpecParams = new OvfCreateImportSpecParams();
		importSpecParams.setHostSystem(host.getMOR());
		importSpecParams.setLocale("US");
		importSpecParams.setEntityName(newVmName);
		importSpecParams.setDeploymentOption("");
		OvfNetworkMapping networkMapping = new OvfNetworkMapping();
		networkMapping.setName("Network 1");
		networkMapping.setNetwork(host.getNetworks()[0].getMOR()); // network);
		importSpecParams.setNetworkMapping(new OvfNetworkMapping[] { networkMapping });
		importSpecParams.setPropertyMapping(null);

		String ovfDescriptor = readOvfContent(ovfLocal);
		if (ovfDescriptor == null) 
		{
			si.getServerConnection().logout();
			return;
		}
		
		ovfDescriptor = escapeSpecialChars(ovfDescriptor);
		System.out.println("ovfDesc:" + ovfDescriptor);
			
		ResourcePool rp = ((ComputeResource)host.getParent()).getResourcePool();

		OvfCreateImportSpecResult ovfImportResult = si.getOvfManager().createImportSpec(
				ovfDescriptor, rp, host.getDatastores()[0], importSpecParams);

		if(ovfImportResult==null)
		{
			si.getServerConnection().logout();
			return;
		}
		
		long totalBytes = addTotalBytes(ovfImportResult);
		System.out.println("Total bytes: " + totalBytes);

		HttpNfcLease httpNfcLease = null;

		httpNfcLease = rp.importVApp(ovfImportResult.getImportSpec(), vmFolder, host);
			
		// Wait until the HttpNfcLeaseState is ready
		HttpNfcLeaseState hls;
		for(;;)
		{
			hls = httpNfcLease.getState();
			if(hls == HttpNfcLeaseState.ready || hls == HttpNfcLeaseState.error)
			{
				break;
			}
		}
		
		if (hls.equals(HttpNfcLeaseState.ready)) 
		{
			System.out.println("HttpNfcLeaseState: ready ");
			HttpNfcLeaseInfo httpNfcLeaseInfo = (HttpNfcLeaseInfo) httpNfcLease.getInfo();
			printHttpNfcLeaseInfo(httpNfcLeaseInfo);

			leaseUpdater = new LeaseProgressUpdater(httpNfcLease, 5000);
			leaseUpdater.start();

			HttpNfcLeaseDeviceUrl[] deviceUrls = httpNfcLeaseInfo.getDeviceUrl();
			
			long bytesAlreadyWritten = 0;
			for (HttpNfcLeaseDeviceUrl deviceUrl : deviceUrls) 
			{
				String deviceKey = deviceUrl.getImportKey();
				for (OvfFileItem ovfFileItem : ovfImportResult.getFileItem()) 
				{
					if (deviceKey.equals(ovfFileItem.getDeviceId())) 
					{
						System.out.println("Import key==OvfFileItem device id: " + deviceKey);
						String absoluteFile = new File(ovfLocal).getParent() + File.separator + ovfFileItem.getPath();
						String urlToPost = deviceUrl.getUrl().replace("*", hostip);
						uploadVmdkFile(ovfFileItem.isCreate(), absoluteFile, urlToPost, bytesAlreadyWritten, totalBytes);
						bytesAlreadyWritten += ovfFileItem.getSize();
						System.out.println("Completed uploading the VMDK file:" + absoluteFile);
					}
				}
			}

			leaseUpdater.interrupt();
			httpNfcLease.httpNfcLeaseProgress(100);
			httpNfcLease.httpNfcLeaseComplete();
		}
		si.getServerConnection().logout();
	}
	
	
	public static long addTotalBytes(OvfCreateImportSpecResult ovfImportResult)
	{
		OvfFileItem[] fileItemArr = ovfImportResult.getFileItem();
		
		long totalBytes = 0;
		if (fileItemArr != null) 
		{
			for (OvfFileItem fi : fileItemArr) 
			{
				printOvfFileItem(fi);
				totalBytes += fi.getSize();
			}
		}
		return totalBytes;
	}
	
	private static void uploadVmdkFile(boolean put, String diskFilePath, String urlStr, 
			long bytesAlreadyWritten, long totalBytes) throws IOException 
	{
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() 
		{
			public boolean verify(String urlHostName, SSLSession session) 
			{
				return true;
			}
		});
		
		HttpsURLConnection conn = (HttpsURLConnection) new URL(urlStr).openConnection();
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setChunkedStreamingMode(CHUCK_LEN);
		conn.setRequestMethod(put? "PUT" : "POST"); // Use a post method to write the file.
		conn.setRequestProperty("Connection", "Keep-Alive");
		conn.setRequestProperty("Content-Type",	"application/x-vnd.vmware-streamVmdk");
		conn.setRequestProperty("Content-Length", Long.toString(new File(diskFilePath).length()));
		
		BufferedOutputStream bos = new BufferedOutputStream(conn.getOutputStream());
		
		BufferedInputStream diskis = new BufferedInputStream(new FileInputStream(diskFilePath));
		int bytesAvailable = diskis.available();
		int bufferSize = Math.min(bytesAvailable, CHUCK_LEN);
		byte[] buffer = new byte[bufferSize];
		
		long totalBytesWritten = 0;
		while (true) 
		{
			int bytesRead = diskis.read(buffer, 0, bufferSize);
			if (bytesRead == -1) 
			{
				System.out.println("Total bytes written: " + totalBytesWritten);
				break;
			}

			totalBytesWritten += bytesRead;
			bos.write(buffer, 0, bufferSize);
			bos.flush();
			System.out.println("Total bytes written: " + totalBytesWritten);
			int progressPercent = (int) (((bytesAlreadyWritten + totalBytesWritten) * 100) / totalBytes);
			leaseUpdater.setPercent(progressPercent);			
		}
		
		diskis.close();
		bos.flush();
		bos.close();
		conn.disconnect();
	}
	
	public static String readOvfContent(String ovfFilePath)	throws IOException 
	{
		StringBuffer strContent = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(ovfFilePath)));
		String lineStr;
		while ((lineStr = in.readLine()) != null) 
		{
			strContent.append(lineStr);
		}
		in.close();
		return strContent.toString();
	}

	private static void printHttpNfcLeaseInfo(HttpNfcLeaseInfo info) 
	{
		System.out.println("================ HttpNfcLeaseInfo ================");
		HttpNfcLeaseDeviceUrl[] deviceUrlArr = info.getDeviceUrl();
		for (HttpNfcLeaseDeviceUrl durl : deviceUrlArr) 
		{
			System.out.println("Device URL Import Key: " + durl.getImportKey());
			System.out.println("Device URL Key: " + durl.getKey());
			System.out.println("Device URL : " + durl.getUrl());
			System.out.println("Updated device URL: " + durl.getUrl());
		}
		System.out.println("Lease Timeout: " + info.getLeaseTimeout());
		System.out.println("Total Disk capacity: " + info.getTotalDiskCapacityInKB());
		System.out.println("==================================================");
	}

	private static void printOvfFileItem(OvfFileItem fi) 
	{
		System.out.println("================ OvfFileItem ================");
		System.out.println("chunkSize: " + fi.getChunkSize());
		System.out.println("create: " + fi.isCreate());
		System.out.println("deviceId: " + fi.getDeviceId());
		System.out.println("path: " + fi.getPath());
		System.out.println("size: " + fi.getSize());
		System.out.println("==============================================");
	}

	public static String escapeSpecialChars(String str)
	{
		str = str.replaceAll("<", "&lt;");
		return str.replaceAll(">", "&gt;"); // do not escape "&" -> "&amp;", "\"" -> "&quot;"
	}
}