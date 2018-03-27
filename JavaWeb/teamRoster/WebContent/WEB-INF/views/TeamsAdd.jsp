<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Team</title>
</head>
<body>
	<form action="/TeamRoster/TeamsAdd" method="post">
		<h1>Create a New Team</h1>
		<input type="text" name="name" id="name">
		<input type="submit" value="Add">
	</form>
	
</body>
</html>