/**
 * 
 */
package model;

import java.util.Observable;

/**
 * @author Humbert Meyers
 *
 */
public class ModelDHCP extends Observable {
	
	private DHCP dhcp;

	/**
	 * 
	 */
	public ModelDHCP() {
		this.dhcp = new DHCP();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
