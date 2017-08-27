<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	
		<form class="form-horizontal" action="editCustomer" method="post">
			<div class="form-group">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label"></label>
					<div class="col-sm-10">
						<input type="hidden" class="form-control" placeholder="Id"
							name="customerId" value="${customers.customerId}">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Login</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Login"
							name="login">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" placeholder="Password"
							name="password">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="inputName3" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="firstName"
						placeholder="Name">
				</div>
			</div>
			<div class="form-group">
				<label for="inputSecondname3" class="col-sm-2 control-label">Last
					name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="lastName"
						placeholder="Last name">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPhone3" class="col-sm-2 control-label">Phone</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="phone"
						placeholder="Phone">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" name="email"
						placeholder="Email">
				</div>
			</div>
			<div class="form-group">
				<label for="inputBirthdate3" class="col-sm-2 control-label">Birth
					Date</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="dateOfBirth"
						placeholder="yyyy/mm/dd">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Update
						Customer</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>