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
@WebServlet(name = "ComenzarTest", urlPatterns = {"/ComenzarTest"})
public class ComenzarTest extends HttpServlet {

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
        
        //Obtenemos que tipo de Test se ha seleccionado: 1, 2 o el 3
        String test = null;
        
        switch (request.getParameter("test")) {
            case "Test 1: Dificultad facil":
                test = new String("test1.txt");
                break;
            case "Test 2: Dificultad media":
                test = new String("test2.txt");
                break;
            default:
                test = new String("test3.txt");
                break;
        }
        
        //Creamos matriz con el test 
        Matriz.ObtenerMatriz(getServletContext().getRealPath("/") + "\\" + "/test/" + test); //hacemos referencia a la carpeta donde estan los test
        
       
        //COMIENZA LA PAGINA 
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
            out.println("<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' >");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            
            out.println("<div class='box'>");
            out.println("<img src='" + request.getContextPath() + "/images/men.png'>" );
            out.println("<h2>"+request.getParameter("test")+"</h2>");
            out.println("<h1>"+Matriz.getTituloPregunta(0)+"</h1>");
            out.println("<form action='ComprobarTest' method='post'>");
            
            //TABLA DE LOS INPUTS
            out.println("<table>");
            out.println("<tr>");
            out.println("<th><input type='radio' class='option-input radio' name='respuesta' value='1' /></th>");
            out.println("<td>"+Matriz.getRespuestaA(0)+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<th><input type='radio' class='option-input radio' name='respuesta' value='2' /></th>");
            out.println("<td>"+Matriz.getRespuestaB(0)+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<th><input type='radio' class='option-input radio' name='respuesta' value='3' /></th>");
            out.println("<td>"+Matriz.getRespuestaC(0)+"</td>");
            out.println("</tr>");
            out.println("</table>");
            //*****FIN TABLA INPUTS****\\\\
            //LOS HIDDEN, PARA PODER LLEVAR LA CUENTA
            //Pos es la posicion de la pregunta
            out.println("<input type=\"text\" name='posicion' value='0' hidden=\"true\">");
            out.println("<input type='text' name='test' value='" + test + "' hidden='true'>");
            out.println("<input type=\"text\" name=\"puntos\" value='0' hidden=\"true\"></input>");
            out.println("<th><input type='submit' name='submit' value='Siguiente' class='btn-siguiente'></th>");
            
            out.println("</form>");
            
            
            out.println("<form action='CerrarSesion' method='post'>");
            out.println("<input type='submit' name='submit' value='Cerrar Sesión' class='btn-exit-test'>");
            out.println("</form>");

            out.println("<form action='seleccionartest.jsp' method='post' style='display: inline-block;'>");
            out.println("<input type='submit' name='submit' value='Cancelar' class='btn-atras'>");
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
