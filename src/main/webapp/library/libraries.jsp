<%@page import="it.contrader.dto.LibraryDTO"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Library Management">
<meta name="author" content="Marcello Nichele">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Library Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>
	<br>
	<div class="main">
		<%
			List<LibraryDTO> list = (List<LibraryDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Libraries</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (LibraryDTO l : list) {
			%>
			<tr>
				<td><a href="/library/read?id=<%=l.getIdLibrary()%>"> <%=l.getName()%></a></td>
				<td><a href="/library/preupdate?id=<%=l.getIdLibrary()%>">Edit</a></td>
				<td><a href="/library/delete?id=<%=l.getIdLibrary()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>

		<form id="floatright" action="/library/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="name">Library</label>
				</div>
				<div class="col-75">
					<input type="text" id="library" name="library"
						placeholder="insert library name">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>