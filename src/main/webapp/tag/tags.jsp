<%@ page import="it.contrader.dto.TagDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Tag Management">
<meta name="author" content="Marco Fellone">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Tag Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>
	
	<br>
	
	<div class="main">
		<%
			List<TagDTO> list = (List<TagDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Tags</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (TagDTO t : list) {
			%>
			<tr>
				<td><a href="/tag/read?id=<%=t.getId()%>"> <%=t.getTag()%></a></td>
				<td><a href="/tag/preupdate?id=<%=t.getId()%>">Edit</a></td>
				<td><a href="/tag/delete?id=<%=t.getId()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>

		<form id="floatright" action="/tag/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="tag">Tag</label>
				</div>
				<div class="col-75">
					<input type="text" id="tag" name="tag"
						placeholder="insert tag">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>