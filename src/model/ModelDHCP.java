/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Humbert Meyers
 *
 */
public class ModelDHCP extends Observable {
	
	/**
	 * Les variables
	 * dhcp : un dhcp correspondant � la classe DHCP
	 * dns : l'adresse IP du DNS sous forme de String
	 * router : l'adresse IP du router sous forme de String
	 * masque : le masque de sous r�seau sous forme de Integer
	 */
	private static DHCP dhcp;
	public String dns;
	public String router;
	public int masque;
	

	/**
	 * Ce constructeur cr�e un nouveau DHCP.
	 */
	public ModelDHCP() {
		this.dhcp = new DHCP();
	}
	
	/**
	 * Cette fonction g�re la demande d'une adresse IP.
	 * @return une adresse IP sous forme de string.
	 */
	public int doraDemande() {
		dhcp = new DHCP();
		String router = dhcp.getIpRouter();
		String dns = dhcp.getIpDNS();
		int masque = dhcp.getMasqueInt("255.255.255.0");
		String ip = dhcp.getIpAdr();
		int newIp = donneIP(router, ip, masque, dns);
		return newIp;
	}
	
	/**
	 * Cette fonction donne et v�rifie l'existance de l'adresse IP avec les information suivantes.
	 * @param router l'adresse IP du routeur sous forme de String
	 * @param ip l'adresse IP du client sous forme de String
	 * @param masque le masque de sous r�seau sous forme de Integer
	 * @param dns l'adresse IP du DNS sous forme de String
	 * @return un Integer en fonction de l'existance de l'adresse IP du client ou non dans l' ArrayList<String> usedIP 
	 */
	public int donneIP(String router, String ip, int masque, String dns) {
		if(isIpUtilisee(ip)) {
			System.out.println(ip.toString());
			return 2;
		}
		else {
			try {
				if(!isIpUtilisee(dns)) {dhcp.setUsedIP(dns);}
				if(!isIpUtilisee(router)) {dhcp.setUsedIP(router);}
				dhcp.setUsedIP(ip);
				System.out.println(ip.toString());
				return 0;
			} catch (Exception e) {
				return 1;
			}
		}
	}

	/**
	 * R�cup�re les adresses IP existantes du modele DHCP
	 * @return ArrayList<String> usedIP
	 */
	public ArrayList<String> getUsedIP() {
		return dhcp.usedIP;
	}
	
	/**
	 * Recherche un String dans un ArrayList de String
	 * @param tab une ArrayList de String
	 * @param chaine un String recherch�
	 * @return
	 */
	public boolean contain(ArrayList<String> tab, String chaine) {
		for (String s : tab) {
			if (s.equals(chaine)) {return true;}
		}
		return false;
	}
	
	/**
	 * recherche l'adresse IP dans l' ArrayList usedIP
	 * @param ip l'adresse IP sous forme de String
	 * @return true si l'adresse IP existe dans la liste, false sinon.
	 */
	public boolean isIpUtilisee(String ip){
		return (contain(dhcp.usedIP, ip)) ? true : false;
	}
}
