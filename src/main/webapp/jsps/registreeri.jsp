<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	
	<div id="content4" class="contents">
		<div class="subcontent">
			<div class="content">
				Register
				<form action="register" method="post">
					Name: <input type="text" name=name><br>
					Surname: <input type="text" name=surname><br>
					Telephone number: <input type="text" name=number><br>
					Location: <input type="text" name=location><br>
					Username: <input type="text" name="userName"><br>
					Password: <input type="password" name=userPassword><br>
					Email: <input type="text" name="userEmail"><br> 
					<button class=menu_button type="submit" value="Submit" id="register_button2">Register</button>
				</form>
				<button class="menu_button" id="tagasi_register">Home</button>

			</div>
		</div>
	</div>
</body>
</html>