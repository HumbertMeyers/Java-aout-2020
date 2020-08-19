/**
 * 
 */
package view;

import controller.DhcpController;
import model.ModelDHCP;
import model.Observer;
import model.Observable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Panel;
import java.awt.Window;

import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

/**
 * @author Humbert Meyers
 *
 */
public class GUI extends SerieTemps implements ActionListener, Observer {
	
	
	/**
	 * @param text
	 * @return
	 */
	
	private DhcpController controller;
	
	private JFrame frame;
	private JPanel Menu;
	private JPanel MenuDHCP;
	private JPanel Client_1;
	private JPanel Client_2;
	private JPanel log_1;
	private JPanel log_2;
	
	private JButton vue_DHCP;
	private JButton vue_Clients;
	private JButton exitButton;
	private JButton newIpButton_1;
	private JButton newIpButton_2;
	private JButton Accepter_1;
	private JButton Accepter_2;
	private JButton retourButton;
	private JButton enregistreDHCP;
	private JButton ClearDHCP;
	
	private JTextArea Infos_Client1;
	private JTextArea Infos_Client2;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	
	private JTextField inputDNS;
	private JTextField inputRouter;
	private JTextField inputMasque;

	private JLabel DNS;
	private JLabel routeur;
	private JLabel masque;
	private JLabel exempleDNS;
	private JLabel exempleRouter;
	private JLabel exempleMasque;

	public JOptionPane popUpIP;

	private JButton GetTemps;

