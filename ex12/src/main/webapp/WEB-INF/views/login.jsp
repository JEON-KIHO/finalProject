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
<title>LOGIN</title>
</head>
<body>
	<h2>[LOGIN]</h2>
	<form name="form" action="login" method="post">
		<table border=1>
			<tr>
				<td width=100> ID </td>
				<td width=200> <input type="text" name="user_id"> </td>
			</tr>
			<tr>
				<td width=100> PASSWORD </td>
				<td width=200> <input type="text" name="user_password"> </td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="submit" value="login">
					<input type="checkbox" name="chkLogin"> login ING
				</td>
			</tr>
		</table>
	</form>
</body>
<script>
$(form).submit(function(e) {
	e.preventDefault();
	var id = $(form.user_id).val();
	var pw = $(form.user_password).val();
	var chkLogin=$(form.chkLogin).is(":checked")?true:false;
	$.ajax({
		type:"post",
		url:"login",
		data:{"user_id":id, "user_password":pw, "chkLogin":chkLogin},
		success:function(data) {
			if(data==0) {
				alert("NONE ID");
			} else if(data==1) {
				alert("different PW");
			} else {
				alert("LOGIN SUCCESS");
				location.href="list";
			}
		}
	});
});
</script>
</html>