<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Items</title>
</head>
<body>
    <form:form action="adddItemByCustomer" modelAttribute="item">
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Product id:</th>
                <th>Name:</th>
                <th>Type:</th>
                <th>Quantity:</th>
                <th>Price:</th>
                <th>Select</th>
            </tr>
            
            <c:forEach var="item" items="${item}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.productId}</td>
                    <td>${item.name}</td>
                    <td>${item.type}</td>
                    <td><input type="number" name="quantity" value="1"></td>
                    <td>${item.price}</td>
                    <td><input type="checkbox" name="selectedItems" value="${item.id}"></td>
                </tr>
            </c:forEach>
        </table>
        
        <input type="submit" value="Add item">
    </form:form>
    <a href="customer.jsp">Home</a>
</body>
</html>
