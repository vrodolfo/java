
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Lookify</title>
      
</head>
<body>
		<h1> Lokkify!!! </h1>
		
		<a href="/dashboard">Dashboard</a> 

		<h1> Create Song </h1>
        <form:form method="POST" action="/songs/new" modelAttribute="song">
	    <form:label path="title">Title
	    <form:errors path="title"/>
	    <form:input path="title"/></form:label>
	    
	    </br>
	    
	    <form:label path="artist">Artist
	    <form:errors path="artist"/>
	    <form:input path="artist"/></form:label>
	    
	    </br>
	    
	    <form:label path="rating">Rating
	    <form:errors path="rating"/>
	    <form:input path="rating"/></form:label>
	    
	    </br>
	    
	    
	    <input type="submit" value="Submit"/>
	</form:form>
<!-- ... -->


</body>
</html>