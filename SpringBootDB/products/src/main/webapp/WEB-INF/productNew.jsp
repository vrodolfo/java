
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
		<h1> Product!!! </h1>
		
		

		<h1> New Product </h1>
        <form:form method="POST" action="/products/new" modelAttribute="product">
	    <form:label path="name">Name: 
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
	    
	    </br>
	    <form:label path="description">Description: 
	    <form:errors path="description"/>
	    <form:input path="description"/></form:label>
	    
	    </br>
	    <form:label path="price">Price: 
	    <form:errors path="price"/>
	    <form:input path="price" type="number"/></form:label>
	    
	    </br>
	    
	    
	    <input type="submit" value="Submit"/>
	</form:form>
<!-- ... -->


</body>
</html>