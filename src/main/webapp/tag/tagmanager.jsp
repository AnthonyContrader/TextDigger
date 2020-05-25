<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.TagDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Tag Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="TagServlet?mode=taglist">Tags</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<TagDTO> list = (List<TagDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Tag</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (TagDTO t : list) {
		%>
		<tr>
			<td><a href=TagServlet?mode=read&id=<%=t.getId()%>>
					<%=t.getTag()%>
			</a></td>
			<td><a href=TagServlet?mode=read&update=true&id=<%=t.getId()%>>Edit</a>
			</td>
			<td><a href=TagServlet?mode=delete&id=<%=t.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="TagServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="tag">Tag</label>
    </div>
    <div class="col-75">
      <input type="text" id="tag" name="tag" placeholder="inserisci tag">
    </div>
  </div>

      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>