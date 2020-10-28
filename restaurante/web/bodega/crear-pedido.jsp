<%-- 
    Document   : crear-pedido
    Created on : 10-10-2020, 21:09:41
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
    String nomprov="";
%>
<!DOCTYPE html>
<html lang="es">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Bodega - Pedido Nuevo</title>

  <!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../css/main.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/f298220d4a.js" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body id="page-top">

<div class="container-fluid caja-header">
  <div class="row align-items-center">
    <div class="col-lg-4 col-12">
      <div class="row ">
        <div class="col-6">
          <img src="images/Logo_Restaurante.png" class="img-fluid" style="max-width:150px;" alt="">
        </div>
        <div class="col-6">
          <strong>BODEGA</strong><br>
          Usuario: <%=nombre%> <br>
          Fecha: <%=fecha%> <br>
        </div>
      </div>
    </div>
      <div class="col-lg-8 col-12">
        <div class="d-lg-none d-xl-block">
          <br>
        </div>
        <div class="row">
          <div class="col-lg-6 offset-lg-3 col-10 offset-1">
            <h4>Realizar solicitud de Pedido</h4>
          </div>
      </div>
    </div>
  </div>


</div>
  <!-- Navigation -->
  <div class="container-fluid">
    <div class="row buscador">
      <div class="col-lg-4 col-8 offset-0">
        <input type="text" class="form-control"  class="input-buscador " aria-describedby="search" placeholder="Buscar...">
      </div>
      <div class="col-lg-1 col-1">
        <button type="submit" class="btn"><i class="fas fa-search"></i></button>
      </div>
      <div class="col-1 offset-1 offset-lg-6">
        <a href="bodega.html" class="btn"><i class="fas fa-arrow-left"></i></a>
      </div>
    </div>
    <!-- CONTENIDO -->
    <div class="row align-items-center text-center">
      <div class="col-lg-3  col-12">
        <div class="form-group">
         <form action="crear-pedido.jsp" method="get">
                <select class="form-control" name="proveedor" onchange="this.form.submit()">
                    <option selected disabled>Filtrar por Proveedor</option>
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
                         
                         String prove=null;
                         
                         if(request.getParameter("proveedor")!=null)
                        {
                            prove=request.getParameter("proveedor");
                            
                        } 
                         else
                         {
                             prove="1"; 
                         }
                         while (resultSet.next()) 
                         {   
                          
                             Proveedor pro=new Proveedor();
                             
                             pro.setId_proveedor(resultSet.getInt("IDPROVEE"));
                             pro.setNombre_proveedor(resultSet.getString("NOMBRE"));
                                if(Integer.parseInt(prove)==pro.getId_proveedor())
                                {
                                    nomprov=pro.getNombre_proveedor();
                                   
                                } 
                                     
                                 
                             %>
                             <option value="<%=pro.getId_proveedor()%>"><%=pro.getNombre_proveedor()%></option>
                             <%
                              
                         }
                  }                 
            
                             
                        
                    } catch (Exception e) {
                    }

            %>
                </select>
            </form>
       </div>
      </div>
      <div class="col-lg-3 col-10 offset-1">
        <h5><%=nomprov%> </h5>
      </div>
    </div>
    <div class="row">
      <div class="col-12">
        <table class=" table table-hover table-responsive-md">
       <thead>
       <tr>
       <th scope="col"> COD</th>
       <th scope="col">Nombre</th>
       <th scope="col">Unidad</th>
       <th scope="col">Stock</th>
       <th scope="col">Valor/u</th>
       <th scope="col">Cantidad a Agregar</th>
       <th scope="col"></th>
       <th scope="col">Cantidad Agregada</th>
       <th scope="col">Sub-Total</th>
        <th scope="col"></th>
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
                      } 
                      else
                      {
                          prov="1";
                      }
                      
                      //Llamar a procedure
                       CallableStatement pi;
                       ResultSet resultSet;
                      // probar -> out.print(prov);
                      
                          pi=connection.prepareCall("{call FILTRARPROVEEDOR(?,?)}");
                          pi.setInt(1, Integer.parseInt(prov));
                          pi.registerOutParameter(2, OracleTypes.CURSOR);
                          pi.execute();
                          resultSet=(ResultSet) pi.getObject(2);
                      
                      
                                          
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
                             int idproveedor=resultSet.getInt("PIDPROVEE");
