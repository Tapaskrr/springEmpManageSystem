<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String msg=(String)request.getAttribute("msg"); %>
    <% String errmsg=(String)request.getAttribute("errmsg"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(msg!=null){out.print(msg);} %>
<% if(errmsg!=null){out.print(errmsg);} %>

<form action="./register" method="post">
empId:<input type="text" name="empId">
empName:<input type="text" name="empName">
empMail:<input type="text" name="empMail">
empPwd:<input type="text" name="empPwd">

<input type="submit" value="submit">

</form>


</body>
</html>