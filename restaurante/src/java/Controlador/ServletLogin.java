/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
            
            String user = (String) request.getParameter("user");
            String pass = (String) request.getParameter("pass");
            String sqlLogin = "select * from usuarios where NICK = '"+user+"' and PASSWORD  = '"+getMD5(pass)+"'"; 
            if (connection!= null) {
                
                statement = connection.prepareStatement(sqlLogin);
                resultSet = statement.executeQuery();
                
                if (resultSet.next()) {
                    
                    session = request.getSession(true);
                    Usuarios Us = new Usuarios(resultSet.getInt("idusuario"),(resultSet.getString("nick")),(resultSet.getString("password")),(resultSet.getString("empleados_idempl")));
                    
                    //Fecha
                    Calendar c = Calendar.getInstance();
                    String day = Integer.toString(c.get(Calendar.DATE));
                    String month = Integer.toString(c.get(Calendar.MONTH)+1);
                    String year = Integer.toString(c.get(Calendar.YEAR));
                    session.setAttribute("fecha",day+"/"+month+"/"+year);
                    
                    //Usuario
                    session.setAttribute("idempleado",Us.getId_empleado());
                    session.setAttribute("idusuario",Us.getId_usuario());
                    session.setAttribute("nickuser",Us.getNick_usuario());
                    //obtener nombre y apellido
                    String sqluser= "select * from empleados where IDEMPL = '"+Us.getId_empleado()+"'"; 
                    statement = connection.prepareStatement(sqluser);
                    resultSet = statement.executeQuery();
                    if (resultSet.next()) 
                    {
                        session.setAttribute("nombre",resultSet.getString("NOMBRE")+" "+resultSet.getString("APATERNO"));
                    }
                    
                    response.sendRedirect("bodega/bodega.jsp");
                } else {
                     String mensaje = "Datos incorrectos";
                request.setAttribute("mensaje",mensaje);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
                requestDispatcher.forward(request,response);
                }
                
            } 
            
            connection.close();
            
            
        } catch (Exception e) {
            
            
        }
    }
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    public String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encBytes = md.digest(input.getBytes());
            BigInteger numero = new BigInteger(1, encBytes);
            String encString = numero.toString(16);
            while (encString.length() < 32) {
                encString = "0" + encString;
            }
            return encString;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
