<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p align="center">
<h4>Last action status: ${requestScope.status}</h4>
	<h3>Admin Portal</h3>
	<table style="background-color: cyan; margin: auto;">
		
	</table>
	<h5>
		<a href="<spring:url value='/admins/add'/>">Add New Security</a>
	</h5>
	<h5>
		<a href="<spring:url value='/admins/list'/>"> Security list</a>
	</h5>
	<h5>
		<a href="<spring:url value='/admins/addOwner'/>"> Add owner</a>
	</h5>
	<h5>
		<a href="<spring:url value='/admins/listOwner'/>">  owner list</a>
	</h5>
	<h5>
		<a href="<spring:url value='/admins/listVehicle'/>">  Vehicle list</a>
	</h5>
	<h5>
		<a href="<spring:url value='/owner/vehicle'/>">Add My Vehicle</a>
	</h5>
	<h5>
		<a href="<spring:url value='/owner/OwnersVisitors'/>">Show my visitors</a>
	</h5>
	
	</p>

</body>
</html>