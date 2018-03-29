<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Flash Messages</title>
      
</head>
<body>
		<h1> Flash Messages!!! </h1>
       
        <h2 class="alert"><c:out value="${errors}"/></h2>
        <form action="/check" method="post">
        	<h2>What is the code?</h2>
        	<input type="text" name="code" id="code">
        	<input type="submit" value="Submit">
        </form>
        
</body>
</html>
  