%>
          <tr>
        <form method="POST" action="../ServletPedProv">
             <th><%=in.getCodigo_insumo()%></th>
             <td><%=in.getNombre_insumo()%></td>
             <td><%=in.getUnidad_insumo()%></td>
             <td><%=in.getStock_insumo()%></td>
             <td>$<%=in.getValor_insumo()%></td>
             <input type="hidden" id="inputvalor<%=menu%>" value="<%=in.getValor_insumo()%>">
             <input type="hidden" name="idproveedor" value="<%=prov%>">
             <input type="hidden" name="idinsumo" value="<%=in.getId_insumo()%>">
             <td>
                 <input id="inputpedido<%=menu%>" type="number" class="form-control"   class="input-buscador " >
             </td>
             <td>
                 <button type="button"  id="botonpedido<%=menu%>" class="btn-caja btn">Agregar</button>
             </td>
              <td>
                  <input class="form-control" name="cantidad" type="number" readonly id="idcantidad<%=menu%>" value="0">
              </td>
              <th>
                  $<label id="valorpedido<%=menu%>">0</label> 
              </th>
              <td>
                  <a id="btneliminar<%=menu%>"><i  class="fas fa-times text-danger"></i></a>
              </td>
      
          </tr>
<%
                         }
     
                      
                  }
                  connection.close();
                } catch (Exception e) {
                }

%>
          </tbody>
     </table>
      </div>
    </div>
          <br>
          <div class="row">
           <div class="col-12">
              <div class="row">
              <div class="col-lg-8 col-12">
                  <div class="row">
                    <div class="col-4">
                        <h6>Comentario Pedido</h6> 
                    </div>
                    <div class="w-100"></div>
                    <div class="col-12">
                         <textarea style="overflow:auto;resize:none" rows="4" class="form-control" name="comentario" rows="4"></textarea>
                    </div>
                  </div>
              </div>
              
              <div class="col-lg-4 col-12">
                  <div class="row">
                    <div class="col-8 text-right">
                      <h5>Cantidad de productos:</h5>
                    </div>
                    <div class="col-4 text-left">
                      <label id="cantidadtotal">0</label>
                    </div>
                    <div class="col-8 text-right">
                      <h5>TOTAL:</h5>
                    </div>
                    <div class="col-4 text-left">
                      $<label id="valortotal">0</label>
                      <input type="hidden" name="total" id="total">
                    </div>
                </div>
              </div>
            </div>
           </div>
          </div>          
          
          
          
    <br>
    <div class="row ">
      <div class="col-lg-2 offset-lg-6 col-3 offset-1">
          <a href="bodega.jsp" class="btn-caja btn">Cancelar</a>
      </div>
      <div class="col-lg-2  col-4">
          <button type="submit" value="Pendiente" name="estado" class="btn-caja btn">Crear Pedido</button>
          </form>
      </div>
      <div class="col-lg-2 col-4">
          <a href="solicitudes.jsp"  class="btn-caja btn">Pedidos</a>
      </div>
    </div>

  </div>


<%
      for (int i = 1; i <= menu; i++) 
      {  
%>
  <script>
   $(document).ready(function()
	{
         var cantidad=0;
         var cantidadtotal=0;
         var subtotal=0;
         var total=0;
	$("#botonpedido<%=i%>").click(function () {
            if ((Number($('#inputpedido<%=i%>').val()) >0) && ((Number($('#idcantidad<%=i%>').val())+Number($("#inputpedido<%=i%>").val()))<=200)) 
         {
             
                var cant=($("#inputpedido<%=i%>").val());
              ($("#inputpedido<%=i%>").val(''));
              var valor=($("#inputvalor<%=i%>").val());
              cantidad=Number(cantidad)+Number(cant);
              $('#idcantidad<%=i%>').val(cantidad);
              subtotal=Number(subtotal)+Number((cant*valor));
              $('#valorpedido<%=i%>').text(subtotal);
              
              var tot=($("#valortotal").text());
              total=Number(tot)+Number(cant*valor);
              $('#valortotal').text(total);
              $('#total').val(total);
              cantidadtotal=Number(($("#cantidadtotal").text()))+Number(cant);
              $('#cantidadtotal').text(cantidadtotal);
         }
	});
        $("#btneliminar<%=i%>").click(function () {
          var can=Number(($("#idcantidad<%=i%>").val()));
          ($("#idcantidad<%=i%>").val('0'));
          var sub=Number(($("#valorpedido<%=i%>").text()));
          ($("#valorpedido<%=i%>").text('0'));
          cantidadtotal=Number(($("#cantidadtotal").text()))-Number(can);
          total=Number(($("#valortotal").text()))-Number(sub);
          cantidad=0;
          subtotal=0;
          $('#cantidadtotal').text(cantidadtotal);      
          $('#valortotal').text(total);
          $('#total').val(total);
          
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
