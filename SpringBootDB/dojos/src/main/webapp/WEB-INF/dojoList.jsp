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
		<h1> Dojo "<c:out value="${dojo.name}"/>"!!!! </h1>
		
		
		<table class="table">
			<tr>    
			    <td>First Name </td>
			    <td>Last Name </td>
		    </tr>
		<c:forEach items="${dojo.ninjas}" var="ninja" varStatus="loop">
		    <tr>    
			    <td><c:out value="${ninja.firstName}"/></td>
			    <td><c:out value="${ninja.lastName}"/></td>
			    
		    </tr>
		</c:forEach>
		</table>
	   
<!-- ... -->

</body></html>