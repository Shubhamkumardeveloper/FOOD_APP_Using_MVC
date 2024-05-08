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
<h1>Food Product</h1>
<table border="1px solid red">
	 	<tr>
	 		<th>Id</th>
	 		<th>status</th>
	 		<th>Total Price:</th>
	 		<th>orderCreated Time:</th>
	 		<th>Order Delivery time:</th>
	 		<th>Customer name:</th>
	 		<th>Contact Number:</th>
	 		<th>Edit</th>
	 		<th>Delete</th>
	 	</tr>
	 	
	 	<c:forEach var="order" items="${listofFoodOrder}">
	 	 <tr>
	 	 	<td>${order.getId() }</td>
	 	 	<td>${order.getStatus() }</td>
	 	 	<td>${order.getTotalPrice() }</td>
	 	 	<td>${order.getOrderCreatedTime() }</td>
	 	 	<td>${order.getOrderDeliveryTime() }</td>
	 	 	<td>${order.getCustomerName() }</td>
	 	 	<td>${order.getContactNumber() }</td>
	 	 	<td><a href="editFoodOrder?id=${order.getId()  }">EDIT</a></td>
	 	 	<td><a href="deleteFoodOrder?id=${order.getId()  }">DELETE</a></td>
	 	 </tr>
	 	</c:forEach>
	  <a href="">Home</a>
	</table>
	


</body>
</html>