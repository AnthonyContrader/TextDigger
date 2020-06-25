<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.FolderDTO"
    import="java.util.*"%>
<%@page import ="it.contrader.dto.UserDTO" %>
<%@page import="it.contrader.dto.LibraryDTO" %>
<%@page import="it.contrader.dto.DescriptionDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Folder Edit page">
<meta name="author" content="Marcello Nichele">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Interest</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp"%>
<br>
<div class="main">

<%FolderDTO fdto = (FolderDTO) request.getSession().getAttribute("dto");
List<DescriptionDTO> descriptions = (List<DescriptionDTO>) request.getSession().getAttribute("descriptions");
List<LibraryDTO> libraries = (List<LibraryDTO>) request.getSession().getAttribute("libraries");%>


<form id="floatleft" action="/folder/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=fdto.getName()%>>
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
			<option value="<%=desc.getId()%>"  <%if(desc.getId()==fdto.getDescription().getId()) {%>selected<%} %>  ><%=desc.getDescription()%></option>
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
     <select id="library" name="library">
 		<%
			for (LibraryDTO libs : libraries) {
		%>
			<option value="<%=libs.getId()%>"  <%if(libs.getId()==fdto.getLibrary().getId()) {%>selected<%} %>><%=libs.getName()%></option>
		<%
			}
		%>
	</select>
    </div>
  </div>
  
     	<input type="hidden" name="id" value =<%=fdto.getId()%>>
     	
      <button type="submit" >Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>