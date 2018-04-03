
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
		
		<a href="/songs/new">Add New</a> | 
		<a href="/topten">Top Songs</a>
		
		<form action="/search" action="get">
			<input type="text" name="search" id="search">
			<input type="submit" value="Search Artist">
		</form>

		<table class="table">
			<tr>    
			    <td>Name</td>
			    <td>Rating</td>
			    <td>Action</td>
		    
		    </tr>
		<c:forEach items="${songs}" var="song" varStatus="loop">
		    <tr>    
			    <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
			    <td><c:out value="${song.rating}"/></td>
			    <td>
			        <a href="/songs/delete/${song.id}">Delete </a>
			    </td>
		    </tr>
		</c:forEach>
		</table>
		

</body>
</html>
<!-- ... -->