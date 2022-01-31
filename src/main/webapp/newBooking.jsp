<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BookingServlet" method="post">
Restaurant: <input type="text" name="restaurantName"> <br>
Name: <input type="text" name="bookingName"> <br>
Number: <input type="text" name="bookingNumber"> <br>
Time:<select name="bookingTime">
<option>1pm</option>
<option>2pm</option>
<option>3pm</option>
<option>4pm</option>
<option>5pm</option>
<option>6pm</option>
<option>7pm</option>
<option>8pm</option>
<option>9pm</option>
</select>

<input type="submit" value="Create booking">

</form>
</body>
</html>