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
	 * Le masque de sous-réseau (pouvant aller de 0 à 32).
	 */
	protected int masque;
	
	/**
	 * Ce constructeur initialise une adresse IP de type APIPA (169.254.x.x avec comme masque 255.255.0.0).
	 * @param masque un int compris entre 0 et 32
	 */
	public IP(int masque) {
		
		this.ipAdr = new int[] {1,1,1,1};
		for (int i = 0; i <= 3; i++){
	        this.ipAdr[i]= (int)(Math.random()*255);
	    }

		this.masque = masque;	
	}
	
	/**
	 * Ce constructeur initialise une adresse IP de type APIPA (169.254.x.x avec comme masque 255.255.0.0).
	 */
	public IP() {
		
		this.ipAdr = new int[] {169,254,1,1};
		
		for (int i = 2; i <= 2 ; i++){
	        this.ipAdr[i]= (int)(Math.random()*255);
	    }
		for (int i = 3; i <= 3 ; i++){
	        this.ipAdr[i]= (int)(Math.random()*253)+1;
	    }
		this.masque = 16;	
	}
	
	/**
	 * Ce constructeur initialise une adresse IP avec les paramètres addr et masque.
	 * @param addr : l'adresse IP reçue en paramètre.
	 */
	public IP(String addr) {
		String[] ipArray;
		ipArray = addr.split("\\.");
		this.ipAdr = new int[] {
				Integer.parseInt(ipArray[0]),
				Integer.parseInt(ipArray[1]),
				Integer.parseInt(ipArray[2]),
				Integer.parseInt(ipArray[3])
		};
	}
	
	/**
	 * Ce constructeur initialise une adresse IP avec les paramètres addr et masque.
	 * @param addr : l'adresse IP reçue en paramètre.
	 * @param masque : le masque de réseau reçu en paramètre.
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
				.replace("]", "")
				.replace(" ", "");
	}


	/**
	 * Cette fonction permet de mettre une nouvelle adresse IP.
	 * @param addr : l'adresse IP à initialiser.
	 */
	public void setIpAdr(int[] addr) {
		this.ipAdr = addr;
	}


	/**
	 * Cette fonction retourne le masque de réseau.
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
				.replace("]", "")
				.replace(" ", "");
	}
	
	/**
	 * Transforme un masque sous forme de String "xxx.xxx.xxx.xxx" en Integer
	 * @param masque string sous forme "xxx.xxx.xxx.xxx"
	 * @return un integer
	 */
	public int getMasqueInt(String masque) {
		int masqueInt = 0;
		String byteStr = "";
		String[] ipArray;
		ipArray = masque.split("\\.");
		int[] tab = 
				new int[] {
				Integer.parseInt(ipArray[0]),
				Integer.parseInt(ipArray[1]),
				Integer.parseInt(ipArray[2]),
				Integer.parseInt(ipArray[3])
		}; 
		for (int i = 0; i <= 3; i++) {
			byte byt = (byte) tab[i]; //129
			byteStr += String.format("%8s", Integer.toBinaryString(byt & 0xFF)).replace(' ', '0'); // 10000001
		}
		
		for (int i=0; i < 32; i++) {
			int j = Character.getNumericValue(byteStr.charAt(i));
			masqueInt += j;
		}
		System.out.println(masqueInt);
		return masqueInt;
	}


	/**
	 * Cette fonction permet de mettre un nouveau masque de sous réseau.
	 * @param masque : le masque de réseau à initialiser.
	 */
	public void setMasque(int masque) {
		this.masque = masque;
	}


	/**
	 * Cette fonction est la mise String des propriétés de l'adresse IP.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Voici les informations concernant votre IP\n" 
				+ "IP: " + getIpAdr() + "\n" 
				+ "Masque : " + getMasque();
	}
	
	/*public static void main(String[] args) {
		
		IP adresse1 = new IP("192.168.1.2",24);
		System.out.println(adresse1.toString());
		IP adresse2 = new IP("192.168.1.254", 16);
		System.out.println(adresse2.toString());
		IP adresse3 = new IP("192.168.1.2", 7);
		System.out.println(adresse3.toString());
		IP apipa1 = new IP();
		System.out.println(apipa1.toString());
		IP apipa2 = new IP();
		System.out.println(apipa2.toString());
		IP apipa3 = new IP();
		System.out.println(apipa3.toString());
	}*/
	
}
