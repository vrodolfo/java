<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/RandomWord/RandomB" method="post">
		<h1>You Have Generated a Word <c:out value="${count}"/> times</h1>
		<h2>Last Word: <c:out value="${word}"/></h2>
		<input type="submit" value="Click Me">
		<h2>The last time you generated a Word was <c:out value="${time}"/></h2>
	</form>

</body>
</html>