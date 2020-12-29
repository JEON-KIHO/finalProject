<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 등록</title>
</head>
<body>
	<h1>[게시판 등록]</h1>
	<form action="insert" method="post" name="form">
		<table border=1>
			<tr>
				<td width=100>TITLE</td>
				<td width=400><input type="text" name="title"></td>
			</tr>
			<tr>
				<td width=100>WRITER</td>
				<td width=400><input type="text" name="writer" value="guest"></td>
			</tr>
			<tr>
				<td width=100>CONTENT</td>
				<td width=400><textarea rows="10" cols="50" name="content"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="upload">
		<input type="reset" value="cancel">
		<input type="button" value="list" onCLick="location.href='list'">
		
		<jsp:include page="../ajaxUpload.jsp"></jsp:include>
	</form>
</body>
<script>
	$(form).submit(function(e) {
		e.preventDefault();
		if($(form.title).val()=="") {
			alert("insert title");
			$(form.title).focus();
		} else if($(form.writer).val()=="") {
			alert("insert writer");
			$(form.writer).focus();
		} else if($(form.content).val()=="") {
			alert("insert content");
			$(form.content).focus();
		} else {
			if(!confirm("upload??")) return;
			form.submit();
		}
	});
</script>
</html>