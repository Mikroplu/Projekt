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
	
	// Muudab nuppude klassid
    $('button').click(function(){
    	$('.menu_button').removeClass('menu_button_clicked');
        $(this).addClass('menu_button_clicked');
   });
});

