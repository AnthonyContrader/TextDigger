<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TagDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Tag</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="TagServlet?mode=taglist">Tags</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%TagDTO t = (TagDTO) request.getAttribute("dto");%>


<form id="floatleft" action="TagServlet?mode=update&id=<%=t.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="tag">Tag</label>
    </div>
    <div class="col-75">
      <input type="text" id="tag" name="tag" value=<%=t.getTag()%>>
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>