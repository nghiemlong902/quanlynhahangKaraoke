<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Supplier</title>
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<style>
.table1 {
	border-collapse: collapse;
	width: 100%;
}

.table1 td {
	padding: 5px;
}

.table1 td:first-child {
	padding-right: 40px;
}

.table1 td:last-child {
	padding-left: 20px;
}
</style>
</head>
<body>

	<div class="container">
		<h2>Thông tin sản phẩm theo nhà cung</h2>

	</div>
	<table class="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Tên</th>
				<th>Giá</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="c">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.price}</td>
					<td><a href="AddProductBySupplier?productId=${c.id}"> Buy
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>

