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

		<table class="table">
			<tr>    
			    <td>Name</td>
			    <td>Creator</td>
			    <td>Version</td>
			    <td>Action</td>
		    
		    </tr>
		<c:forEach items="${languages}" var="language" varStatus="loop">
		    <tr>    
			    <td><a href="/languages/${loop.index}"><c:out value="${language.name}"/></a></td>
			    <td><c:out value="${language.creator}"/></td>
			    <td><c:out value="${language.version}"/></td>
			    <td><c:out value="${book.numberOfPages}"/></td>
			    <td><a href="/languages/edit/${loop.index}">Edit </a> | 
			        <a href="/languages/delete/${loop.index}">Delete </a>
			    </td>
		    </tr>
		</c:forEach>
		</table>
		
		</br>
		</br>
		<h1> Create Language </h1>
        <form:form method="POST" action="/languages/new" modelAttribute="language">
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
	    
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