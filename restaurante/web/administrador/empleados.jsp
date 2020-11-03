<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Insumo"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.*"%>
<%@page import="oracle.jdbc.OracleTypes"%>
<%
    HttpSession actual=request.getSession(true);
    String nombre=(String)actual.getAttribute("nombre");
    String fecha=(String)actual.getAttribute("fecha");
    int menu=0;
    int desp=0;
%>
<!DOCTYPE html>
<html lang="es">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Empleados - Administración</title>

  <!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="../css/main.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/f298220d4a.js" crossorigin="anonymous"></script>
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
                    <a class="activo nav-link js-scroll-trigger" href="empleados.html">Empleados</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="caja-ingresos.html">Caja</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="bodegas-productos.html">Bodegas</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="menu-fondo.html">Menús</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="clientes.html">Clientes</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="reportes.html">Reportes</a>
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
      <div class="col-lg-4 col-9 ">
        <input type="text" class="form-control"  aria-describedby="search" placeholder="Buscar...">
      </div>
      <div class="col-lg-1 col-1">
        <button type="submit" class="btn "><i class="fas fa-search"></i></button>
      </div>
      <div class="col-8 offset-2 col-lg-2 offset-lg-5 agregar-empleado">
        <button type="submit" data-toggle="modal" data-target="#agregarempleado" class="btn-100 btn">Agregar Empleado</button>
      </div>
    </div>
    <!-- contenido-->
    <!-- tarjeta-->
    <div class="col-12">
      <div class="row">
        <div class="col-4">
            <h4><b>Empleados</b></h4>
        </div>
      </div>
    </div>
    <br>
    <div class="row tex-center tabla-ingresos">
      <div class="col-12">
        <table class="tex-center table table-hover table-responsive-md">
       <thead>
       <tr>
       <th scope="col">Nombre Empleado</th>
       <th scope="col">Rut</th>
       <th scope="col">Edad</th>
       <th scope="col">Rol</th>
       <th scope="col">E-mail</th>
       <th scope="col">Teléfono</th>
       <th scope="col">Detalle</th>
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
                        ResultSet resultSet,rs;
                        pi=connection.prepareCall("{call LISTAREMPLEADOS (?)}");
                        pi.registerOutParameter(1, OracleTypes.CURSOR);
                        pi.execute();
                        resultSet=(ResultSet) pi.getObject(1);
                       
                         while (resultSet.next()) 
                         {   
                             menu++;
                            
                             Empleados emp=new Empleados(); 
                             emp.setId_empleado(resultSet.getInt("IDEMPL"));
                             emp.setNombre_empleado(resultSet.getString("NOMBRE"));
                             emp.setApellido_paterno(resultSet.getString("APATERNO"));
                             emp.setApellido_materno(resultSet.getString("AMATERNO"));
                             emp.setRut_empleado(resultSet.getString("RUTEMPL"));
                             emp.setFecha_nacimiento(resultSet.getDate("NACIMIENTO"));
                             emp.setRol_empleado(resultSet.getString("ROL"));
                             emp.setFecha_contrato(resultSet.getDate("FECHACONTRATO"));
                             emp.setHoras_trabajo(resultSet.getInt("HORAS"));
                             emp.setEmail_empleado(resultSet.getString("EMAIL"));
                             emp.setTelefono(resultSet.getInt("TELEFONO"));
                             emp.setPlataforma_empleado(resultSet.getString("PLATAFORMA").charAt(0));
                             emp.setSueldo_empleado(resultSet.getInt("SALARIO"));
                             
                             %>
                        <tr>
                            <th><%=emp.NombreAp()%></th>
                           <td><%=emp.getRut_empleado()%></td>
                           <td><%=emp.Edad()%></td>
                           <td><%=emp.getRol_empleado()%></td>
                           <td><%=emp.getEmail_empleado()%> </td>
                           <td><%=emp.getTelefono()%></td>
                           <td><button  type="button" data-toggle="modal" data-target="#empleados<%=menu%>"  class="btn-bodega btn">Ver</button></td>
                        </tr>
                     
                         <!--Modal Detalle Empleado-->
                         <div id="empleados<%=menu%>" class="modal fade"  tabindex="-1" role="dialog" aria-hidden="true">
                                  <div class="modal-dialog">
                                      <div class="modal-content">
                                          <div class="modal-header">
                                              <h4 class="modal-title">Empleado: <%=emp.NombreAp()%></h4>
                                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                          </div>
                                          <div class="modal-body">
                                              <form method="POST" action="../ServletEmpleado">
                                                  <input name="idempleado" value="<%=emp.getId_empleado()%>" type="hidden">
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Nombre</label>
                                                    <div class="col-sm-8">
                                                     <input disabled name="nombre" value="<%=emp.getNombre_empleado()%>" required type="text" class="form-control" placeholder="">
                                                    </div>
                                              </div>
                                                    <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Apellido Paterno</label>
                                                    <div class="col-sm-8">
                                                     <input disabled name="apaterno" value="<%=emp.getApellido_paterno()%>" required type="text" class="form-control" placeholder="">
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Apellido Materno</label>
                                                    <div class="col-sm-8">
                                                     <input disabled name="amaterno" value="<%=emp.getApellido_materno()%>" required type="text" class="form-control" placeholder="">
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Fecha Nacimiento</label>
                                                    <div class="col-sm-8">
                                                     <input disabled name="nacimiento" value="<%=resultSet.getDate("NACIMIENTO")%>" required type="date" class="form-control" placeholder="">
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Rol</label>
                                                    <div class="col-sm-8">
                                                     <select disabled name="rol" required class="form-control" >
                                                         <option selected value="<%=emp.getRol_empleado()%>"><%=emp.getRol_empleado()%></option>
                                                            <option value="Garzon">Garzón</option>
                                                            <option value="Maitre">Maitre</option>
                                                            <option value="JefeCocina">Jefe Cocina</option>
                                                            <option value="Bodeguero">Bodeguero</option>
                                                            <option value="Administrador">Administrador</option>
                                                            <option value="Cajero">Cajero</option>
                                                            <option value="GuardiaSeguridad">Guardia Seguridad</option>
                                                            <option value="Cocinero">Cocinero</option>
                                                     </select>
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Fecha Contrato</label>
                                                    <div class="col-sm-8">
                                                     <input disabled name="contrato" value="<%=emp.getFecha_contrato()%>" required type="date" class="form-control" placeholder="">
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Horas de Trabajo</label>
                                                    <div class="col-sm-8">
                                                     <input disabled name="horas" value="<%=emp.getHoras_trabajo()%>" required type="text" class="form-control" placeholder="">
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Email</label>
                                                    <div class="col-sm-8">
                                                     <input disabled name="email" value="<%=emp.getEmail_empleado()%>" required type="text" class="form-control" placeholder="">
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Teléfono</label>
                                                    <div class="col-sm-8">
                                                     <input disabled name="telefono" value="<%=emp.getTelefono()%>" required type="text" class="form-control" placeholder="">
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">¿Acceso a Plataforma?</label>
                                                    <div class="col-sm-8">
                                                     <select disabled name="plataforma" required class="form-control" id="exampleFormControlSelect1">
                                                         <option selected value="<%=emp.isPlataforma_empleado()%>" ><%=emp.Plataforma()%></option>
                                                            <option value="s">Sí</option>
                                                            <option value="n">No</option>
                                                     </select>
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Sueldo Empleado</label>
                                                    <div class="col-sm-8">
                                                        <input disabled name="sueldo" value="<%=emp.getSueldo_empleado()%>" required type="text" class="form-control" placeholder="">
                                                    </div>
                                              </div>
                                              <div class="row">
                                                <div class="col-4 ">
                                                    <button data-toggle="modal" data-target="#desvincular<%=menu%>"  type="button"  value="1" class="btn btn-100"  name="button">Desvincular</button>
                                                </div>
                                                <div class="col-4 offset-4">
                                                    <button  type="button" value="1" class="btn btn-100" id="editar" name="button">Editar</button>
                                                </div>
                                              </div>
                                          </div>
                                          <div class="modal-footer">
                                                <button type="button" class="btn" data-dismiss="modal">Cerrar</button>
                                                <button disabled type="submit" value="editar" name="action" id="guardar" class="btn" >Guardar</button>
                                                
                                            
                                            <div class="modal fade" id="desvincular<%=menu%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                              <div class="modal-dialog modal-dialog-centered" role="document">
                                                <div class="modal-content">
                                                  <div class="modal-header">
                                                      <h5 class="modal-title">Desvincular Empleado: <%=emp.NombreAp()%></h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                      <span aria-hidden="true">&times;</span>
                                                    </button>
                                                  </div>
                                                  <div class="modal-body">
                                                    <div class="form-group row">
                                                        <label  class="col-sm-4 col-form-label">Comentario</label>
                                                        <div class="col-sm-8">
                                                         <textarea  style="overflow:auto;resize:none" class="form-control" rows="4"  name="descripcion"  resize="none"  rows="3" placeholder="Comentario..." ></textarea>
                                                        </div>
                                                    </div>
                                                  </div>
                                                  <div class="modal-footer">
                                                      <button type="submit" value="desvincular" name="action" class="btn ">Desvincular</button>
                                                    <button type="button" class="btn" data-dismiss="modal">Cancelar</button>
                                                    </form>
                                                  </div>
                                                </div>
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
                catch (Exception e) {
                    out.print(e);
                }
            %>
        </tbody>
     </table>
      </div>
    </div>
    <br> <hr> <br>
    <div class="col-12">
      <div class="row">
        <div class="col-4">
            <h4><b>Empleados Desvinculados</b></h4>
        </div>
      </div>
    </div>
    <br>

    <div class="row tex-center tabla-ingresos">
      <div class="col-12">
        <table class="tex-center table table-hover table-responsive-md">
       <thead>
       <tr>
       <th scope="col">Nombre Empleado</th>
       <th scope="col">Rut</th>
       <th scope="col">Edad</th>
       <th scope="col">Rol</th>
       <th scope="col">Fecha contrato</th>
       <th scope="col">Fecha Despido</th>
       <th scope="col">Horas de Trabajo</th>
       <th scope="col">Motivo</th>
       <th scope="col">Sueldo</th>
       <th scope="col"></th>
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
                    //Llamar a procedure
                        CallableStatement pi;
                        ResultSet resultSet,rs;
                        pi=connection.prepareCall("{call LISTADESPEDIDOS (?)}");
                        pi.registerOutParameter(1, OracleTypes.CURSOR);
                        pi.execute();
                        resultSet=(ResultSet) pi.getObject(1);
                       
                         while (resultSet.next()) 
                         {   
                             desp++;
                            
                            
                             Empleados emp=new Empleados(); 
                             emp.setId_empleado(resultSet.getInt("IDEMPL"));
                             emp.setNombre_empleado(resultSet.getString("NOMBRE"));
                             emp.setApellido_paterno(resultSet.getString("APATERNO"));
                             emp.setRut_empleado(resultSet.getString("RUTEMPL"));
                             emp.setFecha_nacimiento(resultSet.getDate("NACIMIENTO"));
                             emp.setRol_empleado(resultSet.getString("ROL"));
                             emp.setFecha_contrato(resultSet.getDate("FECHACONTRATO"));
                             emp.setHoras_trabajo(resultSet.getInt("HORAS"));
                             emp.setSueldo_empleado(resultSet.getInt("SALARIO"));
                             Empleados_desvinculados ed=new Empleados_desvinculados();
                             ed.setId_desvinculado(resultSet.getInt("IDDESVIN"));
                             ed.setDescripcion(resultSet.getString("DESCRIPCION"));
                             ed.setFecha_despido(resultSet.getDate("FECHADESPIDO")); 
                             
                             %>
           <tr>
             <th><%=emp.NombreAp()%></th>
             <td><%=emp.getRut_empleado()%></td>
             <td><%=emp.Edad()%></td>
             <td><%=emp.getRol_empleado()%></td>
             <td><%=ed.Fecha(emp.getFecha_contrato())%></td>
             <td><%=ed.Fecha(ed.getFecha_despido())%></td>
             <td><%=emp.getHoras_trabajo()%></td>
             <td><%=ed.getDescripcion()%></td>
             <td>$<%=emp.getSueldo_empleado()%></td>
             <td>
                 <button  type="button" data-toggle="modal" data-target="#recontratar<%=desp%>"  class="btn-bodega btn">Recontratar</button>
             </td>
             <td>
                 <button  type="button" data-toggle="modal" data-target="#eliminar<%=desp%>"  class="btn-bodega btn">Eliminar</button>
             </td>
          </tr>
           <!--Modal Recontratar Empleado-->
                         <div id="recontratar<%=desp%>" class="modal fade"  tabindex="-1" role="dialog" aria-hidden="true">
                                  <div class="modal-dialog">
                                      <div class="modal-content">
                                          <div class="modal-header">
                                              <h4 class="modal-title">¿Estás seguro de recontratar a <%=emp.NombreAp()%>?</h4> 
                                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                          </div>
                                          <div class="modal-body">
                                              <p><%=emp.NombreAp()%> cambiará su estado a Contratado</p>
                                          </div>
                                          <div class="modal-footer">
                                              <form method="POST" action="../ServletEmpleado">
                                                <input type="hidden" name="idempleado" value="<%=emp.getId_empleado()%>">
                                                <input type="hidden" name="iddesvinculado" value="<%=ed.getId_desvinculado()%>">
                                                <button type="button" class="btn" data-dismiss="modal">Cancelar</button>
                                                <button type="submit" name="action" value="recontratar" class="btn" >Recontratar</button>
                                              </form>
                                          </div>
                                      </div>
                                  </div>
                               </div>
        <!--Modal Eliminar Empleado-->
                         <div id="eliminar<%=desp%>" class="modal fade"  tabindex="-1" role="dialog" aria-hidden="true">
                                  <div class="modal-dialog">
                                      <div class="modal-content">
                                          <div class="modal-header">
                                              <h4 class="modal-title">¿Estás seguro de eliminar a <%=emp.NombreAp()%>?</h4> 
                                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                          </div>
                                          <div class="modal-body">
                                              <p><%=emp.NombreAp()%> se eliminará para siempre del sistema</p>
                                          </div>
                                          <div class="modal-footer">
                                              <form method="POST" action="../ServletEmpleado">
                                                <input type="hidden" name="idempleado" value="<%=emp.getId_empleado()%>">
                                                <input type="hidden" name="iddesvinculado" value="<%=ed.getId_desvinculado()%>">
                                                <button type="button" class="btn" data-dismiss="modal">Cancelar</button>
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
                    out.print(e);
                }
            %>
        </tbody>
     </table>
      </div>
    </div>

   <!--Modal Ingresar Empleado-->
                         <div id="agregarempleado" class="modal fade"  tabindex="-1" role="dialog" aria-hidden="true">
                                  <div class="modal-dialog">
                                      <div class="modal-content">
                                          <div class="modal-header">
                                              <h4 class="modal-title">Agregar Empleado</h4>
                                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                          </div>
                                          <div class="modal-body tex-center">
                                              <form action="../ServletEmpleado" method="POST">
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Nombre</label>
                                                    <div class="col-sm-8">
                                                     <input  name="nombre"  required type="text" class="form-control" placeholder="Nombre">
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Apellido Paterno</label>
                                                    <div class="col-sm-8">
                                                     <input  name="apaterno"  required type="text" class="form-control" >
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Apellido Materno</label>
                                                    <div class="col-sm-8">
                                                     <input  name="amaterno"  required type="text" class="form-control" >
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Rut</label>
                                                    <div class="col-sm-8">
                                                     <input  name="rut"  required type="text" class="form-control" placeholder="Rut">
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Fecha Nacimiento</label>
                                                    <div class="col-sm-8">
                                                     <input  name="nacimiento" min='1900-01-01' id="datePickerId1"  required type="date" class="form-control">
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Rol</label>
                                                    <div class="col-sm-8">
                                                     <select  name="rol" required class="form-control" >
                                                            <option value="Garzon">Garzón</option>
                                                            <option value="Maitre">Maitre</option>
                                                            <option value="JefeCocina">Jefe Cocina</option>
                                                            <option value="Bodeguero">Bodeguero</option>
                                                            <option value="Administrador">Administrador</option>
                                                            <option value="Cajero">Cajero</option>
                                                            <option value="GuardiaSeguridad">Guardia Seguridad</option>
                                                            <option value="Cocinero">Cocinero</option>
                                                     </select>
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Fecha Contrato</label>
                                                    <div class="col-sm-8">
                                                        <input  name="contrato" min='2015-01-01' id="datePickerId"  required type="date" class="form-control" placeholder="Fecha Contrato">
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Horas de Trabajo</label>
                                                    <div class="col-sm-8">
                                                     <input  name="horas" required type="number" class="form-control" >
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Email</label>
                                                    <div class="col-sm-8">
                                                        <input  name="email"  required type="email" class="form-control" placeholder="">
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Teléfono</label>
                                                    <div class="col-sm-8">
                                                        <input  name="telefono"  required type="number" class="form-control" >
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">¿Acceso a Plataforma?</label>
                                                    <div class="col-sm-8">
                                                     <select  name="plataforma" required class="form-control" id="opcionesPlat">
                                                         <option disabled selected value="0">Seleccionar</option>
                                                            <option value="s">Sí</option>
                                                            <option value="n">No</option>
                                                     </select>
                                                    </div>
                                              </div>
                                              <div class="form-group row d-none" id="nick">
                                                    <label  class="col-sm-4 col-form-label">Nick (Plataforma)</label>
                                                    <div class="col-sm-8">
                                                     <input  name="nick"   type="text" class="form-control" placeholder="nick">
                                                    </div>
                                              </div>
                                              <div class="form-group row d-none" id="password">
                                                    <label  class="col-sm-4 col-form-label">Contraseña (Plataforma)</label>
                                                    <div class="col-sm-8">
                                                     <input  name="pass"   type="password" class="form-control">
                                                    </div>
                                              </div>
                                              <div class="form-group row">
                                                    <label  class="col-sm-4 col-form-label">Sueldo Empleado</label>
                                                    <div class="col-sm-8">
                                                        <input  name="sueldo"  required type="number" class="form-control" placeholder="">
                                                    </div>
                                              </div>
                                          </div>
                                          <div class="modal-footer">
                                                <button type="button" class="btn" data-dismiss="modal">Cerrar</button>
                                                <button  type="submit" value="agregar" name="action"  class="btn" >Agregar</button>
                                                </form>
                                          </div>
                                      </div>
                                  </div>
                               </div>
  </div>
<script>
    
 $(document).ready(function(){
     datePickerId.max = new Date().toISOString().split("T")[0];
     datePickerId1.max = new Date().toISOString().split("T")[0];
     $('#opcionesPlat').change(function() {
         var opval = $(this).val();
         if(opval=="s")
         {
             $(this).closest(".modal-body").find("#nick").removeClass("d-none");
             $(this).closest(".modal-body").find("#password").removeClass("d-none");
         }
         if(opval=="n")
         {
             $(this).closest(".modal-body").find("#nick").addClass("d-none");
             $(this).closest(".modal-body").find("#password").addClass("d-none");
         }
     });
     
 $("body").on("click", "#editar", function (e) {
     
      if($(this).val()==0)
      {
          $(this).closest(".modal-body").find('input, textarea, select').attr("disabled", true);
          $(this).parent().parent().parent().parent().find(".modal-footer").find("#guardar").attr("disabled", true);
          $(this).val(1);
      }
      else
      if($(this).val()==1)
      {
          $(this).closest(".modal-body").find('input, textarea, select').removeAttr('disabled');
          $(this).parent().parent().parent().parent().find(".modal-footer").find("#guardar").removeAttr('disabled');
          $(this).val(0);
      } 
});
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

