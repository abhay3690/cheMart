<%@page import="admin.Product"%><%
	String strJSON = new Product().getProducts();
%><%=strJSON%>