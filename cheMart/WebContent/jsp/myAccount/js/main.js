function login(){
	let username = $("#username");
	let password = $("#password");
	if(username.val() == '' || username.is(':invalid')){
		username.attr("required","required");
		return;
	}
	if(password.val() == '' || password.is(':invalid')){
		password.attr("required","required");
		return;
	}
	let credentials = {
		username:username.val(),
		password:password.val()
	}
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/Login",
		type: "POST",
		data: credentials,
		dataType: "text",
		success: function(response) {
			if(response){
				alert(response);
			}else{
				window.location.href = '/cheMart/jsp/home.jsp';
			}
		}
	})
}

function register(){	
	let fname = $("#fname");
	let lname = $("#lname");
	let email = $("#email");
	let contact = $("#contact");
	let password = $("#password");
	let re_password = $("#re_pass");
	
	if(fname.val() == '' || fname.is(':invalid')){
		fname.attr("required","required");
		return;
	}
	if(lname.val() == '' || lname.is(':invalid')){
		lname.attr("required","required");
		return;
	}
	if(email.val() == '' || email.is(':invalid')){
		email.attr("required","required");
		return;
	}
	if(password.val() == '' || password.is(':invalid')){
		password.attr("required","required");
		return;
	}
	
	if(password.val() !== re_password.val()){
		alert("Password fields does not match!");
		re_password.focus();
		return;
	}
	if(contact.val() == '' || contact.is(':invalid')){
		contact.attr("required","required");
		return;
	}
	/*if(!$("#agree-term").prop("checked")){
		$("#agree-term").attr("required","required");
		return;
	}*/
	
	let credentials = {
		fname:fname.val(),
		lname:lname.val(),
		email:email.val(),
		contact:contact.val(),
		password:password.val()
	}
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/RegistrationServlet",
		type: "POST",
		data: credentials,
		dataType: "text",
		success: function(response) {
			if(response){
				alert(response);
			}else{
				window.location.href = '/cheMart/jsp/myAccount/login.jsp'
			}
		}
	})
}