<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
        <title>Dojo Survey - Results</title>
      
</head>
<body>
		<h1> Results </h1>
        <a href="/">Go Back</a>
		<table>
			<tr>
				<td><label>Your Name:</label></td>
				<td><c:out value="${name}"/></td>
			</tr>
			<tr>
				<td><label>Dojo Location:</label></td>
				<td><c:out value="${dojo}"/></td>
			</tr>
			<tr>
				<td><label>Favorite Language:</label></td>
				<td><c:out value="${language}"/></td>
			</tr>
			<tr>
				<td><label>Comment:</label></td>
				<td><c:out value="${comment}"/></td>
			</tr>
			
		</table>
        
</body>
</html>
  