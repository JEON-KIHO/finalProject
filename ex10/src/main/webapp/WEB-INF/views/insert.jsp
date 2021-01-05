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
<title>insert product</title>
<style>
	#fileList img {margin:5px;}
</style>
</head>
<body>
	<h2>[INSERT PRODUCT]</h2>
	<form action="insert" method="post" enctype="multipart/form-data" name="form">
		<table border=1>
			<tr>
				<td width=100> NAME </td>
				<td width=400><input type="text" name="pname" size=45></td>
			</tr>
			<tr>
				<td width=100> PRICE </td>
				<td width=400><input type="text" name="price" size=10> ＄</td>
			</tr>
			<tr>
				<td width=100> IMAGE </td>
				<td width=400>
					<img src="http://placehold.it/150x120" id="image" width=150>
					<input type="file" name="file">
				</td>
			</tr>
			<tr>
				<td width=100 height=130><input type="button" id="btnImage" value="OTHER IMAGE"></td>
				<td width=400>
					<input type="file" name="files" multiple>
					<div id="fileList"></div>
				</td>
			</tr>
		</table>
		<input type="submit" id="btnSubmit" value="save">
		<input type="reset" value="cancel">
		<input type="button" value="list" onClick="location.href='list'">
	</form>
</body>
<script>
	$(form.file).hide();
	$(form.files).hide();
	
	$(form.image).on("click", function() {
		$(form.file).click();
	});
	$("#btnImage").on("click", function() {
		$(form.files).click();
	});
	
	$(form.file).change(function() {
		var file = $(form.file)[0].files[0];
		$("#image").attr("src", URL.createObjectURL(file));
	});
	
	$(form.files).change(function() {
		var files = $(form.files)[0].files;
		var str = "";
		$.each(files, function(index, file) {
			str += "<img src='" + URL.createObjectURL(file) + "' width=150>";
		});
		$("#fileList").html(str);
	});
</script>
</html>