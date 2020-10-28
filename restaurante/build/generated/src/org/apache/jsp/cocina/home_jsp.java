package org.apache.jsp.cocina;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;
import Modelo.*;
import oracle.jdbc.OracleTypes;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    HttpSession actual=request.getSession(true);
    String nombre=(String)actual.getAttribute("nombre");
    String fecha=(String)actual.getAttribute("fecha");
     int menu=0;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, i+¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿yu677777777777777777777x\n");
      out.write("\n");
      out.write("  <!-- Bootstrap core CSS -->\n");
      out.write("  <link href=\"../vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("  <!-- Custom styles for this template -->\n");
      out.write("  <link href=\"../css/main.css\" rel=\"stylesheet\">\n");
      out.write("  <script src=\"https://kit.fontawesome.com/f298220d4a.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("    <body id=\"page-top\">\n");
      out.write("\n");
      out.write("<div class=\"container-fluid caja-cocina\" >\n");
      out.write("  <div class=\"row align-items-center \">\n");
      out.write("    <div class=\"col-lg-6 offset-lg-3 col-12 text-center\">\n");
      out.write("      <img src=\"images/Logo_Restaurante.png\" style=\"max-width:200px;\" class=\"imagen-logo img-fluid\" alt=\"\">\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"col-6\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-8  col-lg-10 justify-content-start\">\n");
      out.write("          <strong>COCINA</strong><br>\n");
      out.write("          <strong>Fecha: 01/01/2020</strong> <br>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-5\">\n");
      out.write("      <div class=\"row text-right\">\n");
      out.write("        <div class=\"col-10\">\n");
      out.write("          <button type=\"submit\" class=\"btn\">Bodega</button>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-2\">\n");
      out.write("          <i class=\"fas fa-power-off\" style=\"font-size:25px;color:red\"></i>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("  <br>\n");
      out.write("    <div class=\"col-12\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-12\">\n");
      out.write("          <div class=\"row menu text-center\">\n");
      out.write("            <div class=\"col-12\">\n");
      out.write("                <h4>Lista de Pedidos</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-12\">\n");
      out.write("              <table class=\" table table-hover table-responsive-md\">\n");
      out.write("             <thead>\n");
      out.write("             <tr>\n");
      out.write("             <th scope=\"col\">Código</th>\n");
      out.write("             <th scope=\"col\">Mesa</th>\n");
      out.write("             <th scope=\"col\">Hora pedido</th>\n");
      out.write("             <th scope=\"col\">Estado</th>\n");
      out.write("             <th scope=\"col\">Preparado por</th>\n");
      out.write("             <th scope=\"col\">Hora Preparación</th>\n");
      out.write("             <th scope=\"col\">Hora Entrega</th>\n");
      out.write("             <th scope=\"col\">Detalle</th>\n");
      out.write("             </tr>\n");
      out.write("             </thead>\n");
      out.write("              <tbody>\n");
      out.write("                  ");
 
                                try 
                                {
                                        BaseDatos bd = new BaseDatos();
                                        Connection connection = bd.getConnection();
                                        ResultSet resultSet,rs,res;
                                        if (connection!=null) 
                                  {
                                    //Llamar a procedure
                                      CallableStatement pp=connection.prepareCall("{call SOLICITUDESACOCINA (?)}");
                                      pp.registerOutParameter(1, OracleTypes.CURSOR);
                                      pp.execute();
                                      resultSet=(ResultSet) pp.getObject(1);
                                      String cod="";
                                      String cocinero="";
                                         while (resultSet.next()) 
                                         {   
                                             if(resultSet.getString("CODPEDIDO").equals(cod))
                                             {
                                                 continue;
                                             }
   //IDPEDIDO CODPEDIDO Nombre (receta) CANTIDAD HORAPEDIDO HORAPREPARACION HORAENTREGA ESTADO GARZON NUMMESA
                                             menu++;
                                             cod=resultSet.getString("CODPEDIDO");
                                            Pedidos pe=new Pedidos();
                                            pe.setId_pedido(resultSet.getInt("IDPEDIDO"));
                                            pe.setCodigo_pedido(cod);
                                            pe.setEstado(resultSet.getString("ESTADO"));
                                            Detalle_pedido dp=new Detalle_pedido();
                                            dp.setCantidad_pedido(resultSet.getInt("CANTIDAD"));
                                            dp.setHora_Entrega(resultSet.getTimestamp("HORAENTREGA"));
                                            dp.setHora_Pedido(resultSet.getTimestamp("HORAPEDIDO"));
                                            dp.setHora_Preparacion(resultSet.getTimestamp("HORAPREPARACION"));
                                            int mesa=resultSet.getInt("NUMMESA");
                                            String garzon=resultSet.getString("GARZON");
                                            Calendar cal = Calendar.getInstance();  
                                             cal.setTime(dp.getHora_Pedido());
                                             int hour=cal.get(java.util.Calendar.HOUR_OF_DAY);
                                             int minute=cal.get(java.util.Calendar.MINUTE);
                                             String message="";
                                             if(pe.getEstado().equals("Pendiente"))
                                             {
                                                 message="danger";
                                             }
                                             if(pe.getEstado().equals("Preparando"))
                                             {
                                                 message="warning";
                                             }
                                             if(pe.getEstado().equals("Listo"))
                                             {
                                                 message="success";
                                             }
                                             
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                   <th>");
      out.print(pe.getCodigo_pedido());
      out.write("</th>\n");
      out.write("                   <td>");
      out.print(mesa);
      out.write("</td>\n");
      out.write("                   <td>");
if(hour<10){out.print("0"+hour);}else{out.print(hour);};out.print(":");if(minute<10){out.print("0"+minute);}else{out.print(minute);}
      out.write("</td>\n");
      out.write("                   <td>\n");
      out.write("                     <div class=\"alert alert-");
      out.print(message);
      out.write(" text-center\" role=\"alert\">\n");
      out.write("                       ");
      out.print(pe.getEstado());
      out.write("\n");
      out.write("                     </div>\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                     ");
      out.print(cocinero);
      out.write("\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                     ");
      out.print(dp.getHora_Preparacion());
      out.write("\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                     ");
      out.print(dp.getHora_Entrega());
      out.write("\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                    <button  type=\"button\" data-toggle=\"modal\" data-target=\"#modaldetalle\"  class=\"btn btn-100\">Ver</button>\n");
      out.write("                   </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

            }
                      }
                  
                  connection.close();
                } 
                catch (Exception e) 
                {
                    out.print(e);
                }


      out.write("\n");
      out.write("              </tbody>\n");
      out.write("           </table>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("<!-- Modal Solicitudes de pedido-->\n");
      out.write("                    <div class=\"modal fade\" id=\"modaldetalle\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("                      <div class=\"modal-dialog\"  role=\"document\">\n");
      out.write("                        <div class=\"modal-dialog\">\n");
      out.write("                         <div class=\"modal-content\">\n");
      out.write("                             <div class=\"modal-header\">\n");
      out.write("                                <h4 class=\"modal-title\">Detalle Pedido ID:</h4>\n");
      out.write("                                 <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("\n");
      out.write("                             </div>\n");
      out.write("                             <div class=\"modal-body\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-12\">\n");
      out.write("                                      <strong>1x Pastel de Choclo: </strong>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-12\">\n");
      out.write("                                      <strong>2x Coca-Cola 3L:  </strong>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-12\">\n");
      out.write("                                      <strong>1x Tiramisú:  </strong>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"w-100\"></div>\n");
      out.write("                                    <div class=\"col-12 select-cocina\">\n");
      out.write("                                        <br><br>\n");
      out.write("                                      <div class=\"row\">\n");
      out.write("                                        <div class=\"col-6\">\n");
      out.write("                                          Seleccionar Cocinero:\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-6\">\n");
      out.write("                                          <select class=\"form-control select-cocina\" id=\"exampleFormControlSelect1\">\n");
      out.write("                                            <option>Macarena Rosas</option>\n");
      out.write("                                            <option>Juan Gonzales</option>\n");
      out.write("                                          </select>\n");
      out.write("                                        </div>\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-12\">\n");
      out.write("                                      Garzón/a a cargo: Paulina Rubia\n");
      out.write("                                    </div>\n");
      out.write("                               </div>\n");
      out.write("                             <div class=\"modal-footer\">\n");
      out.write("                                 <button type=\"submit\" class=\"btn btn-100\" name=\"button\"> Listo</button>\n");
      out.write("                             </div>\n");
      out.write("                           </div>\n");
      out.write("                       </div>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("\n");
      out.write("</DIV>\n");
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
