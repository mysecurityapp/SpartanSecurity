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
	<h3>visitor List</h3>
	<table style="background-color: cyan; margin: auto;">
		<c:forEach var="v" items="${requestScope.visitor_details_Bydate}">

			<tr>
				<td>${v.athithi.first_name}</td>
				<td>${v.athithi.last_name}</td>
				<td>${v.athithi.email}</td>
				<td>${v.athithi.address}</td>
				<td>${v.in_Time}</td>
				<td>${v.out_Time}</td>
				<td>${v.vehicle_no}</td>
				

			</tr>
		</c:forEach>
	</table>
	

</body>
</html>