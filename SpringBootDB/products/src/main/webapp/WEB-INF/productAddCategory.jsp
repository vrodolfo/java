
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Products and Categories</title>
      
</head>
<body>
		
		

		<h1> Product <c:out value="${product.name}"/>  </h1>
		
		Current Categories:
		<table class="table">
			<tr>    
			    
			    <td> Name </td>
		    </tr>
		<c:forEach items="${product.categories}" var="category" varStatus="loop">
		    <tr>    
			    <td><c:out value="${category.name}"/></td>
			    
		    </tr>
		</c:forEach>
		</table>
		

		</br>
		
        <form method="POST" action="/products/<c:out value="${product.id}"/> /addCategory" >
        Add Category: 
        <select name="category" id="category">
	        <c:forEach items="${categories}" var="category" varStatus="loop">
			    <option value="<c:out value="${category.id}"/>">  
				   <c:out value="${category.name}"/> 
			    </option> 
			</c:forEach>
		</select>
         </br>
	    <input type="submit" value="Submit"/>
		</form>


</body>
</html>