<%@page import="it.contrader.dto.SearchConnectionDTO"%>
<%@ page import="it.contrader.dto.DocumentDTO" import="java.util.*"%>
<%@ page import="it.contrader.dto.TagDTO" import="java.util.*"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="SearchConnection Management">
<meta name="author" content="Vittorio Esposito">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>SearchConnection Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>
	
	<br>
	
	<div class="main">
		<%
			List<SearchConnectionDTO> list = (List<SearchConnectionDTO>) request.getSession().getAttribute("list");
			List<DocumentDTO> documents = (List<DocumentDTO>) request.getSession().getAttribute("documents");
			List<TagDTO> tags = (List<TagDTO>) request.getSession().getAttribute("tags");
		%>

		<br>

		<table>
			<tr>
				<th>SearchConnection</th>
				<th>Tag</th>
				<th>Document</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (SearchConnectionDTO s : list) {
			%>
			<tr>
				
				<td><a href="/searchconnection/read?id=<%=s.getId()%>"></a></td>
				<td><%=s.getTag().getTag()%></td>
				<td><%=s.getDocument().getText()%></td>
				<td><a href="/searchconnection/preupdate?id=<%=s.getId()%>">Edit</a></td>
				<td><a href="/searchconnection/delete?id=<%=s.getId()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>

		<form id="floatright" action="/searchconnection/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="tag">Tag</label>
				</div>
				<div class="col-75">
		 			<select id="tag" name="tag" required>
		 			<option value="" disabled selected>Select Tag</option>
 					<% 			
						for (TagDTO t : tags) {
							%> <option value="<%=t.getId()%>"><%=t.getTag()%></option> <%
						}%> 
					</select>
    			</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="document">Document</label>
				</div>
				<div class="col-75">
		 			<select id="document" name="document" required>
		 			<option value="" disabled selected>Select Document</option>
 					<% 			
						for (DocumentDTO d : documents) {
							%> <option value="<%=d.getId()%>"><%=d.getText()%></option> <%
						}%> 
					</select>
    			</div>
			</div>

			<button type="submit">Insert</button>
		</form>
		

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>