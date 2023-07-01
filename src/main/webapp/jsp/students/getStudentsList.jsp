<%@page import="Students"%><%
	String strJSON = new Students().getStudents();
%><%=strJSON%>