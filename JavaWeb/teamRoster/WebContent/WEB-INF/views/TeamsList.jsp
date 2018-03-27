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
<title>Team Roster</title>
</head>
<body>
	<h1>Prototype Roster</h1>
	<a href="/TeamRoster/TeamsAdd">New Team</a>
	
	<table>
		<tr>
			<td>Team</td>
			<td>Players</td>
			<td>Actions</td>
		</tr>
		
		<% 
		     ArrayList<Team> teams = (ArrayList<Team>) request.getAttribute("teams");
			
		%>
		SIze: <%= teams.size() %>
		<% for (int i=0; i < teams.size() ; i++){ %>
		<tr>
			<td><%= teams.get(i).getName() %></td>
			<td><%= teams.get(i).getPlayersCount() %></td>
			
			<td>
				<a href="/TeamRoster/PlayersList?name=<%= teams.get(i).getName() %>">Details</a> |
				<a href="/TeamRoster/TeamsDelete?name=<%= teams.get(i).getName() %>">Delete</a>
			</td>
		</tr>
		<% } %>
		
		
	</table>

</body>
</html>