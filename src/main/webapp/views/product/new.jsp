<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product</title>
</head>
<body>

	<div class="container">
		<form class="form-horizontal" action="newProduct" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="inputLogin3" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name"
						placeholder="Name">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Description</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="description"
						placeholder="Description">
				</div>
			</div>
			<div class="form-group">
				<label for="inputName3" class="col-sm-2 control-label">City</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="city"
						placeholder="City">
				</div>
			</div>
			<div class="form-group">
				<label for="inputSecondname3" class="col-sm-2 control-label">Price</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="price"
						placeholder="00.0">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPhone3" class="col-sm-2 control-label">Image</label>
				<div class="col-sm-10">
					<input type="file" class="form-control" name="imagePath"
						placeholder="Image">
				</div>
			</div>
				<c:forEach items="${categories}" var="category">
					<input type="radio" name= "category" value="${category.categoryId}">${category.name}
				</c:forEach>
			<div class="register_button">
				<button type="submit" class="btn btn-primary">Create</button>
			</div>
		</form>
	</div>
</body>
</html>