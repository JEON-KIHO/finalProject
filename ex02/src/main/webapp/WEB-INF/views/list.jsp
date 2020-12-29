<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 주소 목록 </title>
<link rel="stylesheet" href="../resources/home.css">
</head>
<body>
	<h1> [주소목록] </h1>
	<a href="insert"> [주소등록] </a>
	<table border=1>
		<tr>
			<td width=50> NO. </td>
			<td width=100> NAME </td>
			<td width=150> TEL </td>
			<td width=250> ADDRESS </td>
		</tr>
		<c:forEach items="${list }" var="vo">
			<tr>
				<td>${vo.ano }</td>
				<td><a href="read?ano=${vo.ano }">${vo.name }</a></td>
				<td>${vo.tel }</td>
				<td>${vo.address }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>