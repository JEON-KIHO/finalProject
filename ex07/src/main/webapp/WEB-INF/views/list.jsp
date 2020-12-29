<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 유저 목록 </title>
</head>
<body>
<h1> [유저 목록] </h1>
<table border=1>
	<tr>
		<td width=100> ID </td>
		<td width=100> PW </td>
		<td width=100> NAME </td>
		<td width=100> POINT </td>
		<td width=100> SEND MSG </td>
		<td width=100> RCV MSG </td>
	</tr>
	<c:forEach items="${list }" var="vo">
		<tr>
		<td width=100> ${vo.user_id } </td>
		<td width=100> ${vo.user_password } </td>
		<td width=100> ${vo.user_name } </td>
		<td width=100> ${vo.point } </td>
		<td width=100> <button onCLick="location.href='send?user_id=${vo.user_id}'">SEND MSG</button> </td>
		<td width=100> <button onClick="location.href='receive?user_id=${vo.user_id}'">RCV MSG</button> </td>
	</tr>
	</c:forEach>
</table>
</body>
</html>