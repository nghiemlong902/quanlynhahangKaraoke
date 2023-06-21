<!DOCTYPE html>
<%@page import="com.dmt.model.Manager"%>
<%@page import="com.dmt.model.Employee"%>
<%@page import="com.dmt.model.Customer"%>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<%
	Customer customer = (Customer) session.getAttribute("loginPerson");
	Employee employee = (Employee) session.getAttribute("loginPersonE");
	Manager manager = (Manager) session.getAttribute("loginPersonM");
	%>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="Home">Karaoke App</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">

			<ul class="navbar-nav mr-auto">
				<%
				if (customer == null && employee == null && manager == null) {
				%>
				<li class="nav-item"><a class="nav-link" href="LoginCustomer">Customer</a></li>
				<li class="nav-item"><a class="nav-link" href="LoginEmployee">Employee</a></li>
				<li class="nav-item"><a class="nav-link" href="LoginManager">Manager</a></li>
				<%}%>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%
				if (customer != null) {
				%>
				<li style="margin-right: 20px"><a href="#"><span
						class=""></span> <%=customer.getFullName()%></a></li>
				<li><a href="LogOut"><span
						class=""></span> Log out </a></li>
				<%
				} else if (employee != null) {
				%>
				<li style="margin-right: 20px"><a href="#"><span
						class=""></span> <%=employee.getFullName()%></a></li>
				<li><a href="LogOut"><span
						class=""></span> Log out </a></li>
				<%
				} else if (manager != null) {
				%>
				<li style="margin-right: 20px"><a href="#"><span class=""></span>
						<%=manager.getFullName()%></a></li>
				<li><a href="LogOut"><span class=""></span> Log out </a></li>
				<%
				}
				%>


			</ul>
		</div>
	</nav>

</body>
</html>

