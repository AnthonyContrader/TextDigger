<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.InterestgroupDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Interestgroup Read">
<meta name="author" content="Marco Fellone">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Interest Group</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>
	<br>

	<div class="main">
		<%
		InterestgroupDTO ig = (InterestgroupDTO) request.getSession().getAttribute("dto");
		%>

		<table>
			<tr>
				<th>ID</th>
				<th>Interest Group</th>
			</tr>
			<tr>
				<td><%=ig.getId()%></td>
				<td><%=ig.getInterestgroup()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>

	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>