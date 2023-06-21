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
<%
Customer customer = (Customer) session.getAttribute("loginPerson");
Employee employee = (Employee) session.getAttribute("loginPersonE");
Manager manager = (Manager) session.getAttribute("loginPersonM");
%>
<div style="padding: 5px;">

	<ul>
		<%
		if (customer != null) {
		%>
		<li><a href="${pageContext.request.contextPath}/Home">Home</a></li>
		<li><a href="${pageContext.request.contextPath}/SearchRoom">SearchRoom</a></li>
		<li><a
			href="${pageContext.request.contextPath}/ViewInvoice?userId=<%=customer.getId()%>">View
				Invoice</a></li>
		<%
		} else if (employee != null) {
		%>
		<li><a href="${pageContext.request.contextPath}/Home">Home</a></li>
		<li><a href="${pageContext.request.contextPath}/manager-customer">Manager-Customer</a></li>
		<%
		} else if (manager != null) {
		%>
		<li><a href="${pageContext.request.contextPath}/Home">Home</a></li>
		<li><a href="${pageContext.request.contextPath}/Product">Manager
				Product</a></li>
		<%
		}
		%>
	</ul>

</div>