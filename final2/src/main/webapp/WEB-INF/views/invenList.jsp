<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../resources/style.css">
<link rel="stylesheet" href="../resources/icono.css">
<title> INVEN LIST </title>
<style>
   #datePage {overflow:hidden; margin-top:50px; margin-left:50px; margin-right:50px; height:45px;}
   #pre, #next, #sel {width:300px; float:left;}
   #sel {overflow:hidden;}
   #selYear, #selMonth, #btn {float:left;}
   #pre {text-align:center;}
   #next{text-align:center;}
   
   #inven {text-align:center; margin-left:40px; margin-top:50px; font-size:25px;}
   #invenList {width:900px; overflow:hidden;}
   .invenAccountName {width:300px; float:left;}
   .startInven, .invenIn, .invenOut, .endInven {width:130px; float:left;}
   
   #insertInven {text-align:center;}
   
   #calendar {width:308px; overflow:hidden; left:10%;}
   .none {width:42px; height:50px; float:left; margin:1px;}
   .wom1, .wom2, .wom3, .wom4, .wom5, .wom6 {width:40px; height:50px; float:left; border:dotted 1px black; margin:1px;}
 #divCenter {
   width: 1000px;
   height: 950px;
   margin-top: 170px;
   margin-left: 430px;
   background-color:#F6F6F6;
   border:1px solid #597484;
}
*:focus { outline: none; }
select {
   width: 100px;
   padding: .5em .3em;
   font-size: 15px;
   -webkit-appearance: none;
   -moz-appearance: none;
   appearance: none;
   border: 1px solid #597484;
   border-radius: 5px;
   text-align: center;
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

</style>
<%
   GregorianCalendar cal = new GregorianCalendar();
   String thisYear = cal.get(GregorianCalendar.YEAR)+"";
   String thisMonth = cal.get(GregorianCalendar.MONTH)+1+"";
   String thisDay = cal.get(GregorianCalendar.DAY_OF_MONTH)+"";
%>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<jsp:include page="menu.jsp"></jsp:include>

<div id="divCenter">
<div id="datePage">
   <div id="pre">
     <button type="button" value="preYear" id="preYear"><i class="icono-rewind"></i></button> 
	 <button type="button" value="preMonth" id="preMonth"><i class="icono-caretLeft"></i></button>
   </div>
   <div id="sel">
      <div id="selYear"></div>
      <div id="selMonth"></div>
      <div id="selDay"></div>
      <input type="hidden" id="btn">
   </div>
   <div id="next">
     <button type="button" value="nextMonth" id="nextMonth"><i class="icono-caretRight"></i></button>
	 <button type="button" value="nextYear" id="nextYear"><i class="icono-forward"></i></button>
   </div>
</div>
<div id="inven"></div>
</div>
	

<div id="footer"><jsp:include page="footer.jsp" /></div>
<!-- <table id="insertInven"></table> -->

<!-- <div id="calendarView"></div> -->

<script>
getDate();
var year = <%=thisYear%>;
var month = <%=thisMonth%>;
var day = <%=thisDay%>;
for(var i = 1; i <= 9; i++) {
   if(day == i) {
      day = "0" + day;
   }
}
endInvenList();
calendar();
<%-- var year = <%=thisYear%>-1; --%>
// getMonth();
<%-- var month = <%=thisMonth%>; --%>
// var date = year +"/"+ month;
// getDay();
<%-- var day = <%=thisDay%>; --%>

// $("#btn").on("click", function() {
//    getInvenList();
// });

$("#calendarView").on("click", "#calendar [name=wom]", function() {
   alert($(this).find(".pleaseData").attr("id"));
});

$("#sel").on("change", "#selYear #year", function() {
   year = $(this).val();
   getMonth();
   month = $(this).parent().parent().find("#selMonth").find("#month").val();
   day = $(this).parent().parent().find("#selDay").find("#day").val();
   value = "year";
   getInvenList();
});

$("#sel").on("change", "#selMonth #month", function() {
   year = $(this).parent().parent().find("#selYear").find("#year").val();
   month = $(this).val();
   value = "month";
   getDay();
   day = $(this).parent().parent().find("#selDay").find("#day").val();
   getInvenList();
});

$("#sel").change("#selDay #day", function() {
   year = $(this).parent().parent().find("#selYear").find("#year").val();
   month = $(this).parent().parent().find("#selMonth").find("#month").val();
   day = $("#sel").find("#selDay").find("#day").val();
   value = "day";
   getInvenList();
});

$("#preYear").on("click", function() {
   year--;
   $("#sel #selYear #year").val(year).prop("selected", true);
   getMonth();
   month = $("#sel").find("#selMonth").find("#month option:selected").val();
   day = $("#sel").find("#selDay").find("#day option:selected").val();
   getInvenList();
});

$("#nextYear").on("click", function() {
   year++;
   $("#sel #selYear #year").val(year).prop("selected", true);
   getMonth();
   month = $("#sel").find("#selMonth").find("#month option:selected").val();
   day = $("#sel").find("#selDay").find("#day option:selected").val();
   getInvenList();
});

// $("#preMonth").on("click", function() {
//    if(month == 01 || month == 1) {
//       year--;
//       month = "12";
//       $("#sel #selYear #year").val(year).prop("selected", true);
//       $("#sel #selMonth #month").val(month).prop("selected", true);
//    } else {
//       month--;
//       for(var i = 1; i <= 9; i++) {
//          if(month == i) {
//             month = "0" + i;
//          }
//       }
//       $("#sel #selMonth #month").val(month).prop("selected", true);
//    }
//    getDay();
//    getInvenList();
// });

// $("#nextMonth").on("click", function() {
//    if(month == 12) {
//       year++;
//       month = "01";
//       $("#sel #selYear #year").val(year).prop("selected", true);
//       $("#sel #selMonth #month").val(month).prop("selected", true);
//    } else {
//       month++;
//       for(var i = 1; i <= 9; i++) {
//          if(month == i) {
//             month = "0" + i;
//          }
//       }
//       $("#sel #selMonth #month").val(month).prop("selected", true);
//    }
//    getDay();
//    getInvenList();
// });

// function calendar() {
//    var date = year +"/"+ month;
//    var addCalendar = "<div id='calendar'>";
//    var cnt = 0;
//    var cnt1 = 0;
//    $.ajax({
//       url:"daily.json",
//       type:"get",
//       data:{"date":date},
//       success:function(data) {
//          $(data).each(function() {
//             if(this.dow == 1) {
//                cnt++;
//             }
//          });
         
//          if(cnt != 7) {
//             for(var i = 0; i <7-cnt; i++) {
//                addCalendar += "<div class='none'></div>";
//             }
//          }
         
//          $(data).each(function() {
//             if(this.dow == 1) {
//                addCalendar += "<div class='wom1' name='wom' style='color:black;'>"+this.day.split("-")[2].substring(0,2)+"<div class='pleaseData' id='"+date+"/"+this.day.split("-")[2].substring(0,2)+"'></div></div>";
//             }
//             if(this.dow == 2) {
//                addCalendar += "<div class='wom2' name='wom' style='color:black;'>"+this.day.split("-")[2].substring(0,2)+"<div class='pleaseData' id='"+date+"/"+this.day.split("-")[2].substring(0,2)+"'></div></div>";
//             }
//             if(this.dow == 3) {
//                addCalendar += "<div class='wom3' name='wom' style='color:black;'>"+this.day.split("-")[2].substring(0,2)+"<div class='pleaseData' id='"+date+"/"+this.day.split("-")[2].substring(0,2)+"'></div></div>";
//             }
//             if(this.dow == 4) {
//                addCalendar += "<div class='wom4' name='wom' style='color:black;'>"+this.day.split("-")[2].substring(0,2)+"<div class='pleaseData' id='"+date+"/"+this.day.split("-")[2].substring(0,2)+"'></div></div>";
//             }
//             if(this.dow == 5) {
//                addCalendar += "<div class='wom5' name='wom' style='color:black;'>"+this.day.split("-")[2].substring(0,2)+"<div class='pleaseData' id='"+date+"/"+this.day.split("-")[2].substring(0,2)+"'></div></div>";
//             }
//             if(this.dow == 6) {
//                addCalendar += "<div class='wom6' name='wom' style='color:black;'>"+this.day.split("-")[2].substring(0,2)+"<div class='pleaseData' id='"+date+"/"+this.day.split("-")[2].substring(0,2)+"'></div></div>";
//             }
//          });
//          addCalendar += "</div>";
// //          alert(addCalendar);
//          $("#calendarView").html(addCalendar);
//          $("#btn").click();
//       }
//    });
// }

// function endInvenList() {
//    var addList = "<tr><td width=300>품목</td><td width=80>기초재고</td><td width=80>입고</td><td width=80>출고</td><td width=80>기말재고</td></tr>";
//    $.ajax({
//       type:"get",
//       url:"endInvenList.json",
//       success:function(data) {
//          $(data).each(function() {
//             var name = this.INVENACCOUNTNAME.split("/")[1];
//             var inven = this.ENDINVEN;
//             addList += "<tr class='list'>";
//             addList += "<td>"+name+"</td>";
//             addList += "<td class='inven'>"+inven+"</td>";
//             addList += "<td class='tdInvenIn'><input type='text' name='invenIn' class='ipInvenIn' size=2></td>";
//             addList += "<td class='tdInvenOut'><input type='text' name='invenOut' class='ipInvenOut' size=2></td>";
//             addList += "<td class='tdEndInven'><input type='text' name='endInven' class='ipEndInven' size=2 value='"+inven+"' readonly></td>";
//             addList += "</tr>";
            
//          });
//          $("#insertInven").html(addList);
         
//       }
//    });
// }

// $("#insertInven").on("keyup", ".list .tdInvenIn .ipInvenIn",function() {
//    var list = $(this).parent().parent();
//    var ipEndInven = list.find(".tdEndInven").find(".ipEndInven");
//    var startInven = list.find(".inven").html();
//    var invenIn = $(this).val();
//    if(list.find(".tdInvenOut").find(".ipInvenOut").val() != "") {
//       var invenOut = list.find(".tdInvenOut").find(".ipInvenOut").val();
//       var amount = parseInt(startInven) + parseInt(invenIn) - parseInt(invenOut);
//       if(!isNaN(amount)) {
//          ipEndInven.val(amount);
//       }
//       if(isNaN(amount)) {
//          ipEndInven.val(parseInt(startInven) - parseInt(invenOut));
//       }
//    }
//    if(list.find(".tdInvenOut").find(".ipInvenOut").val() == "") {
//       var amount = parseInt(startInven) + parseInt(invenIn);
      
//       if(!isNaN(amount)) {
//          ipEndInven.val(amount);
//       }
//       if(isNaN(amount)) {
//          ipEndInven.val("");
//       }
//    }
//    if(ipEndInven.val() == "") {
//       ipEndInven.val(startInven);
//    }
// });

// $("#insertInven").on("keyup", ".list .tdInvenOut .ipInvenOut",function() {
//    var list = $(this).parent().parent();
//    var ipEndInven = list.find(".tdEndInven").find(".ipEndInven");
//    var startInven = list.find(".inven").html();
//    var invenOut = $(this).val();
//    if(!isNaN(list.find(".tdInvenIn").find(".ipInvenIn").val())) {
//       var invenIn = list.find(".tdInvenIn").find(".ipInvenIn").val();
//       var amount = parseInt(startInven) + parseInt(invenIn) - parseInt(invenOut);
//       if(!isNaN(amount)) {
//          ipEndInven.val(amount);
//       }
//       if(isNaN(amount)) {
//          ipEndInven.val(parseInt(startInven) + parseInt(invenIn));
//       }
//    }
//    if(list.find(".tdInvenIn").find(".ipInvenIn").val() == "") {
//       var amount = parseInt(startInven) - parseInt(invenOut);
//       if(!isNaN(amount)) {
//          ipEndInven.val(amount);
//       }
//       if(isNaN(amount)) {
//          ipEndInven.val("");
//       }
//    }
//    if(ipEndInven.val() == "") {
//       ipEndInven.val(startInven);
//    }
// });


function getDate() {
   var yearOption = "<select name='year' id='year' class='selDate'>";
   var monthOption = "<select name='month' id='month' class='selDate'>";
   var dayOption = "<select name='day' id='day' class='selDate'>";
   var addInven = "<div id='invenList'>";
   addInven += "<div class='invenAccountName'>재고 품목</div>";
   addInven += "<div class='startInven'>기초 재고</div>";
   addInven += "<div class='invenIn'>입고</div>";
   addInven += "<div class='invenOut'>출고</div>";
   addInven += "<div class='endInven'>기말 재고</div>";
   var daily;
   var y = 0;
   var m = 0;
   var d = 0;
   $.ajax({
      type:"get",
      url:"invenDailyYear.json",
      dataType:"json",
      success:function(data) {
         $(data).each(function() {
            daily = this.day;
            var year = daily.split("-")[0];
            var oldY = year;
            if(oldY != y) {
               yearOption += "<option value='"+oldY+"'>"+oldY+"</option>";
            }
            y = oldY;
         });
         yearOption += "</select>";
         $("#selYear").html(yearOption);
         $("#sel").find("#selYear").find("#year").val(<%=thisYear%>).prop("selected", true);
         var year = $("#sel").find("#selYear").find("#year option:selected").val();
         $.ajax({
            type:"get",
            url:"invenDailyMonth.json",
            dataType:"json",
            data:{"date":year},
            success:function(data) {
               $(data).each(function() {
                  daily = this.day;
                  var month = daily.split("-")[1];
                  var oldM = month;
                  if(oldM != m) {
                     monthOption += "<option value='"+oldM+"'>"+oldM+"</option>";
                  }
                  m = oldM;
               });
               monthOption += "</select>";
               $("#selMonth").html(monthOption);
               $("#sel").find("#selMonth").find("#month").val(m).prop("selected", true);
            
                  var month = $("#sel").find("#selMonth").find("#month option:selected").val();
                  var date = year +"/"+ month;
                  $.ajax({
                     type:"get",
                     url:"invenDaily.json",
                     dataType:"json",
                     data:{"date":date},
                     success:function(data) {
                        $(data).each(function() {
                           daily = this.day;
                           var day = daily.split("-")[2].substring(0,2);
                           var oldD = day;
                           if(oldD != d) {
                              dayOption += "<option value='"+oldD+"'>"+oldD+"</option>";
                           }
                           d = oldD;
                        });
                        dayOption += "</select>";
                        $("#selDay").html(dayOption);
                        $("#sel").find("#selDay").find("#day").val(d).prop("selected", true);
                        for(var i = 1; i <= 9; i++) {
                           if(day == i) {
                              day = "0" + day;
                           }
                        }
                        var day = $("#sel").find("#selDay").find("#day option:selected").val();
                        var date = year +"/"+ month +"/"+ day;
                        $.ajax({
                           type:"get",
                           url:"invenList.json",
                           data:{"date":date},
                           success:function(data) {
                              $(data).each(function() {
                                 addInven += "<div class='invenAccountName'>"+this.INVENACCOUNTNAME+"</div>";
                                 addInven += "<div class='startInven'>"+this.STARTINVEN+"</div>";
                                 addInven += "<div class='invenIn'>"+this.INVENIN+"</div>";
                                 addInven += "<div class='invenOut'>"+this.INVENOUT+"</div>";
                                 addInven += "<div class='endInven'>"+this.ENDINVEN+"</div>";
                              });
                              addInven += "</div>";
                              $("#inven").html(addInven);
                           }
                        });
                     }
                  });
               }
         });
      }
   });
}

function getMonth() {
   var monthOption = "<select name='month' id='month' class='selDate'>";
   var dayOption = "<select name='day' id='day' class='selDate'>";
   var addInven = "<div id='invenList'>";
   addInven += "<div class='invenAccountName'>재고 품목</div>";
   addInven += "<div class='startInven'>기초 재고</div>";
   addInven += "<div class='invenIn'>입고</div>";
   addInven += "<div class='invenOut'>출고</div>";
   addInven += "<div class='endInven'>기말 재고</div>";
   var daily;
   var m = 0;
   var d = 0;
   $.ajax({
      type:"get",
      url:"invenDailyMonth.json",
      dataType:"json",
      data:{"date":year},
      success:function(data) {
         $(data).each(function() {
            daily = this.day;
            var month = daily.split("-")[1];
            var oldM = month;
            if(oldM != m) {
               monthOption += "<option value='"+oldM+"'>"+oldM+"</option>";
            }
            m = oldM;
         });
         monthOption += "</select>";
         $("#selMonth").html(monthOption);
         $("#sel").find("#selMonth").find("#month").val(m).prop("selected", true);
      
            var month = $("#sel").find("#selMonth").find("#month option:selected").val();
            var date = year +"/"+ month;
            $.ajax({
               type:"get",
               url:"invenDaily.json",
               dataType:"json",
               data:{"date":date},
               success:function(data) {
                  $(data).each(function() {
                     daily = this.day;
                     var day = daily.split("-")[2].substring(0,2);
                     var oldD = day;
                     if(oldD != d) {
                        dayOption += "<option value='"+oldD+"'>"+oldD+"</option>";
                     }
                     d = oldD;
                  });
                  dayOption += "</select>";
                  $("#selDay").html(dayOption);
                  $("#sel").find("#selDay").find("#day").val(d).prop("selected", true);
                  for(var i = 1; i <= 9; i++) {
                     if(day == i) {
                        day = "0" + day;
                     }
                  }
                  var day = $("#sel").find("#selDay").find("#day option:selected").val();
                  var date = year +"/"+ month +"/"+ day;
                  $.ajax({
                     type:"get",
                     url:"invenList.json",
                     data:{"date":date},
                     success:function(data) {
                        $(data).each(function() {
                           addInven += "<div class='invenAccountName'>"+this.INVENACCOUNTNAME+"</div>";
                           addInven += "<div class='startInven'>"+this.STARTINVEN+"</div>";
                           addInven += "<div class='invenIn'>"+this.INVENIN+"</div>";
                           addInven += "<div class='invenOut'>"+this.INVENOUT+"</div>";
                           addInven += "<div class='endInven'>"+this.ENDINVEN+"</div>";
                        });
                        addInven += "</div>";
                        $("#inven").html(addInven);
                     }
                  });
               }
            });
         }
   });
}

function getDay() {
   var dayOption = "<select name='day' id='day' class='selDate'>";
   var addInven = "<div id='invenList'>";
   addInven += "<div class='invenAccountName'>재고 품목</div>";
   addInven += "<div class='startInven'>기초 재고</div>";
   addInven += "<div class='invenIn'>입고</div>";
   addInven += "<div class='invenOut'>출고</div>";
   addInven += "<div class='endInven'>기말 재고</div>";
   var daily;
   var d = 0;
   var date = year +"/"+ month;
   $.ajax({
      type:"get",
      url:"invenDaily.json",
      dataType:"json",
      data:{"date":date},
      success:function(data) {
         $(data).each(function() {
            daily = this.day;
            var day = daily.split("-")[2].substring(0,2);
            var oldD = day;
            if(oldD != d) {
               dayOption += "<option value='"+oldD+"'>"+oldD+"</option>";
            }
            d = oldD;
         });
         dayOption += "</select>";
         $("#selDay").html(dayOption);
         $("#sel").find("#selDay").find("#day").val(d).prop("selected", true);
         for(var i = 1; i <= 9; i++) {
            if(day == i) {
               day = "0" + day;
            }
         }
         var day = $("#sel").find("#selDay").find("#day option:selected").val();
         var date = year +"/"+ month +"/"+ day;
         alert(date);
         $.ajax({
            type:"get",
            url:"invenList.json",
            data:{"date":date},
            success:function(data) {
               $(data).each(function() {
                  addInven += "<div class='invenAccountName'>"+this.INVENACCOUNTNAME+"</div>";
                  addInven += "<div class='startInven'>"+this.STARTINVEN+"</div>";
                  addInven += "<div class='invenIn'>"+this.INVENIN+"</div>";
                  addInven += "<div class='invenOut'>"+this.INVENOUT+"</div>";
                  addInven += "<div class='endInven'>"+this.ENDINVEN+"</div>";
               });
               addInven += "</div>";
               $("#inven").html(addInven);
            }
         });
      }
   });
}

function getInvenList() {
   var addInven = "<div id='invenList'>";
   addInven += "<div class='invenAccountName'>재고 품목</div>";
   addInven += "<div class='startInven'>기초 재고</div>";
   addInven += "<div class='invenIn'>입고</div>";
   addInven += "<div class='invenOut'>출고</div>";
   addInven += "<div class='endInven'>기말 재고</div>";
   var date = year +"/"+ month +"/"+ day;
   $.ajax({
      type:"get",
      url:"invenList.json",
      data:{"date":date},
      success:function(data) {
         $(data).each(function() {
            addInven += "<div class='invenAccountName'>"+this.INVENACCOUNTNAME+"</div>";
            addInven += "<div class='startInven'>"+this.STARTINVEN+"</div>";
            addInven += "<div class='invenIn'>"+this.INVENIN+"</div>";
            addInven += "<div class='invenOut'>"+this.INVENOUT+"</div>";
            addInven += "<div class='endInven'>"+this.ENDINVEN+"</div>";
         });
         addInven += "</div>";
         $("#inven").html(addInven);
      }
   });
}
</script>
</html>