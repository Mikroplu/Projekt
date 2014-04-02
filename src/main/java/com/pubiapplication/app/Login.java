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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String query ="SELECT * FROM users WHERE kasutajanimi=? AND parool=?";
			PreparedStatement prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1,user);
			prepStmt.setString(2,pass);
			ResultSet rs= prepStmt.executeQuery();
			if(rs.next()){
				HttpSession session = req.getSession();
	            session.setAttribute("user", user);
	            //setting session to expiry in 30 mins
	            session.setMaxInactiveInterval(30*60);
	            Cookie userName = new Cookie("user", user);
	            resp.addCookie(userName);
	            //Get the encoded URL string
	            String encodedURL = resp.encodeRedirectURL("loginSuccess.jsp");
	            resp.sendRedirect(encodedURL);
			}
			else{
				response(resp,"Sellist kasutajat ei eksisteeri");
			}
		} catch (SQLException e) {
			response(resp, "SQL EXCEPTION");
		} catch (Exception e) {
			response(resp, "EXCEPTION");
		}
	}
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	}

	public static void response(HttpServletResponse resp, String msg)
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