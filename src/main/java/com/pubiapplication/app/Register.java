package com.pubiapplication.app;

import javax.servlet.*;
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
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

@WebServlet(value = "/register")
public class Register extends HttpServlet {
	private static Connection conn = null;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		conn = DatabaseConnection.getConnection();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String surname = request.getParameter("location");
		String number = request.getParameter("number");
		String username = request.getParameter("userName");
		String password ="";
		try {
			password = stringToHash(request.getParameter("userPassword"));
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		String email = request.getParameter("userEmail");
		String city = request.getParameter("location");

		try {
			String query = "SELECT * FROM kasutajad WHERE kasutajanimi=?";
			PreparedStatement prepStmt2 = conn.prepareStatement(query);
			prepStmt2.setString(1, username);
			ResultSet rs = prepStmt2.executeQuery();

			if (rs.next()) {
				response(response, "Selline kasutaja on juba olemas");
			} else {
				try {
					/*int id=0;
					String query3 = "SELECT * FROM kasutajad";
					PreparedStatement prepStmt3 = conn.prepareStatement(query3);
					ResultSet rs2 = prepStmt3.executeQuery();
					
					while (rs2.next()) {
						id=id+1;
					}*/
					String query2 = "INSERT INTO kasutajad VALUES(?,?,?,?,?,?,?,?,?)";
					PreparedStatement prepStmt = conn.prepareStatement(query2);
					prepStmt.setInt(1, 3);
					prepStmt.setString(2, name);
					prepStmt.setString(3, surname);
					prepStmt.setString(4, username);
					prepStmt.setString(5, password);
					prepStmt.setString(6, city);
					prepStmt.setString(7, email);
					prepStmt.setString(8, number);
					prepStmt.setBoolean(9, true);
					prepStmt.executeUpdate();
					response(response, "Kasutaja edukalt sisestatud andmebaasi");
				} catch (Exception e) {
					response(response, "Midagi läks pekki");
				}
			}

		} catch (SQLException e) {
			response(response, "SQL EXCEPTION");

		} catch (Exception e) {
			response(response, "Midagi läks pekki");
		}

	}

	public static String lisa_ylakomad(String a) {
		return "'" + a + "'";
	}

	private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
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
