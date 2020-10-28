<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Insumo"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.*"%>
<%@page import="oracle.jdbc.OracleTypes"%>
<%
    HttpSession actual=request.getSession(true);
    String nombre=(String)actual.getAttribute("nombre");
    String fecha=(String)actual.getAttribute("fecha");
    out.println((String)actual.getAttribute("error"));
    int menu=0;
%>
<!DOCTYPE html>
<html lang="es">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Insumos - Admin </title>

  <!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="../css/main.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/f298220d4a.js" crossorigin="anonymous"></script>
  <!-- Agregar a css-->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body id="page-top">

<div class="container-fluid caja-header">
  <div class="row">
    <div class="col-lg-4 col-12">
      <div class="row ">
        <div class="col-6">
          <img src="images/Logo_Restaurante.png" class="img-fluid" style="max-width:150px;" alt="">
        </div>
        <div class="col-6">
          <strong>ADMINISTRADOR</strong><br>
          Usuario: <%=nombre%> <br>
          Fecha: <%=fecha%> <br>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-lg-9 offset-lg-3 col-12">
      <div class="row">
          <nav class="navbar navbar-expand-lg navbar-light" id="mainNav">
            <div class="container">
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse menu" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="empleados.jsp">Empleados</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="caja-ingresos.jsp">Caja</a>
                  </li>
                  <li class="nav-item">
                    <a class="activo nav-link js-scroll-trigger" href="bodega-productos.jsp">Bodegas</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="menu.jsp">Menús</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="cliente.jsp">Clientes</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="reportes.jsp">Reportes</a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
    </div>
  </div>
  </div>

