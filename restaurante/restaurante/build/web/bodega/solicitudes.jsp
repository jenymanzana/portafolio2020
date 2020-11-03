<%-- 
    Document   : crear-pedido
    Created on : 10-10-2020, 21:09:41
    Author     : Jeny
--%>
<%@page import="java.util.Calendar"%>
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
  <link rel="icon" type="image/png" href="../img/favicon.png"/>
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
        <div class=" cabecera"> 
            <span><strong>BODEGA</strong></span><br>
            <span  class="float-left">Usuario: <%=nombre%></span><br>
            <span  class="float-left">Fecha: <%=fecha%></span><br>
        </div>
      </div>
    </div>
      <div class="col-lg-8 col-12">
        <div class="d-lg-none d-xl-block">
          <br>
        </div>
        <div class="row">
          <div class="col-lg-6 offset-lg-1 col-10 offset-1">
            <h4>Solicitudes de Insumos a Administrador</h4>
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
        <a href="bodega.jsp" class="btn"><i class="fas fa-arrow-left"></i></a>
      </div>
    </div>
    <!-- CONTENIDO -->
    <div class="row align-items-center text-center">
      <div class="col-lg-3 col-10 offset-1">
        <h5>Solicitudes</h5>
      </div>
    </div>
    <div class="row">
      <div class="col-12">
        <table class=" table table-hover table-responsive-md">
       <thead>
       <tr>
       <th scope="col">Id Pedido</th>
       <th scope="col">Nombre Proveedor</th>
       <th scope="col">Fecha</th>
       <th scope="col">Hora</th>
       <th scope="col">Descripción</th>
       <th scope="col">Detalle</th>
       </tr>
       </thead>
        <tbody>
<% 
            try {
                  BaseDatos bd = new BaseDatos();
                  Connection connection = bd.getConnection();
                  ResultSet resultSet,rs;
                  if (connection!=null) 
                  {
                      //rescatar valor de url
                      
                      CallableStatement pp=connection.prepareCall("{call LPEDIDOBODEGA (?)}");
                      pp.registerOutParameter(1, OracleTypes.CURSOR);
                      pp.execute();
                      resultSet=(ResultSet) pp.getObject(1);
                      int oprove=-1;
                         while (resultSet.next()) 
                         {   
                             if ((resultSet.getInt("IDOPROVEEDOR")==oprove)) 
                             {
                              continue;
                             }
                             menu++;
                               oprove=resultSet.getInt("IDOPROVEEDOR");
                               Pedido_proveedor pprov=new Pedido_proveedor();
                               pprov.setId_pedido(resultSet.getInt("IDOPROVEEDOR"));
                               pprov.setDescripcion_pedido(resultSet.getString("DESCPEDIDO"));
                               pprov.setFecha_pedido(resultSet.getTimestamp("FECHAPEDIDO"));
                               
                               
                               Calendar cal = Calendar.getInstance();  
                               cal.setTime(pprov.getFecha_pedido());
                               String day=Integer.toString(cal.get(java.util.Calendar.DAY_OF_MONTH));
                               int month=cal.get(java.util.Calendar.MONTH)+1;
                               String year=Integer.toString(cal.get(java.util.Calendar.YEAR));
                               int hour=cal.get(java.util.Calendar.HOUR_OF_DAY);
                               int minute=cal.get(java.util.Calendar.MINUTE);
                             
%>
          <tr>
            
             <th><%=pprov.getId_pedido()%></th>
             <td><%=resultSet.getString("nombreprov")%></td>
             <td><%=day+"/"+month+"/"+year%></td>
             <td><%if(hour<10){out.print("0"+hour);}else{out.print(hour);};out.print(":");if(minute<10){out.print("0"+minute);}else{out.print(minute);}%></td>
             <td><%=pprov.getDescripcion_pedido()%></td>
             <td>
                 <button  type="button" data-toggle="modal" data-target="#modaldetalle<%=menu%>"  class="btn-bodega btn">Ver</button>
             </td>
          </tr>
         
          <!-- Modal Solicitudes de pedido-->
                    <div class="modal fade" id="modaldetalle<%=menu%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                      <div class="modal-dialog"  role="document">
                        <div class="modal-dialog">
                         <div class="modal-content">
                             <div class="modal-header">
                                <h4 class="modal-title">Detalle Solicitud ID:<%=oprove%></h4>
                                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>

                             </div>
                             <div class="modal-body">
                                    <div class="form-group row">
                                      <label  class="col-sm-6 col-form-label">Insumo</label>
                                      <label  class="col-sm-6 col-form-label">Cantidad</label>
                                    </div>
<% 
               
                      
                      
                      pp=connection.prepareCall("{call LPEDIDOBODEGA (?)}");
                      pp.registerOutParameter(1, OracleTypes.CURSOR);
                      pp.execute();
                      rs=(ResultSet) pp.getObject(1);
                         while (rs.next()) 
                         {   
                         if ((rs.getInt("IDOPROVEEDOR")!=oprove)) 
                         {
                          continue;
                         }
                         
%>  
                                    <div class="form-group row">
                                      <label  class="col-sm-6 col-form-label"><%=rs.getString("NOMBRE")%></label>
                                      <div class="col-sm-6">
                                          <input readonly name="nombre" required type="text" class="form-control" value="<%=rs.getInt("CANTSOLICITUD")%>">
                                      </div>
                                    </div>
<%
                          }
                             
%>  
                             </div>
                             <div class="modal-footer">
                                 <button type="button" class="btn " data-dismiss="modal">Cerrar</button>
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
  </div>

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

  <!-- Custom JavaScript for this theme -->
  <script src="../js/scrolling-nav.js"></script>

</body>

</html>
