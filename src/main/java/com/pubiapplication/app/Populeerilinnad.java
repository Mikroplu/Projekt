package com.pubiapplication.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@WebServlet("/linnad")
public class Populeerilinnad extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Populeerilinnad() {
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Linnad> linnad = new ArrayList<Linnad>();
		linnad = fetchLinnad.getAllLinnad();
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(linnad,
				new TypeToken<List<Linnad>>() {
				}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
