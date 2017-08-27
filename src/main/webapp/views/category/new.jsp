<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Category</title>
</head>
<body>
	<div class="container">
	<h2>Create Category</h2>
	<form class="form-horizontal" action="newCategory" method="post">
		<div class="form-group">
    		<label for="inputLogin3" class="col-sm-2 control-label">Name</label>
   			<div class="col-sm-10">
   			<input type="text" class="form-control" name="name" placeholder="Name" > <form:errors path="name" />
    		</div>
  		</div>
  		
  		<div class="form-group">
    		<label for="inputName3" class="col-sm-2 control-label">Description</label>
   			<div class="col-sm-10">
     		<input type="text" class="form-control" name="description" placeholder="Description">
   			 </div>
  		</div>
		<div class="register_button">
		<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
	</div>
</body>
</html>