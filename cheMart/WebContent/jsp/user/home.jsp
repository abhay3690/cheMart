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
		<meta name="author" content="Abhay Suthar">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Title -->
 		<title>Chemart Chemical trading</title>
 		<!-- Style Sheet -->
		<link rel="stylesheet" type="text/css" href="css/style.css" />
 	</head>
<body>

	<header>
		<div class="container">
			<div class="brand">
				<div class="logo">
					<a onclick="navLink('dashboard')">
						<img src="img/icons/online_shopping.png">
						<div class="logo-text">
							<p class="big-logo">Chemart</p>
							<p class="small-logo">Chemical trading</p>
						</div>
					</a>
				</div> <!-- logo -->
				<div class="shop-icon">
					<div class="dropdown">
						<img src="img/icons/account.png">
						<p style="margin-left:-28px;"><%=session.getAttribute("name") %></p>
						<div class="dropdown-menu">
							<ul>
								<li><a onclick="navLink('account')">My Account</a></li>
								<li><a onclick="navLink('orders')">My Orders</a></li>
								<li><a href="/cheMart/logout">Logout</a></li>
							</ul>
						</div>
					</div>
					<div class="dropdown">
						<img src="img/icons/heart.png">
						<div class="dropdown-menu wishlist-item">
							<table border="1">
								<thead>
									<tr>
										<th>Image</th>
										<th>Chemical Name</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><img src="img/product/img1.jpg"></td>
										<td>Chemical name</td>
									</tr>
									<tr>
										<td><img src="img/product/img2.jpg"></td>
										<td>Chemical name</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="dropdown">
						cart 							
						<div class="dropdown-menu cart-item">
							<table border="1">
								<thead>
									<tr>
										<th>Image</th>
										<th>Chemical Name</th>
										<th class="center">Price</th>
										<th class="center">Qty.</th>
										<th class="center">Amount</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><img src="img/product/img1.jpg"></td>
										<td>Chemical name</td>
										<td class="center">1200</td>
										<td class="center">2</td>
										<td class="center">2400</td>
									</tr>
									<tr>
										<td><img src="img/product/img2.jpg"></td>
										<td>Chemical name</td>
										<td class="center">1500</td>
										<td class="center">2</td>
										<td class="center">3000</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div> <!-- shop icons -->
			</div> <!-- brand -->

			<div class="menu-bar">
				<div class="menu">
					<ul>
						<li><a onclick="navLink('dashboard')" >Home</a></li>
						<li><a onclick="navLink('shop')">Shop</a></li>
						<li><a onclick="navLink('about')">About</a></li>
						<li><a onclick="navLink('contact')">Contact</a></li>
					</ul>
				</div>
				<div class="search-bar">
					<form>
						<div class="form-group">
							<input type="text" class="form-control" name="search" placeholder="Search">
							<img src="img/icons/search.png">
						</div>
					</form>
				</div>
			</div> <!-- menu -->
		</div> <!-- container -->
	</header> <!-- header -->

	<div class="container">
		<main id="main-container">
			
		</main> <!-- Main Area -->
	</div>

	<footer>
		<div class="container">
			<div class="footer-widget">
				<div class="widget">
					<div class="widget-heading">
						<h3>Important Link</h3>
					</div>
					<div class="widget-content">
						<ul>
							<li><a onclick="navLink('about')">About</a></li>
							<li><a onclick="navLink('contact')">Contact</a></li>
							<li><a onclick="navLink('refund')">Refund Policy</a></li>
							<li><a onclick="navLink('terms')">Terms & Conditions</a></li>
						</ul>
					</div>
				</div>
				<div class="widget">
					<div class="widget-heading">
						<h3>Information</h3>
					</div>
					<div class="widget-content">
						<ul>
							<li><a onclick="navLink('account')">My Account</a></li>
							<li><a onclick="navLink('orders')">My Orders</a></li>
							<li><a onclick="navLink('cart')">Cart</a></li>
							<li><a onclick="navLink('checkout')">Checkout</a></li>
						</ul>
					</div>
				</div>
				<div class="widget">
					<div class="widget-heading">
						<h3>Follow us</h3>
					</div>
					<div class="widget-content">
						<div class="follow">
							<ul>
								<li><a href="#"><img src="img/icons/facebook.png"></a></li>
								<li><a href="#"><img src="img/icons/twitter.png"></a></li>
								<li><a href="#"><img src="img/icons/instagram.png"></a></li>
							</ul>
						</div>						
					</div>
					<div class="widget-heading">
						<h3>Subscribe for Newsletter</h3>
					</div>
					<div class="widget-content">
						<div class="subscribe">
							<form>
								<div class="form-group">
									<input type="text" class="form-control" name="subscribe" placeholder="Email">
									<img src="img/icons/paper_plane.png">
								</div>
							</form>
						</div>						
					</div>
				</div>
			</div> <!-- Footer Widget -->
			<div class="footer-bar">
				<div class="copyright-text">
					<p>Copyright 2023 - All Rights Reserved</p>
				</div>
				<div class="payment-mode">
					<img src="img/icons/paper_money.png">
					<img src="img/icons/visa.png">
					<img src="img/icons/mastercard.png">
				</div>
			</div> <!-- Footer Bar -->
		</div>
	</footer> <!-- Footer Area -->

</body>
<!-- Javascript -->	
<script src="/cheMart/jsp/js/jquery-3.6.1.min.js"></script>
<script src="/cheMart/jsp/js/jquery.maskedinput.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script src="/cheMart/jsp/user/js/index.js"></script>
<script>
    $(document).ready(function(){
      $('.slider').bxSlider({
		  auto: true,
		  autoControls: true,
		  stopAutoOnClick: true,
		  pager: true
		});
    });
 </script>
</html>