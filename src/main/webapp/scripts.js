//Peidab kõik elemendid klassiga "content"

$(document).ready(function() {
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
	
	
	//Edasi nupud
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
	
	// Muudab nuppude klassid
    $('button').click(function(){
    	$('.menu_button').removeClass('menu_button_clicked');
        $(this).addClass('menu_button_clicked');
   });
    
    
    
    
    $('#linnad').change(function() { 
        var value = $(this).attr('value'); 
        var request = $.ajax({
            url: "/getcities/",
            type: "GET",
            data: {country : value},
            dataType: "json",

            success: function(data) {
             //Popluate combo here by unpacking the json
            }
        });


    });
});

