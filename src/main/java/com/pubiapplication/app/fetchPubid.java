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

import org.postgresql.jdbc4.Jdbc4Connection;

public class fetchPubid {
	static Jdbc4Connection getConnection2(){
		return null;
	}
	private static Connection connection = null;
	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://ec2-184-73-251-115.compute-1.amazonaws.com:5432/dfh8pe9gkitn22";
				Properties props = new Properties();
				props.setProperty("user", "vryoynyziocgrs");
				props.setProperty("password", "T6JbGvxZfTtZviY37Cdc1O4mfJ");
				props.setProperty("ssl", "true");
				props.setProperty("sslmode", "require");
				
				connection = DriverManager.getConnection(url, props);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}

	public static ArrayList<Pubid> getAllLinnad() {
		connection = fetchPubid.getConnection();
		ArrayList<Pubid> pubide_list = new ArrayList<Pubid>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT DISTINCT asukoht FROM pubid ORDER BY asukoht ASC");
			while (rs.next()) {
				Pubid pubi = new Pubid();
				pubi.setAsukoht(rs.getString("asukoht"));
				pubide_list.add(pubi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pubide_list;
	}
	
	
public static ArrayList<Pubid> getPubidByLinn(String linn) {
		
		connection = fetchPubid.getConnection();
		ArrayList<Pubid> pubide_list = new ArrayList<Pubid>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM pubid WHERE linn="+linn);
			while (rs.next()) {
				Pubid pubi = new Pubid();
				pubi.setNimi(rs.getString("nimi"));
				pubi.setAsukoht(rs.getString("asukoht"));
				pubi.setLaudade_arv(rs.getInt("laudade_arv"));
				pubide_list.add(pubi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pubide_list;
	}
}
