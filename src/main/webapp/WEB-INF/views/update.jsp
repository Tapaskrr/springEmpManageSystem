<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="navbar.jsp"%>
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


<form action="./updatedata" method="post">
empId:<input type="text" value=<%=empId %> disabled="disabled" name="empId">
empName:<input type="text" value="empName" name="empName">
empMail:<input type="text" value="empEmail" name="empMail">
empPwd:<input type="text" value="empPwd" name="empPwd">

<input type="submit" value="submit">

</form>

</body>
</html>