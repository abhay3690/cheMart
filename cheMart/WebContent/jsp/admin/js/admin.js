function loadProducts() {
	$.ajax({
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		url: "/cheMart/jsp/admin/getProductsList.jsp",
		type: "GET",
		dataType: "text",
		async: false,
		success: function(response) {
			var tbody = document.getElementById('productDetail');
			console.log(tbody);
			let students = JSON.parse(response);
			var row = "";
			students.forEach(function(x) {
				row += `<tr>
					<td>${x.id}</td>
					<td>${x.fname}</td>
					<td>${x.lname}</td>
					<td>${x.dob}</td>
					</tr>
					`;
			});
			tbody.innerHTML = row;
		}
	});
}

loadProducts();