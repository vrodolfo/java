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
		<h1> <c:out value="${question.content}"/>, !!!! </h1>
		
		<h2>Tags: 
					<c:forEach items="${question.tags}" var="tag" varStatus="loop">   
						<c:out value="${tag.subject}"/>, 
					</c:forEach>
		
		</h2>
		
		<h3>Answers</h3>
		<table class="table">
			<tr>    
			    <td>Answer </td>
		    </tr>
		<c:forEach items="${question.answers}" var="answer" varStatus="loop">
		    <tr>    
			    <td>
					<c:out value="${answer.content}"/>
			    </td>
		    </tr>
		</c:forEach>
		</table>
		
		</br>
		
		<h1> Add your Answer !!!! </h1>
		<form:form method="POST" action="/answers/new" modelAttribute="answer">
	    <form:label path="content">Answer: 
	    <form:errors path="content"/>
	    <form:input path="content"/></form:label>
	    
	    </br>
	    <input type="hidden" name="questionID" id="questionID" value="<c:out value="${question.id}"/>"/>
	    <input type="submit" value="Submit"/>
		</form:form>
	   
<!-- ... -->

</body></html>