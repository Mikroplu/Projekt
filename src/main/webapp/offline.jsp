<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://www.facebook.com/2008/fbml">
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
	
<!-- 	<div id="fb-root"></div>
		<div id="status">
		</div>
		<div id="message">
			Logs:<br />
		</div> -->
		
	<div id="fb-root">
		<div class="fb-login-button" data-max-rows="1" data-size="medium" data-show-faces="false" data-auto-logout-link="true">Log in</div>
	</div>

	</div>
	<script type="text/javascript" src="scripts.js"></script>
	<script type="text/javascript" src="seatReservation.js"></script>
	<script type="text/javascript" src="fb.js"></script>
	<script src="//connect.facebook.net/en_US/all.js"></script>
	<script src="http://static.ak.connect.facebook.com/js/api_lib/v0.4/FeatureLoader.js.php" type="text/javascript"></script>
</body>
</html>
