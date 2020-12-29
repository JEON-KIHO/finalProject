<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script src= "http://code.jquery.com/jquery-1.9.1.js"></script>

<meta charset="UTF-8">
<title>Triple S</title>

	<style>
form {
	
	width:900px;
	height:900px;
	margin-left: 500px;
	margin-top: 200px;
}

td {
	padding: 20px 20px 20px 20px;
	font-size:20px;
}

.content-wrapper {
	margin: 5rem;
}

html, body {
  height: 100%;
}



*:focus { outline: none; }


.button1 {
  width: 140px;
  height: 45px;
  font-family: 'Roboto', sans-serif;
  font-size: 11px;
  text-transform: uppercase;
  letter-spacing: 2.5px;
  font-weight: 500;
  color: white;
  background-color: #597484;
  border: none;
  border-radius: 45px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  margin-left:15px;
  }
  
  .button1:hover {
  background-color: black;
  box-shadow: 0px 15px 20px rgba;
  color: #fff;
  transform: translateY(-7px);
}
  
</style>
</head>
	
<body>
	<jsp:include page="header1.jsp"></jsp:include>
   <div class="content-wrapper">
    <div class="form__group field">
   <div id="divCenter">
   <div class="wrap">
   
   <form name = "frm" action="insert" method="post">
   
      <table>
         <tr>
            <td>상호명 &nbsp;&nbsp; <input type = "text" name = "companyName" style="border:none; width:200px; height:30px; border-bottom:1px solid gray;" placeholder="상호명 입력"></td>
         </tr>
         <tr>
            <td>사업자 등록 번호 &nbsp;&nbsp;&nbsp; 
               <input type = "text" name = "companyCode" style="border:none; width:200px; height:30px; border-bottom:1px solid gray;" placeholder="- 를 넣어서 입력해주세요.">
               <input type = "button" class="button1" name="button" value = "확인하기">
               <input type = "radio" class = "rd" value="개인" name = "companyType"> 개인사업자
               <input type = "radio" class = "rd" value = "법인" name = "companyType"> 법인사업자
<!--                <input type = "hidden" name = "companyType" id = "companyType"> -->
            </td>
         </tr>
         <tr>
            <td>법인번호 &nbsp;&nbsp;&nbsp; 
              <input type = "text" class = "rd-cblNum" name = "companyCorporate" style="border:none; width:200px; height:30px; border-bottom:1px solid gray;" placeholder="법인번호 입력"></td>
         </tr>
         <tr>
            <td>주소 &nbsp;&nbsp;&nbsp; 
               <input type = "text" id = "address" placeholder = "주소를 입력하세요" name = "address" style="border:none; width:250px; height:30px; border-bottom:1px solid gray;">
                <input type = "text" id = "detailaddress" placeholder = "상세주소 입력" name = "detailaddress" style="border:none; width:200px; height:30px; border-bottom:1px solid gray;">
             &nbsp;&nbsp;
                 <input type = "button" class="button1" id="FindCode" value = "주소 검색">
                 <input type = "hidden" name = "companyAddress">
            </td>
         </tr>
         <tr>
            <td>대표자명 &nbsp;&nbsp;&nbsp; 
            <input type = "text" name = "companyCEO" style="border:none; width:200px; height:30px; border-bottom:1px solid gray;" placeholder="대표자명 입력"></td>
         </tr>
         <tr>
            <td>아이디 &nbsp;&nbsp;&nbsp; 
                <input type = "text" name = "adminId" style="border:none; width:200px; height:30px; border-bottom:1px solid gray;" placeholder="아이디 입력">
                  <button id="btnCheck" type="button" class="button1">중복체크</button>
                  <input type="hidden" name="idDuplication" value="unCheck">
             </td>
         </tr>

         <tr>
            <td>비밀번호 &nbsp;&nbsp;&nbsp; 
              <input type = "password" name = "adminPassword" 
              style="border:none; width:200px; height:30px; border-bottom:1px solid gray; font-size:12px;" placeholder="비밀번호는 4자리이상 입력하시오."><br/></td>
         </tr>
         <tr>
            <td>개업일 &nbsp;&nbsp;&nbsp;
               <input type = "date" name = "openDate">
             </td>
         </tr>
      </table>
      
      <input type = "submit" value = "저장"  class="button1" id = "save"   style="margin:10px; margin-left:400px; padding:5px;">
      <input type = "reset" value = "취소"  class="button1" id = "reset" style="padding:5px;">
   </form>
   </div>
   </div>
   </div>
   </div>
   	<div id="footer"><jsp:include page="footer.jsp" /></div>
