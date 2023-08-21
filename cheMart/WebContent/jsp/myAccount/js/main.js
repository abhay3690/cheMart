function login(){
	let credentials = {
		username:document.getElementById("username").value,
		password:document.getElementById("password").value
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
	let password = document.getElementById("password").value;
	let re_password = document.getElementById("re_pass").value;
	
	if(password !== re_password){
		alert("Password fields does not match!");
		$("#re_pass").focus();
		return;
	}
	
	let credentials = {
		fname:document.getElementById("fname").value,
		lname:document.getElementById("lname").value,
		email:document.getElementById("email").value,
		contact:document.getElementById("contact").value,
		password:password
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