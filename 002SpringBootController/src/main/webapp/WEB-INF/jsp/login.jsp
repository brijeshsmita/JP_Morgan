<%-- Login View - JSP
Simple login page with user id and password form fields. If an error message is populated into the model, ${errorMessage} will show the authentication failure error message.
 --%>
<html>
<head>
<title>Spring Boot MVC Application</title>
</head>
<body>
	<h1>Spring Boot MVC Application</h1>
	<hr>
	<font color="red">${errorMessage}</font>
	<form method="post">
		Name : <input type="text" name="name" /> <br>Password : <input
			type="password" name="password" /><br> <input type="submit" />
	</form>
</body>
</html>