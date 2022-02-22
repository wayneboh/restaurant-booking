<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">
</head>
<body>

<div class="row">
<div class="container">
<h3 class="text-center">List of Bookings aaaaaa</h3>
<hr>
<div class="container text-left">
<!-- Add new user button redirects to the register.jsp page -->
<a href="<%=request.getContextPath()%>/newBooking.jsp" class="btn btnsuccess">Book another slot</a>
<a href='http://localhost:8090/restaurantBooking/RestaurantServlet/dashboard'
					class='btn btn-primary px-5 py-3'><b>View Restaurants</b></a>
</div>
<br>
<!-- Create a table to list out all current users information -->
<table class="table">
<thead>
<tr>
<th>Restaurant Name</th>
<th>Booking Name</th>
<th>Booking Phone No.</th>
<th>Time Slot</th>
<th>Actions</th>
</tr>
</thead>

<tbody>
<c:forEach var="booking" items="${listBookings}">

<tr>
<td>
<c:out value="${booking.restaurantName}" />
</td>
<td>
<c:out value="${booking.bookingName}" />
</td>
<td>
<c:out value="${booking.bookingNumber}" />
</td>
<td>
<c:out value="${booking.bookingTime}" />
</td>

<td>
<a href="ManageBookingServlet/edit?bookingName=<c:out value='${booking.bookingName}'
/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="ManageBookingServlet/delete?bookingName=<c:out
value='${booking.bookingName}' />">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>

</body>
</html>