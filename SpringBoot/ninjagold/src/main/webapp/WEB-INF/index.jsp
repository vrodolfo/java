<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Ninja Gold</title>
      
</head>
<body>
		<h1> Welcome to Ninja Gold!!! </h1>
        <label>Your Gold: <c:out value="${gold}"/></label>
        
        <div class="box">
        	<h2>Farm</h2>
        	<h3>(Earns 10-20 Gold)</h3>
        	<form action="/gold" method="post">
        		<input type="hidden" name="building" id="building" value="farm">
        		<input type="submit" value="Find Gold!">
        	</form>
        </div>
        
        <div class="box">
        	<h2>Cave</h2>
        	<h3>(Earns 5-10 Gold)</h3>
        	<form action="/gold" method="post">
        		<input type="hidden" name="building" id="building" value="cave">
        		<input type="submit" value="Find Gold!">
        	</form>
        </div>
        
        <div class="box">
        	<h2>House</h2>
        	<h3>(Earns 2-5 Gold)</h3>
        	<form action="/gold" method="post">
        		<input type="hidden" name="building" id="building" value="house">
        		<input type="submit" value="Find Gold!">
        	</form>
        </div>
        
        <div class="box">
        	<h2>Casino</h2>
        	<h3>(Earns/Takes 0-50 Gold)</h3>
        	<form action="/gold" method="post">
        		<input type="hidden" name="building" id="building" value="casino">
        		<input type="submit" value="Find Gold!">
        	</form>
        </div>
        
        <h3>Activities</h3>
		<table>
			<c:forEach items="${activities}" var="value">
			<tr>
				<td><c:out value="${value}"/></td>
			</tr>
			</c:forEach>
		</table>
        
</body>
</html>
  