<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DocumentDTO"
    import="java.util.*"%>
<%@page import ="it.contrader.dto.UserDTO" %>
<%@page import="it.contrader.dto.FolderDTO" %>
<%@page import="it.contrader.dto.DescriptionDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Document Edit page">
<meta name="author" content="Marcello Nichele">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Tag</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp"%>

<br>
<div class="main">

<%DocumentDTO d = (DocumentDTO) request.getSession().getAttribute("dto");
List<UserDTO> users = (List<UserDTO>) request.getSession().getAttribute("users");
List<FolderDTO> folders = (List<FolderDTO>) request.getSession().getAttribute("folders");
List<DescriptionDTO> descriptions = (List<DescriptionDTO>) request.getSession().getAttribute("descriptions");%>


<form id="floatleft" action="/document/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="text">Text</label>
    </div>
    <div class="col-75">
      <input type="text" id="text" name="text" value=<%=d.getText()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="user">User</label>
    </div>
    <div class="col-75">
     <select id="user" name="user">
 		<%
			for (UserDTO user : users) {
		%>
			<option value="<%=user.getId()%>"  <%if(user.getId()==d.getUser().getId()) {%>selected<%} %>  ><%=user.getUsername()%></option>
		<%
			}
		%>
	</select>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="folder">Folder</label>
    </div>
    <div class="col-75">
     <select id="folder" name="folder">
 		<%
			for (FolderDTO folder : folders) {
		%>
			<option value="<%=folder.getId()%>"  <%if(folder.getId()==d.getFolder().getId()) {%>selected<%} %>  ><%=folder.getName()%></option>
		<%
			}
		%>
	</select>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="description">Description</label>
    </div>
    <div class="col-75">
     <select id="description" name="description">
 		<%
			for (DescriptionDTO desc : descriptions) {
		%>
			<option value="<%=desc.getId()%>"  <%if(desc.getId()==d.getDescription().getId()) {%>selected<%} %>  ><%=desc.getDescription()%></option>
		<%
			}
		%>
	</select>
    </div>
  </div>
     	<input type="hidden" name="id" value =<%=d.getId() %>>
      <button type="submit" >Edit</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>