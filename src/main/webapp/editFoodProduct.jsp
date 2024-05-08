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
<h1>Edit Food Product</h1>
<form:form action="updateUser" modelAttribute="foodProducts">
		Id: <form:input path="foodProductId" readonly="true"/><br><br>
 		Food name:<form:input path="name" readonly="true"/><br><br>
	Food type:<form:select path="type" >
		<form:option value="veg">VEG</form:option>
		<form:option value="non veg">NON VEG</form:option>
	</form:select><br><br>
	about:<form:input path="about"/><br><br>
	availability:<form:select path="availability">
		<form:option value="veg">Yes</form:option>
		<form:option value="non veg">No</form:option>
	</form:select><br><br>
	price:<form:input path="price" readonly="true"/><br><br>
	
	<form:button>saveFoodProduct</form:button>
	<a href="findall">cancel</a>
	
	</form:form>

</body>
</html>