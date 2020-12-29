<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>받은 메세지</title>
<style>
	.unread {color:red;}
	.read {color:blue;}
	a {text-decoration:none;}
</style>
</head>
<body>
	<h1>[받은 메세지]</h1>
	<table border=1>
		<tr>
			<td width=100>RECEIVER</td>
			<td width=150>${vo.user_name }</td>
			<td width=60>POINT</td>
			<td width=100><span id="point">${vo.point }</span></td>
		</tr>
	</table>
	<table border=1 style="margin-top: 50px;" id="tbl"></table>
	<script id="temp" type="text/x-handlebars-template">
		<tr>
			<td width=150> SENDER </td>
			<td width=300> TEXT </td>
			<td width=150> SEND DATE </td>
			<td width=50> READ </td>
		</tr>
		{{#each .}}
			<tr class="row">
				<td> {{sender}}-{{user_name}} </td>
				<td> {{message}} </td>
				<td> {{sendDate}} </td>
				<td> <button class="{{confirm readDate}}" mno = "{{mno}}"> READ </button> </td>
			</tr>
		{{/each}}
	</script>
	<script>
		Handlebars.registerHelper("confirm", function(readDate) {
			if (!readDate)
				return "unread";
			else
				return "read";
		});
	</script>
<input type="button" value="list" onClick="location.href='list'">

<div id="divRead" style="width:700px; background:gray; color:white; margin-top:30px; padding:10px;">
	SENDER : <span id = "sender"></span><br>
	TEXT : <span id = "message"></span><br>
	SEND DATE : <span id = "sendDate"></span><br>
	READ DATE : <span id = "readDate"></span>
</div>
</body>
<script>

	var receiver = "${vo.user_id}";

	getList();

	function getList() {
		$.ajax({
			type : "get",
			url : "receiveList",
			data : { "receiver" : receiver },
			success : function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#tbl").html(temp(data));
			}
		});
	}
	
	function getUser() {
		$.ajax({
			type:"get",
			url:"read",
			data:{"user_id":receiver},
			success:function(data) {
				$("#point").html(data.point);
			}
		});
	}
	
	$("#divRead").hide();
	
	$("#tbl").on("click", ".row button", function() {
		var mno = $(this).attr("mno");
		$("#divRead").slideDown();
		$.ajax({
			type:"get",
			url:"readMessage",
			data:{"mno":mno},
			success:function(data) {
				$("#sender").html(data.user_name);
				$("#message").html(data.message);
				$("#sendDate").html(data.sendDate);
				$("#readDate").html(data.readDate);
				getList();
				getUser();
			}
		});
	});
</script>
</html>