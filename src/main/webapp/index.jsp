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
			<button class="menu_button" id="Showcontent1">Linna valik</button>
			<button class="menu_button" id="Showcontent2">Pubi valik</button>
			<button class="menu_button" id="Showcontent3">Laua valik</button>
			<button class="menu_button" id="Showcontent4">Mingi asi</button>
			<button class="menu_button" id="login_button">Nupp1</button>
			<button class="menu_button" id="register_button">Nupp2</button>
		</div>
	</div>


	<div id="content1" class="contents">
		<div class="subcontent">
			<div class="content">
				VALI LINN
				<p>
					<select name="linnad" id="linnad">
						<option disabled="disabled" selected="selected">Vali linn</option>

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

				<!-- <form action="login" method="get">
						<table>
							<tr>
								<td>User</td>
								<td><input name="user" />
							</tr>
							<tr>
								<td>password</td>
								<td><input name="password" />
							</tr>
						</table>
						<input type="submit" />
					</form> -->
				VALI LINN
				<p>
					<select id="pubi_valik">
						<option value="Pahad Poisid">Pahad Poisid</option>
						<option value="Pubi 2">Pubi 2</option>
						<option value="Pubi 3">Pubi 3</option>
						<option value="Pubi 4">Pubi 4</option>
						<option value="Pubi 5">Pubi 5</option>
					</select>
				</p>
				<button class="menu_button" id="pubi_valik">Edasi</button>
			</div>
		</div>
	</div>



	<div id="content3" class="contents">
		<div class="subcontent">
			<div class="content">
				<p>
					VALI SOBIV LAUD


					<form action="register" method="post">
						Name: <input type="text" name="userName"><br> Email:
								<input type="text" name="userEmail"><br> Password:
										<input type="password" name=userPassword><br> <input
												type="submit" value="Submit">
					</form>

				</p>
				<button class="menu_button" id="laua_valik">Edasi</button>

			</div>
		</div>
	</div>

	<div id="content4" class="contents">
		<div class="subcontent">
			<div class="content">
				LOGIN
				<p>
					<form action="register" method="post">
						Name: <input type="text" name="userName"><br> Email:
								<input type="text" name="userEmail"><br> Password:
										<input type="password" name=userPassword><br> <input
												type="submit" value="Submit">
					</form>
				</p>
			</div>
		</div>
	</div>

	<div id="footer">Footer</div>
	<script type="text/javascript" src="scripts.js"></script>
</body>
</html>
