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
	ServerView sv;
	ClientView cv;
	List<String> ipUtilisees;
	

	/**
	 * 
	 */
	public DhcpController(ModelDHCP model) {
		this.model = model;
	}

	public void donneIP(String router, String ip, int masque, String dns) {
		
		model.donneIP(router, ip, masque, dns);
		sv.show("Envoi de la configuration IP effectuée.");
		
		if(!ipUtilisees.contains(router)) {setIpUtilisee(router);}
		if(!ipUtilisees.contains(dns)) {setIpUtilisee(dns);}
		setIpUtilisee(ip);
		
	}
	
	void setIpUtilisee(String str){
		this.ipUtilisees.add(str);
	}
	
	public boolean isIpUtilisee(String ip){
		return (ipUtilisees.contains(ip)) ? true : false;
	}
	
	
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new DhcpController();	
			}
			
		});
	}
}