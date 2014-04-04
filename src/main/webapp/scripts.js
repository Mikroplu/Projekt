$(document).ready (function() {
	updatelinnad();
	function updatelinnad(){
	$.get('linnad', function(responseJson) {
		var linnad = document.getElementById("linnad");
		//Kui algse comboboxi sisu pole sama, mis tuleb andmebaasist, siis muudab comboboxi sisu andmebaasi j�rgi
		if (linnad != responseJson){
			while (linnad.firstChild) {
				linnad.removeChild(linnad.firstChild);
			}
			$.each(responseJson, function(key, value) {
				$("#linnad").append(
						'<option value='+value.asukoht+'>' + value.asukoht
								+ '</option>');
			});
		}
	});	
	}
	
	//window.setInterval(updatelinnad, 1000); // Calls updatelinnad every 1000ms
	// {"asukoht" : "Tartu"},
	//-----------------------------------------------------------------------------------------
	$("#linna_valik").click (function(event) {
				var pubid = document.getElementById("pubid");
				var linnad = document.getElementById("linnad");
				var valitud_linn = linnad.options[linnad.selectedIndex].text;
				$.get('pubinimed', {"asukoht" : valitud_linn}, function(responseJson) {
					if (pubid != responseJson){
						while (pubid.firstChild){
							pubid.removeChild(pubid.firstChild);
						}
						$.each(responseJson, function(key, value) {
							$("#pubid").append(
									'<option value='+value.nimi+'>' + value.nimi
											+ '</option>');
						});
					}
			});
	});
	
	//------------------------------------------------------------------------------------------
	$("#broneeri").click (function(event) {
		var pubid = document.getElementById("pubid");
		var linnad = document.getElementById("linnad");
		var valitud_pubi = pubid.options[pubid.selectedIndex].text;
		var valitud_linn = linnad.options[linnad.selectedIndex].text;
		$.post('redirect', function(responseJson) {
			
	});
});
	
	$("#pubi_valik").click (function(event) {
		var pubid = document.getElementById("pubid");
		var pubi_nimi = pubid.options[pubid.selectedIndex].text;
		var linnad = document.getElementById("linnad");
		var valitud_linn = linnad.options[linnad.selectedIndex].text;
		$.get('lauad', {"pubi_nimi" : pubi_nimi,"valitud_linn" : valitud_linn}, function(responseJson) {
				$.each(responseJson, function(key, value) {
					alert(value.laudade_arv);
				});
	});
});

	$('#login_button').click(function() {
		$('.contents').hide();
	    $('#content5').show();
	});
	
	$('#register_button').click(function() {
		$('.contents').hide();
	    $('#content4').show();
	});
	$('#addpub_button').click(function() {
		$('.contents').hide();
		$('#content6').show();
	});
	
	$('#logout').click(function() {
		$.post('logout', function(responseJson) {
			
	});
	});
	
	
	// Edasi nupud
	$('#linna_valik').click(function() {
		$('.contents').hide();
		$('#content2').show();
	});
	
	$('#pubi_valik').click(function() {
		$('.contents').hide();
		$('#content3').show();
	});
	
	$('#laua_valik').click(function() {
		$('.contents').hide();
		$('#content7').show();
	});
	$('#laua_valik_loggedout').click(function() {
		
	});
	
	// Tagasi nupud
	$('#tagasi_pubi').click(function() {
		$('.contents').hide();
	    $('#content1').show();
	});
	$('#tagasi_addpub').click(function() {
		$('.contents').hide();
	    $('#content1').show();
	});
	
	$('#tagasi_laud').click(function() {
		$('.contents').hide();
	    $('#content2').show();
	});
	
	$('#tagasi_register').click(function() {
		$('.contents').hide();
	    $('#content1').show();
	});
	$('#tagasi_login').click(function() {
		$('.contents').hide();
	    $('#content1').show();
	});
	$('#tagasi_broneeri').click(function() {
		$('.contents').hide();
	    $('#content1').show();
	});
	
	// Muudab nuppude klassid
    $('button').click(function(){
    	$('.menu_button').removeClass('menu_button_clicked');
        $(this).addClass('menu_button_clicked');
   });
    
    function facebooklogin(){
    	  FB.Connect.ifUserConnected("SomeServletOrStrutsActionOrJsp?back="+window.location,null);
    	}
    
    
  /*  $('#header').click(function(){
    	 var eventSource = new EventSource("datapush");
    	 eventSource.onmessage = function(event) {
    	    	document.getElementById('header').innerHTML = event.data;
    	    	document.getElementById('footer').innerHTML = event.data2;
    	    };
   });*/
   
 
});

