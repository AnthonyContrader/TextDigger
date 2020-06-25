<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.DocumentDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Document Read">
<meta name="author" content="Marcello Nichele">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Document</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>
	
	<br>

	<div class="main">
		<%
		DocumentDTO d = (DocumentDTO) request.getSession().getAttribute("dto");
		%>

		<table>
			<tr>
				<th>ID</th>
				<th>Text</th>
				<th>User</th>
				<th>Folder</th>
				<th>Description</th>
			</tr>
			<tr>
				<td><%=d.getId()%></td>
				<td><%=d.getText()%></td>
				<td><%=d.getUser().getUsername()%></td>
				<td><%=d.getFolder().getName()%></td>
				<td><%=d.getDescription().getDescription()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>

	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>