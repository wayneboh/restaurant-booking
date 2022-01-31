<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Booking Management</title>
 <link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light">
<div>
<a class="navbar-brand"> Booking Management </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/ManageBookingServlet"
class="nav-link">Back to Dashboard</a></li>
</ul>
</nav>
<div class="container col-md-6">
<div class="card">
<div class="card-body">
<c:if test="${listBooking.bookingName != null}">
<form action="update" method="post">
</c:if>
<c:if test="${booking == null}">
<form action="insert" method="post">
</c:if>
<caption>
<h2>
<c:if test="${booking != null}">
Edit Booking
</c:if>
<c:if test="${booking == null}">
Add New Booking
</c:if>
</h2>
</caption>

<fieldset class="form-group">
<label>Booking Name</label> <input type="text" value="<c:out
value='${booking.bookingName}' />" class="form-control" name="bookingName" required="required">
</fieldset>
<fieldset class="form-group">
<label>Restaurant Name</label> <input type="text" value="<c:out
value='${booking.restaurantName}' />" class="form-control" name="restaurantName">
</fieldset>
<fieldset class="form-group">
<label>Booking Number</label> <input type="text" value="<c:out
value='${booking.bookingNumber}' />" class="form-control" name="bookingNumber">
</fieldset>
<fieldset class="form-group">
<label> Time Slot</label> <input type="text" value="<c:out
value='${booking.bookingTime}' />" class="form-control" name="bookingTime">
</fieldset>
<button type="submit" class="btn btn-success">Save</button>
</form>
</div>
</div>
</div>
</body>
</html>