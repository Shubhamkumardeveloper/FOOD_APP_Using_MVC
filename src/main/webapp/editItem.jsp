<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Edit Item</h1>
<form:form action="updateItem" modelAttribute="item">
	id: <form:input path="id" readonly=""/>
	productId:<form:input path="productId" readonly="true"/><br><br>
	Item name:<form:input path="name" readonly="true"/><br><br>
	type:<form:input path="type" readonly="true"/><br><br>
	quantity:<form:input path="quantity"/><br><br>
	price:<form:input path="price" readonly="true"/><br><br>
	
	
	<form:button>saveFoodProduct</form:button>
	
	</form:form>


</body>
</html>