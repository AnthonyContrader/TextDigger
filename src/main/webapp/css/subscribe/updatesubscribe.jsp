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
<%@ include file="../header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a href="/user/logout" id="logout">Logout</a>
  <!-- Manca la mia parte di barra -->
</div>
<br>
<div class="main">

<%SubscribeDTO c = (SubscribeDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/interest/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=c.getName()%>>
    </div>
  </div>
     	<input type="hidden" name="idSubscribe" value =<%=c.getIdSubscribe()%>>
     	
      <button type="submit" >Edit</button>
</form>
</div>
<br>
<%@ include file="../footer.jsp" %>	
</body>
</html>