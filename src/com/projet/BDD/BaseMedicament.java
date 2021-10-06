package com.projet.BDD;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;

import com.projet.classe.DbUtils;

import MotDePasse.Medecin;

public class BaseMedicament {

	 String medicament1 , medicament2 ,medicament3,medicament4,medicament5 ,medicament6;
	 float dose1,dose2,dose3,dose4,dose5,dose6;
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
		
		public void insertTable(JTable table,String medicament1,float dose1,String medicament2, float dose2,String medicament3,
				float dose3, String medicament4, float dose4,String medicament5,float dose5,String medicament6,float dose6){
			try {
		      String query = "insert into medicaments values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		      PreparedStatement dml = con.prepareStatement(query);
		        this.dose1=dose1;
			    this.dose2=dose2;
			    this.dose3=dose3;
			    this.dose4=dose4;
			    this.dose5=dose5;
			    this.dose6=dose6;
			    this.medicament1=medicament1;
			    this.medicament2=medicament2;
			    this.medicament3=medicament3;
			    this.medicament4=medicament4;
			    this.medicament5=medicament5;
			    this.medicament6=medicament6;
			    
				dml.setBigDecimal(1, (BigDecimal) Medecin.table.getValueAt(Medecin.table.getSelectedRow(), Medecin.table.getSelectedColumn()));						
				dml.setString(2, medicament1);
				dml.setFloat(3, dose1);
			    dml.setString(4, medicament2);
			    dml.setFloat(5, dose2);
			    dml.setString(6, medicament3);
				dml.setFloat(7, dose3);
			    dml.setString(8, medicament4);
			    dml.setFloat(9, dose4);
			    dml.setString(10, medicament5);
				dml.setFloat(11, dose5);
			    dml.setString(12, medicament6);
			    dml.setFloat(13, dose6);
				System.out.println("dfghjklm");
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
				String query = "select * from  MEDICAMENTS  where id_patient = ?";
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
				String query = "delete FROM  medicaments where id_patient=?";
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
