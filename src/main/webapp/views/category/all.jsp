<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category all</title>
</head>
<body>
<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach var="category" items="${categories}">
				<tr>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td>
						<a href="editCategory=${category.categoryId}" class="btn btn-success"> <span class="glyphicon glyphicon-pencil"></span></a>
						<a href="deleteCategory=${category.categoryId}" class="btn btn-danger"> <span class="glyphicon glyphicon-trash"></span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<a href="createNewCategory">Create Category </a>
</body>
</html>