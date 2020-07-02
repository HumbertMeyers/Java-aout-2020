/**
 * 
 */
package model;

/**
 * @author Humbert Meyers
 *
 */

public class IP{

	/**
	 * Une adresse IP sous forme de tableau de bytes.
	 */
	protected int ipAdr[];
	
	/**
	 * Le masque de sous-réseau (pouvant aller de 0 à 32).
	 */
	protected int masque;
	
	
	/**
	 * Ce constructeur initialise une adresse IP à 0.0.0.0 avec un masque 0.
	 */
	public IP() {
		this.ipAdr = new int[]{0x00,0x00,0x00,0x00};
		this.masque = 0;
	}
	
	
	/**
	 * Ce constructeur initialise une adresse IP avec les paramètres addr et masque.
	 * @param addr : l'adresse IP reçue en paramètre
	 * @param masque : le masque de réseau reçu en paramètre
	 */
	public IP(String addr, int masque) {
		String[] ipArray;
		ipArray = addr.split("\\.");
		this.ipAdr = new int[] {
				Integer.parseInt(ipArray[0]),
				Integer.parseInt(ipArray[1]),
				Integer.parseInt(ipArray[2]),
				Integer.parseInt(ipArray[3])
		};
		this.masque = masque;
	}
}
