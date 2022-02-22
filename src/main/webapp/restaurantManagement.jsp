<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Restaurants</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new restaurant button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/restaurantcreate.jsp"
					class="btn btnsuccess">Add New Restaurant</a> 
				<a href='http://localhost:8090/restaurantBooking/UserServlet/dashboard'
					class='btn btn-primary px-5 py-3'><b>View Users</b></a>
				<a href='http://localhost:8090/restaurantBooking/RestaurantnameServlet/dashboard'
					class='btn btn-primary px-5 py-3'><b>View Comments</b></a>
				<a href='http://localhost:8090/restaurantBooking/ManageBookingServlet'
					class='btn btn-primary px-5 py-3'><b>View Bookings</b></a>
					
			</div>
			<br>
			<!-- Create a table to list out all current restaurants information -->
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Cuisine</th>
						<th>Address</th>
						<th>Information</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- Pass in the list of restaurants receive via the Servlet’s response to a loop-->
				<tbody>
					<c:forEach var="restaurant" items="${listRestaurants}">
						<!-- For each restaurant in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${restaurant.name}" /></td>
							<td><c:out value="${restaurant.cuisine}" /></td>
							<td><c:out value="${restaurant.address}" /></td>
							<td><c:out value="${restaurant.info}" /></td>
							<!-- For each restaurant in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a href="edit?name=<c:out value='${restaurant.name}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?name=<c:out
value='${restaurant.name}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>