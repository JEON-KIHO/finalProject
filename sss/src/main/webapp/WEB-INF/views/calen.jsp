<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
   GregorianCalendar cal = new GregorianCalendar();
   String thisYear = cal.get(GregorianCalendar.YEAR)+"";
   String thisMonth = cal.get(GregorianCalendar.MONTH)+1+"";
   String thisDay = cal.get(GregorianCalendar.DAY_OF_MONTH)+"";
%>
</head>
<style>
   #calendar {width:1344px; overflow:hidden; left:10%;margin-top:50px;}
   .wom1, .wom2, .wom3, .wom4, .wom5, .wom6 {width:190px; height:130px; float:left; border:solid 1px black;}
   #datePage {overflow:hidden;margin-top:20px;margin-left:650px;}
   #pre, #next, #sel {width:200px; float:left;}
   #sel {overflow:hidden;}
   #selYear, #selMonth, #btn {float:left;}
   #costDetail {overflow:hidden; width:400px;}
   .costAccountName, .costAmount, .total, .monthlyCost {float:left;}
   .costAccountName {width:200px;}
   .costAmount {width:200px;}
   .total {width:200px;}
   .monthlyCode {width:200px;}
   #data {overflow:hidden; width:1900px;}
   #calendarView, #costDetail {float:left;}
   #calendarView {width:1344px;margin-left:250px;}
   #costDetail {margin-left:20px; width:400px;}
   .pleaseData {height:100px;}
   #costList{width:200px;height:350px;float:right;padding:30px 15px 30px 15px; font-size:20px;
   margin-top:100px;margin-bottom:150px;}
   #detail{float:right;height:309;font-size:20px;}
   #darken-background {
 position:absolute;
 top:0px;
 left:0px;
 right:0px;
 height:100%;
 display:none;
 background:rgba(0, 0, 0, 0.5);
 z-index:10000;
 overflow-y:scroll;
 }
 #lightbox {
 width:900px;
 margin:20px auto;
 padding:15px;
 border-radius:5px;
 background:white;
 box-shadow:0px 5px 5px rgba(34, 25, 25, 0.4);
 text-align:center;
 overflow:hidden;
 
 }
#typeList{border:1px solid black;width:850px;margin-top:50px;padding:20px 0px 20px 0px;}

select {
  width: 100px;
  padding: .8em .5em;
  font-family: inherit;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  border: 1px solid #597484;
  border-radius: 0px;
  }
  #frm{width:600px;height:600px; float:left;margin-left:20px;}
  #frm1{width:600px;height:300px; float:left;margin-left:20px;}
</style>
<body>
<div id="datePage">
   <div id="pre">
      <input type="button" value="preYear" id="preYear">
      <input type="button" value="preMonth" id="preMonth">
   </div>
   <div id="sel">
      <div id="selYear"	></div>
      <div id="selMonth"></div>
      <div id="btn"><input type="hidden" id="btn"></div>
   </div>
   <div id="next">
      <input type="button" value="nextMonth" id="nextMonth">
      <input type="button" value="nextYear" id="nextYear">
   </div>
</div>
<!--라이트 박스-->
<div id="darken-background">
 <div id="lightbox">
 <button id="btnCancel" 
style="border: 0; background: white; color: gray; font-size: 20px; float: right; color: gray;">X</button>
 <div id="frm"></div>
 <div id="detail"></div>
 <div id="frm1"></div>
 </div>
 </div>
<div id="data">
   <div id="calendarView"></div>
   <div id="costDetail"></div>
</div>

</body>
<script>
var monthlyCost;
getYear();
var year = <%=thisYear%>-1;
getMonth();
var month = <%=thisMonth%>;
var date = year +"/"+ month;
// getDay();
calendar();
monthlyCost();
costList();
getData();
// salesTotal();
// refundTotal();
// costTotal();
// payTypeList();



// $("#calendarView").on("click", "#calendar [name=wom]", function() {
// 	   date = $(this).find(".pleaseData").attr("id");
// 	   getData();
	   
// 	});


$(document).ready(function(){
	 function showLight(){
	  $("#darken-background").show();
	 }
	 function hideLight(){
		$("#darken-background").hide();
	 }
	 $("#data").on("click", "#calendarView #calendar [name=wom] .pleaseData", function() {
		if($(this).html()) {
			showLight();
		}
	});
	 $("#btnCancel").on("click", function() {
		 hideLight();
	 });
	 $("#frm").on("click", function() {
		 hideLight();
	 });
});

