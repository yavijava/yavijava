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

package com.vmware.vim.rest;

/** The utility to convert the HTML table to XML format.
  * @author Steve JIN (sjin@vmware.com)
*/

public class ResultConverter
{
  final static String TABLE_START = "<table";
  final static String TABLE_END = "</table";
  final static String TR_START = "<tr>";
  final static String TD_START = "<td";
  final static String TD_END = "</td>";
  final static String LINK_END = "</a>";
  
  public static String convert2Xml(String html)
  {
    StringBuffer xml = new StringBuffer("<xml> <result");
    int pos = html.indexOf("<");
    String resultType = html.substring(1, pos);
    xml.append(" type=\"" + resultType + "\">\n");
    
    int tableEnd = html.lastIndexOf(TABLE_END);
    convertTable(html, pos, tableEnd, xml);

    xml.append("</result> </xml>");

    return xml.toString();
  }
  
  private static int convertTable(String html, int from, int to, StringBuffer xml)
  {
    int pos = html.indexOf(TABLE_START, from);
    pos = html.indexOf(TR_START, pos) + TR_START.length();
    System.out.println("ConvertTable Pos:" + pos);
    
    while( (pos = html.indexOf(TR_START, pos))!= -1)
    {
      if(pos > to)
      {
        return to;
      }
      pos = html.indexOf(TD_START, pos);
      int nameStart = html.indexOf(">", pos) + 1;
      int nameEnd = html.indexOf(TD_END, nameStart);
      String name = html.substring(nameStart, nameEnd);
      
      pos = html.indexOf(TD_START, nameEnd);
      int typeStart = html.indexOf(">", pos) + 1;
      int typeEnd = html.indexOf(TD_END, typeStart);
      String type = html.substring(typeStart, typeEnd);
     
      xml.append("<" + name + " type=\"" + type + "\">");
      
      pos = convertTdValue(html, typeEnd, to, type, xml);

      xml.append("</" + name +">\n");
    }
    System.out.println("ConvertTable Pos(end):" + pos);
    return pos;
  }
  
