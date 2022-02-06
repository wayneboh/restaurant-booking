<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comments</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Restaurant comment</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/comment.jsp"
					class="btn btnsuccess">Add New comment</a>
					<a href='http://localhost:8090/restaurantBooking/RestaurantServlet/dashboard'
					class='btn btn-primary px-5 py-3'><b>View Restaurants</b></a>
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>RestaurantName</th>
						<th>Username</th>
						<th>Comment</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet’s response to a loop
-->
				<tbody>
					<c:forEach var="user" items="${listUsers}">
						<!-- For each user in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${user.restaurantname}" /></td>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.comment}" /></td>

							<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a
								href="edit?restaurantname=<c:out value='${user.restaurantname}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?restaurantname=<c:out
value='${user.restaurantname}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>