$("#calendarView").on("click", "#calendar [name=wom]", function() {
	   date = $(this).find(".pleaseData").attr("id");
	   getData();
	});



$("#btn").on("click", function() {
   date = year +"/"+ month;
   monthlyCost();
   costList();
});
//매출,환불총액
$("#calendarView").on("click", "#calendar [name=wom] .pleaseData", function() {
	var date = $(this).attr("id");
	$.ajax({
		type:"get",
		url:"costrefundList.json",
		data:{"date":date},
		success:function(result) {
			function changeChart() {
				google.charts.load('current',{'packages' : [ 'corechart' ]});
				google.charts.setOnLoadCallback(drawVisualization);
				function drawVisualization() {
					var data = google.visualization.arrayToDataTable(result); /* 데이터 셋팅 */
					var options = {vAxis : {},
							hAxis : {
								maxValue : 100000000,
								minValue : 0,
								ticks : ['0%','100%' ]
									},
								series : {
									0 : {color : 'pink'},
									1 : {color : 'lightgray'},
									},
								bar : {groupWidth : '40%' // 그래프 너비 설정 %
									// 그래프 너비 설정 %
									},
								legend : 'none'
									}; /* 옵션 셋팅 */
									var chart = new google.visualization.BarChart(document.getElementById('frm1'));
									chart.draw(data,options); /* 차트 그리기 */
				}
				
			}
			getData();
			$("#frm1").html(changeChart());
			
		}
		
	});
	
});
$("#calendarView").on("click", "#calendar [name=wom] .pleaseData", function() {
	var date = $(this).attr("id");
	$.ajax({
		type:"get",
		url:"categoryList.json",
		data:{"date":date},
		success:function(result) {
			function changeChart() {
				google.charts.load('current',{'packages' : [ 'corechart' ]});
				google.charts.setOnLoadCallback(drawVisualization);
				function drawVisualization() {
					var data = google.visualization.arrayToDataTable(result); /* 데이터 셋팅 */
					var options = {vAxis : {},
							hAxis : {
								maxValue : 100000000,
								minValue : 0,
								ticks : ['0%','100%' ]
									},
								series : {
									0 : {color : 'pink'},
									1 : {color : 'lightgray'},
									2 : {color : 'red'},
									},
								bar : {groupWidth : '70%' // 그래프 너비 설정 %
									// 그래프 너비 설정 %
									},
								legend : 'none'
									}; /* 옵션 셋팅 */
									var chart = new google.visualization.BarChart(document.getElementById('frm'));
									chart.draw(data,options); /* 차트 그리기 */
				}
				
			}
			getData();
			$("#frm").html(changeChart());
			
		}
		
	});
	
});

// $("#calendarView").on("click", "#calendar [name=wom] .pleaseData", function() {
// 	var date = $(this).attr("id");
// 	var scnt = 0;
// 	var rcnt = 0;
// 		$.ajax({
// 			type : "get",
// 			url : "payTypeList.json",
// 			data : {
// 				"date" : date
// 			},
// 			success : function(data) {
// 					var str = "<div id='typeList'>";
// 				$(data).each(function(){
// 					if(this.SALESTYPE == "매출"){
// 						if(scnt == 0) {
// 							str+="<div>매출별 총금액</div>";
// 							scnt++;
// 						}
// 						str+="<div>"+this.PAYTYPE+"</div>";
// 						str+="<div>"+this.SALESAMOUNT+"</div>";

// 					}
// 					if(this.SALESTYPE == "환불") {
// 						if(rcnt == 0) {
// 							str+="<div>환불별 총금액</div>";
// 							rcnt++;
// 						}
// 						str+="<div>"+this.PAYTYPE+"</div>";
// 						str+="<div>"+this.REFUNDAMOUNT+"</div>";
// 					}
// 					if(this.COSTTOTAL != null) {
// 						str+="<div>비용별 총금액</div>";
// 						str+="<div>"+this.COSTTOTAL+"</div>";
// 					}
// 				});
// 				str += "</div>";
//  				$("#frm").html(str);
// 			}
// 		});
// });

$("#sel").on("change", "#selYear #year", function() {
   year = $(this).val();
   getMonth();
   month = $(this).parent().parent().find("#selMonth").find("#month").val();
   date = year+"/"+month;
   $("#costDetail").html("");
   calendar();
   costList();
});

$("#sel").on("change", "#selMonth #month", function() {
   year = $(this).parent().parent().find("#selYear").find("#year").val();
   month = $(this).val();
   date = year+"/"+month;
   $("#costDetail").html("");
   calendar();
   costList();
});

