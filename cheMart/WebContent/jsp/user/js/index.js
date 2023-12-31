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

function sendMessage(){
	let contact = {
		fname:document.getElementById("fname").value,
		lname:document.getElementById("lname").value,
		email:document.getElementById("email").value,
		message:document.getElementById("message").value,
		
	};
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/jsp/admin/addcontact.jsp",
		type: "POST",
		data: {"contact":JSON.stringify(contact)},
		dataType: "text",
		success: function(response) {
			response = JSON.parse(response);
			if(response.status === "failed"){
				alert("Something went wrong, Please contact administrator!")
			}
		}
	})
}


function changePassword(){
	let newpassword = document.getElementById("new_password").value;
	let confirmpassword = document.getElementById("confirm_password").value;
	
	if(newpassword !== confirmpassword){
		alert("New password doesn't match!");
		return;
	}
	
	let changepassword = {
		password:document.getElementById("old_password").value
	};
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/jsp/admin/changepassword.jsp",
		type: "POST",
		data: {"changepassword":JSON.stringify(changepassword)},
		dataType: "text",
		success: function(response) {
			response = JSON.parse(response);
			if(response.status === "failed"){
				alert("Something went wrong, Please contact administrator!")
			}else if(response.status === "success"){
				alert("password changed successfully!")
			}else{
				alert(response.status);
			}
		}
	})
}


function checkout(){
	let checkout = {
		firstname:document.getElementById("firstname").value,
		lastname:document.getElementById("lastname").value,
		companyname:document.getElementById("companyname").value,
		country:document.getElementById("country").value,
		city:document.getElementById("city").value,
		address:document.getElementById("address").value,
		oredernote:document.getElementById("ordernote").value
	
		
	};
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/jsp/admin/checkout.jsp",
		type: "POST",
		data: {"checkout":JSON.stringify(checkout)},
		dataType: "text",
		success: function(response) {
			response = JSON.parse(response);
			if(response.status === "failed"){
				alert("Something went wrong, Please contact administrator!")
			}
		}
	})
}

navLink("dashboard");