<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
String userName = null;
String userNimi=null;
String userLocation=null;
String userSurname=null;
	//allow access only if session exists
	if (session.getAttribute("user") == null) {
		response.sendRedirect("index.jsp");
	} else
		userName = (String) session.getAttribute("user");
	String sessionID = null;
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
		}
	}
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>PUBIPUBI</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<link rel="stylesheet" type="text/css" href="seatReserv.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"
	type="text/javascript"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<%@ include file="loggedinJsps/header.jsp"%>
	<%@ include file="jsps/linnavalik.jsp"%>
	<%@ include file="jsps/pubivalik.jsp"%>
	<%@ include file="loggedinJsps/broneerilaud.jsp"%>
	<%@ include file="loggedinJsps/ajutineboneeri.jsp"%>
	<%@ include file="loggedinJsps/userdetails.jsp"%>
	<%@ include file="jsps/registreeri.jsp"%>
	<%@ include file="jsps/lisapubi.jsp"%>
	<div id="sisu" class="contents"></div>



	<div id="footerLoggedin"></div>
	<script type="text/javascript" src="scripts.js"></script>
	<script type="text/javascript" src="seatReservation.js"></script>
</body>
</html>
