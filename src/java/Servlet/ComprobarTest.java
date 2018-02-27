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
@WebServlet(name = "ComprobarTest", urlPatterns = {"/ComprobarTest"})
public class ComprobarTest extends HttpServlet {

    
    private String obtenerTest(HttpServletRequest request){
         //Obtenemos que tipo de Test se ha seleccionado: 1, 2 o el 3
        String test = null;
        
        switch (request.getParameter("test")) {
            case "test1.txt":
                test = new String("Test 1: Dificultad facil");
                break;
            case "test2.txt":
                test = new String("Test 2: Dificultad media");
                break;
            default:
                test = new String("Test 3: Dificultad dificil");
                break;
        }
        return test;
    }
    
    
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
       
        
        //Obtenemos la respuesta tipo Radio pulsada
        String respuesta = request.getParameter("respuesta");
        if(respuesta == null){
            respuesta = "0";
        }
        int res = Integer.parseInt(respuesta);
        
        
        
        //Obtenemos el nombre de usuario de sesion
        HttpSession objsesion = request.getSession(false);
        String usuario = (String)objsesion.getAttribute("usuario");
        if(usuario.equals("")){
            response.sendRedirect("index.jsp");
        }
        String posicion = request.getParameter("posicion");
        int pos = Integer.parseInt(posicion);
        int puntos = Integer.parseInt(request.getParameter("puntos"));
        

        //Obtener el tipo de test selecccionado
        String test = null;
        if(pos == 0){
            test = obtenerTest(request);
        } else {
            test = request.getParameter("test");
        }
       
        //GENERAR PAGINA HTML
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
            out.println("<h2>"+test+"</h2>");
            
            
            //ComprobarRespuesta
            if(res == Matriz.getPreguntaCorrecta(pos)){ //Correcta
                puntos+=1;
                out.println("<h1 style='color: rgb(64, 224, 208);'>CORRECTO</h1>");
                //TABLA DE LOS INPUTS
                out.println("<table>");
                out.println("<tr>");
                out.println("<td>"+Matriz.getTituloPregunta(pos)+"</td>");
                out.println("</tr>");

                out.println("<tr>");          
                out.println("<td>"+Matriz.getTituloCorrecto(pos, res)+"</td>");
                out.println("</tr>");
                out.println("</table>");
                //*****FIN TABLA INPUTS****\\\\

            }else{ //INCORRECTO
                out.println("<h1 style='color: tomato;'>INCORRECTO</h1>");
    
                out.println("<table>");
                out.println("<tr>");
                out.println("<td>"+Matriz.getTituloPregunta(pos)+"</td>");
                out.println("</tr>");
                
                //Si no se ha contestado ninguna respuesta
                if(res == 0){
                    out.println("<h1 style='color: white;'>No se ha contestado</h1>");
                } else{
                    out.println("<tr>");          
                    out.println("<td>" + Matriz.getTituloCorrecto(pos, Matriz.getPreguntaCorrecta(pos)) + "</td>");
                    out.println("</tr>");
                    out.println("</table>");
                }
                
            }
            
            if(pos < 4){
                out.println("<form action='ContinuarTest' method='post'>");
                out.println("<input type='submit' name='submit' value='Siguiente' class='btn-siguiente'>");
                
            } else{
                out.println("<form action='FinalizarTest' method='post'>");
                out.println("<input type='submit' name='submit' value='Finalizar' class='btn-siguiente'>");
                
            }
            //LOS HIDDEN, PARA PODER LLEVAR LA CUENTA
            //Pos es la posicion de la pregunta
            pos++;
            out.println("<input type='text' name='puntos' value='" + puntos + "' hidden='true'>");
            out.println("<input type='text' name='test' value='" + test + "' hidden='true'>");
            out.println("<input type='text' name='pregunta' value='" + pos + "' hidden='true'>");
            out.println("</form>"); //dentro del form sino las variables se quedan nulas al pasar al otro 
            
            
            out.println("<form action='CerrarSesion' method='post'>");
            out.println("<input type='submit' name='submit' value='Cerrar Sesión' class='btn-exit-test' style='margin-top:-370px;'>");
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
