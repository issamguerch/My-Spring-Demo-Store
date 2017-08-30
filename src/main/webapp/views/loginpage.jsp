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
		<form class="form-horizontal" action="loginprocessing" method="post">

			<div class="form-group">
				<label for="InputLogin2">Login</label> <input type="text"
					class="form-control" name="username" placeholder="Login">
			</div>

			<div class="form-group">
				<label for="InputPassword2">Password</label> <input type="password"
					class="form-control" name="password" placeholder="Password">
			</div>

			<button type="submit" class="btn btn-primary">Sign In</button>

		</form>
		</div>
</body>
</html>