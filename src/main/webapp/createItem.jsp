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
<h1>Create Item</h1>
<form:form action="saveItem" modelAttribute="item">
	productId:<form:input path="productId"/><br><br>
	Item name:<form:input path="name"/><br><br>
	type:<form:input path="type"/><br><br>
	quantity:<form:input path="quantity"/><br><br>
	price:<form:input path="price"/><br><br>
	
	<form:button>Add item</form:button>
</form:form>
<a href="branchManager.jsp">Home</a>
</body>
</html>