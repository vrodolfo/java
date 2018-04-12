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

	<h1>Welcome <c:out value="${currentUser.getFirstName()}"/>!</h1>
	 <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
    <h2>Here are some of the events in your state:</h2>
    <table class="table">
			<tr>    
			    <td> Name </td>
			    <td>Date</td>
			    <td>Location </td>
			    <td>Host </td>
			    <td>Action/Status </td>
			    
		    </tr>
		<c:forEach items="${eventsInState}" var="event" varStatus="loop">
		    <tr>    
			    <td><a href="/events/<c:out value="${event.id}"/>"><c:out value="${event.name}"/></a></td>
			    <td><c:out value="${event.date}"/></td>
			    <td><c:out value="${event.location}"/></td>
			    <td><c:out value="${event.getHost().getFirstName()}"/> <c:out value="${event.getHost().getLastName()}"/></td>
			    
			    
			    <td>
			    	<c:if test = "${event.getHost().getId() == currentUser.getId()}">
				       <a href="/events/<c:out value="${event.id}"/>/edit"> Edit </a> |
			    		<a href="/events/<c:out value="${event.id}"/>/delete"> Delete </a> 
				    </c:if>
				    <c:if test = "${event.getHost().getId() != currentUser.getId()}">
				    	<c:if test = "${event.checkIfJoining(currentUser) == true }">
				    		
			    			Joining ||
			    			<a href="/events/<c:out value="${event.id}"/>/cancel"> Cancel </a> 
			    		</c:if>
			    		<c:if test = "${event.checkIfJoining(currentUser) == false }">
				    		
			    			<a href="/events/<c:out value="${event.id}"/>/join"> Join </a> |
			    			
			    		</c:if>
			    	</c:if>
			    </td>
		    </tr>
		</c:forEach>
	</table>
	
	<h2>Here are some of the events in Out state:</h2>
    <table class="table">
			<tr>    
			    <td> Name </td>
			    <td>Date</td>
			    <td>Location </td>
			    <td>State </td>
			    <td>Host </td>
			    <td>Action/Status </td>
			    
		    </tr>
		<c:forEach items="${eventsOutState}" var="event" varStatus="loop">
		    <tr>    
			    <td><a href="/events/<c:out value="${event.id}"/>"><c:out value="${event.name}"/></a></td>
			    <td><c:out value="${event.date}"/></td>
			    <td><c:out value="${event.location}"/></td>
			    <td><c:out value="${event.state}"/></td>
			    <td><c:out value="${event.getHost().getFirstName()}"/> <c:out value="${event.getHost().getLastName()}"/></td>
			    
			    
			    <td>
			    	<c:if test = "${event.getHost().getId() == currentUser.getId()}">
				       <a href="/events/<c:out value="${event.id}"/>/edit"> Edit </a> |
			    		<a href="/events/<c:out value="${event.id}"/>/delete"> Delete </a> 
				    </c:if>
				    <c:if test = "${event.getHost().getId() != currentUser.getId()}">
			    		<a href="/events/<c:out value="${event.id}"/>/join"> Join </a> |
			    		<a href="/events/<c:out value="${event.id}"/>/cancel"> Cancel </a> 
			    	</c:if>
			    	
			    </td>
		    </tr>
		</c:forEach>
	</table>
     
    <h1> New Event </h1>
        <form:form method="POST" action="/events/new" modelAttribute="event">
	    <form:label path="name">Name: 
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
	    
	    </br>
	    <form:label path="date">Date: 
	    <form:errors path="date"/>
	    <form:input path="date" type="date"/></form:label>
	    
	    </br>
	    <form:label path="location">Location: 
	    <form:errors path="location"/>
	    <form:input path="location"/></form:label>
	    
	    </br>
	    <form:label path="state">State: 
	    <form:errors path="state"/>
	    <form:input path="state"/></form:label>
	    
	    </br>
	    
	    
	    <input type="submit" value="Create"/>
	</form:form>
    
   
</body>
</html>