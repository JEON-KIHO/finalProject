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
<title> 상품 등록 </title>
</head>
<body>
<h2> [상품 등록] </h2>
<form name="form" action="insert" method="post" enctype="multipart/form-data">
	<div>
		<div style="width:100px">상품코드: <input type="text" name="pcode"></div>
		<div style="width:100px">상품명: <input type="text" name="pname"></div>
		<div style="width:100px">상품가격: <input type="text" name="price"></div>
		<div style="width:100px"> 대표이미지: <input type="file" name="file"></div>
		<div id="images"  style="width:800px; margin-bottom:10px; padding:10px; background:gray">
			첨부이미지: <input type="file" name="files" multiple>
		</div>
		<input type="submit" value="저장">
		<input type="reset" value="취소">
	</div>
</form>
</body>
</html>