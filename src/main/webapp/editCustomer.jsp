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

<h1>Edit Customer</h1>

<form:form action="updateCustomer" modelAttribute="customer">
	id: <form:input path="id" readonly="ture"/>
	Name:<form:input path="name"/><br><br>
	Email:<form:input path="email" readonly="true"/><br><br>
	Password:<form:input path="password"/><br><br>
	Role:
	<form:select path="role">
		<form:option value="Customer">customer</form:option>
	</form:select> <br><br>
	
	<form:button>Update Customer</form:button>
	
	</form:form>

</body>
</html>