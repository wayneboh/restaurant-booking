<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a restaurant </title>
</head>
<body>

<h1>Enter the restaurant details below to create a restaurant.</h1>
<form action="RestaurantcreateServlet" method="post">
	Name:<input type="text" name="name">
	Cuisine:<input type="text" name="cuisine">
	Address:<input type="text" name="address">
	Information:<input type="text" name="info">
<input type="submit" value="Call Servlet"/>
</form>
<h2><a href="http://localhost:8090/restaurant-booking/restauranthome.jsp"> Click here to return to landing page </a></h2>


</body>
</html>