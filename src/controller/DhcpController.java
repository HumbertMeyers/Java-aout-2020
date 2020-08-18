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
		int resultIP = model.donneIP(router, ip, masque, dns);
		switch(resultIP) {
			case 0: 
				gui.show("Configuration IP effectuée.");
				break;
			case 1:	
				gui.show("Adresse IP déja existante.");
				break;
			case 2:	
				gui.show("Erreur dans la configuration IP.");
				break;
			default: 
				break;
		}	
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				ModelDHCP model = new ModelDHCP();
				DhcpController DC = new DhcpController(model);
				GUI gui = new GUI();
				
			}
			
		});
	}
	
	/**
	 * Cette fonction enregistre la configuration du DHCP
	 * @param dns l'adresse IP du DNS sous forme de String
	 * @param router l'adresse IP du router sous forme de String
	 * @param masque le masque de sous réseau sous forme de Integer
	 */
	public static void enregistrerDhcpConfig(String dns, String router, String masque) {
		model.dns = dns;
		model.router = router;
		model.masque = Integer.parseInt(masque);
	}
}