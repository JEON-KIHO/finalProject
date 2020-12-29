<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LogIn</title>
<style>
 #divCenter{margin-left:700px;margin-top:200px;}
 #frm{border:1px solid #F1F3F2;}
 td{padding:20px 20px 10px 15px;}
</style>
</head>
<body>
<div id="divTop"></div>
<div id="divCenter">
<h1>LogIn</h1>
   <form name="frm" action="login" method="post">
      <table>
         <tr>
            <td width=100>Id</td>
            <td width=200><input type="text" name="adminId"></td>
         </tr>
         <tr>
            <td width=100>Password</td>
            <td width=200><input type="password" name="adminPassword"></td>
         </tr>
         <tr>
         <td><input type="submit" value="Login"></td> 
         <td><input type="checkbox" name="chkLogin" >Keep Login</td>
         </tr>
      </table>
   </form>
   </div>
</body>
<script>

	$(frm).submit(function(e) {
		e.preventDefault();
		var adminId = $(frm.adminId).val();
		var adminPassword = $(frm.adminPassword).val();
		var chkLogin = $(frm.chkLogin).is(":checked") ? true : false;
		$.ajax({
			
			type : "post",
			url : "mainlogin",
			data : {
				"adminId" : adminId,
				"adminPassword" : adminPassword,
				"chkLogin" : chkLogin
			},
			success : function(data) {
				if (data == 0) {
					alert("아이디를 입력하세요.");
				} else if (data == 2) {
					alert("비밀번호가 올바르지 않습니다.");
				} else if (data == 1) {

					location.href = "main";
				}
			}

		});

	});


	
</script>

</html>