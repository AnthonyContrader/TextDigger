<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SubscribeDTO"
    import="java.util.*"%>
<%@page import ="it.contrader.dto.UserDTO" %>
<%@page import="it.contrader.dto.InterestgroupDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Subscribe Edit page">
<meta name="author" content="Vittorio Esposito">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Subscribe</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp"%>

<br>
<div class="main">

<%SubscribeDTO d = (SubscribeDTO) request.getSession().getAttribute("dto");
List<UserDTO> users = (List<UserDTO>) request.getSession().getAttribute("users");
List<InterestgroupDTO> Interestgroups = (List<InterestgroupDTO>) request.getSession().getAttribute("Interestgroups");
%>


<form id="floatleft" action="/subscribe/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="text">Text</label>
    </div>
    <div class="col-75">
      <input type="text" id="text" name="text" value=<%=d.getText()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="user">User</label>
    </div>
    <div class="col-75">
     <select id="tool" name="tool">
 		<%
			for (UserDTO user : users) {
		%>
			<option value="<%=user.getId()%>"  <%if(user.getId()==d.getUser().getId()) {%>selected<%} %>  ><%=user.getUsername()%></option>
		<%
			}
		%>
	</select>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="interestgroup">Interestgroup</label>
    </div>
    <div class="col-75">
     <select id="tool" name="tool">
 		<%
			for (InterestgroupDTO Interestgroup : Interestgroups) {
		%>
			<option value="<%=Interestgroup.getId()%>"  <%if(Interestgroup.getId()==d.getInterestgroup().getId()) {%>selected<%} %>  ><%=Interestgroup.getInterestgroup()%></option>
		<%
			}
		%>
	</select>
    </div>
  </div>
       	<input type="hidden" name="id" value =<%=d.getId() %>>
      <button type="submit" >Edit</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>