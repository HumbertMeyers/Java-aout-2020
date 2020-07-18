/**
 * 
 */
package model;

import java.util.Arrays;
import java.util.List;

/**
 * @author Humbert Meyers
 *
 */
public class DHCP extends IP {
	
	/**
	 * ipRouter : Une adresse IP (celle du routeur) sous forme de tableau de bytes.
	 */
	protected int ipRouter[];
	
	/**
	 * ipRouter : Une adresse IP (celle du routeur) sous forme de tableau de bytes.
	 */
	protected int ipDNS[];
	
	/**
	 * usedIP : La liste des adresses IP deja utilisees
	 */
	protected List<IP> usedIP;
	
	/**
	 * Ce constructeur donne une adresse IP avec un masque, un routeur et un dns.
	 */
	public DHCP() {
		super("192.168.1.1", 24);
		this.ipRouter = string2Integer("192.168.1.1");
		this.ipDNS = string2Integer("192.168.1.1");
	}
	
	/**
	 * Ce constructeur donne une adresse IP avec un masque, un routeur et un dns.
	 * Il assigne la valeur donnée à l'adresse IP aux routeur et au DNS
	 * @param dhcp : L'adresse IP du DHCP
	 * @param masque : Le masque de sous réseau
	 */
	public DHCP(String dhcp, int masque) {
		super(dhcp, masque);
		this.ipRouter = string2Integer(dhcp);
		this.ipDNS = string2Integer(dhcp);
	}

	/**
	 * Ce constructeur donne une adresse IP avec un masque, un routeur et un dns. 
	 * Si le routeur ou le dns n'est pas donné, il assigne la valeur donnée à l'adresse IP 
	 * @param router : L'adresse IP du routeur
	 * @param dhcp : L'adresse IP du DHCP
	 * @param masque : Le masque de sous réseau
	 * @param dns : L'adresse IP du DNS
	 */
	public DHCP(String router, String dhcp, int masque, String dns) {
		super(dhcp, masque);
		if(router=="") {this.ipRouter = string2Integer(dhcp);} else {this.ipRouter = string2Integer(router);}
		if(dns=="") {this.ipDNS = string2Integer(dhcp);} else {this.ipDNS = string2Integer(dns);}
	}
	
	/**
	 * Cette methode transforme une adresse IP à partir d'un String vers un tableau de int.
	 * @param addr : l'adresse IP reçue en paramètre sous forme de String.
	 * @return l'adresse IP sous forme de tableau de int.
	 */
	public int[] string2Interger(String addr) {
		String[] ipArray;
		ipArray = addr.split("\\.");
		return new int[] {
				Integer.parseInt(ipArray[0]),
				Integer.parseInt(ipArray[1]),
				Integer.parseInt(ipArray[2]),
				Integer.parseInt(ipArray[3])
		};
	}
	
	/**
	 * @return the ipRouter
	 */
	public String getIpRouter() {
		return Arrays.toString(ipRouter)
				.replace(",", ".")
				.replace("[", "")
				.replace("]", "")
				.replace(" ", "");
	}

	/**
	 * @param ipRouter the ipRouter to set
	 */
	public void setIpRouter(int[] ipRouter) {
		this.ipRouter = ipRouter;
	}

	/**
	 * @return the ipDNS
	 */
	public String getIpDNS() {
		return Arrays.toString(ipDNS)
				.replace(",", ".")
				.replace("[", "")
				.replace("]", "")
				.replace(" ", "");
	}

	/**
	 * @param ipDNS the ipDNS to set
	 */
	public void setIpDNS(int[] ipDNS) {
		this.ipDNS = ipDNS;
	}

	/**
	 * @return the usedIP
	 */
	public List<IP> getUsedIP() {
		return usedIP;
	}

	/**
	 * @param usedIP the usedIP to set
	 */
	public void setUsedIP(List<IP> usedIP) {
		this.usedIP = usedIP;
	}

	/**
	 * Cette methode retourne une adresse ip
	 * @param addr : une adresse ip sous forme de tableau de int
	 * @return l'adresse IP sous forme de string dans le format "xxx.xxx.xxx.xxx".
	 */
	public String getIpAdr(int[] addr) {
		return Arrays.toString(addr)
				.replace(",", ".")
				.replace("[", "")
				.replace("]", "")
				.replace(" ", "");
	}
	
	@Override
	public String toString() {
		return "Voici les informations concernant votre DHCP\n" 
				+ "IP: " + getIpAdr() + "\n" 
				+ "Masque : " + getMasque() + "\n"
				+ "Router : " + getIpRouter() + "\n"
				+ "DNS : " + getIpDNS();
	}

	public static void main(String[] args) {
		DHCP dhcp1 = new DHCP();
		DHCP dhcp2 = new DHCP("", "172.16.2.253",23,"172.16.2.1");
		DHCP dhcp3 = new DHCP("192.168.1.1","192.168.1.2",24,"");
		DHCP dhcp4 = new DHCP("10.8.1.254","10.8.2.127",25,"8.8.8.8");
		DHCP dhcp5 = new DHCP("","172.16.255.253",16,"172.168.2.1");
		DHCP dhcp6 = new DHCP("192.168.99.1", 24);
		System.out.println(dhcp1.toString());
		System.out.println(dhcp2.toString());
		System.out.println(dhcp3.toString());
		System.out.println(dhcp4.toString());
		System.out.println(dhcp5.toString());
		System.out.println(dhcp6.toString());
		
	}

}
