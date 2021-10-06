package Classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.projet.BDD.BaseMotDePasse;

import partials.Ecriture;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class InfoPatient {

	static JFrame frame=new JFrame();
	private String[] jours = new String[32];
	private String[] mois =new String[13];
	private String[] annee=new String[121];
	private BaseMotDePasse base= new BaseMotDePasse();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	@SuppressWarnings("rawtypes")
	JComboBox comboBox_1 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox comboBox_2 = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox comboBox_3 = new JComboBox();


	public InfoPatient() {
		Fenetre(700,700,700,350,frame);
		date_de_naissance(177, 127,frame);
		Nom(frame);
		prenom(frame);
		lieu_de_naissance(frame);
		adresse(frame);
		adresse_mail(frame);
		numero_telephone(frame);
		dateinscription(523, 37,frame);
		Apliquer(457,623,frame);
		Annuler(453,225,frame);
		fond(0,-57,700,726,"fon1.png",frame); 
	}

	/*FENETRE*/
	public void Fenetre(int x,int y, int z, int t,JFrame frame) {
		frame.setBounds(x, y, z, t);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}
	/*FOND*/
	public void fond(int x,int y, int z, int t,  String image,JFrame frame) {
		Image img1 = new ImageIcon(this.getClass().getResource("/Images/"+image)).getImage();
		JLabel lblNewLabel1 = new JLabel(" ");
		lblNewLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel1.setForeground(Color.BLACK);
		lblNewLabel1.setIcon(new ImageIcon(img1));
		lblNewLabel1.setBounds(x, y, z, t);
		frame.getContentPane().add(lblNewLabel1);
	}
	
	/*DATE DE NAISSANCE*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void date_de_naissance(int x, int y,JFrame frame) {
		JLabel lblNewLabel_3 = new JLabel("Date de naissance:");
		lblNewLabel_3.setBounds(32, 190, 170, 15);
		frame.getContentPane().add(lblNewLabel_3);
		for(int i=0; i<31;i++) {
			jours[i]=String.valueOf(i+1);
		}
		comboBox_1.setModel(new DefaultComboBoxModel(jours));
		comboBox_1.setBounds(178, 185, 46, 24);
		frame.getContentPane().add(comboBox_1);
		
		for(int i=1900; i<2021;i++) {
			annee[i-1900]=String.valueOf(i);
		}
		comboBox_3.setModel(new DefaultComboBoxModel(annee));
		comboBox_3.setBounds(265, 185, 74, 24);
		frame.getContentPane().add(comboBox_3);
		
		for(int i=0; i<12;i++) {
			mois[i]=String.valueOf(i+1);
		}
		comboBox_2.setModel(new DefaultComboBoxModel(mois));
		comboBox_2.setBounds(220, 185, 46, 24);
		frame.getContentPane().add(comboBox_2);
		}
	
	/*SAISIR LE NOM*/
    public void Nom(JFrame frame) {
		JLabel lblNewLabel_1 = new JLabel("Nom:");
		lblNewLabel_1.setBounds(32, 92, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);
		textField = new Ecriture("Saisir le texte...");
		textField.setBounds(135, 86, 171, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
    }
    
    /*SAISIR LE LIEU DE NAISSANCE*/
	public void	lieu_de_naissance(JFrame frame) {
		JLabel lblNewLabel_4 = new JLabel("Lieu de naissance:");
		lblNewLabel_4.setBounds(32, 236, 144, 15);
		frame.getContentPane().add(lblNewLabel_4);
		textField_5 = new Ecriture("Saisir le texte...");
		textField_5.setBounds(192, 230, 171, 28);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
	}
	/*SAISIR LE NUMERO DE TELEPHONE*/
	public void numero_telephone(JFrame frame) {
	JLabel lblNewLabel_5 = new JLabel("N°tel:");
	lblNewLabel_5.setBounds(380, 92, 70, 15);
	frame.getContentPane().add(lblNewLabel_5);
	textField_6 = new Ecriture("Saisir le texte...");
	textField_6.setBounds(499, 86, 170, 28);
	frame.getContentPane().add(textField_6);
	textField_6.setColumns(10);
	}
	/*SAISIR L'ADRESSE MAIL*/
	public void adresse_mail(JFrame frame) {
	JLabel lblNewLabel_6 = new JLabel("Adresse mail:");
	lblNewLabel_6.setBounds(380, 132, 102, 15);
	frame.getContentPane().add(lblNewLabel_6);
	textField_7 = new Ecriture("Saisir le texte...");
	textField_7.setBounds(499, 125, 170, 29);
	frame.getContentPane().add(textField_7);
	textField_7.setColumns(10);
	}
	/*SAISIR LE PRENOM*/
	public void prenom(JFrame frame) {
	JLabel lblNewLabel_2 = new JLabel("Prenom:");
	lblNewLabel_2.setBounds(32, 132, 70, 15);
	frame.getContentPane().add(lblNewLabel_2);
	textField_1 = new Ecriture("Saisir le texte...");
	textField_1.setBounds(135, 126, 171, 28);
	frame.getContentPane().add(textField_1);
	textField_1.setColumns(10);
	}
	/*SAISIR L'ADRESSE*/
	public void adresse(JFrame frame) {
	JLabel lblNewLabel_7 = new JLabel("Adresse:");
	lblNewLabel_7.setBounds(380, 190, 70, 15);
	frame.getContentPane().add(lblNewLabel_7);
	textField_8 = new Ecriture("Saisir le texte...");
	textField_8.setBounds(499, 184, 170, 28);
	frame.getContentPane().add(textField_8);
	textField_8.setColumns(10);
	}
	
	/*DATE D'INSCRIPTION*/
	public void dateinscription(int x, int y,JFrame frame) {
	Date aujourdhui = new Date();
    DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
        DateFormat.SHORT,
        DateFormat.SHORT);
	JLabel lblNewLabel = new JLabel(""+shortDateFormat.format(aujourdhui));
	lblNewLabel.setBounds(x, y, 255, 15);
	frame.getContentPane().add(lblNewLabel);
	}
	
		
		/*SORTIR DE LA FENETRE*/
		public void Annuler(int x, int y,JFrame frame) {
			JButton btnNewButton_1 = new JButton("Annuler");
			btnNewButton_1.setBounds(567, 263, 102, 35);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					EventQueue.invokeLater(new Runnable() {
	  				public void run() {
	  					try {
	  						@SuppressWarnings("unused")
							InfoPatient window = new InfoPatient();
	  						InfoPatient.frame.setVisible(false);
	  					} catch (Exception e) {
	  						e.printStackTrace();
	  					}
	  				}});}});
			frame.getContentPane().add(btnNewButton_1);
			}

	/*Methode pour enregistrer dans la base de donnée*/
	
		public void Apliquer(int x, int y,JFrame frame) {
			JButton btnNewButton = new JButton("Appliquer");
			btnNewButton.setBounds(444, 263, 102, 35);
			frame.getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				    int x=Integer.parseInt(comboBox_1.getSelectedItem().toString());
					int y = Integer.parseInt(comboBox_2.getSelectedItem().toString());
					int z= Integer.parseInt(comboBox_3.getSelectedItem().toString());
					Medecin.base.getOracleComment();
					Medecin.base.insertTable(textField.getText(), textField_1.getText(),x+"/"+y+"/"+z,
					textField_5.getText(),textField_8.getText(), textField_6.getText(), textField_7.getText());
					Medecin.base.Table(Medecin.table);
				}});
}

		public void Apliquer2(int x, int y,JFrame frame) {
			JButton btnNewButton = new JButton("Appliquer");
			btnNewButton.setBounds(x, y, 102, 35);
			frame.getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
			     	int x=Integer.parseInt(comboBox_1.getSelectedItem().toString());
					int y = Integer.parseInt(comboBox_2.getSelectedItem().toString());
					int z= Integer.parseInt(comboBox_3.getSelectedItem().toString());
					base.getOracleComment();
					Medecin.base.modifierInfopatient(Medecin.table,textField.getText(), textField_1.getText(),x+"/"+y+"/"+z,
							textField_5.getText(),textField_8.getText(), textField_6.getText(), textField_7.getText());
					Medecin.base.Table(Medecin.table);
             
				Annuler(453,225,frame);
				
				}});
}

}
