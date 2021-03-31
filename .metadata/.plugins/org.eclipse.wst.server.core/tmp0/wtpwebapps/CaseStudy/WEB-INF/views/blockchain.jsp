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
<%-- 	<%Blockchain blockchain = new Blockchain("Bitcoin2");
	for (int i = 0; i < 4; i++) {
		blockchain.add_block(String.valueOf(i));
	}
	%><%=blockchain.toJSONtheChain()%> --%>
		${blockchain.toJSONtheChain()}
		
</body>
</html>