<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Restaurant Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/RestaurantServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${restaurant != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${restaurant == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${restaurant != null}">
Edit Restaurant
</c:if>
						<c:if test="${restaurant == null}">
Add New Restaurant
</c:if>
					</h2>
				</caption>
				<c:if test="${restaurant != null}">
					<input type="hidden" name="oriName"
						value="<c:out
value='${restaurant.name}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Restaurant Name</label> <input type="text"
						value="<c:out
value='${restaurant.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Cuisine</label> <input type="text"
						value="<c:out
value='${restaurant.cuisine}' />" class="form-control"
						name="cuisine">
				</fieldset>
				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out
value='${restaurant.address}' />" class="form-control"
						name="address">
				</fieldset>
				<fieldset class="form-group">
					<label>Information</label> <input type="text"
						value="<c:out
value='${restaurant.info}' />" class="form-control"
						name="info">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>


</body>
</html>