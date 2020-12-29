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
<title> LIST </title>
<style>
	table {text-align:center;}
</style>
</head>
<body>
<h1> [LIST] </h1>
<table border=1>
	<tr>
		<td width=70>ACTNO.</td>
		<td width=100>NAME</td>
		<td width=150>OPENDATE</td>
		<td width=100>BALANCE</td>
		<td width=70>ACT LIST</td>
	</tr>
	<c:forEach items="${list }" var="vo">
		<tr>
		<td>${vo.ano }</td>
		<td>${vo.name }</td>
		<td><fmt:formatDate value="${vo.openDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td><fmt:formatNumber value="${vo.balance }" pattern="#,###.##"/> ＄</td>
		<td><button onClick="location.href='read?ano=${vo.ano}'">LIST</button></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>