package Classes;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.projet.BDD.BaseInfoPatient;

import partials.BT;
import partials.Ecriture;
public class Medecin {

	static JFrame frame=new JFrame();
	 public static JTable table=new JTable();
	static BaseInfoPatient base = new BaseInfoPatient();
	private  Ecriture t;
	/**
	 * Launch the application.
	 */

	public Medecin() {
		base.getOracleComment();
		Consultation.base.getOracleComment();
		Consultation.base1.getOracleComment();
		Traitement.base.getOracleComment();
		ConsultersStatistique();
		ChangerMotpasse();
		ChangerNomutilisateur();
		AjouterConsultation();
		AjouterPatient();
		SupprimerPatient();
		VoirAide();
		ModifierInfoPatient();
		Annueler();
		Recherche();
		Actualiser();
		initialize();
		 fond();
	}

	private void initialize() {
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	public void VoirAide() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 215, 1071, 364);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
      	JButton btnNewButton = new JButton("Aide");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(883, 607, 89, 39);
		frame.getContentPane().add(btnNewButton);
	}
	public void Recherche() {
		t= new Ecriture("Recherche ...");
		t.setBounds(825, 5, 210, 40);
		frame.getContentPane().add(t);		
		t.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    base.Table2(table, t);
		}
	});
		
		BT btnNewButton_21 = new BT("coronavirus");
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				base.Table2(table, t);
			}
		});
		btnNewButton_21.setBorderPainted(false);
		btnNewButton_21.setBounds(788, 5, 25, 39);
		frame.getContentPane().add(btnNewButton_21);
	}
	public void AjouterPatient() {
		JButton btnNewButton_1 = new JButton("Ajouter un patient");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							@SuppressWarnings("unused")
							InfoPatient window = new InfoPatient();
							InfoPatient.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1.setBounds(53, 164, 179, 39);
		frame.getContentPane().add(btnNewButton_1);
	}
	public void Annueler() {
		JButton btnNewButton_2 = new JButton("Annuler");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
	  				public void run() {
	  					try {
	  						@SuppressWarnings("unused")
							Medecin window = new Medecin();
	  						Medecin.frame.setVisible(false);
	  					} catch (Exception e) {
	  						e.printStackTrace();
	  					}
	  				}});
			}
		});
		btnNewButton_2.setBounds(984, 607, 89, 39);
		frame.getContentPane().add(btnNewButton_2);
	}
			
	public void SupprimerPatient() {
		JButton btnNewButton_5 = new JButton("Supprimer un patient");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Consultation.base.Suprimerligne(table);;
				Consultation.base1.Suprimerligne(table);
				Traitement.base.Suprimerligne(table);
			base.Suprimerligne(table);
			base.Table(table);
			}
		});
		btnNewButton_5.setBounds(278, 164, 185, 39);
		frame.getContentPane().add(btnNewButton_5);
	}
	public void Actualiser() {
		JButton btnNewButton_4 = new JButton("Actualiser");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    base.Table(table);
			}
		});
		btnNewButton_4.setBounds(500, 5, 117, 39);
		frame.getContentPane().add(btnNewButton_4);
	}
	public void ModifierInfoPatient() {
		JButton btnModifierLesInformatios = new JButton("modifier les informations du patient");
		btnModifierLesInformatios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							@SuppressWarnings("unused")
							ModifierInfoPatient window = new ModifierInfoPatient();
							ModifierInfoPatient.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		
		});
		btnModifierLesInformatios.setBounds(500, 164, 289, 39);
		frame.getContentPane().add(btnModifierLesInformatios);
	}
	public void fond() {
		/*FOND*/
		Image img1 = new ImageIcon(this.getClass().getResource("/Images/fon3.jpg")).getImage();
		Image img21 = new ImageIcon(this.getClass().getResource("/Images/doc.png")).getImage();
    	Image img4 = new ImageIcon(this.getClass().getResource("/Images/fon3.jpg")).getImage();
    	Image img2 = new ImageIcon(this.getClass().getResource("/Images/fon3.jpg")).getImage();
    	Image img3 = new ImageIcon(this.getClass().getResource("/Images/fon3.jpg")).getImage();
 		
		JLabel lblNewLabel11 = new JLabel(" ");
		lblNewLabel11.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel11.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel11.setForeground(Color.BLACK);
		lblNewLabel11.setIcon(new ImageIcon(img21));
		lblNewLabel11.setBounds(0, -300, 344, 378);
		frame.getContentPane().add(lblNewLabel11);
		
		
		
		JLabel lblNewLabel1 = new JLabel(" ");
		lblNewLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel1.setForeground(Color.BLACK);
		lblNewLabel1.setIcon(new ImageIcon(img1));
		lblNewLabel1.setBounds(0, -56, 700, 726);
		frame.getContentPane().add(lblNewLabel1);
		
		JLabel lblNewLabel2 = new JLabel(" ");
		lblNewLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel2.setForeground(Color.BLACK);
		lblNewLabel2.setIcon(new ImageIcon(img2));
		lblNewLabel2.setBounds(532, -30,1000, 700);
		frame.getContentPane().add(lblNewLabel2);
		
        JLabel lblNewLabel3 = new JLabel(" ");
		lblNewLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel3.setForeground(Color.BLACK);
		lblNewLabel3.setIcon(new ImageIcon(img3));
		lblNewLabel3.setBounds(0, -300, 700, 726);
		frame.getContentPane().add(lblNewLabel3);
		
        JLabel lblNewLabel4 = new JLabel(" ");
		lblNewLabel4.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel4.setForeground(Color.BLACK);
		lblNewLabel4.setIcon(new ImageIcon(img4));
		lblNewLabel4.setBounds(500, -300, 700, 726);
		frame.getContentPane().add(lblNewLabel4);
	}
	public void ConsultersStatistique() {
		JButton btnNewButton_6 = new JButton("Statistique du cabinet");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_6.setBounds(35, 607, 265, 39);
		frame.getContentPane().add(btnNewButton_6);
	}
	public void AjouterConsultation() {
		JButton btnNewButton_7 = new JButton("Consultations");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					@SuppressWarnings("static-access")
					public void run() {
						try {
							Consultation window = new Consultation();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			
			}
		});
	
		btnNewButton_7.setBounds(825, 164, 223, 39);
		frame.getContentPane().add(btnNewButton_7);
	}
	public void ChangerMotpasse() {
		JButton btnNewButton_8 = new JButton("changer le mot de passe");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    Clinique.base.UpdatTble(JOptionPane.showInputDialog("Changer votre mot de passe"));
			}
		});
		btnNewButton_8.setBounds(97, 12, 226, 25);
		frame.getContentPane().add(btnNewButton_8);
	}
	public void ChangerNomutilisateur() {
		JButton btnNewButton_9 = new JButton("changer nom d'utilisateur");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    Clinique.base.UpdatTble2(JOptionPane.showInputDialog("Changer votre nom d'utilisateur"));
				
			}
		});
		btnNewButton_9.setBounds(97, 53, 226, 25);
		frame.getContentPane().add(btnNewButton_9);
	}
}
