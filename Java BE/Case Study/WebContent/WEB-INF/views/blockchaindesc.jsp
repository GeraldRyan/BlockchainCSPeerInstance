<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="privblock.gerald.ryan.entity.Blockchain"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<p>Here is the current longest valid chain according to our intel.</p>
	<p>However, we are just a node on a peer to peer network. Do ask
		around</p>
	<br>

	<h5>Here's what we got</h5>
	<br>
	<%
	Blockchain bc = (Blockchain) request.getAttribute("blockchain");
	%>
	<%=bc.toStringBroadcastChain()%>

	<br>
	<br>
	<h5>As JSON</h5>
	<br>
	<%=bc.toJSONtheChain()%>
	<br>
	<br>


	<form:form action="./blockchaindesc" modelAttribute="blockdata" method="post">
		<form:label path="blockdata">Block Data </form:label>
		<form:input type="text" path="blockdata" />
		<br />
		<br />
		<input type="submit" value="Post">
	</form:form>


	<a href="./blockchain/mine">Mine Block</a>
	<h3>${afb}</h3>
</body>
</html>