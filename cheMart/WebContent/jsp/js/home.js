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
		$("#currentTab").text("home");
		$("#main-content").addClass("dashboard");
		loadProducts();
	}else
		$("#main-content").removeClass("dashboard");
		
	if(tab == 'product'){
		loadProducts();
		getCompanyDetail();
	}
	if(tab == 'category')
		loadCategory();
	if(tab === 'account'){
		$("#mobileNo").mask("999-999-9999");
		loadAccountDetails()
	}
	if(tab === 'change-password'){
		loadAccountDetails();
	}
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
					</tr>
					`;
			});
			tbody.innerHTML = row;
		}
	});
}

function addChemProduct(){
	let product = {
		name:document.getElementById("pname").value,
		companyId:document.getElementById("chemCategory").value,
		price:document.getElementById("price").value,
		shortDesc:document.getElementById("sdesc").value,
		longDesc:document.getElementById("ldesc").value,
	};
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/jsp/admin/addProduct.jsp",
		type: "POST",
		data: {"product":JSON.stringify(product)},
		dataType: "text",
		success: function(response) {
			response = JSON.parse(response);
			if(response.status === "exists"){
				alert("This product already exists!")
			}else if(response.status === "success"){
				openTab("product");
			}else if(response.status === "failed"){
				alert("Something went wrong, Please contact administrator!")
			}
		}
	})
}

function loadCategory() {
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/jsp/admin/getCategoryList.jsp",
		type: "GET",
		dataType: "text",
		async: false,
		success: function(response) {
			var tbody = document.getElementById('categoryDetail');
			let products = JSON.parse(response);
			var row = "";
			products.forEach(function(x) {
				row += `<tr>
					<td>${x.companyName}</td>
					<td>${x.tradeType}</td>
					<td></td>
					<td></td>
					</tr>
					`;
			});
			tbody.innerHTML = row;
		}
	});
}

function getCompanyDetail(){
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/jsp/admin/getCategoryList.jsp",
		type: "GET",
		dataType: "text",
		async: false,
		success: function(response) {
			var select = document.getElementById('chemCategory');
			let company = JSON.parse(response);
			let options = "<option>---Select a Company---</option>";
			company.forEach(function(x) {
				if(x.tradeType == 'sale'){
					options += `
						<option value='${x.id}'>${x.companyName}</option>
						`;
				}
			});
			select.innerHTML = options;
		}
	});
}

function addChemCategory(){
	let category = {
		companyName:document.getElementById("companyName").value,
		tradeType:document.getElementById("tradeType").value
	};
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/jsp/admin/addCategory.jsp",
		type: "POST",
		data: {"category":JSON.stringify(category)},
		dataType: "text",
		success: function(response) {
			if(response === "true"){
				openTab("category");
			}else{
				alert("This category already exists!")
			}
		}
	})
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

openTab("index");