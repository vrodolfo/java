
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Belt Reviewer - Edit Event</title>
      
</head>
<body>
		<h1> <c:out value="${event.name}"/>	!!! </h1>
		
		

		<h2> Edit Event </h2>
        <form:form method="POST" action="/events/${event.id}/edit" modelAttribute="event">
	    <form:label path="name">Name: 
	    <form:errors path="name"/>
	    <form:input path="name" value="${event.name}"/></form:label>
	    
	    </br>
	    <form:label path="date">Date: 
	    <form:errors path="date"/>
	    <form:input path="date"  value="${event.date}" type="date"/></form:label>
	    
	    </br>
	    <form:label path="location">Location: 
	    <form:errors path="location"/>
	    <form:input path="location"  value="${event.location}"/></form:label>
	    
	    </br>
	    <form:label path="state">State: 
	    <form:errors path="state"/>
	    <form:input path="state"  value="${event.state}"/></form:label>
	    
	    </br>
	    
	    
	    <input type="submit" value="Update"/>
	</form:form>
<!-- ... -->


</body>
</html>