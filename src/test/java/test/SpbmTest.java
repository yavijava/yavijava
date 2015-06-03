package test;
import java.net.URL;

import com.vmware.spbm.PbmProfileResourceType;
import com.vmware.spbm.mo.PbmServiceInstance;
import com.vmware.vim25.mo.ServiceInstance;


public class SpbmTest {
	public static void main(String[] args) {
		try {

		    final URL url = new URL("https", "100.222.12.122", "/sdk");
			ServiceInstance si = new ServiceInstance(url, "vsphere.local\\administrator", "vmware", true);

			final URL pbmUrl = new URL("https", "100.222.12.122", "/pbm");
			PbmServiceInstance pbmSi = new PbmServiceInstance(pbmUrl, si.getServerConnection().getSessionStr(), true);

			PbmProfileResourceType[] PbmProfileResourceTypes = pbmSi.getProfileManager().pbmFetchResourceType();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
