<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pubi321</title>
<link rel="stylesheet" type="text/css" href="styles.css">
	<script type="text/javascript" src="scripts.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"
		type="text/javascript"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Ryhm321</title>
</head>
<body>
<div id="header">
		<div id="buttons_menu">
			<button class="menu_button" onclick="showdiv('content1')">Pealeht</button>
			<button class="menu_button" onclick="showdiv('content2')">Register</button>
			<button class="menu_button" onclick="showdiv('content3')">Show content3</button>
			<button class="menu_button" onclick="showdiv('content4')">Show content4</button>
		</div>

		<button id="login_button">Login</button>
		<button id="register_button">Register</button>
	</div>


	<div id="content1" class="content">
		<div class="subcontent">
			Div content1
			<p>Siin on content1 sisu</p>
		</div>
	</div>



	<div id="content2" class="content">
		<div class="subcontent">
			Div content2
			<form action="servlet1" method="post">
			Name: <input type="text" name="userName"><br>
			Email: <input type="text" name="userEmail"><br>	
			Password: <input type="password" name=userPassword><br>
			<input type="submit"  value="Submit">
			</form>
		</div>
	</div>



	<div id="content3" class="content">
		<div class="subcontent">
			Div content3
			<p>Siin on content3 sisu</p>
		</div>
	</div>



	<div id="content4" class="content">
		<div class="subcontent">
			Div content4
			<p>Siin on content4 sisu</p>
		</div>
	</div>



	<div id="footer">Footer</div>

</body>
</html>