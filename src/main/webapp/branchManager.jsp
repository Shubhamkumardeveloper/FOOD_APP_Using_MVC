<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<style>
  /* Style the links */
  a {
    text-decoration: none; /* Remove underlines from links */
    color: #336699; /* Set the link color */
    padding: 5px 10px; /* Add some padding to the links */
    border: 1px solid #336699; /* Add a border to the links */
    border-radius: 5px; /* Round the corners of the links */
    margin: 5px; /* Add margin around the links */
  }

  /* Change the link color on hover */
  a:hover {
    color: #ff6600; /* Set a different color on hover */
    background-color: #336699; /* Change the background color on hover */
    transition: color 0.3s, background-color 0.3s; /* Add a smooth transition effect */
  }

  /* Style the heading */
  h1 {
    color: #333; /* Set the heading color */
  }
</style>

<body>
	<h1>Welcome the branch</h1>

	<a href="createsaff">create Staff</a><br><br>
	<a href="displayAllSatff">display All Staff</a><br><br>
	<a href="createmenu?id=${branchManager.getMenu().getId()}">Create Menu</a><br><br>
	<a href="addItem">add item</a><br><br>
	<a href="findAllItem">find all Item</a>
</body>
</html>