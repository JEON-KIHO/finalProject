<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> USER LIST </title>
</head>
<body>
<h2> [USER LIST] </h2>
<a href="insert"> [INSERT INFO] </a>
<c:if test="${user_id == null }">
	<button onCLick="location.href='login'"> LOGIN </button>
</c:if>
<c:if test="${user_id != null }">
	<button onCLick="location.href='logout'"> LOGOUT </button>
	<span> ${user_id }님이 입장 하셨나요? </span>
</c:if>
<table border=1>
	<tr>
		<td width=100> ID </td>
		<td width=100> NAME </td>
	</tr>
	<c:forEach items="${list }" var="vo">
		<tr>
			<td width=100><a href="read?user_id=${vo.user_id }">${vo.user_id }</a></td>
			<td width=100> ${vo.user_name } </td>
		</tr>
	</c:forEach>
</table>
</body>
</html>