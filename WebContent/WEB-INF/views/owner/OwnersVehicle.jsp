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
<h4>Last action status: ${requestScope.status}</h4>
	<h3>VEhicle List</h3>
	<table style="background-color: cyan; margin: auto;">
		<c:forEach var="v" items="${requestScope.vehicle_owner}">

			<tr>
				<td>${v.vehicle_no}</td>
				<td>${v.vehicle_type}</td>  
				

			</tr>
		</c:forEach>
	</table>
	

</body>

</body>
</html>