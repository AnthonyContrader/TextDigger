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
<title>Interest Manager</title>

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
				<th>Interest</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (SubscribeDTO b : list) {
			%>
			<tr>
				<td><a href="/subscribe/read?id=<%=b.getIdSubscribe()%>"> <%=b.getName()%></a></td>
				<td><a href="/subscribe/preupdate?id=<%=b.getIdSubscribe()%>">Edit</a></td>
				<td><a href="/subscribe/delete?id=<%=b.getIdSubscribe()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>

		<form id="floatright" action="/subscribe/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="name">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="name" name="name"
						placeholder="inserisci name subscribe">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>