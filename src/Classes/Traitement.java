package Classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import com.projet.BDD.BaseMedicament;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Traitement {

	static JFrame frame=new JFrame();
	static JTable table=new JTable();
	static JTable table1=new JTable();
	private final JButton btnAnnuler = new JButton("Annuler");
	private final JButton btnImprimer = new JButton("Imprimer");
    static BaseMedicament base = new  BaseMedicament();

	/**
	 * Create the application.
	 */
	public Traitement() {
		base.getOracleComment();
		
		Fenetre(700,700,1100,290,frame);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 134, 1076, 38);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table1);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(12, 97, 1076, 38);
		frame.getContentPane().add(scrollPane1);
		scrollPane1.setViewportView(table);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
	  				public void run() {
	  					try {
	  						@SuppressWarnings("unused")
							Traitement window = new Traitement();
	  						Traitement.frame.setVisible(false);
	  					} catch (Exception e) {
	  						e.printStackTrace();
	  					}
	  				}});
			}
		});
	
		btnAnnuler.setBounds(969, 195, 95, 39);	
		frame.getContentPane().add(btnAnnuler);
		
		btnImprimer.setBounds(855, 195, 102, 39);	
		frame.getContentPane().add(btnImprimer);
		
		JRadioButton rdbtnDemandeDanalyse = new JRadioButton("Demande d'analyse");
		rdbtnDemandeDanalyse.setBounds(20, 66, 175, 23);
		frame.getContentPane().add(rdbtnDemandeDanalyse);
		AfficherPatient();
		dateinscription();
		fond();
	}


	/*FENETRE*/
	public void Fenetre(int x,int y, int z, int t,JFrame frame) {
		frame.setBounds(x, y, z, t);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	/*FOND*/
	public void fond() {
		
     	Image img3 = new ImageIcon(this.getClass().getResource("/Images/fon1.png")).getImage();
        
        JButton btnAfficherLeS = new JButton("Afficher les médicaments");
        btnAfficherLeS.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	base.Table(table1);
        	}
        });
        btnAfficherLeS.setBounds(209, 202, 225, 39);
        frame.getContentPane().add(btnAfficherLeS);
        JLabel lblNewLabel3 = new JLabel(" ");
        lblNewLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel3.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel3.setForeground(Color.BLACK);
        lblNewLabel3.setIcon(new ImageIcon(img3));
        lblNewLabel3.setBounds(0, -300, 700, 726);
        frame.getContentPane().add(lblNewLabel3);

		
    	Image img4 = new ImageIcon(this.getClass().getResource("/Images/fon1.png")).getImage();
    	 JLabel lblNewLabel4 = new JLabel(" ");
 		lblNewLabel4.setAlignmentX(Component.CENTER_ALIGNMENT);
 		lblNewLabel4.setVerticalAlignment(SwingConstants.BOTTOM);
 		lblNewLabel4.setForeground(Color.BLACK);
 		lblNewLabel4.setIcon(new ImageIcon(img4));
 		lblNewLabel4.setBounds(500, -300, 700, 726);
 		frame.getContentPane().add(lblNewLabel4);
	}
	
	/*DATE D'INSCRIPTION*/
	public void dateinscription(){
	Date aujourdhui = new Date();
    DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
        DateFormat.SHORT,
        DateFormat.SHORT);
	JLabel lblNewLabel = new JLabel(""+shortDateFormat.format(aujourdhui));
	lblNewLabel.setBounds(900, 20, 900, 15);
	frame.getContentPane().add(lblNewLabel);
	}
	/*AFFICHER LE PATIENT*/
	public void AfficherPatient() {
		JButton btnAfficherLePatient = new JButton("Afficher le patient");
		btnAfficherLePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Medecin.base.Table3(table);
			}
		});
		btnAfficherLePatient.setBounds(26, 202, 161, 39);
		frame.getContentPane().add(btnAfficherLePatient);
	}
}
