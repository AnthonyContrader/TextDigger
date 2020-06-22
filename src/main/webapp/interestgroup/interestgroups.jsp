<%@ page import="it.contrader.dto.InterestgroupDTO" import="java.util.*"%>
<%@ page import="it.contrader.dto.InterestDTO" import="java.util.*" %>
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
			List<InterestDTO> interests = (List<InterestDTO>) request.getSession().getAttribute("interests");
		%>

		<br>

		<table>
			<tr>
				<th>Interest Groups</th>
				<th>Interests</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (InterestgroupDTO ig : list) {
			%>
			<tr>
				<td><a href="/interestgroup/read?id=<%=ig.getId()%>"> <%=ig.getInterestgroup()%></a></td>
				<td><%ig.getInterest().getInterest();%></td>
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
						placeholder="insert interest group">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="interest">Interest</label>
				</div>
				<div class="col-75">
		 			<select id="interest" name="interest" required>
		 			<option value="" disabled selected>Select Interest</option>
 					<% 			
						for (InterestDTO i : interests) {
							%> <option value="<%=i.getId()%>"><%=i.getInterest()%></option> <%
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