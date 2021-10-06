package Classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import com.projet.BDD.BaseConsultation;
import com.projet.BDD.BaseEtatPatient;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consultation {

	static JFrame frame=new JFrame();
	static JTable table=new JTable();
	static JTable table1=new JTable();
	static BaseEtatPatient base = new BaseEtatPatient();
	static BaseConsultation base1 =  new BaseConsultation();

	public Consultation() {
		base.getOracleComment();
		base1.getOracleComment();
		
		Fenetre(700,700,1100,330,frame);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 70, 1076, 38);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(12, 120, 1076, 100);
		frame.getContentPane().add(scrollPane1);
		scrollPane1.setViewportView(table1);
		AfficherConsultation();
		AfficherEtatPatient();
		ModifierPatient();
		AjouterConsultation();
		Annuler();
		Aide(); 
		fond();
	}



	public void Fenetre(int x,int y, int z, int t,JFrame frame) {
		frame.setBounds(x, y, z, t);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	/*FOND*/
	public void fond() {
		
    	Image img4 = new ImageIcon(this.getClass().getResource("/Images/fon1.png")).getImage();
     	Image img3 = new ImageIcon(this.getClass().getResource("/Images/fon1.png")).getImage();
        
        JLabel lblNewLabel4 = new JLabel(" ");
		lblNewLabel4.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel4.setForeground(Color.BLACK);
		lblNewLabel4.setIcon(new ImageIcon(img4));
		lblNewLabel4.setBounds(500, -300, 700, 726);
		frame.getContentPane().add(lblNewLabel4);
		
        JLabel lblNewLabel3 = new JLabel(" ");
        lblNewLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel3.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel3.setForeground(Color.BLACK);
        lblNewLabel3.setIcon(new ImageIcon(img3));
        lblNewLabel3.setBounds(0, -300, 700, 726);
        frame.getContentPane().add(lblNewLabel3);
	}
	
    public void ModifierPatient() {
        JButton btnModifierLetatDu = new JButton("Etat du patient");
        btnModifierLetatDu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							@SuppressWarnings("unused")
							EtatPatient window = new EtatPatient();
							EtatPatient.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
        	}
        });
        btnModifierLetatDu.setBounds(563, 20, 223, 38);
        frame.getContentPane().add(btnModifierLetatDu);
    }
    
    public void AjouterConsultation() {
        JButton btnAjouterUneConsultation = new JButton("Ajouter une consultation");
        btnAjouterUneConsultation.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					@SuppressWarnings("unused")
							UneConsultation window = new UneConsultation();
        					UneConsultation.frame.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
        	}
        });
        btnAjouterUneConsultation.setBounds(816, 20, 223, 38);
        frame.getContentPane().add(btnAjouterUneConsultation);
    }
    public void Annuler() {
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		EventQueue.invokeLater(new Runnable() {
	  				public void run() {
	  					try {
	  						@SuppressWarnings("unused")
							Consultation window = new Consultation();
	  						Consultation.frame.setVisible(false);
	  					} catch (Exception e) {
	  						e.printStackTrace();
	  					}
	  				}});
        	}
        });
        btnAnnuler.setBounds(970, 244, 101, 38);
        frame.getContentPane().add(btnAnnuler);
    }
    
    public void AfficherConsultation() {
        JButton btnAfficherLesConsultations = new JButton("Afficher les consultations");
        btnAfficherLesConsultations.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	base1.Table(table1);
        	}
        });
        btnAfficherLesConsultations.setBounds(306, 20, 223, 38);
        frame.getContentPane().add(btnAfficherLesConsultations);
    }
    
    public void Aide() {
        JButton btnAide = new JButton("Aide");
        btnAide.setBounds(857, 244, 101, 38);
        frame.getContentPane().add(btnAide);
    }
    
	
public void AfficherEtatPatient() {
	JButton btnAfficherLetatDu = new JButton("Afficher l'etat du patient");
	btnAfficherLetatDu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			base.Table(table);
		}
	});
	btnAfficherLetatDu.setBounds(47, 20, 223, 38);
	frame.getContentPane().add(btnAfficherLetatDu);
}
}
