<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Customer</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>


	<c:if test="${not empty LoginFail }">
		<script type="text/javascript">
			alert("Incorrect username or Password");
		</script>
	</c:if>
	<div class="container">
		<h2>Login customer</h2>
		<form action="LoginCustomer" method="post">
			<div class="form-group">
				<label for="userName">userName:</label> <input type="text"
					class="form-control" id="userName" placeholder="Enter userName"
					name="userName">
			</div>
			<div class="form-group">
				<label for="pwd">password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter password"
					name="pswd">
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
		<a href="RegisterCustomer">Register if you don't account</a>
	</div>
</body>
</html>

