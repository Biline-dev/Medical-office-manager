package Classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.projet.BDD.BaseMotDePasse;

import partials.Ecriture;


public class Clinique {

	public static JFrame frame =  new JFrame();
	public static BaseMotDePasse base = new BaseMotDePasse();
	private JTextField textField;
	private JTextField textField_1;
    
	public Clinique() {
		base.getOracleComment();
		fenetre();
		Entrermotdepasse();
		Entrernom();
		organiservisite();
		voiragenda();
		login();
        Lettre();
		fond();
	}

	public void Lettre() {
		JLabel lblCabinetBa = new JLabel("Cabinet BA");
		lblCabinetBa.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		lblCabinetBa.setBackground(Color.BLACK);
		lblCabinetBa.setForeground(new Color(0, 0, 102));
		lblCabinetBa.setBounds(208, 20, 199, 47);
		frame.getContentPane().add(lblCabinetBa);
	}
	public void fenetre() {
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	public void Entrermotdepasse() {
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(90, 153, 109, 15);
		frame.getContentPane().add(lblMotDePasse);
		textField = new Ecriture("Saisir du texte...");
		textField.setBounds(239, 144, 160, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	public void organiservisite() {
		JButton btnNewButton = new JButton("Organiser une visite");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(239, 233, 249, 25);
		frame.getContentPane().add(btnNewButton);
	}
	public void voiragenda() {
		JButton btnNewButton_1 = new JButton("Agenda");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(28, 233, 117, 25);
		frame.getContentPane().add(btnNewButton_1);
	}
		
   public void Entrernom() {
		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur :");
		lblNomDutilisateur.setBounds(90, 99, 143, 33);
		frame.getContentPane().add(lblNomDutilisateur);
		textField_1 = new Ecriture("Saisir du texte...");
		textField_1.setBounds(239, 99, 160, 33);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
   }
   public void login() {
		JButton btnNewButton_2 = new JButton("Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if (base.ComparerMotdepasse(textField.getText()) && 
						base.ComparerNomutilisateur(textField_1.getText())) {
					Clinique.frame.setVisible(false);
					EventQueue.invokeLater(new Runnable() {
		  				public void run() {
		  					try {
		  						@SuppressWarnings("unused")
								Medecin window = new Medecin();
		  						Medecin.frame.setVisible(true);
		  					} catch (Exception e) {
		  						e.printStackTrace();
		  					}
		  				}
		  			});
					}
					else {JOptionPane.showMessageDialog(null,"Mot de passe ou nom utilisateur erroné");
			}
		}});
		
		btnNewButton_2.setBounds(313, 189, 83, 25);
		frame.getContentPane().add(btnNewButton_2);
   }
		
	public void fond() {
		JLabel lblNewLabel1 = new JLabel(" ");
		lblNewLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel1.setForeground(Color.BLACK);
		Image img1 = new ImageIcon(this.getClass().getResource("/Images/doc.png")).getImage();
		lblNewLabel1.setIcon(new ImageIcon(img1));
		lblNewLabel1.setBounds(28, -290, 344, 378);
		frame.getContentPane().add(lblNewLabel1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setForeground(Color.BLACK);
		Image img = new ImageIcon(this.getClass().getResource("/Images/fon2.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, -12, 515, 378);
		frame.getContentPane().add(lblNewLabel);
	}
}

