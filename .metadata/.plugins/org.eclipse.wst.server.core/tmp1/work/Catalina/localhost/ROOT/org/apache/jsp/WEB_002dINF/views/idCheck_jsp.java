/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-12-24 00:15:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class idCheck_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>아이디 중복 체크</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <h2>아이디 중복 체크</h2>\r\n");
      out.write("   <div id=\"checkMsg\"></div>\r\n");
      out.write("   <table>\r\n");
      out.write("      <tr>\r\n");
      out.write("         <td> &nbsp;  \r\n");
      out.write("                <input type = \"text\" name = \"adminId\" style=\"border:none; width:200px; height:30px; border-bottom:1px solid gray;\" placeholder=\"아이디 입력\" id=\"adminId\">\r\n");
      out.write("             </td>\r\n");
      out.write("             <td><input type=\"hidden\" value=\"사용\" id=\"btnUse\"></td>\r\n");
      out.write("<!--          <td><button type=\"submit\" id=\"btnCheck\">중복확인</button></td> -->\r\n");
      out.write("      </tr>\r\n");
      out.write("   </table>\r\n");
      out.write("      <div id=\"checkMs\"></div>\r\n");
      out.write("      \r\n");
      out.write("      <table>\r\n");
      out.write("      <tr>\r\n");
      out.write("<!--       <td><input type=\"hidden\" value=\"사용\" id=\"btnUse\"></td> -->\r\n");
      out.write("      </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("      \r\n");
      out.write("<!--      <a href=\"javascript:window.close()\" style=\"color:gray; margin-left:300px;\">close</a>       -->\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("   //아이디 값 불러오기\r\n");
      out.write("   //아이디 체크여부 확인\r\n");
      out.write("//    $(document).ready(function() {\r\n");
      out.write("\t   \r\n");
      out.write("\t$(\"#adminId\").focus();\r\n");
      out.write("\t\r\n");
      out.write("\t   $(\"#adminId\").on(\"keyup\", function(key) {\r\n");
      out.write("\t\t  var adminId = $(this).val();\r\n");
      out.write("\t\t  $.ajax({\r\n");
      out.write("\t\t\t type:\"post\",\r\n");
      out.write("\t\t\t url:\"idCheck\",\r\n");
      out.write("\t\t\t data:{\"adminId\":adminId},\r\n");
      out.write("\t\t\t success:function(data) {\r\n");
      out.write("\t\t\t\t if(data == 0) {\r\n");
      out.write("\t\t\t\t\t if(adminId.length == 0) {\r\n");
      out.write("\t\t\t\t\t\t $(\"#adminId\").css(\"background\", \"#FF7E7E\"); \r\n");
      out.write("\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t\t if(adminId.length != 0) {\r\n");
      out.write("\t\t\t\t\t\t $(\"#adminId\").css(\"background\", \"#9BFF94\"); \r\n");
      out.write("\t\t                 \t\tif(key.keyCode == 13) {\r\n");
      out.write("\t\t                 \t\t\t$(\"#btnUse\").click();\r\n");
      out.write("\t\t                 \t\t}\r\n");
      out.write("\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t\t if(data == 1) {\r\n");
      out.write("\t\t\t\t \t$(\"#adminId\").css(\"background\", \"#FF7E7E\"); \r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t  });\r\n");
      out.write("// \t   });\r\n");
      out.write("\t   \r\n");
      out.write("\t   \r\n");
      out.write("\t\t  $(\"#btnUse\").on(\"click\",function(){\r\n");
      out.write("\t\t      var id=$(\"#adminId\").val();\r\n");
      out.write("\t\t      $(\"#adminId\", opener.document).val(id);\r\n");
      out.write("\t\t      window.close();\r\n");
      out.write("\t\t   });\r\n");
      out.write("\t   \r\n");
      out.write("//       $('#btnCheck').on('click', function(e) {\r\n");
      out.write("//          e.preventDefault();\r\n");
      out.write("//          var adminId = $(frm.adminId).val();\r\n");
      out.write("//          $.ajax({\r\n");
      out.write("//             type : 'POST',\r\n");
      out.write("//             url : 'idCheck',\r\n");
      out.write("//             data : {\r\n");
      out.write("//                \"adminId\" : adminId\r\n");
      out.write("//             },\r\n");
      out.write("//             success : function(data) {\r\n");
      out.write("//                if(adminId==\"\"){\r\n");
      out.write("//                   alert(\"아이디를 입력하세요\");\r\n");
      out.write("//                    $(frm.adminId).focus();\r\n");
      out.write("//                    return;\r\n");
      out.write("//                }\r\n");
      out.write("//                if ((data) == 0) {\r\n");
      out.write("//                   $('#id').css(\"background\", \"#9BFF94\");\r\n");
      out.write("//                   $('#btnUse').attr(\"type\", \"button\");\r\n");
      out.write("//                }else if((data) == 1){\r\n");
      out.write("//             \t   $('#id').css(\"background\", \"#FF7E7E\");\r\n");
      out.write("//                   $('#btnUse').attr(\"type\", \"hidden\");\r\n");
      out.write("//                }\r\n");
      out.write("//             }\r\n");
      out.write("//          });\r\n");
      out.write("//       });\r\n");
      out.write("   });\r\n");
      out.write("   //사용 버튼 누른후 등록화ㅣ면\r\n");
      out.write("   \r\n");
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