</div>
  <!-- buscador -->
  <div class="container-fluid">
    <div class="row buscador">
      <div class="col-lg-4 col-9 offset-1 offset-lg-1">
        <input type="text" class="form-control"  aria-describedby="search" placeholder="Buscar...">
      </div>
      <div class="col-lg-1 col-1">
        <button type="submit" class="btn "><i class="fas fa-search"></i></button>
      </div>
    </div>
    <!-- contenido-->
    <!-- tarjeta-->
    <div class="row caja">
      <div class="col-2 offset-1">
        <a href="bodega-proveedores.jsp"><h5 class="">PROVEEDORES</h5></a>
      </div>
      <div class="col-2">
        <a href="bodega-productos.jsp"><h5 class="activos">PRODUCTOS</h5></a>
      </div>
    </div>
    <div class="row tabla-ingresos">
      <div class="col-12">
        <table class=" table table-hover table-responsive">
       <thead>
       <tr>
       <th scope="col">Nombre</th>
       <th scope="col">Unidad</th>
       <th scope="col">Proveedor</th>
       <th scope="col">Stock</th>
       <th scope="col">Valor/unidad</th>
       <th scope="col">Categoría</th>
       <th scope="col">Imagen</th>
       <th scope="col">Acciones</th>
       </tr>
       </thead>
        <tbody>
             <% 
                
            try {
                  BaseDatos bd = new BaseDatos();
                  Connection connection = bd.getConnection();
                  if (connection!=null) 
                  {
                      
                      
                    //Llamar a procedure
                        CallableStatement pi;
                        ResultSet resultSet;
                        pi=connection.prepareCall("{call LISTARINSUMOS (?)}");
                        pi.registerOutParameter(1, OracleTypes.CURSOR);
                        pi.execute();
                        resultSet=(ResultSet) pi.getObject(1);
                       
                         while (resultSet.next()) 
                         {    
                             menu++;
                             Insumo in=new Insumo();
                             in.setId_insumo(resultSet.getInt("IDINSUMO"));
                             in.setNombre_insumo(resultSet.getString("NOMBRE"));
                             in.setUnidad_insumo(resultSet.getString("UNIDAD"));
                             in.setStock_insumo(resultSet.getInt("STOCK"));
                             in.setValor_insumo(resultSet.getInt("VALOR"));
                             in.setCategoria_insumo(resultSet.getString("CATEGORIA"));
                             in.setImagen_insumo(resultSet.getString("IMAGEN"));
                             String proveedor=(resultSet.getString("NOM"));
                             
                             %>
                             <tr>
                                <th><%=in.getNombre_insumo()%></th>
                                <td><%=in.getUnidad_insumo()%></td>
                                <td><%=proveedor%></td>
                                <td><%=in.getStock_insumo()%></td>
                                <td><%="$"+in.getValor_insumo()%></td>
                                <td><%=in.getCategoria_insumo()%></td>
                                <td>
                                    <img src="../<%=in.getImagen_insumo()%>" class="img-fluid img-tabla">
                                </td>
                                <td>
                                  <div class="form-group">
                                   <select class="form-control" onchange="changeFunc(this.value)" id="opcionesMenu<%=menu%>">
                                       <option value="0" selected disabled>Seleccionar</option>
                                     <option value="Oeditar">Editar</option>
                                     <option value="Oeliminar">Eliminar</option>
                                   </select>
                                 </div>
                               </td>
                             </tr>
                             <!--Modal EDITAR Insumos-->
                            <div id="editarInsumo<%=menu%>" class="modal fade"  tabindex="-1" role="dialog" aria-hidden="true">
                                 <form method="POST" action="../ServletProveedor">
                                     <input type="hidden" name="idinsumo" value="<%=in.getId_insumo()%>" ></>
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                           <h4 class="modal-title">Editar Producto</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>

                                        </div>
                                        <div class="modal-body">
                                          <p>Ingrese los valores a modificar</p>
                                                  <div class="form-group row">
                                                    <label  class="col-sm-2 col-form-label">Nombre</label>
                                                    <div class="col-sm-10">
                                                        <input name="nombre" value="<%=in.getNombre_insumo()%>" required type="text" class="form-control" placeholder="Nombre">
                                                    </div>
                                                  </div>
                                                   <div class="form-group row">
                                                    <label  class="col-sm-2 col-form-label">Unidad</label>
                                                    <div class="col-sm-10">
                                                        <input name="unidad" readonly value="<%=in.getUnidad_insumo()%>" required type="text" class="form-control">
                                                    </div>
                                                  </div>
                                                   <div class="form-group row">
                                                    <label  class="col-sm-2 col-form-label">Stock </label>
                                                    <div class="col-sm-10">
              <!-- cambiar tipo de dato-->              <input name="stock" value="<%=in.getStock_insumo()%>" required type="text" title="El número no debe contener letras ni simbolos y debe ser como máximo de 9 dígitos"  class="form-control" placeholder="Stock">
                                                    </div>
                                                  </div>
                                                   <div class="form-group row">
                                                    <label  class="col-sm-2 col-form-label">Valor</label>
                                                    <div class="col-sm-10">
                                                        <input name="valor" value="<%="$"+in.getValor_insumo()%>" disabled required type="text" class="form-control" placeholder="$890">
                                                    </div>
                                                  </div>
                                                   <div class="form-group row">
                                                    <label  class="col-sm-2 col-form-label">Proveedor</label>
                                                    <div class="col-sm-10">
                                                        <input name="proveedor" value="<%=proveedor%>" required type="text" class="form-control" readonly>
                                                    </div>
                                                  </div>
                                                    
                                                <div class="form-group row">
                                                    <label  class="col-sm-2 col-form-label">Descripción</label>
                                                    <div class="col-sm-10" >
                                                         <textarea  style="overflow:auto;resize:none" rows="4" class="form-control" rows="4"  name="descripcion"  resize="none"  rows="3" class="form-control" placeholder="Este producto es bajo en calorías, la bolsa es color azul" class="form-control" id="exampleFormControlTextarea1" resize: none rows="3"><%=in.getDescripcion()%></textarea>
                                                     </div>
                                                                                                      </div>
                                          </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn " data-dismiss="modal">Cerrar</button>
                                            <button data-toggle="modal" data-target="#editar<%=menu%>" type="button" class="btn">Modificar</button>

                                            <div class="modal fade" id="editar<%=menu%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                              <div class="modal-dialog modal-dialog-centered" role="document">
                                                <div class="modal-content">
                                                  <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                      <span aria-hidden="true">&times;</span>
                                                    </button>
                                                  </div>
                                                  <div class="modal-body">
                                                    ¿Está seguro de modificar este producto?
                                                  </div>
                                                  <div class="modal-footer">
                                                      <button type="submit" name="action" value="editar" class="btn ">Sí</button>
                                                    <button type="button" class="btn" data-dismiss="modal">No</button>
                                                  </div>
                                                </div>
                                              </div>
                                            </div>
                                       </div>
                                    </div>
                                </div>
                               </form>
                            </div>
                             
                             <!--Modal ELIMINAR insumos-->
                         <div id="eliminarInsumo<%=menu%>" class="modal fade"  tabindex="-1" role="dialog" aria-hidden="true">
                                  <div class="modal-dialog">
                                      <div class="modal-content">
                                          <div class="modal-header">
                                              <h4 class="modal-title">¿Estás seguro?</h4>
                                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                          </div>
                                          <div class="modal-body">
                                              <p>Si borra este insumo no lo podrá recuperar</p>

                                          </div>
                                          <div class="modal-footer">
                                              <form method="POST" action="../ServletBodega">
                                                <input type="hidden" name="idinsumo" value="<%=in.getId_insumo() %>" ></>
                                                <button type="button" class="btn" data-dismiss="modal">Cerrar</button>
                                                <button type="submit" name="action" value="eliminar" class="btn" >Eliminar</button>
                                              </form>
                                          </div>
                                      </div>
                                  </div>
                               </div>
                       <%
                                  
                         }
                  }
                  connection.close();
                } 
                catch (Exception e) {
                }
            %>

        </tbody>
     </table>
      </div>
    </div>

    <div class="row ">
      <div class="col-2 offset-1">
          <button  type="submit" data-toggle="modal" data-target="#exampleModalCenter"  class="btn-caja btn">+</button>
      </div>
    </div>
    <!-- Modal Ingresar Producto-->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
      <div class="modal-dialog"  role="document">
        <div class="modal-dialog">
         <div class="modal-content">
             <div class="modal-header">
                <h4 class="modal-title">Ingresar Producto</h4>
                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
             </div>
             <form method="POST" action="../ServletInsumo"  enctype="multipart/form-data">
             <div class="modal-body">
                    <div class="form-group row">
                      <label  class="col-sm-2 col-form-label">Nombre</label>
                      <div class="col-sm-10">
                          <input name="nombre" required type="text" class="form-control" placeholder="Nombre">
                      </div>
                    </div>
                     <div class="form-group row">
                      <label  class="col-sm-2 col-form-label">Unidad</label>
                      <div class="col-sm-10">
                          <select name="unidad" required class="form-control" id="exampleFormControlSelect1">
                            <option disabled selected >Seleccionar</option>
                            <option value="u">Unidad</option>
                            <option value="kg">Kilogramos</option>
                        </select>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label  class="col-sm-2 col-form-label">Categoría</label>
                      <div class="col-sm-10">
                          <select name="categoria" required class="form-control" id="exampleFormControlSelect1">
                            <option disabled selected >Seleccionar</option>
                            <option value="Producto">Producto</option>
                            <option value="Ingrediente">Ingrediente</option>
                          </select>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label  class="col-sm-2 col-form-label">Proveedor</label>
                      <div class="col-sm-10">
                          <select name="proveedor" required class="form-control" id="exampleFormControlSelect1">
                            <option disabled selected >Seleccionar</option>
                            <option value="1" >1</option>
                            <% 
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
                             
                             %>
                               <option value="<%=pro.getId_proveedor()%>"><%=pro.getNombre_proveedor()%></option>
                             <%
                         }
                  }                 
            
                             
                        
                    } catch (Exception e) {
                    }

            %>
                      </select>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label  class="col-sm-2 col-form-label">Valor</label>
                      <div class="col-sm-10">
                          <input name="valor" required type="number" title="El valor no debe contener letras ni ser negativo" class="form-control" placeholder="Valor">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label  class="col-sm-2 col-form-label">Stock</label>
                      <div class="col-sm-10">
                          <input name="stock" required type="number" title="El Stock no debe contener letras ni ser negativo"  class="form-control" placeholder="Stock">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label  class="col-sm-2 col-form-label">Descripción</label>
                      <div class="col-sm-10">
                          <textarea required style="overflow:auto;resize:none" rows="4" class="form-control" name="descripcion" rows="4"></textarea>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label  class="col-sm-2 col-form-label">Imagen</label>
                      <div class="col-sm-10">
                            <div class="custom-file">
                                <input type="file" name="imagen" class="custom-file-input" id="customFileLang" lang="es">
                                <label class="custom-file-label" for="customFileLang">Seleccionar Archivo</label>
                            </div>
                      </div>
                    </div>

             </div>
             <div class="modal-footer">
                 <button type="button" class="btn " data-dismiss="modal">Cerrar</button>
                 <button type="submit" value="ingresar" name="action" class="btn ">Ingresar</button>
             </div>
             </form>
           </div>
       </div>
      </div>
    </div>
   </div>
 

<!-- Script Modal Editar Eliminar-->
<%
      for (int i = 1; i <= menu; i++) 
      {  
%>
<script> $(document).ready(function()
{   //Make script DOM ready
   
        $('#opcionesMenu<%=i%>').change(function() { //jQuery Change Function
        var opval = $(this).val(); //Get value from select element
        if(opval=="Oeliminar")
        { //Compare it and if true
            $('#eliminarInsumo<%=i%>').modal("show"); //Open Modal
        }
        if(opval=="Oeditar"){ //Compare it and if true
            $('#editarInsumo<%=i%>').modal("show"); //Open Modal
        }
        $('#opcionesMenu<%=i%>').val('0');
    });
});
</script>
<%      
  }
%>



  <!-- Bootstrap core JavaScript -->
  <script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom JavaScript for this theme -->
  <script src="../js/scrolling-nav.js"></script>

</body>

</html>

