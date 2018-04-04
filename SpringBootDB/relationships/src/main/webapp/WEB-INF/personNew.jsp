
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Driver License</title>
      
</head>
<body>
		<h1> Drivers License!!! </h1>
		
		

		<h1> New Person </h1>
        <form:form method="POST" action="/persons/new" modelAttribute="person">
	    <form:label path="firstName">First Name: 
	    <form:errors path="firstName"/>
	    <form:input path="firstName"/></form:label>
	    
	    </br>
	    
	    <form:label path="lastName">Last Name:
	    <form:errors path="lastName"/>
	    <form:input path="lastName"/></form:label>
	    
	    </br>
	    
	    
	    <input type="submit" value="Submit"/>
	</form:form>
<!-- ... -->


</body>
</html>