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
	<sf:form  method="post" modelAttribute="security">
		<table style="background-color: pink; margin: auto;">

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
				<td>Enter User Mobile No</td>
				<td><sf:input type="text" path="mobile_numb" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><sf:password path="password" /></td>
			</tr>
			<tr>
				<td>Enter User Email</td>
				
				<td><sf:input type="text" path="email" /></td>
				
			</tr>
		
			<tr>
				<td><input type="submit" value="Register security" /></td>
			</tr>

		</table>
	</sf:form>


</body>
</html>