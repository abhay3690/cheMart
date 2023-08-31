function navLink(tab) {
	if(tab === ''){
		return;
	}
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
	if(tab === 'account'){
		$("#mobileNo").mask("999-999-9999");
		loadAccountDetails()
	}
	if(tab === 'change-password' || tab === 'orders'){
		loadAccountDetails();
	}
}

function loadAccountDetails(){
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/getUserDetail",
		type: "GET",
		dataType: "text",
		async: false,
		success: function(response) {
			let jsonObj = JSON.parse(response);
			$("#fullName").text(jsonObj.fname + " "+jsonObj.lname);
			$("#fname").val(jsonObj.fname);
			$("#lname").val(jsonObj.lname);
			$("#uEmail").text(jsonObj.email);
			$("#mobileNo").val(jsonObj.mobileNo);
		}
	});
}

navLink("dashboard");