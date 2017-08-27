<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home Page</title>
<link href="resources/css/style.css" rel="stylesheet">
<script src="resources/js/jquery-2.2.4.min.js"></script> 
<script>
	var addToCart = function(element) {
		$.ajax({
			url: "cart/add/" + element,
			method: "GET"
		}).error(function(data) {
			if(data.status == 404) {
				alert("Product not found");
			}
		});
	}
</script> 
</head>
<body>
	<div class="content">
		<table class = "table_mainPage" align="center">

		<tbody>
			<c:forEach var="product" items="${products}">
				<tr>
					<td><img src="data:image/jpeg;base64,${product.imagePath}" alt="Cinque Terre" class="img-img-rounded" width="150" height="130"> </br> ${product.name} ${product.city} </br> ${product.price}</td>
					<security:authorize access="isAuthenticated()">
					<td><a href="#" class="btn btn-success" onclick="addToCart(${product.productId})">Add to cart</a> <br/></td>
					</security:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>

		<security:authorize access="hasRole('ROLE_ADMIN')">
		<div class="adminNaviPanel">
				<a href="customer={customerId}">Customers</a>
				<a href="allProducts">Products</a>
				<a href="category={categoryId}">Categories</a>
		</div>	
		</security:authorize>
	</div>
 
</body>
</html>