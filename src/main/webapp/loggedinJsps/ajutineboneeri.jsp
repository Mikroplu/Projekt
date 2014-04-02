<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	
	<div id="content7" class="contents">
		<div class="subcontent">
			<div class="content">
				BRONEERI
				<form action="broneeri" method="post">
					Laua number: <input type="text" name="lauaNumber" id="laua_number"><br>
					<button class=menu_button type="submit" value="Submit"
						id="broneeri">Broneeri</button>
				</form>
				<button class="menu_button" id="tagasi_broneeri">Home</button>
				
			</div>
		</div>
	</div>
</body>
</html>