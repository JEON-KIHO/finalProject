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
<title> READ </title>
<style>
	.title {background:gray; color:white;}
	table {text-align:center;}
	#divTrade{margin:10px 0px 10px 0px;}
	#amount {margin-top:10px;}
</style>
</head>
<body>
<h1> [READ] </h1>
<table border=1>
	<tr>
		<td width=70 class="title">ACT NO.</td>
		<td width=70>${vo.ano }</td>
		<td width=70 class="title">NAME</td>
		<td width=100>${vo.name }</td>
		<td width=70 class="title">BALANCE</td>
		<td width=100 id="balance"></td>
	</tr>
</table>
<div id="divTrade">
	ACCOUNT
	<select id="tradeNo">
		<c:forEach items="${list }" var="v">
			<c:if test="${vo.ano != v.ano }">
				<option value="${v.ano }"> ${v.ano }-${v.name } </option>
			</c:if>
		</c:forEach>
	</select>  <br>
	TRADE BALANCE
	<input type="text" id="amount" size=7> ＄
	<button id="btnTrade">TRANSFER</button>
</div>
<h1> [거래내역] </h1>
<table id="tbl" border=1></table>
<script id="temp" type="text/x-handlebars-template">
		<tr>
			<td width=100>WHO's ACT</td>
			<td width=100>WHO</td>
			<td width=100>TYPE</td>
			<td width=100>AMOUNT</td>
			<td width=150>TRADE DATE</td>
		</tr>
	{{#each .}}
		<tr class="row" style="{{printStyle type}}">
			<td>{{tradeNo}}</td>
			<td>{{name}}</td>
			<td>{{type}}</td>
			<td>{{amount}}</td>
			<td>{{tradeDate}}</td>
		</tr>
	{{/each}}
	</script>
	<script>
		Handlebars.registerHelper("printStyle", function(type){
			if(type=="입금") return "color:blue;";
			else return "color:red;";
		});
	</script>
	<button onClick="location.href='list'"> LIST </button>
</body>
<script>
var ano = "${vo.ano}";

getList();

function getList() {
	$.ajax({
		type:"get",
		url:"/trade/list",
		data:{"ano":ano},
		success:function(data) {
			var temp = Handlebars.compile($("#temp").html());
			 $("#tbl").html(temp(data));
			 
			 // 잔액 가져오기
			 $.ajax({
				 type:"get",
				 url:"/read.json",
				 data:{"ano":ano},
				 success:function(data) {
					 var strAmount = data.balance.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
					 $("#balance").html(strAmount + " ＄");
				 }
			 });
		}
	});
}

$("#btnTrade").on("click", function() {
	var amount = $("#amount").val();
	var tradeNo = $("#tradeNo").val();
	if(amount.length==0) {
		alert("insert amount");
		$("#amount").focus();
	} else {
		if(!confirm(amount + " to " + tradeNo + " trade??")) return;
		$.ajax({
			type:"post",
			url:"/trade/insert",
			data:{"ano":ano, "tradeNo":tradeNo, "amount":amount},
			success:function() {
				alert("success trade");
				getList();
			}
		});
	}
});

$("#btnTrade").ready(function(){
    //키를 누르거나 떼었을때 이벤트 발생
    $("input").bind('keyup keydown',function(){
        inputNumberFormat(this);
    });

    //입력한 문자열 전달
    function inputNumberFormat(obj) {
        obj.value = comma(uncomma(obj.value));
    }
      
    //콤마찍기
    function comma(str) {
        str = String(str);
        return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
    }

    //콤마풀기
    function uncomma(str) {
        str = String(str);
        return str.replace(/[^\d]+/g, '');
    }

    //숫자만 리턴(저장할때)
    //alert(cf_getNumberOnly('1,2./3g')); -> 123 return
    function cf_getNumberOnly (str) {
        var len      = str.length;
        var sReturn  = "";

        for (var i=0; i<len; i++){
            if ( (str.charAt(i) >= "0") && (str.charAt(i) <= "9") ){
                sReturn += str.charAt(i);
            }
        }
        return sReturn;
    }
});
</script>
</html>