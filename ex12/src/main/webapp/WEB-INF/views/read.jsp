<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> USER READ </title>
</head>
<body>
<h2> [USER INFO] </h2>
<table border=1>
<tr>
	<td width=100> ID </td>
	<td width=200> <input type="text" name="user_id" value="${vo.user_id }"> </td>
</tr>
<tr>
	<td width=100> NAME </td>
	<td width=200> <input type="text" name="user_name" value="${vo.user_name }"> </td>
</tr>
<tr>
	<td width=100> PASSWORD </td>
	<td width=200> <input type="password" name="user_name" value="${vo.user_password }"> </td>
</tr>
</table>
<input type="button" value="list" onClick="location.href='list'">
</body>
</html>