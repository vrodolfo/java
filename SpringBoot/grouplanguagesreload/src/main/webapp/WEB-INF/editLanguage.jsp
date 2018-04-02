
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Group Languages</title>
      
</head>
<body>
		<h1> Group Languages!!! </h1>

		<a href="/languages">Dashboard </a>
		</br> 
		<a href="/languages/delete/${language.id}">Delete Language</a>
		
		</br>
		<h1> Edit Language </h1>
		
		
		
        <form:form method="POST" action="/languages/edit/${language.id}" modelAttribute="language">
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
	    
	    <form:hidden path="id"/>
	    
	    </br>
	    
	    <form:label path="creator">Creator
	    <form:errors path="creator"/>
	    <form:input path="creator"/></form:label>
	    
	    </br>
	    
	    <form:label path="version">Version
	    <form:errors path="version"/>
	    <form:input path="version"/></form:label>
	    
	    </br>
	    
	    
	    <input type="submit" value="Submit"/>
	</form:form>
<!-- ... -->