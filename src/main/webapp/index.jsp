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
	<%@ include file="jsps/header.jsp"%>
	<%@ include file="jsps/linnavalik.jsp"%>
	<%@ include file="jsps/pubivalik.jsp"%>
	<%@ include file="jsps/broneerilaud.jsp"%>
	<%@ include file="jsps/ajutineboneeri.jsp"%>
	<%@ include file="jsps/registreeri.jsp"%>
	<%@ include file="jsps/login.jsp"%>
	<%@ include file="jsps/lisapubi.jsp"%>

	<div id="sisu" class="contents"></div>

	<div id="footer">
	
	<div id="fb-root"></div>
		<div id="status">
			Click on Below Image to start the demo: <br /> <img
				src="http://hayageek.com/examples/oauth/facebook/oauth-javascript/LoginWithFacebook.png"
				style="cursor: pointer;" onclick="Login()" />
		</div>

		<div id="message">
			Logs:<br />
		</div>

	</div>
	<script type="text/javascript" src="scripts.js"></script>
	<script type="text/javascript" src="seatReservation.js"></script>
	<script type="text/javascript" src="facebooklogin.js"></script>
	<script src="//connect.facebook.net/en_US/all.js"></script>
</body>
</html>
