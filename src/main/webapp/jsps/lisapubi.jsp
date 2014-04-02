<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
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

	<script type="text/javascript" src="scripts.js"></script>
</body>
</html>