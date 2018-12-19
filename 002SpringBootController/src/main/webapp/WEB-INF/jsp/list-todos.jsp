<!-- List Todos - JSP
This is the page that will show our list of todos. This is a completely unformatted page. During the subsequent steps, we will beautify this page and create more functionalities so you can add, delete, and update todos.
 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spring Boot MVC Application</title>
</head>
<body>
	<h1>Spring Boot MVC Application</h1>
	<hr>
	<h2>
		Hello : ${name}<br>Here are the list of your todos:
	</h2>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>Task ID</th>
				<th>Task Description</th>
				<th>Task targetDate</th>
				<th>Task Status</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty todos}">
				<tr>
					<td colspan="8">No task to Display</td>
				</tr>
			</c:if>
			<c:if test="${not empty todos}">

				<c:forEach items="${todos}" var="task">
					<tr class="">
						<td>${task.id}</td>
						<td>${task.desc}</td>
						<td>${task.targetDate}</td>
						<td>${task.status}"</td>

					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	</div>
</body>
</html>