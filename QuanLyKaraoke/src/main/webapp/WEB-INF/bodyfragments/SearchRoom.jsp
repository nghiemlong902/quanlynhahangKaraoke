<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>SearchRoom</title>
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

	<div class="container">
		<h2>SearchRoom</h2>
		<form class="form-inline" action="show-room" method="post"
			id="form-new">
			<div class="form-group">
				<label for="dateStart" class="mb-2 mr-sm-2">Date Start</label> <input
					type="date" class="form-control" name="dateStart" id="dateStart">
				<span class="form-message" style="color: red"></span>
			</div>
			<div class="form-group">
				<label for="dateEnd" class="mb-2 mr-sm-2">Date End</label> <input
					type="date" class="form-control" name="dateEnd" id="dateEnd">
				<span class="form-message" style="color: red"></span>

			</div>
			<button type="submit" class="btn btn-primary">Search</button>
		</form>
	</div>

	<script src="js/Validator.js">
		
	</script>

	<script type="text/javascript">
		Validator({
			form : '#form-new',
			errorSelector : '.form-message',
			rules : [
					Validator.isRequired('#dateStart'),
					Validator.isRequired('#dateEnd'),
					Validator.isDateEndGreaterThanStart('#dateStart',
							'#dateEnd') ],
		});
	</script>

</body>
</html>

