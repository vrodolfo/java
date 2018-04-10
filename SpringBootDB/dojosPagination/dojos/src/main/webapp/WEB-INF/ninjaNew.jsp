
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Dojos</title>
      
</head>
<body>
		<h1> Ninjas!!! </h1>
		
		

		<h1> New Ninja </h1>
        <form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
        Dojos: 
        <select name="dojo" id="dojo">
        <c:forEach items="${dojos}" var="dojo" varStatus="loop">
		    <option value="<c:out value="${dojo.id}"/>">  
			   <c:out value="${dojo.name}"/> 
		    </option> 
		</c:forEach>
		</select>
         </br>
        
	    <form:label path="firstName">First Name: 
	    <form:errors path="firstName"/>
	    <form:input path="firstName"/></form:label>
	    
	    </br>
	    
	    
	    
	    <form:label path="lastName">Last Name:
	    <form:errors path="lastName"/>
	    <form:input path="lastName" /></form:label>
	    
	    </br>
	    
	    
	    <input type="submit" value="Submit"/>
	</form:form>
<!-- ... -->


</body>
</html>