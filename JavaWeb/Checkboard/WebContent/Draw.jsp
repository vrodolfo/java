<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkerboard Assignment</title>
<style type="text/css">
.div{
	width: 100%;
	margin: 0 auto;
	text-align: center;
}
.box{
	width:50px;
	height:50px;
	margin: 0 0 0 0;
	display: inline-block;
	background-color: black;
}

.color1{
	background-color: black;
}

.color2{
	background-color: blue;
}

</style>
</head>
<body>
	<% String width = request.getParameter("width");
	   String height = request.getParameter("height"); 
	   int w = 0;
	   int h = 0;
	   
	   if(width != null){ w=Integer.parseInt(width); }
	   if(height != null){ h=Integer.parseInt(height); }
	   
	 
	 %>
	<h1 style="text-align: center;">Checkerboard:  <%= w %>w x <%= h %>h</h1>
	
	<div class="div">
		<% if (w != 0 && h != 0){ %>
		
		<% for(int index = 0; index <= h; index++) { %>
			
	        <% for(int j = 0; j <= w; j++) { %>
	        	<% if (index % 2 == 0){ %>
	        		<div class="box <% if (j % 2 == 0){ %> color2 <% } else{%> color1 <%} %>>">box</div>
	        	<% } else{%>
		        	<div class="box <% if (j % 2 == 0){ %> color1 <% } else{%> color2 <%} %>>">box</div>
		    	<% } %>
		    <% } %>
		    	</br>
	    <% } %>
	    <%} %>
	</div>
	
</body>
</html>