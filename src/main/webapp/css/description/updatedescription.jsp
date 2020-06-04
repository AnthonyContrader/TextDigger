<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DescriptionDTO"%>
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
<%@ include file="../header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a href="/user/logout" id="logout">Logout</a>
  <!-- Manca la mia parte di barra -->
</div>
<br>
<div class="main">

<%DescriptionDTO d = (DescriptionDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/description/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="description">Description</label>
    </div>
    <div class="col-75">
      <input type="text" id="description" name="description" value=<%=d.getDescription()%>>
    </div>
  </div>
     	<input type="hidden" name="id" value =<%=d.getIdDescription() %>>
      <button type="submit" >Edit</button>
</form>

</div>
<br>
<%@ include file="../footer.jsp" %>	
</body>
</html>