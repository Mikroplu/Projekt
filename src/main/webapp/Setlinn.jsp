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
        String valitud_linn=request.getParameter("linnad");
        int id=fetchPubid.getIDByName(valitud_linn);
        session.setAttribute("linna_id",id);
        response.sendRedirect("pubivalik.jsp");
%>
<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>
