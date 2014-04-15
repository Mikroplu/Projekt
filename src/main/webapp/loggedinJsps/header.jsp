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
<div id="headerLoggedin">
	<p id="headeri_kasutaja_info">
		Olete sisse logitud kasutajana: <%=userName%>
	</p>
	<div id="buttons_menu">
		<button class="menu_button" id="register_button">Register</button>
		<button class="menu_button" id="addpub_button">Add pub</button>
		<button class="menu_button" id="userdetails_button">Profile</button>
		<form action="<%=response.encodeURL("logout")%>" method="post">
			<input type="submit" value="Logout">
		</form>
	</div>
</div>
