/**
 * 
 */
package model;

import java.util.ArrayList;
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
	
	public int doraDemande() {
		String router = dhcp.getIpRouter();
		String dns = dhcp.getIpDNS();
		int masque = dhcp.getMasqueInt("255.255.0.0");
		String ip = dhcp.getIP();
		donneIP(router, ip, masque, dns);
		return 0;
	}
	
	public int donneIP(String router, String ip, int masque, String dns) {
		if(isIpUtilisee(ip)) {
			System.out.println(ip.toString());
			return 2;
		}
		else {
			try {
				dhcp = new DHCP(router, ip, masque, dns);
				
				if(!dhcp.usedIP.contains(dns)) {dhcp.setUsedIP(dns);}
				if(!dhcp.usedIP.contains(router)) {dhcp.setUsedIP(router);}
				dhcp.setUsedIP(ip);
				System.out.println(ip.toString());
				return 0;
			} catch (Exception e) {
				return 1;
			}
		}
	}

	
	public ArrayList<String> getUsedIP() {
		return dhcp.usedIP;
	}
	
	public boolean isIpUtilisee(String ip){
		return (dhcp.usedIP.contains(ip)) ? true : false;
	}
}
