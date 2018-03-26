<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Great Number Game</title>

<style type="text/css">
.div{
	width: 150px;
	height: 150px;
}

.won{
	background-color: green;
}

.tooLow{
	background-color: red;
}

.tooHigh{
	background-color: red;
}

</style>

</head>
<body>
		
		
		<h1>Welcome To Great Number Game!!!</h1>
		<h2>I'm Thinking of a Game Between 1 and 100!!!</h2>
		<h3>Take a Guess!!!</h3>
	<% 
		boolean newGame = (boolean)request.getAttribute("newGame");
		boolean won = (boolean)request.getAttribute("won");
		boolean tooLow = (boolean)request.getAttribute("tooLow");
		boolean tooHigh = (boolean)request.getAttribute("tooHigh");
		int numberPlayed = (int)request.getAttribute("numberPlayed");
		int numberWinning = (int)request.getAttribute("numberWinning");
		
	%>
	
	<%= numberWinning %>>

	<% if(won){ %>
		<div class="div won">
			Well Done!!!, the number was <%= numberWinning %>
		</div>
	
		<form action="/GreatNumberGame/PlayGame" method="post">
			<input type="hidden" name="playAgain" id="playAgain" value="true">
			<input type="hidden" name="number" id="number" value="0">
			<input type="submit" value="Play Again">
		
		</form>
		
	<% } else { %>
	
	
		<% if (newGame) { %>
			
		
		<% } %>
	
		<% if (tooLow) { %>
			<div class="div tooLow">
				Too Low
			</div>
		
		<% } %>
		
		<% if (tooHigh) { %>
			<div class="div tooHigh">
				Too High
			</div>
		<% } %>
		
		<form action="/GreatNumberGame/PlayGame" method="post">
			<input type="hidden" name="playAgain" id="playAgain" value="false">
			<input type="text" name="number" id="number">
			<input type="submit" value="Guess!!!">
		
		</form>
		
	
	<% } %>
	
	
	
	

</body>
</html>