package com.pubiapplication.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(value = "/login")
public class Login extends HttpServlet {
	private static Connection conn = null;
    boolean login = false;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		conn = DatabaseConnection.getConnection();
		String user = req.getParameter("user");
		String pass = req.getParameter("password");
		try {
			Statement stmt = (Statement) conn.createStatement();
			String query ="SELECT * FROM users WHERE kasutajanimi="+lisa_ylakomad(user)+" AND parool="+lisa_ylakomad(pass);
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();
			
			int row_count=0;
			while(rs.next()) row_count+=1;
			if(row_count==0) response(resp,"Wrong username and or password");
			if(row_count==1) response(resp,"Success");
		} catch (SQLException e) {
			response(resp, "SQL EXCEPTION");
		} catch (Exception e) {
			response(resp, "EXCEPTION");
		}
	}
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
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
	public static String lisa_ylakomad(String a) {
		return "'" + a + "'";
	}
}