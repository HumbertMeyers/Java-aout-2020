/**
 * 
 */
package model;

import java.util.List;
import java.util.Observable;

/**
 * @author Humbert Meyers
 *
 */
public class ModelDHCP extends Observable {
	
	private DHCP dhcp;

	/**
	 * 
	 */
	public ModelDHCP() {
		this.dhcp = new DHCP();
	}
	
	public int donneIP(String router, String ip, int masque, String dns) {
		if(isIpUtilisee(ip)) {
			return 2;
		}
		else {
			try {
				dhcp = new DHCP(router, ip, masque, dns);
				
				if(!dhcp.usedIP.contains(router)) {dhcp.setUsedIP(router);}
				if(!dhcp.usedIP.contains(dns)) {dhcp.setUsedIP(dns);}
				dhcp.setUsedIP(ip);
				return 0;
			} catch (Exception e) {
				return 1;
			}
		}
	}

	
	public List<String> getUsedIP() {
		return dhcp.usedIP;
	}
	
	public boolean isIpUtilisee(String ip){
		return (dhcp.usedIP.contains(ip)) ? true : false;
	}
}
