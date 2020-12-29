<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../resources/style.css">
<link rel="stylesheet" href="../resources/icono.css">
<title>Insert title here</title>
<%
	GregorianCalendar cal = new GregorianCalendar();
	String thisYear = cal.get(GregorianCalendar.YEAR) + "";
	String thisMonth = cal.get(GregorianCalendar.MONTH) + 1 + "";
	String thisDay = cal.get(GregorianCalendar.DAY_OF_MONTH) + "";
%>
</head>
<style>


#calendar {
	width: 1200px;
	overflow: hidden;
	margin-left:100px;
	border:solid 1px #F6F6F6;
}

.wom1, .wom2, .wom3, .wom4, .wom5, .wom6 {
	width: 150px;
	height: 130px;
	float: left;
	border:solid 1px #EAEAEA;
	background-color:white;
}

#datePage {
	overflow: hidden;
	margin:15px 0px 15px 350px;
	height:60px;
	width:600px;
	text-align:center;
}

#pre, #next, #sel{
	width: 200px;
	float: left;
}

#sel {
	overflow: hidden;

}

#selYear, #selMonth, #btn {
	float: left;
}

#costDetail {
	overflow: hidden;
	display:none;
	width: 400px;
	margin-right:100px;
	font-size:30px;
	font-family: 'Roboto', sans-serif;
}
}

.costAccountName, .costAmount, .totalCost, .monthlyCost {
	float: left;
}

.costAccountName {
	width: 200px;
}

.costAmount {
	width: 200px;
}

.totalCost {
	width: 200px;
}

.monthlyCode {
	width: 200px;
}

#data {
	overflow: hidden;
	width: 1700px;
}

#calendarView{
	float: left;
}

#calendarView {
	width: 1200px;
}



.pleaseData {
	height: 100px;
}

#divCenter {
	width: 1500px;
	height: 900px;
	margin-top: 150px;
	margin-left: 250px;
	background-color:#F6F6F6;
	border:1px solid #597484;
}
 #preYear, #preMonth, #nextMonth, #nextYear{
    background-color: hsl(222, 100%, 95%);
    color: hsl(243, 80%, 62%);
    border-radius: 6px;
    border-width: 0;
    display: inline-block;
    cursor: pointer;
	box-shadow: 0 5px #B0B0B0;
}

#preYear:hover {
    background-color: hsl(190, 100%, 70%);
    
}
#preYear:active{
	background-color: blue;
	box-shadow: 0 5px #808080;
	transform: translateY(4px);
} 
#preMonth:hover {
     background-color: hsl(190, 100%, 70%);
}
#preMonth:active {
    background-color: blue;
	box-shadow: 0 5px #808080;
	transform: translateY(4px);
}
#nextMonth:hover {
  	background-color: hsl(190, 100%, 70%);
}
#nextMonth:active {
  	background-color: blue;
	box-shadow: 0 5px #808080;
	transform: translateY(4px);
}
#nextYear:hover {
    background-color: hsl(190, 100%, 70%);
}
#nextYear:active {
   	background-color: blue;
	box-shadow: 0 5px #808080;
	transform: translateY(4px);
}

*:focus { outline: none; }

}

.totalCost {color:red}
.monthlyCost {color:red}

select {
  width: 100px;
  padding: .8em .5em;
  font-family: inherit;
  font-size:15px;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  border: 1px solid #597484;
  border-radius: 5px;
  text-align:center;
  }
  span {color:black;}
#logout{margin-left:30px;}
  
</style>
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
			<br /> <br />
			<button type="button" class="button" id="logout" style="width:100px;"><i class="icono-power"></i></button>
		</div>
	</div>

	<div id="divCenter">
		<div id="datePage">
			<div id="pre">
				<button type="button" value="preYear" id="preYear"><i class="icono-rewind"></i></button> 
				<button type="button" value="preMonth" id="preMonth"><i class="icono-caretLeft"></i></button>
			</div>
			<div id="sel">
				<div id="selYear"></div>
				<div id="selMonth"></div>
			
				<div id="btn">
					<input type="hidden" id="btn">
				</div>
			</div>
			<div id="next">
				<button type="button" value="nextMonth" id="nextMonth"><i class="icono-caretRight"></i></button>
				<button type="button" value="nextYear" id="nextYear"><i class="icono-forward"></i></button>
			</div>
		</div>
		<div id="data">
			<div id="calendarView"></div>
							<div id="costDetail"></div>
						</div>
					</div>

	<div id="footer"><jsp:include page="footer.jsp" /></div>
