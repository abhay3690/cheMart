<%
	if(session.getAttribute("name") == null){
		response.sendRedirect("login.jsp");
	}else{
		response.sendRedirect("/cheMart/jsp/home.html");
	}

%>
