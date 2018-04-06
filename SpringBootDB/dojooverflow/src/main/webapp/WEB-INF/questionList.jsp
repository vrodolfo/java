<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Questions</title>
      
</head>
<body>	
		<h1> Questions Dashboard!!!! </h1>
		
		
		<table class="table">
			<tr>    
			    <td>Question </td>
			    <td>Tags </td>
		    </tr>
		<c:forEach items="${questions}" var="question" varStatus="loop">
		    <tr>    
			    <td><a href="/questions/<c:out value="${question.id}"/>"><c:out value="${question.content}"/></a></td>
			    <td>
			    	<c:forEach items="${question.tags}" var="tag" varStatus="loop">   
						<c:out value="${tag.subject}"/>, 
					</c:forEach>
			    </td>
		    </tr>
		</c:forEach>
		</table>
		
		<a href="/questions/new">New Question</a>
	   
<!-- ... -->

</body></html>