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
<h1>Create Food </h1>
<%-- <h1>${menu.getId()}</h1> --%>
<form:form action="saveFoodProduct?id=${menu.getId() }" modelAttribute="foodProduct">
	
	Food name:<form:input path="name"/><br><br>
	Food type:<form:select path="type">
		<form:option value="veg">VEG</form:option>
		<form:option value="non veg">NON VEG</form:option>
	</form:select><br><br>
	about:<form:input path="about"/><br><br>
	availability:<form:select path="availability">
		<form:option value="Yes">Yes</form:option>
		<form:option value="No">No</form:option>
	</form:select><br><br>
	price:<form:input path="price"/><br><br>
	
	<form:button>saveFoodProduct</form:button>
</form:form>
	<a href="branchManager.jsp">back</a>

</body>
</html>