<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SearchConnectionDTO"
    import="java.util.*"%>
<%@page import ="it.contrader.dto.DocumentDTO" %>
<%@page import="it.contrader.dto.TagDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="SearchConnection Edit page">
<meta name="author" content="Vittorio Esposito">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit SearchConnection</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp"%>

<br>
<div class="main">

<%SearchConnectionDTO s = (SearchConnectionDTO) request.getSession().getAttribute("dto");
List<DocumentDTO> documents = (List<DocumentDTO>) request.getSession().getAttribute("documents");
List<TagDTO> tags = (List<TagDTO>) request.getSession().getAttribute("tags");
%>


<form id="floatleft" action="/searchconnection/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="document">Document</label>
    </div>
    <div class="col-75">
     <select id="document" name="document">
 		<%
			for (DocumentDTO document : documents) {
		%>
			<option value="<%=document.getId()%>"  <%if(document.getId()==s.getDocument().getId()) {%>selected<%} %>  ><%=document.getText()%></option>
		<%
			}
		%>
	</select>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="tag">Tag</label>
    </div>
    <div class="col-75">
     <select id="tag" name="tag">
 		<%
			for (TagDTO tag : tags) {
		%>
			<option value="<%=tag.getId()%>"  <%if(tag.getId()==s.getTag().getId()) {%>selected<%} %>  ><%=tag.getTag()%></option>
		<%
			}
		%>
	</select>
    </div>
  </div>
       	<input type="hidden" name="id" value =<%=s.getId() %>>
      <button type="submit" >Edit</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>