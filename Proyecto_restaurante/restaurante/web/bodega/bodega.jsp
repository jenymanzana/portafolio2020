<%-- 
    Document   : bodega
    Created on : 10-10-2020, 21:07:43
    Author     : Jeny
--%>
<%@page import="Modelo.Insumo"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.*"%>
<%@page import="oracle.jdbc.OracleTypes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession actual=request.getSession(true);
    String nombre=(String)actual.getAttribute("nombre");
    String fecha=(String)actual.getAttribute("fecha");
    int menu=0;
%>
  
<!DOCTYPE html>
<html lang="es">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Home - Bodega</title>
  <link rel="icon" type="image/png" href="../img/favicon.png"/>
  <!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="../css/main.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/f298220d4a.js" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  
</head>

<body id="page-top">

<div class="container-fluid caja-header">
  <div class="row align-items-center">
    <div class="col-lg-4 col-12">
      <div class="row">
        <div class="col-5">
          <img src="images/Logo_Restaurante.png" class="img-fluid" style="max-width:150px;" alt="">
        </div>
        <div class=" cabecera"> 
            <span><strong>BODEGA</strong></span><br>
            <span  class="float-left">Usuario: <%=nombre%></span><br>
            <span  class="float-left">Fecha: <%=fecha%></span><br>
        </div>

      </div>
       
    </div>      
      <div class="col-lg-8 col-12">
          <br>
                <div class="container">
                 <div class="row">
                   <div class="col-lg-2 col-md-3  col-3 offset-lg-3 offset-md-2 size">
                     <a type="submit" href="pedidos-cocina.jsp" class="btn-bodega btn">Cocina</a>
                   </div>
                   <div class="col-lg-2 col-md-3 col-3 size">
                     <a type="submit" href="crear-pedido.jsp" class="btn-bodega btn ">+ Pedido</a>
                   </div>
                   <div class="col-lg-2 col-md-3 col-3 size ">
                      <a type="submit" href="crear-pedido.jsp" data-target="#exampleModalCenter"  data-toggle="modal" class="btn-bodega btn ">+ Producto</a>
                   </div>
                     
                    <div class="col-2"> 
                      <button class="learn-more">
                        <span class="circle" aria-hidden="true">
                          <span class="icon arrow"></span>
                        </span>
                         <a type="submit" href="../login.jsp"> <span class="button-text">Cerrar sesión</span></a>
                   
                       
                      </button>
                    </div>
                     
                     <!-- AGREGAR nuevo INSUMO-->

                    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                      <div class="modal-dialog"  role="document">
                        <div class="modal-dialog">
                         <div class="modal-content">
                             <div class="modal-header">
                                <h4 class="modal-title">Ingresar Producto</h4>
                                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                             </div>
                             <form method="POST" action="../ServletBodega"  enctype="multipart/form-data"> <!-- enctype:  Envía imagen -->
                             <div class="modal-body">
                                    <div class="form-group row">
                                      <label  class="col-sm-2 col-form-label">Nombre</label>
                                      <div class="col-sm-10">
                                          <input name="nombre" required type="text" class="form-control" placeholder="Bebida Fanta 1.5L">
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
                                          <input name="valor" required type="text" title="El valor no debe contener letras ni ser negativo" class="form-control" placeholder="$1990">
                                      </div>
                                    </div>
                                    <div class="form-group row">
                                      <label  class="col-sm-2 col-form-label">Stock</label>
                                      <div class="col-sm-10">
                                          <input name="stock" required type="number" title="El Stock no debe contener letras ni ser negativo"  class="form-control" placeholder="45">
                                      </div>
                                    </div>
                                    <div class="form-group row">
                                      <label  class="col-sm-2 col-form-label">Descripción </label>
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
          </div>
      </div>
  </div>
</div>
                                      
 <Style>

.inputWithIcon {
  position: relative;
}

