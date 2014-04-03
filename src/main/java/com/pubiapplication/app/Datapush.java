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

        //content type must be set to text/event-stream
        response.setContentType("text/event-stream");  
 
        //encoding must be set to UTF-8
        response.setCharacterEncoding("UTF-8");
 
        PrintWriter writer = response.getWriter();
 
        for(int i=0; i<pubid.size(); i++) {
        	
            writer.write("data: "+ (pubid.get(i)).getAsukoht() +"\n\n");
 
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writer.close();
    }
}