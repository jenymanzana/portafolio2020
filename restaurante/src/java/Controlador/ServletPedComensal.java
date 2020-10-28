
package Controlador;

import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServletPedComensal", urlPatterns = {"/ServletPedComensal"})
public class ServletPedComensal extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         BaseDatos bd = new BaseDatos();
         String action=(String)request.getParameter("action");
         PreparedStatement pst;
         ResultSet resultSet;
         HttpSession session=request.getSession(true);
         switch (action) {
           
        case "Preparando":
            try {
                    Connection connection = bd.getConnection();
                    String[] idpedido=request.getParameterValues("idpedido");
                    String codigo=(String)request.getParameter("codigo");
                    String cocinero=(String)request.getParameter("cocinero");
                
                     String sqlpedido="update pedidos set ESTADO=? where CODPEDIDO=?";
                     pst = connection.prepareStatement(sqlpedido);
                     pst.setString(1, action);
                     pst.setString(2, codigo);
                    
                     if(pst.executeUpdate()!=0)
                     {
                         session.setAttribute("cocinero"+codigo,cocinero);
                         for (int i = 0; i < idpedido.length; i++) 
                         {
                             String sqldpedido="update dpedido set HORAPREPARACION=? where PEDIDOS_IDPEDIDO=?";
                             pst = connection.prepareStatement(sqldpedido);
                             pst.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
                             pst.setInt(2, Integer.parseInt(idpedido[i]));
                             pst.executeUpdate();
                         }
                         response.sendRedirect("cocina/home.jsp?correcto");
                     }
            } catch (Exception e) {
                response.sendRedirect("cocina/home.jsp?error "+e);  
            }
            
            
            break;
            
            
        case "Listo":
             try {
                    Connection connection = bd.getConnection();
                    String[] idpedido=request.getParameterValues("idpedido");
                    String codigo=(String)request.getParameter("codigo");
                
                     String sqlpedido="update pedidos set ESTADO=? where CODPEDIDO=?";
                     pst = connection.prepareStatement(sqlpedido);
                     pst.setString(1, action);
                     pst.setString(2, codigo);
                    
                     if(pst.executeUpdate()!=0)
                     {
                         
                         for (int i = 0; i < idpedido.length; i++) 
                         {
                             String sqldpedido="update dpedido set HORAENTREGA=? where PEDIDOS_IDPEDIDO=?";
                             pst = connection.prepareStatement(sqldpedido);
                             pst.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
                             pst.setInt(2, Integer.parseInt(idpedido[i]));
                             pst.executeUpdate();
                         }
                         response.sendRedirect("cocina/home.jsp?correcto");
                     }
            } catch (Exception e) {
                response.sendRedirect("cocina/home.jsp?error "+e);  
            }
            
            
         }
         
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
