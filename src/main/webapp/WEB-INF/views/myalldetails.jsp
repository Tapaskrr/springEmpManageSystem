<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="navbar.jsp" %>
    <% String empId=(String)request.getAttribute("empId"); %>
    <% String empName=(String)request.getAttribute("empName"); %>
    <% String empEmail=(String)request.getAttribute("empEmail"); %>
    <% String empPwd=(String)request.getAttribute("empPwd"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
id is :   <%=empId %>
<br> <br>
Name is :   <%=empName %>
<br> <br>
Email is :   <%=empEmail %>
<br> <br>
Password is :   <%=empPwd %>
<br> <br>
</body>
</html>