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
     int form=0;
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
          Usuario: <%=nombre%> <br>
          Fecha: <%=fecha%> <br>
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
                <h4>Recetas</h4>
            </div>
            <div class="col-12">
              <table class=" table table-hover table-responsive-md">
             <thead>
             <tr>
             <th scope="col">ID</th>
             <th scope="col">Nombre</th>
             <th scope="col">Rinde/porciones</th>
             <th scope="col">Detalle</th>
             <th scope="col">Solicitar</th>
             <th scope="col"></th>
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
                                             
                                             
                                       
                                             %>
                <tr>
              <form action="../ServletPedCocina" method="POST"> 
                  <input type="hidden" name="idreceta" value="<%=re.getId_receta()%>">
                  <input type="hidden" name="porciones" value="<%=re.getPorciones_receta() %>">
                   <th><%=re.getId_receta()%></th>
                   <th><%=re.getNombre_receta()%></th>
                   <td><%=re.getPorciones_receta() %></td>
                   <td>
                    <button  type="button" data-toggle="modal" data-target="#modalreceta<%=menu%>"  class="btn btn-100">Ver</button>
                   </td>
                   <td>
                       <input required type="number" class="form-control input-buscador"  name="cantidad">
                   </td>
                   <td>
                       <button type="submit" value="ingresar" name="estado" class="btn-caja btn">Pedir</button>
                   </td>
                </tr>
              </form>
  <!-- Modal Solicitudes de pedido-->
                    <div class="modal fade" id="modalreceta<%=menu%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                      <div class="modal-dialog"  role="document">
                        <div class="modal-dialog">
                         <div class="modal-content">
                             <div class="modal-header">
                                <h4 class="modal-title">Detalle Receta ID: <%=re.getId_receta()%></h4>
                                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>

                             </div>
                             <div class="modal-body">
                                <div class="row">
                                    <div class="col-12 text-center">
                                        <h5> <strong><%=re.getNombre_receta()%></strong></h5>
                                    </div>
                                    <div class="col-12 text-left">
                                      <strong>Ingredientes</strong>
                                    </div>
                                    <div class="w-100"></div>
                                    <div class="col-6">
                                        <form action="../ServletReceta" method="POST" >
                                            <input name="modal" type="hidden" value="<%=menu%>">
                                            <input  type="hidden" name="idreceta" value="<%=re.getId_receta()%>">
                                        <select name="insumo" class="form-control" id="opcionesMenu<%=menu%>">
                                            <option selected disabled value="0">Seleccionar</option>
                                   <% pp=connection.prepareCall("{call LISTARINSUMOS (?)}");
                                      pp.registerOutParameter(1, OracleTypes.CURSOR);
                                      pp.execute();
                                      rs=(ResultSet) pp.getObject(1);

                                         while (rs.next()) 
                                         {   
                                             Insumo in=new Insumo();
                                             in.setId_insumo(rs.getInt("IDINSUMO"));
                                             in.setNombre_insumo(rs.getString("NOMBRE"));

                                             %>
                                             <option value="<%=in.getId_insumo()%>"><%=in.getNombre_insumo() %></option>
                                       <%
                                         }%>
                                        </select>
                                    </div>
                                    <div class="col-6">
                                        <button type="submit" name="action" value="agregar"  class="btn-100 btn" >Agregar</button>
                                    </div>
                                    <div class="col-12"><hr></div>
                                    <div class="col-12">
                                      <div class="row text-center">
                                        <div class="col-5 text center">
                                          Producto
                                        </div>
                                        <div class="col-5">
                                          Cantidad
                                        </div>
                                      </div>
                                        <div class="row tex-center" >
                                            
                                            <div class="col-12" id="insumos-receta<%=menu%>">
                                                
                                          <% pp=connection.prepareCall("{call LISTARRECETAINSUMO (?)}");
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
                                             %>
                                             <input type="hidden" name="idinsumo" value="<%=res.getInt("IDINSUMO")%>">
                                           <div class="form-group row">
                                            <div class="col-5">
                                              <input type="text" class="form-control input-100"  value="<%=res.getString("NOMBRE_INSUMO")%>" disabled >
                                            </div>
                                            <div class="col-5">
                                                <input type="number"  name="cantidad" value="<%=res.getInt("CANTIDAD")%>" class="form-control input-100">
                                            </div>
                                            <div class="col-2">
                                                    <button  type="submit" class="btn-100 btn" name="action" value="eliminar<%=res.getInt("IDINSUMO")%>" >x</button>
                                            </div>
                                           </div>
                                           
                                        <%
                                         }%>
                                            </div>
                                      </div>
                                        <br><HR>
                                      <div class="row">
                                        <div class="col-4">
                                          Esta recete rinde:
                                        </div>
                                        <div class="col-4">
                                            <input  type="number" name="porcion" class="form-control input-100" value="<%=re.getPorciones_receta() %>">
                                        </div>
                                        <div class="col-4">
                                          Porciones
                                        </div>
                                      </div>
                                      <br>
                                      <div class="row">
                                        <div class="col-4 offset-8">
                                          <button  type="button" class="btn btn-100" name="button">Editar</button>
                                        </div>
                                      </div>
                                      <br>
                                </div>
                             </div>
                             <div class="modal-footer">
                                 <button  type="submit" class="btn btn-100" name="action" value="editar">Guardar</button>
                                  </form>
                             </div>
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
    </div>
  </div>

  <script>
   $( document ).ready(function() {
       var modal=<%=request.getParameter("modal")%>
       if(modal)
       {
           $('#modalreceta'+modal+'').modal('toggle');
       }
    
});
  </script>

  <!-- Bootstrap core JavaScript -->
  <script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom JavaScript for this theme -->
  <script src="../js/scrolling-nav.js"></script>

</body>
</html>
