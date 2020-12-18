<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#tbl{padding:10px 10px 20px 10px;}
</style>
</head>
<body>
<form name="frm" action="pwUpdate" method="post">
<table id="tbl">
   <tr class="register" style="margin-right:10px;">
      <td style="padding:5px 5px 5px 5px;">*  현재 비밀번호<input type="password" name="oriPw" style="margin-left:10px;"></td>
   </tr>
   <tr class="register" style="margin-right:10px;">
      <td style="padding:5px 5px 5px 5px;">*  새 비밀번호<input type="password" name="newPw" style="margin-left:10px;"></td>
   </tr>
   <tr class="register" style="margin-right:10px;">
      <td style="padding:5px 5px 5px 5px;">*  비밀번호 확인<input type="password" name="adminPassword" style="margin-left:10px;"></td>
   </tr>
   
</table>
    <input type="submit" name="btnSave" value="저장" style="margin:20px;"> 
</form>
</body>
<script>
//저장 눌렀을때

$(frm.btnSave).click(function(e){
   e.preventDefault();
var oriPw=$(frm.oriPw).val();
var newPw=$(frm.newPw).val();
var adminPassword=$(frm.adminPassword).val();
   if(oriPw.trim()==""){
      alert("기존의 비밀번호를 입력하시오.");
      frm.oriPw.focus();
   }else if(newPw.trim()==""){
      alert("새 비밀번호를 입력하시오");
      frm.newPw.focus();
   }else if(adminPassword.trim()==""){
      alert("확인하실 비밀번호를 입력하시오.");
      frm.adminPassword.focus();
   }   else if(newPw.trim()!=adminPassword.trim()){
      alert("비밀번호가 일치하지 않습니다.");
   }else{
      $.ajax({
         type:"post",
         url:"pwUpdate",
         data:{"adminPassword":adminPassword},
         success:function(){
            if(!confirm("등록하시겠습니까?"))return;
            frm.submit();
            alert("변경완료");
            window.close();
         }
//    window.close();
//     location.href="main";
    
      });
   }
});

      

// $("#btnSave").on("click",function(){
//    if(!confirm("저장 하시겠습니까?"))return;
//    frm.submit();
//    location.href="main";
// });
//새로운 비번

         </script>
</html>