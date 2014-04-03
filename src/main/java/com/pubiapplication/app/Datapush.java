package com.pubiapplication.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/datapush")
public class Datapush extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Pubi> pubid = new ArrayList<Pubi>();
		pubid = fetchPubid.getAllLinnad();

		// content type must be set to text/event-stream
		response.setContentType("text/event-stream");

		// encoding must be set to UTF-8
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();

		String data = (pubid.get(0)).getAsukoht();
		String data2 = (pubid.get(1)).getAsukoht();
		writer.write("data:" + data + "\n\n" + " data2:" + data2 + "\n\n");

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		writer.close();
	}
}