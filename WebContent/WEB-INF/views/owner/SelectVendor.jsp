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
	<sf:form  method="post" modelAttribute="suppliers">
		<table style="background-color: pink; margin: auto;">

			<tr>
				<td>Enter vendor role</td>
				<td><sf:input type="text" path="role" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="search vendor" /></td>
			</tr>

		</table>
	</sf:form>


</body>
</html>