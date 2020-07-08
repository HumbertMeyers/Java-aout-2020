/**
 * 
 */
package model;

import java.util.Arrays;

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
	 * Le masque de sous-r�seau (pouvant aller de 0 � 32).
	 */
	protected int masque;
	
	
	/**
	 * Ce constructeur initialise une adresse IP � 0.0.0.0 avec un masque 0.
	 */
	public IP() {
		this.ipAdr = new int[]{0x00,0x00,0x00,0x00};
		this.masque = 0;
	}
	
	
	/**
	 * Ce constructeur initialise une adresse IP avec les param�tres addr et masque.
	 * @param addr : l'adresse IP re�ue en param�tre.
	 * @param masque : le masque de r�seau re�u en param�tre.
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

	/**
	 * Cette fonction retourne l'adresse IP.
	 * @return l'adresse IP sous forme de string dans le format "xxx.xxx.xxx.xxx".
	 */
	public String getIpAdr() {
		return Arrays.toString(ipAdr)
				.replace(",", ".")
				.replace("[", "")
				.replace("]", "");
	}


	/**
	 * Cette fonction permet de mettre une nouvelle adresse IP.
	 * @param addr : l'adresse IP � initialiser.
	 */
	public void setIpAdr(int[] addr) {
		this.ipAdr = addr;
	}


	/**
	 * Cette fonction retourne le masque de r�seau.
	 * @return le masque sous forme de string dans le format "xxx.xxx.xxx.xxx".
	 */
	public String getMasque() {
		int[] m = new int[4];
		int tempMasque = this.masque;
		
		for (int i = 0; i < m.length; i++) {
			if(tempMasque == (int) 0) {m[i] = (int) 0;}
			else if(tempMasque > 8) {m[i] = 255;}
			else {m[i] = 256 - (int) Math.pow(2, 8-tempMasque);}
			
			if(tempMasque >= 8){tempMasque -= 8;}
			else{tempMasque -= tempMasque;}
		}
		return Arrays.toString(m)
				.replace(",", ".")
				.replace("[", "")
				.replace("]", "");
	}


	/**
	 * Cette fonction permet de mettre un nouveau masque de sous r�seau.
	 * @param masque : le masque de r�seau � initialiser.
	 */
	public void setMasque(int masque) {
		this.masque = masque;
	}


	/**
	 * Cette fonction est la mise String des propri�t�s de l'adresse IP.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Voici les information concernant votre IP\n" 
				+ "IP:" + getIpAdr() + "\n" 
				+ "Masque" + getMasque();
	}
	
	
	
	
}
