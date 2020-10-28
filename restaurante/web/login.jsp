<%-- 
    Document   : login
    Created on : 10-10-2020, 14:22:03
    Author     : Jeny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
	<title>Ingresar a cuenta</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="img/favicon.png"/>
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="css/style-login.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="limiter">
	<a href="index.php"><div class="fas fa-home"></div></a>
		<div class="container-login100" style="background-image: url('img/fondo_login.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					<a><img src="img/logo.png" alt="Logo_restaurante" style="height: 120px;"></a>
				</span>
				<form class="login100-form validate-form p-b-33 p-t-5"  method="POST" action="ServletLogin">

					<div class="wrap-input100 validate-input" data-validate = "Ingrese usuario">
              <input required class="input100" type="text" name="user"  placeholder="Usuario">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Ingrese contraseña">
						<input required class="input100" type="password" name="pass" placeholder="Contraseña">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>

					<div class="container-login100-form-btn m-t-32">
              <button type="submit"  class="login100-form-btn">
							Entrar
						</button>
					</div>
				</form>
					<div style="text-align:right;padding:20px 0px;font-size:0.9em;"><p style="color:white">¿Olvidaste tu contraseña?</p>
						<a href="">Recupera aquí</a>&nbsp;
				</div>
			</div>
		</div>
	</div>
</body>
</html>
