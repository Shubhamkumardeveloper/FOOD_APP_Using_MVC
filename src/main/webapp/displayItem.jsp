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
<h1>Item:</h1>
<table border="1px solid red">
	 	<tr>
	 		<th>Id</th>
	 		<th>Product id:</th>
	 		<th>name:</th>
	 		<th>type:</th>
	 		<th>quantity:</th>
	 		<th>price:</th>
	 		<th>Edit</th>
	 		<th>Delete</th>
	 	</tr>
	 	
	 	<c:forEach var="item" items="${listOfItem}">
	 	 <tr>
	 	 	<td>${item.getId() }</td>
	 	 	<td>${item.getProductId() }</td>
	 	 	<td>${item.getName() }</td>
	 	 	<td>${item.getType() }</td>
	 	 	<td>${item.getQuantity() }</td>
	 	 	<td>${item.getPrice() }</td>
	 	 	<td><a href="editItem?id=${item.getId() }">EDIT</a></td>
	 	 	<td><a href="deleteItem?id=${item.getId() }">DELETE</a></td>
	 	 </tr>
	 	</c:forEach>
	</table>
<a href="branchManager.jsp">Home</a>
</body>
</html>