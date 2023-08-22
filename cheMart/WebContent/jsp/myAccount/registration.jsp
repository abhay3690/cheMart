<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up</title>

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<input type="hidden" id="status"
		value='<%=request.getAttribute("status")%>'>

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>

						<form class="register-form" id="register-form">
							<div class="form-group">
								<label for="fname"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="fname" id="fname" placeholder="First Name"/>
							</div>
							<div class="form-group">
								<label for="lname"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="fname" id="lname" placeholder="Last Name"/>
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email"/>
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password"
									placeholder="Password"/>
							</div>
							<div class="form-group">
								<label for="re_pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_pass" id="re_pass"
									placeholder="Repeat your password"/>
							</div>
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="tel" name="contact" id="contact"
									placeholder="Contact Number" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="button" class="form-submit" value="Register" onclick="register()"/>
							</div>
						</form>
					</div>
					<div class="signup-image">
						<div class="logo">
							<a onclick="openTab('index')"> <img
								src="/cheMart/jsp/img/icons/online_shopping.png" alt="">
							</a>
							<div class="logo-text">
								<p class="big-logo">cheMart</p>
								<p class="small-logo">online chemical</p>
							</div>
						</div>
						<a href="login.jsp" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>
	</div>
	<!-- JS -->
	<script src="/cheMart/jsp/js/jquery-3.6.1.min.js"></script>
	<script src="js/main.js" type="text/javascript"></script>
	<script src="/cheMart/jsp/js/jquery.maskedinput.js"></script>
	<script type="text/javascript">
		$("#contact").mask("999-999-9999");
	</script>
</body>
</html>