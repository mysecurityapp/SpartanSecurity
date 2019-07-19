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
	<h3>Secuirty List</h3>
	<table style="background-color: cyan; margin: auto;">
		<c:forEach var="v" items="${requestScope.vendor_list}">

			<tr>
				<td>${v.id}</td>
				<td>${v.first_name}</td>
				<td>${v.last_name}</td>  
				<td>${v.address}</td>
				<td>${v.mobile_numb}</td>
				<td>${v.password}</td>
				<td>${v.email}</td>  
				<td>${v.saheb.owner_id}</td>
				<td>${v.mobile_numb}</td>
				<td><a href="<spring:url value='/admins/updateSec?vid=${v.id}'/>">Update</a></td>
				<td><a href="<spring:url value='/admin/delete?vid=${v.id}'/>">Delete</a></td>

			</tr>
		</c:forEach>
	</table>
	<h5>
		<a href="<spring:url value='/admins/add'/>">Add New Security</a>
	</h5>

</body>
</html>