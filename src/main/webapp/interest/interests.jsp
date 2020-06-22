<%@ page import="it.contrader.dto.InterestDTO" import="java.util.*"%>
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
	<%@ include file="../css/menu.jsp"%>
	
	<br>

	<div class="main">
		<%
			List<InterestDTO> list = (List<InterestDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Interests</th>
				<th>Interest Groups</th>
				<th>Libraries</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (InterestDTO i : list) {
			%>
			<tr>
				<td><a href="/interest/read?id=<%=i.getId()%>"> <%=i.getInterest()%> <%=i.getInterestGroups()%> <%i.getLibraries();%></a></td>
				<td><a href="/interest/preupdate?id=<%=i.getId()%>">Edit</a></td>
				<td><a href="/interest/delete?id=<%=i.getId()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>

		<form id="floatright" action="/interest/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="interest">Interest</label>
				</div>
				<div class="col-75">
					<input type="text" id="interest" name="interest"
						placeholder="insert interest">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>