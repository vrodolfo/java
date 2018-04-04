<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->

<!DOCTYPE html>
<html>
<head>
		<link href="/style.css" rel="stylesheet"/>
        <title>Driver License</title>
      
</head>
<body>	
		<h1> Driver License!!!! </h1>
		<h2><c:out value="${person.firstName}"/>  <c:out value="${person.lastName}"/></h2>
		License Number::::::<c:out value="${person.license.number}"/>
		</br>
		State::::::<c:out value="${person.license.state}"/>
		</br>
		Expiration Date::::::<c:out value="${person.license.expiration_date}"/>
		</br>
	   
<!-- ... -->

</body></html>