<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<% String stringstring = (String) session.getAttribute("user");%> 
	
	<div id="content7" class="contents">
	<%=stringstring%>
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