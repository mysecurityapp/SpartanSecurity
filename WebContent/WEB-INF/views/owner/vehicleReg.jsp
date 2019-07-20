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
	<sf:form  method="post" modelAttribute="vehicle">
		<table style="background-color: pink; margin: auto;">

			
			<tr>
				<td>Enter type of Vehicle</td>
				<td><sf:radiobutton value="Two wheeler" path="Vehicle_type"/>Two wheeler<td/>
				<td><sf:radiobutton value="Three wheeler" path="Vehicle_type"/>Three wheeler<td/> 
				
			</tr>
			
			<tr>
				<td>Enter Vehicle No</td>
				<td><sf:input type="text" path="Vehicle_no" /></td>
			</tr>
		
			<tr>
				<td><input type="submit" value="Register vehicle" /></td>
			</tr>

		</table>
	</sf:form>


</body>
</html>