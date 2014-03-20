package com.pubiapplication.app;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


public class fetchLinnad {
	
	private static Connection connection = null;
	
	
	
	 public static Connection getConnection() {
		 	        if (connection != null)
		 	            return connection;
		 	        else {
		 	            try {
		 	                Properties prop = new Properties();
		 	                InputStream inputStream = fetchLinnad.class.getClassLoader().getResourceAsStream("databaseconnection.txt");
		 	                prop.load(inputStream);
		 	                String driver = prop.getProperty("driver");
		 	                String url = prop.getProperty("url");
		 	                String user = prop.getProperty("user");
		 	                String password = prop.getProperty("password");
		 	                Class.forName(driver);
		 	                connection = DriverManager.getConnection(url, user, password);
		 	            } catch (ClassNotFoundException e) {
		 	                e.printStackTrace();
		 	            } catch (SQLException e) {
		 	                e.printStackTrace();
		 	            } catch (FileNotFoundException e) {
		 	                e.printStackTrace();
		 	            } catch (IOException e) {
		 	                e.printStackTrace();
		 	            }
		 	            return connection;
		 	        }
		 	    }
	 
	 public static ArrayList<Linnad> getAllLinnad() {
		 	     connection = fetchLinnad.getConnection();
		 	        ArrayList<Linnad> linnade_list = new ArrayList<Linnad>();
		 	       
		 	        try {
		 	            Statement statement = connection.createStatement();
		 	            ResultSet rs = statement.executeQuery("SELECT * FROM users");
		 	            while(rs.next()) {
		 	            	Linnad linn=new Linnad();
		 	            	linn.setNimi(rs.getString("kasutajanimi"));
		 	            	linnade_list.add(linn);
		 	            }
		 	        } catch (SQLException e) {
		 	            e.printStackTrace();
		 	        }
		 	        return linnade_list;
		 	    }
}
