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
	protected ServerView cli;
	protected GUI gui;
	
	
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
				break;
			case 1:	
				cli.show("Adresse IP déja existante.");
				gui.show("Adresse IP déja existante.");
				break;
			case 2:	
				cli.show("Erreur dans la configuration IP.");
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
				ServerView cli = new ServerView(model, DC);
				GUI gui = new GUI();	
				
			}
			
		});
	}

	/**
	 * 
	 */
	
	public static void changerVue(String e) {
		System.out.println("--- \n");
		switch (e) {
			case "vueMenu" : 
				ReadInput.show(ReadInput.MENUP_STRING);
				break;
			case "vueClient" :
				ReadInput.show(ReadInput.MENUCLIENT_STRING);
				break;
			case "vueDHCP" :
				ReadInput.show(ReadInput.MENUDHCP_STRING);
				break;
		}
	}
}