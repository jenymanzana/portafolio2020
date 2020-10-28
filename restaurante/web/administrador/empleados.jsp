<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Scrolling Nav - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="../css/main.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/f298220d4a.js" crossorigin="anonymous"></script>
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
          Usuario: Marco Contreras <br>
          Fecha: 01/01/2020 <br>
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
    </div>
    <!-- contenido-->
    <!-- tarjeta-->

    <div class="row tabla-ingresos">
      <div class="col-12">
        <table class=" table table-hover table-responsive">
       <thead>
       <tr>
       <th scope="col">Nombre Empleado</th>
       <th scope="col">Rut</th>
       <th scope="col">Edad</th>
       <th scope="col">Rol</th>
       <th scope="col">Fecha contrato</th>
       <th scope="col">Horas de Trabajo</th>
       <th scope="col">E-mail</th>
       <th scope="col">Teléfono</th>
       <th scope="col">Acceso Plataforma</th>
       <th scope="col">Sueldo</th>
       </tr>
       </thead>
        <tbody>
          <tr>
             <th>Maria del Pilar Rubia Martinez</th>
             <td>11.111.111-1</td>
             <td>31</td>
             <td>Garzón</td>
             <td>12/01/2017</td>
             <td>45</td>
             <td>bla@mail.com</td>
             <td>987654321</td>
             <td>Sí</td>
             <td>$400.000</td>
          </tr>
          <tr>
             <th>Juan Carlos Horacio Rosales</th>
             <td>12.121.121.1</td>
             <td>42</td>
             <td>Guardia Seguridad</td>
             <td>12/01/2017</td>
             <td>50</td>
             <td>carlos@mail.com</td>
             <td>76543456</td>
             <td>No</td>
             <td>$600.000</td>
          </tr>
        </tbody>
     </table>
      </div>
    </div>
    <br> <hr> <br>
    <div class="col-12">
      <div class="row">
        <div class="col-4">
            <b>Empleados Desvinculados</b>
        </div>
      </div>
    </div>


    <div class="row tabla-ingresos">
      <div class="col-12">
        <table class=" table table-hover table-responsive">
       <thead>
       <tr>
       <th scope="col">Nombre Empleado</th>
       <th scope="col">Rut</th>
       <th scope="col">Edad</th>
       <th scope="col">Rol</th>
       <th scope="col">Fecha contrato</th>
       <th scope="col">Horas de Trabajo</th>
       <th scope="col">Motivo</th>
       <th scope="col">Sueldo</th>
       </tr>
       </thead>
        <tbody>
          <tr>
             <th>Maria del Pilar Rubia Martinez</th>
             <td>11.111.111-1</td>
             <td>31</td>
             <td>Garzón</td>
             <td>12/01/2017</td>
             <td>45</td>
             <td>Renuncia empleado</td>
             <td>$500.000</td>
          </tr>
          <tr>
        </tbody>
     </table>
      </div>
    </div>

   <div class="row ">
     <div class="col-4 col-lg-2">
       <button type="submit" class="btn-100 btn">Desvincular</button>
     </div>
     <div class="col-4 col-lg-2">
       <button type="submit" class="btn-100 btn">Editar Empleado</button>
     </div>
      <div class="col-4 col-lg-2">
        <button type="submit" class="btn-100 btn">+</button>
      </div>
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

