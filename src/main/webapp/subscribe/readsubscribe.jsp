<%@page import="it.contrader.dto.SubscribeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.FolderDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Subscribe Read">
<meta name="author" content="Vittorio Esposito">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Interest</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>
	<br>

	<div class="main">
		<%
		SubscribeDTO s = (SubscribeDTO) request.getSession().getAttribute("dto");
		%>

		<table>
			<tr>
				<th>ID</th>
			</tr>
			<tr>
				<td><%=s.getId()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>

	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>