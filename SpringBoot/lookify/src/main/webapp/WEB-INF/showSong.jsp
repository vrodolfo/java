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
		<h1> Lookify!!!! </h1>
		<a href="/dashboard">Dashboard </a> 
		
		<p><c:out value="${song.title}"/></p>
		<p><c:out value="${song.artist}"/></p>
		<p><c:out value="${song.rating}"/></p>
	    <a href="/songs/delete/${song.id}">Delete </a>
		

	    
	   
<!-- ... -->

</body></html>