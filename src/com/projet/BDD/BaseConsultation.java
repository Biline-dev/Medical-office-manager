package com.projet.BDD;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;

import com.projet.classe.DbUtils;

import MotDePasse.Medecin;

public class BaseConsultation {

	 String maladie1,maladie2,maladie3,maladie4,commentaire,dateinscription;
	 int motantpaye;
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
		
		public void insertTable(JTable table,String dateinscription, String maladie1,String maladie2, String maladie3,
				String maladie4, String commentaire,int montantpaye){
			try {
		      String query = "insert into consultation values(?,?,?,?,?,?,?,?)";
		      PreparedStatement dml = con.prepareStatement(query);
		      this.dateinscription=dateinscription;
		       this.maladie1=maladie1;
		       this.maladie2=maladie2;
		       this.maladie3=maladie3;
		       this.maladie4=maladie4;
		       this.commentaire=commentaire;
		       this.motantpaye=montantpaye;
			    
				dml.setBigDecimal(1, (BigDecimal) Medecin.table.getValueAt(Medecin.table.getSelectedRow(), Medecin.table.getSelectedColumn()));						
				dml.setString(2,dateinscription);
				dml.setString(3, maladie1);
				dml.setString(4, maladie2);
			    dml.setString(5, maladie3);
			    dml.setString(6, maladie4);
			    dml.setString(7, commentaire);
				dml.setInt(8, montantpaye);

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
				String query = "select * from  consultation  where id_patient = ?";
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
				String query = "delete FROM  consultation where id_patient=?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setBigDecimal(1,  (BigDecimal) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));		
				@SuppressWarnings("unused")
				ResultSet rs = pst.executeQuery();
			}catch(Exception e)
			{
				 System.out.println(e);
				}
		}
}
