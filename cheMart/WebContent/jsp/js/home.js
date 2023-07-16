function openTab(tab){
	$(".sidebar > ul > li > a:not("+tab+")").removeClass("active");
	$("#"+tab).addClass('active');
	$("#currentTab").text(tab);
	
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/jsp/admin/"+tab+".html",
		type: "GET",
		dataType: "text",
		async: false,
		success: function(response) {
			let content = document.getElementById('content-data');
			content.innerHTML = response;
		},
		error: function(){
			alert("An error occurred while loading data!");
		}
	});
	if(tab === 'index'){
		$("#main-content").addClass("dashboard");
		loadProducts();
	}else
		$("#main-content").removeClass("dashboard");
		
	if(tab == 'product')
		loadProducts();

}

function loadProducts() {
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/jsp/admin/getProductsList.jsp",
		type: "GET",
		dataType: "text",
		async: false,
		success: function(response) {
			var tbody = document.getElementById('productDetail');
			let products = JSON.parse(response);
			var row = "";
			products.forEach(function(x) {
				row += `<tr>
					<td>${x.name}</td>
					<td>${x.price}</td>
					<td>${x.companyName}</td>
					<td>${x.quantity}</td>
					</tr>
					`;
			});
			tbody.innerHTML = row;
		}
	});
}

openTab("index");