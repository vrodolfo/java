<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="ninjas">
    <h1>Dojos</h1>
    
    // for loop to create all the links
    <c:forEach begin="1" end="${totalPages}" var="index">
        <a href="/dojos/pages/${index}">${index}</a>
    </c:forEach>
    <table class="table">
        <thead>
        	<th>Dojo Name</th>
            <th>Ninja First Name</th>
            <th>Ninja Last Name</th>
        </thead>
        <tbody>
        
   
        
        
        
            // we have to call the .content method to actually get the ninjas inside the Page iterable.
            <c:forEach var="ninja" items="${dojos.content}">                 
            <tr>
            	<td><c:out value="${ninja[0]}"></c:out></td>
                <td><c:out value="${ninja[1]}"></c:out></td>
                <td><c:out value="${ninja[2]}"></c:out></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>