
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

<div class='container'>
	<div class='header'>
		<h1><b>Restaurant Booking</b></h1>
		<p class='text-muted'>Login or Register to continue</p>
		
	</div>
	
	<div>
	
		<a href='userLogin.jsp' class='btn btn-primary px-5 py-3'><b>Login</b></a>
		<a href='userRegister.jsp' class='btn btn-outline-primary px-5 py-3'><b>Register</b></a>
	</div>
</div>

</body>
</html>