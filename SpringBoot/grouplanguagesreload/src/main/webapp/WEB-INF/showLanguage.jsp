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
		<h1> Language Reloaded </h1>
		<a href="/languages">Dashboard </a> 
		<p><c:out value="${language.name}"/></p>
		<p><c:out value="${language.creator}"/></p>
		<p><c:out value="${language.version}"/></p>
		<a href="/languages/edit/${language.id}">Edit </a> 
	    <a href="/languages/delete/${language.id}">Delete </a>
		

	    
	   
<!-- ... -->