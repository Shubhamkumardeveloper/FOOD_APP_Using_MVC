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

<h1>Edit Staff</h1>

<form:form action="updateStaff" modelAttribute="user">
	id: <form:input path="id" readonly="ture"/>
	Name:<form:input path="name"/><br><br>
	Email:<form:input path="email" readonly="true"/><br><br>
	Password:<form:input path="password"/><br><br>
	Role:
	<form:select path="role">
		<form:option value="Staff">Staff</form:option>
	</form:select> <br><br>
	
	<form:button>Update Staff</form:button>
	
	</form:form>

</body>
</html>