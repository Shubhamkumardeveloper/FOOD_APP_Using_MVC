<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Staff</h1>
<form:form action="updateFoodOrder" modelAttribute="foodOrder">
	id: <form:input path="id" readonly="true"/><br><br>
	Status: <form:input path="status"/><br><br>
	totalfoodPrice: <form:input path="totalPrice" readonly="true"/><br><br>
	<%-- orderCreatedTime: <form:input path="orderCreatedTime" readonly="true"/><br><br>
	orderDeliveryTime: <form:input path="orderDeliveryTime" readonly="true"/><br><br> --%>
	customerName: <form:input path="customerName"/><br><br>
	ContactNumner: <form:input path="contactNumber"/><br><br>
	
	<form:button>UpdateFoodOrder</form:button>
	<a href="findallFoodOrder">cancel</a>
	
	</form:form>

</body>
</html>