<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>id check</h1>
   <form name="frm" action="login" method="post">
   <div id="checkMsg"></div>
   <table>
      <tr>
         <td><input type="text" placeholder="id" name="adminId" maxlength="10"></td>
         <td><button type="submit" id="btnCheck">중복확인</button></td>
      </tr>
   </table>
      <div id="checkMs"></div>
      
      <table>
      <tr>
      <td><input type="hidden" value="사용" id="btnUse"></td>
      </tr>
      </table>
     <a href="javascript:window.close()" style="color:gray; margin-left:150px;">close</a>      
   </form>
</body>
<script>
   //아이디 값 불러오기
   $("#btnUse").on("click",function(){
      var adminId=$(frm.adminId).val();
      $(opener.frm.adminId).val(adminId);
      window.close();
   });
   //아이디 체크여부 확인
   $(document).ready(function() {
      $('#btnCheck').on('click', function(e) {
         e.preventDefault();
         var adminId = $(frm.adminId).val();
         $.ajax({
            type : 'POST',
            url : 'idCheck',
            data : {
               "adminId" : adminId
            },
            success : function(data) {
               if(adminId==""){
                  alert("아이디를 입력하세요");
                   $(frm.adminId).focus();
                   return;
               }
               if ((data) == 0) {
                  $('#checkMs').html('<p style="color:blue">사용가능</p>');
                  $('#btnUse').attr("type", "button");
               }else if((data) == 1){
                  $('#checkMs').html('<p style="color:red">사용불가능</p>');
                  $('#btnUse').attr("type", "hidden");
               }
            }
         });
      });
   });
   //사용 버튼 누른후 등록화ㅣ면
   
</script>
</html>