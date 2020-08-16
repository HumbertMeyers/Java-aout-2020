/**
 * 
 */
package view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Humbert Meyers
 * Main running Class
 */
public class ReadInput implements Runnable {
	
	Scanner scan;
	int client = 0;
	
	
	
	public ReadInput() {
		this.scan = new Scanner(System.in);
	}
	
	public static boolean validate(final String ip) {
	 	String PATTERN = 
	 			"^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
	    return ip.matches(PATTERN);
	}
	
	
	public static final String INSTRUCTIONS_STRING = ""
			+ "Bienvenue";
	
	public static final String MENUP_STRING = ""
			+ "1. Config DHCP\n"
			+ "2. Config Client\n"
			+ "3. Quitter";

	public static final String MENUDHCP_STRING = ""
			+ "1. Config DHCP\n"
			+ "2. Retour";

	public static final String MENUCLIENT_STRING = ""
			+ "1. Choix Du client\n"
			+ "2. Retour\n";
	
	public static final String VUECLIENT_STRING = ""
			+ "1. Vue avec les deux clients\n"
			+ "2. Retour";

	public static final String MENUCHOIXCLIENT_STRING = ""
			+ "1. Client 1\n"
			+ "2. Client 2\n"
			+ "3. Retour";

	public static final String MENUDORA_STRING = ""
			+ "1. Procédure DORA\n"
			+ "2. Retour\n";
	
	private boolean stopRead = false;
	
	private void printMenuP() {
		
		show(INSTRUCTIONS_STRING);
		show(MENUP_STRING);
	}

	public static void show(String string) {
		
		System.out.println(string);
		
	}
	
	/**
	 * demande à l'utilisateur de confirmer son choix
	 * @param msg : message de confirmation
	 * @return boolean
	 */
	private boolean confirmer(String msg) {
		this.show(msg + " [O/N]");
		while (true) {
			switch(scan.next().toUpperCase()) {
			case "O":
				return true;
				
			case "N":
				return false;
				
			default:
				this.show("Veuillez entrez [O] Oui  ou [N] Non");	
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		
		while(!stopRead) {
			
			String ipRouter = "";
			int masque = 33;
			String ipDNS = "";
			
			// REQUEST THE NUMBER OF HOSTS NEEDED TO THE USER
			boolean inMenuP = true;
			boolean inMenuDHCP = false;
			boolean inMenuClient = false;
			boolean isVueClient = false;
			boolean inMenuChoixClient = false;
			boolean inMenuDORA = false;
			boolean isIpRouterOk = false;
			boolean isMasqueOk = false;
			boolean isIpDNSOk = false;
			
			while(inMenuP) {
				printMenuP();
				switch(scan.nextInt()) {
					case 1: 
						show(MENUDHCP_STRING);
						inMenuP = false;
						inMenuDHCP = true;
						break;
					case 2: 
						show(MENUCLIENT_STRING);
						inMenuP = false;
						inMenuClient = true;
						break;
					case 3: System.exit(0);
					default: System.out.println("Mauvaise entrée.");
				}
			}
			while(inMenuDHCP) {
				switch(scan.nextInt()) {
					case 1:
						try {
							wait(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						inMenuDHCP = false;
						break;
					case 2: 
						show(MENUP_STRING);
						inMenuP = true;
						inMenuDHCP = false;
						break;
					default: System.out.println("Mauvaise entrée.");
				}
			}
			
			while(inMenuClient) {
				switch(scan.nextInt()) {
					case 1:
						show(MENUCHOIXCLIENT_STRING);
						inMenuClient = false;
						inMenuChoixClient = true;
						break;
					case 2: 
						show(MENUP_STRING);
						inMenuP = true;
						inMenuClient = false;
						break;
					default: System.out.println("Mauvaise entrée.");
				}
			}
			while(inMenuChoixClient) {
				switch(scan.nextInt()) {
					case 1:
						show(MENUDORA_STRING);
						client = 1;
						inMenuClient = false;
						break;
					case 2:
						show(MENUDORA_STRING);
						client = 2;
						inMenuClient = false;
						break;
					case 3: 
						show(MENUCLIENT_STRING);
						inMenuClient = true;
						inMenuChoixClient = false;
						client = 0;
						break;
					default: System.out.println("Mauvaise entrée.");
				}
			}
			while(inMenuDORA) {
				switch(scan.nextInt()) {
					case 1:
						try {
							wait(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						inMenuDORA = false;
						break;
					case 2: 
						show(MENUCHOIXCLIENT_STRING);
						inMenuChoixClient = true;
						inMenuDORA = false;
						break;
					default: System.out.println("Mauvaise entrée.");
				}
			}
			
			while (!isIpRouterOk) {
				show("Veillez entrez l'adresse IP du routeur sous forme \"xxx.xxx.xxx.xxx\" ");
				try {
					ipRouter = scan.nextLine();
					if (validate(ipRouter)) {
						if(isIpRouterOk = confirmer("Confirmez-vous l'adresse IP suivante pour le routeur ? : " + ipRouter)) {
							show("Adresse IP du routeur confirmée !\n");
						} 
					} else {
						show("Veuillez entrer une Adresse IP correcte !\n");
					}
				} catch (InputMismatchException e) {
					show("Veuillez entrer une Adresse IP correcte !\n");
					scan.nextLine();
				}
				
			}
			while (!isMasqueOk) {
				show("Veillez entrez le masque de sous réseau entre 0 et 32");
				try {
					masque = scan.nextInt();
					if (masque >=0 && masque < 33) {
						if(isMasqueOk = confirmer("Confirmez-vous le masque de sous réseau suivant ? : " + masque)) {
							show("Adresse IP du routeur confirmée !\n");
						} 
					} else {
						show("Le masque de sous réseau doit être compris entre 0 et 32 !\n");
					}
				} catch (InputMismatchException e) {
					show("Veuillez entrer un masque de sous réseau correct !\n");
					scan.nextInt();
				}
				
			}
			while (!isIpDNSOk) {
				show("Veillez entrez l'adresse IP du DNS sous forme \"xxx.xxx.xxx.xxx\" ");
				try {
					ipDNS = scan.nextLine();
					if (validate(ipDNS)) {
						if(isIpDNSOk = confirmer("Confirmez-vous l'adresse IP suivante pour le DNS ? : " + ipDNS)) {
							show("Adresse IP du routeur confirmée !\n");
						} 
					} else {
						show("Veuillez entrer une Adresse IP correcte !\n");
					}
				} catch (InputMismatchException e) {
					show("Veuillez entrer une Adresse IP correcte !\n");
					scan.nextLine();
				}
				
			}
			stopRead = true;
		}
	}		
}
