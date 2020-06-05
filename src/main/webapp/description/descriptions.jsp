<%@ page import="it.contrader.dto.DescriptionDTO" import="java.util.*" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Description Management">
<meta name="author" content="Marcello Nichele">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Document Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a class="active" href="/user/getall">Users</a> 
	</div>
	
	<div class="main">
	<%
			List<DescriptionDTO> list = (List<DescriptionDTO>) request.getSession().getAttribute("list");
	%>
	
	<br>
	
	<table>
		<tr>
			<th>Text</th>
			<th>Users</th>
		</tr>
		<%for (DescriptionDTO d : list) {%>
		<tr>
				<td><a href="/description/read?id=<%=d.getIdDescription()%>"> 
				<%=d.getDescription()%>
				</a></td>
				<td><a href="/description/preupdate?id=<%=d.getIdDescription()%>">Edit</a></td>


				<td><a href="/description/delete?id=<%=d.getIdDescription()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
		<form id="floatright" action="/description/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="description">Description</label>
				</div>
				<div class="col-75">
					<input type="text" id="description" name="description"
						placeholder="inserisci description">
				</div>
			</div>
			<button type="submit">Insert</button>
			
		</form>
	</div>

	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>