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

<h1 align ="center">Owner Registration Form</h1>
	<sf:form  method="post" modelAttribute="vendor">
		<table style="background-color: pink; margin: auto;">

			<tr>
				<td>Enter User Name</td>
				<td><sf:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td>Enter User Email</td>
				
				<td><sf:input type="text" path="email" /></td>
				
			</tr>
			<tr>
				<td>Enter User Role</td>
				<!-- <td><sf:radiobutton value="admin" path="role"/><td/>
				<td><sf:radiobutton value="vendor" path="role"/><td/> -->
				<td><sf:input type="text" path="role" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><sf:password path="password" /></td>
			</tr>
			<tr>
				<td>Enter Reg Amount</td>
				<td><sf:input type="number" path="regAmount" /></td>
			</tr>
			<tr>
				<td>Choose Reg Date</td>
				<td><sf:input type="date" path="regDate" /></td>
			</tr>
			<tr>
				<td>Enter User Phone No</td>
				<td><sf:input type="text" path="phoneNo" /></td>
			</tr>
			<tr>
				<td>Enter User City</td>
				<td><sf:input type="text" path="city" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register Vendor" /></td>
			</tr>

		</table>
	</sf:form>


</body>
</html>