$("#preYear").on("click", function() {
   year--;
   $("#sel #selYear #year").val(year).prop("selected", true);
   date = year +"/"+ month;
   $("#costDetail").html("");
   calendar();
   costList();
});

$("#nextYear").on("click", function() {
   year++;
   $("#sel #selYear #year").val(year).prop("selected", true);
   date = year +"/"+ month;
   $("#costDetail").html("");
   calendar();
   costList();
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
   costList();
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
   costList();
});

	
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
	         
	         addCost += "</div>";
	         addCost += "<div class='totalCost' style='color:red'>비용 총액</div>"+amountFormat+"원";
	         $("#detail").html(addCost);
	      }
	   });
	}


function costList() {
	var date = year + "/" + month;
	$.ajax({
				type : "get",
				url : "costList.json",
				data : {
					"date" : date
				},
				success : function(data) {
					$(data).each(function() {
										var amount = this.costAmount;
										var costYear = this.day.split("-")[0];
										var costMonth = this.day.split("-")[1];
										var costDay = this.day.split("-")[2]
												.substring(0, 2);
										var date = costYear + "/"
												+ costMonth + "/" + costDay;
										$("#calendarView").find("#calendar").find("[name=wom]").each(function() {
															if ($(this).find(".pleaseData").attr("id") == date) {
																function changeChart() {
																	google.charts.load('current',{'packages' : [ 'corechart' ]});
																	google.charts.setOnLoadCallback(drawVisualization);
																	function drawVisualization() {
																		$.ajax({
																					type : "get",
																					url : "GraphList.json",
																					dataType : "json",
																					data : {
																						"date" : date
																					},
																					success : function(
																							result) {
																						//                                    var result = [["과목","점수"],["국어",90],["영어",80]];
																						var data = google.visualization
																								.arrayToDataTable(result); /* 데이터 셋팅 */
																						var options = {
																							vAxis : {},
																							hAxis : {
																								maxValue : 100000000,
																								minValue : 0,
																								ticks : [
																										'0%',
																										'100%' ]
																							},
																							series : {
																								0 : {
																									color : '#7D444A'
																								},
																								1 : {
																									color : '#F7E7DE'
																								},
																								2 : {
																									color : 'blue'
																								},

																							},
																							bar : {
																								groupWidth : '70%' // 그래프 너비 설정 %
																							},
																							legend : 'none'
																						}; /* 옵션 셋팅 */
																						
																						var chart = new google.visualization.BarChart(
																								document
																										.getElementById(date));
																						chart
																								.draw(
																										data,
																										options); /* 차트 그리기 */
																						
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
function salesTotal() {
	var date = year + "/" + month +"/"+ day;
	var amount = 0;
	$.ajax({
		type : "get",
		url : "GraphList.json",
		data : {
			"date" : date
		},
		success : function(data) {
			$(data).each(function() {
				amount = amount + this.salesTotal;
			});
			salesTotal = amount;
		}
	});
}
function refundTotal() {
	var date = year + "/" + month +"/"+ day;
	var amount = 0;
	$.ajax({
		type : "get",
		url : "GraphList.json",
		data : {
			"date" : date
		},
		success : function(data) {
			$(data).each(function() {
				amount = amount + this.refundTotal;
			});
			refundTotal = amount;
		}
	});
}
function costTotal() {
	var date = year + "/" + month +"/"+ day;
	var amount = 0;
	$.ajax({
		type : "get",
		url : "GraphList.json",
		data : {
			"date" : date
		},
		success : function(data) {
			$(data).each(function() {
				amount = amount + this.costTotal;
			});
			costTotal = amount;
		}
	});
}
// function getData() {
//    var amount = 0;
//    var addCost = "<div id='costList'>";
//    $.ajax({
//       type:"get",
//       url:"dataList.json",
//       data:{"date":date},
//       success:function(data) {
//          $(data).each(function() {
//             var costAccountName = this.COSTACCOUNTNAME;
//             var costAmount = this.COSTAMOUNT;
//             amount = amount + costAmount;
//             addCost += "<div class='costAccountName'>"+costAccountName+"</div>";
//             var costAmountFormat = costAmount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
//             addCost += "<div class='costAmount'>"+costAmountFormat+"원</div>";
//          });
//          var amountFormat = amount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
//          addCost += "<div class='total'>비용 총액</div><div class='monthlyCost'>"+amountFormat+"원</div>";
//          addCost += "</div>";
//          $("#costDetail").html(addCost);
//       }
//    });
// }

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