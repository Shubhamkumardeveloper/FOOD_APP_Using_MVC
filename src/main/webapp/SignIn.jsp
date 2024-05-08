<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
</head>

<style>
    /* Center the form and style the background */
    body {
        font-family: Arial, sans-serif;
        background-image: pink;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    /* Style the form container */
    form {
        max-width: 300px;
        margin: 0 auto;
        padding: 20px;
        background-color: rgba(255, 255, 255, 0.9);
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
        text-align: center;
    }

    h1 {
        color: #333;
        font-size: 24px;
    }

    /* Style form elements */
    form input[type="text"],
    form input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: none;
        border-radius: 5px;
        background-color: #f4f4f4;
        font-size: 16px;
    }

    form select {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: none;
        border-radius: 5px;
        background-color: #f4f4f4;
        font-size: 16px;
    }

    form button {
        display: block;
        width: 100%;
        padding: 10px;
        background-color: #4CAF50;
        color: #fff;
        border: none;
        border-radius: 5px;
        font-size: 18px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    form button:hover {
        background-color: #45a049;
    }
</style>


<body>
<h1>Sign In page</h1>

<form:form action="saveUser" modelAttribute="user">
	Name:<form:input path="name"/><br><br>
	Email:<form:input path="email"/><br><br>
	Password:<form:input path="password"/><br><br>
	Role:
	<form:select path="role">
		<form:option value="BranchManager">Branch Manager</form:option>
		<form:option value="Staff">Staff</form:option>
		<form:option value="customer">customer</form:option>
	</form:select> <br><br>
	
	<form:button>Submit</form:button>
</form:form>

</body>
</html>