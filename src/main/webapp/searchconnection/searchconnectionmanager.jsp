<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.List" import = " it.contrader.dto.SearchConnectionDTO" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>SearchConnection Manager</title>
</head>

<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="SearchConnectionServlet?mode=searchconnectionlist">SearchConnections</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<% 
	List<SearchConnectionDTO> list = (List<SearchConnectionDTO>) request.getAttribute("list"); 
	%>
	<br>

   <table>
		<tr>
			<th>IdDoc</th>
			<th>IdTag</th>
			<th></th>
			<th></th>
		</tr>
    <%
    for(SearchConnectionDTO s : list){
    %>
    	<tr>
			<td><a href=SearchConnectionServlet?mode=read&id=<%=s.getIdTag()%>>
			<%=s.getIdDocument()%>
			</a></td>
			<td><%=s.getIdTag()%></td>
			<td><a href=SearchConnectionServlet?mode=read&update=true&id=<%=s.getIdDocument()%>
			     <%=s.getIdTag()%>>Edit</a></td>
			<td><a href=SearchConnectionServlet?mode=delete&id=<%=s.getIdTag()%>>Delete</a>
			</td>

		</tr>
   		 <%
			}
		%>
    
    </table>

<form id="floatright" action="SearchConnectionServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="tag">IdTag</label>
    </div>
    <div class="col-75">
      <input type="text" id="tag" name="idTag" placeholder="inserisci idTag">
       </div>
       </div>
        <div class="row">
    <div class="col-25">
      <label for="doc">IdDocument</label>
    </div>
       <div class="col-75">
      <input type="text" id="doc" name="idDocument" placeholder="inserisci idDocument">
    </div>
  </div>

      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>