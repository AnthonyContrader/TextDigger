<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DescriptionDTO"
 import="it.contrader.dto.FolderDTO" 
 import="it.contrader.dto.LibraryDTO" 
 import="it.contrader.dto.DocumentDTO"
 import="it.contrader.dto.InterestDTO"
 import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Description Edit page">
<meta name="author" content="Marcello Nichele">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Tag</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp"%>

<br>
<div class="main">

<%DescriptionDTO d = (DescriptionDTO) request.getSession().getAttribute("dto");
List<FolderDTO> f = (List<FolderDTO>) request.getSession().getAttribute("folders");
List<LibraryDTO> l = (List<LibraryDTO>) request.getSession().getAttribute("libraries");
List<DocumentDTO> documents = (List<DocumentDTO>) request.getSession().getAttribute("documents");
List<InterestDTO> list_i = (List<InterestDTO>) request.getSession().getAttribute("interests");%>


<form id="floatleft" action="/description/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="description">Description</label>
    </div>
    <div class="col-75">
      <input type="text" id="description" name="description" value=<%=d.getDescription()%>>
    </div>
  </div>
     	<input type="hidden" name="id" value =<%=d.getId() %>>
      <button type="submit" >Edit</button>
</form>

  <div class="row">
    <div class="col-25">
      <label for="folder">Folder</label>
    </div>
    <div class="col-75">
     <select id="tool" name="tool">
 		<%
			for (FolderDTO folder : f) {
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
      <label for="library">Library</label>
    </div>
    <div class="col-75">
     <select id="tool" name="tool">
 		<%
			for (LibraryDTO libraries : l) {
		%>
			<option value="<%=libraries.getId()%>"  <%if(libraries.getId()==d.getLibrary().getId()) {%>selected<%} %>  ><%=libraries.getName()%></option>
		<%
			}
		%>
	</select>
    </div>
  </div>
  
  
  <div class="row">
    <div class="col-25">
      <label for="document">Document</label>
    </div>
    <div class="col-75">
     <select id="tool" name="tool">
 		<%
			for (DocumentDTO docs  : documents) {
		%>
			<option value="<%=docs.getId()%>"  <%if(docs.getId()==d.getDocument().getId()) {%>selected<%} %>  ><%=docs.getText()%></option>
		<%
			}
		%>
	</select>
    </div>
  </div>
  
  
  <div class="row">
    <div class="col-25">
      <label for="interest">Interest</label>
    </div>
    <div class="col-75">
     <select id="tool" name="tool">
 		<%
			for (InterestDTO i : list_i) {
		%>
			<option value="<%=i.getId()%>"  <%if(i.getId()==d.getInterest().getId()) {%>selected<%} %>  ><%=i.getInterest()%></option>
		<%
			}
		%>
	</select>
    </div>
  </div>

</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>