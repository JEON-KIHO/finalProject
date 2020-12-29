<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5ce0232a77c703831f4d0a375cece966"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> SEARCH LOCAL </title>
</head>
<body>
<h2> [SEARCH LOCAL] </h2>
<table id="tbl"></table>
<script id="temp" type="text/x-handlebars-template">
	{{#each documents}}
		<tr class="row">
			<td width=300>{{place_name}}</td>
			<td width=300>{{road_address_name}}</td>
			<td width=150>{{phone}}</td>
			<td width=100><button x={{x}} y={{y}}>지도출력</button></td>
		</tr>
	{{/each}}
</script>

<div id="map" style="width:850px;height:400px;"></div>
</body>
<script>
	var query = "법원";

	getList();

	function getList() {
		$.ajax({
			type:"get",
			url:"local.json",
			data:{"query":query},
			dataType:"json",
			success:function(data) {
				var temp = Handlebars.compile($("#temp").html());
				 $("#tbl").html(temp(data));
			}
		});
	}
	
	$("#tbl").on("click", ".row button", function() {
		var x = $(this).attr("x");
		var y = $(this).attr("y");
		
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(y, x),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
	});
</script>
</html>