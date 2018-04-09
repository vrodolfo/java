<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Countries</title>
      
</head>
<body>	
		<h1> Countries Speaking Slovene!!!! </h1>
		
		
		<table class="table">
			<tr>    
			    <td>Country </td>
			    <td>Percentage </td>
		    </tr>
		<c:forEach var="row" items="${result1}">                
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
        </tr>
        </c:forEach>
		</table>
		
		<h1> Cities per Country!!!! </h1>
		<table class="table">
			<tr>    
			    <td>Country </td>
			    <td>Cities </td>
		    </tr>
		<c:forEach var="row" items="${result2}">                
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
        </tr>
        </c:forEach>
		</table>
		
		<h1> Cities In Mexico with Population higher than 500k!!!! </h1>
		<table class="table">
			<tr>    
			    <td>Country </td>
			    <td>Cities </td>
		    </tr>
		<c:forEach var="row" items="${result3}">                
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
        </tr>
        </c:forEach>
		</table>
		
		
		<h1> Languages where spoken in more than 89%!!!! </h1>
		<table class="table">
			<tr>    
			    <td>Country </td>
			    <td>Language </td>
			    <td>Percentage </td>
		    </tr>
		<c:forEach var="row" items="${result4}">                
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
        </tr>
        </c:forEach>
		</table>
		
		
		<h1> Cities with Surface Greater than 501 and Population > 100k!!!! </h1>
		<table class="table">
			<tr>    
			    <td>Country </td>
			    <td>Surface </td>
			    <td>Population </td>
		    </tr>
		<c:forEach var="row" items="${result5}">                
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
        </tr>
        </c:forEach>
		</table>
		
		<h1> Countries with Surface Greater than 200 and Life Expectancy > 75!!!! </h1>
		<table class="table">
			<tr>    
			    <td>Country </td>
			    <td>Surface </td>
			    <td>Population </td>
		    </tr>
		<c:forEach var="row" items="${result6}">                
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
        </tr>
        </c:forEach>
		</table>
		
		<h1> Cities in Argentina, Buenos Aires District with population > 500k!!!! </h1>
		<table class="table">
			<tr>    
			    <td>City </td>
			    <td>District </td>
			    <td>Population </td>
		    </tr>
		<c:forEach var="row" items="${result7}">                
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
        </tr>
        </c:forEach>
		</table>
	   
	   
	   <h1> Number of Countries Per Region!!!! </h1>
		<table class="table">
			<tr>    
			    <td>Region </td>
			    <td>Countries </td>
			   
		    </tr>
		<c:forEach var="row" items="${result8}">                
        <tr>
            <td>${row[1]}</td>
            <td>${row[0]}</td>
        </tr>
        </c:forEach>
		</table>
<!-- ... -->

</body></html>