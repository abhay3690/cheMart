<%@page import="admin.Product"%><%
	String product = request.getParameter("product");
	boolean bFlag = new Product().addProduct(product);
%><%=bFlag%>