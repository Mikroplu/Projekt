<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
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
				<button class="menu_button" id="laua_valik">Edasi</button>
				<button class="menu_button" id="tagasi_laud">Tagasi</button>

			</div>
		</div>
	</div>



	<div id="content4" class="contents">
		<div class="subcontent">
			<div class="content">
				Register
				<p>
					<form action="register" method="post">
						Name: <input type="text" name="userName"><br> Email:
								<input type="text" name="userEmail"><br> Password:
										<input type="password" name=userPassword><br>
												<button class=menu_button type="submit" value="Submit"
													id="register_button2">Register</button>
													
													
					</form>
					<button class="menu_button" id="tagasi_register">Home</button>
				</p>
			</div>
		</div>
	</div>

	<div id="content5" class="contents">
		<div class="subcontent">
			<div class="content">
				LOGIN
				<p>
					<form action="login" method="get">


						User: <input name="user" /><br> Password: 
						<input name="password" /><br>
						<button type="submit" class=menu_button id="login_nupp">Login</button>
						
					</form>
					<button class="menu_button" id="tagasi_login">Home</button>
				</p>
			</div>
		</div>
	</div>

	<div id="footer">Footer</div>
	<script type="text/javascript" src="scripts.js"></script>
</body>
</html>
