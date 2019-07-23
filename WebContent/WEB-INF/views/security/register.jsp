<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- 	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="register">
		<table style="background-color: pink; margin: auto;">

			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="fname" /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="lname" /></td>
			</tr>
			<tr>
				<td>Enter User Email</td>
				
				<td><input type="text" name="email" /></td>
				
			</tr>
			<tr>
				<td>Enter Mobile no</td>
				<td><input type="text" name="mobile" /></td>
			</tr>
			
			<tr>
				<td>Enter Guest Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>Choose In Time</td> -->
<!-- 				<td><input type="date" name="inTime" /></td> -->
<!-- 			</tr> -->
<!-- 				<tr> -->
<!-- 				<td>Choose Out Time</td> -->
<!-- 				<td><input type="date" name="outTime" /></td> -->
<!-- 			</tr> -->
			<tr>
				<td>Enter Vehicle No</td>
				<td><input type="text" name="vehicleNo" /></td>
			</tr>
			<tr>
				<td>Enter Flat No</td>
				<td><input type="text" name="flatNo" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register Guest" /></td>
			</tr>

		</table>
	</form>


</body>
</html>