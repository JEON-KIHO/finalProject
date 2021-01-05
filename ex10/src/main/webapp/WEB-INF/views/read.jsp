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
<title>information product</title>
<style>
	#fileList img {margin:5px;}
</style>
</head>
<body>
	<h2>[READ PRODUCT]</h2>
	<form action="update" method="post" enctype="multipart/form-data" name="form">
		<input type="hidden" name="pcode" value="${vo.pcode }">
		<input type="hidden" name="image" value="${vo.image }">
		<table border=1>
			<tr>
				<td width=100> NAME </td>
				<td width=400><input type="text" name="pname" size=45 value="${vo.pname }"></td>
			</tr>
			<tr>
				<td width=100> PRICE </td>
				<td width=400><input type="text" name="price" size=10 value="${vo.price }"> ＄</td>
			</tr>
			<tr>
				<td width=100> IMAGE </td>
				<td width=400>
					<img src="display?fileName=${vo.image }" id="image" width=150>
					<input type="file" name="file">
				</td>
			</tr>
			<tr>
				<td width=100 height=130><input type="button" id="btnImage" value="OTHER IMAGE"></td>
				<td width=400>
					<input type="file" name="files" multiple>
					<div id="fileList">
						<c:forEach items="${images }" var="image">
							<img src="display?fileName=attach/${image }" width=150>
						</c:forEach>
					</div>
				</td>
			</tr>
		</table>
		<input type="submit" id="btnSubmit" value="update">
		<input type="reset" value="cancel">
		<input type="button" value="delete" id="btnDelete">
		<input type="button" value="list" onClick="location.href='list'">
	</form>
</body>
<script>
	var pcode = "${vo.pcode}";

	$(form.file).hide();
	$(form.files).hide();
	
	$("#image").on("click", function() {
		$(form.file).click();
	});
	$("#btnImage").on("click", function() {
		$(form.files).click();
	});
	
	$(form.file).on("change", function() {
		var file = $(form.file)[0].files[0];
		$("#image").attr("src", URL.createObjectURL(file));
	});
	
	$(form.files).on("change", function() {
		var files = $(form.files)[0].files;
		var str = "";
		$.each(files, function(index, file) {
			str += "<img src='" + URL.createObjectURL(file) + "' width=150>";
		});
		$("#fileList").html(str);
	});
	
	$(form).submit(function(e) {
		e.preventDefault();
		if(!confirm("update???")) return;
		form.submit();
	});
	
	$("#btnDelete").on("click", function() {
		if(!confirm(pcode + " delete??")) return;
		form.action="delete";
		form.method="post";
		form.submit();
	});
</script>
</html>