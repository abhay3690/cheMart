<%@page import="cheMart.Students"%><%
	String strJSON = new Students().getStudents();
%><%=strJSON%>