</body>
<script>
// var firstYear;
// var lastYear;
var monthlyCost;
getYear();
var year = <%=thisYear%>-1;
getMonth();
var month = <%=thisMonth%>;
var date = year +"/"+ month;
// getDay();
calendar();
monthlyCost();
setTimeout(costList, 1000);
// costList();


$("#logout").click(function() {
	if (confirm("로그아웃 하시겠습니까?") == true) {
		alert("로그아웃 하셨습니다.");
		location.href="login";
	} else {
		return;
	}
});

$("#calendarView").on("click", "#calendar [name=wom]", function() {
	$("#costDetail").show();
   date = $(this).find(".pleaseData").attr("id");
   getData();
   
});

$("#btn").on("click", function() {
   date = year +"/"+ month;
   monthlyCost();
   setTimeout(costList, 500);
//    costList();
});

$("#sel").on("change", "#selYear #year", function() {
   year = $(this).val();
   getMonth();
   month = $(this).parent().parent().find("#selMonth").find("#month").val();
   date = year+"/"+month;
   $("#costDetail").html("");
   calendar();
   setTimeout(costList, 500);
//    costList();
});

$("#sel").on("change", "#selMonth #month", function() {
   year = $(this).parent().parent().find("#selYear").find("#year").val();
   month = $(this).val();
   date = year+"/"+month;
   $("#costDetail").html("");
   calendar();
   setTimeout(costList, 500);
//    costList();
});

$("#preYear").on("click", function() {
   year--;
   $("#sel #selYear #year").val(year).prop("selected", true);
   date = year +"/"+ month;
   $("#costDetail").html("");
   calendar();
   setTimeout(costList, 500);
//    costList();
});

$("#nextYear").on("click", function() {
   year++;
   $("#sel #selYear #year").val(year).prop("selected", true);
   date = year +"/"+ month;
   $("#costDetail").html("");
   calendar();
   setTimeout(costList, 500);
//    costList();
});

$("#preMonth").on("click", function() {
   if(month == 01 || month == 1) {
      year--;
      month = "12";
      $("#sel #selYear #year").val(year).prop("selected", true);
      $("#sel #selMonth #month").val(month).prop("selected", true);
   } else {
      month--;
      for(var i = 1; i <= 9; i++) {
         if(month == i) {
            month = "0" + i;
         }
      }
      $("#sel #selMonth #month").val(month).prop("selected", true);
   }
   date = year +"/"+ month;
   $("#costDetail").html("");
   calendar();
   setTimeout(costList, 500);
//    costList();
});

$("#nextMonth").on("click", function() {
   if(month == 12) {
      year++;
      month = "01";
      $("#sel #selYear #year").val(year).prop("selected", true);
      $("#sel #selMonth #month").val(month).prop("selected", true);
   } else {
      month++;
      for(var i = 1; i <= 9; i++) {
         if(month == i) {
            month = "0" + i;
         }
      }
      $("#sel #selMonth #month").val(month).prop("selected", true);
   }
   date = year +"/"+ month;
   $("#costDetail").html("");
   calendar();
   setTimeout(costList, 500);
//    costList();
});

