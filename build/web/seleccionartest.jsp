<%-- 
    Document   : seleccionartest
    Created on : 29-dic-2017, 17:58:20
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
    <title>Selección de Test</title>
    <link rel="icon" href="images/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    <link rel="stylesheet" href="css/menu.css">
  </head>
  <body>
    <center>
      <div class="box">
        <img src="images/men.png">
        <button type="button" name="button" onclick="window.print()"><i class="fas fa-download"></i></button>
        <h2 id="login">Sistema tutor de <% out.println("\""+usuario+"\"");%></h2>
        <form action="ComenzarTest" method="post">
          <input type="submit" name="test" value="Test 1: Dificultad facil" class="btn-acceso"><br>
          <input type="submit" name="test" value="Test 2: Dificultad media" class="btn-acceso"><br>
          <input type="submit" name="test" value="Test 3: Dificultad dificil" class="btn-acceso"><br>        
        </form>
        <!--El siguiente css se añade para quitar el salto de linea que genera el FORM-->
        <form action="CerrarSesion" method="post" style="display: inline;"> 
          <input type="submit" name="submit" value="Cerrar Sesión" class="btn-exit-test">
        </form>
        
        <input type="submit" name="submit" value="Volver atrás" class="btn-atras" onClick='window.location.href="menu.jsp";'>
        
      </div>
        <footer>
            <hr width="500px;">
            Adrián Fernández (Universidad de Málaga) <br>
            Copyright &copy; 2017-2018 Todos los derechos reservados
        </footer>
    </center>
  </body>
</html>
