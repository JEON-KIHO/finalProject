<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 주소수정 </title>
<link rel="stylesheet" href="../resources/home.css">
</head>
<body>
	<h1> [주소수정] </h1>
	<form action="update" method="post" name="form">
	<input type="hidden" name="ano" value="${vo.ano}">
		<table border=1 style="margin-top: 20px;">
			<tr>
				<td width=100>NAME</td>
				<td width=300><input type="text" name="name" size=5 value="${vo.name}" readonly></td>
			</tr>
			<tr>
				<td width=100>TEL</td>
				<td width=300><input type="text" name="tel" size=10 value="${vo.tel}"></td>
			</tr>
			<tr>
				<td width=100>ADDRESS</td>
				<td width=300><input type="text" name="address" size=30 value="${vo.address}"></td>
			</tr>
		</table>
		<input type="submit" value="update">
		<input type="button" value="delete" id="btnDelete">
		<input type="reset" value="cancel">
		<input type="button" value="list" onClick="location.href='list'">
	</form>
</body>
<script src="../resources/home.js"></script>
<script>
	$("#btnDelete").on("click", function() {
		if(!confirm("delete?")) return;
		location.href='delete?ano=${vo.ano}';
	})
</script>
</html>