function costList() {
   
   var date = year +"/"+ month;
   $.ajax({
      type:"get",
      url:"costList.json",
      data:{"date":date},
      success:function(data) {
         $(data).each(function() {
            var amount = this.costAmount;
            var costYear = this.day.split("-")[0];
            var costMonth = this.day.split("-")[1];
            var costDay = this.day.split("-")[2].substring(0,2);
            var date = costYear +"/"+ costMonth +"/"+ costDay;
            $("#calendarView").find("#calendar").find("[name=wom]").each(function() {
               if($(this).find(".pleaseData").attr("id") == date) {
                  
                  function changeChart(){
                      google.charts.load('current', {'packages':['corechart']});
                      google.charts.setOnLoadCallback(drawVisualization);
                           function drawVisualization() {
                              $.ajax({
                                  type:"get",
                                  url:"costGraphList.json",
                                  dataType:"json",
                                  data:{"date":date, "monthlyCost":monthlyCost},
                                  success:function(result){
//                                    var result = [["과목","점수"],["국어",90],["영어",80]];
                                      var data = google.visualization.arrayToDataTable(result); /* 데이터 셋팅 */
                                      var options = {
                                            vAxis : {
                                            },
                                            hAxis : {
                                               maxValue : monthlyCost,
                                               minValue : 0,
                                               ticks : ['0%', '100%']
                                            },
                                            series : {
                                               0: {color: 'red'}
                                               
                                            },
                                            bar : {
                                               groupWidth : '40%' // 그래프 너비 설정 %
                                            },
                                            legend : 'none'
                                            }; /* 옵션 셋팅 */
                                      var chart = new google.visualization.BarChart(document.getElementById(date));
                                         chart.draw(data, options); /* 차트 그리기 */
                                  }
                              });
                          }
                   }
                  
                  $(this).find(".pleaseData").text(changeChart());
               }
            });
         });
      }
   });
}

function monthlyCost() {
   var date = year +"/"+ month;
   var amount = 0;
   $.ajax({
      type:"get",
      url:"costList.json",
      data:{"date":date},
      success:function(data) {
         $(data).each(function() {
            amount = amount + this.costAmount;
         });
         monthlyCost = amount;
      }
   });
}

function getData() {
   var amount = 0;
   var addCost = "<div id='costList'>";
   $.ajax({
      type:"get",
      url:"dataLists.json",
      data:{"date":date},
      success:function(data) {
         $(data).each(function() {
            var costAccountName = this.COSTACCOUNTNAME;
            var costAmount = this.COSTAMOUNT;
            amount = amount + costAmount;
            addCost += "<div class='costAccountName'>"+costAccountName+"</div>";
            var costAmountFormat = costAmount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            addCost += "<div class='costAmount'>"+costAmountFormat+"원</div>";
         });
         var amountFormat = amount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
         addCost += "<div class='totalCost' style='color:red'>비용 총액</div><div class='monthlyCost'>"+amountFormat+"원</div>";
         addCost += "</div>";
         $("#costDetail").html(addCost);
      }
   });
}

function calendar() {
   var date = year +"/"+ month;
   var addCalendar = "<div id='calendar'>";
   var cnt = 0;
   var cnt1 = 0;
   $.ajax({
      url:"daily.json",
      type:"get",
      data:{"date":date},
      success:function(data) {
         $(data).each(function() {
            if(this.wom == 1) {
               cnt++;
            }
         });
         
         if(cnt != 7) {
            for(var i = 0; i <7-cnt; i++) {
               addCalendar += "<div class='wom1'></div>";
            }
         }
         
         $(data).each(function() {
            if(this.wom == 1) {
               addCalendar += "<div class='wom1' name='wom' style='color:black;'>"+this.day.split("-")[2].substring(0,2)+"<div class='pleaseData' id='"+date+"/"+this.day.split("-")[2].substring(0,2)+"'></div></div>";
            }
            if(this.wom == 2) {
               addCalendar += "<div class='wom2' name='wom' style='color:black;'>"+this.day.split("-")[2].substring(0,2)+"<div class='pleaseData' id='"+date+"/"+this.day.split("-")[2].substring(0,2)+"'></div></div>";
            }
            if(this.wom == 3) {
               addCalendar += "<div class='wom3' name='wom' style='color:black;'>"+this.day.split("-")[2].substring(0,2)+"<div class='pleaseData' id='"+date+"/"+this.day.split("-")[2].substring(0,2)+"'></div></div>";
            }
            if(this.wom == 4) {
               addCalendar += "<div class='wom4' name='wom' style='color:black;'>"+this.day.split("-")[2].substring(0,2)+"<div class='pleaseData' id='"+date+"/"+this.day.split("-")[2].substring(0,2)+"'></div></div>";
            }
            if(this.wom == 5) {
               addCalendar += "<div class='wom5' name='wom' style='color:black;'>"+this.day.split("-")[2].substring(0,2)+"<div class='pleaseData' id='"+date+"/"+this.day.split("-")[2].substring(0,2)+"'></div></div>";
            }
            if(this.wom == 6) {
               addCalendar += "<div class='wom6' name='wom' style='color:black;'>"+this.day.split("-")[2].substring(0,2)+"<div class='pleaseData' id='"+date+"/"+this.day.split("-")[2].substring(0,2)+"'></div></div>";
            }
         });
         addCalendar += "</div>";
//          alert(addCalendar);
         $("#calendarView").html(addCalendar);
         $("#btn").click();
      }
   });
}

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

