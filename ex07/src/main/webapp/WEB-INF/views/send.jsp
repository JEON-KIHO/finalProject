<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 메세지 보내기 </title>
<style>
	.unread {color:red;}
	.read {color:blue;}
	a {text-decoration:none;}
</style>
</head>
<body>
<h1> [메세지 보내기] </h1>
<table border=1>
	<tr>
		<td width=100>SENDER</td>
		<td width=300>${vo.user_name } _ point : <span id="point">${vo.point }</span></td>
	</tr>
	<tr>
		<td width=100>REVEIVER</td>
		<td width=300>
			<select id="receiver">
				<c:forEach items="${list }" var="v">
					<c:if test="${vo.user_id != v.user_id }">
						<option value="${v.user_id }"> ${v.user_name}</option>
					</c:if>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td> TEXT </td>
		<td> <input type="text" size=40 id="txtMessage"> </td>
	</tr>
</table>
<input type="button" value="SEND" id="btnSend">
<input type="button" value="list" onClick="location.href='list'">

<h1> [보낸 메세지] </h1>
<table id="tbl" border=1></table>
	<script id="temp" type="text/x-handlebars-template">
		<tr>
			<td width=100> RECEIVE </td>
			<td width=300> TEXT </td>
			<td width=150> RECEIVE DATE </td>
			<td width=150> READ MSG </td>
		</tr>
		{{#each .}}
			<tr class=row>
				<td>{{user_name}}</td>
				<td>{{message}}</td>
				<td>{{sendDate}}</td>
				<td>{{{confirm readDate}}} &nbsp;<a href="{{mno}}">DEL</a> </td>
			</tr>
		{{/each}}
	</script>
	<script>
		Handlebars.registerHelper("confirm", function(readDate) {
			if (!readDate)
				return "<span class=unread>NONE READ</span>";
			else
				return "<span class=read>READ</span>";
		});
	</script>
</body>
<script>
	getList();

	var sender = "${vo.user_id}";
	
	$("#tbl").on("click", ".row a", function(e) {
		e.preventDefault();
		var mno = $(this).attr("href");
		if(!confirm(mno + " delete?")) return;
		$.ajax({
			type:"post",
			url:"delete",
			data:{"mno":mno},
			success:function() {
				alert("success delete");
				getList();
			}
		});
	});
	
	$("#txtMessage").keydown(function(key) {
		if(key.keyCode==13) {
			$("#btnSend").click();
		}
	});

	$("#btnSend").on("click", function() {
		var receiver = $("#receiver").val();
		var message = $("#txtMessage").val();
		if(message=="") {
			alert("insert MESSAGE");
			$("#txtMessge").focus();
			return;
		}
		if(!confirm("send message?")) return;
		$.ajax({
			type:"post",
			url:"insert",
			data:{"sender":sender, "receiver":receiver, "message":message},
			success:function() {
				$("#txtMessage").val("");
				getList();
				getUser();
			}
		});
	});
	
	function getList() {
		sender = "${vo.user_id}";
		$.ajax({
			type:"get",
			url:"sendList",
			data:{"sender":sender},
			success:function(data) {
				var temp = Handlebars.compile($("#temp").html());
				 $("#tbl").html(temp(data));
			}
		});
	}
	
	function getUser() {
		$.ajax({
			type:"get",
			url:"read",
			data:{"user_id":sender},
			success:function(data) {
				$("#point").html(data.point);
			}
		});
	}
</script>
</html>