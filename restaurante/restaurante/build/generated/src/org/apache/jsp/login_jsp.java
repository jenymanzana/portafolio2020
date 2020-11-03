package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Expires\" content=\"0\">\n");
      out.write("<meta http-equiv=\"Last-Modified\" content=\"0\">\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-cache, mustrevalidate\">\n");
      out.write("<meta http-equiv=\"Pragma\" content=\"no-cache\">\n");
      out.write("\t<title>Ingresar a cuenta</title>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\t<link rel=\"icon\" type=\"image/png\" href=\"img/favicon.png\"/>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/Linearicons-Free-v1.0.0/icon-font.min.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style-login.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.1/css/all.css\" integrity=\"sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"limiter\">\n");
      out.write("\t<a href=\"index.php\"><div class=\"fas fa-home\"></div></a>\n");
      out.write("\t\t<div class=\"container-login100\" style=\"background-image: url('img/fondo_login.jpg');\">\n");
      out.write("\t\t\t<div class=\"wrap-login100 p-t-30 p-b-50\">\n");
      out.write("\t\t\t\t<span class=\"login100-form-title p-b-41\">\n");
      out.write("\t\t\t\t\t<a><img src=\"img/logo.png\" alt=\"Logo_restaurante\" style=\"height: 120px;\"></a>\n");
      out.write("\t\t\t\t</span>\n");
      out.write("\t\t\t\t<form class=\"login100-form validate-form p-b-33 p-t-5\"  method=\"POST\" action=\"ServletLogin\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate = \"Ingrese usuario\">\n");
      out.write("              <input required class=\"input100\" type=\"text\" name=\"user\"  placeholder=\"Usuario\">\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\" data-placeholder=\"&#xe82a;\"></span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate=\"Ingrese contraseña\">\n");
      out.write("\t\t\t\t\t\t<input required class=\"input100\" type=\"password\" name=\"pass\" placeholder=\"Contraseña\">\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\" data-placeholder=\"&#xe80f;\"></span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"container-login100-form-btn m-t-32\">\n");
      out.write("              <button type=\"submit\"  class=\"login100-form-btn\">\n");
      out.write("\t\t\t\t\t\t\tEntrar\n");
      out.write("\t\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t<div style=\"text-align:right;padding:20px 0px;font-size:0.9em;\"><p style=\"color:white\">¿Olvidaste tu contraseña? Contacta al Administrador</p>\n");
      out.write("\t\t\t\t\t\t<!--<a href=\"\">Recupera aquí</a>&nbsp;-->\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
