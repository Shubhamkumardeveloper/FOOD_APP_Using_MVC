<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>

<style>
    /* Center the form and style the background */
    body {
            font-family: Arial, sans-serif;
            background-color: rgba(242, 242, 242, 0.8); /* Transparent background */
            text-align: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* Vertical centering */
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

    form button {
        display: block;
        width: 100%;
        padding: 10px;
        background-color: #2980b9;
        color: #fff;
        border: none;
        border-radius: 5px;
        font-size: 18px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    form button:hover {
        background-color: #3498db;
    }

    /* Style form links */
    a {
        color: #2980b9;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }
</style>


<body>
	<h1>Login form:</h1>
	<form:form action="validate" modelAttribute="user">
		Email:<form:input path="email"/><br><br>
		Password:<form:input path="password"/><br><br>
		<form:button>Login-in</form:button>
	</form:form>
</body>
</html>