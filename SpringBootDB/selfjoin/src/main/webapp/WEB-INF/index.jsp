<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Selfjoin</title>
      
</head>
<body>	
		<h1> Manager "<c:out value="${manager.getFirstname()}"/>"!!!! </h1>
		
		Subordinates:
		<table class="table">
			<tr>    
			    <td>First Name </td>
			    <td>Last Name </td>
		    </tr>
		<c:forEach items="${employees}" var="employee" varStatus="loop">
		    <tr>    
			    <td><c:out value="${employee.getFirstname()}"/></td>
			    <td><c:out value="${employee.getLastname()}"/></td>
			    
		    </tr>
		</c:forEach>
		</table>
	   
<!-- ... -->

</body></html>