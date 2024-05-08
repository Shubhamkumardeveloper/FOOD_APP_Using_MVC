<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Staff</h1>
<table border="1px solid red">
	 	<tr>
	 		<th>Id</th>
	 		<th>Name:</th>
	 		<th>email:</th>
	 		<th>role:</th>
	 		<th>Edit</th>
	 		<th>Delete</th>
	 	</tr>
	 	
	 	<c:forEach var="staff" items="${staff}">
	 	 <tr>
	 	 	<td>${staff.getId() }</td>
	 	 	<td>${staff.getName() }</td>
	 	 	<td>${staff.getEmail() }</td>
	 	 	<td>${staff.getRole() }</td>
	 	 	<td><a href="editStaff?id=${staff.getId() }">EDIT</a></td>
	 	 	<td><a href="deleteStaff?id=${staff.getId()  }">DELETE</a></td>
	 	 </tr>
	 	</c:forEach>
	</table>
	

</body>
</html>