	/**
	 * Create the application.
	 * @param controller le controller
	 */
	public GUI(DhcpController controller) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					this.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		this.controller = controller;
		frame = new JFrame();
		this.frame.setVisible(true);
		initialize();
	}
	
	/**
	 * affiche une popUp informative.
	 * @param MsgCréationIp le message à afficher dans la popUp informative
	 */
	public void show(String MsgCréationIp) {
		JOptionPane.showMessageDialog(null, MsgCréationIp, "Pop-Up informative", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		frame.setBounds(100, 100, 845, 792);
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Simulateur ludique d'un DHCP");
		
		popUpIP = new JOptionPane();
		
		
		Menu = new JPanel();
		Menu.setBounds(0, 0, 829, 753);
		frame.getContentPane().add(Menu);
		Menu.setLayout(null);
		
		vue_DHCP = new JButton("Config DHCP");
		vue_DHCP.setBounds(322, 282, 163, 23);
		Menu.add(vue_DHCP);
		
		vue_DHCP.addActionListener(this);
		
		vue_Clients = new JButton("Config Client");
		vue_Clients.setBounds(322, 316, 163, 23);
		vue_Clients.setEnabled(false);
		Menu.add(vue_Clients);
		
		exitButton = new JButton("Quitter");
		exitButton.setBounds(322, 351, 163, 23);
		Menu.add(exitButton);
		
		GetTemps = new JButton("Retourner la SerieTemps");
		GetTemps.addActionListener(this);
		GetTemps.setBounds(322, 385, 163, 23);
		Menu.add(GetTemps);
		
		vue_Clients.addActionListener(this);
		
		exitButton.addActionListener(this);
		
		
		retourButton = new JButton("Retour Menu");
		retourButton.addActionListener(this);
		retourButton.setBounds(688, 719, 131, 23);
		frame.getContentPane().add(retourButton);
		retourButton.setVisible(false);		
		
		MenuDHCP = new JPanel();
		MenuDHCP.setBounds(0, 0, 829, 753);
		frame.getContentPane().add(MenuDHCP);
		MenuDHCP.setLayout(null);
		
		inputDNS = new JTextField("");
		inputDNS.setBounds(321, 199, 123, 23);
		MenuDHCP.add(inputDNS);
		inputDNS.setColumns(10);
		
		DNS = new JLabel("DNS");
		DNS.setBounds(185, 202, 93, 14);
		MenuDHCP.add(DNS);
		
		routeur = new JLabel("Routeur");
		routeur.setBounds(185, 247, 93, 14);
		MenuDHCP.add(routeur);
		
		inputRouter = new JTextField("");
		inputRouter.setColumns(10);
		inputRouter.setBounds(321, 244, 123, 23);
		MenuDHCP.add(inputRouter);
		
		masque = new JLabel("Masque");
		masque.setBounds(185, 290, 46, 14);
		MenuDHCP.add(masque);
		
		inputMasque = new JTextField("");
		inputMasque.setBounds(321, 286, 123, 23);
		MenuDHCP.add(inputMasque);
		inputMasque.setColumns(10);
		
		enregistreDHCP = new JButton("Enregistrer");
		enregistreDHCP.addActionListener(this);
		enregistreDHCP.setBounds(321, 365, 123, 23);
		MenuDHCP.add(enregistreDHCP);
		
		exempleDNS = new JLabel("ex : 192.168.1.1");
		exempleDNS.setBounds(483, 201, 110, 14);
		MenuDHCP.add(exempleDNS);
		
		exempleRouter = new JLabel("ex : 192.168.1.1");
		exempleRouter.setBounds(483, 247, 110, 14);
		MenuDHCP.add(exempleRouter);
		
		exempleMasque = new JLabel("ex : 24 pour un /24");
		exempleMasque.setBounds(483, 290, 110, 14);
		MenuDHCP.add(exempleMasque);
		
		ClearDHCP = new JButton("Reinitialiser DHCP");
		ClearDHCP.addActionListener(this);
		ClearDHCP.setBounds(321, 418, 123, 23);
		MenuDHCP.add(ClearDHCP);
		MenuDHCP.setVisible(false);
		
		
		Client_1 = new JPanel();
		Client_1.setBackground(Color.WHITE);
		Client_1.setBounds(10, 10, 809, 330);
		frame.getContentPane().add(Client_1);
		Client_1.setLayout(null);
		Client_1.setVisible(false);
		
		
		newIpButton_1 = new JButton("Nouvelle Adresse IP");
		newIpButton_1.addActionListener(this);
		newIpButton_1.setBounds(10, 296, 279, 23);
		Client_1.add(newIpButton_1);
		
		log_1 = new JPanel();
		log_1.setBorder(new TitledBorder(null, "Console avec le serveur", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		log_1.setBounds(10, 11, 279, 274);
		Client_1.add(log_1);
		log_1.setLayout(null);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 22, 259, 241);
		log_1.add(textArea_1);
		
		Infos_Client1 = new JTextArea();
		Infos_Client1.setBackground(Color.LIGHT_GRAY);
		Infos_Client1.setEditable(false);
		Infos_Client1.setBounds(328, 11, 471, 274);
		Client_1.add(Infos_Client1);
		Infos_Client1.setColumns(10);
		
		Accepter_1 = new JButton("Accepter");
		Accepter_1.addActionListener(this);
		Accepter_1.setBounds(710, 296, 89, 23);
		Client_1.add(Accepter_1);
		
		Client_2 = new JPanel();
		Client_2.setBackground(Color.WHITE);
		Client_2.setBounds(10, 350, 809, 330);
		frame.getContentPane().add(Client_2);
		Client_2.setLayout(null);
		Client_2.setVisible(false);
		
		newIpButton_2 = new JButton("Nouvelle Adresse IP");
		newIpButton_2.addActionListener(this);
		newIpButton_2.setBounds(10, 296, 279, 23);
		Client_2.add(newIpButton_2);
		
		log_2 = new JPanel();
		log_2.setBorder(new TitledBorder(null, "Console avec le serveur", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		log_2.setBounds(10, 11, 279, 274);
		Client_2.add(log_2);
		log_2.setLayout(null);
		
		textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setBounds(10, 22, 259, 241);
		log_2.add(textArea_2);
		
		Infos_Client2 = new JTextArea();
		Infos_Client2.setBackground(Color.LIGHT_GRAY);
		Infos_Client2.setEditable(false);
		Infos_Client2.setBounds(328, 11, 471, 274);
		Client_2.add(Infos_Client2);
		Infos_Client2.setColumns(10);
		
		Accepter_2 = new JButton("Accepter");
		Accepter_2.addActionListener(this);
		Accepter_2.setBounds(710, 296, 89, 23);
		Client_2.add(Accepter_2);

	}
	
	public void afficheInfoIPClient(int clientNum, String res) {
		if (clientNum == 1) {
			textArea_1.setText(res);
		}
		if (clientNum == 2) {
			textArea_2.setText(res);
		}
	}
	
	public void update(String str) {
		Infos_Client1.setText(str);
	}
	
	/**
	 * Les actions lorsqu'on clique sur un bouton
	 */
	public void actionPerformed(ActionEvent e) {
		Object  source = e.getSource();
		addEvent(((AbstractButton) source).getText());
	    if  (source == vue_DHCP){
	    	MenuDHCP.setVisible(true);
	    	Client_1.setVisible(false);
			Client_2.setVisible(false);
			
			Menu.setVisible(false);
			vue_Clients.setEnabled(true);
			retourButton.setVisible(true);
	    }
	    else if (source == vue_Clients) {
	    	Client_1.setVisible(true);
			Client_2.setVisible(true);
			Menu.setVisible(false);
			retourButton.setVisible(true);
	    }
	    else if (source == exitButton) {
	    	System.exit(0);
	    }
	    else if (source == retourButton) {
	    	Menu.setVisible(true);
	    	MenuDHCP.setVisible(false);
	    	Client_1.setVisible(false);
			Client_2.setVisible(false);
			retourButton.setVisible(false);
	    }
	    else if (source == newIpButton_1) {
	    	String result = controller.model.doraDemande();
	    	afficheInfoIPClient(1 ,result);
	    	System.out.println(result);
	    }
	    else if (source == newIpButton_2) {
	    	String result = controller.model.doraDemande();
	    	afficheInfoIPClient(2, result);
	    	System.out.println(result);
	    }
	    else if (source == enregistreDHCP) {
	    	int res = controller.enregistrerDhcpConfig(inputDNS.getText(),inputRouter.getText(), inputMasque.getText());
	    	if(res == 0) { show("Bien enregistré"); }
	    	if(res == 1) { 
	    		show("config DHCP non enregistrée car problème avec le dns ou le router");
	    		inputDNS.setText("");
	    		inputRouter.setText("");
	    		inputMasque.setText("");	
	    	}
	    	if(res==2) {show("Catch enregistrer config DHCP\nLa configuration par défaut est prise car vous n'avez rien défini");}
	    }
	    else if (source == ClearDHCP){
	    	controller.viderDHCP();
	    	controller.enregistrerDhcpConfig(inputDNS.getText(),inputRouter.getText(), inputMasque.getText());
	    	Infos_Client1.setText("");
	    	Infos_Client2.setText("");
	    }
	    else if (source == Accepter_1) {
	    	if(textArea_1.getText().equals(Infos_Client2.getText())) {
	    		Infos_Client1.setText("Un autre ordinateur possède déjà cette ip");
	    	}else {
	    		Infos_Client1.setText(textArea_1.getText());
	    	}
	    }
	    else if (source == Accepter_2) {
	    	if(textArea_2.getText().equals(Infos_Client1.getText())) {
	    		Infos_Client2.setText("Un autre ordinateur possède déjà cette ip");
	    	}else {
	    		Infos_Client2.setText(textArea_2.getText());
	    	}
	    }
	    else if(source == GetTemps) {
    		show(this.toString());
    	}
	}
}
