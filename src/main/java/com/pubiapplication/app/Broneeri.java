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
	int row_count = 0;
	private static Connection conn = null;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		conn = DatabaseConnection.getConnection();
		response.setContentType("text/html");
		int laua_number = Integer.parseInt(request.getParameter("lauaNumber"));
		String pubi_nimi = request.getParameter("pubinimi");
		//need andmed on vaja kätte saada sisselogitud kasutajalt
		String broneeritud = "true";
		int kastuajaid = 1;
		String kohtade_arv = "4";

		try {
			String query2 = "INSERT INTO lauad VALUES(default,?,?,?,?,?)";
			PreparedStatement prepStmt = conn.prepareStatement(query2);
			prepStmt.setInt(1, laua_number);
			prepStmt.setString(2, pubi_nimi);
			prepStmt.setString(3, broneeritud);
			prepStmt.setInt(4, kastuajaid);
			prepStmt.setString(5, kohtade_arv);
			prepStmt.executeUpdate();
			response(response, "Laud " + laua_number
					+ " edukalt lisatud, kasutaja " + kastuajaid
					+ " poolt, pubisse " + pubi_nimi);
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
