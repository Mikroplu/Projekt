$(document).ready (function() {
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
	// {"asukoht" : "Tartu"},
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
	
	$("#pubi_valik").click (function(event) {
		var pubid = document.getElementById("pubid");
		var pubi_nimi = pubid.options[pubid.selectedIndex].text;
		$.get('lauad', {"pubi_nimi" : pubi_nimi}, function(responseJson) {
				$.each(responseJson, function(key, value) {
					var dimensions=value.laudade_arv;
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
	    $('#content3').show();
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
	
	// Muudab nuppude klassid
    $('button').click(function(){
    	$('.menu_button').removeClass('menu_button_clicked');
        $(this).addClass('menu_button_clicked');
   });
 
});

