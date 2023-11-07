<%@page import="admin.Contact"%><%
	String contact = request.getParameter("contact");
	String returnJson = new Contact().addContact(contact);
%><%=returnJson%>