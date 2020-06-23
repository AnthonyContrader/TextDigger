<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.FolderDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Folder Read">
<meta name="author" content="Marcello Nichele">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Interest</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>
	<br>

	<div class="main">
		<%
		FolderDTO f = (FolderDTO) request.getSession().getAttribute("dto");
		%>

		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Library</th>
			</tr>
			<tr>
				<td><%=f.getId()%></td>
				<td><%=f.getName()%></td>
				<td><%=f.getDescription()%></td>
				<td><%=f.getLibrary()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>

	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>