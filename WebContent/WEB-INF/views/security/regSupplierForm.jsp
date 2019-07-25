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
<h1 align ="center">Security Registration Form</h1>
	<sf:form  method="post" modelAttribute="suppliers">
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
				<td><sf:input type="text" path="mobile" /></td>
			</tr>
			
				<td>Enter User Email</td>
				
				<td><sf:input type="text" path="email" /></td>
				
			</tr>
			<tr>
				<td>Enter Role</td>
				<td><sf:input type="text" path="role" /></td>
			</tr>
		
			<tr>
				<td><input type="submit" value="Register supplier" /></td>
			</tr>

		</table>
	</sf:form>


</body>
</html>