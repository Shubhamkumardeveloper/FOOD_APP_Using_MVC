<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Create Food Order</h1>

<form:form action="saveFoodOrder" modelAttribute="foodorder">
	
	Status: <form:input path="status"/><br><br>
	totalfoodPrice: <form:input path="totalPrice"/><br><br>
	customerName: <form:input path="customerName"/><br><br>
	ContactNumner: <form:input path="contactNumber"/><br><br>
	
	<form:button>Save Food Order</form:button>


</form:form>

</body>
</html>