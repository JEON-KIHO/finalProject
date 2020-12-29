<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> SEARCH LOCAL </title>
<style>
	
	#tbl {border-collapse:collapse; margin:10px 0px 10px 0px;}
	
</style>
</head>
<body>
<h2> [SEARCH LOCAL] </h2>
<div id="divSearch">
	<button id="btnSave"> checked save</button>
	<input id="query" value="경찰서">
	<input type="button" value="search" id="btnSearch">
	<span id="total"></span>
</div>
<table id="tbl" border=1></table>
	<script id="temp" type="text/x-handlebars-template">
		<tr class="title">
			<td><input type="checkbox" id="chkAll"></td>
			<td width=300> PLACE NAME </td>
			<td width=200> TEL. </td>
			<td width=300> ADDRESS </td>
		</tr>
		{{#each documents}}
			<tr class="row">
				<td><input type="checkbox" class="chk" id={{id}} placeName="{{place_name}}" addressName="{{road_address_name}}" phone={{phone}} x={{x}} y={{y}}></td>
				<td>{{place_name}}</td>
				<td>{{phone}}</td>
				<td>{{road_address_name}}</td>
			</tr>
		{{/each}}
	</script>
	<div id="pagination">
		<button id="btnPre"> PRE </button>
		<button id="btnNext"> NEXT </button>
	</div>
</body>
<script>
	var page = 1;

	getList();
	
	$("#btnNext").on("click", function() {
		page++;
		getList();
	});
	
	$("#btnPre").on("click", function() {
		page--;
		getList();
	});

	$("#btnSearch").on("click", function() {
		page = 1;
		getList();
	});
	
	$("#query").keydown(function(key) {
		if(key.keyCode==13) {
			page = 1;
			getList();
		}
	});
	
	$("#btnSave").on("click", function() {
		if(!confirm("save choose?")) return;
		$("#tbl .row .chk:checked").each(function() {
			var id = $(this).attr("id");
			var placeName = $(this).attr("placeName");
			var addressName = $(this).attr("addressName");
			var phone = $(this).attr("phone");
			var x = $(this).attr("x");
			var y = $(this).attr("y");
			$.ajax({
				type:"post",
				url:"insert",
				data:{"id":id, "placeName":placeName, "addressName":addressName, "phone":phone, "x":x, "y":y},
				success:function() {}
			});
		});
		$("#tbl .row .chk").each(function() {
			$(this).prop("checked", false);
		});
		$("#tbl #chkAll").prop("checked", false);
		alert("success save");
	});
	
	function getList() {
		var query = $("#query").val();
		$.ajax({
			type:"get",
			url:"https://dapi.kakao.com/v2/local/search/keyword.json",
			headers:{"Authorization":"KakaoAK 5ce0232a77c703831f4d0a375cece966"},
			dataType:"json",
			data:{"query":query, "page":page, "size":10},
			success:function(data) {
				var temp = Handlebars.compile($("#temp").html());
				 $("#tbl").html(temp(data));
				 var total = data.meta.pageable_count;
				 $("#total").html("post: " + total)
				 
				 if(page==1) $("#btnPre").attr("disabled", true);
				  else $("#btnPre").attr("disabled", false);
				 if(data.meta.is_end) $("#btnNext").attr("disabled", true);
				  else $("#btnNext").attr("disabled", false);
				 
			}
		});
	}
	
	// click chkAll
	$("#tbl").on("click", "#chkAll",  function(){
	    if($(this).is(":checked")){
	        $("#tbl .row .chk").each(function(){
	            $(this).prop("checked", true);
	         });
	    }else{
	        $("#tbl .row .chk").each(function(){
	            $(this).prop("checked", false);
	        });
	    }
	});

	// click chk
	$("#tbl").on("click", ".row .chk", function(){
	    var isCheck=true
	    $("#tbl .row .chk").each(function(){
	        if(!$(this).is(":checked")) isCheck=false
	    });
	    if(isCheck){
	        $("#chkAll").prop("checked", true);
	    }else{
	        $("#chkAll").prop("checked", false);
	    }
	});
</script>
</html>