<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 읽기</title>
</head>
<body>
	<h1>[글 읽기]</h1>
	<form action="update" method="post" name="form">
		<input type="hidden" name="bno" value="${vo.bno }">
		<table border=1>
			<tr>
				<td width=100>TITLE</td>
				<td width=350><input type="text" name="title" value="${vo.title }"></td>
				<td width=100> view : ${vo.viewcnt }</td>
			</tr>
			<tr>
				<td width=100>WRITER</td>
				<td width=450 colspan=2><input type="text" name="writer" value="${vo.writer }"></td>
			</tr>
			<tr>
				<td width=100>CONTENT</td>
				<td width=450 colspan=2><textarea rows="10" cols="60" name="content">${vo.content }</textarea></td>
			</tr>
		</table>
		<input type="submit" value="update">
		<input type="reset" value="cancel">
		<input type="button" value="delete" id="btnDelete">
		<input type="button" value="list" onClick="location.href='list'">
	</form>
	<jsp:include page="reply.jsp"></jsp:include>
</body>
<script>
	$("#btnDelete").on("click", function() {
		if(!confirm("delete????")) return;
		form.action="delete";
		form.submit();
	});

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
			if(!confirm("update??")) return;
			form.submit();
		}
	});
</script>
</html>