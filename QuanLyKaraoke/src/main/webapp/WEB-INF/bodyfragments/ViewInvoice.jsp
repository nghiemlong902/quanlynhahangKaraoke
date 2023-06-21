<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>View Invoice</h2>
		<p></p>
		<table class="table table-condensed">
			<thead>
				<tr>
					<th>RoomNumber</th>
					<th>RoomType</th>
					<th>Price</th>
					<th>FullName</th>
					<th>DateCreated</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listInvoiceDetail}" var="c">
					<tr>
						<td>${c.roomNumber}</td>
						<td>${c.roomType}</td>
						<td>${c.price}</td>
						<td>${c.fullName}</td>
						<td>${c.startDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>