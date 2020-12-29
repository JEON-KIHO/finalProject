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
<title>BOOK LIST</title>
<style>
	#divBook {overflow:hidden;}
	.box {float:left; margin:10px;}
	.title {text-overflow:ellipsis; white-space:nowrap; word-wrap:normal; width:100px; overflow:hidden;}
</style>
</head>
<body>
<h2> [BOOK LIST] </h2>
	total : ${pm.totalCount } post
	<div id="divBook">
		<c:forEach items="${list }" var="vo">
			<div class="box">
				<img src="display?fileName=${vo.image }">
				<div class="title">${vo.title }</div>
				<div>${vo.price }</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>