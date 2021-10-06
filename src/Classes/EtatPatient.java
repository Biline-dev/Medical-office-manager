package Classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import partials.Ecriture;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EtatPatient {

	static JFrame frame= new JFrame();
	private JTextField textField_2=new JTextField ();
	private JTextField textField_3=new JTextField ();
	private JTextField textField_4=new JTextField ();
	private JTextField textField_11=new JTextField ();
	private JTextField textField_13=new JTextField ();
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox = new JComboBox();
    private JTextField textField;
    private JTextField textField_1;
	public EtatPatient() {
		
		Fenetre(500,330,500,330,frame);

		poid();
		taille();
		tension();
		maladie_cronnique();
		groupe_sanguin();
        Enregistrer();
        Annuler();
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
        JLabel lblNewLabel3 = new JLabel(" ");
        lblNewLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel3.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel3.setForeground(Color.BLACK);
        lblNewLabel3.setIcon(new ImageIcon(img3));
        lblNewLabel3.setBounds(0, -300, 700, 726);
        frame.getContentPane().add(lblNewLabel3);
	}
	/*SAISIR LE POID*/
	public void poid() {
		JLabel lblNewLabel_8 = new JLabel("Poids:");
		lblNewLabel_8.setBounds(34, 36, 51, 15);
		frame.getContentPane().add(lblNewLabel_8);
		textField_2 = new Ecriture("...");
		textField_2.setBounds(103, 30, 40, 28);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
	/*SAISIR LA TENSION*/
	public void tension() {
		JLabel lblNewLabel_11 = new JLabel("Tension:");
		lblNewLabel_11.setBounds(308, 36, 70, 15);
		frame.getContentPane().add(lblNewLabel_11);
		textField_3 = new Ecriture("...");
		textField_3.setBounds(227, 30, 40, 28);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}
	/*SAISIR LA TAILLE*/
     public void taille() {	
	    JLabel lblNewLabel_9 = new JLabel("Taille:");
		lblNewLabel_9.setBounds(161, 36, 70, 15);
		frame.getContentPane().add(lblNewLabel_9);
		textField_4 = new Ecriture("...");
		textField_4.setBounds(396, 30, 40, 28);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
     }
	/*GROUPE SANGUIN*/
     @SuppressWarnings({ "unchecked", "rawtypes" })
	public void groupe_sanguin() {
		JLabel lblNewLabel_10 = new JLabel("Groupe sanguin:");
		lblNewLabel_10.setBounds(227, 85, 122, 15);
		frame.getContentPane().add(lblNewLabel_10);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-"}));
		comboBox.setBounds(365, 78, 71, 28);
		frame.getContentPane().add(comboBox);
     }
    /*SAISIR MALADIECRONIQUE*/
 	public void maladie_cronnique() {
 		JLabel lblNewLabel_12 = new JLabel("Maladies croniques:");
		lblNewLabel_12.setBounds(40, 113, 144, 15);
		frame.getContentPane().add(lblNewLabel_12);
		
		textField_11 = new Ecriture("Saisir le texte...");
		textField_11.setColumns(10);
		textField_11.setBounds(60, 140, 191, 28);
		frame.getContentPane().add(textField_11);
	
		textField_13 = new Ecriture("Saisir le texte...");
		textField_13.setColumns(10);
		textField_13.setBounds(276, 140, 191, 28);
		frame.getContentPane().add(textField_13);
		
        textField_1 = new Ecriture("Saisir le texte...");
        textField_1.setBounds(276, 180, 191, 28);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
    	
		textField = new Ecriture("Saisir le texte...");
		textField.setBounds(60, 180, 191, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	public void Enregistrer() {
	
		
		JButton btnAppliquer = new JButton("Enregistrer les changement");
		btnAppliquer.setBounds(121, 231, 231, 38);
		frame.getContentPane().add(btnAppliquer);	
		
		btnAppliquer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float x=Integer.parseInt(textField_2.getText());
				float y=Integer.parseInt(textField_3.getText());
				float z=Integer.parseInt(textField_4.getText());

				Consultation.base.Etat(Consultation.table, x, y, comboBox.getSelectedItem().toString(),
						z,textField_11.getText(),
					textField.getText(), textField_13.getText(),textField_1.getText());
			    Consultation.base.Table(Consultation.table);
			} 
		});
	}
	public void Annuler() {	
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
	  				public void run() {
	  					try {
	  						@SuppressWarnings("unused")
							EtatPatient window = new EtatPatient();
	  						EtatPatient.frame.setVisible(false);
	  					} catch (Exception e) {
	  						e.printStackTrace();
	  					}
	  				}});
			}
		});
		btnAnnuler.setBounds(370, 232, 97, 37);
		frame.getContentPane().add(btnAnnuler);
	}
}
