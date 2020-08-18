/**
 * 
 */
package model;

import java.util.ArrayList;
import model.Observable;

/**
 * @author Humbert Meyers
 *
 */
public class ModelDHCP extends AbstractMVCModel {
	
	/**
	 * Les variables
	 * dhcp : un dhcp correspondant à la classe DHCP
	 * dns : l'adresse IP du DNS sous forme de String
	 * router : l'adresse IP du router sous forme de String
	 * masque : le masque de sous réseau sous forme de Integer
	 */
	private DHCP dhcp;
	public String dns;
	public String router;
	public int masque;
	

	/**
	 * Ce constructeur crée un nouveau DHCP.
	 */
	public ModelDHCP() {
		this.dhcp = new DHCP();
	}
	
	public void setParamDHCP(String dns, String router, String masque) {
		this.dns = dns;
		this.router = router;
		dhcp.setUsedIP(dns);
		dhcp.setUsedIP(router);
		this.masque = Integer.parseInt(masque);
		notifyObserver(this.dns);
		notifyObserver(this.router);
		notifyObserver(masque);
	}
	
	
	/**
	 * Cette fonction gère la demande d'une adresse IP.
	 * @return une adresse IP sous forme de string.
	 */
	public String doraDemande() {
		//dhcp = new DHCP(this.router);
		dhcp.setIpRouter(dhcp.string2Integer(this.router));
		dhcp.setIpDNS(dhcp.string2Integer(this.dns));
		dhcp.setMasque(this.masque);
		String ip = dhcp.getIpAdr();
		String newIp = donneIP(this.router, ip, this.masque, this.dns);
		return newIp;
		//notify
	}
	
	/**
	 * Cette fonction donne et vérifie l'existance de l'adresse IP avec les information suivantes.
	 * @param router l'adresse IP du routeur sous forme de String
	 * @param ip l'adresse IP du client sous forme de String
	 * @param masque le masque de sous réseau sous forme de Integer
	 * @param dns l'adresse IP du DNS sous forme de String
	 * @return un Integer en fonction de l'existance de l'adresse IP du client ou non dans l' ArrayList<String> usedIP 
	 */
	public String donneIP(String router, String ip, int masque, String dns) {
		if(isIpUtilisee(ip)) {
			System.out.println(ip.toString());
			return "IP déjà utilisée";
		}
		else {
			try {
				if(!isIpUtilisee(dns)) {dhcp.setUsedIP(dns);}
				if(!isIpUtilisee(router)) {dhcp.setUsedIP(router);}
				dhcp.setUsedIP(ip);
				System.out.println(ip.toString());
				return concatInfos(dns, router, masque, ip); // DNS, routeur , masque, IP
			} catch (Exception e) {
				return "Erreur dans la demande DORA";
			}
		}
	}
	
	
	public String concatInfos(String dns, String router, int masque, String ip) {
		String conca = "DNS : " + dns 
				+ "\nPasserelle par défaut : " + router
				+ "\nMasque de sous-réseau : " + masque
				+ "\nAdresse IPv4 proposée : " + ip;
		
		return conca;
	}
	
	/**
	 * Cette fonction vérifie que le String entré correspond bien au pattern "xxx.xxx.xxx.xxx"
	 * @param ip une adresse IP sous forme de String
	 * @return true si correspondant sinon false
	 */
	public static boolean validate(final String ip) {
		//PATTERN correspond à la Regex générique d'une adresse ip pouvant aller de 0.0.0.0 à 255.255.255.255
	 	String PATTERN = 
	 			"^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
	    return ip.matches(PATTERN);
	}

	/**
	 * Récupère les adresses IP existantes du modele DHCP
	 * @return ArrayList<String> usedIP
	 */
	public ArrayList<String> getUsedIP() {
		return dhcp.usedIP;
	}
	
	/**
	 * Recherche un String dans un ArrayList de String
	 * @param tab une ArrayList de String
	 * @param chaine un String recherché
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
