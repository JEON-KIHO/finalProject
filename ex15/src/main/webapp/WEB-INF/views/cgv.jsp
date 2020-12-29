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
<title>MOVIE CHART</title>
<style>
	#divCGV {width:720px; overflow:hidden; text-align:center;}
	.divBOX {width:160px; float:left; margin:10px;}
	.title {text-overflow:ellipsis; white-space:nowrap; word-wrap:normal; width:160px; overflow:hidden;}
</style>
</head>
<body>
<h2> [MOVIE CHART] </h2>
<button id="btnSave">SAVE</button>
<div id="divWeather"></div>
<script id="temp" type="text/x-handlebars-template">
	{{#each .}}
		<div class="divBOX">
			<div> {{part}} : {{weather}} </div>
		</div>
	{{/each}}
</script>
<div id="divCGV"></div>
<script id="temp1" type="text/x-handlebars-template">
	{{#each .}}
		<div class="divBOX" rank="{{rank}}" title="{{title}}" image="{{image}}">
			<div> {{rank}} </div>
			<div> <img src="{{image}}" width=150> </div>
			<div class="title"> {{title}} </div>
		</div>
	{{/each}}
</script>
</body>
<script>
	
	
	getList();
	
	getWeather();
	
	function getList() {
		$.ajax({
			type:"get",
			url:"cgv.json",
			success:function(data) {
				var temp = Handlebars.compile($("#temp1").html());
				 $("#divCGV").html(temp(data));
			}
		});
	}
	
	function getWeather() {
		$.ajax({
			type:"get",
			url:"weather.json",
			success:function(data) {
				var temp = Handlebars.compile($("#temp").html());
				 $("#divWeather").html(temp(data));
			}
		});
	}
	
	$("#btnSave").on("click", function() {
		if(!confirm("save??")) return;
		$("#divCGV .divBOX").each(function() {
			var fullRank = $(this).attr("rank");
			var rank = fullRank.split(".")[1];
			var title = $(this).attr("title");
			var fullImage = $(this).attr("image");
			var image = fullImage.substring(fullImage.lastIndexOf("/")+1);
			$.ajax({
				type:"get",
				url:"insert",
				data:{"rank":rank, "title":title, "image":image, "fullImage":fullImage},
				success:function() {}
			});
		});
		alert("success save");
	});
</script>
</html>