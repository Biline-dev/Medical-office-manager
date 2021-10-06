package com.projet.BDD;
import java.sql.*;



public class BaseMotDePasse {

	@SuppressWarnings("unused")
	private String MotDePasse,Nom_utilisateur;
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
	
	/*TABLE MOT DE PASSE*/
	public void createTable() {
		try {
		String query = "create table Profile (MotDePasse VARCHAR2(50 CHAR) primary key, Nom_utilisateur VARCHAR2(50 CHAR))" ;               
		Statement stnt = con.createStatement();
		boolean check = stnt.execute(query);
		while(check) {
			System.out.println("Table created");
		}
		}catch(Exception e)
		{
			 System.out.println(e);
			}}
	

	public void insertTble(String MotDePasse,String Nom_utilisateur){
		try {
	      String query = "insert into profile values(?,?)";
		  PreparedStatement dml = con.prepareStatement(query);
		  this.MotDePasse= MotDePasse;
		  this.Nom_utilisateur=Nom_utilisateur;
		  dml.setString(1, MotDePasse);
		  dml.setString(2, Nom_utilisateur); 
		  int insert = dml.executeUpdate();
		  if(insert>0) {
			  System.out.println("inserted values successfully");
		  }else {   System.out.println("inserted failed");}
		}catch(Exception e)
		{
			 System.out.println(e);
			}
	}
	
	public void UpdatTble(String MotDePasse){
		try {
	      String query = "Update profile Set motdepasse =?";
		  PreparedStatement dml = con.prepareStatement(query);
		  this.MotDePasse= MotDePasse;
		  dml.setString(1, MotDePasse); 
		  int update = dml.executeUpdate();
		  if(update>0) {
			  System.out.println("updated values successfully");
		  }else {   System.out.println("update failed");}
		}catch(Exception e)
		{
			 System.out.println(e);
			}
	}
	
	public void UpdatTble2(String Nom_utilisateur){
		try {
	      String query = "Update profile Set NOM_UTILISATEUR =?";
		  PreparedStatement dml = con.prepareStatement(query);
		  this.Nom_utilisateur= Nom_utilisateur;
		  dml.setString(1, Nom_utilisateur); 
		  int update = dml.executeUpdate();
		  if(update>0) {
			  System.out.println("updated values successfully");
		  }else {   System.out.println("update failed");}
		}catch(Exception e)
		{
			 System.out.println(e);
			}
	}
	
	public String display() {
	    try {
		String MotDePasse=" ", Nom_utilisateur=" ";
		Statement stnt = con.createStatement();
		ResultSet rst = stnt.executeQuery("select * from Profile");
	    while(rst.next()) {
	    	
	    	MotDePasse = rst.getString("MotDePasse");
	    	Nom_utilisateur=rst.getString("NOM_UTILISATEUR");
	    	
	    	return MotDePasse+" "+Nom_utilisateur;
	    }
			}
			catch(Exception e){
				System.out.println(e);
			}
	    return null;
		}
	
	public boolean ComparerMotdepasse( String motdepasse) {
		try {
			String MotDePasse="";
			Statement stnt = con.createStatement();
			ResultSet rst = stnt.executeQuery("select MotDePasse from Profile");
		    while(rst.next()) {	
		    	MotDePasse = rst.getString("MotDePasse");
		    	
		    	if(motdepasse.equals(MotDePasse) ) {
		    		return true;}}
				}
				catch(Exception e){
					System.out.println(e);
				}
		return false;
	}
	
	public boolean ComparerNomutilisateur( String nomutilisateur) {
		try {
			String Nom_utilisateur="";
			Statement stnt = con.createStatement();
			ResultSet rst = stnt.executeQuery("select Nom_utilisateur from Profile");
		    while(rst.next()) {	
		    	Nom_utilisateur = rst.getString("Nom_utilisateur");
		    	
		    	if(nomutilisateur.equals(Nom_utilisateur) ) {
		    		return true;}}
				}
				catch(Exception e){
					System.out.println(e);
				}
		return false;
	}

	
	
	
	
	
	
	
	
	
	
}
