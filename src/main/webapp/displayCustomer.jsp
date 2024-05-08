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

<h1>Customer</h1>
<table border="1px solid red">
	 	<tr>
	 		<th>Id</th>
	 		<th>Name:</th>
	 		<th>email:</th>
	 		<th>role:</th>
	 		<th>Edit</th>
	 		<th>Delete</th>
	 	</tr>
	 	
	 	<c:forEach var="customer" items="${customer}">
	 	 <tr>
	 	 	<td>${customer.getId() }</td>
	 	 	<td>${customer.getName() }</td>
	 	 	<td>${customer.getEmail() }</td>
	 	 	<td>${customer.getRole() }</td>
	 	 	<td><a href="editCustomer?id=${customer.getId() }">EDIT</a></td>
	 	 	<td><a href="deleteCustomer?id=${customer.getId()  }">DELETE</a></td>
	 	 </tr>
	 	</c:forEach>
	</table>
	<a href="staff.jsp">Home</a>

</body>
</html>