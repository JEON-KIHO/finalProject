/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-12-18 06:25:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/ERP/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.10.2.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Triple S</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../resources/css/animations.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("#video {\r\n");
      out.write("   position: absolute;\r\n");
      out.write("   top: 0px;\r\n");
      out.write("   left: 0px;\r\n");
      out.write("   min-width: 100%;\r\n");
      out.write("   min-height: 100%;\r\n");
      out.write("   width: auto;\r\n");
      out.write("   height: auto;\r\n");
      out.write("   z-index: -1;\r\n");
      out.write("   overflow: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("   background: #ececec;\r\n");
      out.write("   padding: 40px 0;\r\n");
      out.write("   font-family: 'Lato', sans-serif;\r\n");
      out.write("   color: #444;\r\n");
      out.write("   text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button-wrapper {\r\n");
      out.write("   display: inline-block;\r\n");
      out.write("   margin: 20px 5px;\r\n");
      out.write("   padding: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dark-button, .dark-button-2 {\r\n");
      out.write("   background: #333;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button {\r\n");
      out.write("   background-color: rgba(300, 300, 300, 0.0);\r\n");
      out.write("   border: none;\r\n");
      out.write("   padding: 40px;\r\n");
      out.write("   cursor: pointer;\r\n");
      out.write("   display: block;\r\n");
      out.write("   position: relative;\r\n");
      out.write("   overflow: hidden;\r\n");
      out.write("   transition: all .35s ease-in-out .35s;\r\n");
      out.write("   margin-top: 300px;\r\n");
      out.write("   width: 200px;\r\n");
      out.write("   text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dark-button .button, .dark-button .button span {\r\n");
      out.write("   background: #36B4C7;\r\n");
      out.write("   color: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dark-button .button:after, .dark-button .button:before, .dark-button .button:hover span\r\n");
      out.write("   {\r\n");
      out.write("   background: #fff;\r\n");
      out.write("   color: #444;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dark-button-2 .button, .dark-button-2 .button span {\r\n");
      out.write("   background: #333;\r\n");
      out.write("   color: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dark-button-2 .button:after, .dark-button-2 .button:before,\r\n");
      out.write("   .dark-button-2 .button:hover span {\r\n");
      out.write("   background: #fff;\r\n");
      out.write("   color: #444;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h2 {\r\n");
      out.write("   font-family:\"굴림\";\r\n");
      out.write("   background-color: rgba(300, 300, 300, 0.0);\r\n");
      out.write("   display: block;\r\n");
      out.write("   padding: 15px 30px;\r\n");
      out.write("   z-index: 100;\r\n");
      out.write("   position: relative;\r\n");
      out.write("   transition: all .35s ease-in-out .35s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button:hover h2 {\r\n");
      out.write("   background: #36B4C7;\r\n");
      out.write("   color: #fff;\r\n");
      out.write("   transition: all .35s ease-in-out .35s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button:after {\r\n");
      out.write("   bottom: -100%;\r\n");
      out.write("   right: -100%;\r\n");
      out.write("   content: \"\";\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   height: 100%;\r\n");
      out.write("   position: absolute;\r\n");
      out.write("   background: #36B4C7;\r\n");
      out.write("   transition: all .35s ease-in-out .5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button:hover:after {\r\n");
      out.write("   right: 0;\r\n");
      out.write("   bottom: 0;\r\n");
      out.write("   transition: all ease-in-out .35s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button:before {\r\n");
      out.write("   top: -100%;\r\n");
      out.write("   left: -100%;\r\n");
      out.write("   content: \"\";\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   height: 100%;\r\n");
      out.write("   position: absolute;\r\n");
      out.write("   background: #36B4C7;\r\n");
      out.write("   transition: all .35s ease-in-out .5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button:hover:before {\r\n");
      out.write("   left: 0;\r\n");
      out.write("   top: 0;\r\n");
      out.write("   transition: all ease-in-out .35s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#darken-background {\r\n");
      out.write("   position: absolute;\r\n");
      out.write("   top: 0px;\r\n");
      out.write("   left: 0px;\r\n");
      out.write("   right: 0px;\r\n");
      out.write("   height: 100%;\r\n");
      out.write("   display: none;\r\n");
      out.write("   background: rgba(0, 0, 0, 0.5);\r\n");
      out.write("   z-index: 10000;\r\n");
      out.write("   overflow-y: scroll;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#lightbox {\r\n");
      out.write("   width: 600px;\r\n");
      out.write("   height: 600px;\r\n");
      out.write("   margin: 20px auto;\r\n");
      out.write("   border: 1px solid #333333;\r\n");
      out.write("   border-radius: 5px;\r\n");
      out.write("   background: white;\r\n");
      out.write("   box-shadow: 0px 5px 5px rgba(34, 25, 25, 0.4);\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".box {\r\n");
      out.write("   margin: 10px;\r\n");
      out.write("   float: left;\r\n");
      out.write("}\r\n");
      out.write("#divCenter{margin-left: 20px; margin:100px;}\r\n");
      out.write(" #frm{border:1px solid #F1F3F2;}\r\n");
      out.write(" td{padding:20px 10px 10px 15px;}\r\n");
      out.write("   \r\n");
      out.write("   #mainlogin {\r\n");
      out.write("  width: 500px;\r\n");
      out.write("  height: 80px;\r\n");
      out.write("  margin-top:30px;\r\n");
      out.write("  font-family: 'Roboto', sans-serif;\r\n");
      out.write("  font-size: 11px;\r\n");
      out.write("  text-transform: uppercase;\r\n");
      out.write("  letter-spacing: 2.5px;\r\n");
      out.write("  font-weight: 500;\r\n");
      out.write("  color: white;\r\n");
      out.write("  background-color:#597484;\r\n");
      out.write("  border: none;\r\n");
      out.write("  border-radius: 45px;\r\n");
      out.write("  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);\r\n");
      out.write("  transition: all 0.3s ease 0s;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  outline: none;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write(" #mainlogin:hover {\r\n");
      out.write("  background-color: black;\r\n");
      out.write("  box-shadow: 0px 15px 20px rgba;\r\n");
      out.write("  color: #fff;\r\n");
      out.write("  transform: translateY(-7px);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("*:focus { outline: none; }\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("   <video id=\"video\" preload=\"auto\" autoplay=\"true\" loop=\"loop\"\r\n");
      out.write("      muted=\"muted\" volume=\"0\"> <source src=\"../resources/ask.mp4\">\r\n");
      out.write("   </source> </video>\r\n");
      out.write("\r\n");
      out.write("   <div class=\"light-button button-wrapper\">\r\n");
      out.write("      <div class=\"button\" onclick=\"location.href='company'\">\r\n");
      out.write("\r\n");
      out.write("         <h2 style=\"color: white; text-align:center;\">Registration</h2>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("   </div>\r\n");
      out.write("\r\n");
      out.write("   <div class=\"light-button button-wrapper\">\r\n");
      out.write("      <div class=\"button\" onclick=\"showLogin();\">\r\n");
      out.write("\r\n");
      out.write("         <h2 style=\"color: white; text-align: center;\">\r\n");
      out.write("\r\n");
      out.write("            Login \r\n");
      out.write("         </h2>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("   </div>\r\n");
      out.write(" <!--라이트 박스-->\r\n");
      out.write(" <div id=\"darken-background\">\r\n");
      out.write(" <div id=\"divCenter\">\r\n");
      out.write(" <div id=\"lightbox\" class=\"light-button button-wrapper\">\r\n");
      out.write("    <button id=\"btnCancell\" style=\"border:0; background:white; font-size:40px; float:left; color:gray;\">X</button>\r\n");
      out.write("    <h1 style=\"font-size:50px; margin-top:20px;\">LOGIN</h1>\r\n");
      out.write("   <form name=\"frm\" action=\"loginok\" method=\"post\" style=\"margin-top:100px;\">\r\n");
      out.write("      <table>\r\n");
      out.write("         <tr>\r\n");
      out.write("            <td width=100 style=\"font-size:30px;\">ID</td>\r\n");
      out.write("            <td width=200><input type=\"text\" name=\"adminId\" style=\"border:none; width:300px; height:50px;\r\n");
      out.write("             border-bottom:1px solid gray;font-size:20px;\" placeholder=\"아이디 입력\"></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("            <td width=100 style=\"font-size:30px\">Password</td>\r\n");
      out.write("            <td width=200><input type=\"password\" name=\"adminPassword\" style=\"border:none; height:50px;\r\n");
      out.write("             width:300px; border-bottom:1px solid gray; font-size:20px;\" placeholder=\"비밀번호 입력\"></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("         <td colspan=2>\r\n");
      out.write("             <input type=\"checkbox\" name=\"chkLogin\"  style=\"margin-left:360px; margin-bottom:50px; float:left;\">Keep Login<br/>\r\n");
      out.write("            \r\n");
      out.write("            <input type=\"submit\" id=\"mainlogin\" value=\"Login\" style=\"margin-left:20px; font-size:30px;\"\r\n");
      out.write("            ></td>\r\n");
      out.write("            \r\n");
      out.write("         </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("   </form>\r\n");
      out.write("   </div>\r\n");
      out.write("      </div>\r\n");
      out.write(" </div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("   $(\"#btnCancell\").on(\"click\",function(){\r\n");
      out.write("      location.href = \"login\";\r\n");
      out.write("      \r\n");
      out.write("   });\r\n");
      out.write("   function showLogin(){\r\n");
      out.write("      $(\"#darken-background\").show();\r\n");
      out.write("   }\r\n");
      out.write("\r\n");
      out.write("   $(frm).submit(function(e) {\r\n");
      out.write("      e.preventDefault();\r\n");
      out.write("      var adminId = $(frm.adminId).val();\r\n");
      out.write("      var adminPassword = $(frm.adminPassword).val();\r\n");
      out.write("      var chkLogin = $(frm.chkLogin).is(\":checked\") ? true : false;\r\n");
      out.write("      $.ajax({\r\n");
      out.write("\r\n");
      out.write("         type : \"post\",\r\n");
      out.write("         url : \"mainlogin\",\r\n");
      out.write("         data : {\r\n");
      out.write("            \"adminId\" : adminId,\r\n");
      out.write("            \"adminPassword\" : adminPassword,\r\n");
      out.write("            \"chkLogin\" : chkLogin\r\n");
      out.write("         },\r\n");
      out.write("         success : function(data) {\r\n");
      out.write("            if (data == 0) {\r\n");
      out.write("               alert(\"아이디를 입력하세요.\");\r\n");
      out.write("            } else if (data == 2) {\r\n");
      out.write("               alert(\"비밀번호가 올바르지 않습니다.\");\r\n");
      out.write("            } else if (data == 1) {\r\n");
      out.write("//                frm.submit();\r\n");
      out.write("               location.href = \"main\";\r\n");
      out.write("            }\r\n");
      out.write("         }\r\n");
      out.write("\r\n");
      out.write("      });\r\n");
      out.write("\r\n");
      out.write("   });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
