/**
 * 
 */
package view;

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
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import controller.DhcpController;
import model.ModelDHCP;

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
@SuppressWarnings("deprecation")
public class GUI implements ActionListener, Observer {

	private JFrame frame;
	private JTextField Infos_Client2;
	private JTextField Infos_Client1;
	private JPanel Client_1;
	private JPanel Client_2;
	private JPanel Menu;
	private JButton vue_Clients;
	private JButton exitButton;
	
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
	private JButton vue_DHCP;
	
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
	public GUI() {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					this.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		frame = new JFrame();
		this.frame.setVisible(true);
		initialize();
	}
	
	public void show(String MsgCréationIp) {
		popUpIP.showMessageDialog(null, MsgCréationIp, "Retour création IP", JOptionPane.INFORMATION_MESSAGE);
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
		Menu.add(vue_Clients);
		
		exitButton = new JButton("Quitter");
		exitButton.setBounds(322, 351, 163, 23);
		Menu.add(exitButton);
		
		vue_Clients.addActionListener(this);
		
		exitButton.addActionListener(this);
		
		
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
		
		
		retourBoutton = new JButton("Retour Menu");
		retourBoutton.addActionListener(this);
		retourBoutton.setBounds(688, 719, 131, 23);
		frame.getContentPane().add(retourBoutton);
		retourBoutton.setVisible(false);		

	}
	
	public void actionPerformed(ActionEvent e) {
		Object  source = e.getSource();
	    if  (source == vue_DHCP){
	    	DhcpController.changerVue("vueDHCP");
	    }
	    else if (source == retourBoutton) {
	    }
	    else if (source == vue_Clients) {
	    	Client_1.setVisible(true);
			Client_2.setVisible(true);
			Menu.setVisible(false);
			retourBoutton.setVisible(true);
			DhcpController.changerVue("vueClient");
	    }
	    else if (source == exitButton) {
	    	System.exit(0);
	    }
	    else if (source == retourBoutton) {
	    	Client_1.setVisible(false);
			Client_2.setVisible(false);
			Menu.setVisible(true);
			retourBoutton.setVisible(false);
	    }
	    else if (source == newIpBoutton_1) {
	    	int result = DhcpController.model.donneIP("192.168.1.1", "192.168.1.2", 24, "1.1.1.1");
	    	System.out.println(result);
	    }
	    else if (source == vue_Clients) {
	    }
	    else if (source == vue_Clients) {
	    }
	    else if (source == vue_Clients) {
	    }
	    else {}
	}

	public void addObserver(Observer obs) {
		
	}
	public void removeObserver() {
		
	}
	public void notifyObserver(String str) {
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		frame.pack();
		if (o instanceof ModelDHCP && "newIpBoutton_1".equals(arg)) {
			show("Yeh !!");
        }
	}
}
