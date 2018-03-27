<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="java.util.*" %>
<%@ page import="com.teamroster.models.Team" %>
<%@ page import="com.teamroster.models.Player" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Players</title>
</head>
<body>
	<form action="/TeamRoster/PlayersAdd" method="post">
		<h1>Add a Player to Team <%= request.getAttribute("name") %></h1>
		<input type="hidden" name="name" id="name" value="<%= request.getAttribute("name") %>">
		First Name: <input type="text" name="firstName" id="firstName">
		Last Name: <input type="text" name="lastName" id="lastName">
		Age: <input type="number" name="age" id="age">
		<input type="submit" value="Add">
	</form>

</body>
</html>