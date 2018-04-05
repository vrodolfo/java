
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
		
		

		<h1> Category <c:out value="${category.name}"/>  </h1>
		
		Current Products:
		<table class="table">
			<tr>    
			    
			    <td> Name </td>
		    </tr>
		<c:forEach items="${category.products}" var="product" varStatus="loop">
		    <tr>    
			    <td><c:out value="${product.name}"/></td>
			    
		    </tr>
		</c:forEach>
		</table>
		

		</br>
		
        <form method="POST" action="/categories/<c:out value="${category.id}"/> /addProduct" >
        Add Product: 
        <select name="productID" id="productID">
	        <c:forEach items="${products}" var="product" varStatus="loop">
			    <option value="<c:out value="${product.id}"/>">  
				   <c:out value="${product.name}"/> 
			    </option> 
			</c:forEach>
		</select>
         </br>
	    <input type="submit" value="Submit"/>
		</form>


</body>
</html>