<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>
	<h1>Check Console</h1>
	<c:if test="${requestScope.usrList !=null and
 	not empty requestScope.usrList}">
	<table align="center" border="4" cellpadding="3">
	<tr>
		<td>First Name</td>
		<td>Last Name</td>
		<td> </td>
		<td> </td>
	</tr>
	<c:forEach items="${requestScope.usrList}" var="e"> 		
	<tr>
		<td>${e.fname}</td>
		<td>${e.lname}</td>
		<td><a href="editemp/${emp.fname}">Edit</a></td>  
   		<td><a href="deleteemp/${emp.fname}">Delete</a></td>  
	</tr>
	</c:forEach>
	</table>
	</c:if>
</body>
</html>