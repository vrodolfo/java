<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<a href="/">Go Back</a>
</br>
<span><fmt:formatDate value="${date}" pattern="HH:mm:ss"/></span>
</br>
<span id="date"><fmt:formatDate type = "both"  dateStyle = "long" timeStyle = "long" value = "${date}" /></span>