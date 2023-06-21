<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Add new Product</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Add New Product</h2>
		<form action="AddProductBySupplier" method="post" id="form-new">
			<div class="form-group">
				<label for="quantity">Quantity:</label> <input type="text"
					class="form-control" id="quantity" name="quantity"> <span
					class="form-message" style="color: red"></span>
			</div>

			<div class="form-group">
				<input type="hidden" class="form-control" name="productId"
					value=${productId }>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

		<script src="js/Validator.js">
			
		</script>

		<script type="text/javascript">
			Validator({
				form : '#form-new',
				errorSelector : '.form-message',
				rules : [ Validator.isRequired('#quantity'), ],
			});
		</script>

	</div>

</body>
</html>

