<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action ="UserRegisterServlet" method="post">
	Name: <input type="text" name="name">
	Email: <input type="text" name="email">
	Password: <input type="password" name="password">
	Gender: <select name="gender">
		<option>Male</option>
		<option>Female</option>
		<option>Prefer Not To Say</option></select>
	Register As: <select name="role">
		<option>user</option></select>
	<input type="submit" value="Call Servlet" />
</form>
<a href='http://localhost:8090/restaurantBooking/index.jsp' class='btn btn-primary px-5 py-3'><b>Home Page</b></a>
</body>
</html>