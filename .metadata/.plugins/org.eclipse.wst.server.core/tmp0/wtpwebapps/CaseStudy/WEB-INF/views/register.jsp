<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register here</title>
</head>
<body>
	<form:form action="./register" method="post" modelAttribute="user">
		<div>
			<label>Name</label>
			<form:input path="name" />
			<form:errors path="name" />
		</div>
		<div>
			<label>Email</label>
			<form:input path="email" />
			<form:errors path="email" />
		</div>
		<div>
			<input type="submit" value="Login" />
		</div>
	</form:form>
</body>
</html>