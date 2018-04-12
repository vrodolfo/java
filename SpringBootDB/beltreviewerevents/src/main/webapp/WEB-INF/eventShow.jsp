<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Belt Reviewer - Events Manager</title>
</head>
<body>

	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
	
	<a href="/dashboard">Dashboard</a>

	<h1> <c:out value="${event.name}"/>!</h1>
	<h2>Date:  <c:out value="${event.date}"/></h2>
	<h2>Location: <c:out value="${event.location}"/>, <c:out value="${event.state}"/></h2>
	<h2> People who are attending this event: <c:out value="${event.getUsersAttending().size()}"/></h2>
	 
    
    <h2>People Attending:</h2>
    <table class="table">
			<tr>    
			    <td> Name </td>
			    <td>Location</td>
			   
		    </tr>
		<c:forEach items="${event.getUsersAttending()}" var="user" varStatus="loop">
		    <tr>    
			    
			    <td><c:out value="${user.getFirstName()}"/> <c:out value="${user.getLastName()}"/></td>
			    <td><c:out value="${event.getLocation()}"/> </td>
			    
			    
		    </tr>
		</c:forEach>
	</table>
	
	<h2>Message Wall:</h2>
	<textarea cols="30" rows="20">
		<c:forEach items="${messages}" var="message" varStatus="loop">
		  *- <c:out value="${message.getUser().getFirstName()}"/> Says:
			 <c:out value="${message.content}"/>
			
		</c:forEach>
	
	
	
	</textarea>
     
    <h1> Add Comment </h1>
        <form:form method="POST" action="/events/${event.id}/messages/add" modelAttribute="message">
	    <form:label path="content">Content: 
	    <form:errors path="content"/>
	    <form:input path="content"/></form:label>
	    
	    </br>

	    <input type="submit" value="Create"/>
	</form:form>
    
   
</body>
</html>