window.fbAsyncInit = function() {
	FB.init({
		appId : '1492728744281952', 
		channelUrl : 'http://pubipubi.herokuapp.com', 
		status : true,
		cookie : true,
		xfbml : true
	});

	FB.Event
			.subscribe(
					'auth.authResponseChange',
					function(response) {
						if (response.status === 'connected') {
							document.getElementById("message").innerHTML += "<br>Connected to Facebook";

						} else if (response.status === 'not_authorized') {
							document.getElementById("message").innerHTML += "<br>Failed to Connect";
						} else {
							document.getElementById("message").innerHTML += "<br>Logged Out";
						}
					});

};

function Login() {
	FB.login(function(response) {
		if (response.authResponse) {
			getUserInfo();
		} else {
			console.log('User cancelled login or did not fully authorize.');
		}
	}, {
		scope : 'email,user_photos,user_videos'
	});

}

function getUserInfo() {
	FB
			.api(
					'/me',
					function(response) {
						var str = "<b>Name</b> : " + response.name + "<br>";
						str += "<b>Username:</b> " + response.username + "<br>";
						str += "<b>id: </b>" + response.id + "<br>";
						document.getElementById("status").innerHTML = str;
					});
}
function getPhoto() {
	FB.api('/me/picture?type=normal', function(response) {

		var str = "<br/><b>Pic</b> : <img src='" + response.data.url + "'/>";
		document.getElementById("status").innerHTML += str;
	});
}
function Logout() {
	FB.logout(function() {
		document.location.reload();
	});
}
(function(d) {
	var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement('script');
	js.id = id;
	js.async = true;
	js.src = "//connect.facebook.net/en_US/all.js";
	ref.parentNode.insertBefore(js, ref);
}(document));