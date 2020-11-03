<%@page import="java.util.ArrayList"%>
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
<html>
  <head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Cocina - Jefe Cocina</title>

  <!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../css/main.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/f298220d4a.js" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
    <body id="page-top">

<div class="container-fluid caja-cocina" >
  <div class="row align-items-center ">
    <div class="col-lg-6 offset-lg-3 col-12 text-center">
      <img src="images/Logo_Restaurante.png" style="max-width:200px;" class="imagen-logo img-fluid" alt="">
    </div>
  </div>
</div>
<div class="container-fluid">
  <div class="row">
    <div class="col-6">
      <div class="row">
        <div class="col-8  col-lg-10 justify-content-start">
          <strong>COCINA</strong><br>
          <strong>Fecha: 01/01/2020</strong> <br>
        </div>
      </div>
    </div>
    <div class="col-5">
      <div class="row text-right">
        <div class="col-10">
          <button type="submit" class="btn">Bodega</button>
        </div>
        <div class="col-2">
          <i class="fas fa-power-off" style="font-size:25px;color:red"></i>
        </div>
      </div>
    </div>

  </div>
  <br>
    <div class="col-12">
      <div class="row">
        <div class="col-12">
          <div class="row menu text-center">
            <div class="col-12">
                <h4>Lista de Pedidos</h4>
            </div>
            <div class="col-12">
              <table class=" table table-hover table-responsive-md">
             <thead>
             <tr>
             <th scope="col">Código</th>
             <th scope="col">Mesa</th>
             <th scope="col">Hora pedido</th>
             <th scope="col">Estado</th>
             <th scope="col">Preparado por</th>
             <th scope="col">Hora Preparación</th>
             <th scope="col">Hora Entrega</th>
             <th scope="col">Detalle</th>
             </tr>
             </thead>
              <tbody>
                  <% 
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
                                         while (resultSet.next()) 
                                         {   
                                             if(resultSet.getString("CODPEDIDO").equals(cod))
                                             {
                                                 continue;
                                             }
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
                                            
                                            String cocinero=(String)actual.getAttribute("cocinero"+cod);
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
                                             %>
                <tr>
              <form action="../ServletPedComensal" method="POST">
                  <input name="codigo" value="<%=pe.getCodigo_pedido()%>" type="hidden">
                   <th><%=pe.getCodigo_pedido()%></th>
                   <td><%=mesa%></td>
                   <td><%=dp.Hora(dp.getHora_Pedido()) %></td>
                   <td>
                     <div class="alert alert-<%=message%> text-center" role="alert">
                       <%=pe.getEstado()%>
                     </div>
                   </td>
                   <td>
                     <%if(cocinero!=null){out.print(cocinero);}%>
                   </td>
                   <td>
                       <%=dp.Hora(dp.getHora_Preparacion())%>
                   </td>
                   <td>
                       <%=dp.Hora(dp.getHora_Entrega())%>
                   </td>
                   <td>
                    <button  type="button" data-toggle="modal" data-target="#modaldetalle<%=menu%>"  class="btn btn-100">Ver</button>
                   </td>
                </tr>
                <!-- Modal Solicitudes de pedido-->
                    <div class="modal fade " id="modaldetalle<%=menu%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                      <div class="modal-dialog"  role="document">
                        <div class="modal-dialog">
                         <div class="modal-content">
                             <div class="modal-header">
                                <h4 class="modal-title">Detalle Pedido ID: <%=pe.getCodigo_pedido()%></h4>
                                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>

                             </div>
                             <div class="modal-body">
                                <div class="row">
                                    <% pp=connection.prepareCall("{call SOLICITUDESACOCINA (?)}");
                                      pp.registerOutParameter(1, OracleTypes.CURSOR);
                                      pp.execute();
                                      rs=(ResultSet) pp.getObject(1);

                                         while (rs.next()) 
                                         {   
                                             if(!pe.getCodigo_pedido().equals(rs.getString("CODPEDIDO")))
                                             {
                                                 continue;
                                             }

                                             %>
                                    <div class="col-12">
                                        <input name="idpedido" type="hidden" value="<%=rs.getInt("IDPEDIDO")%>">
                                        <strong><%=rs.getInt("CANTIDAD")%>x <%=rs.getString("NOMBRE")%>: </strong>
                                    </div>
                                             <%
                                         }%>
                                    <div class="w-100"></div>
                                    <div class="col-12 select-cocina">
                                        <br><br>
                                        <%if(pe.getEstado().equals("Pendiente")){%>
                                      <div class="row align-items-center">
                                        <div class="col-6">
                                          Seleccionar Cocinero:
                                        </div>
                                        <div class="col-6">
                                            <select name="cocinero" class="form-control select-cocina">
                                              <%
                                                PreparedStatement pst;
                                                ResultSet emp;
                                                String sql="select * from empleados where ROL='Cocinero'";
                                                pst=connection.prepareStatement(sql);
                                                emp=pst.executeQuery(); 

                                         while (emp.next()) 
                                         {   
                                             %>
                                             <option value="<%=emp.getString("NOMBRE")+" "+emp.getString("APATERNO")%>"><%=emp.getString("NOMBRE")+" "+emp.getString("APATERNO")%></option>
                                            <%}%>
                                          </select>
                                        </div>
                                      </div>
                                           <%}%>
                                        <br>
                                    </div>
                                    <div class="col-12">
                                      Garzón/a a cargo: <%=garzon%>
                                    </div>
                               </div>
                             <div class="modal-footer">
                                 <% if(pe.getEstado().equals("Pendiente")){ %>
                                 <button type="submit" value="Preparando" class="btn btn-100" name="action">Preparar</button>
                                 <%}%>
                                 <% if(pe.getEstado().equals("Preparando")){ %>
                                 <button type="submit" value="Listo" class="btn btn-100" name="action">Listo</button>
                                 <%}%>
                                 
                             </div>
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
        </div>
      </div>
    </div>



</DIV>

  <!-- Bootstrap core JavaScript -->
  <script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom JavaScript for this theme -->
  <script src="../js/scrolling-nav.js"></script>

</body>

</html>
