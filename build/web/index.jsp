<%-- 
    Document   : index
    Created on : 01-dic-2017, 11:19:12
    Author     : Fernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Inicio sesión</title>
    <link rel="icon" href="images/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/script.js"></script>
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
    <center>
      <div class="box">
        <img src="images/men.png">
        <h2 id="login">Iniciar sesión</h2>
        <form action="InicioSesion" method="post" onsubmit="return validarLogin()">
          <div class="form-input">
            <input id="user" type="text" name="usuario" placeholder="Usuario">
          </div>
          <div class="form-input">
            <input id="pass" type="password" name="pass" placeholder="Contraseña">
          </div>
            <input id="entrar" type="submit" name="submit" value="Entrar" class="btn-login"><br>
        </form>
        
        <button id="botonenlazado" onClick='window.location.href="registro.jsp";'>Registrate aquí</button>
        <br>
        <a href="Fichero" id="forget"><input style="width: 100px;" type="button" name="readme" value="Readme" name="B2"></a>          
          
      </div>
        <footer>
        <hr width="500px;">
        Adrián Fernández (Universidad de Málaga) <br>
        Copyright &copy; 2017-2018 Todos los derechos reservados
      </footer>
    </center>
  </body>
</html>
