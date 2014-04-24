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
			ResultSet rs = statement.executeQuery("SELECT DISTINCT asukoht FROM pub ORDER BY asukoht ASC");
			while (rs.next()) {
				Pubi pubi = new Pubi();
				//pubi.setID(rs.getInt("id"));
				pubi.setAsukoht(rs.getString("asukoht"));
				//pubi.setNimi(rs.getString("nimi"));
				//pubi.setLaudade_arv(rs.getInt("laudade_arv"));
				pubide_list.add(pubi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pubide_list;
	}
	
	
public static ArrayList<Pubi> getPubidByLinn(String linn2) {
		connection = DatabaseConnection.getConnection();
		ArrayList<Pubi> pubide_list = new ArrayList<Pubi>();
		try {
			
			String query="SELECT nimi FROM pub WHERE asukoht=? ORDER BY asukoht ASC";
			PreparedStatement prepStmt = connection.prepareStatement(query);
			prepStmt.setString(1,linn2);
			ResultSet rs= prepStmt.executeQuery();
			while (rs.next()) {
				Pubi pubi = new Pubi();
				pubi.setNimi(rs.getString("nimi"));
				pubide_list.add(pubi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pubide_list;
	}

public static ArrayList<Pubi> getNrOfTablesByPubi(String pubi_nimi,String valitud_linn) {
	connection = DatabaseConnection.getConnection();
	ArrayList<Pubi> yks_pubi = new ArrayList<Pubi>();
	try {
		//Lause mis v�ttis pub tabelist laudade arvu. tegin lause mis kasutab joini asemele
		//***Vana lihtne ja ilus lause****
		//String query ="SELECT laudade_arv FROM pub WHERE nimi=? AND asukoht=?";
		
		//See annab tulemuse lauad tabelist lugedes ja on tehtud join lause n�iteks. 
		//***TEGU ON V�GA KOLEDA JA M�TTETU VIISIGA***
	    String query ="select count(*) as laudade_arv  from (SELECT lauad.laua_nr, lauad.broneeritud, lauad.kohti as Broneeritud_kohti, kasutajad.kasutajanimi as Broneerija_nimi, pub.nimi as Pubi_nimi from lauad inner join pub	on lauad.pubi=pub.id left join kasutajad on lauad.kasutaja=kasutajad.id) as foo	where pubi_nimi=?	group by pubi_nimi";
	    //Kui tahad vana viisi tagasi kommenteeri see v�lja ja v�ta vanalt kommentaarid �ra	
		
		PreparedStatement prepStmt = connection.prepareStatement(query);
		prepStmt.setString(1,pubi_nimi);
		ResultSet rs= prepStmt.executeQuery();
		while (rs.next()) {
			Pubi pubi = new Pubi();
			pubi.setLaudade_arv(rs.getInt("laudade_arv"));
			yks_pubi.add(pubi);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return yks_pubi;
}

    public static int getIDByName(String pubi_nimi){
        connection =DatabaseConnection.getConnection();
        Pubi pubi=new Pubi();
        try{
            String query = "SELECT id FROM pub WHERE nimi=?";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setString(1,pubi_nimi);
            ResultSet rs = prep.executeQuery();
            while (rs.next()){
                pubi.setID(rs.getInt("id"));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pubi.getID();
    }
}
