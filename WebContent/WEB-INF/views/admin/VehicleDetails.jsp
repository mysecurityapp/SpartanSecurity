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

	<h3>Vehicle List</h3>
	<table style="background-color: cyan; margin: auto;">
		<c:forEach var="v" items="${requestScope.vehicle_list}">

			<tr>
				<td>${v.vehicle_no}</td>
				<td>${v.vehicle_type}</td>  
				<td>${v.malik.owner_id}</td>
				

			</tr>
		</c:forEach>
	</table>
	<h5>
		<a href="<spring:url value='/admin/add'/>">Add New Vendor</a>
	</h5>

</body>
</html>