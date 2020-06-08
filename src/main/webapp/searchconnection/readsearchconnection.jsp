<%@page import="it.contrader.dto.SearchConnectionDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.DocumentDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="SearchConnection Read">
<meta name="author" content="Vittorio Esposito">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Tag</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>
	<br>

	<div class="main">
		<%
		SearchConnectionDTO c = (SearchConnectionDTO) request.getSession().getAttribute("dto");
		%>

		<table>
			<tr>
				<th>IdSearchConnection</th>
				<th>IdDocument</th>
				<th>IdTag</th>
			</tr>
			<tr>
				<td><%=c.getIdSearchConnection() %></td>
				<td><%=c.getDocument().getIdDocument()%></td>
				<td><%=c.getTag().getId()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>

	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>