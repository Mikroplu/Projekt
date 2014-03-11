package com.pubiapplication.app;
import javax.servlet.*;
import java.io.IOException;
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




@WebServlet(value="/servlet")
public class servlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletOutputStream out = resp.getOutputStream();
		String name = req.getParameter("userName");
		String email = req.getParameter("userEmail");
		String password = req.getParameter("userPassword");
		String ip = req.getRemoteAddr();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>This is the response</title>");
		out.println("</head>");
		out.println("</head>");
		out.println("<body>");
		out.println("Kasutajanimi: " + name);
		out.println("Email: " + email);
		out.println("Parool: " + password);
		out.println("Ip: " + ip);
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		java.io.PrintWriter out = response.getWriter();
		
		try {
			Class.forName("org.postgresql.Driver");
			
			
			String url = "jdbc:postgresql://ec2-184-73-251-115.compute-1.amazonaws.com:5432/dfh8pe9gkitn22";
			Properties props = new Properties();
			props.setProperty("user","vryoynyziocgrs");
			props.setProperty("password","T6JbGvxZfTtZviY37Cdc1O4mfJ");
			props.setProperty("ssl","true");
			props.setProperty("sslmode", "require");
			Connection conn = DriverManager.getConnection(url, props);
			
			String name = request.getParameter("userName");
			String email = request.getParameter("userEmail");
			String password = request.getParameter("userPassword");
			String ip = request.getRemoteAddr();
			
		    String test = "INSERT INTO users VALUES("+lisa_ylakomad(name)+","+lisa_ylakomad(email)+","+lisa_ylakomad(password)+","+lisa_ylakomad(ip)+");";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(test);
			
		} catch (SQLException e) {
			out.println(e);
			out.println("SQL EX");
		} catch (Exception e) {
			out.println(e);
			out.println("EX");
		}
		
		
	}
	public String lisa_ylakomad(String a){
		return "'"+a+"'";
	}
}
