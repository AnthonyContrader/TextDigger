<%@ page import="it.contrader.dto.DocumentDTO" import="java.util.*" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Document Management">
<meta name="author" content="Marcello Nichele">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Document Manager</title>
</head>
<body>
<%@ include file="../header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a class="active" href="/user/getall">Users</a> 
	</div>
	
	<div class="main">
	<%
			List<DocumentDTO> list = (List<DocumentDTO>) request.getSession().getAttribute("list");
	%>
	
	<br>
	
	<table>
		<tr>
			<th>Text</th>
			<th></th>
		</tr>
		<%for (DocumentDTO d : list) {%>
		<tr>
				<td><a href="/document/read?id=<%=d.getIdDocument()%>"> 
				<%=d.getText()%>
				<%=d.getUser().getId() %>
				</a></td>
				<td><%=d.getText()%></td>
				<td><a href="/document/preupdate?id=<%=d.getIdDocument()%>">Edit</a></td>


				<td><a href="/document/delete?id=<%=d.getIdDocument()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
		<form id="floatright" action="/user/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="document">Text</label>
				</div>
				<div class="col-75">
					<input type="text" id="document" name="text"
						placeholder="inserisci text">
				</div>
			</div>
			<button type="submit">Insert</button>
			
		</form>
	</div>

	<br>
	<%@ include file="../footer.jsp"%>
</body>
</html>