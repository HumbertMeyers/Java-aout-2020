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
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

/**
 * @author Humbert Meyers
 *
 */
public class GUI implements ActionListener, Observer {

	private DhcpController controller;
	
	private JFrame frame;
	private JPanel Client_1;
	private JPanel Client_2;
	private JPanel Menu;
	
	private JButton vue_DHCP;
	private JButton vue_Clients;
	private JButton exitButton;
	
	private JTextField Infos_Client1;
	private JTextField Infos_Client2;
	private JButton newIpBoutton_1;
	private JButton newIpBoutton_2;
	private JPanel log_1;
	private JPanel log_2;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JButton Accepter_1;
	private JButton Accepter_2;
	private JButton retourBoutton;
	
	JOptionPane popUpIP;
	private JPanel MenuDHCP;
	private JTextField textField;
	private JLabel routeur;
	private JTextField textField_1;
	private JLabel masque;
	private JTextField textField_2;
	private JButton enregistreDHCP;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
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
	 * affiche une popUp lorsque la création d'une adresse ip est faite.
	 * @param MsgCréationIp
	 */
	public void show(String MsgCréationIp) {
		JOptionPane.showMessageDialog(null, MsgCréationIp, "Retour création IP", JOptionPane.INFORMATION_MESSAGE);
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
		
		
		retourBoutton = new JButton("Retour Menu");
		retourBoutton.addActionListener(this);
		
		
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
		
		vue_Clients.addActionListener(this);
		
		exitButton.addActionListener(this);
		retourBoutton.setBounds(688, 719, 131, 23);
		frame.getContentPane().add(retourBoutton);
		retourBoutton.setVisible(false);		
		
		MenuDHCP = new JPanel();
		MenuDHCP.setBounds(0, 0, 829, 753);
		frame.getContentPane().add(MenuDHCP);
		MenuDHCP.setLayout(null);
		
		textField = new JTextField("");
		textField.setBounds(321, 199, 123, 23);
		MenuDHCP.add(textField);
		textField.setColumns(10);
		
		JLabel DNS = new JLabel("DNS");
		DNS.setBounds(185, 202, 93, 14);
		MenuDHCP.add(DNS);
		
		routeur = new JLabel("Routeur");
		routeur.setBounds(185, 247, 93, 14);
		MenuDHCP.add(routeur);
		
		textField_1 = new JTextField("");
		textField_1.setColumns(10);
		textField_1.setBounds(321, 244, 123, 23);
		MenuDHCP.add(textField_1);
		
		masque = new JLabel("Masque");
		masque.setBounds(185, 290, 46, 14);
		MenuDHCP.add(masque);
		
		textField_2 = new JTextField("");
		textField_2.setBounds(321, 286, 123, 23);
		MenuDHCP.add(textField_2);
		textField_2.setColumns(10);
		
		enregistreDHCP = new JButton("Enregistrer");
		enregistreDHCP.addActionListener(this);
		enregistreDHCP.setBounds(321, 365, 123, 23);
		MenuDHCP.add(enregistreDHCP);
		
		lblNewLabel = new JLabel("ex : 192.168.1.1");
		lblNewLabel.setBounds(483, 201, 110, 14);
		MenuDHCP.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("ex : 192.168.1.1");
		lblNewLabel_1.setBounds(483, 247, 110, 14);
		MenuDHCP.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("ex : 24 pour un /24");
		lblNewLabel_2.setBounds(483, 290, 110, 14);
		MenuDHCP.add(lblNewLabel_2);
		MenuDHCP.setVisible(false);
		
		
		Client_1 = new JPanel();
		Client_1.setBackground(Color.WHITE);
		Client_1.setBounds(10, 10, 809, 330);
		frame.getContentPane().add(Client_1);
		Client_1.setLayout(null);
		Client_1.setVisible(false);
		
		Client_2 = new JPanel();
		Client_2.setBackground(Color.WHITE);
		Client_2.setBounds(10, 350, 809, 330);
		frame.getContentPane().add(Client_2);
		Client_2.setLayout(null);
		Client_2.setVisible(false);
		
		
		newIpBoutton_1 = new JButton("Nouvelle Adresse IP");
		newIpBoutton_1.addActionListener(this);
		newIpBoutton_1.setBounds(10, 296, 279, 23);
		Client_1.add(newIpBoutton_1);
		
		log_1 = new JPanel();
		log_1.setBorder(new TitledBorder(null, "Console avec le serveur", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		log_1.setBounds(10, 11, 279, 274);
		Client_1.add(log_1);
		log_1.setLayout(null);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 22, 259, 241);
		log_1.add(textArea_1);
		
		Infos_Client1 = new JTextField();
		Infos_Client1.setEditable(false);
		Infos_Client1.setBounds(328, 11, 471, 274);
		Client_1.add(Infos_Client1);
		Infos_Client1.setColumns(10);
		
		Accepter_1 = new JButton("Accepter");
		Accepter_1.addActionListener(this);
		Accepter_1.setBounds(710, 296, 89, 23);
		Client_1.add(Accepter_1);
		
		newIpBoutton_2 = new JButton("Nouvelle Adresse IP");
		newIpBoutton_2.addActionListener(this);
		newIpBoutton_2.setBounds(10, 296, 279, 23);
		Client_2.add(newIpBoutton_2);
		
		log_2 = new JPanel();
		log_2.setBorder(new TitledBorder(null, "Console avec le serveur", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		log_2.setBounds(10, 11, 279, 274);
		Client_2.add(log_2);
		log_2.setLayout(null);
		
		textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setBounds(10, 22, 259, 241);
		log_2.add(textArea_2);
		
		Infos_Client2 = new JTextField();
		Infos_Client2.setEditable(false);
		Infos_Client2.setBounds(328, 11, 471, 274);
		Client_2.add(Infos_Client2);
		Infos_Client2.setColumns(10);
		
		Accepter_2 = new JButton("Accepter");
		Accepter_2.addActionListener(this);
		Accepter_2.setBounds(710, 296, 89, 23);
		Client_2.add(Accepter_2);

	}
	
	/**
	 * Les actions lorsqu'on clique sur un bouton
	 */
	public void actionPerformed(ActionEvent e) {
		Object  source = e.getSource();
	    if  (source == vue_DHCP){
	    	MenuDHCP.setVisible(true);
	    	Client_1.setVisible(false);
			Client_2.setVisible(false);
			
			Menu.setVisible(false);
			vue_Clients.setEnabled(true);
			retourBoutton.setVisible(true);
	    }
	    else if (source == vue_Clients) {
	    	Client_1.setVisible(true);
			Client_2.setVisible(true);
			Menu.setVisible(false);
			retourBoutton.setVisible(true);
	    }
	    else if (source == exitButton) {
	    	System.exit(0);
	    }
	    else if (source == retourBoutton) {
	    	Menu.setVisible(true);
	    	MenuDHCP.setVisible(false);
	    	Client_1.setVisible(false);
			Client_2.setVisible(false);
			retourBoutton.setVisible(false);
	    }
	    else if (source == newIpBoutton_1) {
	    	int result = DhcpController.model.doraDemande();
	    	System.out.println(result);
	    }
	    else if (source == newIpBoutton_2) {
	    	int result = DhcpController.model.doraDemande();
	    	System.out.println(result);
	    }
	    else if (source == enregistreDHCP) {
	    	controller.enregistrerDhcpConfig(textField.getText(),textField_1.getText(), textField_2.getText());
	    	show("Bien enregistré");
	    }	    
	    else if (source == Accepter_1) {
	    	
	    }
	    else if (source == Accepter_2) {
	    }
	    else {}
	}

	public void addObserver(Observer obs) {
		
	}
	public void removeObserver() {
		
	}
	public void notifyObserver(String str) {
	}
	
	public void update(String str) {
		Infos_Client1.setText(Infos_Client1.getText() + "\n" + str);
	}
}
