/**
 * 
 */
package controller;

import java.awt.EventQueue;

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

	/**
	 * 
	 */
	public DhcpController() {
		this.model = new ModelDHCP();
		this.sv = new ServerView();
		this.cv = new ClientView();
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