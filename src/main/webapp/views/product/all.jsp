<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Products</title>
</head>
<body>
<div align="center"><a class="btn btn-primary btn-lg" href="createNewProduct">Create Product</a></div>
	
	<div class="container">
	<table class="table table-hover">
		<thead class="thead-inverse">
			<tr>
				<th>Image</th>
				<th>Name</th>
				<th>Description</th>
				<th>City</th>
				<th>Price</th>
				<th>Category</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${products}">
				<tr>
					<td><img src="data:image/jpeg;base64,${product.imagePath}" alt="Cinque Terre" class="img-img-rounded" width="100" height="100"></td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.city}</td>
					<td>${product.price}</td>
					<td>${product.categoryName}</td>
					<td>
						<a href="editProduct=${product.productId}" class="btn btn-success"> <span class="fa fa-pencil"></span></a>
						<a href="deleteProduct=${product.productId}" class="btn btn-danger"> <span class="fa fa-trash-o"></span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
</body>
</html>