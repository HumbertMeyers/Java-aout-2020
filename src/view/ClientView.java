/**
 * 
 */
package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.regex.Pattern;

import controller.DhcpController;
import model.ModelDHCP;
import view.ReadInput;
/**
 * @author Humbert Meyers
 *
 */
@SuppressWarnings("deprecation")
public class ClientView implements Observer{
	
	private Scanner scan;
	protected ModelDHCP model;
	protected DhcpController controller;
	
	
	/**
	 * Les différents menus possibles
	 */
	private static final String menuP = ""
			+ "1. Config DHCP\n"
			+ "2. Config Client\n"
			+ "3. Quitter";

	private static final String menuDHCP = ""
			+ "1.1. Config DHCP\n"
			+ "1.2. Retour";

	private static final String menuClient = ""
			+ "2.1. Vue avec 2 clients\n"
			+ "2.2. Retour\n";

	/**
	 * Le constructeur
	 */
	public ClientView(ModelDHCP model, DhcpController controller) {
		this.model = model;
		this.controller = controller;
		this.update(null, null);
		this.scan = new Scanner(System.in);
		
		/* TODO Menu disposant de :
		 * 			1. Config DHCP
		 *			 	1.1 Vue Config DHCP
		 * 				1.2 Retour
		 * 			2. Config Client
		 * 				2.1 Vue avec 2 clients
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
