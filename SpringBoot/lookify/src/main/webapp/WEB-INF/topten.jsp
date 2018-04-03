
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
		
		
		<a href="/dashboard">Dashboard</a> 
		
		<h1> Top Ten Songs!!! </h1>

		

		<table class="table">
			
		<c:forEach items="${songs}" var="song" varStatus="loop">
		    <tr>    
			    <td>
			    	<c:out value="${song.rating}"/> -
			    	<a href="/songs/${song.id}"><c:out value="${song.title}"/></a> -
			    	<c:out value="${song.artist}"/>
			    </td>
			   
		    </tr>
		</c:forEach>
		</table>
		

</body>
</html>
<!-- ... -->