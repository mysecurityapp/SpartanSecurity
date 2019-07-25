<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>SECURITY DASHBOARD</h1><br><br>
<a href="register">Register Guest</a><br><br><br>
<a href="checkout">Checkout Guest</a><br><br><br>

<h5>
		<a href="<spring:url value='/security/regGuest'/>">register guest</a>
	</h5>
	<h5>
		<a href="<spring:url value='/admins/listVehicle'/>">  Vehicle list</a>
	</h5>
	<h5>
		<a href="<spring:url value='/admins/listOwner'/>">  owner list</a>
	</h5>
	<h5>
		<a href="<spring:url value='/admins/ReportBetweenDate'/>">Show visitors between date</a>
	</h5>
	<h5>
		<a href="<spring:url value='/owner/suppliers'/>">find vendor</a>
	</h5>
	<h5>
		<a href="<spring:url value='/security/addSupplier'/>">Add vendor</a>
	</h5>
	
</body>
</html>