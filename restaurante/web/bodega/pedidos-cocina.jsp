<%-- 
    Document   : pedidos-cociina
    Created on : 10-10-2020, 21:10:08
    Author     : Jeny
--%>

<%@page import="java.util.Calendar"%>
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

  <title>Bodega - Pedidos</title>

  <!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../css/main.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/f298220d4a.js" crossorigin="anonymous"></script>
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
          <strong>ADMINISTRADOR</strong><br>
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
            <h4>Pedidos de Cocina</h4>
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
      <div class="col-12">
        <h5>Listado de Pedidos</h5>
      </div>
    </div>
    <div class="row">
      <div class="col-12">
        <table class="text-center table table-hover table-responsive-md">
       <thead>
       <tr>
       <th scope="col">ID</th>
       <th scope="col">Fecha</th>
       <th scope="col">Hora</th>
       <th scope="col">Estado</th>
       <th scope="col">Detalle</th>
       </tr>
       </thead>
        <tbody>
            <% 
                                try 
                                {
                                        BaseDatos bd = new BaseDatos();
                                        Connection connection = bd.getConnection();
                                        ResultSet resultSet,rs;
                                        if (connection!=null) 
                                  {
                                    //Llamar a procedure
                                      CallableStatement pp=connection.prepareCall("{call LISTARPEDIDOCOCINA (?)}");
                                      pp.registerOutParameter(1, OracleTypes.CURSOR);
                                      pp.execute();
                                      resultSet=(ResultSet) pp.getObject(1);
                                      int oprove=-1;
                                         while (resultSet.next()) 
                                         {   
                                             if(resultSet.getInt("IDPEDIDO")==oprove)
                                             {
                                                 continue;
                                             }
                                             menu++;
                                             
                                            
                                             oprove=resultSet.getInt("IDPEDIDO");
                                             Orden_Bodega pr=new Orden_Bodega();
                                             pr.setId_OBodega(resultSet.getInt("IDPEDIDO"));
                                             pr.setEstado(resultSet.getString("ESTADO_PEDIDO"));
                                             pr.setFechaHra(resultSet.getTimestamp("FECHA_PEDIDO"));
                                             pr.setComentario(resultSet.getString("COMENTARIO"));
                                             Calendar cal = Calendar.getInstance();  
                                             cal.setTime(pr.getFechaHra());
                                             String day=Integer.toString(cal.get(java.util.Calendar.DAY_OF_MONTH));
                                             int month=cal.get(java.util.Calendar.MONTH)+1;
                                             String year=Integer.toString(cal.get(java.util.Calendar.YEAR));
                                             int hour=cal.get(java.util.Calendar.HOUR_OF_DAY);
                                             int minute=cal.get(java.util.Calendar.MINUTE);
                                             String message="";
                                             if(pr.getEstado().equals("Pendiente"))
                                             {
                                                 message="warning";
                                             }
                                             if(pr.getEstado().equals("Aprobado"))
                                             {
                                                 message="success";
                                             }
                                             if(pr.getEstado().equals("Rechazado"))
                                             {
                                                 message="danger";
                                             }
                                       
                                             %>
          <tr>
             <th><%=pr.getId_OBodega()%></th>
             <td><%=day+"/"+month+"/"+year%></td>
             <td><%if(hour<10){out.print("0"+hour);}else{out.print(hour);};out.print(":");if(minute<10){out.print("0"+minute);}else{out.print(minute);}%></td>
             <td>
                <div class="alert alert-<%=message%> text-center" role="alert">
                 <%=pr.getEstado()%>
                </div>
             </td>
             <%if(pr.getEstado().equals("Pendiente")){ }%>
             <td>
                 <button  type="button" data-toggle="modal" data-target="#modaldetalle<%=menu%>"  class="btn btn-100">Ver</button>
             </td>
          </tr>
 <!-- Modal Pedidos Cocina-->
                    <div class="modal fade" id="modaldetalle<%=menu%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                      <div class="modal-dialog"  role="document">
                        <div class="modal-dialog">
                         <div class="modal-content">
                             <div class="modal-header">
                                <h4 class="modal-title">Detalle Pedido Cocina ID: <%=pr.getId_OBodega()%></h4>
                                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>

                             </div>
                             <div class="modal-body">
                                    <div class="form-group row">
                                      <label  class="col-sm-4 col-form-label">Insumo</label>
                                      <label  class="col-sm-4 col-form-label">Requerido</label>
                                      <label  class="col-sm-4 col-form-label">Stock</label>
                                    </div>
                                 <form method="POST" action="../ServletPedCocina"> 
                
                <input type="hidden" name="idpedido" value="<%=pr.getId_OBodega()%>">
                <input type="hidden" name="estado" value="<%=pr.getEstado()%>">
<% 
                        pp=connection.prepareCall("{call LISTARPEDIDOCOCINA (?)}");
                        pp.registerOutParameter(1, OracleTypes.CURSOR);
                        pp.execute();
                        rs=(ResultSet) pp.getObject(1);
                           while (rs.next()) 
                           {   
                            if ((rs.getInt("IDPEDIDO")!=oprove)) 
                            {
                             continue;
                            }
                                int Stock=rs.getInt("STOCK");
                                String nombrei=rs.getString("NOMBRE_INSUMO");
                                Detalle_Orden_Bodega dob=new Detalle_Orden_Bodega();
                                dob.setCantidad_Pedido(rs.getInt("CANTIDAD_INSUMO"));
                                
%>  
                                    <input type="hidden" name="idinsumo" value="<%=rs.getInt("IDINSUMO")%>">
                                    <div class="form-group row">
                                      <label  class="col-sm-4 col-form-label"><%=nombrei%></label>
                                      <div class="col-sm-4">
                                          <input readonly name="cantidad" required type="text" class="form-control" value="<%=dob.getCantidad_Pedido() %>">
                                      </div>
                                      <div class="col-sm-4">
                                          <input readonly name="stock" required type="text" class="form-control" value="<%=rs.getInt("STOCK")%>">
                                      </div>
                                    </div>
                                      <%} 
                                      if (pr.getEstado().equals("Pendiente")) 
                                      {%>
                                      <div class="form-group row">
                                          <label  class="col-sm-4 col-form-label">Comentario</label>
                                          <div class="col-sm-8">
                                          <textarea style="overflow:auto;resize:none" rows="4" class="form-control" name="comentario" rows="4"></textarea>
                                          </div>
                                      </div>      
                                      <%}else{
                                      %>
                                      <div class="form-group row">
                                          <label  class="col-sm-4 col-form-label">Comentario</label>
                                          <div class="col-sm-8">
                                          <textarea readonly style="overflow:auto;resize:none" rows="4" class="form-control" name="comentario" rows="4"><%=pr.getComentario()%></textarea>
                                          </div>
                                      </div> 
                                      <%}%>
                             </div>
                             <div class="modal-footer">
                                 <% if (pr.getEstado().equals("Pendiente")){ %> 
                                 <button type="submit" class="btn-success btn" value="Aprobado" name="nuevoestado">Aprobar</button>
                                 <button type="submit" class="btn-danger btn" value="Rechazado" name="nuevoestado" >Rechazar</button>
                             
                                 <%}else{%>
                                 <button type="button" class="btn " data-dismiss="modal">Cerrar</button>
                                 <%}%>
                                 </form>
                             </div>
                           </div>
                       </div>
                      </div>
                    </div>
        <%
            }
                      }
                  
                  connection.close();
                } 
                catch (Exception e) 
                {
                    out.print(e);
                }

%>
           
          </tbody>
     </table>
      </div>
    </div>
    <br>
  </div>

  <!-- Bootstrap core JavaScript -->
  <script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom JavaScript for this theme -->
  <script src="../js/scrolling-nav.js"></script>

</body>

</html>
