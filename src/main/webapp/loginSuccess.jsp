<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Sisselogimine õnnestus</title>
</head>
<body>
	<%
		//allow access only if session exists
		String user = null;
		if (session.getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
		} else
			user = (String) session.getAttribute("user");
		String userName = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user"))
					userName = cookie.getValue();
				if (cookie.getName().equals("JSESSIONID"))
					sessionID = cookie.getValue();
			}
		} else {
			sessionID = session.getId();
		}
	%>
	<h3>
		Tere
		<%=userName%>, olet sisse logitud. Sinu sessiooni ID on: <%=sessionID%></h3>
	<br> Kasutajanimi=<%=user%>
	<br>
	<!-- need to encode all the URLs where we want session information to be passed -->
	<a href="<%=response.encodeURL("indexloggedin.jsp")%>">Checkout Page</a>
	<form action="<%=response.encodeURL("LogoutServlet")%>" method="post">
		<input type="submit" value="Logi välja">
	</form>
</body>
</html>