<%@page import="it.contrader.dto.LibraryDTO"%>
<%@page import="java.util.*"%>
<%@page import="it.contrader.dto.InterestDTO" %>
<%@page import="it.contrader.dto.DescriptionDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Library Management">
<meta name="author" content="Marcello Nichele">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Library Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>
	<br>
	<div class="main">
		<%
			List<LibraryDTO> list = (List<LibraryDTO>) request.getSession().getAttribute("list");
			List<DescriptionDTO> descriptions = (List<DescriptionDTO>) request.getSession().getAttribute("descriptions");
			List<InterestDTO> interests = (List<InterestDTO>) request.getSession().getAttribute("interests");
		%>

		<br>

		<table>
			<tr>
				<th>Libraries</th>
				<th>Descriptions</th>
				<th>Interests</th>
			</tr>
			<%
				for (LibraryDTO l : list) {
			%>
			<tr>
				<td><a href="/library/read?id=<%=l.getId()%>"> <%=l.getName()%></a></td>
				<td><%=l.getDescription().getId()%> <%=l.getDescription().getDescription()%></td>
				<td><%=l.getInterest().getId()%> <%=l.getInterest().getInterest()%></td>
				<td><a href="/library/preupdate?id=<%=l.getId()%>">Edit</a></td>
				<td><a href="/library/delete?id=<%=l.getId()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>

		<form id="floatright" action="/library/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="name">Library Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="name" name="name"
						placeholder="insert library name">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="description">Description</label>
				</div>
				<div class="col-75">
		 			<select id="description" name="description" required>
		 			<option value="" disabled selected>Select Description</option>
 					<% 			
						for (DescriptionDTO dto: descriptions) {
							%> <option value="<%=dto.getId()%>"><%=dto.getDescription()%></option> <%
						}%> 
					</select>
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
						for (InterestDTO dto: interests) {
							%> <option value="<%=dto.getId()%>"><%=dto.getInterest()%></option> <%
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