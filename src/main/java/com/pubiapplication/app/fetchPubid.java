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

public class fetchPubid {

	private static Connection connection = null;
	public static ArrayList<Pubid> getAllLinnad() {
		connection = DatabaseConnection.getConnection();
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
	
	
public static ArrayList<Pubid> getPubidByLinn(String linn2) {
		String linn = register.lisa_ylakomad(linn2);
		connection = DatabaseConnection.getConnection();
		ArrayList<Pubid> pubide_list = new ArrayList<Pubid>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM pubid WHERE asukoht="+linn+"ORDER BY asukoht ASC");
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
