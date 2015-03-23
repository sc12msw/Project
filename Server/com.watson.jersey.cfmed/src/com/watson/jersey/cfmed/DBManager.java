package com.watson.jersey.cfmed;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/CFMedDB";

	//  Database credentials
	static final String USER = "admin";
	static final String PASS = "#S3cret999";

	public void addDrug(DrugInfo drug) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement preparedStatement = null;
		try{
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Create a connection
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			//creates query to add object to database
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;

			//Drug init block, the following code sets the basic data for the drug in the database.
			preparedStatement = conn.prepareStatement("insert into  Drugs (Name,Indication,Side_Effects) values (?, ?, ?)");
			preparedStatement.setString(1, drug.getName());
			preparedStatement.setString(2, drug.getIndication());
			preparedStatement.setString(3, drug.getSideEffect());
			preparedStatement.executeUpdate();

			
			sql = "SELECT * FROM Drugs";
			ResultSet rs = stmt.executeQuery(sql);

			//Get the drug id to pass the foreign key to the other tables
			int lastid = 0;
			while(rs.next()){
				//Retrieve by column name
				int id  = rs.getInt("ID");
				lastid = id;
			}
			
				
				
			
			//Adult administration section, the following block is how the adult administration data is added to the database.   
			AdultInfo adult=drug.getAdult();
			AdminDose oral = adult.getOral();
			AdminDose iv = adult.getIV();
			AdminDose inhaled = adult.getInhaled();
			AdminDose im = adult.getIM();
			AdminDose pr = adult.getPR();
			AdminDose sc = adult.getSC();

			preparedStatement = conn.prepareStatement("insert into  Adult_Administration  values (default ,?, ?, ?, ?, ?, ?,"+lastid+")");
			if (oral == null){ 
				preparedStatement.setString(1,"NULL"); 
			}else{
				preparedStatement.setString(1, oral.getAdministration());
			}
			if (iv == null){ 
				preparedStatement.setString(2,"NULL"); 
			}else{
				preparedStatement.setString(2, iv.getAdministration());
			}
			if (inhaled == null){ 
				preparedStatement.setString(3,"NULL"); 
			}else{
				preparedStatement.setString(3, inhaled.getAdministration());
			}
			if (im == null){ 
				preparedStatement.setString(4,"NULL"); 
			}else{
				preparedStatement.setString(4, im.getAdministration());
			}
			if (pr == null){ 
				preparedStatement.setString(5,"NULL"); 
			}else{
				preparedStatement.setString(5, pr.getAdministration());
			}
			if (sc == null){ 
				preparedStatement.setString(6,"NULL"); 
			}else{
				preparedStatement.setString(6, sc.getAdministration());
			}
			preparedStatement.executeUpdate();   

			//Adult dose section, the following block is how the adult dose data is added to the database.   
			preparedStatement = conn.prepareStatement("insert into  Adult_Dose values (default ,?, ?, ?, ?, ?, ?,"+lastid+")");
			if (oral == null){ 
				preparedStatement.setString(1,"NULL"); 
			}else{
				preparedStatement.setString(1, oral.getDose());
			}
			if (iv == null){ 
				preparedStatement.setString(2,"NULL"); 
			}else{
				preparedStatement.setString(2, iv.getDose());
			}
			if (inhaled == null){ 
				preparedStatement.setString(3,"NULL"); 
			}else{
				preparedStatement.setString(3, inhaled.getDose());
			}
			if (im == null){ 
				preparedStatement.setString(4,"NULL"); 
			}else{
				preparedStatement.setString(4, im.getDose());
			}
			if (pr == null){ 
				preparedStatement.setString(5,"NULL"); 
			}else{
				preparedStatement.setString(5, pr.getDose());
			}
			if (sc == null){ 
				preparedStatement.setString(6,"NULL"); 
			}else{
				preparedStatement.setString(6, sc.getDose());
			}
			preparedStatement.executeUpdate();   


			// Paediatric administration section, the following block is how the adult administration data is added to the database.   
			PaediatricInfo paed=drug.getPaediatric();
			oral = paed.getOral();
			iv = paed.getIV();
			inhaled = paed.getInhaled();
			im = paed.getIM();
			pr = paed.getPR();
			sc = paed.getSC();
			preparedStatement = conn.prepareStatement("insert into  Paediatric_Administration values (default ,?, ?, ?, ?, ?, ?,"+lastid+")");
			if (oral == null){ 
				preparedStatement.setString(1,"NULL"); 
			}else{
				preparedStatement.setString(1, oral.getAdministration());
			}
			if (iv == null){ 
				preparedStatement.setString(2,"NULL"); 
			}else{
				preparedStatement.setString(2, iv.getAdministration());
			}
			if (inhaled == null){ 
				preparedStatement.setString(3,"NULL"); 
			}else{
				preparedStatement.setString(3, inhaled.getAdministration());
			}
			if (im == null){ 
				preparedStatement.setString(4,"NULL"); 
			}else{
				preparedStatement.setString(4, im.getAdministration());
			}
			if (pr == null){ 
				preparedStatement.setString(5,"NULL"); 
			}else{
				preparedStatement.setString(5, pr.getAdministration());
			}
			if (sc == null){ 
				preparedStatement.setString(6,"NULL"); 
			}else{
				preparedStatement.setString(6, sc.getAdministration());
			}
			preparedStatement.executeUpdate();   

			//Paediatric dose section, the following block is how the paediatric dose data is added to the database.   
			preparedStatement = conn.prepareStatement("insert into  Paediatric_Dose values (default ,?, ?, ?, ?, ?, ?,"+lastid+")");
			if (oral == null){ 
				preparedStatement.setString(1,"NULL"); 
			}else{
				preparedStatement.setString(1, oral.getDose());
			}
			if (iv == null){ 
				preparedStatement.setString(2,"NULL"); 
			}else{
				preparedStatement.setString(2, iv.getDose());
			}
			if (inhaled == null){ 
				preparedStatement.setString(3,"NULL"); 
			}else{
				preparedStatement.setString(3, inhaled.getDose());
			}
			if (im == null){ 
				preparedStatement.setString(4,"NULL"); 
			}else{
				preparedStatement.setString(4, im.getDose());
			}
			if (pr == null){ 
				preparedStatement.setString(5,"NULL"); 
			}else{
				preparedStatement.setString(5, pr.getDose());
			}
			if (sc == null){ 
				preparedStatement.setString(6,"NULL"); 
			}else{
				preparedStatement.setString(6, sc.getDose());
			}
			preparedStatement.executeUpdate();

			
			//Sets the brand name table
			ArrayList <String> brands = drug.getBrandName();
			if (brands != null){
				for (int i=0; i<brands.size();i++){
					preparedStatement = conn.prepareStatement("insert into  Brand_Names values (default , ?,"+lastid+")");
					preparedStatement.setString(1, brands.get(i));
					preparedStatement.executeUpdate();
				}
			}
			else { 
				PreparedStatement preparedStatement2 = conn.prepareStatement("insert into  Brand_Names values (default , ?,"+lastid+")");
				preparedStatement2.setString(1, "NULL");
				preparedStatement2.executeUpdate();
			}
			
			
			sql = "SELECT * FROM Adult_Administration";
			rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int id  = rs.getInt("ID");
				String name = rs.getString("Oral");
				String indication = rs.getString("IV");
				String sideEffects = rs.getString("Inhaled");

				//Display values
				System.out.print("ID: " + id);
				System.out.print(", oral: " + name);
				System.out.print(", IV: " + indication);
				System.out.println(", Inhaled: " + sideEffects);
			}
			
			//Close connections
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//Close connections if no connection was found
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
}

