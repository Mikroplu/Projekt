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
public class login extends HttpServlet {
	String query;
    String dbUsername, dbPassword;

    boolean login = false;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("password");
		
		
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
			query ="SELECT username, password FROM users";
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next()){
                dbUsername = rs.getString("name");
                dbPassword = rs.getString("password");

                if(dbUsername.equals(user) && dbPassword.equals(pass)){
                    login = true;
                    response(resp,"Kasutaja leiti");
                }
                else response(resp,"Kasutajat ei leitud");
               
            }
			
		} catch (SQLException e) {

		} catch (Exception e) {
		}
		
	
	    
	    
		if ("Kasutaja".equals(user) && "Parool".equals(pass)) {
			response(resp, "Kasutajanimi ja parool esinevad andmebaasis");
		} else {
			response(resp, "Sellist kasutajat ei esine andmebaasis");
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
}