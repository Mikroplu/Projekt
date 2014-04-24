<%@ page import="com.pubiapplication.app.DatabaseConnection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.io.Writer" %>
<%--
  Created by IntelliJ IDEA.
  User: indrek
  Date: 24.04.14
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Connection conn = DatabaseConnection.getConnection();
    response.setContentType("text/html");
    try {
        String query2 = "UPDATE lauad SET broneeritud=true, kasutaja=? WHERE pubi=? AND laua_nr=?";
        PreparedStatement prepStmt = conn.prepareStatement(query2);
        int laua_number = (Integer) Integer.parseInt(request.getParameter("laud"));
        int kasutajaId= (Integer) session.getAttribute("id");
        int pubiId= (Integer) session.getAttribute("pubi_id");

        prepStmt.setInt(1, kasutajaId);
        prepStmt.setInt(2, pubiId);
        prepStmt.setInt(3, laua_number);
        prepStmt.executeUpdate();
        response.sendRedirect("BroneeriSuccess.jsp");
    } catch (Exception e) {


        response.sendRedirect("Error.jsp");
    }
%>
<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>
