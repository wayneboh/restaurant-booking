<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="RestaurantcreateServlet" method="post">
	Name:<input type="text" name="name">
	Cuisine:<input type="text" name="cuisine">
	Address:<input type="text" name="address">
	Information:<input type="text" name="info">
<input type="submit" value="Call Servlet"/>
</form>


</body>
</html>