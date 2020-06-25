<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.SearchConnectionDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="SearchConnection Read">
<meta name="author" content="Vittorio Esposito">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read SearchConnection</title>
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
				<th>IDSearchConnection</th>
				<th>Document</th>
				<th>Tag</th>
			</tr>
			<tr>
				<td><%=c.getId() %></td>
				<td><%=c.getDocument().getText()%></td>
				<td><%=c.getTag().getTag()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>

	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>