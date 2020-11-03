
package Controlador;

import Modelo.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "ServletInsumo", urlPatterns = {"/ServletInsumo"})
public class ServletInsumo extends HttpServlet {

    
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
            String nombre = (String) request.getParameter("nombre");
            String unidad = (String) request.getParameter("unidad");
            String categoria = (String) request.getParameter("categoria");
            int proveedor = Integer.parseInt(request.getParameter("proveedor"));
            int valor = Integer.parseInt(request.getParameter("valor"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            String descripcion = (String) request.getParameter("descripcion");
            
            //Guardar Imagen
            String context = request.getServletContext().getRealPath("img/Bodega");//rescata ruta del proyecto y agrega el destino
            File uploads = new File(context);
            Part filePart = request.getPart("imagen");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();//rescata nombre de imagen con la extensión
            String imagen="img/Bodega/"+fileName;//ruta que se envia a la bd
            File f = new File(fileName);
            File file = new File(uploads, f.getName());
            InputStream input = filePart.getInputStream();
            Files.copy(input, file.toPath());//guarda la imagen en la ruta
            
            HttpSession session = request.getSession(true);
             Insumo in=new Insumo();
             in.setNombre_insumo(nombre);
             in.setUnidad_insumo(unidad);
             in.setCategoria_insumo(categoria);
             in.setId_proveedor(proveedor);
             in.setValor_insumo(valor);
             in.setStock_insumo(stock);
             in.setDescripcion(descripcion);
             in.setImagen_insumo(imagen);
            
            if (connection!= null) {
                
                
                 //Agregar Insumo
                        CallableStatement cstC = connection.prepareCall("{call AGREGARINSUMO(?,?,?,?,?,?,?,?,?,?)}");
                        cstC.setString(1, null);
                        cstC.setString(2, null);
                        cstC.setString(3, in.getNombre_insumo());
                        cstC.setString(4, in.getImagen_insumo());
                        cstC.setString(5, in.getCategoria_insumo());
                        cstC.setInt(6, in.getValor_insumo());
                        cstC.setString(7, in.getUnidad_insumo());
                        cstC.setInt(8, in.getStock_insumo());
                        cstC.setInt(9, in.getId_proveedor());
                        cstC.setString(10, in.getDescripcion() );
                        
                       if(cstC.executeUpdate()!=0)
                       {
                           response.sendRedirect("administrador/bodega-productos.jsp");
                       }
                       else
                       { 
                        session.setAttribute("error","error");
                        response.sendRedirect("administrador/bodega-productos.jsp");
                       }
                       
                
            } 
            
            connection.close();
            
            
        } catch (Exception e) {
             HttpSession session = request.getSession(true);
             session.setAttribute("error","error2 "+e);
             response.sendRedirect("administrador/bodega-productos.jsp");
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
