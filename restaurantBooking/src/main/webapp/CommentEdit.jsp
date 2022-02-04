<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Comment Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Comment Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/RestaurantnameServlet/dashboard"
				class="nav-link">Back to Comment Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${user != null}">
Edit comment
</c:if>
						<c:if test="${user == null}">
Add New comment
</c:if>
					</h2>
				</caption>
				<c:if test="${user != null}">
					<input type="hidden" name="oriName"
						value="<c:out
value='${user.restaurantname}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>RestaurantName</label> <input type="text"
						value="<c:out
value='${user.restaurantname}' />"
						class="form-control" name="restaurantname" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>userName</label> <input type="text"
						value="<c:out
value='${user.username}' />" class="form-control"
						name="username">
				</fieldset>
				<fieldset class="form-group">
					<label>Comment</label> <input type="text"
						value="<c:out
value='${user.comment}' />" class="form-control"
						name="comment">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>



</body>
</html>