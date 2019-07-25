<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align ="center">Guest Registration Form</h1>
	<sf:form  method="post" modelAttribute="guestEntry">
		<table style="background-color: pink; margin: auto;">

			<tr>
				<td>Enter Flat no</td>
				<td><sf:input type="text" path="flat_no" /></td>
			</tr>
			<tr>
				<td>Enter Vehicle No</td>
				<td><sf:input type="text" path="Vehicle_no" /></td>
			</tr>
			
			
			<tr>
				<td><input type="submit" value="Register guest" /></td>
			</tr>

		</table>
	</sf:form>


</body>
</html>