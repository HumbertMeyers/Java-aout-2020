/**
 * 
 */
package controller;

import java.awt.EventQueue;
import java.util.List;

import model.ModelDHCP;
import view.*;

/**
 * @author Humbert Meyers
 *
 */
public class DhcpController {
	
	public static ModelDHCP model;
	protected GUI gui;
	
	
	/**
	 * Le constructeur.
	 * @param model le modelDHCP
	 */
	public DhcpController(ModelDHCP model) {
		this.model = model;
	}

	/**
	 * Cette fonction affiche dans la console un message lorsque la configuration IP est faite.
	 * @param router l'adresse IP du router sous forme de String
	 * @param ip l'adresse IP du cleint sous forme de String
	 * @param masque le masque de sous réseau sous forme de Integer
	 * @param dns l'adresse IP du DNS sous forme de String
	 */
	public void donneIP(String router, String ip, int masque, String dns) {
		String resultIP = model.donneIP(router, ip, masque, dns);
		switch(resultIP) {
			case "IP déjà utilisée":	
				gui.show("Adresse IP déja existante.");
				break;
			case "Erreur dans la demande DORA":	
				gui.show("Erreur dans la configuration IP.");
				break;
			default: 
				gui.show("Configuration IP effectuée.");
				break;
		}	
	}
	
	/**
	 * Cette fonction enregistre la configuration du DHCP
	 * @param dns l'adresse IP du DNS sous forme de String
	 * @param router l'adresse IP du router sous forme de String
	 * @param masque le masque de sous réseau sous forme de Integer
	 * @return un int en fonction de l'enregistrement ou non du dhcp
	 */
	public int enregistrerDhcpConfig(String dns, String router, String masque) {
		if(dns.equals("255.255.255.0")||router.equals("255.255.255.0")) {
			return 1;
		}
		else {
			try {
				model.setParamDHCP(dns, router, masque);
				return 0;
			} catch  (Exception e){
				return 2;
			}
		}
	}
	
	public void viderDHCP() {
		model.clearUsedIP();
		
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				ModelDHCP model = new ModelDHCP();
				DhcpController DC = new DhcpController(model);
				GUI gui = new GUI(DC);
			}
			
		});
	}
	
}