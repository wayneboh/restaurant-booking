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
<c:if test="${booking.bookingName != null}">
<form action="updateBooking" method="post">
</c:if>
<c:if test="${booking == null}">
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
<label>Restaurant Name (Cannot be changed)</label> <input type="text" readonly value="<c:out
value='${booking.restaurantName}' />" class="form-control" name="restaurantName">
</fieldset>

<fieldset class="form-group">
<label>Booking Number</label> <input type="text" value="<c:out
value='${booking.bookingNumber}' />" class="form-control" name="bookingNumber">
</fieldset>

<fieldset class="form-group">
    <label >Time Slot</label>
    <select name="bookingTime" class="form-control">
    <option value ="1pm"     <c:if test="${booking.bookingTime == '1pm'}">selected</c:if>>1pm</option>
    <option value="2pm" <c:if test="${booking.bookingTime == '2pm'}">selected</c:if>>2pm</option>
    <option value="3pm" <c:if test="${booking.bookingTime == '3pm'}">selected</c:if>>3pm</option>
    <option value="4pm" <c:if test="${booking.bookingTime == '4pm'}">selected</c:if>>4pm</option>
    <option value="5pm" <c:if test="${booking.bookingTime == '5pm'}">selected</c:if>>5pm</option>
    <option value="6pm" <c:if test="${booking.bookingTime == '6pm'}">selected</c:if>>6pm</option>
    <option value="7pm" <c:if test="${booking.bookingTime == '7pm'}">selected</c:if>>7pm</option>
    <option value="8pm" <c:if test="${booking.bookingTime == '8pm'}">selected</c:if>>8pm</option>
    <option value="9pm" <c:if test="${booking.bookingTime == '9pm'}">selected</c:if>>9pm</option>

    </select>
    </fieldset>

<button type="submit" class="btn btn-success">Save</button>
</form>
</div>
</div>
</div>
</body>
</html>