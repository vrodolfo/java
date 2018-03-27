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
<title>Insert title here</title>
</head>
<body>
<h1>Prototype Roster</h1>
	<%=  request.getAttribute("name") %>
	<a href="/TeamRoster/PlayersAdd?name=<%=  request.getAttribute("name") %>"> New Player</a>
	
	<table>
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Age</td>
			<td>Actions</td>
		</tr>
		
		<% 
		     Team team = (Team) request.getAttribute("team");
			 ArrayList<Player> players = new ArrayList<>();
			 if(team.getPlayers() != null){
				 players = team.getPlayers();
			 }
			 
			
		%>

		<% for (int i=0; i < players.size() ; i++){ %>
		<tr>
			<td><%= players.get(i).getFirstName() %></td>
			<td><%= players.get(i).getLastName() %></td>
			<td><%= players.get(i).getAge() %></td>
			
			<td>
				<a href="/TeamRoster/PlayersDelete?team=<%=  request.getAttribute("name") %>&name=<%= players.get(i).getFirstName() %>">Delete</a>
			</td>
		</tr>
		<% } %>
		
		
	</table>

</body>
</html>