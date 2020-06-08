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
<%@ include file="../css/header.jsp"%>
<%@ include file="../css/menu.jsp"%>
	
	<br>
	
	<div class="main">
	<%
			List<DocumentDTO> list = (List<DocumentDTO>) request.getSession().getAttribute("list");
	%>
	
	<br>
	
	<table>
		<tr>
			<th>Documents</th>
			<th></th>
			<th></th>
		</tr>
		<%for (DocumentDTO d : list) {%>
		<tr>
				<td><a href="/document/read?id=<%=d.getIdDocument()%>"> 
				<%=d.getText()%>
				</a></td>
				<td><%=d.getText()%></td>
				<td><a href="/document/preupdate?id=<%=d.getIdDocument()%>">Edit</a></td>


				<td><a href="/document/delete?id=<%=d.getIdDocument()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
		<form id="floatright" action="/document/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="document">Text</label>
				</div>
				<div class="col-75">
					<input type="text" id="text" name="text"
						placeholder="insert text">
				</div>
			</div>
			<button type="submit">Insert</button>
			
		</form>
	</div>

	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>