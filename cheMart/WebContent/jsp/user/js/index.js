function navLink(tab) {
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/jsp/user/" + tab + ".html",
		type: "GET",
		dataType: "text",
		async: false,
		success: function(response) {
			let content = document.getElementById('main-container');
			content.innerHTML = response;
			if (tab === 'dashboard') {
				$('.slider').bxSlider({
					auto: true,
					autoControls: true,
					stopAutoOnClick: true,
					pager: true
				});
			}
			if (tab === 'checkout') {
				$('input[type="radio"]').change(function() {
					if (this.value == 'easypaisa') {
						$('#easypaisaText').css('display', 'block');
					} else {
						$('#easypaisaText').css('display', 'none');
					}
				});
			}
		},
		error: function() {
			alert("An error occurred while loading data!");
		}
	});
}

navLink("dashboard");