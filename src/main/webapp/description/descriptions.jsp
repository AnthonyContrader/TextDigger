<%@ page import="it.contrader.dto.DescriptionDTO" import="java.util.*" %>
<%@ page import="it.contrader.dto.FolderDTO" import="java.util.*" %>
<%@ page import="it.contrader.dto.LibraryDTO" import="java.util.*" %>
<%@ page import="it.contrader.dto.DocumentDTO" import="java.util.*" %>
<%@ page import="it.contrader.dto.InterestDTO" import="java.util.*" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Description Management">
<meta name="author" content="Marcello Nichele">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Description Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp"%>
<%@ include file="../css/menu.jsp"%>

<br>
	
	<div class="main">
	<%
			List<DescriptionDTO> list = (List<DescriptionDTO>) request.getSession().getAttribute("list");
			List<FolderDTO> folders = (List<FolderDTO>) request.getSession().getAttribute("folders");
			List<LibraryDTO> libraries = (List<LibraryDTO>) request.getSession().getAttribute("libraries");
			List<DocumentDTO> documents = (List<DocumentDTO>) request.getSession().getAttribute("documents");
			List<InterestDTO> interests = (List<InterestDTO>) request.getSession().getAttribute("interests");
	%>
	
	<br>
	
	<table>
		<tr>
			<th>Descriptions</th>
			<th>Folders</th>
			<th>Libraries</th>
			<th>Documents</th>
			<th>Interests</th>
		</tr>
		<%for (DescriptionDTO d : list) {%>
		<tr>
				<td><a href="/description/read?id=<%=d.getId()%>"> 
				<%=d.getDescription()%>
				</a></td>
				<td><%d.getFolder().getId(); d.getFolder().getName();%></td>
				<td><%d.getLibrary().getId();d.getLibrary().getName();%></td>
				<td><%d.getDocument().getId();d.getDocument().getDescription();%></td>
				<td><%d.getInterest().getId();d.getInterest().getInterest();%></td>
				<td><a href="/description/preupdate?id=<%=d.getId()%>">Edit</a></td>


				<td><a href="/description/delete?id=<%=d.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
		<form id="floatright" action="/description/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="description">Description</label>
				</div>
				<div class="col-75">
					<input type="text" id="description" name="description"
						placeholder="insert description">
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
					<label for="library">Library</label>
				</div>
				<div class="col-75">
		 			<select id="library" name="library" required>
		 			<option value="" disabled selected>Select Library</option>
 					<% 			
						for (LibraryDTO l : libraries) {
							%> <option value="<%=l.getId()%>"><%=l.getName()%></option> <%
						}%> 
					</select>
    			</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="document">Document</label>
				</div>
				<div class="col-75">
		 			<select id="document" name="document" required>
		 			<option value="" disabled selected>Select Document</option>
 					<% 			
						for (DocumentDTO d : documents) {
							%> <option value="<%=d.getId()%>"><%=d.getText()%></option> <%
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