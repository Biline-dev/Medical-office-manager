package com.projet.BDD;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;

import com.projet.classe.DbUtils;

import MotDePasse.Medecin;

public class BaseEtatPatient {
      
    @SuppressWarnings("unused")
	private float poid, taille, tension;
	@SuppressWarnings("unused")
	private String groupe_sanguin, maladie_cronique1,maladie_cronique2, maladie_cronique3, maladie_cronique4, observation;
	@SuppressWarnings("unused")
	private BigDecimal id_patient;
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
		
		public void insertTable(JTable table,float poid, float taille,String groupe_sanguin, float tension,String maladie_cronique1,
				String maladie_cronique2, String maladie_cronique3, String maladie_cronique4){
			try {
		      String query = "insert into etatpatient values(?,?,?,?,?,?,?,?,?)";
			  PreparedStatement dml = con.prepareStatement(query);
			    this.poid=poid;
				this.taille=taille;
				this.groupe_sanguin=groupe_sanguin;
				this.tension=tension;
				this.maladie_cronique1=maladie_cronique1;
				this.maladie_cronique2=maladie_cronique2;
				this.maladie_cronique3=maladie_cronique3;
				this.maladie_cronique4=maladie_cronique4;
				dml.setBigDecimal(1, (BigDecimal) Medecin.table.getValueAt(Medecin.table.getSelectedRow(), Medecin.table.getSelectedColumn()));		
				dml.setFloat(2, poid);
				dml.setFloat(3, taille);
			    dml.setString(4, groupe_sanguin);
			    dml.setFloat(5, tension);
			    dml.setString(6, maladie_cronique1);
			    dml.setString(7, maladie_cronique2);
			    dml.setString(8, maladie_cronique3);
			    dml.setString(9, maladie_cronique4);
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
				String query = "select * from  etatpatient where id_patient = ?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setBigDecimal(1, (BigDecimal) Medecin.table.getValueAt(Medecin.table.getSelectedRow(), Medecin.table.getSelectedColumn()));		
				ResultSet rs = pst.executeQuery();
			    table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e)
			{
				 System.out.println(e);
				}
		}

       
		public void ModifierEtatPatient(JTable table,float poid, float taille,String groupe_sanguin, float tension,String maladie_cronique1,
				String maladie_cronique2, String maladie_cronique3, String maladie_cronique4){
			
			try {
		      String query = "update etatpatient set poid=?,taille=?,groupe_sanguin=?, "
		      		+ "tension=?,maladie_cronique1=?,maladie_cronique2=?,maladie_cronique3=?,maladie_cronique4=? where id_patient=?" ;
               
		      	PreparedStatement dml = con.prepareStatement(query);
                
		      	this.poid=poid;
				this.taille=taille;
				this.groupe_sanguin=groupe_sanguin;
				this.tension=tension;
				this.maladie_cronique1=maladie_cronique1;
				this.maladie_cronique2=maladie_cronique2;
				this.maladie_cronique3=maladie_cronique3;
				this.maladie_cronique4=maladie_cronique4;
				dml.setFloat(1, poid);
				dml.setFloat(2, taille);
			    dml.setString(3, groupe_sanguin);
			    dml.setFloat(4, tension);
			    dml.setString(5, maladie_cronique1);
			    dml.setString(6, maladie_cronique2);
			    dml.setString(7, maladie_cronique3);
			    dml.setString(8, maladie_cronique4);
				dml.setBigDecimal(9, (BigDecimal) Medecin.table.getValueAt(Medecin.table.getSelectedRow(), Medecin.table.getSelectedColumn()));		
				
				  int update = dml.executeUpdate();
			  if(update>0) {
				  System.out.println("updated values successfully");
			  }else {   System.out.println("updated failed");}
			}catch(Exception e)
			{
				 System.out.println(e);
				}
		}

      public void Etat(JTable table,float poid, float taille,String groupe_sanguin, float tension,String maladie_cronique1,
				String maladie_cronique2, String maladie_cronique3, String maladie_cronique4) {
    	
    		try {
    			  String poids="";
    			  String query= "select poid from etatpatient where id_patient=?";
    			  PreparedStatement dml = con.prepareStatement(query);
  				  dml.setBigDecimal(1, (BigDecimal) Medecin.table.getValueAt(Medecin.table.getSelectedRow(), Medecin.table.getSelectedColumn()));		
  			      ResultSet rst = dml.executeQuery();
  				  while(rst.next()) {  	
 			    	poids = rst.getString("poid");
 			    }
                if (poids!="") {
                ModifierEtatPatient(table,poid,taille,groupe_sanguin, tension,maladie_cronique1,
        				 maladie_cronique2,  maladie_cronique3, maladie_cronique4);	    
                }else {
                insertTable(table, poid, taille, groupe_sanguin, tension, maladie_cronique1, maladie_cronique2, maladie_cronique3, maladie_cronique4);	
                }
			}catch(Exception e)
			{
				 System.out.println(e);
				}
      }

  	public void Suprimerligne(JTable table) {
		try {
			String query = "delete FROM  etatpatient where id_patient=?";
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
