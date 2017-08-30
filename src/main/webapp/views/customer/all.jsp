<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Login</th>
				<th>Email</th>
				<th>Phone</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Date of birth</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach var="customer" items="${customers}">
				<tr>
					<td>${customer.login}</td>
					<td>${customer.email}</td>
					<td>${customer.phone}</td>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.dateOfBirth}</td>
					<td>
						<a href="editCustomer=${customer.customerId}" class="btn btn-success"> <span class="glyphicon glyphicon-pencil"></span></a>
						<a href="deleteCustomer=${customer.customerId}" class="btn btn-danger"> <span class="glyphicon glyphicon-trash"></span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>