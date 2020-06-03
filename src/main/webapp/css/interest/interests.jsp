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
	<%@ include file="../header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a class="active" href="/user/getall">Users</a> 
		<a href="/user/logout" id="logout">Logout</a>
			<!-- Manca la mia parte di barra -->
	</div>
	<div class="main">
		<%
			List<InterestDTO> list = (List<InterestDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Interest</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (InterestDTO i : list) {
			%>
			<tr>
				<td><a href="/interest/read?id=<%=i.getId()%>"> <%=i.getInterest()%></a></td>
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
						placeholder="inserisci interest">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../footer.jsp"%>
</body>
</html>