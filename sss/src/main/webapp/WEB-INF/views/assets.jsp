<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.GregorianCalendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
   GregorianCalendar cal = new GregorianCalendar();
   String thisYear = cal.get(GregorianCalendar.YEAR)+"";
   String thisMonth = cal.get(GregorianCalendar.MONTH)+1+"";
   String thisDay = cal.get(GregorianCalendar.DAY_OF_MONTH)+"";
%>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../resources/style.css">
<link rel="stylesheet" href="../resources/icono.css">
<title>자산</title>
<style>
   #Totaltbl {
    border: 1px solid #444444;
  }
  #total_chart{margin-left:150px; margin-top:100px; }
  #all {float:left; border-radius:20px; background-color: white; cursor: pointer; width:80px; margin:5px; font-size:15px;}
  #btDeposit {float:right;  border-radius: 20px; background-color: white; cursor: pointer;}
  #Desposit {margin: 5px 10%; margin-top:50px; margin-left:150px;}
  #btLoans {float:right; border-radius: 20px; background-color: white; cursor: pointer;}
  #Loans{margin: 10px 10%; margin-top:30px;}
#divCenter{width:1450px; height: 1000px; margin-top:150px; margin-left:220px;}
 table{width:1300px; border:0;}
 td {width:1300px; height:30px; text-align:center;}
span {color:black;}
#logout{margin-left:30px;}
</style>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

		<div class="flip">
		<div id="left_area">

			
            
            
			<ul>
				<li><a href="#sales">매출 or 환불</a></li>
				<li><a href="cost">비용</a></li>
				<li><a href="assets">자산</a></li>
				<li><a href="total">통계</a></li>
				<li><a href="invenList">재고</a></li>
				<li><a href="#set">설정</a></li>
				
			</ul>
			<br/>
			<br/>
			<button type="button" class="button" id="logout" style="width:100px;"><i class="icono-power"></i></button>
			
		</div>
	</div>
    <div id="divTop"></div>
    <div id="divCenter">
    
    <div id="sel">
      <div id="selYear"></div>
      <div id="selMonth"></div>
   </div>
   
   <div id = "total_chart" style="width:1300px; height:250px;"></div>
   <input type = "button" value = "통계">
   <div id = "Desposit">
      <table border = 1 style = "border-collapse:collapse; float:left;">
         <tr>
            <td colspan ="4">예금<input type = "button" value = "그래프" id = "btDeposit"></td>
         </tr>
         <tr>
            <td>은행명</td>
            <td>계좌번호</td>
            <td>통장잔액</td>
            <td>이율</td>
         </tr>
         <c:forEach items = "${Dlist}" var = "vo">
            <tr>
               <td>${vo.depositAccountBankName}</td>
               <td>${vo.depositAccountCode}</td>
               <td><fmt:formatNumber value="${vo.depositBalance}" pattern="#,###"/>원</td>
               <td>${vo.depositAccountRate}%</td>
            </tr>
         </c:forEach>
      </table>
   </div>
   <div id = "Loans">
      <table border = 1 style = "border-collapse:collapse;">
         <tr>
            <td colspan = "8">대출<input type ="button" value = "그래프" id ="btLoans"></td>
         </tr>
         <tr>
            <td>은행명</td>
            <td>계좌 번호</td>
            <td>시작일</td>
            <td>만료일</td>
            <td>이율</td>
            <td>대출원금</td>
            <td>상환금액</td>
            <td>대출잔액</td>
         </tr>
         <c:forEach items = "${Llist}" var = "vo">
            <tr>
               <td>${vo.loansAccountBankName}</td>
               <td>${vo.loansAccountCode}</td>
               <td>${vo.loansAccount_startDay.substring(0,11)}</td>
               <td>${vo.loansAccount_endDay.substring(0,11)}</td>
               <td>${vo.loansAccountRate}%</td>
               <td><fmt:formatNumber value="${vo.loansAccountAmount}" pattern="#,###"/>원</td>
               <td><fmt:formatNumber value="${vo.loansAmount}" pattern="#,###"/>원</td>
               <td><fmt:formatNumber value="${vo.loansBalance}" pattern="#,###"/>원</td>
            </tr>
         </c:forEach>
      </table>
   </div>
   </div>
   <div id="footer"><jsp:include page="footer.jsp" /></div>
</body>
<script>
var companyCode = "347-88-00867";
getYear();
var year = <%=thisYear%>-1;
getMonth();
var month = <%=thisMonth%>;
var date = year +"/"+ month;

   $("#sel").on("change", "#selYear #year", function() {
      year = $(this).val();
      getMonth();
      month = $(this).parent().parent().find("#selMonth").find("#month").val();
      date = year+"/"+month;
      drawChart();
   });

   $("#sel").on("change", "#selMonth #month", function() {
      year = $(this).parent().parent().find("#selYear").find("#year").val();
      month = $(this).val();
      date = year+"/"+month;
      drawChart();
   });
   
   function getYear() {
         var yearOption = "<select name='year' id='year' class='selDate'>";
         var daily;
         var cnt = 0;
         var y = 0;
         $.ajax({
            type:"get",
            url:"dailyYear.json",
            dataType:"json",
            success:function(data) {
               $(data).each(function() {
                  daily = this.day;
                  var year = daily.split("-")[0];
                  var oldY = year;
                  if(cnt == 0) {
                     yearOption += "<option value='"+oldY+"'>"+oldY+"</option>";
                  } else {
                     if(oldY != y) {
                        yearOption += "<option value='"+oldY+"'>"+oldY+"</option>";
                     }
                  }
                  y = oldY;
                  cnt++;
               });
               yearOption += "</select>";
               $("#selYear").html(yearOption);
               $("#sel").find("#selYear").find("#year").val(<%=thisYear%>-1).prop("selected", true);
            }
         });
      }

      function getMonth() {
         var monthOption = "<select name='month' id='month' class='selDate'>";
         var daily;
         var cnt = 0;
         var m = 0;
         $.ajax({
            type:"get",
            url:"dailyMonth.json",
            dataType:"json",
            data:{"date":year},
            success:function(data) {
               $(data).each(function() {
                  daily = this.day;
                  var month = daily.split("-")[1];
                  var oldM = month;
                  if(cnt == 0) {
                     monthOption += "<option value='"+oldM+"'>"+oldM+"</option>";
                  } else {
                     if(oldM != m) {
                        monthOption += "<option value='"+oldM+"'>"+oldM+"</option>";
                     }
                  }
                  m = oldM;
                  cnt++;
               });
               monthOption += "</select>";
               $("#selMonth").html(monthOption);
               $("#sel").find("#selMonth").find("#month").val(<%=thisMonth%>).prop("selected", true);
            }
         });
      }

    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
//        var date = year + "/" + month;
//       alert(date);
       
         $.ajax({
           type : "get",
           url : "total.json",
           data : {"date":date},
           success:function(result){
              
              var options = {
                   title: '예금 & 대출 총액 퍼센트',
                   chartArea : {width:'80%', height:'80%'}
                };
              var data = google.visualization.arrayToDataTable(result);
                 var chart = new google.visualization.BarChart(document.getElementById('total_chart'));
                chart.draw(data, options);
           }
      });
   }
</script>
<script>   
   $("#btDeposit").on('click', function(){
      window.open("depositpercent","예금퍼센트", "width=600, height=600")
   });
   
   $("#btLoans").on('click', function(){
      window.open("loanspercent", "대출퍼센트", "width=600, height=600")
   });
</script>

</html>