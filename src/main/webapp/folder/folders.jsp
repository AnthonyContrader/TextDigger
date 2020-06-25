<%@ page import="it.contrader.dto.FolderDTO" import="java.util.*"%>
<%@page import="it.contrader.dto.LibraryDTO" %>
<%@page import="it.contrader.dto.DescriptionDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Folder Management">
<meta name="author" content="Marcello Nichele">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Folder Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>
	
	<br>
	
	<div class="main">
		<%
			List<FolderDTO> list = (List<FolderDTO>) request.getSession().getAttribute("list");
			List<DescriptionDTO> descriptions = (List<DescriptionDTO>) request.getSession().getAttribute("descriptions");
			List<LibraryDTO> libraries = (List<LibraryDTO>) request.getSession().getAttribute("libraries");
		%>

		<br>

		<table>
			<tr>
				<th>Folders</th>
				<th>Descriptions</th>
				<th>Libraries</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (FolderDTO fdto : list) {
			%>
			<tr>
				<td><a href="/folder/read?id=<%=fdto.getId()%>"> <%=fdto.getName()%>
				</a></td>
				<td><%=fdto.getDescription().getDescription()%></td>
				<td><%=fdto.getLibrary().getName()%></td>
				<td><a href="/folder/preupdate?id=<%=fdto.getId()%>">Edit</a></td>
				<td><a href="/folder/delete?id=<%=fdto.getId()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>

		<form id="floatright" action="/folder/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="name">Folder</label>
				</div>
				<div class="col-75">
					<input type="text" id="name" name="name"
						placeholder="insert folder name">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="description">Description</label>
				</div>
				<div class="col-75">
		 			<select id="description" name="description" >
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
					<label for="library">Library</label>
				</div>
				<div class="col-75">
		 			<select id="library" name="library" >
		 			<option value="" disabled selected>Select Library</option>
 					<% 			
						for (LibraryDTO dto: libraries) {
							%> <option value="<%=dto.getId()%>"><%=dto.getName()%></option> <%
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