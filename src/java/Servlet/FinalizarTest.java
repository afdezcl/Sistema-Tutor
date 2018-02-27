/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.Matriz;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fernandez
 */
@WebServlet(name = "FinalizarTest", urlPatterns = {"/FinalizarTest"})
public class FinalizarTest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //Obtenemos el nombre de usuario de sesion
        HttpSession objsesion = request.getSession(false);
        String usuario = (String)objsesion.getAttribute("usuario");
        if(usuario.equals("")){
            response.sendRedirect("index.jsp");
        }
        
        String test = request.getParameter("test");
        int puntos = Integer.parseInt(request.getParameter("puntos"));
        int fallos = 5-puntos;
        int porcentaje = (puntos*100)/5;
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<title> Usuario " + usuario + " realizando test </title>");
            out.println("<link rel='icon' href='"+ request.getContextPath() + "/images/favicon.ico' />");
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +  "/css/test.css' />");
            out.println("<script type='text/javascript' src='" + request.getContextPath() +  "/js/script.js'></script>");
            out.println("<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' >");
            out.println("</head>");
            out.println("<body onload=\"mostrarGif()\">");
            out.println("<center>");
            
            out.println("<div class='box'>");
            out.println("<img src='" + request.getContextPath() + "/images/men.png'>" );
            out.println("<h2>"+test+"</h2>");
            if(porcentaje<=33){
                out.println("<h2 style='color: rgb(64, 224, 208);'>Muy baja nota. Se aconseja no presentarse</h2>"); 
            }else if(porcentaje>66){
                out.println("<h2 style='color: rgb(64, 224, 208);'>Muy bien, puede presentarse al examen</h2>"); 
            }else{
                out.println("<h2 style='color: rgb(64, 224, 208);'>Debe estudiar más</h2>"); 
            }
            
            //LEYENDA
            out.println("<h1>Tu porcentaje es de: " + porcentaje + "%</h1>");        
            out.println("<h1>El numero de aciertos son: " + puntos + "</h1>");
            out.println("<h1>El numero de fallos cometidos son: "+fallos+"</h1>");
            //mostrar el gif
            out.println("<img id='gif'>");
            //REFERENCIA, NO SE MUESTRA
            out.println("<input id='ptos' type=\"text\" name=\"puntos\" value='" +puntos+ "' hidden=\"true\"></input>");
            
            
            //botones
            out.println("<form action='CerrarSesion' method='post'>");
            out.println("<input type='submit' name='submit' value='Cerrar Sesión' class='btn-exit-test' style='margin-top:-350px;'>");
            out.println("</form>");

            out.println("<form action='seleccionartest.jsp' method='post' style='display: inline-block;'>");
            out.println("<input type='submit' name='submit' value='Volver al inicio' class='btn-atras'>");
            out.println("</form>");
            
            
  
            out.println("</div>");
            
            out.println("<footer>");
            out.println("<hr width='500px;'>");
            out.println("Adrián Fernández (Universidad de Málaga) <br>");
            out.println("Copyright &copy; 2017-2018 Todos los derechos reservados");
            out.println("</footer>");
            
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
