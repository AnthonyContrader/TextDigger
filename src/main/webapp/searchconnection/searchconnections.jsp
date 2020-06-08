<%@page import="it.contrader.dto.SearchConnectionDTO"%>
<%@ page import="it.contrader.dto.UserDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="SearchConnection Management">
<meta name="author" content="Vittorio Esposito">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>User Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>
	
	<br>
	
	<div class="main">
		<%
			List<SearchConnectionDTO> list = (List<SearchConnectionDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>IdDocument</th>
				<th>IdTag</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (SearchConnectionDTO s : list) {
			%>
			<tr>
				<td><a href="/searchconnection/read?id=<%=s.getIdDocument()%>"> <%=s.getIdTag()%>
				</a></td>
				<td><%=s.getIdDocument()%></td>
				<td><%=s.getIdTag()%></td>
				
			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/searchconnection/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="doc">IdDocument</label>
				</div>
				<div class="col-75">
					<input type="text" id="doc" name="IdDocument"
						placeholder="insert IdDocument">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="tag">IdTag</label>
				</div>
				<div class="col-75">
					<input type="text" id="tag" name="IdTag"
						placeholder="insert IdTag">
				</div>
			</div>

			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>