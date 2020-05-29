<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DocumentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Document</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="DocumentServlet?mode=documentlist">Documents</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%DocumentDTO d = (DocumentDTO) request.getAttribute("documentDTO");%>


<form id="floatleft" action="DocumentServlet?mode=update&id=<%=d.getIdDocument()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="text">Text</label>
    </div>
    <div class="col-75">
      <input type="text" id="text" name="text" value=<%=d.getText()%>>
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	

</body>
</html>