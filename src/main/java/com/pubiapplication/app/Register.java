package com.pubiapplication.app;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
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
	int row_count=0;
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
		String password = request.getParameter("userPassword");
		String email = request.getParameter("userEmail");
		String city = request.getParameter("location");
		
		

		

		try {
			String query = "SELECT * FROM users WHERE kasutajanimi=?";
			PreparedStatement prepStmt2 = conn.prepareStatement(query);
			prepStmt2.setString(1,username);
			ResultSet rs= prepStmt2.executeQuery();
			
			if(rs.next()){
				response(response, "Selline kasutaja on juba olemas");
			}
			else{
				try {
					String query2 = "INSERT INTO users VALUES(?,?,?,?,?,?,?)";
					PreparedStatement prepStmt = conn.prepareStatement(query2);
					prepStmt.setString(1, name);
					prepStmt.setString(2, surname);
					prepStmt.setString(3, username);
					prepStmt.setString(4, password);
					prepStmt.setString(5, city);
					prepStmt.setString(6, email);
					prepStmt.setString(7, number);
					prepStmt.executeUpdate();
					response(response, "Kasutaja edukalt sisestatud andmebaasi");
					row_count=0;
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
}
