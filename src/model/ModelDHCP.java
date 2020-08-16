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
	
	public void donneIP(String router, String ip, int masque, String dns) {
		dhcp = new DHCP(router, ip, masque, dns);
	}
	
	public List<IP> getUsedIP() {
		return dhcp.usedIP;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
