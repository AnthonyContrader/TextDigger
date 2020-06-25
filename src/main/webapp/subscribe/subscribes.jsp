<%@page import="it.contrader.dto.SubscribeDTO" import="java.util.*"%>
<%@page import="it.contrader.dto.UserDTO" import="java.util.*"%>
<%@page import="it.contrader.dto.InterestgroupDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Subscribe Management">
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
			List<UserDTO> users = (List<UserDTO>) request.getSession().getAttribute("users");
			List<InterestgroupDTO> interestgroups = (List<InterestgroupDTO>) request.getSession().getAttribute("interestgroups");
		%>

		<br>

		<table>
			<tr>
				<th>Subscribe</th>
				<th>User</th>
				<th>InterestGroup</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (SubscribeDTO b : list) {
			%>
			<tr>
				<td><a href="/subscribe/read?id=<%=b.getId()%>"></a></td>
				<td><%=b.getUser().getUsername() %></td>
				<td><%=b.getInterestgroup().getInterestgroup()%></td>
				<td><a href="/subscribe/preupdate?id=<%=b.getId()%>">Edit</a></td>		
				<td><a href="/subscribe/delete?id=<%=b.getId()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
 
		<form id="floatright" action="/subscribe/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">User</label>
				</div>
				<div class="col-75">
		 			<select id="user" name="user" required>
		 			<option value="" disabled selected>Select User</option>
 					<% 			
						for (UserDTO u : users) {
							%> <option value="<%=u.getId()%>"><%=u.getUsername()%></option> <%
						}%> 
					</select>
    			</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="interestgroup">Interestgroup</label>
				</div>
				<div class="col-75">
		 			<select id="interestgroup" name="interestgroup" required>
		 			<option value="" disabled selected>Select InterestGroup</option>
 					<% 			
						for (InterestgroupDTO g : interestgroups) {
							%> <option value="<%=g.getId()%>"><%=g.getInterestgroup()%></option> <%
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