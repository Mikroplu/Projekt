<%@ page import="com.pubiapplication.app.fetchPubid" %>
<%--
  Created by IntelliJ IDEA.
  User: indrek
  Date: 24.04.14
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String valitud_pubi=request.getParameter("pubid");
    int id=fetchPubid.getIDByName(valitud_pubi);
    session.setAttribute("pubi_id",id);
    response.sendRedirect("loggedinJsps/broneerilaud.jsp");
%>
<html>
<head>
    <title></title>
</head>
<body>
<%out.print(id);
out.print(valitud_pubi);%>
</body>
</html>
