<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PRODUCT LIST</title>
<style>
	#divList {overflow:hidden; width:800px;}
	.box {width:190px; background:gray; color:white; float:left; margin:5px; height:280px; text-align:center;}
	img {margin-top:10px; margin-bottom:5px;}
	a {text-decoration:none; color:green;}
	.active {color:red;}
</style>
</head>
<body>
	<h2>[PRODUCT LIST]</h2>
	<c:if test="${user_id == null }">
		<a href="login"> [LOGIN] </a><br><br>
	</c:if>
	<c:if test="${user_id != null }">
		<a href="logout"> [LOGOUT] </a>
		<span>welcome! ${user_name}</span><br><br>
	</c:if>
	<a href="insert"> [INSERT PRODUCT] </a>
	<form name="frm">
		<input type="hidden" name="page" value="1">
		<select name="searchType">
			<option value="pname" <c:out value="${pm.cri.searchType=='pname'?'selected':'' }" />>NAME</option>
			<option value="price1" <c:out value="${pm.cri.searchType=='price1'?'selected':'' }" />>PRICE↓</option>
			<option value="price2" <c:out value="${pm.cri.searchType=='price2'?'selected':'' }" />>PRICE↑</option>
		</select>
		<input type="text" name="keyword" value="${pm.cri.keyword }">
		<input type="submit" value="search" id="btnSearch">
		<select name="perPageNum">
			<option value="4" <c:out value="${pm.cri.perPageNum==4?'selected':'' }" />> 4post </option>
			<option value="8" <c:out value="${pm.cri.perPageNum==8?'selected':'' }" />> 8post </option>
			<option value="12" <c:out value="${pm.cri.perPageNum==12?'selected':'' }" />> 12post </option>
		</select>
	</form>

	<div id="divList">
		<c:forEach items="${list }" var="vo">
			<div class="box">
			<a href="read?pcode=${vo.pcode }">
				<img src="display?fileName=${vo.image }" width=150 height=220>
			</a>
				<div>${vo.pname }</div>
				<div> <fmt:formatNumber value="${vo.price }" pattern="#,###" /> ＄</div>
			</div>
		</c:forEach>
	</div>

	<div id="pagination">
		<c:if test="${pm.prev }">
			<a href="${pm.startPage-1 }">◀</a>
		</c:if>
		<c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
			<c:if test="${pm.cri.page==i }">
			[<a href="${i}" class="active">${i}</a>]
		</c:if>
			<c:if test="${pm.cri.page!=i }">
			[<a href="${i}">${i}</a>]
		</c:if>
		</c:forEach>
		<c:if test="${pm.next}">
			<a href="${pm.endPage+1 }">▶</a>
		</c:if>
	</div>
</body>
<script>
	$("#pagination a").click(function(e) {
		e.preventDefault();
		$(frm.page).val($(this).attr("href"));
		frm.submit();
	});
	
	$(frm.perPageNum).change(function() {
		frm.submit();
	});
</script>
</html>