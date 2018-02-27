<%-- 
    Document   : registro
    Created on : 28-dic-2017, 3:30:50
    Author     : Fernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Registro de usuario</title>
    <link rel="icon" href="images/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/script.js"></script>
  </head>
  <body>
    <center>
      <div class="box-registro">
        <img src="images/registro.png">
        <h2 id="login">Registrar usuario</h2>
        <form action="Registrar" method="post" onsubmit="return validacionRegistro()">
          <div class="form-input">
            <input id="user" type="text" name="usuario" placeholder="Introduzca un nombre de usuario *">
          </div>
          <div class="form-input">
            <input id="pass1" type="password" name="pass" placeholder="Contraseña *" minlength="4">
          </div>
          <div class="form-input">
            <input id="pass2" type="password" name="pass2" placeholder="Repita la contraseña *" minlength="4">
          </div>
          <div class="form-input">
            <input id="name" type="text" name="name" placeholder="Introduzca su nombre *">
          </div>
          <div class="form-input">
            <input id="subname" type="text" name="subname" placeholder="Introduzca su pellido *">
          </div>
          <div class="form-input">
            <input id="email" type="text" name="email" placeholder="Email o correo *">
          </div>
          <div class="form-input">
            <input id="telf" type="text" name="telf" placeholder="Teléfono *">
          </div>

            <input type="submit" name="submit" value="Registrar" class="btn-login"><br>
        </form>
        <button id="botonenlazado" onClick='window.location.href="index.jsp";'>Ya tengo cuenta</button>
      </div>
        <footer>
            <hr width="500px;">
            Adrián Fernández (Universidad de Málaga) <br>
            Copyright &copy; 2017-2018 Todos los derechos reservados
        </footer>
    </center>
  </body>
</html>