  private static int convertTdValue(String html, int from, int to, String type, StringBuffer xml)
  {
    int pos = html.indexOf(TD_START, from);
  
//    System.out.println("ConvertTdValue Pos:" + pos);
    
    String value = "";
    
    if(!isSimpleTdValue(html, pos, to))
    {
      int tableEnd = getTableEnd(html, pos + TD_START.length() + TABLE_START.length(), to-1);
      System.out.println("tableEnd:" + tableEnd);
//ServiceContent</p>         <table summary="Table of properties for this Data Object">                <tr>                  <th>Name</th>                  <th>Type</th>                  <th>Value</th>                </tr><tr><td class="c2">about</td><td class="c1">AboutInfo</td><td>         <table summary="Table of properties for this Data Object">                <tr>                  <th>Name</th>                  <th>Type</th>                  <th>Value</th>                </tr><tr><td class="c2">apiType</td><td class="c1">string</td><td>"HostAgent"</td></tr><tr><td class="c2">apiVersion</td><td class="c1">string</td><td>"2.0.0"</td></tr><tr><td class="c2">build</td><td class="c1">string</td><td>"62355"</td></tr><tr><td class="c2">dynamicProperty</td><td class="c1">DynamicProperty[]</td><td>Unset</td></tr><tr><td class="c2">dynamicType</td><td class="c1">string</td><td>Unset</td></tr><tr><td class="c2">fullName</td><td class="c1">string</td><td>"VMware ESX Server 3.5.0 build-62355"</td></tr><tr><td class="c2">localeBuild</td><td class="c1">string</td><td>"000"</td></tr><tr><td class="c2">localeVersion</td><td class="c1">string</td><td>"INTL"</td></tr><tr><td class="c2">name</td><td class="c1">string</td><td>"VMware ESX Server"</td></tr><tr><td class="c2">osType</td><td class="c1">string</td><td>"vmnix-x86"</td></tr><tr><td class="c2">productLineId</td><td class="c1">string</td><td>"esx"</td></tr><tr><td class="c2">vendor</td><td class="c1">string</td><td>"VMware, Inc."</td></tr><tr><td class="c2">version</td><td class="c1">string</td><td>"3.5.0"</td></tr></table></td></tr><tr><td class="c2">accountManager</td><td class="c1">ManagedObjectReference:HostLocalAccountManager</td><td><a href="/mob/?moid=ha%2dlocalacctmgr">ha-localacctmgr</a></td></tr><tr><td class="c2">alarmManager</td><td class="c1">ManagedObjectReference:AlarmManager</td><td>Unset</td></tr><tr><td class="c2">authorizationManager</td><td class="c1">ManagedObjectReference:AuthorizationManager</td><td><a href="/mob/?moid=ha%2dauthmgr">ha-authmgr</a></td></tr><tr><td class="c2">customFieldsManager</td><td class="c1">ManagedObjectReference:CustomFieldsManager</td><td>Unset</td></tr><tr><td class="c2">customizationSpecManager</td><td class="c1">ManagedObjectReference:CustomizationSpecManager</td><td>Unset</td></tr><tr><td class="c2">diagnosticManager</td><td class="c1">ManagedObjectReference:DiagnosticManager</td><td><a href="/mob/?moid=ha%2ddiagnosticmgr">ha-diagnosticmgr</a></td></tr><tr><td class="c2">dynamicProperty</td><td class="c1">DynamicProperty[]</td><td>Unset</td></tr><tr><td class="c2">dynamicType</td><td class="c1">string</td><td>Unset</td></tr><tr><td class="c2">eventManager</td><td class="c1">ManagedObjectReference:EventManager</td><td><a href="/mob/?moid=ha%2deventmgr">ha-eventmgr</a></td></tr><tr><td class="c2">extensionManager</td><td class="c1">ManagedObjectReference:ExtensionManager</td><td>Unset</td></tr><tr><td class="c2">fileManager</td><td class="c1">ManagedObjectReference:FileManager</td><td><a href="/mob/?moid=ha%2dnfc%2dfile%2dmanager">ha-nfc-file-manager</a></td></tr><tr><td class="c2">licenseManager</td><td class="c1">ManagedObjectReference:LicenseManager</td><td><a href="/mob/?moid=ha%2dlicense%2dmanager">ha-license-manager</a></td></tr><tr><td class="c2">perfManager</td><td class="c1">ManagedObjectReference:PerformanceManager</td><td><a href="/mob/?moid=ha%2dperfmgr">ha-perfmgr</a></td></tr><tr><td class="c2">propertyCollector</td><td class="c1">ManagedObjectReference:PropertyCollector</td><td><a href="/mob/?moid=ha%2dproperty%2dcollector">ha-property-collector</a></td></tr><tr><td class="c2">rootFolder</td><td class="c1">ManagedObjectReference:Folder</td><td><a href="/mob/?moid=ha%2dfolder%2droot">ha-folder-root</a></td></tr><tr><td class="c2">scheduledTaskManager</td><td class="c1">ManagedObjectReference:ScheduledTaskManager</td><td>Unset</td></tr><tr><td class="c2">searchIndex</td><td class="c1">ManagedObjectReference:SearchIndex</td><td><a href="/mob/?moid=ha%2dsearchindex">ha-searchindex</a></td></tr><tr><td class="c2">sessionManager</td><td class="c1">ManagedObjectReference:SessionManager</td><td><a href="/mob/?moid=ha%2dsessionmgr">ha-sessionmgr</a></td></tr><tr><td class="c2">setting</td><td class="c1">ManagedObjectReference:OptionManager</td><td><a href="/mob/?moid=HostAgentSettings">HostAgentSettings</a></td></tr><tr><td class="c2">taskManager</td><td class="c1">ManagedObjectReference:TaskManager</td><td><a href="/mob/?moid=ha%2dtaskmgr">ha-taskmgr</a></td></tr><tr><td class="c2">userDirectory</td><td class="c1">ManagedObjectReference:UserDirectory</td><td><a href="/mob/?moid=ha%2duser%2ddirectory">ha-user-directory</a></td></tr><tr><td class="c2">viewManager</td><td class="c1">ManagedObjectReference:ViewManager</td><td><a href="/mob/?moid=ViewManager">ViewManager</a></td></tr><tr><td class="c2">virtualDiskManager</td><td class="c1">ManagedObjectReference:VirtualDiskManager</td><td><a href="/mob/?moid=ha%2dvdiskmanager">ha-vdiskmanager</a></td></tr><tr><td class="c2">virtualizationManager</td><td class="c1">ManagedObjectReference:VirtualizationManager</td><td>Unset</td></tr></table>  </body></html>        
      pos = convertTable(html, pos, tableEnd + TABLE_END.length()+1, xml);
      System.out.println("pos:" + pos);
    }
    else
    {
      int valueStart = html.indexOf(">", pos) + 1;
      int valueEnd = html.indexOf(TD_END, valueStart);
      value = html.substring(valueStart, valueEnd);
      if("Unset".equals(value))
      {
        value="";
      }
      else if("string".equals(type))
      {
        value = value.substring(1, value.length()-1);
      }
      else if(value.indexOf("href=")!=-1)
      {
        int start = value.indexOf(">");
        int end = value.indexOf("</a>", start);
        value = value.substring(start+1, end);
      }
    }
    return pos;
  }

  private static boolean isSimpleTdValue(String html, int from, int to)
  {
    int pos = html.indexOf("</", from);
    if(html.startsWith(TD_END, pos) || html.startsWith(LINK_END, pos))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  private static int getTableEnd(String html, int from, int to)
  {
    int tagLevel = 0;
    int pos = from;
    while(true)
    {
      pos = html.indexOf("<", pos+1);
      if(html.charAt(pos+1)=='/')
      { //closing tag
        if(html.startsWith(TABLE_END, pos))
        {
          tagLevel--;
        }
      }
      else
      { //opening tag, then
        if(html.startsWith(TABLE_START, pos))
        {
          tagLevel++;
        }
      }
      if(tagLevel==0)
      {
        break;
      }
    }
    return pos;
  }
}