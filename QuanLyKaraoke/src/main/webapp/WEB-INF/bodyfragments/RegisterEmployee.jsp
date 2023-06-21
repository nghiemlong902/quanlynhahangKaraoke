<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Register</title>
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
		<h2>Register Employee</h2>
		<form action="register-employee" method="post" id="form-new">
			<div class="form-group">
				<label for="userName">UserName:</label> <input type="text"
					class="form-control" id="userName" name="userName"> <span
					class="form-message" style="color: red"></span>
			</div>

			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" name="password"> <span
					class="form-message" style="color: red"></span>
			</div>

			<div class="form-group">
				<label for="fullName">Full name:</label> <input type="text"
					class="form-control" id="fullName" name="fullName"> <span
					class="form-message" style="color: red"></span>
			</div>

			<div class="form-group">
				<label for="email">Email:</label> <input type="text"
					class="form-control" id="email" name="email"> <span
					class="form-message" style="color: red"></span>
			</div>

			<div class="form-group">
				<label for="phoneNumber">Phone number:</label> <input type="text"
					class="form-control" id="phoneNumber" name="phoneNumber"> <span
					class="form-message" style="color: red"></span>
			</div>

			<div class="form-group">
				<label for="address">Address:</label> <input type="text"
					class="form-control" id="address" name="address"> <span
					class="form-message" style="color: red"></span>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>

		</form>
		<script src="js/Validator.js">
			
		</script>

		<script type="text/javascript">
			Validator({
				form : '#form-new',
				errorSelector : '.form-message',
				rules : [ Validator.isRequired('#userName'),
						Validator.isRequired('#password'),
						Validator.isRequired('#fullName'),
						Validator.isRequired('#email'),
						Validator.isRequired('#phoneNumber'),
						Validator.isRequired('#address'),
						Validator.isEmail('#email'),
						Validator.isSoDienThoaiTuan('#phoneNumber'), ],
			});
		</script>

	</div>

</body>
</html>
