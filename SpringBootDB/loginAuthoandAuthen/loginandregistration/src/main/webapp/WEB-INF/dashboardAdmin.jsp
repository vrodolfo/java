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

	<h1>Dashboard Admin</h1>
	
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
     Welcome   <c:out value="${currentUser.getFirstName()}"/>!!!
     </br>
     </br>
    
    
    	<table class="table">
			<tr>    
			    <td> Name </td>
			    <td>Email </td>
			    <td>Action </td>
		    </tr>
		<c:forEach items="${users}" var="user" varStatus="loop">
		    <tr>    
			    <td><c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></td>
			    <td><c:out value="${user.email}"/></td>
			    <td>
			    	
			    	
			    	
			    	<c:if test="${ user.getRoles().get(0).getName() == 'ROLE_ADMIN'}">
					 Admin.
					</c:if>	
					
					<c:if test="${ user.getRoles().get(0).getName() == 'ROLE_USER'}">
					<a href="/users/<c:out value="${user.getId()}"/>/delete">Delete</a> |
					 <a href="/users/<c:out value="${user.getId()}"/>/makeadmin">Make Admin</a>
					</c:if>	
			    	
			    	
			    </td>
			    
		    </tr>
		</c:forEach>
		</table>
</body>
</html>