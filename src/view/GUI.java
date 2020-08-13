/**
 * 
 */
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
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
import java.awt.FlowLayout;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Humbert Meyers
 *
 */
public class GUI {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 845, 792);
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Menu = new JPanel();
		Menu.setBounds(0, 0, 829, 753);
		frame.getContentPane().add(Menu);
		Menu.setLayout(null);
		
		JButton Vue_Clients = new JButton("Voir les clients");
		Vue_Clients.setBounds(322, 316, 163, 23);
		Menu.add(Vue_Clients);
		
		JButton ExitButton = new JButton("Quitter");
		ExitButton.setBounds(322, 351, 163, 23);
		Menu.add(ExitButton);
		
		
		JPanel Client_1 = new JPanel();
		Client_1.setBackground(Color.WHITE);
		Client_1.setBounds(10, 10, 809, 330);
		frame.getContentPane().add(Client_1);
		Client_1.setLayout(null);
		Client_1.setVisible(false);
		
		JPanel Client_2 = new JPanel();
		Client_2.setBackground(Color.WHITE);
		Client_2.setBounds(10, 350, 809, 330);
		frame.getContentPane().add(Client_2);
		Client_2.setLayout(null);
		Client_2.setVisible(false);
		
		
		JButton newIpBoutton_1 = new JButton("Nouvelle Adresse IP");
		newIpBoutton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		newIpBoutton_1.setBounds(10, 296, 129, 23);
		Client_1.add(newIpBoutton_1);
		
		JButton renewIpBoutton_1 = new JButton("Renouveller IP");
		renewIpBoutton_1.setBounds(149, 296, 129, 23);
		Client_1.add(renewIpBoutton_1);
		
		JPanel log_1 = new JPanel();
		log_1.setBorder(new TitledBorder(null, "Console avec le serveur", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		log_1.setBounds(10, 11, 279, 274);
		Client_1.add(log_1);
		log_1.setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 22, 259, 241);
		log_1.add(textArea_1);
		
		
		JButton newIpBoutton_2 = new JButton("Nouvelle Adresse IP");
		newIpBoutton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		newIpBoutton_2.setBounds(10, 296, 129, 23);
		Client_2.add(newIpBoutton_2);
		
		JButton renewIpBoutton_2 = new JButton("Renouveller IP");
		renewIpBoutton_2.setBounds(149, 296, 129, 23);
		Client_2.add(renewIpBoutton_2);
		
		JPanel log_2 = new JPanel();
		log_2.setBorder(new TitledBorder(null, "Console avec le serveur", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		log_2.setBounds(10, 11, 279, 274);
		Client_2.add(log_2);
		log_2.setLayout(null);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setBounds(10, 22, 259, 241);
		log_2.add(textArea_2);
		
		JButton exitBoutton = new JButton("Retour Menu");
		exitBoutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client_1.setVisible(false);
				Client_2.setVisible(false);
				Menu.setVisible(true);
				exitBoutton.setVisible(false);
			}
		});
		exitBoutton.setBounds(688, 719, 131, 23);
		frame.getContentPane().add(exitBoutton);
		exitBoutton.setVisible(false);
		
		Vue_Clients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client_1.setVisible(true);
				Client_2.setVisible(true);
				Menu.setVisible(false);
				exitBoutton.setVisible(true);
			}
		});
		
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	
}
