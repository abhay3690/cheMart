<%@page import="utils.Students"%><%
	String strJSON = new Students().getStudents();
%><%=strJSON%>