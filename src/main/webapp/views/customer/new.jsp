<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Register</title>
</head>
<body>	
	<div class="container">
	<form class="form-horizontal" action="newCustomer" method="post">
		<div class="form-group ">
    		<label for="inputLogin3" class="col-sm-2 control-label">Login</label>
   			<div class="col-sm-10">
   			<input type="text" class="form-control" name="login" placeholder="Login"> <form:errors path="login" />
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
   			<div class="col-sm-10">
     		<input type="password" class="form-control" name="password" placeholder="Password"> <form:errors path="password" />
   			 </div>
  		</div>
  		<div class="form-group">
    		<label for="inputName3" class="col-sm-2 control-label">Name</label>
   			<div class="col-sm-10">
     		<input type="text" class="form-control" name="firstName" placeholder="Name">
   			 </div>
  		</div>
  		<div class="form-group">
    		<label for="inputSecondname3" class="col-sm-2 control-label">Last name</label>
   			<div class="col-sm-10">
     		<input type="text" class="form-control" name="lastName" placeholder="Last name">
   			 </div>
  		</div>
  		<div class="form-group">
    		<label for="inputPhone3" class="col-sm-2 control-label">Phone</label>
   			<div class="col-sm-10">
     		<input type="text" class="form-control" name="phone" placeholder="Phone"> <form:errors path="phone" />
   			 </div>
  		</div>
  		<div class="form-group">
   			 <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
    		 <div class="col-sm-10">
     		 <input type="email" class="form-control" name="email"  placeholder="Email"> <form:errors path="email" />
    		</div>
 		 </div>
 		 <div class="form-group">
   			 <label for="inputBirthdate3" class="col-sm-2 control-label">Birth Date</label>
    		 <div class="col-sm-10">
     		 <input  type="date" class="form-control" name="dateOfBirth" placeholder="yyyy/mm/dd"> <form:errors path="dateOfBirth" />
    		</div>
 		 </div>

		<div class="register_button">
		<button type="submit" class="btn btn-primary">Register</button>
		</div>
	</form>
	</div>
	
</body>
</html>