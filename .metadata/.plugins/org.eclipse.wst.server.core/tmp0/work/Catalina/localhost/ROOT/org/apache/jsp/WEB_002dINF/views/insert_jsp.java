/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-11-18 04:17:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/D:/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ex10/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ex10/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
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

      out.write(" \r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>insert product</title>\r\n");
      out.write("<style>\r\n");
      out.write("\t#fileList img {margin:5px;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h2>[INSERT PRODUCT]</h2>\r\n");
      out.write("\t<form action=\"insert\" method=\"post\" enctype=\"multipart/form-data\" name=\"form\">\r\n");
      out.write("\t\t<table border=1>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=100> NAME </td>\r\n");
      out.write("\t\t\t\t<td width=400><input type=\"text\" name=\"pname\" size=45></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=100> PRICE </td>\r\n");
      out.write("\t\t\t\t<td width=400><input type=\"text\" name=\"price\" size=10> ＄</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=100> IMAGE </td>\r\n");
      out.write("\t\t\t\t<td width=400>\r\n");
      out.write("\t\t\t\t\t<img src=\"http://placehold.it/150x120\" id=\"image\" width=150>\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" name=\"file\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=100 height=130><input type=\"button\" id=\"btnImage\" value=\"OTHER IMAGE\"></td>\r\n");
      out.write("\t\t\t\t<td width=400>\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" name=\"files\" multiple>\r\n");
      out.write("\t\t\t\t\t<div id=\"fileList\"></div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<input type=\"submit\" id=\"btnSubmit\" value=\"save\">\r\n");
      out.write("\t\t<input type=\"reset\" value=\"cancel\">\r\n");
      out.write("\t\t<input type=\"button\" value=\"list\" onClick=\"location.href='list'\">\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(form.file).hide();\r\n");
      out.write("\t$(form.files).hide();\r\n");
      out.write("\t\r\n");
      out.write("\t$(form.image).on(\"click\", function() {\r\n");
      out.write("\t\t$(form.file).click();\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"#btnImage\").on(\"click\", function() {\r\n");
      out.write("\t\t$(form.files).click();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(form.file).change(function() {\r\n");
      out.write("\t\tvar file = $(form.file)[0].files[0];\r\n");
      out.write("\t\t$(\"#image\").attr(\"src\", URL.createObjectURL(file));\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(form.files).change(function() {\r\n");
      out.write("\t\tvar files = $(form.files)[0].files;\r\n");
      out.write("\t\tvar str = \"\";\r\n");
      out.write("\t\t$.each(files, function(index, file) {\r\n");
      out.write("\t\t\tstr += \"<img src='\" + URL.createObjectURL(file) + \"' width=150>\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#fileList\").html(str);\r\n");
      out.write("\t});\r\n");
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