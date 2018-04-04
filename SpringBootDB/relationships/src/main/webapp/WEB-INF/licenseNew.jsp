
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
		
		

		<h1> New License </h1>
        <form:form method="POST" action="/licenses/new" modelAttribute="license">
        
        <select name="person" id="person">
        <c:forEach items="${people}" var="person" varStatus="loop">
		    <option value="<c:out value="${person.id}"/>">  
			   <c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/>
		    </option> 
		</c:forEach>
		</select>
         </br>
        
	    <form:label path="state">State: 
	    <form:errors path="state"/>
	    <form:input path="state"/></form:label>
	    
	    </br>
	    
	    
	    
	    <form:label path="expiration_date">Expiration Date:
	    <form:errors path="expiration_date"/>
	    <form:input path="expiration_date" type="date"/></form:label>
	    
	    </br>
	    
	    
	    <input type="submit" value="Submit"/>
	</form:form>
<!-- ... -->


</body>
</html>