package org.apache.jsp.cocina;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;
import Modelo.*;
import oracle.jdbc.OracleTypes;

public final class jefe_002dcocina_jsp extends org.apache.jasper.runtime.HttpJspBase
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
     int form=0;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("  <title>Cocina - Jefe Cocina</title>\n");
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
      out.write("          Usuario: ");
      out.print(nombre);
      out.write(" <br>\n");
      out.write("          Fecha: ");
      out.print(fecha);
      out.write(" <br>\n");
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
      out.write("                <h4>Recetas</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-12\">\n");
      out.write("              <table class=\" table table-hover table-responsive-md\">\n");
      out.write("             <thead>\n");
      out.write("             <tr>\n");
      out.write("             <th scope=\"col\">ID</th>\n");
      out.write("             <th scope=\"col\">Nombre</th>\n");
      out.write("             <th scope=\"col\">Rinde/porciones</th>\n");
      out.write("             <th scope=\"col\">Detalle</th>\n");
      out.write("             <th scope=\"col\">Solicitar</th>\n");
      out.write("             <th scope=\"col\"></th>\n");
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
                                      CallableStatement pp=connection.prepareCall("{call LISTARRECETAS (?)}");
                                      pp.registerOutParameter(1, OracleTypes.CURSOR);
                                      pp.execute();
                                      resultSet=(ResultSet) pp.getObject(1);
                                      int rece=-1;
                                         while (resultSet.next()) 
                                         {   
                                             if(resultSet.getInt("IDRECETA")==rece)
                                             {
                                                 continue;
                                             }
                                             menu++;
                                             
                                            
                                             rece=resultSet.getInt("IDRECETA");
                                             Recetas re=new Recetas();
                                             re.setId_receta(resultSet.getInt("IDRECETA"));
                                             re.setNombre_receta(resultSet.getString("NOMBRE"));
                                             re.setDescripcion_receta(resultSet.getString("DESCRIPCION"));
                                             re.setCategoria_receta(resultSet.getString("CATEGORIA"));
                                             re.setPorciones_receta(resultSet.getInt("PORCIONES"));
                                             
                                             
                                       
                                             
      out.write("\n");
      out.write("                <tr>\n");
      out.write("              <form action=\"../ServletPedCocina\" method=\"POST\"> \n");
      out.write("                  <input type=\"hidden\" name=\"idreceta\" value=\"");
      out.print(re.getId_receta());
      out.write("\">\n");
      out.write("                  <input type=\"hidden\" name=\"porciones\" value=\"");
      out.print(re.getPorciones_receta() );
      out.write("\">\n");
      out.write("                   <th>");
      out.print(re.getId_receta());
      out.write("</th>\n");
      out.write("                   <th>");
      out.print(re.getNombre_receta());
      out.write("</th>\n");
      out.write("                   <td>");
      out.print(re.getPorciones_receta() );
      out.write("</td>\n");
      out.write("                   <td>\n");
      out.write("                    <button  type=\"button\" data-toggle=\"modal\" data-target=\"#modalreceta");
      out.print(menu);
      out.write("\"  class=\"btn btn-100\">Ver</button>\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                       <input required type=\"number\" class=\"form-control input-buscador\"  name=\"cantidad\">\n");
      out.write("                   </td>\n");
      out.write("                   <td>\n");
      out.write("                       <button type=\"submit\" value=\"ingresar\" name=\"estado\" class=\"btn-caja btn\">Pedir</button>\n");
      out.write("                   </td>\n");
      out.write("                </tr>\n");
      out.write("              </form>\n");
      out.write("  <!-- Modal Solicitudes de pedido-->\n");
      out.write("                    <div class=\"modal fade\" id=\"modalreceta");
      out.print(menu);
      out.write("\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("                      <div class=\"modal-dialog\"  role=\"document\">\n");
      out.write("                        <div class=\"modal-dialog\">\n");
      out.write("                         <div class=\"modal-content\">\n");
      out.write("                             <div class=\"modal-header\">\n");
      out.write("                                <h4 class=\"modal-title\">Detalle Receta ID: ");
      out.print(re.getId_receta());
      out.write("</h4>\n");
      out.write("                                 <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("\n");
      out.write("                             </div>\n");
      out.write("                             <div class=\"modal-body\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-12 text-center\">\n");
      out.write("                                        <h5> <strong>");
      out.print(re.getNombre_receta());
      out.write("</strong></h5>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-12 text-left\">\n");
      out.write("                                      <strong>Ingredientes</strong>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"w-100\"></div>\n");
      out.write("                                    <div class=\"col-6\">\n");
      out.write("                                        <form action=\"../ServletReceta\" method=\"POST\" >\n");
      out.write("                                            <input name=\"modal\" type=\"hidden\" value=\"");
      out.print(menu);
      out.write("\">\n");
      out.write("                                            <input  type=\"hidden\" name=\"idreceta\" value=\"");
      out.print(re.getId_receta());
      out.write("\">\n");
      out.write("                                        <select name=\"insumo\" class=\"form-control\" id=\"opcionesMenu");
      out.print(menu);
      out.write("\">\n");
      out.write("                                            <option selected disabled value=\"0\">Seleccionar</option>\n");
      out.write("                                   ");
 pp=connection.prepareCall("{call LISTARINSUMOS (?)}");
                                      pp.registerOutParameter(1, OracleTypes.CURSOR);
                                      pp.execute();
                                      rs=(ResultSet) pp.getObject(1);

                                         while (rs.next()) 
                                         {   
                                             Insumo in=new Insumo();
                                             in.setId_insumo(rs.getInt("IDINSUMO"));
                                             in.setNombre_insumo(rs.getString("NOMBRE"));

                                             
      out.write("\n");
      out.write("                                             <option value=\"");
      out.print(in.getId_insumo());
      out.write('"');
      out.write('>');
      out.print(in.getNombre_insumo() );
      out.write("</option>\n");
      out.write("                                       ");

                                         }
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-6\">\n");
      out.write("                                        <button type=\"submit\" name=\"action\" value=\"agregar\"  class=\"btn-100 btn\" >Agregar</button>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-12\"><hr></div>\n");
      out.write("                                    <div class=\"col-12\">\n");
      out.write("                                      <div class=\"row text-center\">\n");
      out.write("                                        <div class=\"col-5 text center\">\n");
      out.write("                                          Producto\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-5\">\n");
      out.write("                                          Cantidad\n");
      out.write("                                        </div>\n");
      out.write("                                      </div>\n");
      out.write("                                        <div class=\"row tex-center\" >\n");
      out.write("                                            \n");
      out.write("                                            <div class=\"col-12\" id=\"insumos-receta");
      out.print(menu);
      out.write("\">\n");
      out.write("                                                \n");
      out.write("                                          ");
 pp=connection.prepareCall("{call LISTARRECETAINSUMO (?)}");
                                      pp.registerOutParameter(1, OracleTypes.CURSOR);
                                      pp.execute();
                                      res=(ResultSet) pp.getObject(1);
                                       
                                        
                                            
                                         while (res.next()) 
                                         {   
                                               if ((res.getInt("IDRECETA"))!=(re.getId_receta())) 
                                                {
                                                       continue;
                                                }
                                               form++;
                                             
      out.write("\n");
      out.write("                                             <input type=\"hidden\" name=\"idinsumo\" value=\"");
      out.print(res.getInt("IDINSUMO"));
      out.write("\">\n");
      out.write("                                           <div class=\"form-group row\">\n");
      out.write("                                            <div class=\"col-5\">\n");
      out.write("                                              <input type=\"text\" class=\"form-control input-100\"  value=\"");
      out.print(res.getString("NOMBRE_INSUMO"));
      out.write("\" disabled >\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-5\">\n");
      out.write("                                                <input type=\"number\"  name=\"cantidad\" value=\"");
      out.print(res.getInt("CANTIDAD"));
      out.write("\" class=\"form-control input-100\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-2\">\n");
      out.write("                                                    <button  type=\"submit\" class=\"btn-100 btn\" name=\"action\" value=\"eliminar");
      out.print(res.getInt("IDINSUMO"));
      out.write("\" >x</button>\n");
      out.write("                                            </div>\n");
      out.write("                                           </div>\n");
      out.write("                                           \n");
      out.write("                                        ");

                                         }
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                      </div>\n");
      out.write("                                        <br><HR>\n");
      out.write("                                      <div class=\"row\">\n");
      out.write("                                        <div class=\"col-4\">\n");
      out.write("                                          Esta recete rinde:\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-4\">\n");
      out.write("                                            <input  type=\"number\" name=\"porcion\" class=\"form-control input-100\" value=\"");
      out.print(re.getPorciones_receta() );
      out.write("\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-4\">\n");
      out.write("                                          Porciones\n");
      out.write("                                        </div>\n");
      out.write("                                      </div>\n");
      out.write("                                      <br>\n");
      out.write("                                      <div class=\"row\">\n");
      out.write("                                        <div class=\"col-4 offset-8\">\n");
      out.write("                                          <button  type=\"button\" class=\"btn btn-100\" name=\"button\">Editar</button>\n");
      out.write("                                        </div>\n");
      out.write("                                      </div>\n");
      out.write("                                      <br>\n");
      out.write("                                </div>\n");
      out.write("                             </div>\n");
      out.write("                             <div class=\"modal-footer\">\n");
      out.write("                                 <button  type=\"submit\" class=\"btn btn-100\" name=\"action\" value=\"editar\">Guardar</button>\n");
      out.write("                                  </form>\n");
      out.write("                             </div>\n");
      out.write("                           </div>\n");
      out.write("                       </div>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
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
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <script>\n");
      out.write("   $( document ).ready(function() {\n");
      out.write("       var modal=");
      out.print(request.getParameter("modal"));
      out.write("\n");
      out.write("       if(modal)\n");
      out.write("       {\n");
      out.write("           $('#modalreceta'+modal+'').modal('toggle');\n");
      out.write("       }\n");
      out.write("    \n");
      out.write("});\n");
      out.write("  </script>\n");
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
