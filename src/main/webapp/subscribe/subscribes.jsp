<%@page import="it.contrader.dto.SubscribeDTO"%>
<%@ page import="it.contrader.dto.FolderDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Interestgroup Management">
<meta name="author" content="Vittorio Esposito">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Subscribe Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>
	
	<br>
	
	<div class="main">
		<%
			List<SubscribeDTO> list = (List<SubscribeDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>IDSubscribe</th>
				<th>IDUser</th>
				<th>IDInterestGroup</th>
			</tr>
			<%
				for (SubscribeDTO b : list) {
			%>
			<tr>
				<td><a href="/subscribe/read?id=<%=b.getId()%>">
				</a></td>
				<td><%=b.getUser().getId()%></td>
				<td><%=b.getInterestgroup().getId()%></td>
				<td><a href="/subscribe/preupdate?id=<%=b.getId()%>">Edit</a></td>
				<td><a href="/subscribe/delete?id=<%=b.getId()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
<!-- 
		<form id="floatright" action="/subscribe/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="id">Subscribe Id</label>
				</div>
				<div class="col-75">
					<input type="number" id="id" name="id"
						placeholder="insert subscribe id">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>
-->

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>