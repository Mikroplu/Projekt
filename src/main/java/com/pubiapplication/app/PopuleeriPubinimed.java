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

@WebServlet("/pubinimed")
public class PopuleeriPubinimed extends HttpServlet {
	private String linn;
	private static final long serialVersionUID = 1L;

	public PopuleeriPubinimed() {
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("valitud_linn");
		ArrayList<Pubid> pubid = new ArrayList<Pubid>();
		pubid = fetchPubid.getPubidByLinn(linn);
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(pubid,
				new TypeToken<List<Pubid>>() {
				}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
