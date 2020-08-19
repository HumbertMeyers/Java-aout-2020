/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Humbert Meyers
 *
 */

public class DHCP extends IP{
	
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
	protected ArrayList<String> usedIP = new ArrayList<String>();
	
	/**
	 * Ce constructeur donne une adresse IP avec un masque, un routeur et un dns.
	 */
	public DHCP() {
		super(24);
		this.ipRouter = string2Integer("192.168.1.1");
		this.ipAdr = IpBaseeSurRouter(this.ipRouter);
		this.ipDNS = string2Integer("192.168.1.1");
		this.usedIP.add("0.0.0.0");
	}
	
	public DHCP(String router) {
		super(24);
		this.ipRouter = string2Integer(router);
		this.ipAdr = IpBaseeSurRouter(this.ipRouter);
		this.ipDNS = string2Integer("192.168.1.1");
		this.usedIP.add("0.0.0.0");
	}
	
	/**
	 * Ce constructeur donne une adresse IP avec un masque, un routeur et un dns.
	 * Il assigne la valeur donnée à l'adresse IP aux routeur et au DNS
	 * @param ip : L'adresse IP du DHCP
	 * @param masque : Le masque de sous réseau
	 */
	public DHCP(String ip, int masque) {
		super(ip, masque);
		this.ipRouter = string2Integer(ip);
		this.ipDNS = string2Integer(ip);
		this.usedIP.add("0.0.0.0");
	}

	/**
	 * Ce constructeur donne une adresse IP avec un masque, un routeur et un dns. 
	 * Si le routeur ou le dns n'est pas donné, il assigne la valeur donnée à l'adresse IP 
	 * @param router : L'adresse IP du routeur
	 * @param ip : L'adresse IP du DHCP
	 * @param masque : Le masque de sous réseau
	 */
	public DHCP(String router, String ip, int masque) {
		super(ip, masque);
		this.ipRouter = string2Integer(router);
		this.ipDNS = string2Integer(router);
		this.usedIP.add("0.0.0.0");
	}
	
	/**
	 * Ce constructeur donne une adresse IP avec un masque, un routeur et un dns. 
	 * Si le routeur ou le dns n'est pas donné, il assigne la valeur donnée à l'adresse IP 
	 * @param router : L'adresse IP du routeur
	 * @param ip : L'adresse IP du DHCP
	 * @param masque : Le masque de sous réseau
	 * @param dns : L'adresse IP du DNS
	 */
	public DHCP(String router, String ip, int masque, String dns) {
		super(ip, masque);
		this.ipRouter = string2Integer(router);
		this.ipDNS = string2Integer(dns);
		this.usedIP.add("0.0.0.0");
	}
	
	
	/**
	 * Cette methode transforme une adresse IP à partir d'un String vers un tableau de int.
	 * @param addr : l'adresse IP reçue en paramètre sous forme de String.
	 * @return l'adresse IP sous forme de tableau de int.
	 */
	public int[] string2Integer(String addr) {
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
	 * Cette fonction retourne une IP d'un client grace à l'ip du router
	 * @param ipRouter
	 * @return l'ip d'un client
	 */
	public int[] IpBaseeSurRouter(int[] ipRouter) {
		int [] ipAdr = ipRouter;
		int temp = ipAdr[3];
		boolean flag = true;
		
		while(flag) 
			if(contain(usedIP, getIpAdr(ipAdr))) {
				ipAdr[3] += 1;
				//System.out.println(getIpAdr(ipAdr));
				if(ipAdr[3] == temp) {
					ipAdr[0] = 0; ipAdr[1] = 0; ipAdr[2]=0; ipAdr[3] = 0;
					return ipAdr;
				}
				if(ipAdr[3] == 255) {
					ipAdr[3] = 1;
				}
			}
			else {
				flag = false;
			}
		return ipAdr;
	}
	
	/**
	 * Cette méthode vérifie si l'
	 * @param tab
	 * @param chaine
	 * @return
	 */
	public boolean contain(ArrayList<String> tab, String chaine) {
		for (String s : tab) {
			if (s.equals(chaine)) {return true;}
		}
		return false;
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
	public ArrayList<String> getUsedIP() {
		return usedIP;
	}

	/**
	 * @param ip : the usedIP to add to the ArrayList
	 */
	public void setUsedIP(String ip) {
		this.usedIP.add(ip);
	}
	
	/**
	 * Fonction qui supprime tout de l'ArrayList UsedIP
	 */
	public void clearUsedIP() {
		this.usedIP.clear();
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

	/**
	 * Cette méthode retourne un objet de type IP
	 * @return retourne un objet de type IP sous forme de string
	 */
	public String getIP() {
		IP ip = new IP();
		return ip.toString();
	}
	
	@Override
	public String toString() {
		return "Configuration IP\n\n" 
				+ "Adresse IPv4............: " + getIpAdr() + "\n" 
				+ "Masque de sous-réseau...: " + getMasque() + "\n"
				+ "Passerelle par défaut...: " + getIpRouter() + "\n"
				+ "Serveur DNS.............: " + getIpDNS();
	}

	/*public static void main(String[] args) {
		DHCP dhcp1 = new DHCP();
		DHCP dhcp2 = new DHCP("172.16.2.1", "172.16.2.253",23,"172.16.2.1");
		DHCP dhcp3 = new DHCP("192.168.1.1","192.168.1.2",24);
		DHCP dhcp4 = new DHCP("10.8.1.254","10.8.2.127",25,"8.8.8.8");
		DHCP dhcp5 = new DHCP("172.16.255.254","172.16.255.253",16,"172.168.2.1");
		DHCP dhcp6 = new DHCP("192.168.99.1", 24);
		System.out.println(dhcp1.toString()+ "\n" );
		System.out.println(dhcp2.toString()+ "\n" );
		System.out.println(dhcp3.toString()+ "\n" );
		System.out.println(dhcp4.toString()+ "\n" );
		System.out.println(dhcp5.toString()+ "\n" );
		System.out.println(dhcp6.toString());
	}*/

}
