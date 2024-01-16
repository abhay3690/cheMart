<%@page import="admin.Product"%><%
	String product = request.getParameter("product");
	String returnJson = new Product().addProduct(product);
%><%=returnJson%>