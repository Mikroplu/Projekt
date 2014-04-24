<%@ page import="com.pubiapplication.app.DatabaseConnection" %>
<%@ page import="java.security.NoSuchAlgorithmException" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.pubiapplication.app.stringToHash" %>
<%--
  Created by IntelliJ IDEA.
  User: indrek
  Date: 24.04.14
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    Connection conn = DatabaseConnection.getConnection();
    response.setContentType("text/html");
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String number = request.getParameter("number");
    String username = request.getParameter("userName");
    String email = request.getParameter("userEmail");
    String city = request.getParameter("location");
    String password = "";
    try {
        password = stringToHash.giveMeHash(request.getParameter("userPassword"));
    } catch (NoSuchAlgorithmException e1) {
        e1.printStackTrace();
    }

    try {
        String query = "SELECT * FROM kasutajad WHERE kasutajanimi=?";
        PreparedStatement prepStmt2 = conn.prepareStatement(query);
        prepStmt2.setString(1, username);
        ResultSet rs = prepStmt2.executeQuery();
        if (rs.next()) {
            response.sendRedirect("Error.jsp");
        } else {
            try {
                int id = 0;
                String query3 = "SELECT * FROM kasutajad";
                PreparedStatement prepStmt3 = conn.prepareStatement(query3);
                ResultSet rs2 = prepStmt3.executeQuery();

                while (rs2.next()) {
                    id = id + 1;
                }
                String query2 = "INSERT INTO kasutajad VALUES(default,?,?,?,?,?,?,?,?)";
                PreparedStatement prepStmt = conn.prepareStatement(query2);
                prepStmt.setString(1, name);
                prepStmt.setString(2, surname);
                prepStmt.setString(3, username);
                prepStmt.setString(4, password);
                prepStmt.setString(5, city);
                prepStmt.setString(6, email);
                prepStmt.setString(7, number);
                prepStmt.setBoolean(8, true);
                prepStmt.executeUpdate();
                response.sendRedirect("RegisterSuccess.jsp");
            } catch (Exception e) {

            }
        }

    } catch (SQLException e) {
    } catch (Exception e) {
    }


%>
<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>
