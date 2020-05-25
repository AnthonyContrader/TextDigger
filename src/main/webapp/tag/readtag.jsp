<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TagDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Tag</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="TagServlet?mode=taglist">Tags</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%TagDTO u = (TagDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Tag</th>
	</tr>
	<tr>
		<td><%=u.getTag()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>