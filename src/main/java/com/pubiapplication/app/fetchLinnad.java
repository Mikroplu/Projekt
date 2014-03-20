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

	public static ArrayList<Linnad> getAllLinnad() {
		
		connection = fetchLinnad.getConnection();
		ArrayList<Linnad> linnade_list = new ArrayList<Linnad>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM linnad");
			while (rs.next()) {
				Linnad linn = new Linnad();
				linn.setNimi(rs.getString("nimi"));
				linnade_list.add(linn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linnade_list;
	}
}
