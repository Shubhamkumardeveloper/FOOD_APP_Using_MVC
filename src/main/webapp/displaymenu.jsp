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
<h1>Menu</h1>

<table border="1px solid red">
	 	<tr>
	 		<th>Id</th>
	 		<th>Name:</th>
	 		<th>Type:</th>
	 		<th>about:</th>
	 		<th>availability:</th>
	 		<th>price:</th>
	 		<th>Edit</th>
	 		<th>Delete</th>
	 	</tr>
	 	
	 	<c:forEach var="product" items="${listofproduct}">
	 	 <tr>
	 	 	<td>${product.getFoodProductId() }</td>
	 	 	<td>${product.getName() }</td>
	 	 	<td>${product.getType() }</td>
	 	 	<td>${product.getAbout() }</td>
	 	 	<td>${product.getAvailability() }</td>
	 	 	<td>${product.getPrice() }</td>
	 	 	<td><a href="edit?id=${product.getFoodProductId() }">EDIT</a></td>
	 	 	<td><a href="delete?id=${product.getFoodProductId() }">DELETE</a></td>
	 	 </tr>
	 	</c:forEach>
	</table>
	
</body>
</html>