<%@page import="admin.Category"%><%
	String category = request.getParameter("category");
	boolean bFlag = new Category().addCompanyCategory(category);
%><%=bFlag%>