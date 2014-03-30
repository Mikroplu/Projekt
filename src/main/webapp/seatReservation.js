$(document).ready (function() {
	var dimensions=0;
	$("#pubi_valik").click (function(event) {
		var pubid = document.getElementById("pubid");
		var pubi_nimi = pubid.options[pubid.selectedIndex].text;
		$.get('lauad', {"pubi_nimi" : pubi_nimi}, function(responseJson) {
				$.each(responseJson, function(key, value) {
					dimensions=parseInt(value.laudade_arv);
					alert(dimensions);
				});
	});
			var settings = {
				rows : Math.sqrt(dimensions),
				cols : Math.sqrt(dimensions),
				rowCssPrefix : 'row-',
				colCssPrefix : 'col-',
				seatWidth : 35,
				seatHeight : 35,
				seatCss : 'seat',
				selectedSeatCss : 'selectedSeat',
				selectingSeatCss : 'selectingSeat'
			};
			var init = function(reservedSeat) {
				var str = [], seatNo, className;
				for (var i = 0; i < settings.rows; i++) {
					for (var j = 0; j < settings.cols; j++) {
						seatNo = (i + j * settings.rows + 1);
						//seat row-0 col-0
						className = settings.seatCss + ' '
								+ settings.rowCssPrefix + i.toString() + ' '
								+ settings.colCssPrefix + j.toString();
						if ($.isArray(reservedSeat)
								&& $.inArray(seatNo, reservedSeat) != -1) {
							className += ' ' + settings.selectedSeatCss;
						}
						str.push('<li class="' + className + '"'
								+ 'style="top:'
								+ (i * settings.seatHeight).toString()
								+ 'px;left:'
								+ (j * settings.seatWidth).toString() + 'px">'
								+ '<a title="' + seatNo + '">' + seatNo
								+ '</a>' + '</li>');
					}
				}
				$('#place').html(str.join(''));
			};
			// case I: Show from starting
			// init();

			// Case II: If already booked
			var bookedSeats = [ ];
			init(bookedSeats);

			$('.' + settings.seatCss).click(function() {
				if ($(this).hasClass(settings.selectedSeatCss)) {
					alert('This seat is already reserved');
				} else {
					$(this).toggleClass(settings.selectingSeatCss);
				}
			});

		});
});