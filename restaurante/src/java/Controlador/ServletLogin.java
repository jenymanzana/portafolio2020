
package Controlador;

import Modelo.BaseDatos;
import Modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Jeny
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

   
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
       HttpSession session = request.getSession(false);
       
        try {
            Connection connection = bd.getConnection();
            ResultSet resultSet;
            PreparedStatement statement;
            Usuarios us = new Usuarios();
            String user = (String) request.getParameter("user");
            String pass = (String) request.getParameter("pass");
            String sqlLogin = "select * from usuarios where NICK = '"+user+"' and PASSWORD  = '"+us.getMD5(pass)+"'"; 
            if (connection!= null) {
                
                statement = connection.prepareStatement(sqlLogin);
                resultSet = statement.executeQuery();
                
                if (resultSet.next()) 
                {    
                    session = request.getSession(true);
                    
                    us.setId_empleado(resultSet.getInt("empleados_idempl"));
                    us.setId_usuario(resultSet.getInt("idusuario"));
                    us.setNick_usuario(resultSet.getString("nick"));
                    
                    //Fecha
                    Calendar c = Calendar.getInstance();
                    String day = Integer.toString(c.get(Calendar.DATE));
                    String month = Integer.toString(c.get(Calendar.MONTH)+1);
                    String year = Integer.toString(c.get(Calendar.YEAR));
                    session.setAttribute("fecha",day+"/"+month+"/"+year);
                    
                    //Usuario
                    session.setAttribute("idempleado",us.getId_empleado());
                    session.setAttribute("idusuario",us.getId_usuario());
                    session.setAttribute("nickuser",us.getNick_usuario());
                    //obtener nombre y apellido
                    String sqluser= "select * from empleados where IDEMPL = '"+us.getId_empleado()+"'"; 
                    statement = connection.prepareStatement(sqluser);
                    resultSet = statement.executeQuery();
                    if (resultSet.next()) 
                    {
                        session.setAttribute("nombre",resultSet.getString("NOMBRE")+" "+resultSet.getString("APATERNO"));
                        session.setAttribute("rol",resultSet.getString("ROL"));
                        String rol=resultSet.getString("ROL");
                        switch (rol) {
           
                        case "Garzon":
                                        response.sendRedirect("");
                            break;
                        case "Maitre":
                                        response.sendRedirect("");
                            break;
                        case "JefeCocina":
                                        response.sendRedirect("cocina/home.jsp");
                            break;
                        case "Bodeguero":
                                        response.sendRedirect("bodega/bodega.jsp");
                            break;
                        case "Administrador":
                                        response.sendRedirect("administrador/index.jsp");
                            break;
                        case "Cajero":
                                        response.sendRedirect("caja/home.jsp");
                            break;
                        }
                        
                    }
                    
                    
                } 
                else 
                {
                     response.sendRedirect("login.jsp?error");
                }
                
            } 
            
            connection.close();
            
            
        } 
        catch (Exception e) 
        {
            
            response.sendRedirect("login.jsp?error "+e);
        }
    }
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
