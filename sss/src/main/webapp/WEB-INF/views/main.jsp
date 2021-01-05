<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<title>Triple S</title>
<link rel="stylesheet" href="../resources/style.css">
<link rel="stylesheet" href="../resources/icono.css">
<%
   GregorianCalendar cal = new GregorianCalendar();
   String thisYear = cal.get(GregorianCalendar.YEAR)+"";
   String thisMonth = cal.get(GregorianCalendar.MONTH)+1+"";
   String thisDay = cal.get(GregorianCalendar.DAY_OF_MONTH)+"";
%>
</head>
<style>
	
   #btnUpdate{margin-left:10px;margin-top:10px;}
   #calendar {width:1344px; overflow:hidden;margin-left:50px;margin-top:20px; border:solid 1px white;}
   .wom1, .wom2, .wom3, .wom4, .wom5, .wom6 {width:190px; height:130px; float:left; border:solid 1px #EAEAEA; background-color:white;}
   #datePage {overflow: hidden;margin:15px 0px 0px 380px;height:60px;width:600px; text-align:center;}
   #pre, #next, #sel {width:200px; float:left;}
   #sel {overflow:hidden;}
   #selYear, #selMonth, #btn {float:left;}
   
   #costDetail {overflow:hidden; width:400px;}
   .costAccountName, .costAmount, .total, .monthlyCost {float:left;}
   .costAccountName {width:200px;}
   .costAmount {width:200px;}
   .total {width:200px;}
   .monthlyCode {width:200px;}
   #data {overflow:hidden; width:1600px;}
   #calendarView, #costDetail {float:left;}
   #calendarView {width:1344px;}
   #costDetail {margin-left:20px; width:400px;}
   .pleaseData {height:100px;}
   #costList{width:200px;height:350px;float:right;padding:30px 15px 30px 15px; font-size:20px;
   margin-top:100px;margin-bottom:150px;}
   #detail{float:right;height:309;font-size:20px;}
 
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
	background-color: #0000FF;
	box-shadow: 0 5px #808080;
	transform: translateY(4px);
} 
#preMonth:hover {
     background-color: hsl(190, 100%, 70%);
}
#preMonth:active {
    background-color: #0000FF;
	box-shadow: 0 5px #808080;
	transform: translateY(4px);
}
#nextMonth:hover {
  	background-color: hsl(190, 100%, 70%);
}
#nextMonth:active {
  	background-color: #0000FF;
	box-shadow: 0 5px #808080;
	transform: translateY(4px);
}
#nextYear:hover {
    background-color: hsl(190, 100%, 70%);
}
#nextYear:active {
   	background-color: #0000FF;
	box-shadow: 0 5px #808080;
	transform: translateY(4px);
}

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
  font-size:15px;
  
  
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  border: 1px solid #597484;
  border-radius: 5px;
  text-align:center;
  }
  .selDate{text-align:center;}
  #frm{width:600px;height:600px; float:left;margin-left:20px;}
  #frm1{width:600px;height:300px; float:left;margin-left:20px;}
  #divCenter {
	width: 1450px;
	height: 950px;
	margin-top: 170px;
	margin-left: 230px;
	background-color:#F6F6F6;
	border:1px solid #597484;
}
	*:focus { outline: none; }

	span {color:black;}
	
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
			<br/>
			<br/>
				
		</div>
	</div>
	<div id="divCenter">
	<div id="datePage">
   <div id="pre">
      <button type="button" value="preYear" id="preYear"><i class="icono-rewind"></i></button> 
	  <button type="button" value="preMonth" id="preMonth"><i class="icono-caretLeft"></i></button>
   </div>
   <div id="sel">
      <div id="selYear"	></div>
      <div id="selMonth"></div>
      <div id="btn"><input type="hidden" id="btn"></div>
   </div>
   <div id="next">
      <button type="button" value="nextMonth" id="nextMonth"><i class="icono-caretRight"></i></button>
	  <button type="button" value="nextYear" id="nextYear"><i class="icono-forward"></i></button>
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
</div>
	<div id="footer"><jsp:include page="footer.jsp" /></div>
</body>
	<script>
	
		var monthlyCost;
		getYear();
		var year = <%=thisYear%>-1;
		getMonth();
		var month = <%=thisMonth%>;
		var date = year +"/"+ month;
		calendar();
		monthlyCost();
		costList();
		getData();
		
		function readTarget() {
			$.ajax({
				type:"get",
				url:"readTarget.json",
				data:{"date":date},
				success:function(data) {
					if(data == 0) {
						var targetSales = prompt("이번달 목표 매출액");
						alert(targetSales);
						var targetCost = prompt("이번달 예상 비용");
						alert(targetCost);
					}
				}
			});
		}

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
																											color : 'red'
																										},
																										1 : {
																											color : 'green'
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
//		          alert(addCalendar);
		         $("#calendarView").html(addCalendar);
		         $("#btn").click();
		      }
		   });
		}

		function getYear() {
		   var yearOption = "<select name='year' id='year' class='selDate' style='text-align:center'>";
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
	</script>
</html>