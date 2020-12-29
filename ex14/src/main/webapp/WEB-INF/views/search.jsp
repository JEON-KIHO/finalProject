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
<title> SEARCH BOOK </title>
<style>
	.title {text-overflow:ellipsis; white-space:nowrap; word-wrap:normal; width:150px; overflow:hidden;}
</style>
</head>
<body>
<h2> [SEARCH BOOK] </h2>
<div id="divSearch">
	<input type="text" id="query" value="mysql">
	<button id="btnSave">SAVE</button>
</div>
<div id="divBook"></div>
<script id="temp" type="text/x-handlebars-template">
	{{#each items}}
		<div class="box" isbn="{{isbn}}" title="{{title}}" price="{{price}}" image="{{image}}">
			<img src="{{image}}" width=150>
			<div class="title">{{{title}}}</div>
			<div>{{fmt price}}＄</div>
			<div>{{isbn}}</div>
		</div>
	{{/each}}
</script>
<script>
	Handlebars.registerHelper("fmt", function(price){
		return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	});
</script>

</body>
<script>
	getList();

	function getList() {
		var query = $("#query").val();
		$.ajax({
			type:"get",
			url:"search.json",
			data:{"query":query},
			dataType:"json",
			success:function(data) {
				var temp = Handlebars.compile($("#temp").html());
				 $("#divBook").html(temp(data));
			}
		});
	}
	
	$("#query").keydown(function(key) {
		if(key.keyCode==13) {
			getList();
		}
	});
	
	$("#btnSave").on("click", function() {
		if(!confirm("save?")) return;
		$("#divBook .box").each(function() {
			var isbn = $(this).attr("isbn");
			var title = $(this).attr("title");
			var price = $(this).attr("price");
			var fullImage = $(this).attr("image");
			var image = fullImage.substring(fullImage.lastIndexOf("/")+1, fullImage.lastIndexOf("?"));
			$.ajax({
				type:"post",
				url:"insert",
				data:{"isbn":isbn, "title":title, "price":price, "image":image, "fullImage":fullImage},
				success:function() {}
			});
		});
		alert("success save");
	});
</script>
</html>