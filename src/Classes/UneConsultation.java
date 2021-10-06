package Classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import partials.Ecriture;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class UneConsultation {

	static JFrame frame = new JFrame();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5=new JTextField ();;
	private JLabel lblDoses;
	private JTextField textField_6;
	private JTextField textField_7=new JTextField ();;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12=new JTextField ();;
	private JTextField textField_13=new JTextField ();;
	private JTextField textField_14=new JTextField ();;
	private JTextField textField_15;
	private JLabel lblMdicaments_1;
	private JLabel lblDoses_1;
	private JLabel lblCommentaire;
	private JLabel lblNewLabel;
	private JTextField textField_17;
	private JButton btnTraitement;


	/**
	 * Create the application.
	 */
	public UneConsultation() {
		
		Traitement.base.getOracleComment();
		Fenetre(550,550,550,550,frame);
		initialize();
		fond();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {

		
		JLabel lblMaladieDiagnostiques = new JLabel("Maladie diagnostiquées:");
		lblMaladieDiagnostiques.setBounds(181, 51, 187, 15);
		frame.getContentPane().add(lblMaladieDiagnostiques);
		
		textField = new Ecriture("Saisir le texte...");
		textField.setBounds(72, 98, 157, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new Ecriture("Saisir le texte...");
		textField_1.setColumns(10);
		textField_1.setBounds(307, 98, 157, 28);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new Ecriture("Saisir le texte...");
		textField_2.setColumns(10);
		textField_2.setBounds(72, 138, 157, 28);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new Ecriture("Saisir le texte...");
		textField_3.setColumns(10);
		textField_3.setBounds(307, 138, 157, 28);
		frame.getContentPane().add(textField_3);
		
		JLabel lblMdicaments = new JLabel("Médicaments");
		lblMdicaments.setBounds(77, 184, 109, 15);
		frame.getContentPane().add(lblMdicaments);
		
		textField_4 = new Ecriture("/");
		textField_4.setColumns(10);
		textField_4.setBounds(42, 211, 157, 28);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new Ecriture("0");
		textField_5.setColumns(10);
		textField_5.setBounds(211, 211, 53, 28);
		frame.getContentPane().add(textField_5);
		
		lblDoses = new JLabel("Doses");
		lblDoses.setBounds(211, 181, 70, 15);
		frame.getContentPane().add(lblDoses);
		
		textField_6 = new Ecriture("/");
		textField_6.setColumns(10);
		textField_6.setBounds(42, 251, 157, 28);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new Ecriture("0");
		textField_7.setColumns(10);
		textField_7.setBounds(211, 251, 53, 28);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new Ecriture("/");
		textField_8.setColumns(10);
		textField_8.setBounds(276, 211, 157, 28);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new Ecriture("/");
		textField_9.setColumns(10);
		textField_9.setBounds(276, 251, 157, 28);
		frame.getContentPane().add(textField_9);
		
		textField_10 = new Ecriture("/");
		textField_10.setColumns(10);
		textField_10.setBounds(42, 291, 157, 28);
		frame.getContentPane().add(textField_10);
		
		textField_11 = new Ecriture("/");
		textField_11.setColumns(10);
		textField_11.setBounds(276, 291, 157, 28);
		frame.getContentPane().add(textField_11);
		
		textField_12 = new Ecriture("0");
		textField_12.setColumns(10);
		textField_12.setBounds(211, 291, 53, 28);
		frame.getContentPane().add(textField_12);
		
		textField_13 = new Ecriture("0");
		textField_13.setColumns(10);
		textField_13.setBounds(445, 211, 53, 28);
		frame.getContentPane().add(textField_13);
		
		textField_14 = new Ecriture("0");
		textField_14.setColumns(10);
		textField_14.setBounds(445, 251, 53, 28);
		frame.getContentPane().add(textField_14);
		
		textField_15 = new Ecriture("0");
		textField_15.setColumns(10);
		textField_15.setBounds(445, 291, 53, 28);
		frame.getContentPane().add(textField_15);
		
		lblMdicaments_1 = new JLabel("Médicaments");
		lblMdicaments_1.setBounds(307, 181, 109, 15);
		frame.getContentPane().add(lblMdicaments_1);
		
		lblDoses_1 = new JLabel("Doses");
		lblDoses_1.setBounds(445, 181, 70, 15);
		frame.getContentPane().add(lblDoses_1);
		
		lblCommentaire = new JLabel("Commentaire");
		lblCommentaire.setBounds(42, 345, 120, 15);
		frame.getContentPane().add(lblCommentaire);
		
		lblNewLabel = new JLabel("Montant payé:");
		lblNewLabel.setBounds(42, 400, 120, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField_17 = new  Ecriture("...,00 DA");
		textField_17.setBounds(167, 394, 150, 28);
		frame.getContentPane().add(textField_17);
		textField_17.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
	  				public void run() {
	  					try {
	  						@SuppressWarnings("unused")
							UneConsultation window = new UneConsultation();
	  						UneConsultation.frame.setVisible(false);
	  					} catch (Exception e) {
	  						e.printStackTrace();
	  					}
	  				}});
			}
		});
		btnNewButton_1.setBounds(428, 469, 101, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		btnTraitement = new JButton("Traitement");
		btnTraitement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

	  						@SuppressWarnings("unused")
							Traitement window = new Traitement();
							Traitement.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnTraitement.setBounds(22, 469, 157, 39);
		frame.getContentPane().add(btnTraitement);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(163, 340, 118, 24);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"/", "positive", "negative"}));
		
		frame.getContentPane().add(comboBox);
		
		JButton btnAppliquer = new JButton("Appliquer");
		btnAppliquer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float x=Float.parseFloat(textField_5.getText());
				float y=Float.parseFloat(textField_7.getText());
				float z=Float.parseFloat(textField_12.getText());
				float t=Float.parseFloat(textField_13.getText());
				float w=Float.parseFloat(textField_14.getText());
				float u=Float.parseFloat(textField_15.getText());
				int v= Integer.parseInt(textField_17.getText());

			Traitement.base.insertTable(Traitement.table, textField_4.getText(), x, 
			textField_6.getText(), y, textField_10.getText(), z, textField_8.getText(), t, textField_9.getText(), w, textField_11.getText(), u);
			
			Consultation.base1.insertTable(Medecin.table,dateinscription(523, 37,frame), textField.getText(), textField_1.getText(), textField_2.getText(),
					textField_4.getText(), comboBox.getSelectedItem().toString(), v);
			}
		});
		btnAppliquer.setBounds(296, 469, 120, 39);
		frame.getContentPane().add(btnAppliquer);
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
        JLabel lblNewLabel3 = new JLabel(" ");
        lblNewLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel3.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel3.setForeground(Color.BLACK);
        lblNewLabel3.setIcon(new ImageIcon(img3));
        lblNewLabel3.setBounds(0, -200, 700, 726);
        frame.getContentPane().add(lblNewLabel3);
	}
	
	/*DATE D'INSCRIPTION*/
	public String dateinscription(int x, int y,JFrame frame) {
	Date aujourdhui = new Date();
    DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
        DateFormat.SHORT,
        DateFormat.SHORT);
    return  ""+shortDateFormat.format(aujourdhui);

	}
	
}
