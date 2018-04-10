<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login and Registration</title>
</head>
<body>

	<h1>Login</h1>
    
     First Name:   <c:out value="${currentUser.getFirstName()}"/>
     </br>
     Last Name:   <c:out value="${currentUser.getLastName()}"/>
     </br>
    SignUp Date:   <c:out value="${currentUser.getCreatedAt()}"/>
    </br>
    Last SignIn Date:   <c:out value="${currentUser.getUpdatedAt()}"/>
    </br>
    
    
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>