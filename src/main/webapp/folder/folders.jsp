<%@ page import="it.contrader.dto.FolderDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Interest Management">
<meta name="author" content="Marco Fellone">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Interest Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a class="active" href="/user/getall">Users</a> 
		<a href="/user/logout" id="logout">Logout</a>
			<!-- Manca la mia parte di barra -->
	</div>
	<div class="main">
		<%
			List<FolderDTO> list = (List<FolderDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Interest</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (FolderDTO f : list) {
			%>
			<tr>
				<td><a href="/folder/read?id=<%=f.getIdFolder()%>"> <%=f.getName()%></a></td>
				<td><a href="/folder/preupdate?id=<%=f.getIdFolder()%>">Edit</a></td>
				<td><a href="/folder/delete?id=<%=f.getIdFolder()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>

		<form id="floatright" action="/folder/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="name">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="name" name="name"
						placeholder="inserisci name folder">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>