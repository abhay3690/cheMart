<%@page import="admin.Category"%><%
	String strJSON = new Category().getCompanyCategoryList();
%><%=strJSON%>