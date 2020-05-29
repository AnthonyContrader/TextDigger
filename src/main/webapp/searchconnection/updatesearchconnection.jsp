<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "it.contrader.dto.SearchConnectionDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit SearchConnection</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="SearchConnectionServlet?mode=searchconnectionlist">SearchConnections</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%SearchConnectionDTO a = (SearchConnectionDTO) request.getAttribute("SearchConnectionDto");%>


<form id="floatleft" action="SearchConnectionServlet?mode=update&id= <%=a.getIdTag()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="tag">Tag</label>
    </div>
    <div class="col-75">
      <input type="text" id="tag" name="idTag" value=<%=a.getIdTag()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="doc">Document</label>
    </div>
    <div class="col-75">
      <input type="text" id="doc" name="idDocument" value=<%=a.getIdDocument()%>>
    </div>
  </div>
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	

</body>
</html>