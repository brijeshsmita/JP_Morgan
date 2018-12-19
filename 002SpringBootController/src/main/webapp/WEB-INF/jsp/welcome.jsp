<!-- Welcome View - JSP
The welcome page is shown on successful authentication. Shows the name of the login user and a link to manage your todos.
 -->
<html>
<head>
<title>Spring Boot MVC Application</title>
</head>
<body>
	<h1>Spring Boot MVC Application</h1>
	<hr>
	<h3>
		Welcome ${name}!! <a href="/list-todos">Click here</a> to manage your
		todo's.
	</h3>
</body>
</html>