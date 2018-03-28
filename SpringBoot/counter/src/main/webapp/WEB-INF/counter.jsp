<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
        <title>Counter</title>
      
</head>
<body>
        <h1> You Have visited the app <c:out value="${counter}"/>  times</h1>
        <a href="/">Test another visit?</a>
        
        
 
</body>
</html>
  