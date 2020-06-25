<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TagDTO"
    import="it.contrader.dto.DescriptionDTO" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Tag Edit page">
<meta name="author" content="Marco Fellone">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Tag</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp"%>
<br>
<div class="main">

<%TagDTO t = (TagDTO) request.getSession().getAttribute("dto");
List<DescriptionDTO> list_d = (List<DescriptionDTO>) request.getSession().getAttribute("descriptions");%>


<form id="floatleft" action="/tag/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="tag">Tag</label>
    </div>
    <div class="col-75">
      <input type="text" id="tag" name="tag" value=<%=t.getTag()%>>
    </div>
  </div>
  
   <div class="row">
    <div class="col-25">
      <label for="description">Description</label>
    </div>
    <div class="col-75">
     <select id="description" name="description">
 		<%
			for (DescriptionDTO d : list_d) {
		%>
			<option value="<%=d.getId()%>"  <%if(d.getId()==t.getDescription().getId()) {%>selected<%} %>  ><%=d.getDescription()%></option>
		<%
			}
		%>
	</select>
    </div>
  </div> 
  
     <input type="hidden" name="id" value =<%=t.getId() %>>
     <button type="submit" >Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>