<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.InterestDTO"%>
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
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a href="/user/logout" id="logout">Logout</a>
  <!-- Manca la mia parte di barra -->
</div>
<br>
<div class="main">

<%InterestDTO i = (InterestDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/interest/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="interest">Interest</label>
    </div>
    <div class="col-75">
      <input type="text" id="interest" name="interest" value=<%=i.getInterest()%>>
    </div>
  </div>
     	<input type="hidden" name="id" value =<%=i.getId() %>>
     	
      <button type="submit" >Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>