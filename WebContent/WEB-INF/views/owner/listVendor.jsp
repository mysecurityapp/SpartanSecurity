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
	<h3>vendor List</h3>
	<table style="background-color: cyan; margin: auto;">
		<c:forEach var="v" items="${requestScope.status}">

			<tr>
				<td>${v.vid}</td>
				<td>${v.first_name}</td>
				<td>${v.last_name}</td>  
				<td>${v.role}</td>
				<td>${v.mobile}</td>
				<td>${v.address}</td>
				<td>${v.email}</td>  			
			</tr>
		</c:forEach>
	</table>
	

</body>
</html>