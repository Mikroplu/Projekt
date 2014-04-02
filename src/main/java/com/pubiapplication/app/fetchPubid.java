package com.pubiapplication.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class fetchPubid {

	private static Connection connection = null;
	public static ArrayList<Pubi> getAllLinnad() {
		connection = DatabaseConnection.getConnection();
		ArrayList<Pubi> pubide_list = new ArrayList<Pubi>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT DISTINCT asukoht FROM pubid ORDER BY asukoht ASC");
			while (rs.next()) {
				Pubi pubi = new Pubi();
				pubi.setAsukoht(rs.getString("asukoht"));
				pubide_list.add(pubi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pubide_list;
	}
	
	
public static ArrayList<Pubi> getPubidByLinn(String linn2) {
		String linn = Register.lisa_ylakomad(linn2);
		connection = DatabaseConnection.getConnection();
		ArrayList<Pubi> pubide_list = new ArrayList<Pubi>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM pubid WHERE asukoht="+linn+"ORDER BY asukoht ASC");
			while (rs.next()) {
				Pubi pubi = new Pubi();
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

public static ArrayList<Pubi> getNrOfSeatsByPubi(String pubi_nimi) {
	connection = DatabaseConnection.getConnection();
	ArrayList<Pubi> yks_pubi = new ArrayList<Pubi>();
	try {
		String query ="SELECT * FROM pubid WHERE nimi=?";
		PreparedStatement prepStmt = connection.prepareStatement(query);
		prepStmt.setString(1,pubi_nimi);
		ResultSet rs= prepStmt.executeQuery();
		while (rs.next()) {
			Pubi pubi = new Pubi();
			pubi.setNimi(rs.getString("nimi"));
			pubi.setAsukoht(rs.getString("asukoht"));
			pubi.setLaudade_arv(rs.getInt("laudade_arv"));
			yks_pubi.add(pubi);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return yks_pubi;
}
}
