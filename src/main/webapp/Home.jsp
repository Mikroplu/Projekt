<%--
  Created by IntelliJ IDEA.
  User: indrek
  Date: 24.04.14
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String userName = null;
    String userNimi=null;
    String userLocation=null;
    String userSurname=null;
    String userID=null;
    //allow access only if session exists
    if (session.getAttribute("authenticated") == null) {
        response.sendRedirect("login.jsp");
    } else
        userName = (String) session.getAttribute("user");
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user"))
                userName = cookie.getValue();

            if (cookie.getName().equals("name"))
                userNimi = cookie.getValue();

            if (cookie.getName().equals("surname"))
                userSurname = cookie.getValue();

            if (cookie.getName().equals("location"))
                userLocation = cookie.getValue();

            if (cookie.getName().equals("id"))
                userID = cookie.getValue();
        }
    }
%>
<html>
<head>
    <title></title>
</head>
<body>
hello, <%=userName%>, <%=userNimi%>, <%=userSurname%>, <%=userLocation%>,<%=userID%>
<a href="Logout.jsp">Logout</a>
</body>
</html>
