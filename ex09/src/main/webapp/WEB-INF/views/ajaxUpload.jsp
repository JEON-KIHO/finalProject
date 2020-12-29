<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> file upload </title>
<style>
	a {text-decoration:none};
</style>
</head>
<body>
<h1> [file upload (ajax)] </h1>
<div id="upload">
	<input type="file" id="file">
</div>
<hr>
<div id="uploaded">
	<ul id="uploadFiles"></ul>
</div>
</body>
<script>
	$("#file").on("change", function() {
		var file = $("#file")[0].files[0];
		if(file==null) return;
		
		var formData = new FormData();
		formData.append("file", file);
		
		$.ajax({
			type:"post",
			url:"/uploadFile",
			processData:false,
			contentType:false,
			data:formData,
			success:function(data) {
				var str = "<li><img src=/displayFile?fileName=" + data + " width=100 />" + "<input type=text name='files' value='" + data + "'>" + " <a href='" + data + "'>delete</a></li>";
				$("#uploadFiles").append(str);
			}
		});
	});
	
	// delete upload file
	$("#uploadFiles").on("click", "a", function(e) {
		e.preventDefault();
		var fileName=$(this).attr("href");
		var li = $(this).parent();
		$.ajax({
			type:"post",
			url:"/deleteFile",
			data:{"fileName":fileName},
			success:function() {
				li.remove();
			}
		});
	});
</script>
</html>