/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-31 02:47:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class deupte_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"multipart/form-data; charset=utf-8\" />\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link href=\"../../css/bootstrap-datetimepicker.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/bootstrap.min.css\" ></link>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/bootstrap-theme.min.css\" ></link>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/mycss.css\"></link>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("    <script src=\"../../js/moment-with-locales(1).js\"></script>\r\n");
      out.write("    <script src=\"../../js/bootstrap-datetimepicker.min.js\"></script>\r\n");
      out.write("    <script src=\"../../js/bootstrap-datetimepicker.zh-CN.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"../../js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"../../js/gpmall.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery.cookie.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "head2.jsp", out, false);
      out.write("\r\n");
      out.write("<form action=\"/picture\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write(" <div class=\"row\"> \r\n");
      out.write(" <div style=\"height:50px;text-align:center;font-size:24px;font-weight:bold;line-height:50px;\" id=\"title\"></div>\r\n");
      out.write(" <div class=\"col-md-3\" style=\"height:600px;\"></div> \r\n");
      out.write(" <div class='col-md-6'><div class='col-md-4 deupte'>商品名称:</div><div class='col-md-8 deupte1' ><input type=\"text\" name=\"comName\"></div></div>\r\n");
      out.write(" <div class='col-md-6'><div class='col-md-4 deupte'>商品分类:</div><div class='col-md-8 deupte1'>\r\n");
      out.write(" <div class=\"dropdown\">\r\n");
      out.write("  <button class=\"btn btn-default dropdown-toggle\" type=\"button\" id=\"dropdownMenu1\" data-toggle=\"dropdown\" >\r\n");
      out.write("    <span id=\"swit\" >请选择</span>\r\n");
      out.write("   <span class=\"caret\"></span>\r\n");
      out.write("  </button>\r\n");
      out.write("  <ul class=\"dropdown-menu\" id=\"dpdown\">  \r\n");
      out.write("  <li></li>\r\n");
      out.write("  </ul>\r\n");
      out.write("</div></div></div>\r\n");
      out.write(" <div class='col-md-6'><div class='col-md-4 deupte'>开拍时间:</div><div class='col-md-8 deupte1'>\r\n");
      out.write("   <a class='input-group date' id='datetimepicker1' style=\"float: left; \">\r\n");
      out.write("  <input type='text' class=\"form-control\" id='nowdate' style=\"width: 150px; height: 30px;\"name=\"startDate\" />\r\n");
      out.write("   <span class=\"input-group-addon\" style=\"float: left; width: 50px; height: 30px;\">\r\n");
      out.write("   <span class=\"glyphicon glyphicon-calendar\"></span>\r\n");
      out.write("  \r\n");
      out.write("   </span> \r\n");
      out.write("  </a>\r\n");
      out.write("  <span style=\"float: left; \">&nbsp;至&nbsp;</span>\r\n");
      out.write("  <a class='input-group date' id='datetimepicker2' style=\"float: left; \">\r\n");
      out.write("  <input type='text' class=\"form-control \" id='nowdate2' style=\"width: 150px; height: 30px;\" name=\"endDate\"/>\r\n");
      out.write("   <span class=\"input-group-addon\" style=\"float: left; width: 50px; height: 30px;\">\r\n");
      out.write("   <span class=\"glyphicon glyphicon-calendar\"></span>\r\n");
      out.write("   </span>\r\n");
      out.write("   </a>\r\n");
      out.write("   \r\n");
      out.write("   </div></div>\r\n");
      out.write(" <div class='col-md-6'><div class='col-md-4 deupte'>起拍价:</div><div class='col-md-8 deupte1'><input type=\"text\" name=\"lastprice\"></div></div>\r\n");
      out.write("  <div class='col-md-6'><div class='col-md-4 deupte'>数量:</div><div class='col-md-8 deupte1'><input type=\"text\" name=\"count\"></div></div>\r\n");
      out.write("  <div class='col-md-6'><div class='col-md-4 deupte'>上传图片：</div><div class='col-md-8 deupte1'>\r\n");
      out.write("  <input type=\"file\" name=\"pictureFile\" id=\"picture\"></div></div>\r\n");
      out.write(" <div class='col-md-6'><div class='col-md-4 deupte'>商品描述：</div><div class='col-md-8 deupte1'>\r\n");
      out.write(" <textarea rows=\"6\" cols=\"50\" name=\"descript\"></textarea></div></div>\r\n");
      out.write(" <div class='col-md-6'><div class='col-md-4 deupte'></div><div class='col-md-8 deupte1'>\r\n");
      out.write("\r\n");
      out.write("<button class=\"btn btn-danger\" type=\"submit\">发布委托</button>");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write(" </div></div>\r\n");
      out.write(" </div>\r\n");
      out.write("</form>\r\n");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\tswitchitem();\r\n");
      out.write("\tDatetime();//起始日期\r\n");
      out.write("\tDatetime2();//结束日期\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("/*接受委托*/\r\n");
      out.write("function accept(){\r\n");
      out.write("\t  var suppid=$(\".userId\").val();\r\n");
      out.write("\t  alert(suppid);\r\n");
      out.write("\t  var comid=$(\"#comid\").text();\r\n");
      out.write("\t  $.post(\"/acceptCom\",\r\n");
      out.write("\t\t\t  {\"comid\":comid,\"suppid\":suppid},\r\n");
      out.write("\t\t\t  function(data){\r\n");
      out.write("\t\t\t\t  alert(\"已成功委托该商品\");\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t  })\r\n");
      out.write("}\r\n");
      out.write("function switchitem(){\r\n");
      out.write("\tvar html=$(\"#dpdown\").html();\r\n");
      out.write("\tvar swit=$(\"#swit\");\r\n");
      out.write("\tvar level=$(\".userlevel\");\t\r\n");
      out.write("\tif(level==1){\r\n");
      out.write("\t\t$(\"#title\").text(\"\");\r\n");
      out.write("\t\t$(\"#title\").text(\"发布商品拍卖委托\");\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t$(\"#title\").text(\"\");\r\n");
      out.write("\t\t$(\"#title\").text(\"发布商品拍卖\");\r\n");
      out.write("\t}\r\n");
      out.write("\t$.post(\"/switchitem\",\r\n");
      out.write("\t\t\t{},\r\n");
      out.write("\t\t\tfunction(data){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tfor(var i=0;i<data.list.length;i++){\r\n");
      out.write("\t\t\t\t\thtml+=\"<li><a style='cursor: pointer;'>\"+data.list[i].typename+\"</a><input type='hidden'   value='\"+data.list[i].id+\"'></li>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#dpdown\").html(html);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#dpdown li \").click(function(){\r\n");
      out.write("\t\t\t\t\tvar text=$(this).text();\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tswit.text(\"\");\r\n");
      out.write("\t\t\t\t\tswit.text(text);\r\n");
      out.write("\t\t\t\t\tvar val=$(this).find(\"input\").val();\t\r\n");
      out.write("\t\t\t\t\tvar userId=$(\".userId\").val();\r\n");
      out.write("\t\t\t\t\tvar userlevel=$(\".userlevel\").val();\r\n");
      out.write("\t\t\t\t\t$(\"form\").attr(\"action\",\"/picture?swit=\"+val+\"&id=\"+userId+\"&level=\"+userlevel);//发布商品 默认委托方id为1，有时间在修改\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function Datetime() {\r\n");
      out.write("    $('#datetimepicker1').datetimepicker({\r\n");
      out.write("        language: 'zh-CN',//显示中文\r\n");
      out.write("        format: 'yyyy-mm-dd',//显示格式\r\n");
      out.write("        minView: \"month\",//设置只显示到月份\r\n");
      out.write("        initialDate: new Date(),\r\n");
      out.write("        autoclose: true,//选中自动关闭\r\n");
      out.write("        todayBtn: true,//显示今日按钮\r\n");
      out.write("        locale: moment.locale('zh-cn')\r\n");
      out.write("    });\r\n");
      out.write("    //默认获取当前日期\r\n");
      out.write("    var today = new Date();\r\n");
      out.write("    var nowdate = (today.getFullYear()) + \"-\" + (today.getMonth() + 1) + \"-\" + today.getDate();\r\n");
      out.write("    //对日期格式进行处理\r\n");
      out.write("    var date = new Date(nowdate);\r\n");
      out.write("    var mon = date.getMonth() + 1;\r\n");
      out.write("    var day = date.getDate();\r\n");
      out.write("    var mydate = date.getFullYear() + \"-\" + (mon < 10 ? \"0\" + mon : mon) + \"-\" + (day < 10 ? \"0\" + day : day);\r\n");
      out.write("    document.getElementById(\"nowdate\").value = mydate;\r\n");
      out.write("}\r\n");
      out.write("function Datetime2() {\r\n");
      out.write("    $('#datetimepicker2').datetimepicker({\r\n");
      out.write("        language: 'zh-CN',//显示中文\r\n");
      out.write("        format: 'yyyy-mm-dd',//显示格式\r\n");
      out.write("        minView: \"month\",//设置只显示到月份\r\n");
      out.write("        initialDate: new Date(),\r\n");
      out.write("        autoclose: true,//选中自动关闭\r\n");
      out.write("        todayBtn: true,//显示今日按钮\r\n");
      out.write("        locale: moment.locale('zh-cn')\r\n");
      out.write("    });\r\n");
      out.write("    //默认获取当前日期\r\n");
      out.write("    var today = new Date();\r\n");
      out.write("    var nowdate = (today.getFullYear()) + \"-\" + (today.getMonth() + 1) + \"-\" + today.getDate();\r\n");
      out.write("    //对日期格式进行处理\r\n");
      out.write("    var date = new Date(nowdate);\r\n");
      out.write("    var mon = date.getMonth() + 1;\r\n");
      out.write("    var day = date.getDate();\r\n");
      out.write("    var mydate = date.getFullYear() + \"-\" + (mon < 10 ? \"0\" + mon : mon) + \"-\" + (day < 10 ? \"0\" + day : day);\r\n");
      out.write("    document.getElementById(\"nowdate2\").value = mydate;\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsp/deupte.jsp(66,58) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${key=='ok'}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<span style=\"color:red;\">发布成功</span>");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest)_jspx_page_context.getRequest();
    javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse)_jspx_page_context.getResponse();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/jsp/deupte.jsp(70,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${level==3}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "accept.jsp", out, false);
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
