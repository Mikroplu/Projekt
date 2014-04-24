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

@WebServlet(value = "/broneeri")
public class Broneeri extends HttpServlet {
	private static Connection conn = null;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		conn = DatabaseConnection.getConnection();
		response.setContentType("text/html");
		try {
			String query2 = "UPDATE lauad SET broneeritud=true, kasutaja=? WHERE pubi=? AND laua_nr=?";
			PreparedStatement prepStmt = conn.prepareStatement(query2);
            int laua_number = (Integer) request.getAttribute("lauaNumber");
            int kasutajaId= (Integer) request.getAttribute("userId");
            int pubiId= (Integer) request.getAttribute("pubiId");

			prepStmt.setInt(1, kasutajaId);
			prepStmt.setInt(2, pubiId);
			prepStmt.setInt(3, laua_number);
			prepStmt.executeUpdate();
            response.sendRedirect("index.jsp");
		} catch (Exception e) {
			response(response,e.getMessage());
		}

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