</body>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

//취소 버튼 누를때 
$("#reset").click(function(){
   if(confirm("등록을 취소 하시겠습니까?") == true) {
      alert("취소 하셨습니다.");
      location.href="login";
   }else{
      return;
   }
});

//뭔지 모르겠음
// $(frm.button).on("click",function(){
//    var number=$(frm.companycode).val();
   
//    $.ajax({
//       type:"get",
//       url :"company.json",
//       dataType: "json",
//       data : {"number":number},
//       success : function(data){
//          alert("???????????");
//       }
//    });
// });


//유효성 체크 및 저장
   $(frm).submit(function(e) {
         e.preventDefault();
        var radioVal = $('input[name="companyType"]:checked').val();
      frm.companyAddress.value = frm.address.value + frm.detailaddress.value;
         
      if (!$(frm.companyName).val()) {
         alert("상호명을 입력하세요");
         //커서(포커스)를 아이디 인풋요소로 이동
         $(frm.companyName).focus();
         //아래의 submit()을 하면 안되므로...
         
      } else if (!$(frm.companyCode).val()) {
         alert("사업자 등록번호를 입력하세요");
         $(frm.companyCode).focus();
         
      } else if (!radioVal){
         alert("사업자 체크해주세요.");
         frm.companyType.foucs();
         
//       }else if(radioVal){
//     	  if(radioVal == '법인'){
//         	 if(!frm.companyCorporate.value){
//             	alert("법인등록번호를 입력하세요");
//             	frm.companyCorporate.focus();
//         	 }
//     	}
         
      }else if (!frm.address.value) {
         alert("주소를 입력하세요");
         frm.address.focus();
         
      } else if (!frm.detailaddress.value){
         alert("상세주소를 입력하세요.");
         frm.detailaddress.focus();
         
      } else if (!frm.companyCEO.value) {
         alert("대표자명을 입력하세요");
         frm.companyCEO.focus();
         
      } else if (!frm.adminId.value) {
         alert("아이디를 입력하세요");
         frm.adminId.focus();
         
      } else if (!frm.adminPassword.value) {
         alert("비밀번호를 입력하세요");
         frm.adminPassword.focus();
         
      } else if (!frm.openDate.value) {
         alert("개업일을 입력하세요");
         frm.openDate.focus();
         
      }else if(radioVal){
    	if(radioVal == '법인'){
        	if(!frm.companyCorporate.value){
            	alert("법인등록번호를 입력하세요");
            	frm.companyCorporate.focus();
        	 }else{
        	 	if(!confirm("등록하시겠습니까?")) return;
        	 	frm.submit();
        	 }
      	}else{
         if(!confirm("등록하시겠습니까?")) return;
//          alert(radioVal);
         frm.submit();
      	}
      }
   });
   
   //주소
   $("#FindCode").on('click', function() {
      new daum.Postcode({
         oncomplete : function(data) {
            var addr = '';

            //주소 타입일때
            if (data.userSelectedType === 'R') {
               addr = data.roadAddress;
            } else { //지번 주소일때
               addr = data.jibunAddress;
            }
            document.getElementById("address").value = addr;
            document.getElementById("address").focus();
         }
      }).open();
   });

   //라디오 버튼 활성 비활성
   $('.rd').on('click', function() {
      var valueCheck = $('.rd:checked').val();

      if (valueCheck == '법인') {
         $('.rd-cblNum').attr('disabled', false);
         $('.rd-cblNum').focus();
      } else {
         $('.rd-cblNum').val('');
         $('.rd-cblNum').attr('disabled', true);
      }
   });
   

   //팝업
   $("#btnCheck").on("click", function() {
      window.open("idCheck", "btnCheck",'left='+(screen.availWidth-660)/2+',top='+(screen.availHeight-430)/2+',width=500px, height=350');
   });

   //팝업을 가운데 위치 시키기 위해 값구하기
   $(frm.adminId).on(
         "click",
         function() {
            window.open('idCheck', 'btnCheck', 'left='
                  + (screen.availWidth - 660) / 2 + ',top='
                  + (screen.availHeight - 430) / 2
                  + ', width=500px,height=300px');
   });
</script>
</html>