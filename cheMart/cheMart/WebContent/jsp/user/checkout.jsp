<%@page import="admin.Checkout"%><%
	String checkout = request.getParameter("checkout");
	String returnJson = new Checkout().checkout(checkout);
%><%=returnJson%>