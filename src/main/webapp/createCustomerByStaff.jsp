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
<h1>Create Customer</h1>

  <form:form action="savecustomer" modelAttribute="customer">
	Name:<form:input path="name"/><br><br>
	Email:<form:input path="email"/><br><br>
	Password:<form:input path="password"/><br><br>
	Role:
	<form:select path="role">
		<form:option value="Customer">Customer</form:option>
	</form:select> <br><br>
	
	<form:button>Submit</form:button>
	<a href="branchManager.jsp">back</a>
</form:form>
</body>
</html>