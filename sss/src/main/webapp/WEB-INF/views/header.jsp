<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/style.css">
<style>
#darken-background {
	position: absolute;
	top: 0px;
	left: 0px;
	right: 1000px;
	height: 100%;
	display: none;
	background: rgba(0, 0, 0, 0);
	z-index: 10000;
	overflow: hidden;
}

#lightbox {
    right: 1350px;
	z-index:1000;
	position: fixed;
	width: 400px;
	margin: 20px auto;
	padding: 25px;
	border: 1px solid #333333;
	border-radius: 5px;
	background: white;
	box-shadow: 0px 5px 5px rgba(34, 25, 25, 0.4);
	text-align: center;
}

img {
	margin-right: 11%;
	align: center;
	width: 200px;
	height: 120px;
}

#profile {
	float: left;
	margin-top: 30px;
}

span {
	float: left;
	
} 
    #btnProfile{margin-bottom:50px;margin-right:50px;}
    #divicon{margin-right:10px;border:1px solid lightgray;margin-top:100px;padding:25px 15px 25px 15px;}
</style>
</head>
<body>
	<div id="header">
		<img src="../resources/Triple sss.png" onclick="location.href= 'main'">
		<button type="button" class="button" id="profile"
			style="width: 60px; float: left; margin-left: 1px;">
			<i class="icono-user"></i>
		</button>
		
	</div>
	<div id="darken-background">
		<div id="lightbox">
		<div id="btnId">
		<button type="button" class="button" id="btnProfile"
			style="width: 60px; float: left; margin-left: 1px;"><i class="icono-user"></i>
		<c:if test="${adminId!=null}">
            <span style="font-size:13px;margin-top:15px;">${adminId}</span>
		</c:if>
		</button>
		
		</div>
		<div id="divName" style="margin-left:20px;">
		<c:if test="${companyName!=null}">
            <span><b style="font-size:20px;">${companyName}</b>&nbsp;&nbsp;님 <br/>
				환영합니다.
			</span>
		</c:if>
		</div>
		<div id="divicon">
			<button type="button" class="button" id="btnChange" style="width:100px;color:white;background:#547484;margin-right:50px;margin-bottom:20px;">비밀번호 변경</button><br/>
			<button type="button" class="button" id="logout" style="width:100px;color:white;background:#547484;margin-right:50px;padding:15px 15px 15px 15px;">로그 아웃</button>
	        </div>
		</div>
	</div>

</body>
<script>
//비밀번호 변경
$("#btnChange").on("click",function(){
	window.open("pwUpdate","btnChange",'left='+(screen.availWidth+660)/7+', width=500px, height=300px');
});
//로그아웃
	$("#logout").click(function() {
		if (confirm("로그아웃 하시겠습니까?") == true) {
			alert("로그아웃 하셨습니다.");
			location.href="login";
		} else {
			return;
		}
	});
	$(document).ready(function() {
		function showLightBox() {
			//라이트박스를 보이게 한다. 
			$("#darken-background").show();
		}
		function hideLightBox() {
			 $("#darken-background").hide();
		}
		$("#darken-background").click(function() {
			hideLightBox();
		});
		$("#profile").on("click", function() {
			showLightBox();
		});
	});
	
	$("#btnChange").on(
			"click",
			function() {
				window.open("pwUpdate", "btnChange", 'left='
						+ (screen.availWidth + 660) / 7
						+ ', width=500px, height=300px');
			});
</script>
</html>