/*================================================================================
Copyright (c) 2009 VMware, Inc. All Rights Reserved.

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

package com.vmware.vim25;

/**
@author Steve Jin (sjin@vmware.com)
*/

public enum VirtualMachineGuestOsIdentifier
{
  dosGuest ("dosGuest"),
  win31Guest ("win31Guest"),
  win95Guest ("win95Guest"),
  win98Guest ("win98Guest"),
  winMeGuest ("winMeGuest"),
  winNTGuest ("winNTGuest"),
  win2000ProGuest ("win2000ProGuest"),
  win2000ServGuest ("win2000ServGuest"),
  win2000AdvServGuest ("win2000AdvServGuest"),
  winXPHomeGuest ("winXPHomeGuest"),
  winXPProGuest ("winXPProGuest"),
  winXPPro64Guest ("winXPPro64Guest"),
  winNetWebGuest ("winNetWebGuest"),
  winNetStandardGuest ("winNetStandardGuest"),
  winNetEnterpriseGuest ("winNetEnterpriseGuest"),
  winNetDatacenterGuest ("winNetDatacenterGuest"),
  winNetBusinessGuest ("winNetBusinessGuest"),
  winNetStandard64Guest ("winNetStandard64Guest"),
  winNetEnterprise64Guest ("winNetEnterprise64Guest"),
  winLonghornGuest ("winLonghornGuest"),
  winLonghorn64Guest ("winLonghorn64Guest"),
  winNetDatacenter64Guest ("winNetDatacenter64Guest"),
  winVistaGuest ("winVistaGuest"),
  winVista64Guest ("winVista64Guest"),
  windows7Guest ("windows7Guest"),
  windows7_64Guest ("windows7_64Guest"),
  windows7Server64Guest ("windows7Server64Guest"),
  freebsdGuest ("freebsdGuest"),
  freebsd64Guest ("freebsd64Guest"),
  redhatGuest ("redhatGuest"),
  rhel2Guest ("rhel2Guest"),
  rhel3Guest ("rhel3Guest"),
  rhel3_64Guest ("rhel3_64Guest"),
  rhel4Guest ("rhel4Guest"),
  rhel4_64Guest ("rhel4_64Guest"),
  rhel5Guest ("rhel5Guest"),
  rhel5_64Guest ("rhel5_64Guest"),
  rhel6Guest ("rhel6Guest"),
  rhel6_64Guest ("rhel6_64Guest"),
  centosGuest ("centosGuest"),
  centos64Guest ("centos64Guest"),
  oracleLinuxGuest ("oracleLinuxGuest"),
  oracleLinux64Guest ("oracleLinux64Guest"),
  suseGuest ("suseGuest"),
  suse64Guest ("suse64Guest"),
  slesGuest ("slesGuest"),
  sles64Guest ("sles64Guest"),
  sles10Guest ("sles10Guest"),
  sles10_64Guest ("sles10_64Guest"),
  sles11Guest ("sles11Guest"),
  sles11_64Guest ("sles11_64Guest"),
  nld9Guest ("nld9Guest"),
  oesGuest ("oesGuest"),
  sjdsGuest ("sjdsGuest"),
  mandrivaGuest ("mandrivaGuest"),
  mandriva64Guest ("mandriva64Guest"),
  turboLinuxGuest ("turboLinuxGuest"),
  turboLinux64Guest ("turboLinux64Guest"),
  ubuntuGuest ("ubuntuGuest"),
  ubuntu64Guest ("ubuntu64Guest"),
  debian4Guest ("debian4Guest"),
  debian4_64Guest ("debian4_64Guest"),
  debian5Guest ("debian5Guest"),
  debian5_64Guest ("debian5_64Guest"),
  asianux3Guest ("asianux3Guest"),
  asianux3_64Guest ("asianux3_64Guest"),
  asianux4Guest ("asianux4Guest"),
  asianux4_64Guest ("asianux4_64Guest"),
  other24xLinuxGuest ("other24xLinuxGuest"),
  other26xLinuxGuest ("other26xLinuxGuest"),
  otherLinuxGuest ("otherLinuxGuest"),
  other24xLinux64Guest ("other24xLinux64Guest"),
  other26xLinux64Guest ("other26xLinux64Guest"),
  otherLinux64Guest ("otherLinux64Guest"),
  solaris6Guest ("solaris6Guest"),
  solaris7Guest ("solaris7Guest"),
  solaris8Guest ("solaris8Guest"),
  solaris9Guest ("solaris9Guest"),
  solaris10Guest ("solaris10Guest"),
  solaris10_64Guest ("solaris10_64Guest"),
  os2Guest ("os2Guest"),
  eComStationGuest ("eComStationGuest"),
  netware4Guest ("netware4Guest"),
  netware5Guest ("netware5Guest"),
  netware6Guest ("netware6Guest"),
  openServer5Guest ("openServer5Guest"),
  openServer6Guest ("openServer6Guest"),
  unixWare7Guest ("unixWare7Guest"),
  darwinGuest ("darwinGuest"),
  darwin64Guest ("darwin64Guest"),
  otherGuest ("otherGuest"),
  otherGuest64 ("otherGuest64");

  private final String val;
  private VirtualMachineGuestOsIdentifier(String val)
  {
    this.val = val;
  }
}