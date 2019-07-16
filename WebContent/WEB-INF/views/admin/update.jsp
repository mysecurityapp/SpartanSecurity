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
	<sf:form method="post" modelAttribute="vendor">
		<table style="background-color: pink; margin: auto;">
			<tr>
				<td>Your assigned ref id (R)</td>
				<td><sf:input readonly="true" path="id"/></td>
			</tr>
			<tr>
				<td>Enter User Name</td>
				<td><sf:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td>Your Email</td>

				<td><sf:input type="text" path="email" readonly="true" /></td>

			</tr>
			<tr>
				<td>Choose Role</td>
				 <td><sf:radiobutton value="admin" path="role"/>Admin<td/>
				<td><sf:radiobutton value="vendor" path="role"/>Vendor<td/> 
				<!-- <td><sf:input type="text" path="role" /></td> -->
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><sf:password path="password" showPassword="true"/></td>
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
				<td><input type="submit" value="Update Details" /></td>
			</tr>

		</table>
	</sf:form>


</body>
</html>