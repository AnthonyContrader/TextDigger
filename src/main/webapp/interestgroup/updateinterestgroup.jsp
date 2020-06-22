<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.InterestgroupDTO" 
    import="it.contrader.dto.InterestDTO" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Interestgroup Edit page">
<meta name="author" content="Marco Fellone">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Interest Group</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp"%>
<br>
<div class="main">

<%InterestgroupDTO ig = (InterestgroupDTO) request.getSession().getAttribute("dto");
List<InterestDTO> list_i = (List<InterestDTO>) request.getSession().getAttribute("interests");%>


<form id="floatleft" action="/interestgroup/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="interestgroup">Interest Group</label>
    </div>
    <div class="col-75">
      <input type="text" id="interestgroup" name="interestgroup" value=<%=ig.getInterestgroup()%>>
    </div>
    <input type="hidden" name="id" value =<%=ig.getId() %>>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="interest">Interest</label>
    </div>
    <div class="col-75">
     <select id="tool" name="tool">
 		<%
			for (InterestDTO i : list_i) {
		%>
			<option value="<%=i.getId()%>"  <%if(i.getId()==ig.getInterest().getId()) {%>selected<%} %>  ><%=i.getInterest()%></option>
		<%
			}
		%>
	</select>
    </div>
  </div>
  
  <button type="submit" >Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>