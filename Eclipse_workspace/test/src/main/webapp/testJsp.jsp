<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./styleForTestJsp.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	for(int i = 0; i < 2; i++){
		out.print("<h1>wel come to jsp</h1>");
	}
	%>
	<%="<h2>naol kasinet</h2>" %>
	<p>${message}</p>
	<c:forEach var="item" items="${message}">
    <p>${item}</p>
	</c:forEach>
	
</body>
</html>