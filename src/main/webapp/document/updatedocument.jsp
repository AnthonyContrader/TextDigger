<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DocumentDTO"%>
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

<%DocumentDTO d = (DocumentDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/document/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="text">Text</label>
    </div>
    <div class="col-75">
      <input type="text" id="text" name="text" value=<%=d.getText()%>>
    </div>
  </div>
     	<input type="hidden" name="id" value =<%=d.getIdDocument() %>>
      <button type="submit" >Edit</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>