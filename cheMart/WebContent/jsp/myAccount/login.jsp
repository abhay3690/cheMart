<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Login</title>

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<input type="hidden" id="status"
		value="<%= request.getAttribute("status") %>">
	<div class="main">
		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<div class="logo">
							<a onclick="openTab('index')"> <img
								src="/cheMart/jsp/img/icons/online_shopping.png">
							</a>
							<div class="logo-text">
								<p class="big-logo">cheMart</p>
								<p class="small-logo">online chemical</p>
							</div>
						</div>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Sign in</h2>
						<form class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="email" name="username" id="username"
									placeholder="Username" required/>
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password"
									placeholder="Password" required/>
							</div>
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me"
									class="agree-term" /> <label for="remember-me"
									class="label-agree-term"><span><span></span></span>Remember
									me</label>
							</div>
							<div class="form-group form-button">
								<input type="button" name="signin" id="signin"
									class="form-submit" value="Log in" onclick="login()" /> <a
									href="registration.jsp" class="signup-image-link">Create an
									account</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>

	<!-- JS -->
	<script src="/cheMart/jsp/js/jquery-3.6.1.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>