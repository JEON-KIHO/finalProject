<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> USER INSERT </title>
</head>
<body>
<h2> [USER INSERT] </h2>
<form name="form" action="insert" method="post">
<table border=1>
<tr>
	<td width=100> ID </td>
	<td width=200> <input type="text" name="user_id"> </td>
</tr>
<tr>
	<td width=100> NAME </td>
	<td width=200> <input type="text" name="user_name"> </td>
</tr>
<tr>
	<td width=100> PASSWORD </td>
	<td width=200> <input type="password" name="user_name"> </td>
</tr>
</table>
</form>
<input type="button" value="list" onClick="location.href='list'">
</body>
</html>