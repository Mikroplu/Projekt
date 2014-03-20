//Peidab kõik elemendid klassiga "content"

$(document).ready(function() {
	$("#linnad").click(function(event) {
		$.get('linnad', function(responseJson) {
			alert("1");
			if (responseJson != null) {
				alert("2");
				var combobox = $("#linnad");
				$.each(responseJson, function(key, value) {
					var rowNew = $("<option></option>");
					alert(value['nimi']);
					rowNew.children().eq(0).text(value['nimi']);
					rowNew.appendTo(combobox);
				});
			}
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

	// Muudab nuppude klassid
	$('button').click(function() {
		$('.menu_button').removeClass('menu_button_clicked');
		$(this).addClass('menu_button_clicked');
	});

});
