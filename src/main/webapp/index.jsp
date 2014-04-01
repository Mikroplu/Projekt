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
	<div id="header">
		<div id="buttons_menu">
			<button class="menu_button" id="register_button">Register</button>
			<button class="menu_button" id="login_button">Login</button>
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
					Name: <input type="text" name="userName"><br> Email: <input
						type="text" name="userEmail"><br> Password: <input
						type="password" name=userPassword><br>
					<button class=menu_button type="submit" value="Submit"
						id="register_button2">Register</button>


				</form>
				<button class="menu_button" id="tagasi_register">Home</button>

			</div>
		</div>
	</div>

	<div id="content5" class="contents">
		<div class="subcontent">
			<div class="content">
				LOGIN
				
				<form action="login" method="get">
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

	<div id="footer">Footer</div>
	<script type="text/javascript" src="scripts.js"></script>
	<script type="text/javascript" src="seatReservation.js"></script>
</body>
</html>
