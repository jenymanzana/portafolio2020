
package Controlador;

import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletReceta", urlPatterns = {"/ServletReceta"})
public class ServletReceta extends HttpServlet {

    
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
        
       String action=(String)request.getParameter("action");
       int modal=Integer.parseInt(request.getParameter("modal"));
       int id=0;
       if(action.contains("eliminar"))
       {
           id=Integer.parseInt(action.replaceAll("eliminar",""));
           action="eliminar";
       }
       BaseDatos bd = new BaseDatos();
       PreparedStatement pst;
       ResultSet resultSet;
       switch (action) {
           
        case "eliminar":
            try {
                
                int idreceta=Integer.parseInt(request.getParameter("idreceta"));
                int idinsumo=id;
                Connection connection = bd.getConnection();
                String sqlreceta = "delete dreceta where INSUMO_IDINSUMO=? and RECETAS_IDRECETA=?";
                     pst = connection.prepareStatement(sqlreceta);
                     pst.setInt(1, idinsumo);
                     pst.setInt(2, idreceta);
                     pst.executeQuery();
                 response.sendRedirect("cocina/jefe-cocina.jsp?modal="+modal);  
            } catch (Exception e) {
                response.sendRedirect("cocina/jefe-cocina.jsp?error= "+e);  
            }

        break;
        
        case "agregar":
            try {
               
                int insumo=Integer.parseInt(request.getParameter("insumo"));
                int idreceta=Integer.parseInt(request.getParameter("idreceta"));
                
                int cant=0;
                
                Connection connection = bd.getConnection();
                
                     String sqlnueva = "insert into dreceta values(?,?,?)";
                     pst = connection.prepareStatement(sqlnueva);
                     pst.setInt(1, cant);
                     pst.setInt(2, insumo);
                     pst.setInt(3, idreceta);
                     pst.executeQuery();
                
                     response.sendRedirect("cocina/jefe-cocina.jsp?modal="+modal);  
                
               
            } catch (Exception e) {
                response.sendRedirect("cocina/jefe-cocina.jsp?error= "+e);  
            }
            break;
        
        case "editar":
            try {
                String idinsumo[]=request.getParameterValues("idinsumo");
                String cantidad[]=request.getParameterValues("cantidad");
                int idreceta=Integer.parseInt(request.getParameter("idreceta"));
                int porcion=Integer.parseInt(request.getParameter("porcion"));
                
                    Connection connection = bd.getConnection();
                if(idinsumo!=null)
                {
                    for (int i = 0; i < cantidad.length; i++) 
                    {
                        if(Integer.parseInt(cantidad[i])>0)
                        {
                            String sqlnueva = "update dreceta set CANTIDAD=? where INSUMO_IDINSUMO=? AND RECETAS_IDRECETA=?";
                            pst = connection.prepareStatement(sqlnueva);
                            pst.setInt(1, Integer.parseInt(cantidad[i]));
                            pst.setInt(2, Integer.parseInt(idinsumo[i]));
                            pst.setInt(3, idreceta);
                            pst.executeQuery();
                        }
                        
                    }
                }
                    
                    
                        String sqlporcion = "update recetas set PORCIONES=? where IDRECETA=?";
                        pst = connection.prepareStatement(sqlporcion);
                        pst.setInt(1, porcion);
                        pst.setInt(2, idreceta);
                        pst.executeQuery();
                        
                        response.sendRedirect("cocina/jefe-cocina.jsp?modal="+modal);  
                     
                
                
            } catch (Exception e) {
            }
            
            
            break;
            
       }
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
