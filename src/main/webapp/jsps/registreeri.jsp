<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<div id="content4" class="contents">
	<div class="subcontent">
		<div class="content">
			Register
			<form action="register" method="post">
				<label>Name</label> 
				<input type="text" name=name><br>
				<label>Surname</label>
				<input type="text" name=surname><br>
				<label>Telephon number</label>
				<input type="text" name=number><br>
				<label>Location</label>
				<input type="text" name=location><br>
				<label>Username</label>
				<input type="text" name="userName"><br> 
				<label>Password</label>
				<input type="password" name=userPassword><br> 
				<label>Email</label>
				<input type="text" name="userEmail"><br>
				<button class=menu_button type="submit" value="Submit"
					id="register_button2">Register</button>
			</form>
			<button class="menu_button allvasakul" id="tagasi_register">Home</button>
		</div>
	</div>
</div>