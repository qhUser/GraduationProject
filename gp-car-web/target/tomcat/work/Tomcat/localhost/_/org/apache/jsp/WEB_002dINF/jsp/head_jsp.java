/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-31 02:47:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class head_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<div style=\"height:20px;\"></div>\r\n");
      out.write("  <div class=\"row\">\r\n");
      out.write("  <div class=\"col-md-2\"></div>\r\n");
      out.write("  <div class=\"col-md-3\">\r\n");
      out.write("  <ul class=\"nav nav-tabs\">\r\n");
      out.write("  <li role=\"presentation\"><a href=\"http://localhost:8082\">商城首页</a></li>\r\n");
      out.write("  <li role=\"presentation\"><a href=\"http://localhost:8085/list\">正在拍卖</a></li>\r\n");
      out.write("  <li role=\"presentation\" class=\"active\"><a>我的拍卖</a></li>\r\n");
      out.write("  <li role=\"presentation\"><a id=\"deupte\" onclick=\"checkNow();\">拍卖委托</a></li>\r\n");
      out.write("  <li role=\"presentation\"><a href=\"#\">拍卖流程</a></li>\r\n");
      out.write("  </ul>\r\n");
      out.write("  <input type=\"hidden\" class=\"userlevel\"><!--隐藏域判定存放用户级别 以及判定用户是否登录 -->\r\n");
      out.write("  <input type=\"hidden\" class=\"userId\"><!--隐藏域判定存放用户级别 以及判定用户是否登录 -->\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"col-md-3\">\r\n");
      out.write("  <form action=\"/list\">\r\n");
      out.write("     <div class=\"input-group\">\r\n");
      out.write("      <input type=\"text\" class=\"form-control\" placeholder=\"请输入查询内容\" name=\"keyword\" style=\"border:1px solid #269abc; text-align:5px;\">\r\n");
      out.write("      <span class=\"input-group-btn\">\r\n");
      out.write("        <button class=\"btn btn-info\" type=\"submit\">搜索</button>\r\n");
      out.write("      </span>\r\n");
      out.write("    </div>\r\n");
      out.write("  </form>\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"col-md-2\"></div>\r\n");
      out.write("  <div class=\"col-md-2\" style=\"font-size:14px;\">\r\n");
      out.write("  <span id=\"loginbar\">\r\n");
      out.write("   你好，欢迎来到酷拍网!\r\n");
      out.write("  <a href=\"http://localhost:8090\">登录</a>&nbsp;&nbsp;<a href=\"http://localhost:8090/register\">注册</a>\r\n");
      out.write("  </span>\r\n");
      out.write("  </div>  \r\n");
      out.write("</div>\r\n");
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
