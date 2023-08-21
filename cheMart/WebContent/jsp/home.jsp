<%
	if(session.getAttribute("name") == null){
		response.sendRedirect("/cheMart/jsp/myAccount/login.jsp");
	}

%>
<!DOCTYPE html>
<html lang="en">
 	<head>
 		<!-- Meta Tags -->
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Title -->
 		<title>cheMart</title>
 		<!-- Style Sheet -->
		<link rel="stylesheet" type="text/css" href="/cheMart/jsp/admin/css/style.css" />
 	</head>
<body>
	<header>
		<div class="container">
			<div class="brand">
				<div class="logo">
					<a onclick="javascript:openTab('index')">
						<img src="/cheMart/jsp/img/icons/online_shopping.png">
						<div class="logo-text">
							<p class="big-logo">cheMart</p>
							<p class="small-logo">online chemical</p>
						</div>
					</a>
				</div> <!-- logo -->
				<div class="shop-icon" style="margin: 24px;">
					<div class="dropdown">
						<img src="/cheMart/jsp/img/icons/account.png">
						<p style="margin-left:-28px;"><%=session.getAttribute("name") %></p>
						<div class="dropdown-menu">
							<ul>
								<li><a onclick="openTab('account')">My Account</a></li>								
								<li><a href="#">Settings</a></li>
								<li><a href="/cheMart/logout">Logout</a></li>
							</ul>
						</div>
					</div>
				</div> <!-- shop icons -->
			</div> <!-- brand -->
		</div> <!-- container -->
	</header> <!-- header -->
	<main>
		<div class="main-content">
			<div class="sidebar">
				<h3>Menu</h3>
				<ul>
					<li><a id="index" class="active" onclick="javascript:openTab('index')">Home</a></li>
					<li><a id="order" onclick="javascript:openTab('order')">Order</a></li>
					<li><a id="product" onclick="javascript:openTab('product')">Product</a></li>
					<li><a id="category" onclick="javascript:openTab('category')">Category</a></li>
					<li><a id="stock" onclick="javascript:openTab('stock')">Stock</a></li>
					<li><a id="users" onclick="javascript:openTab('users')">Users</a></li>
				</ul>				
			</div>
			<div class="content" id="main-content">
				<h3 id="currentTab">home</h3>
				<div class="content-data" id="content-data">
					
				</div>
			</div>
		</div>		

	</main> <!-- Main Area -->

	<footer>
		<div class="container">
			<div class="footer-bar">
				<div class="copyright-text">
					<p>--------------------------------------------------------------------------------------------------</p>
				</div>
			</div> <!-- Footer Bar -->
		</div>
	</footer> <!-- Footer Area -->

</body>
<script src="/cheMart/jsp/js/jquery-3.6.1.min.js"></script>
<script src="/cheMart/jsp/js/home.js"></script>
</html>