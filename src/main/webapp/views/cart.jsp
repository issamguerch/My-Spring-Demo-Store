<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>
<div class="container">
<h2>Your cart</h2>
<form action='cart/confirmOrder' method="post">
${cartMessage}
<table class="table">
	<tr>
		<th> Product </th>
		<th> Quantity </th>
		<th> Price </th>
	</tr>
	<c:forEach var="product" items="${cart.contents}">
	<tr>
		<td><c:out value="${product.key.name}"/> </td>
		<td><c:out value="${product.value}"/> </td>
		<td>$<c:out value="${product.key.price * product.value}"/> </td>
	</tr>
	</c:forEach>
	
	<tr></tr>
	<tr>
		<td>Total</td>
		<td></td>
		<td>$${cart.totalCost}</td>
	</tr>
</table>
<input type="submit" value="Confirm Order"></input>
</form>

</div>
</body>
</html>