/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-12-28 01:35:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.GregorianCalendar;

public final class invenList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/D:/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/ERP/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/ERP/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1604883783799L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title> INVEN LIST </title>\r\n");
      out.write("<style>\r\n");
      out.write("\t#datePage {overflow:hidden;}\r\n");
      out.write("\t#pre, #next, #sel {width:200px; float:left;}\r\n");
      out.write("\t#sel {overflow:hidden;}\r\n");
      out.write("\t#selYear, #selMonth, #btn {float:left;}\r\n");
      out.write("\t\r\n");
      out.write("\t#inven {text-align:center;}\r\n");
      out.write("\t#invenList {width:700px; overflow:hidden;}\r\n");
      out.write("\t.invenAccountName {width:300px; float:left;}\r\n");
      out.write("\t.startInven, .invenIn, .invenOut, .endInven {width:100px; float:left;}\r\n");
      out.write("\t\r\n");
      out.write("\t#insertInven {text-align:center;}\r\n");
      out.write("\t\r\n");
      out.write("\t#calendar {width:308px; overflow:hidden; left:10%;}\r\n");
      out.write("\t.none {width:42px; height:50px; float:left; margin:1px;}\r\n");
      out.write("\t.wom1, .wom2, .wom3, .wom4, .wom5, .wom6 {width:40px; height:50px; float:left; border:dotted 1px black; margin:1px;}\r\n");
      out.write("</style>\r\n");

	GregorianCalendar cal = new GregorianCalendar();
	String thisYear = cal.get(GregorianCalendar.YEAR)+"";
	String thisMonth = cal.get(GregorianCalendar.MONTH)+1+"";
	String thisDay = cal.get(GregorianCalendar.DAY_OF_MONTH)+"";

      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"datePage\">\r\n");
      out.write("\t<div id=\"pre\">\r\n");
      out.write("\t\t<input type=\"button\" value=\"preYear\" id=\"preYear\">\r\n");
      out.write("\t\t<input type=\"button\" value=\"preMonth\" id=\"preMonth\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"sel\">\r\n");
      out.write("\t\t<div id=\"selYear\"></div>\r\n");
      out.write("\t\t<div id=\"selMonth\"></div>\r\n");
      out.write("\t\t<div id=\"selDay\"></div>\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"btn\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"next\">\r\n");
      out.write("\t\t<input type=\"button\" value=\"nextMonth\" id=\"nextMonth\">\r\n");
      out.write("\t\t<input type=\"button\" value=\"nextYear\" id=\"nextYear\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"inven\"></div>\r\n");
      out.write("\r\n");
      out.write("<table id=\"insertInven\"></table>\r\n");
      out.write("\r\n");
      out.write("<!-- <div id=\"calendarView\"></div> -->\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("getDate();\r\n");
      out.write("var year = ");
      out.print(thisYear);
      out.write(";\r\n");
      out.write("var month = ");
      out.print(thisMonth);
      out.write(";\r\n");
      out.write("var day = ");
      out.print(thisDay);
      out.write(";\r\n");
      out.write("for(var i = 1; i <= 9; i++) {\r\n");
      out.write("\tif(day == i) {\r\n");
      out.write("\t\tday = \"0\" + day;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("endInvenList();\r\n");
      out.write("// calendar();\r\n");
      out.write("\r\n");
      out.write("// getMonth();\r\n");
      out.write("\r\n");
      out.write("// var date = year +\"/\"+ month;\r\n");
      out.write("// getDay();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("// $(\"#btn\").on(\"click\", function() {\r\n");
      out.write("// \tgetInvenList();\r\n");
      out.write("// });\r\n");
      out.write("\r\n");
      out.write("$(\"#calendarView\").on(\"click\", \"#calendar [name=wom]\", function() {\r\n");
      out.write("\talert($(this).find(\".pleaseData\").attr(\"id\"));\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(\"#sel\").on(\"change\", \"#selYear #year\", function() {\r\n");
      out.write("\tyear = $(this).val();\r\n");
      out.write("\tgetMonth();\r\n");
      out.write("\tmonth = $(this).parent().parent().find(\"#selMonth\").find(\"#month\").val();\r\n");
      out.write("\tday = $(this).parent().parent().find(\"#selDay\").find(\"#day\").val();\r\n");
      out.write("\tvalue = \"year\";\r\n");
      out.write("\tgetInvenList();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(\"#sel\").on(\"change\", \"#selMonth #month\", function() {\r\n");
      out.write("\tyear = $(this).parent().parent().find(\"#selYear\").find(\"#year\").val();\r\n");
      out.write("\tmonth = $(this).val();\r\n");
      out.write("\tvalue = \"month\";\r\n");
      out.write("\tgetDay();\r\n");
      out.write("\tday = $(this).parent().parent().find(\"#selDay\").find(\"#day\").val();\r\n");
      out.write("\tgetInvenList();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(\"#sel\").change(\"#selDay #day\", function() {\r\n");
      out.write("\tyear = $(this).parent().parent().find(\"#selYear\").find(\"#year\").val();\r\n");
      out.write("\tmonth = $(this).parent().parent().find(\"#selMonth\").find(\"#month\").val();\r\n");
      out.write("\tday = $(\"#sel\").find(\"#selDay\").find(\"#day\").val();\r\n");
      out.write("\tvalue = \"day\";\r\n");
      out.write("\tgetInvenList();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(\"#preYear\").on(\"click\", function() {\r\n");
      out.write("\tyear--;\r\n");
      out.write("\t$(\"#sel #selYear #year\").val(year).prop(\"selected\", true);\r\n");
      out.write("\tgetMonth();\r\n");
      out.write("\tmonth = $(\"#sel\").find(\"#selMonth\").find(\"#month option:selected\").val();\r\n");
      out.write("\tday = $(\"#sel\").find(\"#selDay\").find(\"#day option:selected\").val();\r\n");
      out.write("\tgetInvenList();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(\"#nextYear\").on(\"click\", function() {\r\n");
      out.write("\tyear++;\r\n");
      out.write("\t$(\"#sel #selYear #year\").val(year).prop(\"selected\", true);\r\n");
      out.write("\tgetMonth();\r\n");
      out.write("\tmonth = $(\"#sel\").find(\"#selMonth\").find(\"#month option:selected\").val();\r\n");
      out.write("\tday = $(\"#sel\").find(\"#selDay\").find(\"#day option:selected\").val();\r\n");
      out.write("\tgetInvenList();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("// $(\"#preMonth\").on(\"click\", function() {\r\n");
      out.write("// \tif(month == 01 || month == 1) {\r\n");
      out.write("// \t\tyear--;\r\n");
      out.write("// \t\tmonth = \"12\";\r\n");
      out.write("// \t\t$(\"#sel #selYear #year\").val(year).prop(\"selected\", true);\r\n");
      out.write("// \t\t$(\"#sel #selMonth #month\").val(month).prop(\"selected\", true);\r\n");
      out.write("// \t} else {\r\n");
      out.write("// \t\tmonth--;\r\n");
      out.write("// \t\tfor(var i = 1; i <= 9; i++) {\r\n");
      out.write("// \t\t\tif(month == i) {\r\n");
      out.write("// \t\t\t\tmonth = \"0\" + i;\r\n");
      out.write("// \t\t\t}\r\n");
      out.write("// \t\t}\r\n");
      out.write("// \t\t$(\"#sel #selMonth #month\").val(month).prop(\"selected\", true);\r\n");
      out.write("// \t}\r\n");
      out.write("// \tgetDay();\r\n");
      out.write("// \tgetInvenList();\r\n");
      out.write("// });\r\n");
      out.write("\r\n");
      out.write("// $(\"#nextMonth\").on(\"click\", function() {\r\n");
      out.write("// \tif(month == 12) {\r\n");
      out.write("// \t\tyear++;\r\n");
      out.write("// \t\tmonth = \"01\";\r\n");
      out.write("// \t\t$(\"#sel #selYear #year\").val(year).prop(\"selected\", true);\r\n");
      out.write("// \t\t$(\"#sel #selMonth #month\").val(month).prop(\"selected\", true);\r\n");
      out.write("// \t} else {\r\n");
      out.write("// \t\tmonth++;\r\n");
      out.write("// \t\tfor(var i = 1; i <= 9; i++) {\r\n");
      out.write("// \t\t\tif(month == i) {\r\n");
      out.write("// \t\t\t\tmonth = \"0\" + i;\r\n");
      out.write("// \t\t\t}\r\n");
      out.write("// \t\t}\r\n");
      out.write("// \t\t$(\"#sel #selMonth #month\").val(month).prop(\"selected\", true);\r\n");
      out.write("// \t}\r\n");
      out.write("// \tgetDay();\r\n");
      out.write("// \tgetInvenList();\r\n");
      out.write("// });\r\n");
      out.write("\r\n");
      out.write("// function calendar() {\r\n");
      out.write("// \tvar date = year +\"/\"+ month;\r\n");
      out.write("// \tvar addCalendar = \"<div id='calendar'>\";\r\n");
      out.write("// \tvar cnt = 0;\r\n");
      out.write("// \tvar cnt1 = 0;\r\n");
      out.write("// \t$.ajax({\r\n");
      out.write("// \t\turl:\"daily.json\",\r\n");
      out.write("// \t\ttype:\"get\",\r\n");
      out.write("// \t\tdata:{\"date\":date},\r\n");
      out.write("// \t\tsuccess:function(data) {\r\n");
      out.write("// \t\t\t$(data).each(function() {\r\n");
      out.write("// \t\t\t\tif(this.dow == 1) {\r\n");
      out.write("// \t\t\t\t\tcnt++;\r\n");
      out.write("// \t\t\t\t}\r\n");
      out.write("// \t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("// \t\t\tif(cnt != 7) {\r\n");
      out.write("// \t\t\t\tfor(var i = 0; i <7-cnt; i++) {\r\n");
      out.write("// \t\t\t\t\taddCalendar += \"<div class='none'></div>\";\r\n");
      out.write("// \t\t\t\t}\r\n");
      out.write("// \t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("// \t\t\t$(data).each(function() {\r\n");
      out.write("// \t\t\t\tif(this.dow == 1) {\r\n");
      out.write("// \t\t\t\t\taddCalendar += \"<div class='wom1' name='wom' style='color:black;'>\"+this.day.split(\"-\")[2].substring(0,2)+\"<div class='pleaseData' id='\"+date+\"/\"+this.day.split(\"-\")[2].substring(0,2)+\"'></div></div>\";\r\n");
      out.write("// \t\t\t\t}\r\n");
      out.write("// \t\t\t\tif(this.dow == 2) {\r\n");
      out.write("// \t\t\t\t\taddCalendar += \"<div class='wom2' name='wom' style='color:black;'>\"+this.day.split(\"-\")[2].substring(0,2)+\"<div class='pleaseData' id='\"+date+\"/\"+this.day.split(\"-\")[2].substring(0,2)+\"'></div></div>\";\r\n");
      out.write("// \t\t\t\t}\r\n");
      out.write("// \t\t\t\tif(this.dow == 3) {\r\n");
      out.write("// \t\t\t\t\taddCalendar += \"<div class='wom3' name='wom' style='color:black;'>\"+this.day.split(\"-\")[2].substring(0,2)+\"<div class='pleaseData' id='\"+date+\"/\"+this.day.split(\"-\")[2].substring(0,2)+\"'></div></div>\";\r\n");
      out.write("// \t\t\t\t}\r\n");
      out.write("// \t\t\t\tif(this.dow == 4) {\r\n");
      out.write("// \t\t\t\t\taddCalendar += \"<div class='wom4' name='wom' style='color:black;'>\"+this.day.split(\"-\")[2].substring(0,2)+\"<div class='pleaseData' id='\"+date+\"/\"+this.day.split(\"-\")[2].substring(0,2)+\"'></div></div>\";\r\n");
      out.write("// \t\t\t\t}\r\n");
      out.write("// \t\t\t\tif(this.dow == 5) {\r\n");
      out.write("// \t\t\t\t\taddCalendar += \"<div class='wom5' name='wom' style='color:black;'>\"+this.day.split(\"-\")[2].substring(0,2)+\"<div class='pleaseData' id='\"+date+\"/\"+this.day.split(\"-\")[2].substring(0,2)+\"'></div></div>\";\r\n");
      out.write("// \t\t\t\t}\r\n");
      out.write("// \t\t\t\tif(this.dow == 6) {\r\n");
      out.write("// \t\t\t\t\taddCalendar += \"<div class='wom6' name='wom' style='color:black;'>\"+this.day.split(\"-\")[2].substring(0,2)+\"<div class='pleaseData' id='\"+date+\"/\"+this.day.split(\"-\")[2].substring(0,2)+\"'></div></div>\";\r\n");
      out.write("// \t\t\t\t}\r\n");
      out.write("// \t\t\t});\r\n");
      out.write("// \t\t\taddCalendar += \"</div>\";\r\n");
      out.write("// // \t\t\talert(addCalendar);\r\n");
      out.write("// \t\t\t$(\"#calendarView\").html(addCalendar);\r\n");
      out.write("// \t\t\t$(\"#btn\").click();\r\n");
      out.write("// \t\t}\r\n");
      out.write("// \t});\r\n");
      out.write("// }\r\n");
      out.write("endInvenList();\r\n");
      out.write("function endInvenList() {\r\n");
      out.write("\tvar addList = \"<tr><td width=300>품목</td><td width=80>기초재고</td><td width=80>입고</td><td width=80>출고</td><td width=80>기말재고</td></tr>\";\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\ttype:\"get\",\r\n");
      out.write("\t\turl:\"endInvenList.json\",\r\n");
      out.write("\t\tsuccess:function(data) {\r\n");
      out.write("\t\t\t$(data).each(function() {\r\n");
      out.write("\t\t\t\tvar name = this.INVENACCOUNTNAME.split(\"/\")[1];\r\n");
      out.write("\t\t\t\tvar inven = this.ENDINVEN;\r\n");
      out.write("\t\t\t\taddList += \"<tr class='list'>\";\r\n");
      out.write("\t\t\t\taddList += \"<td>\"+name+\"</td>\";\r\n");
      out.write("\t\t\t\taddList += \"<td class='inven'>\"+inven+\"</td>\";\r\n");
      out.write("\t\t\t\taddList += \"<td class='tdInvenIn'><input type='text' name='invenIn' class='ipInvenIn' size=2></td>\";\r\n");
      out.write("\t\t\t\taddList += \"<td class='tdInvenOut'><input type='text' name='invenOut' class='ipInvenOut' size=2></td>\";\r\n");
      out.write("\t\t\t\taddList += \"<td class='tdEndInven'><input type='text' name='endInven' class='ipEndInven' size=2 value='\"+inven+\"' readonly></td>\";\r\n");
      out.write("\t\t\t\taddList += \"</tr>\";\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#insertInven\").html(addList);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$(\"#insertInven\").on(\"keyup\", \".list .tdInvenIn .ipInvenIn\",function() {\r\n");
      out.write("\tvar list = $(this).parent().parent();\r\n");
      out.write("\tvar ipEndInven = list.find(\".tdEndInven\").find(\".ipEndInven\");\r\n");
      out.write("\tvar startInven = list.find(\".inven\").html();\r\n");
      out.write("\tvar invenIn = $(this).val();\r\n");
      out.write("\tif(list.find(\".tdInvenOut\").find(\".ipInvenOut\").val() != \"\") {\r\n");
      out.write("\t\tvar invenOut = list.find(\".tdInvenOut\").find(\".ipInvenOut\").val();\r\n");
      out.write("\t\tvar amount = parseInt(startInven) + parseInt(invenIn) - parseInt(invenOut);\r\n");
      out.write("\t\tif(!isNaN(amount)) {\r\n");
      out.write("\t\t\tipEndInven.val(amount);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(isNaN(amount)) {\r\n");
      out.write("\t\t\tipEndInven.val(parseInt(startInven) - parseInt(invenOut));\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tif(list.find(\".tdInvenOut\").find(\".ipInvenOut\").val() == \"\") {\r\n");
      out.write("\t\tvar amount = parseInt(startInven) + parseInt(invenIn);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(!isNaN(amount)) {\r\n");
      out.write("\t\t\tipEndInven.val(amount);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(isNaN(amount)) {\r\n");
      out.write("\t\t\tipEndInven.val(\"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tif(ipEndInven.val() == \"\") {\r\n");
      out.write("\t\tipEndInven.val(startInven);\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(\"#insertInven\").on(\"keyup\", \".list .tdInvenOut .ipInvenOut\",function() {\r\n");
      out.write("\tvar list = $(this).parent().parent();\r\n");
      out.write("\tvar ipEndInven = list.find(\".tdEndInven\").find(\".ipEndInven\");\r\n");
      out.write("\tvar startInven = list.find(\".inven\").html();\r\n");
      out.write("\tvar invenOut = $(this).val();\r\n");
      out.write("\tif(!isNaN(list.find(\".tdInvenIn\").find(\".ipInvenIn\").val())) {\r\n");
      out.write("\t\tvar invenIn = list.find(\".tdInvenIn\").find(\".ipInvenIn\").val();\r\n");
      out.write("\t\tvar amount = parseInt(startInven) + parseInt(invenIn) - parseInt(invenOut);\r\n");
      out.write("\t\tif(!isNaN(amount)) {\r\n");
      out.write("\t\t\tipEndInven.val(amount);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(isNaN(amount)) {\r\n");
      out.write("\t\t\tipEndInven.val(parseInt(startInven) + parseInt(invenIn));\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tif(list.find(\".tdInvenIn\").find(\".ipInvenIn\").val() == \"\") {\r\n");
      out.write("\t\tvar amount = parseInt(startInven) - parseInt(invenOut);\r\n");
      out.write("\t\tif(!isNaN(amount)) {\r\n");
      out.write("\t\t\tipEndInven.val(amount);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(isNaN(amount)) {\r\n");
      out.write("\t\t\tipEndInven.val(\"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tif(ipEndInven.val() == \"\") {\r\n");
      out.write("\t\tipEndInven.val(startInven);\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function getDate() {\r\n");
      out.write("\tvar yearOption = \"<select name='year' id='year' class='selDate'>\";\r\n");
      out.write("\tvar monthOption = \"<select name='month' id='month' class='selDate'>\";\r\n");
      out.write("\tvar dayOption = \"<select name='day' id='day' class='selDate'>\";\r\n");
      out.write("\tvar addInven = \"<div id='invenList'>\";\r\n");
      out.write("\taddInven += \"<div class='invenAccountName'>재고 품목</div>\";\r\n");
      out.write("\taddInven += \"<div class='startInven'>기초 재고</div>\";\r\n");
      out.write("\taddInven += \"<div class='invenIn'>입고</div>\";\r\n");
      out.write("\taddInven += \"<div class='invenOut'>출고</div>\";\r\n");
      out.write("\taddInven += \"<div class='endInven'>기말 재고</div>\";\r\n");
      out.write("\tvar daily;\r\n");
      out.write("\tvar y = 0;\r\n");
      out.write("\tvar m = 0;\r\n");
      out.write("\tvar d = 0;\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\ttype:\"get\",\r\n");
      out.write("\t\turl:\"invenDailyYear.json\",\r\n");
      out.write("\t\tdataType:\"json\",\r\n");
      out.write("\t\tsuccess:function(data) {\r\n");
      out.write("\t\t\t$(data).each(function() {\r\n");
      out.write("\t\t\t\tdaily = this.day;\r\n");
      out.write("\t\t\t\tvar year = daily.split(\"-\")[0];\r\n");
      out.write("\t\t\t\tvar oldY = year;\r\n");
      out.write("\t\t\t\tif(oldY != y) {\r\n");
      out.write("\t\t\t\t\tyearOption += \"<option value='\"+oldY+\"'>\"+oldY+\"</option>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\ty = oldY;\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tyearOption += \"</select>\";\r\n");
      out.write("\t\t\t$(\"#selYear\").html(yearOption);\r\n");
      out.write("\t\t\t$(\"#sel\").find(\"#selYear\").find(\"#year\").val(");
      out.print(thisYear);
      out.write(").prop(\"selected\", true);\r\n");
      out.write("\t\t\tvar year = $(\"#sel\").find(\"#selYear\").find(\"#year option:selected\").val();\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype:\"get\",\r\n");
      out.write("\t\t\t\turl:\"invenDailyMonth.json\",\r\n");
      out.write("\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\tdata:{\"date\":year},\r\n");
      out.write("\t\t\t\tsuccess:function(data) {\r\n");
      out.write("\t\t\t\t\t$(data).each(function() {\r\n");
      out.write("\t\t\t\t\t\tdaily = this.day;\r\n");
      out.write("\t\t\t\t\t\tvar month = daily.split(\"-\")[1];\r\n");
      out.write("\t\t\t\t\t\tvar oldM = month;\r\n");
      out.write("\t\t\t\t\t\tif(oldM != m) {\r\n");
      out.write("\t\t\t\t\t\t\tmonthOption += \"<option value='\"+oldM+\"'>\"+oldM+\"</option>\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tm = oldM;\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\tmonthOption += \"</select>\";\r\n");
      out.write("\t\t\t\t\t$(\"#selMonth\").html(monthOption);\r\n");
      out.write("\t\t\t\t\t$(\"#sel\").find(\"#selMonth\").find(\"#month\").val(m).prop(\"selected\", true);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tvar month = $(\"#sel\").find(\"#selMonth\").find(\"#month option:selected\").val();\r\n");
      out.write("\t\t\t\t\t\tvar date = year +\"/\"+ month;\r\n");
      out.write("\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\ttype:\"get\",\r\n");
      out.write("\t\t\t\t\t\t\turl:\"invenDaily.json\",\r\n");
      out.write("\t\t\t\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\t\t\t\tdata:{\"date\":date},\r\n");
      out.write("\t\t\t\t\t\t\tsuccess:function(data) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(data).each(function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdaily = this.day;\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvar day = daily.split(\"-\")[2].substring(0,2);\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvar oldD = day;\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif(oldD != d) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdayOption += \"<option value='\"+oldD+\"'>\"+oldD+\"</option>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\td = oldD;\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\tdayOption += \"</select>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#selDay\").html(dayOption);\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#sel\").find(\"#selDay\").find(\"#day\").val(d).prop(\"selected\", true);\r\n");
      out.write("\t\t\t\t\t\t\t\tfor(var i = 1; i <= 9; i++) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif(day == i) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tday = \"0\" + day;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\tvar day = $(\"#sel\").find(\"#selDay\").find(\"#day option:selected\").val();\r\n");
      out.write("\t\t\t\t\t\t\t\tvar date = year +\"/\"+ month +\"/\"+ day;\r\n");
      out.write("\t\t\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype:\"get\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\turl:\"invenList.json\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata:{\"date\":date},\r\n");
      out.write("\t\t\t\t\t\t\t\t\tsuccess:function(data) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(data).each(function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\taddInven += \"<div class='invenAccountName'>\"+this.INVENACCOUNTNAME+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\taddInven += \"<div class='startInven'>\"+this.STARTINVEN+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\taddInven += \"<div class='invenIn'>\"+this.INVENIN+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\taddInven += \"<div class='invenOut'>\"+this.INVENOUT+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\taddInven += \"<div class='endInven'>\"+this.ENDINVEN+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\taddInven += \"</div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"#inven\").html(addInven);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getMonth() {\r\n");
      out.write("\tvar monthOption = \"<select name='month' id='month' class='selDate'>\";\r\n");
      out.write("\tvar dayOption = \"<select name='day' id='day' class='selDate'>\";\r\n");
      out.write("\tvar addInven = \"<div id='invenList'>\";\r\n");
      out.write("\taddInven += \"<div class='invenAccountName'>재고 품목</div>\";\r\n");
      out.write("\taddInven += \"<div class='startInven'>기초 재고</div>\";\r\n");
      out.write("\taddInven += \"<div class='invenIn'>입고</div>\";\r\n");
      out.write("\taddInven += \"<div class='invenOut'>출고</div>\";\r\n");
      out.write("\taddInven += \"<div class='endInven'>기말 재고</div>\";\r\n");
      out.write("\tvar daily;\r\n");
      out.write("\tvar m = 0;\r\n");
      out.write("\tvar d = 0;\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\ttype:\"get\",\r\n");
      out.write("\t\turl:\"invenDailyMonth.json\",\r\n");
      out.write("\t\tdataType:\"json\",\r\n");
      out.write("\t\tdata:{\"date\":year},\r\n");
      out.write("\t\tsuccess:function(data) {\r\n");
      out.write("\t\t\t$(data).each(function() {\r\n");
      out.write("\t\t\t\tdaily = this.day;\r\n");
      out.write("\t\t\t\tvar month = daily.split(\"-\")[1];\r\n");
      out.write("\t\t\t\tvar oldM = month;\r\n");
      out.write("\t\t\t\tif(oldM != m) {\r\n");
      out.write("\t\t\t\t\tmonthOption += \"<option value='\"+oldM+\"'>\"+oldM+\"</option>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tm = oldM;\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tmonthOption += \"</select>\";\r\n");
      out.write("\t\t\t$(\"#selMonth\").html(monthOption);\r\n");
      out.write("\t\t\t$(\"#sel\").find(\"#selMonth\").find(\"#month\").val(m).prop(\"selected\", true);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\tvar month = $(\"#sel\").find(\"#selMonth\").find(\"#month option:selected\").val();\r\n");
      out.write("\t\t\t\tvar date = year +\"/\"+ month;\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\ttype:\"get\",\r\n");
      out.write("\t\t\t\t\turl:\"invenDaily.json\",\r\n");
      out.write("\t\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\t\tdata:{\"date\":date},\r\n");
      out.write("\t\t\t\t\tsuccess:function(data) {\r\n");
      out.write("\t\t\t\t\t\t$(data).each(function() {\r\n");
      out.write("\t\t\t\t\t\t\tdaily = this.day;\r\n");
      out.write("\t\t\t\t\t\t\tvar day = daily.split(\"-\")[2].substring(0,2);\r\n");
      out.write("\t\t\t\t\t\t\tvar oldD = day;\r\n");
      out.write("\t\t\t\t\t\t\tif(oldD != d) {\r\n");
      out.write("\t\t\t\t\t\t\t\tdayOption += \"<option value='\"+oldD+\"'>\"+oldD+\"</option>\";\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\td = oldD;\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\tdayOption += \"</select>\";\r\n");
      out.write("\t\t\t\t\t\t$(\"#selDay\").html(dayOption);\r\n");
      out.write("\t\t\t\t\t\t$(\"#sel\").find(\"#selDay\").find(\"#day\").val(d).prop(\"selected\", true);\r\n");
      out.write("\t\t\t\t\t\tfor(var i = 1; i <= 9; i++) {\r\n");
      out.write("\t\t\t\t\t\t\tif(day == i) {\r\n");
      out.write("\t\t\t\t\t\t\t\tday = \"0\" + day;\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tvar day = $(\"#sel\").find(\"#selDay\").find(\"#day option:selected\").val();\r\n");
      out.write("\t\t\t\t\t\tvar date = year +\"/\"+ month +\"/\"+ day;\r\n");
      out.write("\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\ttype:\"get\",\r\n");
      out.write("\t\t\t\t\t\t\turl:\"invenList.json\",\r\n");
      out.write("\t\t\t\t\t\t\tdata:{\"date\":date},\r\n");
      out.write("\t\t\t\t\t\t\tsuccess:function(data) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(data).each(function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\taddInven += \"<div class='invenAccountName'>\"+this.INVENACCOUNTNAME+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\taddInven += \"<div class='startInven'>\"+this.STARTINVEN+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\taddInven += \"<div class='invenIn'>\"+this.INVENIN+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\taddInven += \"<div class='invenOut'>\"+this.INVENOUT+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\taddInven += \"<div class='endInven'>\"+this.ENDINVEN+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\taddInven += \"</div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#inven\").html(addInven);\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getDay() {\r\n");
      out.write("\tvar dayOption = \"<select name='day' id='day' class='selDate'>\";\r\n");
      out.write("\tvar addInven = \"<div id='invenList'>\";\r\n");
      out.write("\taddInven += \"<div class='invenAccountName'>재고 품목</div>\";\r\n");
      out.write("\taddInven += \"<div class='startInven'>기초 재고</div>\";\r\n");
      out.write("\taddInven += \"<div class='invenIn'>입고</div>\";\r\n");
      out.write("\taddInven += \"<div class='invenOut'>출고</div>\";\r\n");
      out.write("\taddInven += \"<div class='endInven'>기말 재고</div>\";\r\n");
      out.write("\tvar daily;\r\n");
      out.write("\tvar d = 0;\r\n");
      out.write("\tvar date = year +\"/\"+ month;\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\ttype:\"get\",\r\n");
      out.write("\t\turl:\"invenDaily.json\",\r\n");
      out.write("\t\tdataType:\"json\",\r\n");
      out.write("\t\tdata:{\"date\":date},\r\n");
      out.write("\t\tsuccess:function(data) {\r\n");
      out.write("\t\t\t$(data).each(function() {\r\n");
      out.write("\t\t\t\tdaily = this.day;\r\n");
      out.write("\t\t\t\tvar day = daily.split(\"-\")[2].substring(0,2);\r\n");
      out.write("\t\t\t\tvar oldD = day;\r\n");
      out.write("\t\t\t\tif(oldD != d) {\r\n");
      out.write("\t\t\t\t\tdayOption += \"<option value='\"+oldD+\"'>\"+oldD+\"</option>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\td = oldD;\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tdayOption += \"</select>\";\r\n");
      out.write("\t\t\t$(\"#selDay\").html(dayOption);\r\n");
      out.write("\t\t\t$(\"#sel\").find(\"#selDay\").find(\"#day\").val(d).prop(\"selected\", true);\r\n");
      out.write("\t\t\tfor(var i = 1; i <= 9; i++) {\r\n");
      out.write("\t\t\t\tif(day == i) {\r\n");
      out.write("\t\t\t\t\tday = \"0\" + day;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar day = $(\"#sel\").find(\"#selDay\").find(\"#day option:selected\").val();\r\n");
      out.write("\t\t\tvar date = year +\"/\"+ month +\"/\"+ day;\r\n");
      out.write("\t\t\talert(date);\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype:\"get\",\r\n");
      out.write("\t\t\t\turl:\"invenList.json\",\r\n");
      out.write("\t\t\t\tdata:{\"date\":date},\r\n");
      out.write("\t\t\t\tsuccess:function(data) {\r\n");
      out.write("\t\t\t\t\t$(data).each(function() {\r\n");
      out.write("\t\t\t\t\t\taddInven += \"<div class='invenAccountName'>\"+this.INVENACCOUNTNAME+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\taddInven += \"<div class='startInven'>\"+this.STARTINVEN+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\taddInven += \"<div class='invenIn'>\"+this.INVENIN+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\taddInven += \"<div class='invenOut'>\"+this.INVENOUT+\"</div>\";\r\n");
      out.write("\t\t\t\t\t\taddInven += \"<div class='endInven'>\"+this.ENDINVEN+\"</div>\";\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\taddInven += \"</div>\";\r\n");
      out.write("\t\t\t\t\t$(\"#inven\").html(addInven);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getInvenList() {\r\n");
      out.write("\tvar addInven = \"<div id='invenList'>\";\r\n");
      out.write("\taddInven += \"<div class='invenAccountName'>재고 품목</div>\";\r\n");
      out.write("\taddInven += \"<div class='startInven'>기초 재고</div>\";\r\n");
      out.write("\taddInven += \"<div class='invenIn'>입고</div>\";\r\n");
      out.write("\taddInven += \"<div class='invenOut'>출고</div>\";\r\n");
      out.write("\taddInven += \"<div class='endInven'>기말 재고</div>\";\r\n");
      out.write("\tvar date = year +\"/\"+ month +\"/\"+ day;\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\ttype:\"get\",\r\n");
      out.write("\t\turl:\"invenList.json\",\r\n");
      out.write("\t\tdata:{\"date\":date},\r\n");
      out.write("\t\tsuccess:function(data) {\r\n");
      out.write("\t\t\t$(data).each(function() {\r\n");
      out.write("\t\t\t\taddInven += \"<div class='invenAccountName'>\"+this.INVENACCOUNTNAME+\"</div>\";\r\n");
      out.write("\t\t\t\taddInven += \"<div class='startInven'>\"+this.STARTINVEN+\"</div>\";\r\n");
      out.write("\t\t\t\taddInven += \"<div class='invenIn'>\"+this.INVENIN+\"</div>\";\r\n");
      out.write("\t\t\t\taddInven += \"<div class='invenOut'>\"+this.INVENOUT+\"</div>\";\r\n");
      out.write("\t\t\t\taddInven += \"<div class='endInven'>\"+this.ENDINVEN+\"</div>\";\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\taddInven += \"</div>\";\r\n");
      out.write("\t\t\t$(\"#inven\").html(addInven);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
