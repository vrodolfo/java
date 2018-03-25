<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

div{
	display:inline-block;
	margin-left:100px;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<div>
		<form action="/Pets/ShowDog" method="post">
		<table>
			<tr>
				<td><h1>Make a Dog!</h1></td>
			</tr>
			<tr>
				<td><span>Name:</span><input type="text" name="name" id="name"/></td>
			</tr>
			<tr>
				<td><span>Breed:</span><input type="text" name="breed" id="breed"/></td>
			</tr>
			<tr>
				<td><span>Weight:</span><input type="number" name="weight" id="weight"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Dog"/></td>
			</tr>
		
		</table>
		</form>
	</div>
	
	<div>
		<form action="/Pets/ShowCat" method="post">
		<table>
			<tr>
				<td><h1>Make a Cat!</h1></td>
			</tr>
			<tr>
				<td><span>Name:</span><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td><span>Breed:</span><input type="text" name="breed" id="breed"></td>
			</tr>
			<tr>
				<td><span>Weight:</span><input type="number" name="weight" id="weight"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Cat"/></td>
			</tr>
		
		</table>
		</form>
	</div>
	

</body>
</html>