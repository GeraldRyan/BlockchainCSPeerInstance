<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="privblock.gerald.ryan.entity.Blockchain"%>
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
	<%
	Blockchain blockchain = new Blockchain("Bitcoin2");
	for (int i = 0; i < 4; i++) {
		blockchain.add_block(String.valueOf(i));
	}
	%>
	<h5>Here's what we got</h5>
	<br>
	<%=blockchain.toStringBroadcastChain()%>

	<br>
	<br>
	<h5>As JSON</h5>
	<br>
	<%=blockchain.toJSONtheChain()%>
</body>
</html>