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
                    <a class="nav-link js-scroll-trigger" href="empleados.html">Empleados</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="caja-ingresos.html">Caja</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="bodegas-productos.html">Bodegas</a>
                  </li>
                  <li class="nav-item">
                    <a class="activo nav-link js-scroll-trigger" href="menu-fondo.html">Menús</a>
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
      <h5 class="">Menús</h5>
      </div>
    </div>

    <div class="row ">
      <div class="col-lg-2 offset-lg-1 col-11 offset-1">
        <div class="form-group">
         <select class="form-control" id="exampleFormControlSelect1">
           <option>Plato de fondo</option>
           <option>Entrada</option>
           <option>Ensalada</option>
           <option>Postre</option>
           <option>Bebestibles</option>
         </select>
       </div>
      </div>
    </div>

    <div class="row menu">
      <div class="col-11 offset-1">
        <table class=" table table-hover table-responsive">
       <thead>
       <tr>
       <th scope="col">Nombre</th>
       <th scope="col">Preparación/compra</th>
       <th scope="col">Valor Venta</th>
       <th scope="col">Ganancia</th>
       <th scope="col">Tipo</th>
       <th scope="col">Estado</th>
       <th scope="col">Imagen</th>
       <th scope="col">Acciones</th>
       </tr>
       </thead>
        <tbody>
          <tr>
             <th>Porotos con riendas</th>
             <td>$1800</td>
             <td>$3800</td>
             <td>$2000</td>
             <td>Preparación</td>
             <td>
               <div class="alert alert-success text-center" role="alert">
                 Activo
               </div>
             </td>
             <td>
               <img src="images/Porotos-con-Riendas.jpg" class="img-fluid img-tabla" alt="">
             </td>
             <td>
               <div class="form-group">
                <select class="form-control" id="exampleFormControlSelect1">
                  <option disabled selected >Seleccionar</option>
                  <option>Editar</option>
                  <option>Eliminar</option>
                </select>
              </div>
            </td>
          </tr>
          <tr>
             <th>Pollo Arverjado</th>
             <td>$1900</td>
             <td>$3900</td>
             <td>$2000</td>
             <td>Preparación</td>
             <td>
               <div class="alert alert-warning text-center" role="alert">
                  Pausado
               </div>
             </td>
             <td>
               <img src="images/pollo-arvejado.jpg" class="img-fluid img-tabla" alt="">
             </td>
             <td>
               <div class="form-group">
                <select class="form-control" id="exampleFormControlSelect1">
                  <option disabled selected >Seleccionar</option>
                  <option>Editar</option>
                  <option>Eliminar</option>
                </select>
              </div>
            </td>
          </tr>
        </tbody>
     </table>
      </div>
    </div>

    <div class="row ">
      <div class="col-lg-2 offset-lg-1 col-3 offset-1  caja-botones">
        <button type="submit" class="btn-caja btn">Secciones</button>
      </div>
      <div class="col-lg-2 col-1">
        <button type="submit" class="btn-caja btn">+</button>
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

