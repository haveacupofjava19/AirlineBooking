<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
<h2>Reservation Details</h2>
Airlines: ${flight.operatingAirlines} <br />
Departure City: ${flight.departureCity} <br />
Arrival City: ${flight.arrivalCity} <br />

<form action="completeReservation" method="post">
<pre>
<h2>Traveller Details:</h2>
First Name:<input type="text" name="travellerFirstName"/>
Last Name:<input type="text" name="travellerLastName"/>
Email:<input type="text" name="travellerEmail"/>
Phone:<input type="text" name="travellerPhone"/>

<h2>Card Details:</h2>
Name on the Card:<input type="text" name="nameOnTheCard"/>
Card No:<input type="text" name="cardNumber"/>
Expiry Date:<input type="text" name="expirationDate"/>
CVV Code:<input type="text" name="sercutiyCode"/>

<input type="hidden" name="flightId" value="${flight.id}"/>

<input type="submit" value="Confirm Booking"/>
</pre>
</form>
</body>
</html>