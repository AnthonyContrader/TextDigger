<%@page import="it.contrader.dto.SubscribeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.FolderDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Interest Edit page">
<meta name="author" content="Marco Fellone">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Interest</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp"%>
<br>
<div class="main">

<%SubscribeDTO c = (SubscribeDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/subscribe/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="id">Name</label>
    </div>
    <div class="col-75">
      <input type="number" id="id" name="id" value=<%=c.getId()%>>
    </div>
  </div>
     	<input type="hidden" name="id" value =<%=c.getId()%>>
     	
      <button type="submit" >Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>