<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire</title>
</head>
<body>
	<div align="center">
	<form action="<%=request.getContextPath()%>/register" method="POST">
		<table style="width : 80%">
			<tr>
			
				<td>Firstname:</td>
				<td><input type="text" name="firstname" required></td>
		
			</tr>
			<tr>
			
				<td>Lastname:</td>
				<td><input type="text" name="lastname" required></td>
		
			</tr>
			<tr>
			
				<td>Username:</td>
				<td><input type="text" name="username" required></td>
		
			</tr>
			<tr>
			
				<td>Password:</td>
				<td><input type="text" name="password" required></td>
		
			</tr>
			<tr>
			
				<td>Address:</td>
				<td><input type="text" name="address" required></td>
		
			</tr><tr>
			
				<td>Contact:</td>
				<td><input type="text" name="contact" required></td>
		
			</tr>
			
			<tr>
			
				<td colspan="2" style = "color : red;">
				<% if(request.getAttribute("errorMessage") != null){ %>
					<%=request.getAttribute("errorMessage") %>
				<% } %>
				</td>
		
			</tr>
	
		</table>
		<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>