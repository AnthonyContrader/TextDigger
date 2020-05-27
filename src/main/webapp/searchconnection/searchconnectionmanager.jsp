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
  <a class="active" href="SearchConnectionServlet?mode=SearchConnectionlist">SearchConnections</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<% 
	List<SearchConnectionDTO> list = (List<SearchConnectionDTO>) request.getAttribute("list"); 
	%>
	<br>

   <table>
		<tr>
			<th>SearchConnection</th>
			<th></th>
			<th></th>
		</tr>
    <%
    for(SearchConnectionDTO s : list){
    %>
    	<tr>
			<td><a href=SearchConnectionServlet?mode=read&id=<%=s.getIdTag()%>>
			</a></td>
			<td><a href=SearchConnectionServlet?mode=read&update=true&id=<%=s.getIdDocument()%>
			     <%=s.getIdTag()%>>Edit</a></td>
			<td><a href=SearchConnectionServlet?mode=delete&id=<%=s.getIdTag()%>>Delete</a>
			</td>

		</tr>
   		 <%
			}
		%>
    
    </table>

<form id="floatright" action="DocumentServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="tag">SearchConnection</label>
    </div>
    <div class="col-75">
      <input type="number" id="idDocument" name="idDocument" placeholder="inserisci idDocument">
    </div>
  </div>

      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>