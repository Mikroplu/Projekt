<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div id="content5" class="contents">
		<div class="subcontent">
			<div class="content">
				LOGIN
				
				<form action="login" method="post">
					User: <input name="user" type="text" /><br> Password: <input
						name="password" type="password" /><br>
					<button type="submit" class=menu_button id="login_nupp">Login</button>
				</form>
				<button class="menu_button" id="tagasi_login">Home</button>
				
			</div>
		</div>
	</div>

	<script type="text/javascript" src="scripts.js"></script>
</body>
</html>