<%@ page language="java" contentType="text/html; charset=UTF-8"%>

	<div id="content5" class="contents">
		<div class="subcontent">

		</div>
        <div class="content">
            LOGIN
            <p>
                Logi sisse, kasutades registreerimise käigus sisestatud andmeid.
            </p>
            <form action="logincheck.jsp" method="post">
                <label>Username</label>
                <input name="username" type="text" /><br>
                <label>Password</label>
                <input name="password" type="password" /><br>
                <button type="submit" class=menu_button id="login_nupp">Login</button>
            </form>
            <button class="menu_button allvasakul" id="tagasi_login">Home</button>

        </div>
	</div>
