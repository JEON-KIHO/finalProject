<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="flip">
		<div id="left_area">
			<ul>
				<li><a href="salesList">매출 & 환불</a></li>
				<li><a href="cost">비용 & 재고</a></li>
				<li><a href="assets">자산</a></li>
				<li><a href="total">통계</a></li>
				<li><a href="categoryread">설정</a></li>
				<li><a href="insert">NEW</a></li>
			</ul>
		</div>
	</div>
</body>
</html>