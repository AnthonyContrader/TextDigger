<%@ page import="it.contrader.dto.DocumentDTO" import="java.util.*"%>
<%@page import ="it.contrader.dto.UserDTO" %>
<%@page import="it.contrader.dto.FolderDTO" %>
<%@page import="it.contrader.dto.DescriptionDTO" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Document Management">
<meta name="author" content="Marcello Nichele">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Document Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp"%>
<%@ include file="../css/menu.jsp"%>
	
	<br>
	
	<div class="main">
	<%
			List<DocumentDTO> list = (List<DocumentDTO>) request.getSession().getAttribute("list");
			List<UserDTO> users = (List<UserDTO>) request.getSession().getAttribute("users");
			List<FolderDTO> folders = (List<FolderDTO>) request.getSession().getAttribute("folders");
			List<DescriptionDTO> descriptions = (List<DescriptionDTO>) request.getSession().getAttribute("descriptions");
	%>
	
	<br>
	
	<table>
		<tr>
			<th>Documents</th>
			<th>Users</th>
			<th>Folders</th>
			<th>Description</th>
			<th></th>
			<th></th>
		</tr>
		<%for (DocumentDTO d : list) {%>
		<tr>
				<td><a href="/document/read?id=<%=d.getId()%>"> 
				<%=d.getText()%>
				</a></td>
				<td><%=d.getUser().getUsername()%></td>
				<td><%=d.getFolder().getName()%></td>
				<td><%=d.getDescription().getDescription()%></td>
				<td><a href="/document/preupdate?id=<%=d.getId()%>">Edit</a></td>
				<td><a href="/document/delete?id=<%=d.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
		<form id="floatright" action="/document/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="text">Text</label>
				</div>
				<div class="col-75">
					<input type="text" id="text" name="text"
						placeholder="insert text">
				</div>
			</div>
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
					<label for="folder">Folder</label>
				</div>
				<div class="col-75">
		 			<select id="folder" name="folder" required>
		 			<option value="" disabled selected>Select Folder</option>
 					<% 			
						for (FolderDTO fdto : folders) {
							%> <option value="<%=fdto.getId()%>"><%=fdto.getName()%></option> <%
						}%> 
					</select>
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
			<button type="submit">Insert</button>
			
		</form>
	</div>

	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>