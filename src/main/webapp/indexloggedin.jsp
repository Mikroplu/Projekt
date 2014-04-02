<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
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
	<div id="header">
		<div id="buttons_menu">
			<%=userName%>
			<button class="menu_button" id="register_button">Register</button>
			
			<button class="menu_button" id="addpub_button">Add pub</button>
		</div>
	</div>


	<div id="content1" class="contents">
		<div class="subcontent">
			<div class="content">
				VALI LINN
				<p>
					<select name="linnad" id="linnad">
					</select>
				</p>
				<button class="menu_button" id="linna_valik">Edasi</button>
			</div>

		</div>
	</div>



	<div id="content2" class="contents">
		<div class="subcontent">
			<div class="content">
				PUBI VALIK
				<p>
					<select id="pubid">
					</select>
				</p>
				<button class="menu_button" id="pubi_valik">Edasi</button>
				<button class="menu_button" id="tagasi_pubi">Tagasi</button>
			</div>
		</div>
	</div>



	<div id="content3" class="contents">
		<div class="subcontent">
			<div class="content">
				<p>VALI SOBIV LAUD</p>

				<div id="holder">
					<ul id="place">
					</ul>
				</div>
				<button class="menu_button" id="laua_valik">Edasi</button>
				<button class="menu_button" id="tagasi_laud">Tagasi</button>
			</div>
		</div>
	</div>



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

	<div id="content6" class="contents">
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
	</div>
	
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

	<div id="footer"></div>
	<script type="text/javascript" src="scripts.js"></script>
	<script type="text/javascript" src="seatReservation.js"></script>
</body>
</html>
