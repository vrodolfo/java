
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Dojos and Ninjas</title>
      
</head>
<body>
		<h1> Dojos!!! </h1>
		
		

		<h1> New Dojo </h1>
        <form:form method="POST" action="/dojos/new" modelAttribute="dojo">
	    <form:label path="name">Name: 
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
	    
	    </br>
	    
	    
	    <input type="submit" value="Submit"/>
	</form:form>
<!-- ... -->


</body>
</html>