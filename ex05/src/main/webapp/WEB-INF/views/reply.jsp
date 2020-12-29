<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 댓글 목록 </title>
</head>
<body>
<h1> [댓글 목록] </h1>
<div id="divInsert">
	<input type="text" id="txtReply" size=50>
	<input type="button" id="btnReply" value="upload">
</div>
<div id="divReply"></div>
	<script id="temp" type="text/x-handlebars-template">
		{{#each .}}
			<div>
				[{{rno}}]: {{reply}}
				<div>{{replyer}} | {{replyDate}}</div>
				<button rno="{{rno}}"> delete </button>
			</div>
		{{/each}}
	</script>
</body>
<script>
	var page=1;
	var bno=320;
	
	getList();
	
	$("#divReply").on("click", "button", function() {
		var rno = $(this).attr("rno");
		if(!confirm(rno + " delete???")) return;
		$.ajax({
			type:"post",
			url:"/reply/delete",
			data:{"rno":rno},
			success:function() {
				getList();
			}
		})
	});
	
	function getList() {
		$.ajax({
			type:"get",
			url:"/reply/list",
			data:{"page":page, "bno":bno},
			dataType:"json",
			success:function(data) {
				var temp = Handlebars.compile($("#temp").html());
				 $("#divReply").html(temp(data));
			}
		});
	}
	
	$("#txtReply").keydown(function(key) {
		var reply = $("#txtReply").val();
		if(key.keyCode==13) {
			if(reply=="") {
				alert("insert please");
				return;
			}
			
			if(!confirm("upload?")) return;
			$.ajax({
				type:"post",
				url:"/reply/insert",
				data:{"bno":bno, "reply":reply, "replyer":"guest01"},
				success:function(){
					$("#txtReply").val("");
					getList();
				}
			});
		}
	});
</script>
</html>