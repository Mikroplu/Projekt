//when Facebook's SDK is loaded, it calls "window.fbAsyncInit"
// the SDK load is the second block of code below
window.fbAsyncInit = function() {
	FB.init({
		appId : '260614934118793', // App ID
		channelUrl : '//pubipubi.herokuapp.com', // Channel File
		status : true,
		cookie : true,
		xfbml : true,
		oauth : true
	});
	// Additional initialization code here
	
	////// Siia lähevad funktsioonid mida tahame kasutada FB kaudu

	FB.getLoginStatus(function(response) {
		if (response.status === 'connected') {
			// the user is logged in and has authenticated your
			// app, and response.authResponse supplies
			// the user's ID, a valid access token, a signed
			// request, and the time the access token
			// and signed request each expire
			var uid = response.authResponse.userID;
			var accessToken = response.authResponse.accessToken;
			alert(uid);
			alert(accessToken);
		} else if (response.status === 'not_authorized') {
			// the user is logged in to Facebook,
			// but has not authenticated your app
		} else {
			// the user isn't logged in to Facebook.
		}
	});
	
	////////// Kuni siiani (vt. üles)
	
	// the above is the fairly standard example from Facebook
	// now we'll do something custom
	// we want to wrap all our facebook init stuff within a function that runs
	// post async, but is cached across the site

};
// this block actually loads the SDK
(function(d) {
	var js, id = 'facebook-jssdk';
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement('script');
	js.id = id;
	js.async = true;
	js.src = "//connect.facebook.net/en_US/all.js";
	d.getElementsByTagName('head')[0].appendChild(js);
}(document));