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
<h1>create staff</h1>

<form:form action="saveUser" modelAttribute="user">
	Name:<form:input path="name"/><br><br>
	Email:<form:input path="email"/><br><br>
	Password:<form:input path="password"/><br><br>
	Role:
	<form:select path="role">
		<form:option value="Staff">Staff</form:option>
	</form:select> <br><br>
	
	<form:button>Submit</form:button>
	<a href="branchManager.jsp">back</a>
</form:form>
<a href="branchManager.jsp">Home</a>
</body>
</html>