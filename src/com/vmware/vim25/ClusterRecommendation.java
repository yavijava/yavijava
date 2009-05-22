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
import java.util.Calendar;

/**
@author Steve Jin (sjin@vmware.com)
*/

public class ClusterRecommendation extends DynamicData
{
  public String key;
  public String type;
  public Calendar time;
  public int rating;
  public String reason;
  public String reasonText;
  public String[] prerequisite;
  public ClusterAction[] action;
  public ManagedObjectReference target;

  public String getKey()
  {
    return this.key;
  }

  public String getType()
  {
    return this.type;
  }

  public Calendar getTime()
  {
    return this.time;
  }

  public int getRating()
  {
    return this.rating;
  }

  public String getReason()
  {
    return this.reason;
  }

  public String getReasonText()
  {
    return this.reasonText;
  }

  public String[] getPrerequisite()
  {
    return this.prerequisite;
  }

  public ClusterAction[] getAction()
  {
    return this.action;
  }

  public ManagedObjectReference getTarget()
  {
    return this.target;
  }

  public void setKey(String key)
  {
    this.key=key;
  }

  public void setType(String type)
  {
    this.type=type;
  }

  public void setTime(Calendar time)
  {
    this.time=time;
  }

  public void setRating(int rating)
  {
    this.rating=rating;
  }

  public void setReason(String reason)
  {
    this.reason=reason;
  }

  public void setReasonText(String reasonText)
  {
    this.reasonText=reasonText;
  }

  public void setPrerequisite(String[] prerequisite)
  {
    this.prerequisite=prerequisite;
  }

  public void setAction(ClusterAction[] action)
  {
    this.action=action;
  }

  public void setTarget(ManagedObjectReference target)
  {
    this.target=target;
  }
}