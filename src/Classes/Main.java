package MotDePasse;

import java.awt.EventQueue;



public class Main{

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					Clinique window = new Clinique();
				    Clinique.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UneConsultation window = new UneConsultation();
					UneConsultation.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*//*
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
	  			});*/
	}

}
