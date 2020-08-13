/**
 * 
 */
package view;

import java.util.Observer;
import java.util.Scanner;

import controller.DhcpController;
import model.ModelDHCP;

/**
 * @author Humbert Meyers
 *
 */
@SuppressWarnings("deprecation")
public class ServerView implements Observer{
	
	private Scanner scan;

	protected ModelDHCP model;
	protected DhcpController controller;
	
	private static final String menuP = ""
			+ "1. Config DHCP\n"
			+ "2. Config Client\n"
			+ "3. Quitter";

	private static final String menuDHCP = ""
			+ "1.1. Config DHCP\n"
			+ "1.2. Retour";

	private static final String menuClient = ""
			+ "2.1. Choix Du client\n"
			+ "2.2. Retour\n";

	private static final String menuChoixClient = ""
			+ "2.1.1. Client 1\n"
			+ "2.1.2. Client 2\n"
			+ "2.1.3. Retour";

	private static final String menuDORA = ""
			+ "Procédure DORA\n"
			+ "Retour\n";
	
	/**
	 * 
	 */
	public ServerView(ModelDHCP model, DhcpController controller) {
		this.model = model;
		this.controller = controller;
		this.update(null, null);
		this.scan = new Scanner(System.in);
		
		/* TODO Menu disposant de :
		 * 			1. Config DHCP
		 *			 	1.1 Config DHCP
		 * 				1.2 Retour
		 * 			2. Config Client
		 * 				2.1 Choix du client (1 ou 2)
		 * 					2.1.1 Procédure DORA
		 * 					2.1.2 Retour
		 * 				2.2 Retour
		 * 			3. Quitter
		*/
	}
	
	
	public void addObserver(Observer obs) {
	
	}
	public void removeObserver() {
	
	}
	public void notifyObserver(String str) {
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg == null) {
			printWelcome();
			printInstructions();
		} else {
			
		}
		
	}

}
