<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Header</title>
</head>
<body>
	<div class="header>">
		<p class="MyWebStore"><a href="./"><img id="logo" alt="MyWebStore" src="resources/images/shopping.png"><b>MyWebStore</b></a>
		
			<security:authorize access="isAnonymous()">
				<a id="header_buttons" class="btn btn-primary btn-sm" href="createNewCustomer">Sign Up</a>
				<a id="header_buttons" class="btn btn-primary btn-sm" href="loginpage">Login</a>
			</security:authorize>
		
		<security:authorize access="isAuthenticated()">
			<a id="header_buttons" class="btn btn-primary btn-sm " href="cart">View Cart</a>
			<a id="header_buttons" class="btn btn-primary btn-sm " href="logout">Logout</a>
		</security:authorize>
		</p>
		
	</div>
</body>
</html>