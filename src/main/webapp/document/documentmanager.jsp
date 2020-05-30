<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.List"
    import = "it.contrader.dto.DocumentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Document Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="DocumentServlet?mode=documentlist">Documents</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<% 
	List<DocumentDTO> list = (List<DocumentDTO>) request.getAttribute("list"); 
	%>
<br>

   <table>
		<tr>
			<th>Document</th>
			<th></th>
			<th></th>
		</tr>
    <%
    for(DocumentDTO d : list){
    %>
    	<tr>
			<td><a href=DocumentServlet?mode=read&id=<%=d.getIdDocument()%>>
					<%=d.getText()%>
			</a></td>
			<td><a href=DocumentServlet?mode=read&update=true&id=<%=d.getIdDocument()%>>Edit</a>
			</td>
			<td><a href=DocumentServlet?mode=delete&id=<%=d.getIdDocument()%>>Delete</a>
			</td>

		</tr>
   		 <%
			}
		%>
    
    </table>

<form id="floatright" action="DocumentServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="text">Document Text</label>
    </div>
    <div class="col-75">
      <input type="text" id="text" name="text" placeholder="Inserisci Text">
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>