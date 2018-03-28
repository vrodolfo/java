<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
        <title>Hello Human</title>
      
</head>
<body>

        <h1> Hello <c:out value="${firstname}"/> <c:out value="${lastname}"/>!!!</h1>
        <h2> Welcome to Spring Boot!!!</h2>
        
</body>
</html>
  