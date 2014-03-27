$(document).ready (function() {
	
	$.get('linnad', function(responseJson) {
		var linnad = document.getElementById("linnad");
		//Kui algse comboboxi sisu pole sama, mis tuleb andmebaasist, siis muudab comboboxi sisu andmebaasi järgi
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
				var linnad = document.getElementById("linnad");
				var valitud_linn = linnad.options[linnad.selectedIndex].text;
				
/*				$("#pubid").append(
						'<option value='+"Lahekõrts"+'>' + "Lahekõrts"
								+ '</option>');*/
				
				$.get('pubinimed', function(responseJson) {
						
						alert("df");
						$.each(responseJson, function(key, value) {
							alert("hakkab appendima");
							$("#pubid").append(
									'<option value='+value.nimi+'>' + value.nimi
											+ '</option>');
					
						});
				
			});
	});



	$('#Showcontent1').click(function() {
		$('.contents').hide();
	    $('#content1').show();
	});
	$('#Showcontent2').click(function() {
		$('.contents').hide();
	    $('#content2').show();
	});
	$('#Showcontent3').click(function() {
		$('.contents').hide();
	    $('#content3').show();
	});
	$('#Showcontent4').click(function() {
		$('.contents').hide();
	    $('#content4').show();
	});
	
	$('#login_button').click(function() {
		$('.contents').hide();
	    $('#content5').show();
	});
	
	$('#register_button').click(function() {
		$('.contents').hide();
	    $('#content4').show();
	});
	
	
	// Edasi nupud
	$('#linna_valik').click(function() {
		//$('.contents').hide();
	    //$('#content2').show();
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

