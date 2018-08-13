<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
	<h1>My Recipe</h1>
</div>
<div>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<td>#</td>
				<td>Name</td>
				<td>Description</td>
			</tr>
		</thead>
			<c:forEach items="${recipes}" var="r">
				<tr>
					<td><c:out value="${r.getId()}"></c:out></td>
					<td><c:out value="${r.getName()}"></c:out></td>
					<td><c:out value="${r.getDescription()}"></c:out></td>
				</tr>
			</c:forEach>
	</table>
</div>
</body>
</html>