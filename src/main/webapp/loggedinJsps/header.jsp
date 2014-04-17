<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<div id="headerLoggedin">
	<p id="headeri_kasutaja_info">
		Tere, <%=userName%>
	</p>
	<div id="buttons_menu">
		<button class="menu_button" id="register_button">Register</button>
		<button class="menu_button" id="addpub_button">Add pub</button>
		<button class="menu_button" id="userdetails_button">Profile</button>
		<form action="<%=response.encodeURL("logout")%>" method="post">
			<input type="submit" value="Logout">
		</form>
	</div>
</div>
