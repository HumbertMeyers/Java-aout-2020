/**
 * 
 */
package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.DhcpController;
import model.ModelDHCP;
import view.ReadInput;

/**
 * @author Humbert Meyers 
 *
 */
@SuppressWarnings("deprecation")
public class ServerView implements Observer{

	Scanner scan;
	protected ModelDHCP model;
	protected DhcpController controller;
	
	/**
	 * 
	 */
	public ServerView(ModelDHCP model, DhcpController controller) {
		this.model = model;
		this.controller = controller;
		this.update(null, null);
		//this.scan = new Scanner(System.in);
		
		
		this.model.addObserver(this);
		
		new Thread(new ReadInput()).start();
		
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
	
	public void show(String string) {
		System.out.println(string);
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
		} else {
			System.out.println("plop");
		}
		
	}

}
