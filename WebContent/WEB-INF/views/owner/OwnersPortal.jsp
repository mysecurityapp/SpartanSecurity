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
<h4>Last action status: ${requestScope.status}</h4>
	<h3>Owners portal</h3>
	<table style="background-color: cyan; margin: auto;">
		
	</table>
	<h5>
		<a href="<spring:url value='/owner/vehicle'/>">Add New Vehicle</a>
	</h5>
	
	

</body>
</html>