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
        <div class="col-lg-6 col-5">
          <img src="images/Logo_Restaurante.png" class="img-fluid" style="max-width:150px;" alt="">
        </div>
        <div class="col-lg-6 col-3">
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
                    <a class="nav-link js-scroll-trigger" href="empleados.html">Empleados</a>
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
                    <a class="activo nav-link js-scroll-trigger" href="reportes.html">Reportes</a>
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
        <input type="text" class="form-control"  class="input-buscador " aria-describedby="search" placeholder="Buscar...">
      </div>
      <div class="col-lg-1 col-1">
        <button type="submit" class="btn"><i class="fas fa-search"></i></button>
      </div>
    </div>
    <!-- contenido-->
    <!-- tarjeta-->
    <div class="row">
      <div class="col-lg-2 offset-lg-1">
        <h4>INGRESOS</h4>
        Elegir rango de Fechas
      </div>
      <div class="col-lg-3">
        <br>
        <div class="row">
          <div class="col-3">
            <h5>Inicio</h5>
          </div>
          <div class="col-9">
            <div class="form-group">
              <input type="date" class="form-control" id="date" >
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-3">
        <br>
        <div class="row">
          <div class="col-3">
            <h5>Fin</h5>
          </div>
          <div class="col-9">
            <div class="form-group">
              <input type="date" class="form-control" id="date" >
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-2">
        <br>
        <div class="row">
          <button type="submit" class="btn btn-100">Generar</button>
        </div>
      </div>
    </div>
    <br>
    <div class="row">
      <div class="col-lg-2 offset-lg-1">
        <h4>GASTOS</h4>
        Elegir rango de Fechas
      </div>
      <div class="col-lg-3">
        <br>
        <div class="row">
          <div class="col-3">
            <h5>Inicio</h5>
          </div>
          <div class="col-9">
            <div class="form-group">
              <input type="date" class="form-control" id="date" >
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-3">
        <br>
        <div class="row">
          <div class="col-3">
            <h5>Fin</h5>
          </div>
          <div class="col-9">
            <div class="form-group">
              <input type="date" class="form-control" id="date" >
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-2">
        <br>
        <div class="row">
          <button type="submit" class="btn btn-100">Generar</button>
        </div>
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

