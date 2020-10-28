package org.apache.jsp.bodega;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Insumo;
import java.sql.*;
import Modelo.*;
import oracle.jdbc.OracleTypes;

public final class bodega_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"author\" content=\"\">\n");
      out.write("  <title>Home - Bodega</title>\n");
      out.write("  <link rel=\"icon\" type=\"image/png\" href=\"../img/favicon.png\"/>\n");
      out.write("  <!-- Bootstrap core CSS -->\n");
      out.write("  <link href=\"../vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("  <!-- Custom styles for this template -->\n");
      out.write("  <link href=\"../css/main.css\" rel=\"stylesheet\">\n");
      out.write("  <script src=\"https://kit.fontawesome.com/f298220d4a.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("  \n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body id=\"page-top\">\n");
      out.write("\n");
      out.write("<div class=\"container-fluid caja-header\">\n");
      out.write("  <div class=\"row align-items-center\">\n");
      out.write("    <div class=\"col-lg-4 col-12\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-5\">\n");
      out.write("          <img src=\"images/Logo_Restaurante.png\" class=\"img-fluid\" style=\"max-width:150px;\" alt=\"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\" cabecera\"> \n");
      out.write("            <span><strong>BODEGA</strong></span><br>\n");
      out.write("            <span  class=\"float-left\">Usuario: ");
      out.print(nombre);
      out.write("</span><br>\n");
      out.write("            <span  class=\"float-left\">Fecha: ");
      out.print(fecha);
      out.write("</span><br>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("       \n");
      out.write("    </div>      \n");
      out.write("      <div class=\"col-lg-8 col-12\">\n");
      out.write("          <br>\n");
      out.write("                <div class=\"container\">\n");
      out.write("                 <div class=\"row\">\n");
      out.write("                   <div class=\"col-lg-3 col-md-3  col-4 offset-lg-3 offset-md-2 size\">\n");
      out.write("                     <a type=\"submit\" href=\"pedidos-cocina.jsp\" class=\"btn-bodega btn btn-block\">Cocina</a>\n");
      out.write("                   </div>\n");
      out.write("                   <div class=\"col-lg-3 col-md-3 col-4 size\">\n");
      out.write("                     <a type=\"submit\" href=\"crear-pedido.jsp\" class=\"btn-bodega btn btn-block\">+ Pedido</a>\n");
      out.write("                   </div>\n");
      out.write("                   <div class=\"col-lg-3 col-md-3 col-4 size \">\n");
      out.write("                      <a type=\"submit\" href=\"crear-pedido.jsp\" data-target=\"#exampleModalCenter\"  data-toggle=\"modal\" class=\"btn-bodega btn btn-block\">+ Producto</a>\n");
      out.write("                   </div>\n");
      out.write("                     \n");
      out.write("                     <!-- AGREGAR nuevo INSUMO-->\n");
      out.write("\n");
      out.write("                    <div class=\"modal fade\" id=\"exampleModalCenter\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("                      <div class=\"modal-dialog\"  role=\"document\">\n");
      out.write("                        <div class=\"modal-dialog\">\n");
      out.write("                         <div class=\"modal-content\">\n");
      out.write("                             <div class=\"modal-header\">\n");
      out.write("                                <h4 class=\"modal-title\">Ingresar Producto</h4>\n");
      out.write("                                 <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                             </div>\n");
      out.write("                             <form method=\"POST\" action=\"../ServletBodega\"  enctype=\"multipart/form-data\"> <!-- enctype:  Envía imagen -->\n");
      out.write("                             <div class=\"modal-body\">\n");
      out.write("                                    <div class=\"form-group row\">\n");
      out.write("                                      <label  class=\"col-sm-2 col-form-label\">Nombre</label>\n");
      out.write("                                      <div class=\"col-sm-10\">\n");
      out.write("                                          <input name=\"nombre\" required type=\"text\" class=\"form-control\" placeholder=\"Bebida Fanta 1.5L\">\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                     <div class=\"form-group row\">\n");
      out.write("                                      <label  class=\"col-sm-2 col-form-label\">Unidad</label>\n");
      out.write("                                      <div class=\"col-sm-10\">\n");
      out.write("                                          <select name=\"unidad\" required class=\"form-control\" id=\"exampleFormControlSelect1\">\n");
      out.write("                                            <option disabled selected >Seleccionar</option>\n");
      out.write("                                            <option value=\"u\">Unidad</option>\n");
      out.write("                                            <option value=\"kg\">Kilogramos</option>\n");
      out.write("                                        </select>\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group row\">\n");
      out.write("                                      <label  class=\"col-sm-2 col-form-label\">Categoría</label>\n");
      out.write("                                      <div class=\"col-sm-10\">\n");
      out.write("                                          <select name=\"categoria\" required class=\"form-control\" id=\"exampleFormControlSelect1\">\n");
      out.write("                                            <option disabled selected >Seleccionar</option>\n");
      out.write("                                            <option value=\"Producto\">Producto</option>\n");
      out.write("                                            <option value=\"Ingrediente\">Ingrediente</option>\n");
      out.write("                                          </select>\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group row\">\n");
      out.write("                                      <label  class=\"col-sm-2 col-form-label\">Proveedor</label>\n");
      out.write("                                      <div class=\"col-sm-10\">\n");
      out.write("                                          <select name=\"proveedor\" required class=\"form-control\" id=\"exampleFormControlSelect1\">\n");
      out.write("                                              <option disabled selected >Seleccionar</option>\n");
      out.write("                                            ");
 
                                try 
                                {
                                        BaseDatos bd = new BaseDatos();
                                        Connection connection = bd.getConnection();
                                        if (connection!=null) 
                                  {
                                    //Llamar a procedure
                                      CallableStatement pp=connection.prepareCall("{call LISTARPROVEEDOR (?)}");
                                      pp.registerOutParameter(1, OracleTypes.CURSOR);
                                      pp.execute();
                                      ResultSet resultSet=(ResultSet) pp.getObject(1);

                                         while (resultSet.next()) 
                                         {   
                                             Proveedor pro=new Proveedor();
                                             pro.setId_proveedor(resultSet.getInt("IDPROVEE"));
                                             pro.setNombre_proveedor(resultSet.getString("NOMBRE"));

                                             
      out.write("\n");
      out.write("                                               <option value=\"");
      out.print(pro.getId_proveedor());
      out.write('"');
      out.write('>');
      out.print(pro.getNombre_proveedor());
      out.write("</option>\n");
      out.write("                                             ");

                                         }
                                  }                 



                                    } catch (Exception e) {
                                    }

                            
      out.write("\n");
      out.write("                                      </select>\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group row\">\n");
      out.write("                                      <label  class=\"col-sm-2 col-form-label\">Valor</label>\n");
      out.write("                                      <div class=\"col-sm-10\">\n");
      out.write("                                          <input name=\"valor\" required type=\"text\" title=\"El valor no debe contener letras ni ser negativo\" class=\"form-control\" placeholder=\"$1990\">\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group row\">\n");
      out.write("                                      <label  class=\"col-sm-2 col-form-label\">Stock</label>\n");
      out.write("                                      <div class=\"col-sm-10\">\n");
      out.write("                                          <input name=\"stock\" required type=\"number\" title=\"El Stock no debe contener letras ni ser negativo\"  class=\"form-control\" placeholder=\"45\">\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group row\">\n");
      out.write("                                      <label  class=\"col-sm-2 col-form-label\">Descripción </label>\n");
      out.write("                                      <div class=\"col-sm-10\">\n");
      out.write("                                          <textarea required style=\"overflow:auto;resize:none\" rows=\"4\" class=\"form-control\" name=\"descripcion\" rows=\"4\"></textarea>\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group row\">\n");
      out.write("                                      <label  class=\"col-sm-2 col-form-label\">Imagen</label>\n");
      out.write("                                      <div class=\"col-sm-10\">\n");
      out.write("                                            <div class=\"custom-file\">\n");
      out.write("                                                <input type=\"file\" name=\"imagen\" class=\"custom-file-input\" id=\"customFileLang\" lang=\"es\">\n");
      out.write("                                                <label class=\"custom-file-label\" for=\"customFileLang\">Seleccionar Archivo</label>\n");
      out.write("                                            </div>\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                             </div>\n");
      out.write("                             <div class=\"modal-footer\">\n");
      out.write("                                 <button type=\"button\" class=\"btn \" data-dismiss=\"modal\">Cerrar</button>\n");
      out.write("                                 <button type=\"submit\" value=\"ingresar\" name=\"action\" class=\"btn \">Ingresar</button>\n");
      out.write("                             </div>\n");
      out.write("                             </form>\n");
      out.write("                           </div>\n");
      out.write("                       </div>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("               </div>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("                                      \n");
      out.write(" <Style>\n");
      out.write("\n");
      out.write(".inputWithIcon {\n");
      out.write("  position: relative;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".inputWithIcon i {\n");
      out.write("  position: absolute;\n");
      out.write("  right: 7%;\n");
      out.write("  top: 4px;\n");
      out.write("  padding: 9px 9px;\n");
      out.write("  color: #aaa;\n");
      out.write("  transition: 0.3s;\n");
      out.write("}\n");
      out.write("     </style>                               \n");
      out.write("  <!-- Navegación -->\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"row inputWithIcon buscador\">\n");
      out.write("      <div class=\"inputWithIcon col-lg-4 col-5\">\n");
      out.write("        <input type=\"text\" onkeyup=\"Buscar()\" id=\"buscar\" class=\"form-control\"  class=\"input-buscador \" aria-describedby=\"search\" placeholder=\"Buscar insumo\">\n");
      out.write("      <i class=\"fas fa-search\"></i>\n");
      out.write("      </div>\n");
      out.write("        \n");
      out.write("    <div class=\"col-lg-4 offset-lg-4 col-5\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <form action=\"bodega.jsp\" method=\"get\">\n");
      out.write("                <select class=\"form-control\" name=\"proveedor\" onchange=\"this.form.submit()\">\n");
      out.write("                    <option disabled selected>Filtrar por proveedor</option>\n");
      out.write("            ");
 
                try 
                {
                      // Conexión
                        BaseDatos bd = new BaseDatos();
                        Connection connection = bd.getConnection();
                        if (connection!=null) 
                  {
                    //Llamar a procedimineto LISTARPROVEEOR
                      CallableStatement pp=connection.prepareCall("{call LISTARPROVEEDOR (?)}");
                      pp.registerOutParameter(1, OracleTypes.CURSOR);
                      pp.execute();
                      ResultSet resultSet=(ResultSet) pp.getObject(1);
                         
                         
                         while (resultSet.next()) 
                         {   
                          
                            
                             Proveedor pro=new Proveedor();
                             pro.setId_proveedor(resultSet.getInt("IDPROVEE"));
                             pro.setNombre_proveedor(resultSet.getString("NOMBRE"));
                             
                             
      out.write("\n");
      out.write("                               <option value=\"");
      out.print(pro.getId_proveedor());
      out.write('"');
      out.write('>');
      out.print(pro.getNombre_proveedor());
      out.write("</option>\n");
      out.write("                             ");

                         }
                  }                 
            
                             
                        
                    } catch (Exception e) {
                    }

            
      out.write("\n");
      out.write("                <option value=\"todos\">Ver Todos</option>\n");
      out.write("                </select>\n");
      out.write("            </form>\n");
      out.write("       </div>\n");
      out.write("     </div>\n");
      out.write("        \n");
      out.write("    <!--  <div class=\"col-lg-1 col-1\">\n");
      out.write("        <div type=\"submit\" class=\"btn\"><i class=\"fas fa-search\"></i></div>\n");
      out.write("      </div> -->\n");
      out.write("    </div>\n");
      out.write("    <!-- CONTENIDO -->\n");
      out.write("    \n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-12\">\n");
      out.write("          <table id=\"datos\" number-per-page=\"5\" current-page=\"\" class=\" table table-hover table-responsive-md\">\n");
      out.write("       <thead>\n");
      out.write("       <tr>\n");
      out.write("       <th scope=\"col\">Código</th>\n");
      out.write("       <th scope=\"col\">Nombre</th>\n");
      out.write("       <th scope=\"col\">Unidad</th>\n");
      out.write("       <th scope=\"col\">Stock</th>\n");
      out.write("       <th scope=\"col\">Valor/un</th>\n");
      out.write("       <th scope=\"col\">Categoría</th>      \n");
      out.write("       <th scope=\"col\">Proveedor</th>\n");
      out.write("       <th scope=\"col\">Imagen</th>\n");
      out.write("       <th scope=\"col\">Descripción</th>\n");
      out.write("       <th scope=\"col\">Acciones</th>\n");
      out.write("       </tr>\n");
      out.write("       </thead>\n");
      out.write("        <tbody>\n");
      out.write("         ");
 
            try {
                  BaseDatos bd = new BaseDatos();
                  Connection connection = bd.getConnection();
                  if (connection!=null) 
                  {
                      //rescatar valor de url
                      String prov = null;
                      if(request.getParameter("proveedor")!=null)
                      {
                          prov=request.getParameter("proveedor");
                          if(prov.equals("todos"))
                          {
                            prov=null;
                          }
                      } 
                      
                      //Llamar a procedure
                       CallableStatement pi;
                       ResultSet resultSet;
                      // probar -> out.print(prov);
                      if(prov==null)
                      {
                          pi=connection.prepareCall("{call LISTARINSUMOS (?)}");
                          pi.registerOutParameter(1, OracleTypes.CURSOR);
                          pi.execute();
                           resultSet=(ResultSet) pi.getObject(1);
                      }
                      
                      else
                      {
                          pi=connection.prepareCall("{call FILTRARPROVEEDOR(?,?)}");
                          pi.setInt(1, Integer.parseInt(prov));
                          pi.registerOutParameter(2, OracleTypes.CURSOR);
                          pi.execute();
                          resultSet=(ResultSet) pi.getObject(2);
                      }
                      
                                          
                         while (resultSet.next()) 
                         {   
                             menu++;
                            //Rescata desde BD y se guarda en la clase  
                             Insumo in=new Insumo();
                             in.setId_insumo(resultSet.getInt("IDINSUMO"));
                             in.setCodigo_insumo(resultSet.getString("CODIGO"));
                             in.setNombre_insumo(resultSet.getString("NOMBRE"));
                             in.setUnidad_insumo(resultSet.getString("UNIDAD"));
                             in.setStock_insumo(resultSet.getInt("STOCK"));
                             in.setValor_insumo(resultSet.getInt("VALOR")); 
                             in.setCategoria_insumo(resultSet.getString("CATEGORIA"));
                             in.setDescripcion(resultSet.getString("DESCRIPCION"));
                             in.setImagen_insumo(resultSet.getString("IMAGEN"));
                             String proveedor=(resultSet.getString("NOM"));
                             int idproveedor=resultSet.getInt("PIDPROVEE");
                             
      out.write("\n");
      out.write("                             <tr>\n");
      out.write("                                <th>");
      out.print(in.getCodigo_insumo());
      out.write("</th>\n");
      out.write("                                <td>");
      out.print(in.getNombre_insumo());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(in.getUnidad_insumo() );
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(in.getStock_insumo() );
      out.write("</td>\n");
      out.write("                                <td>");
      out.print("$"+in.getValor_insumo());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(in.getCategoria_insumo());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(proveedor);
      out.write("</td>                           \n");
      out.write("                                <td>\n");
      out.write("                                    <img src=\"../");
      out.print(in.getImagen_insumo());
      out.write("\" class=\"img-fluid img-tabla\">\n");
      out.write("                                </td>\n");
      out.write("                                 <td>");
      out.print(in.getDescripcion());
      out.write("</td> \n");
      out.write("                                <td>\n");
      out.write("                                  <div class=\"form-group\">                                  \n");
      out.write("                                     <select class=\"form-control\" onchange=\"changeFunc(this.value)\" id=\"opcionesMenu");
      out.print(menu);
      out.write("\">\n");
      out.write("                                   <option value=\"0\" selected disabled>Seleccionar</option>\n");
      out.write("                                     <option value=\"Oeditar\">Editar</option>\n");
      out.write("                                     <option value=\"Oeliminar\">Eliminar</option>\n");
      out.write("                                   </select>\n");
      out.write("                                 </div>\n");
      out.write("                               </td>\n");
      out.write("                             </tr>\n");
      out.write("                              \n");
      out.write("                            <!--Modal EDITAR Insumos-->\n");
      out.write("                            <div id=\"editarInsumo");
      out.print(menu);
      out.write("\" class=\"modal fade\"  tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\">\n");
      out.write("                                 <form  enctype=\"multipart/form-data\"  method=\"POST\" action=\"../ServletBodega\">\n");
      out.write("                                     <input type=\"hidden\" name=\"idinsumo\" value=\"");
      out.print(in.getId_insumo());
      out.write("\"></>\n");
      out.write("                                <div class=\"modal-dialog\">\n");
      out.write("                                    <div class=\"modal-content\">\n");
      out.write("                                        <div class=\"modal-header\">\n");
      out.write("                                           <h4 class=\"modal-title\">Editar Producto</h4>\n");
      out.write("                                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"modal-body\">\n");
      out.write("                                          <p>Ingrese los valores a modificar</p>\n");
      out.write("                                                  <div class=\"form-group row\">\n");
      out.write("                                                    <label  class=\"col-sm-2 col-form-label\">Nombre</label>\n");
      out.write("                                                    <div class=\"col-sm-10\">\n");
      out.write("                                                        <input name=\"nombre\" value=\"");
      out.print(in.getNombre_insumo());
      out.write("\" required type=\"text\" class=\"form-control\" placeholder=\"Nombre\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                  </div>\n");
      out.write("                                                   <div class=\"form-group row\">\n");
      out.write("                                                    <label  class=\"col-sm-2 col-form-label\">Unidad</label>\n");
      out.write("                                                    <div class=\"col-sm-10\">\n");
      out.write("                                                        <input name=\"unidad\" readonly value=\"");
      out.print(in.getUnidad_insumo());
      out.write("\" type=\"text\" class=\"form-control\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                  </div>\n");
      out.write("                                                   <div class=\"form-group row\">\n");
      out.write("                                                    <label  class=\"col-sm-2 col-form-label\">Stock </label>\n");
      out.write("                                                    <div class=\"col-sm-10\">\n");
      out.write("              <!-- cambiar tipo de dato-->              <input name=\"stock\" value=\"");
      out.print(in.getStock_insumo());
      out.write("\" required type=\"text\" title=\"El número no debe contener letras ni simbolos y debe ser como máximo de 9 dígitos\"  class=\"form-control\" placeholder=\"Stock\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                  </div>\n");
      out.write("                                                   <div class=\"form-group row\">\n");
      out.write("                                                    <label  class=\"col-sm-2 col-form-label\">Valor($)</label>\n");
      out.write("                                                    <div class=\"col-sm-10\">\n");
      out.write("                                                        <input name=\"valor\" value=\"");
      out.print(in.getValor_insumo());
      out.write("\" readonly  type=\"text\" class=\"form-control\" placeholder=\"$890\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                  </div>\n");
      out.write("                                                   <div class=\"form-group row\">\n");
      out.write("                                                    <label  class=\"col-sm-2 col-form-label\">Proveedor</label>\n");
      out.write("                                                    <div class=\"col-sm-10\">\n");
      out.write("                                                       \n");
      out.write("                                                        <select readonly name=\"proveedor\" required class=\"form-control\">\n");
      out.write("                                                            <option readonly value=\"");
      out.print(idproveedor);
      out.write("\" selected >");
      out.print(proveedor);
      out.write("</option>\n");
      out.write("                                                         </select>\n");
      out.write("                                                    </div>\n");
      out.write("                                                  </div>\n");
      out.write("                                                    \n");
      out.write("                                                     <div class=\"form-group row\">\n");
      out.write("                                                    <label  class=\"col-sm-2 col-form-label\">Categoría</label>\n");
      out.write("                                                    <div class=\"col-sm-10\">\n");
      out.write("                                                        <input name=\"categoria\" value=\"");
      out.print(in.getCategoria_insumo());
      out.write("\" type=\"text\" class=\"form-control\" readonly>\n");
      out.write("                                                    </div>\n");
      out.write("                                                  </div>\n");
      out.write("                                                    \n");
      out.write("                                                <div class=\"form-group row\">\n");
      out.write("                                                    <label  class=\"col-sm-2 col-form-label\">Descripción</label>\n");
      out.write("                                                    <div class=\"col-sm-10\" >\n");
      out.write("                                                         <textarea  style=\"overflow:auto;resize:none\" rows=\"4\" class=\"form-control\" rows=\"4\"  name=\"descripcion\"  resize=\"none\"  rows=\"3\" class=\"form-control\" placeholder=\"Este producto es bajo en calorías, la bolsa es color azul\" class=\"form-control\" id=\"exampleFormControlTextarea1\" resize: none rows=\"3\">");
      out.print(in.getDescripcion());
      out.write("</textarea>\n");
      out.write("                                                     </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"form-group row\">\n");
      out.write("                                                  <label  class=\"col-sm-2 col-form-label\">Imagen</label>\n");
      out.write("                                                  <div class=\"col-sm-10\">\n");
      out.write("                                                        <div class=\"custom-file\">\n");
      out.write("                                                            <input type=\"file\" name=\"imagen\" class=\"custom-file-input\" id=\"customFileLang\" lang=\"es\">\n");
      out.write("                                                            <label class=\"custom-file-label\" for=\"customFileLang\">Seleccionar Archivo</label>\n");
      out.write("                                                        </div>\n");
      out.write("                                                  </div>\n");
      out.write("                                                </div>\n");
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
      out.write("                             \n");
      out.write("                             <!--Modal ELIMINAR insumos-->\n");
      out.write("                         <div id=\"eliminarInsumo");
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
      out.write("                                              <form method=\"POST\" action=\"../ServletBodega\">\n");
      out.write("                                                <input type=\"hidden\" name=\"idinsumo\" value=\"");
      out.print(in.getId_insumo() );
      out.write("\" ></>\n");
      out.write("                                                <button type=\"button\" class=\"btn\" data-dismiss=\"modal\">Cerrar</button>\n");
      out.write("                                                <button type=\"submit\" name=\"action\" value=\"eliminar\" class=\"btn\" >Eliminar</button>\n");
      out.write("                                              </form>\n");
      out.write("                                          </div>\n");
      out.write("                                      </div>\n");
      out.write("                                  </div>\n");
      out.write("                               </div>\n");
      out.write("                          \n");
      out.write("                             ");

                         }
     
                      
                  }
                  connection.close();
                } catch (Exception e) {
                }

            
      out.write("\n");
      out.write("             <input type=\"hidden\" value=\"");
      out.print(menu);
      out.write("\"> </>\n");
      out.write("          </tbody>\n");
      out.write("     </table>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
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
      out.write("            $('#eliminarInsumo");
      out.print(i);
      out.write("').modal(\"show\"); //Open Modal\n");
      out.write("        }\n");
      out.write("        if(opval==\"Oeditar\"){ //Compare it and if true\n");
      out.write("            $('#editarInsumo");
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
      out.write("<div class=\"\">\n");
      out.write("    <section style=\"height:50px;\"></section>\n");
      out.write("    <!----------- Footer ------------>\n");
      out.write("    <footer class=\"footer-bs\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div id=\"centrador\" class=\"col-md-12\">\n");
      out.write("                    <img id=\"imagen\" src=\"../img/gorro.png\" class=\"img-fluid\" alt=\"\">\n");
      out.write("                   <div class=\"col-sm-12 align-self-center text-footer text-center\">\n");
      out.write("                        <p >© Restaurante Siglo XXI - 2020</p>\n");
      out.write("                   </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </footer>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("  <!-- Bootstrap core JavaScript -->\n");
      out.write("  <script src=\"../vendor/jquery/jquery.min.js\"></script>\n");
      out.write("  <script src=\"../vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("  <!-- Plugin JavaScript -->\n");
      out.write("  <script src=\"../vendor/jquery-easing/jquery.easing.min.js\"></script>\n");
      out.write("\n");
      out.write("  <!-- Javascript-->\n");
      out.write("  <script src=\"../js/scrolling-nav.js\"></script>\n");
      out.write("  <script src=\"../js/paginacion.js\"></script>\n");
      out.write("  \n");
      out.write("  \n");
      out.write("   <!--codigo de paginacion-->\n");
      out.write("  <style>\n");
      out.write("  \n");
      out.write("ulll {\n");
      out.write("  list-style: none;\n");
      out.write("  margin-top: 10px;\n");
      out.write("  padding: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("liii {\n");
      out.write("  border-radius: 3px;\n");
      out.write("  color: black;\n");
      out.write("  background: white;\n");
      out.write("  cursor: pointer;\n");
      out.write("  display: inline;\n");
      out.write("  font-weight: 200;\n");
      out.write("  margin: 10px 5px 0px 2px;\n");
      out.write("  /*padding: 10px;*/\n");
      out.write("  text-align: center;\n");
      out.write("  width: 35px;\n");
      out.write(" /* height: 35px;*/\n");
      out.write("}\n");
      out.write("\n");
      out.write(".activa {\n");
      out.write("  background: #cc9650;\n");
      out.write("  color: white;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t$(function(){\n");
      out.write("\t\t$(\"#datos\").pagination();\n");
      out.write("\t});\n");
      out.write("        </script>\n");
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
