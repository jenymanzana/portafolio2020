package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _404_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"es\" dir=\"ltr\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <div>\r\n");
      out.write("      <style>\r\n");
      out.write("        body { background-image: url(/img/fondo.svg);\r\n");
      out.write("          display: flex;\r\n");
      out.write("          justify-content: center;\r\n");
      out.write("          align-items: center;\r\n");
      out.write("          vertical-align:middle;\r\n");
      out.write("          margin: 0;}\r\n");
      out.write("        .texto {\r\n");
      out.write("              position: absolute;\r\n");
      out.write("              font: bold 200px/200px Arial, sans-serif;\r\n");
      out.write("              left: 50%;\r\n");
      out.write("              top: 50%;\r\n");
      out.write("              margin-top: -100px;\r\n");
      out.write("              width: 100%;\r\n");
      out.write("              margin-left: -50%;\r\n");
      out.write("              height: 200px;\r\n");
      out.write("              text-align: center;\r\n");
      out.write("              color:white;\r\n");
      out.write("              text-shadow: 0 0 30px rgba(0, 0, 0, .5);\r\n");
      out.write("animation: asdd 2s linear infinite;\r\n");
      out.write("          }\r\n");
      out.write("      </style>\r\n");
      out.write("\r\n");
      out.write("      <div>\r\n");
      out.write("        <div class=\"texto\">404</div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
