<%@ page import="it.contrader.dto.InterestgroupDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Interestgroup Management">
<meta name="author" content="Marco Fellone">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Interest Group Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>
	<br>
	<div class="main">
		<%
			List<InterestgroupDTO> list = (List<InterestgroupDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Interest Group</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (InterestgroupDTO ig : list) {
			%>
			<tr>
				<td><a href="/interestgroup/read?id=<%=ig.getId()%>"> <%=ig.getInterestgroup()%></a></td>
				<td><a href="/interestgroup/preupdate?id=<%=ig.getId()%>">Edit</a></td>
				<td><a href="/interestgroup/delete?id=<%=ig.getId()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>

		<form id="floatright" action="/interestgroup/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="interestgroup">Interest Group</label>
				</div>
				<div class="col-75">
					<input type="text" id="interestgroup" name="interestgroup"
						placeholder="inserisci interestgroup">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>