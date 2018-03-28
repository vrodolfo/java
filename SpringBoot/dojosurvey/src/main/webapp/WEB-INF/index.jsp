<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
        <title>Dojo Survey</title>
      
</head>
<body>
		<h1> Welcome to Dojo Survey!!!</h1>
        <form action="/survey/add" method="post">
		<table>
			<tr>
				<td><label>Your Name:</label></td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td><label>Dojo Location:</label></td>
				<td><input type="text" name="dojo" id="dojo"></td>
			</tr>
			<tr>
				<td><label>Favorite Language:</label></td>
				<td><input type="text" name="language" id="language"></td>
			</tr>
			<tr>
				<td><label>Comment:</label></td>
				<td><textarea cols="20" name="comment" id="comment"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</table>
		</form>
        
</body>
</html>
  