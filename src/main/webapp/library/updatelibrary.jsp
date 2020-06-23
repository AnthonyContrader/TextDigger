<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.LibraryDTO"
    import="java.util.*" import="it.contrader.dto.DescriptionDTO"
    import="it.contrader.dto.InterestDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Library Edit page">
<meta name="author" content="Marcello Nichele">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Interest</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp"%>
<br>
<div class="main">

<%LibraryDTO l = (LibraryDTO) request.getSession().getAttribute("dto");
  List<DescriptionDTO> descriptions = (List<DescriptionDTO>) request.getSession().getAttribute("descriptions");
  List<InterestDTO> interests = (List<InterestDTO>) request.getSession().getAttribute("interests");%>


<form id="floatleft" action="/library/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=l.getName()%>>
    </div>
  </div>
  
  <div class="row">
		<div class="col-25">
			<label for="description">Description</label>
				</div>
				<div class="col-75">
		 			<select id="description" name="description" required>
		 			<option value="" disabled selected>Select Description</option>
 					<% 			
						for (DescriptionDTO dto: descriptions) {
							%> <option value="<%=dto.getId()%>"><%=dto.getDescription()%></option> <%
						}%> 
					</select>
    			</div>
   </div>
			
			<div class="row">
				<div class="col-25">
					<label for="interest">Interest</label>
				</div>
				<div class="col-75">
		 			<select id="interest" name="interest" required>
		 			<option value="" disabled selected>Select Interest</option>
 					<% 			
						for (InterestDTO dto: interests) {
							%> <option value="<%=dto.getId()%>"><%=dto.getInterest()%></option> <%
						}%> 
					</select>
    			</div>
			</div>
     	<input type="hidden" name="id" value =<%=l.getId() %>>
     	
      <button type="submit" >Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>