// function getDay() {
//    var dayOption = "<select name='day' id='day' class='selDate'>";
//    var daily;
//    var cnt = 0;
//    var d = 0;
//    $.ajax({
//       type:"get",
//       url:"daily.json",
//       dataType:"json",
//       data:{"date":date},
//       success:function(data) {
//          $(data).each(function() {
//             daily = this.day;
//             var day = daily.split("-")[2].substring(0,2);
//             var oldD = day;
//             if(cnt == 0) {
//                dayOption += "<option value='"+oldD+"' selected>"+oldD+"</option>";
//             } else {
//                if(oldD != d) {
//                   dayOption += "<option value='"+oldD+"'>"+oldD+"</option>";
//                }
//             }
//             d = oldD;
//             cnt++;
//          });
//          dayOption += "</select>";
//          $("#selDay").html(dayOption);
<%--          $("#sel").find("#selDay").find("#day").val(<%=thisDay%>).prop("selected", true); --%>
//       }
//    });
// }

// function getDate() {
//    var yearOption = "<select name='year' id='year' class='selDate'>";
//    var monthOption = "<select name='month' id='month' class='selDate'>";
//    var dayOption = "<select name='day' id='day' class='selDate'>";
//    var daily;
//    var cnt = 0;
//    var y = 0;
//    var m = 0;
//    var d = 0;
//    $.ajax({
//       type:"get",
//       url:"daily.json",
//       dataType:"json",
//       success:function(data) {
//          alert("?");
//          $(data).each(function() {
//             daily = this.day;
//             var year = daily.split("-")[0];
//             var oldY = year;
//             if(cnt == 0) {
//                yearOption += "<option value='"+oldY+"' selected>"+oldY+"</option>";
//             } else {
//                if(oldY != y) {
//                   yearOption += "<option value='"+oldY+"'>"+oldY+"</option>";
//                }
//             }
//             y = oldY;
//             cnt++;
//          });
//          cnt = 0;
//          $(data).each(function() {
//             daily = this.day;
//             var month = daily.split("-")[1];
//             var oldM = month;
//             if(cnt == 0) {
//                monthOption += "<option value='"+oldM+"' selected>"+oldM+"</option>";
//             } else {
//                if(oldM != m) {
//                   monthOption += "<option value='"+oldM+"'>"+oldM+"</option>";
//                }
//             }
//             m = oldM;
//             cnt++;
//          });
//          cnt = 0;
//          $(data).each(function() {
//             daily = this.day;
//             var day = daily.split("-")[2].substring(0,2);
//             var oldD = day;
//             if(cnt == 0) {
//                dayOption += "<option value='"+oldD+"' selected>"+oldD+"</option>";
//             } else {
//                if(oldD != d) {
//                   dayOption += "<option value='"+oldD+"'>"+oldD+"</option>";
//                }
//             }
//             d = oldD;
//             cnt++;
//          });
//          yearOption += "</select>";
//          monthOption += "</select>";
//          dayOption += "</select>";
//          $("#selYear").html(yearOption);
//          $("#selMonth").html(monthOption);
//          $("#selDay").html(dayOption);
//       }
//    });
// }
</script>
</html>