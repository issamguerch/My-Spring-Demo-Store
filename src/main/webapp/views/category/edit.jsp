<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	
		<form class="form-horizontal" action="editCategory" method="post">
			<div class="form-group">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label"></label>
					<div class="col-sm-10">
						<input type="hidden" class="form-control" placeholder="Id"
							name="categoryId" value="${categories.categoryId}">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Name"
							name="name">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Description</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Description"
							name="description">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Update
						Category</button>
				</div>
			</div>
		</form>
	</div>
	
</body>
</html>