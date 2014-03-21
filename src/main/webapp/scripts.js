//Peidab kõik elemendid klassiga "content"

$(document).ready(
		function() {
			$("#linnad").click(
					function(event) {
						
						$.get('pubid', function(responseJson) {
							var linnad = document.getElementById("linnad");
							while (linnad.firstChild) {
								linnad.removeChild(linnad.firstChild);
							}
							if (responseJson != null) {
								var $combobox = $("#linnad");
								$.each(responseJson, function(key, value) {
									$("#linnad").append(
											'<option value='+value.asukoht+'>' + value.asukoht
													+ '</option>');

								});
							}
						});
					});
			
			
			$("#linnad").click(
					function(event) {
						var linnad = document.getElementById("linnad");
						var valitud_linn = e.options[e.selectedIndex].text;
						$.get('pubinimed',valitud_linn, function(responseJson) {
							if (responseJson != null) {
								
								$.each(responseJson, function(key, value) {
									$("#linnad").append(
											'<option value='+value.asukoht+'>' + value.asukoht
													+ '</option>');

								});
							}
						});
					});

			
			
			
			
			var linnad = document.getElementById("linnad");
			var valitud_linn = e.options[e.selectedIndex].text;
			
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
