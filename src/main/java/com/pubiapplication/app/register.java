package com.pubiapplication.app;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
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
public class register extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("userName");
		String email = req.getParameter("userEmail");
		String password = req.getParameter("userPassword");
		out.println(name);
		out.println(email);
		out.println(password);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("userName");
		String email = request.getParameter("userEmail");
		String password = request.getParameter("userPassword");
		String ip = request.getRemoteAddr();

		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://ec2-184-73-251-115.compute-1.amazonaws.com:5432/dfh8pe9gkitn22";
			Properties props = new Properties();
			props.setProperty("user", "vryoynyziocgrs");
			props.setProperty("password", "T6JbGvxZfTtZviY37Cdc1O4mfJ");
			props.setProperty("ssl", "true");
			props.setProperty("sslmode", "require");
			Connection conn = DriverManager.getConnection(url, props);
			Statement stmt = (Statement) conn.createStatement();
			String query = "SELECT name, password FROM users";
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				String dbUsername = rs.getString("name");
				String dbPassword = rs.getString("password");
				if (dbUsername.equals(name)) {
					response(response, "Selline kasutajanimi on juba olemas");
				} else {
					try {
						Statement st = conn.createStatement();
						String test = "INSERT INTO users VALUES("
								+ lisa_ylakomad(name) + ","
								+ lisa_ylakomad(email) + ","
								+ lisa_ylakomad(password) + ","
								+ lisa_ylakomad(ip) + ");";
						ResultSet rs2 = st.executeQuery(test);
						PreparedStatement ps = conn
								.prepareStatement("INSERT INTO users VALUES(?,?,?);");
						//security
						MessageDigest digest = MessageDigest.getInstance("SHA-1");
						byte[] hasBytes = digest.digest(password.getBytes("UTF-8"));
						
						ps.setString(1, name);
						ps.setString(2, email);
						ps.setString(3, password);
						ps.execute();

						response(response,
								"Kasutaja edukalt sisestatud andmebaasi");
					} catch (SQLException e) {

					} catch (Exception e) {
					}

				}
			}
		} catch (SQLException e) {

		} catch (Exception e) {
		}

	}

	public String lisa_ylakomad(String a) {
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
