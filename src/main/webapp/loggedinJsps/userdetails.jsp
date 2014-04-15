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
<div id="content9" class="contents">
	<div class="subcontent">
		<div class="content">
			Nimi: <%=userNimi%><br>
			Perenimi: <%=userSurname%><br>
			Asukoht: <%=userLocation%> <br>
			<button class="menu_button" id="tagasi_userdetails">Home</button>
		</div>
	</div>
</div>
