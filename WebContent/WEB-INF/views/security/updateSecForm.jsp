<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sf:form method="post" modelAttribute="security">
		<table style="background-color: pink; margin: auto;">
			<tr>
				<td>Your assigned ref id (R)</td>
				<td><sf:input readonly="true" path="id"/></td>
			</tr>
			<tr>
				<td>Enter First Name</td>
				<td><sf:input type="text" path="first_name" /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><sf:input type="text" path="last_name" /></td>
			</tr>
			<tr>
				<td>Enter Address</td>
				<td><sf:input type="text" path="address" /></td>
			</tr>
			<tr>
				<td>Your Email</td>

				<td><sf:input type="text" path="email"  /></td>

			</tr>
			
			<tr>
				<td>Enter Password</td>
				<td><sf:password path="password" showPassword="true"/></td>
			</tr>
			<tr>
				<td>Enter mobile no</td>
				<td><sf:input type="text" path="mobile_numb" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Update Details" /></td>
			</tr>

		</table>
	</sf:form>


</body>
</html>