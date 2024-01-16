<%@page import="admin.Changepassword"%><%
	String changepassword = request.getParameter("changepassword");
	int uid = Integer.parseInt(session.getAttribute("uid").toString());
	String returnJson = new Changepassword().changePassword(changepassword,uid);
%><%=returnJson%>
