
package Controlador;

import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(name = "ServletProveedor", urlPatterns = {"/ServletProveedor"})
public class ServletProveedor extends HttpServlet {

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
            ResultSet resultSet;
            PreparedStatement statement;
            String action=(String) request.getParameter("action");
            
            switch (action) {
                
        case "ingresar":
            try {
            Connection connection = bd.getConnection();
            String nombrep = (String) request.getParameter("nombre");
            String rutp = (String) request.getParameter("rut");
            int telefonop = Integer.parseInt(request.getParameter("telefono"));
            String correop = (String) request.getParameter("correo");
            String direccionp = (String) request.getParameter("direccion");
           
            
             Proveedor pro=new Proveedor();
             pro.setCorreo_proveedor(correop);
             pro.setDireccion_proveedor(direccionp);
             pro.setNombre_proveedor(nombrep);
             pro.setRut_proveedor(rutp);
             pro.setTelefono_proveedor(telefonop);
            
            if (connection!= null) {
                
                 //Agregar proveedor
                        CallableStatement cstC = connection.prepareCall("{call AGREGARPROVEEDOR (?,?,?,?,?,?)}");
                        cstC.setString(1, null);
                        cstC.setString(2, pro.getNombre_proveedor());
                        cstC.setString(3, pro.getRut_proveedor());
                        cstC.setInt(4, pro.getTelefono_proveedor());
                        cstC.setString(5, pro.getCorreo_proveedor());
                        cstC.setString(6, pro.getDireccion_proveedor());
                        
                       cstC.executeUpdate();
                       
                       response.sendRedirect("administrador/bodega-proveedores.jsp");
                
            } 
            
            connection.close();
            
            
        } catch (Exception e) {
            
             response.sendRedirect("administrador/bodega-proveedores.jsp");
        }
        break;
        
        case "editar":
             try {
            Connection connection = bd.getConnection();
             String nombrep = (String) request.getParameter("nombre");
            String rutp = (String) request.getParameter("rut");
            int telefonop = Integer.parseInt(request.getParameter("telefono"));
            String correop = (String) request.getParameter("correo");
            String direccionp = (String) request.getParameter("direccion");
            int idProveedor = Integer.parseInt(request.getParameter("idproveedor"));
            
            
             Proveedor pro=new Proveedor();
             pro.setCorreo_proveedor(correop);
             pro.setDireccion_proveedor(direccionp);
             pro.setNombre_proveedor(nombrep);
             pro.setRut_proveedor(rutp);
             pro.setTelefono_proveedor(telefonop);
             pro.setId_proveedor(idProveedor);
            
            if (connection!= null) {
                
                 //Editar Proveedor
                        CallableStatement cstC = connection.prepareCall("{call EDITARPROVEEDOR (?,?,?,?,?,?)}");
                        cstC.setInt(1, pro.getId_proveedor());
                        cstC.setString(2, pro.getNombre_proveedor());
                        cstC.setString(3, pro.getRut_proveedor());
                        cstC.setInt(4, pro.getTelefono_proveedor());
                        cstC.setString(5, pro.getCorreo_proveedor());
                        cstC.setString(6, pro.getDireccion_proveedor());
                        
                       cstC.executeUpdate();
                       
                       response.sendRedirect("administrador/bodega-proveedores.jsp");
                
            } 
            connection.close();
            
        } catch (Exception e) {
            
             response.sendRedirect("administrador/bodega-proveedores.jsp");
        }
        break;

        case "eliminar":
             try {
                 String rutp = (String) request.getParameter("rut");
                 Proveedor pro=new Proveedor();
                 pro.setRut_proveedor(rutp);
                Connection connection = bd.getConnection();
            if (connection!= null) {
                
                 //Editar Proveedor
                        CallableStatement cstC = connection.prepareCall("{call ELIMINARPROVEEDOR (?)}");
                        cstC.setString(1, pro.getRut_proveedor());
                        
                       cstC.executeUpdate();
                       
                       response.sendRedirect("administrador/bodega-proveedores.jsp");
                
            } 
            connection.close();
            
        } catch (Exception e) {
            
             response.sendRedirect("administrador/bodega-proveedores.jsp");
        }
        break;
 }
       
        
    
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
