
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Dojo Overflow</title>
      
</head>
<body>
		<h1> Questions!!! </h1>
		
		

		<h1> New Question </h1>
        <form:form method="POST" action="/questions/new" modelAttribute="question">
	    <form:label path="content">Question: 
	    <form:errors path="content"/>
	    <form:input path="content"/></form:label>
	    
	    </br>
	    
	   <c:if test="${not empty errors}">
		  <h2></h2> <c:out value="${errors}" /></h2>
		</c:if>
	    
	    Tags:
	    <input type="text" name="tag" id="tag">
	     </br>
	    
	    
	    <input type="submit" value="Submit"/>
	</form:form>
<!-- ... -->


</body>
</html>