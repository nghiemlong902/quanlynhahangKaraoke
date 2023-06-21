<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomerReserveRoom</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-100">
		<div class="row">
			<c:forEach items="${listCustomerReserve}" var="c">
				<div class="card" style="width: 18rem;">
					<img src=${c.image } class="card-img-top">
					<div class="card-body">
						<h5 class="card-title">${c.price }</h5>
						<p class="card-text">${c.description }</p>
						<a href="#" class="btn btn-primary">Reserved</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>