.inputWithIcon i {
  position: absolute;
  right: 7%;
  top: 4px;
  padding: 9px 9px;
  color: #aaa;
  transition: 0.3s;
}
     </style>                               
  <!-- Navegación -->
  <div class="container-fluid">
    <div class="row inputWithIcon buscador">
      <div class="inputWithIcon col-lg-4 col-5">
        <input type="text" onkeyup="Buscar()" id="buscar" class="form-control"  class="input-buscador " aria-describedby="search" placeholder="Buscar insumo">
      <i class="fas fa-search"></i>
      </div>
        
    <div class="col-lg-4 offset-lg-4 col-5">
        <div class="form-group">
            <form action="bodega.jsp" method="get">
                <select class="form-control" name="proveedor" onchange="this.form.submit()">
                    <option disabled selected>Filtrar por proveedor</option>
            <% 
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
                             
                             %>
                               <option value="<%=pro.getId_proveedor()%>"><%=pro.getNombre_proveedor()%></option>
                             <%
                         }
                  }                 
            
                             
                        
                    } catch (Exception e) {
                    }

            %>
                <option value="todos">Ver Todos</option>
                </select>
            </form>
       </div>
     </div>
        
    <!--  <div class="col-lg-1 col-1">
        <div type="submit" class="btn"><i class="fas fa-search"></i></div>
      </div> -->
    </div>
    <!-- CONTENIDO -->
    
    <div class="row">
      <div class="col-12">
          <table id="datos" number-per-page="5" current-page="" class=" table table-hover table-responsive-md">
       <thead>
       <tr>
       <th scope="col">Código</th>
       <th scope="col">Nombre</th>
       <th scope="col">Unidad</th>
       <th scope="col">Stock</th>
       <th scope="col">Valor/un</th>
       <th scope="col">Categoría</th>      
       <th scope="col">Proveedor</th>
       <th scope="col">Imagen</th>
       <th scope="col">Descripción</th>
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
                             %>
                             <tr>
                                <th><%=in.getCodigo_insumo()%></th>
                                <td><%=in.getNombre_insumo()%></td>
                                <td><%=in.getUnidad_insumo() %></td>
                                <td><%=in.getStock_insumo() %></td>
                                <td><%="$"+in.getValor_insumo()%></td>
                                <td><%=in.getCategoria_insumo()%></td>
                                <td><%=proveedor%></td>                           
                                <td>
                                    <img src="../<%=in.getImagen_insumo()%>" class="img-fluid img-tabla">
                                </td>
                                 <td><%=in.getDescripcion()%></td> 
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
                                 <form  enctype="multipart/form-data"  method="POST" action="../ServletBodega">
                                     <input type="hidden" name="idinsumo" value="<%=in.getId_insumo()%>"></>
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
                                                        <input name="unidad" readonly value="<%=in.getUnidad_insumo()%>" type="text" class="form-control">
                                                    </div>
                                                  </div>
                                                   <div class="form-group row">
                                                    <label  class="col-sm-2 col-form-label">Stock </label>
                                                    <div class="col-sm-10">
              <!-- cambiar tipo de dato-->              <input name="stock" value="<%=in.getStock_insumo()%>" required type="text" title="El número no debe contener letras ni simbolos y debe ser como máximo de 9 dígitos"  class="form-control" placeholder="Stock">
                                                    </div>
                                                  </div>
                                                   <div class="form-group row">
                                                    <label  class="col-sm-2 col-form-label">Valor($)</label>
                                                    <div class="col-sm-10">
                                                        <input name="valor" value="<%=in.getValor_insumo()%>" readonly  type="text" class="form-control" placeholder="$890">
                                                    </div>
                                                  </div>
                                                   <div class="form-group row">
                                                    <label  class="col-sm-2 col-form-label">Proveedor</label>
                                                    <div class="col-sm-10">
                                                       
                                                        <select readonly name="proveedor" required class="form-control">
                                                            <option readonly value="<%=idproveedor%>" selected ><%=proveedor%></option>
                                                         </select>
                                                    </div>
                                                  </div>
                                                    
                                                     <div class="form-group row">
                                                    <label  class="col-sm-2 col-form-label">Categoría</label>
                                                    <div class="col-sm-10">
                                                        <input name="categoria" value="<%=in.getCategoria_insumo()%>" type="text" class="form-control" readonly>
                                                    </div>
                                                  </div>
                                                    
                                                <div class="form-group row">
                                                    <label  class="col-sm-2 col-form-label">Descripción</label>
                                                    <div class="col-sm-10" >
                                                         <textarea  style="overflow:auto;resize:none" rows="4" class="form-control" rows="4"  name="descripcion"  resize="none"  rows="3" class="form-control" placeholder="Este producto es bajo en calorías, la bolsa es color azul" class="form-control" id="exampleFormControlTextarea1" resize: none rows="3"><%=in.getDescripcion()%></textarea>
                                                     </div>
                                                </div>
                                                   <div class="col-sm-8 offset-sm-2">
                                                       <img src="../<%=in.getImagen_insumo()%>" class="img-fluid">
                                                       <input name="img" type="hidden" value="<%=in.getImagen_insumo()%>">
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
                } catch (Exception e) {
                }

            %>
             <input type="hidden" value="<%=menu%>"> </>
          </tbody>
     </table>
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
<div class="">
    <section style="height:50px;"></section>
    <!----------- Footer ------------>
    <footer class="footer-bs">
        <div class="row">
            <div id="centrador" class="col-md-12">
                    <img id="imagen" src="../img/gorro.png" class="img-fluid" alt="">
                   <div class="col-sm-12 align-self-center text-footer text-center">
                        <p >© Restaurante Siglo XXI - 2020</p>
                   </div>
            </div>
        </div>
    </footer>
</div>

  <!-- Bootstrap core JavaScript -->
  <script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Javascript-->
  <script src="../js/scrolling-nav.js"></script>
  <script src="../js/paginacion.js"></script>
  
  
   <!--codigo de paginacion-->
  <style>
  
ulll {
  list-style: none;
  margin-top: 10px;
  padding: 0;
}

liii {
  border-radius: 3px;
  color: black;
  background: white;
  cursor: pointer;
  display: inline;
  font-weight: 200;
  margin: 10px 5px 0px 2px;
  /*padding: 10px;*/
  text-align: center;
  width: 35px;
 /* height: 35px;*/
}

.activa {
  background: #cc9650;
  color: white;
}
</style>


	<script type="text/javascript">
	$(function(){
		$("#datos").pagination();
	});
        </script>

</body>

</html>
