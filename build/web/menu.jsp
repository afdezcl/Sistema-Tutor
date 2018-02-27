<%-- 
    Document   : menu
    Created on : 28-dic-2017, 3:53:50
    Author     : Fernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    HttpSession objsesion = request.getSession(false);
    String usuario = (String)objsesion.getAttribute("usuario");
    if(usuario.equals("")){
        response.sendRedirect("index.jsp");
    }
    
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Menú Principal de <% out.println(usuario); %> </title>
    <link rel="icon" href="images/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/menu.css">
    <script type="text/javascript" src="js/script.js"></script>
  </head>
  <body onload="mostrarFecha()">
    <center>
      <div class="box">
        <img src="images/men.png">
        <p id="fecha"></p>
        <h2 id="login">Sistema tutor para Desarrollo de Servicios Telemáticos</h2>
        <p id="parrafo">En esta web podrás realizar diferentes test de evaluación de cara al examen final.</p>
        <p id="parrafo2">Tu puntuación será clave para la nota final de la asignatura.</p><br>
        
        <input type="submit" name="acceso" value="Acceso al Sistema Tutor" class="btn-acceso" onClick='window.location.href="seleccionartest.jsp";'><br>
        
        <form action="CerrarSesion" method="post">
          <input type="submit" name="exit" value="¿Desea cerrar sesión <% out.print(usuario); %>?" class="btn-exit">  
        </form>
      </div>
        <footer>
            <hr width="500px;">
            Adrián Fernández (Universidad de Málaga) <br>
            Copyright &copy; 2017-2018 Todos los derechos reservados
        </footer>
    </center>
  </body>
</html>>
