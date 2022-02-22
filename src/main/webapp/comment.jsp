<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CommentServlet" method="post">
	RestaurantName: <input type="text" name="restaurantName">
	UserName: <input type= "text" name="userName">
	Comment: <input type="text" name="comment">
	<input type="submit" value= Call Servlet"/>
</form>
</body>
</html>