package com.pubiapplication.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebook.api.FacebookJsonRestClient;


@WebServlet(value = "/login")
public class Login extends HttpServlet {
	private static Connection conn = null;
    boolean login = false;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		conn = DatabaseConnection.getConnection();
		String user = req.getParameter("user");
		String pass="";
		try {
			pass = stringToHash(req.getParameter("password"));
		} catch (NoSuchAlgorithmException e1) {

			e1.printStackTrace();
		}
		
		
		try {
			String query ="SELECT * FROM kasutajad WHERE KASUTAJANIMI=? AND PAROOL=?";
			PreparedStatement prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1,user);
			prepStmt.setString(2,pass);
			ResultSet rs= prepStmt.executeQuery();
			if(rs.next()){
                HttpSession session = req.getSession();
				int ID=rs.getInt("ID");
                String idstring = Integer.toString(ID);
                session.setAttribute("id",ID);
	            session.setAttribute("user", user);
	            session.setAttribute("password", pass);
	            session.setAttribute("eesnimi", rs.getString("EESNIMI"));
	            session.setAttribute("perenimi", rs.getString("PERENIMI"));
	            session.setAttribute("elukoht", rs.getString("ELUKOHT"));
	            session.setAttribute("email", rs.getString("EMAIL"));
	            session.setAttribute("telefon", rs.getString("TELEFON"));

	            session.setMaxInactiveInterval(30*60);

                Cookie userId =  new Cookie("id",idstring);
	            Cookie userName = new Cookie("user", user);
	            Cookie userNimi = new Cookie("name", rs.getString("EESNIMI"));
	            Cookie userSurname = new Cookie("surname",rs.getString("PERENIMI"));
	            Cookie userLocation = new Cookie("location", rs.getString("ELUKOHT"));

                resp.addCookie(userId);
	            resp.addCookie(userName);
	            resp.addCookie(userNimi);
	            resp.addCookie(userSurname);
	            resp.addCookie(userLocation);
	            String encodedURL = resp.encodeRedirectURL("index.jsp");
	            resp.sendRedirect(encodedURL);
			}
			else{
				resp.sendRedirect(resp.encodeRedirectURL("offline.jsp"));
			}
		} catch (SQLException e) {

		} catch (Exception e) {

		}
	}
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	}



	public static String stringToHash(String password)
			throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		return sb.toString();
	}
}