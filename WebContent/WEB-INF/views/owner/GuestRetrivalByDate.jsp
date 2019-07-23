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

<h1 align ="center">Search by date</h1>
	<sf:form  method="post" modelAttribute="guestEntry">
		<table style="background-color: pink; margin: auto;">

			
			
			<tr>
				<td>Choose Date</td>
				<td><sf:input type="date" path="in_Time" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Search visitor" /></td>
			</tr>

		</table>
	</sf:form>


</body>
</html>