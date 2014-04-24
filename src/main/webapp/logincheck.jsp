<%@ page import="java.sql.Connection" %>
<%@ page import="com.pubiapplication.app.*" %>
<%@ page import="java.security.NoSuchAlgorithmException" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
    Connection conn = DatabaseConnection.getConnection();
    String username = request.getParameter("username");
    String password = "";
    try {
        password = stringToHash.giveMeHash(request.getParameter("password"));
    } catch (NoSuchAlgorithmException e1) {
    }
    try {
        String query = "SELECT * FROM kasutajad WHERE KASUTAJANIMI=? AND PAROOL=?";
        PreparedStatement prepStmt = conn.prepareStatement(query);
        prepStmt.setString(1, username);
        prepStmt.setString(2, password);
        ResultSet rs = prepStmt.executeQuery();
        if (rs.next()) {
            int ID = rs.getInt("ID");
            String idstring = Integer.toString(ID);
            session.setAttribute("id", ID);
            session.setAttribute("user", username);
            session.setAttribute("password", password);
            session.setAttribute("eesnimi", rs.getString("EESNIMI"));
            session.setAttribute("perenimi", rs.getString("PERENIMI"));
            session.setAttribute("elukoht", rs.getString("ELUKOHT"));
            session.setAttribute("email", rs.getString("EMAIL"));
            session.setAttribute("telefon", rs.getString("TELEFON"));
            session.setAttribute("authenticated",true);
            session.setMaxInactiveInterval(30 * 60);

            Cookie userId = new Cookie("id", idstring);
            Cookie userName = new Cookie("user", username);
            Cookie userNimi = new Cookie("name", rs.getString("EESNIMI"));
            Cookie userSurname = new Cookie("surname", rs.getString("PERENIMI"));
            Cookie userLocation = new Cookie("location", rs.getString("ELUKOHT"));

            response.addCookie(userId);
            response.addCookie(userName);
            response.addCookie(userNimi);
            response.addCookie(userSurname);
            response.addCookie(userLocation);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("Error.jsp");
        }
    } catch (SQLException e) {

    } catch (Exception e) {

    }


%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>

</body>
</html>
