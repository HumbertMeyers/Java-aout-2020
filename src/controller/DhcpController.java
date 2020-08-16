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
	
	ModelDHCP model;
	ServerView cli;
	//ClientView cv;
	GUI gui;
	
	
	/**
	 * 
	 */
	public DhcpController(ModelDHCP model) {
		this.model = model;
	}

	public void donneIP(String router, String ip, int masque, String dns) {
		int resultIP = model.donneIP(router, ip, masque, dns);
		switch(resultIP) {
			case 0: 
				cli.show("Configuration IP effectuée.");
				gui.show("Configuration IP effectuée.");
			case 1:	
				cli.show("Adresse IP déja existante.");
				gui.show("Adresse IP déja existante.");
			case 2:	
				cli.show("Erreur dans la configuration IP.");
				gui.show("Erreur dans la configuration IP.");
			default: ;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				ModelDHCP model = new ModelDHCP();
				DhcpController DC = new DhcpController(model);
				ServerView cli = new ServerView(model, DC);
				GUI gui = new GUI();			
				
			}
			
		});
	}
}