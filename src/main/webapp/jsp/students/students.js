(function(){
	function loadStudents(){
		$.ajax({
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			url: "/eSchool/jsp/students/getStudentsList.jsp",
			type: "GET",
			dataType: "text",
			async: false,
			success: function (response) {
				var tbody = document.getElementById('listOfStudents');
				console.log(tbody);
				let students = JSON.parse(response);
				var row = "";
				students.forEach(function(x){
					row += `<tr><td>${x.id}</td>
					<td>${x.fname}</td>
					<td>${x.lname}</td>
					<td>${x.dob}</td>
					<td>${x.gender}</td>
					<td>${x.mobileno}</td>
					</tr>
					`;
				});
				tbody.innerHTML = row;
			}
		});
	}
	
	loadStudents();

})();