package com.projet.BDD;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;

import com.projet.classe.DbUtils;

import MotDePasse.Medecin;
import partials.Ecriture;

public class BaseInfoPatient {

	@SuppressWarnings("unused")
	private String  nom, prenom,adresse,lieu_de_naissance,num_telephone, adresse_mail,date_de_naissance;
	Connection con = null;
	
	public Connection getOracleComment() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","1234","1234");
	    System.out.println("Connection Successful");
	}catch(Exception e)
		{
		 System.out.println(e);
		}
	   return con;
    }
	

	public void insertTable(String nom, String prenom,String date_de_naissance, String lieu_de_naissance,
			String adresse, String num_telephone, String adresse_mail){
		try {
	      String query = "insert into infopatient values(seq.nextval,?,?,?,?,?,?,?)";
		  PreparedStatement dml = con.prepareStatement(query);
		  this.nom=nom;
		  this.prenom=prenom;
		  this.date_de_naissance=date_de_naissance;
		  this.lieu_de_naissance= lieu_de_naissance;
		  this.adresse= adresse;
		  this.num_telephone=num_telephone;
		  this.adresse_mail=adresse_mail;
		  
		  dml.setString(1, nom);
		  dml.setString(2, prenom);
		  dml.setString(3, date_de_naissance);
		  dml.setString(4, lieu_de_naissance);
		  dml.setString(5, adresse);
		  dml.setString(6, num_telephone);
		  dml.setString(7, adresse_mail);
		 
		  int insert = dml.executeUpdate();
		  if(insert>0) {
			  System.out.println("inserted values successfully");
		  }else {   System.out.println("inserted failed");}
		}catch(Exception e)
		{
			 System.out.println(e);
			}
	}
	
	public void Table(JTable table) {
		try {
			String query = "select * from  infopatient";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e)
		{
			 System.out.println(e);
			}
	}
	
	public void Table2(JTable table, Ecriture nom) {
		try {
			String query = "select * from  infopatient where nom=? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, nom.getText());		
			ResultSet rs = pst.executeQuery();
			
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e)
		{
			 System.out.println(e);
			}
	}
	
	public void Table3(JTable table) {
		try {
			String query = "select nom, prenom,adresse,lieu_de_naissance,date_de_naissance from  infopatient where id_patient=? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setBigDecimal(1, (BigDecimal) Medecin.table.getValueAt(Medecin.table.getSelectedRow(), Medecin.table.getSelectedColumn()));		
			ResultSet rs = pst.executeQuery();
			
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e)
		{
			 System.out.println(e);
			}
	}
	public void Suprimerligne(JTable table) {
		try {
			String query = "delete FROM  infopatient where id_patient=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setBigDecimal(1,  (BigDecimal) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));		
			@SuppressWarnings("unused")
			ResultSet rs = pst.executeQuery();
		}catch(Exception e)
		{
			 System.out.println(e);
			}
	}
	
	public void modifierInfopatient(JTable table,String nom, String prenom,String date_de_naissance, String lieu_de_naissance,
			String adresse, String num_telephone, String adresse_mail) {
		try {
			String query = "update infopatient set  nom=?, prenom=?,date_de_naissance=?,lieu_de_naissance=?, "
					+ "adresse=?,num_telephone=?, adresse_mail=? where id_patient=?";
			PreparedStatement dml = con.prepareStatement(query);
			  this.nom=nom;
			  this.prenom=prenom;
			  this.date_de_naissance=date_de_naissance;
			  this.lieu_de_naissance= lieu_de_naissance;
			  this.adresse= adresse;
			  this.num_telephone=num_telephone;
			  this.adresse_mail=adresse_mail;
			  
			  dml.setString(1, nom);
			  dml.setString(2, prenom);
			  dml.setString(3, date_de_naissance);
			  dml.setString(4, lieu_de_naissance);
			  dml.setString(5, adresse);
			  dml.setString(6, num_telephone);
			  dml.setString(7, adresse_mail);
			  dml.setBigDecimal(8,  (BigDecimal) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));		

			  @SuppressWarnings("unused")
			ResultSet rs = dml.executeQuery();	
		}catch(Exception e)
		{
			 System.out.println(e);
			}
	}
	
}
