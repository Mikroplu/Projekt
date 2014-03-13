<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"
		type="text/javascript"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Ryhm321</title>
</head>
<body>
	<div id="_header">
		<div id="_buttons_menu">
			<button class="menu_button" id="_Showcontent1">Show content1</button>
			<button class="menu_button" id="_Showcontent2">Show content2</button>
			<button class="menu_button" id="_Showcontent3">Show content3</button>
			<button class="menu_button" id="_Showcontent4">Show content4</button>
		</div>
		<button id="_login_button">Login</button>
		<button id="_register_button">Register</button>
	</div>


	<div id="_content1" class="content">
		<div class="subcontent">
			Div content1
			<p>Siin on content1 sisu</p>
		</div>
	</div>



	<div id="_content2" class="content">
		<div class="subcontent">
			Div content2
			<p>
				<form action="servlet" method="post">
					Name: <input type="text" name="userName"><br> Email: <input
							type="text" name="userEmail"><br> Password: <input
									type="password" name=userPassword><br> <input
											type="submit" value="Submit">
				</form>
			</p>
		</div>
	</div>



	<div id="_content3" class="content">
		<div class="subcontent">
			Div content3
			<p>Siin on content3 sisu</p>
		</div>
	</div>



	<div id="_content4" class="content">
		<div class="subcontent">
			Div content4
			<p>Siin on content4 sisu</p>
		</div>
	</div>



	<div id="_footer">Footer</div>
	<script type="text/javascript" src="scripts.js"></script>
</body>
</html>