package org.apache.jsp.administrador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Insumo;
import java.sql.*;
import Modelo.*;
import oracle.jdbc.OracleTypes;

public final class bodega_002dproveedores_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"es\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"author\" content=\"\">\n");
      out.write("  \n");
      out.write("  <title>Scrolling Nav - Start Bootstrap Template</title>\n");
      out.write("\n");
      out.write("  <!-- Bootstrap core CSS -->\n");
      out.write("  <link href=\"../vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("  <!-- Custom styles for this template -->\n");
      out.write("  <link href=\"../css/scrolling-nav.css\" rel=\"stylesheet\">\n");
      out.write("  <script src=\"https://kit.fontawesome.com/f298220d4a.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script> \n");
      out.write("  <!-- Agregar a css-->\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("   \n");
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
      out.write("          Usuario: ");
      out.print(nombre);
      out.write(" <br>\n");
      out.write("          Fecha: ");
      out.print(fecha);
      out.write(" <br>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"col-lg-9 offset-lg-3 col-12\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("          <nav class=\"navbar navbar-expand-lg\" id=\"mainNav\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("              <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("              </button>\n");
      out.write("              <div class=\"collapse navbar-collapse menu\" id=\"navbarResponsive\">\n");
      out.write("                <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                  <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link js-scroll-trigger\" href=\"empleados.html\">Empleados</a>\n");
      out.write("                  </li>\n");
      out.write("                  <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link js-scroll-trigger\" href=\"caja-ingresos.html\">Caja</a>\n");
      out.write("                  </li>\n");
      out.write("                  <li class=\"nav-item\">\n");
      out.write("                    <a class=\"activo nav-link js-scroll-trigger\" href=\"bodegas-productos.html\">Bodegas</a>\n");
      out.write("                  </li>\n");
      out.write("                  <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link js-scroll-trigger\" href=\"menu-fondo.html\">Menús</a>\n");
      out.write("                  </li>\n");
      out.write("                  <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link js-scroll-trigger\" href=\"clientes.html\">Clientes</a>\n");
      out.write("                  </li>\n");
      out.write("                  <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link js-scroll-trigger\" href=\"reportes.html\">Reportes</a>\n");
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
      out.write("  <!-- buscador -->\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"row buscador\">\n");
      out.write("      <div class=\"col-lg-4 col-9\">\n");
      out.write("        <input type=\"text\" class=\"form-control\"  aria-describedby=\"search\" placeholder=\"Buscar...\">\n");
      out.write("      </div>\n");
      out.write("      <div class=\"col-lg-1 col-1\">\n");
      out.write("        <button type=\"submit\" class=\"btn \"><i class=\"fas fa-search\"></i></button>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- contenido-->\n");
      out.write("    <!-- tarjeta-->\n");
      out.write("    <div class=\"row caja\">\n");
      out.write("      <div class=\"col-2 offset-1\">\n");
      out.write("        <a href=\"bodegas-proveedores.html\"><h5 class=\"activos\">PROVEEDORES</h5></a>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"col-2\">\n");
      out.write("        <a href=\"bodegas-productos.html\"><h5 class=\"\">PRODUCTOS</h5></a>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"row tabla-ingresos\">\n");
      out.write("      <div class=\"col-12\">\n");
      out.write("        <table class=\" table table-hover table-responsive\">\n");
      out.write("       <thead>\n");
      out.write("       <tr>\n");
      out.write("       <th scope=\"col\">Nombre</th>\n");
      out.write("       <th scope=\"col\">Rut</th>\n");
      out.write("       <th scope=\"col\">Teléfono</th>\n");
      out.write("       <th scope=\"col\">Correo</th>\n");
      out.write("       <th scope=\"col\">Dirección</th>\n");
      out.write("       <th scope=\"col\">Acciones</th>\n");
      out.write("       </tr>\n");
      out.write("       </thead>\n");
      out.write("        <tbody>\n");
      out.write("            ");
 
                
            try {
                  BaseDatos bd = new BaseDatos();
                  Connection connection = bd.getConnection();
                  if (connection!=null) 
                  {
                      
                      
                    //Llamar a procedure
                        CallableStatement pi;
                        ResultSet resultSet;
                        pi=connection.prepareCall("{call  LISTARPROVEEDOR (?)}");
                        pi.registerOutParameter(1, OracleTypes.CURSOR);
                        pi.execute();
                        resultSet=(ResultSet) pi.getObject(1);
                       
                         while (resultSet.next()) 
                         {    
                             menu++;
                             Proveedor pro=new Proveedor();
                             pro.setId_proveedor(resultSet.getInt("IDPROVEE"));
                             pro.setNombre_proveedor(resultSet.getString("NOMBRE"));
                             pro.setRut_proveedor(resultSet.getString("RUTEMPRESA"));
                             pro.setTelefono_proveedor(resultSet.getInt("TELEFONO"));
                             pro.setCorreo_proveedor(resultSet.getString("CORREO"));
                             pro.setDireccion_proveedor(resultSet.getString("DIRECCION"));
                             
                             
      out.write("\n");
      out.write("                             <tr>\n");
      out.write("                                <th>");
      out.print(pro.getNombre_proveedor());
      out.write("</th>\n");
      out.write("                                <td>");
      out.print(pro.getRut_proveedor());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(pro.getTelefono_proveedor());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(pro.getCorreo_proveedor());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(pro.getDireccion_proveedor());
      out.write("</td>\n");
      out.write("                                <td>\n");
      out.write("                                  <div class=\"form-group\">\n");
      out.write("                                   <select class=\"form-control\" onchange=\"changeFunc(this.value)\" id=\"opcionesMenu");
      out.print(menu);
      out.write("\">\n");
      out.write("                                       <option value=\"0\" selected disabled>Seleccionar</option>\n");
      out.write("                                     <option value=\"Oeditar\">Editar</option>\n");
      out.write("                                     <option value=\"Oeliminar\">Eliminar</option>\n");
      out.write("                                   </select>\n");
      out.write("                                 </div>\n");
      out.write("                               </td>\n");
      out.write("                             </tr>\n");
      out.write("                             <div id=\"editarProveedor");
      out.print(menu);
      out.write("\" class=\"modal fade\"  tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\">\n");
      out.write("                                 <form method=\"POST\" action=\"../ServletProveedor\">\n");
      out.write("                                     <input type=\"hidden\" name=\"idproveedor\" value=\"");
      out.print(pro.getId_proveedor());
      out.write("\" ></>\n");
      out.write("                                <div class=\"modal-dialog\">\n");
      out.write("                                    <div class=\"modal-content\">\n");
      out.write("                                        <div class=\"modal-header\">\n");
      out.write("                                           <h4 class=\"modal-title\">Editar Proveedor</h4>\n");
      out.write("                                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"modal-body\">\n");
      out.write("                                          <p>Ingrese los valores a modificar</p>\n");
      out.write("                                                  <div class=\"form-group row\">\n");
      out.write("                                                    <label  class=\"col-sm-2 col-form-label\">Nombre</label>\n");
      out.write("                                                    <div class=\"col-sm-10\">\n");
      out.write("                                                        <input name=\"nombre\" value=\"");
      out.print(pro.getNombre_proveedor());
      out.write("\" required type=\"text\" class=\"form-control\" placeholder=\"Nombre\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                  </div>\n");
      out.write("                                                   <div class=\"form-group row\">\n");
      out.write("                                                    <label  class=\"col-sm-2 col-form-label\">Rut</label>\n");
      out.write("                                                    <div class=\"col-sm-10\">\n");
      out.write("                                                        <input name=\"rut\" readonly value=\"");
      out.print(pro.getRut_proveedor());
      out.write("\" required type=\"text\" class=\"form-control\" placeholder=\"Rut\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                  </div>\n");
      out.write("                                                   <div class=\"form-group row\">\n");
      out.write("                                                    <label  class=\"col-sm-2 col-form-label\">Teléfono</label>\n");
      out.write("                                                    <div class=\"col-sm-10\">\n");
      out.write("                                                        <input name=\"telefono\" value=\"");
      out.print(pro.getTelefono_proveedor());
      out.write("\" required type=\"tel\" title=\"El número no debe contener letras ni simbolos y debe ser como máximo de 9 dígitos\" pattern=\"[0-9]{9}\" class=\"form-control\" placeholder=\"Teléfono\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                  </div>\n");
      out.write("                                                   <div class=\"form-group row\">\n");
      out.write("                                                    <label  class=\"col-sm-2 col-form-label\">Correo</label>\n");
      out.write("                                                    <div class=\"col-sm-10\">\n");
      out.write("                                                        <input name=\"correo\" value=\"");
      out.print(pro.getCorreo_proveedor());
      out.write("\" required type=\"email\" class=\"form-control\" placeholder=\"Correo\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                  </div>\n");
      out.write("                                                   <div class=\"form-group row\">\n");
      out.write("                                                    <label  class=\"col-sm-2 col-form-label\">Dirección</label>\n");
      out.write("                                                    <div class=\"col-sm-10\">\n");
      out.write("                                                        <input name=\"direccion\" value=\"");
      out.print(pro.getDireccion_proveedor());
      out.write("\" required type=\"text\" class=\"form-control\" placeholder=\"Dirección\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                  </div>\n");
      out.write("                                          </div>\n");
      out.write("                                        <div class=\"modal-footer\">\n");
      out.write("                                            <button type=\"button\" class=\"btn \" data-dismiss=\"modal\">Cerrar</button>\n");
      out.write("                                            <button data-toggle=\"modal\" data-target=\"#editar");
      out.print(menu);
      out.write("\" type=\"button\" class=\"btn\">Modificar</button>\n");
      out.write("\n");
      out.write("                                            <div class=\"modal fade\" id=\"editar");
      out.print(menu);
      out.write("\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("                                              <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("                                                <div class=\"modal-content\">\n");
      out.write("                                                  <div class=\"modal-header\">\n");
      out.write("                                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                                      <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                                    </button>\n");
      out.write("                                                  </div>\n");
      out.write("                                                  <div class=\"modal-body\">\n");
      out.write("                                                    ¿Está seguro de modificar este producto?\n");
      out.write("                                                  </div>\n");
      out.write("                                                  <div class=\"modal-footer\">\n");
      out.write("                                                      <button type=\"submit\" name=\"action\" value=\"editar\" class=\"btn \">Sí</button>\n");
      out.write("                                                    <button type=\"button\" class=\"btn\" data-dismiss=\"modal\">No</button>\n");
      out.write("                                                  </div>\n");
      out.write("                                                </div>\n");
      out.write("                                              </div>\n");
      out.write("                                            </div>\n");
      out.write("                                       </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                               </form>\n");
      out.write("                            </div>\n");
      out.write("                                <div id=\"eliminarProveedor");
      out.print(menu);
      out.write("\" class=\"modal fade\"  tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\">\n");
      out.write("                                  <div class=\"modal-dialog\">\n");
      out.write("                                      <div class=\"modal-content\">\n");
      out.write("                                          <div class=\"modal-header\">\n");
      out.write("                                              <h4 class=\"modal-title\">¿Estás seguro?</h4>\n");
      out.write("                                              <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                                          </div>\n");
      out.write("                                          <div class=\"modal-body\">\n");
      out.write("                                              <p>Si borra este insumo no lo podrá recuperar</p>\n");
      out.write("\n");
      out.write("                                          </div>\n");
      out.write("                                          <div class=\"modal-footer\">\n");
      out.write("                                              <form method=\"POST\" action=\"../ServletProveedor\">\n");
      out.write("                                                <input type=\"hidden\" name=\"rut\" value=\"");
      out.print(pro.getRut_proveedor() );
      out.write("\" ></>\n");
      out.write("                                                <button type=\"button\" class=\"btn\" data-dismiss=\"modal\">Cerrar</button>\n");
      out.write("                                                <button type=\"submit\" name=\"action\" value=\"eliminar\" class=\"btn\" >Eliminar</button>\n");
      out.write("                                              </form>\n");
      out.write("                                          </div>\n");
      out.write("                                      </div>\n");
      out.write("                                  </div>\n");
      out.write("                               </div>\n");
      out.write("                             ");

                                  
                         }
                  }
                  connection.close();
                } 
                catch (Exception e) {
                }
            
      out.write("\n");
      out.write("        <input type=\"hidden\" value=\"");
      out.print(menu);
      out.write("\"> </>\n");
      out.write("        </tbody>\n");
      out.write("     </table>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"row \">\n");
      out.write("      <div class=\"col-2 offset-1\">\n");
      out.write("          <button  type=\"submit\" data-toggle=\"modal\" data-target=\"#exampleModalCenter\"  class=\"btn-caja btn\">+</button>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("               \n");
      out.write("<!-- Modal Ingresar Proveedor-->\n");
      out.write("                    <div class=\"modal fade\" id=\"exampleModalCenter\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("                      <div class=\"modal-dialog\"  role=\"document\">\n");
      out.write("                        <div class=\"modal-dialog\">\n");
      out.write("                         <div class=\"modal-content\">\n");
      out.write("                             <div class=\"modal-header\">\n");
      out.write("                                <h4 class=\"modal-title\">Ingresar Proveedor</h4>\n");
      out.write("                                 <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("\n");
      out.write("                             </div>\n");
      out.write("                             <form method=\"POST\" action=\"../ServletProveedor\">\n");
      out.write("                             <div class=\"modal-body\">\n");
      out.write("                                 \n");
      out.write("                                    <div class=\"form-group row\">\n");
      out.write("                                      <label  class=\"col-sm-2 col-form-label\">Nombre</label>\n");
      out.write("                                      <div class=\"col-sm-10\">\n");
      out.write("                                          <input name=\"nombre\" required type=\"text\" class=\"form-control\" placeholder=\"Nombre\">\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                     <div class=\"form-group row\">\n");
      out.write("                                      <label  class=\"col-sm-2 col-form-label\">Rut</label>\n");
      out.write("                                      <div class=\"col-sm-10\">\n");
      out.write("                                          <input name=\"rut\" required type=\"text\" class=\"form-control\" placeholder=\"Rut\">\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                     <div class=\"form-group row\">\n");
      out.write("                                      <label  class=\"col-sm-2 col-form-label\">Teléfono</label>\n");
      out.write("                                      <div class=\"col-sm-10\">\n");
      out.write("                                          <input name=\"telefono\" required type=\"tel\" title=\"El número no debe contener letras ni simbolos y debe ser como máximo de 9 dígitos\" pattern=\"[0-9]{9}\" class=\"form-control\" placeholder=\"Teléfono\">\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                     <div class=\"form-group row\">\n");
      out.write("                                      <label  class=\"col-sm-2 col-form-label\">Correo</label>\n");
      out.write("                                      <div class=\"col-sm-10\">\n");
      out.write("                                          <input name=\"correo\" required type=\"email\" class=\"form-control\" placeholder=\"Correo\">\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                     <div class=\"form-group row\">\n");
      out.write("                                      <label  class=\"col-sm-2 col-form-label\">Dirección</label>\n");
      out.write("                                      <div class=\"col-sm-10\">\n");
      out.write("                                          <input name=\"direccion\" required type=\"text\" class=\"form-control\" placeholder=\"Dirección\">\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                 \n");
      out.write("                             </div>\n");
      out.write("                             <div class=\"modal-footer\">\n");
      out.write("                                 <button type=\"button\" class=\"btn \" data-dismiss=\"modal\">Cerrar</button>\n");
      out.write("                                 <button type=\"submit\" value=\"ingresar\" name=\"action\" class=\"btn \">Ingresar</button>\n");
      out.write("                             </div>\n");
      out.write("                             </form>\n");
      out.write("                         </div>\n");
      out.write("                     </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("  <!-- Script Modal Editar Eliminar-->\n");

      for (int i = 1; i <= menu; i++) 
      {  

      out.write("\n");
      out.write("<script> $(document).ready(function()\n");
      out.write("{   //Make script DOM ready\n");
      out.write("   \n");
      out.write("        $('#opcionesMenu");
      out.print(i);
      out.write("').change(function() { //jQuery Change Function\n");
      out.write("        var opval = $(this).val(); //Get value from select element\n");
      out.write("        if(opval==\"Oeliminar\")\n");
      out.write("        { //Compare it and if true\n");
      out.write("            $('#eliminarProveedor");
      out.print(i);
      out.write("').modal(\"show\"); //Open Modal\n");
      out.write("        }\n");
      out.write("        if(opval==\"Oeditar\"){ //Compare it and if true\n");
      out.write("            $('#editarProveedor");
      out.print(i);
      out.write("').modal(\"show\"); //Open Modal\n");
      out.write("        }\n");
      out.write("        $('#opcionesMenu");
      out.print(i);
      out.write("').val('0');\n");
      out.write("    });\n");
      out.write("});\n");
      out.write("</script>\n");
      
  }

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
