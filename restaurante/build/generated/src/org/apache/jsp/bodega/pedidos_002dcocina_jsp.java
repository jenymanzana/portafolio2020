package org.apache.jsp.bodega;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import Modelo.Insumo;
import java.sql.*;
import Modelo.*;
import oracle.jdbc.OracleTypes;

public final class pedidos_002dcocina_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession actual=request.getSession(true);
    String nombre=(String)actual.getAttribute("nombre");
    String fecha=(String)actual.getAttribute("fecha");

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
      out.write("  <title>Bodega - Pedidos</title>\n");
      out.write("\n");
      out.write("  <!-- Bootstrap core CSS -->\n");
      out.write("  <link href=\"../vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("  <!-- Custom styles for this template -->\n");
      out.write("  <link href=\"../css/main.css\" rel=\"stylesheet\">\n");
      out.write("  <script src=\"https://kit.fontawesome.com/f298220d4a.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body id=\"page-top\">\n");
      out.write("\n");
      out.write("<div class=\"container-fluid caja-header\">\n");
      out.write("  <div class=\"row align-items-center\">\n");
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
      out.write("      <div class=\"col-lg-8 col-12\">\n");
      out.write("        <div class=\"d-lg-none d-xl-block\">\n");
      out.write("          <br>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-lg-6 offset-lg-3 col-10 offset-1\">\n");
      out.write("            <h4>Pedidos de Cocina</h4>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("  <!-- Navigation -->\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"row buscador\">\n");
      out.write("      <div class=\"col-lg-4 col-8 offset-0\">\n");
      out.write("        <input type=\"text\" class=\"form-control\"  class=\"input-buscador \" aria-describedby=\"search\" placeholder=\"Buscar...\">\n");
      out.write("      </div>\n");
      out.write("      <div class=\"col-lg-1 col-1\">\n");
      out.write("        <button type=\"submit\" class=\"btn\"><i class=\"fas fa-search\"></i></button>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"col-1 offset-1 offset-lg-6\">\n");
      out.write("        <a href=\"bodega.html\" class=\"btn\"><i class=\"fas fa-arrow-left\"></i></a>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- CONTENIDO -->\n");
      out.write("    <div class=\"row align-items-center text-center\">\n");
      out.write("      <div class=\"col-12\">\n");
      out.write("        <h5>Listado de Pedidos</h5>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-12\">\n");
      out.write("        <table class=\" table table-hover table-responsive-md\">\n");
      out.write("       <thead>\n");
      out.write("       <tr>\n");
      out.write("       <th scope=\"col\">ID</th>\n");
      out.write("       <th scope=\"col\">Nombre</th>\n");
      out.write("       <th scope=\"col\">Fecha</th>\n");
      out.write("       <th scope=\"col\">Hora</th>\n");
      out.write("       <th scope=\"col\">Cantidad</th>\n");
      out.write("       <th scope=\"col\">Stock</th>\n");
      out.write("       <th scope=\"col\">Estado</th>\n");
      out.write("       <th scope=\"col\"></th>\n");
      out.write("       </tr>\n");
      out.write("       </thead>\n");
      out.write("        <tbody>\n");
      out.write("            ");
 
                                try 
                                {
                                        BaseDatos bd = new BaseDatos();
                                        Connection connection = bd.getConnection();
                                        if (connection!=null) 
                                  {
                                    //Llamar a procedure
                                      CallableStatement pp=connection.prepareCall("{call LISTARPEDIDOCOCINA (?)}");
                                      pp.registerOutParameter(1, OracleTypes.CURSOR);
                                      pp.execute();
                                      ResultSet resultSet=(ResultSet) pp.getObject(1);
//IDPEDIDO ESTADO_PEDIDO FECHA_PEDIDO NOMBRE_INSUMO CANTIDAD_INSUMO STOCK
                                         while (resultSet.next()) 
                                         {   
                                             Pedido_receta pr=new Pedido_receta();
                                             pr.setId_pedido_receta(resultSet.getInt("IDPEDIDO"));
                                             pr.setCantidad(resultSet.getInt("CANTIDAD_INSUMO"));
                                             pr.setEstado(resultSet.getString("ESTADO_PEDIDO"));
                                             pr.setFecha(resultSet.getTimestamp("FECHA_PEDIDO"));
                                             String nombrei=resultSet.getString("NOMBRE_INSUMO");
                                             int Stock=resultSet.getInt("STOCK");
                                             Calendar cal = Calendar.getInstance();  
                                             cal.setTime(pr.getFecha());
                                             String day=Integer.toString(cal.get(java.util.Calendar.DAY_OF_MONTH));
                                             int month=cal.get(java.util.Calendar.MONTH)+1;
                                             String year=Integer.toString(cal.get(java.util.Calendar.YEAR));
                                             int hour=cal.get(java.util.Calendar.HOUR_OF_DAY);
                                             int minute=cal.get(java.util.Calendar.MINUTE);

                                             
      out.write("\n");
      out.write("          <tr>\n");
      out.write("            <form method=\"POST\" action=\"../ServletPedCocina\"> \n");
      out.write("                <input name=\"idinsumo\" value=\"");
      out.print(resultSet.getInt("IDINSUMO"));
      out.write("\">\n");
      out.write("                <input name=\"idpedido\" value=\"");
      out.print(pr.getId_pedido_receta());
      out.write("\">\n");
      out.write("                <input name=\"cantidad\" value=\"");
      out.print(pr.getCantidad());
      out.write("\"> \n");
      out.write("             <th>");
      out.print(pr.getId_pedido_receta());
      out.write("</th>\n");
      out.write("             <td>");
      out.print(nombrei);
      out.write("</td>\n");
      out.write("             <td>");
      out.print(day+"/"+month+"/"+year);
      out.write("</td>\n");
      out.write("             <td>");
if(hour<10){out.print("0"+hour);}else{out.print(hour);};out.print(":");if(minute<10){out.print("0"+minute);}else{out.print(minute);}
      out.write("</td>\n");
      out.write("             <td>");
      out.print(pr.getCantidad());
      out.write("</td>\n");
      out.write("             <td>");
      out.print(Stock);
      out.write("</td>\n");
      out.write("             <td>\n");
      out.write("                <div class=\"alert alert-warning text-center\" role=\"alert\">\n");
      out.write("                 ");
      out.print(pr.getEstado());
      out.write("\n");
      out.write("                </div>\n");
      out.write("             </td>\n");
      out.write("             <td>\n");
      out.write("                 <button  type=\"submit\" value=\"Aprobado\" name=\"estado\" class=\"btn btn-success\">Aprobar</button>\n");
      out.write("             </td>\n");
      out.write("             <td>\n");
      out.write("                 <button  type=\"submit\" value=\"Rechazado\" name=\"estado\" class=\"btn btn-danger\" >Rechazar</button>\n");
      out.write("             </td>\n");
      out.write("             </form>\n");
      out.write("          </tr>\n");

                                         }
                                  }                 


                            } 
                            catch (Exception e) 
                            {
                            }


      out.write("\n");
      out.write("          </tbody>\n");
      out.write("     </table>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <br>\n");
      out.write("  </div>\n");
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
