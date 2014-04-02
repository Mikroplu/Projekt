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
	<%@ include file="jsps/header.jsp" %>
	<%@ include file="jsps/linnavalik.jsp" %>
	<%@ include file="jsps/pubivalik.jsp" %>
	<%@ include file="jsps/broneerilaud.jsp" %>
	<%@ include file="jsps/ajutineboneeri.jsp" %>
	<%@ include file="jsps/registreeri.jsp" %>
	<%@ include file="jsps/login.jsp" %>
	<%@ include file="jsps/lisapubi.jsp" %>
	
	<div id="sisu" class="contents">

	</div>

<!-- 	<div id="content4" class="contents">
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
	</div> -->

<!-- 	<div id="content5" class="contents">
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
	</div> -->

<!-- 	<div id="content6" class="contents">
		<div class="subcontent">
			<div class="content">
				LISA PUBI
				
				<form action="addpub" method="post">
					Nimi: <input type="text" name="pubiNimi"><br> Asukoht:
					<input type="text" name="pubiAsukoht"><br> Laudade
					arv: <input type="text" name="laudadeArv"><br>
					<button class=menu_button type="submit" value="Submit"
						id="lisa_pubi">Lisa pubi</button>

				</form>
				<button class="menu_button" id="tagasi_addpub">Home</button>
				
			</div>
		</div>
	</div> -->
	
<!-- 	<div id="content7" class="contents">
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
	</div> -->

	<div id="footer">Footer</div>
	<script type="text/javascript" src="scripts.js"></script>
	<script type="text/javascript" src="seatReservation.js"></script>
</body>
</html>
