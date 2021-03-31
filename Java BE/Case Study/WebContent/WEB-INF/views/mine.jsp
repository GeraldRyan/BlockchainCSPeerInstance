<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page import="privblock.gerald.ryan.entity.Blockchain"%>
<%@ page import="privblock.gerald.ryan.entity.Block"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>The dwarves are hard at work mining your Block</h2>
	<h3>
		<%=request.getAttribute("foo")%>
		<%
		Blockchain bc = (Blockchain) request.getAttribute("blockchain");
		Block last_block = bc.getLastBlock();
		%>
		<%=bc.toJSONtheChain()%>
	</h3>

	<h4>Most recent block</h4>
	<%=	bc.getLastBlock().toJSONtheBlock()
	%>
	<h1>Welcome to our ${foo}</h1>
	<h3>${afb}</h3>
</body>
</html>