package org.apache.jsp.administrador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("  <title>Scrolling Nav - Start Bootstrap Template</title>\n");
      out.write("\n");
      out.write("  <!-- Bootstrap core CSS -->\n");
      out.write("  <link href=\"../vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("  <link href=\"../css/main.css\" rel=\"stylesheet\">\n");
      out.write("  <script src=\"https://kit.fontawesome.com/f298220d4a.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body id=\"page-top\">\n");
      out.write("\n");
      out.write("<div class=\"container-fluid caja-header\">\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"col-lg-4 col-12\">\n");
      out.write("      <div class=\"row \">\n");
      out.write("        <div class=\"col-6\">\n");
      out.write("          <img src=\"images/Logo_Restaurante.png\" class=\"img-fluid\" style=\"max-width:150px;\" alt=\"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-6\">\n");
      out.write("          <strong>ADMINISTRADOR</strong><br>\n");
      out.write("          Usuario: Marco Contreras <br>\n");
      out.write("          Fecha: 01/01/2020 <br>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"col-lg-9 offset-lg-3 col-12\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("          <nav class=\"navbar navbar-expand-lg navbar-light\" id=\"mainNav\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("              <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("              </button>\n");
      out.write("              <div class=\"collapse navbar-collapse menu\" id=\"navbarResponsive\">\n");
      out.write("                <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                  <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link js-scroll-trigger\" href=\"#about\">Empleados</a>\n");
      out.write("                  </li>\n");
      out.write("                  <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link js-scroll-trigger\" href=\"#services\">Caja</a>\n");
      out.write("                  </li>\n");
      out.write("                  <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link js-scroll-trigger\" href=\"#contact\">Bodegas</a>\n");
      out.write("                  </li>\n");
      out.write("                  <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link js-scroll-trigger\" href=\"#contact\">Menús</a>\n");
      out.write("                  </li>\n");
      out.write("                  <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link js-scroll-trigger\" href=\"#contact\">Clientes</a>\n");
      out.write("                  </li>\n");
      out.write("                  <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link js-scroll-trigger\" href=\"#contact\">Reportes</a>\n");
      out.write("                  </li>\n");
      out.write("                </ul>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </nav>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("  <!-- Navigation -->\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"row buscador\">\n");
      out.write("      <div class=\"col-lg-4 col-9 offset-1 offset-lg-1\">\n");
      out.write("        <input type=\"text\" class=\"form-control\"  aria-describedby=\"search\" placeholder=\"Buscar...\">\n");
      out.write("      </div>\n");
      out.write("      <div class=\"col-lg-1 col-1\">\n");
      out.write("        <button type=\"submit\" class=\"btn \"><i class=\"fas fa-search\"></i></button>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- tarjeta-->\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-lg-4  col-4 offset-3 offset-lg-0\">\n");
      out.write("        <div class=\"card bg-light mb-3 tarjeta\" style=\"max-width: 18rem;\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("              <h5 class=\"card-title\">Mesas actuales:</h5>\n");
      out.write("              <div class=\"row\">\n");
      out.write("                <div class=\"card-title col-6\">\n");
      out.write("                  <input type=\"text\" class=\"form-control\" value=\"30\" aria-describedby=\"mesas\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card-title col-3\">\n");
      out.write("                  <button type=\"submit\" class=\"btn \">-</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card-title col-3\">\n");
      out.write("                  <button type=\"submit\" class=\"btn\">+</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card-title col-10 offset-1\">\n");
      out.write("                  <button type=\"submit\" class=\"btn-actualizar btn\">Actualizar</button>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"col-lg-4  col-4 offset-3 offset-lg-0\">\n");
      out.write("        <div class=\"card bg-light mb-3 tarjeta\" style=\"max-width: 18rem;\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("              <h5 class=\"card-title\">Trabajadores:</h5>\n");
      out.write("              <h1 class=\"card-title\">8</h1>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"col-lg-4  col-4 offset-3 offset-lg-0\">\n");
      out.write("        <div class=\"card bg-light mb-3 tarjeta\" style=\"max-width: 18rem;\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("              <h5 class=\"card-title\">Clientes:</h5>\n");
      out.write("              <h1 class=\"card-title\">16</h1>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  <!-- Bootstrap core JavaScript -->\n");
      out.write("  <script src=\"../vendor/jquery/jquery.min.js\"></script>\n");
      out.write("  <script src=\"../vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("  <!-- Plugin JavaScript -->\n");
      out.write("  <script src=\"../vendor/jquery-easing/jquery.easing.min.js\"></script>\n");
      out.write("\n");
      out.write("  <!-- Custom JavaScript for this theme -->\n");
      out.write("  <script src=\"../js/scrolling-nav.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
