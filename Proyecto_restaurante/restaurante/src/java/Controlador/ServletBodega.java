
package Controlador;

import Modelo.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
/**
 *
 * @author Jeny
 */
@MultipartConfig //Imagen
@WebServlet(name = "ServletBodega", urlPatterns = {"/ServletBodega"})
public class ServletBodega extends HttpServlet {

  
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
                 
           // AGREGAR nuevo insumo 
          case "ingresar":
            try {
            Connection connection = bd.getConnection();
            String nombrei = (String) request.getParameter("nombre");
            String categoriai = (String) request.getParameter("categoria");
            int proveedor = Integer.parseInt(request.getParameter("proveedor"));
            int valori = Integer.parseInt(request.getParameter("valor"));
            String unidadi = (String) request.getParameter("unidad");
            int stocki = Integer.parseInt(request.getParameter("stock"));
            String descripcioni = (String) request.getParameter("descripcion");
            
                        //Guardar Imagen
           String imagen;
            if(request.getPart("imagen").getSize()>0)
            {
                String context = request.getServletContext().getRealPath("img/Bodega");//rescata ruta del proyecto y agrega el destino
                File uploads = new File(context);
                Part filePart = request.getPart("imagen");
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();//rescata nombre de imagen con la extensión
                imagen="img/Bodega/"+fileName;//ruta que se envia a la bd
                File f = new File(fileName);
                File file = new File(uploads, f.getName());
                InputStream input = filePart.getInputStream();
                Files.copy(input, file.toPath(),StandardCopyOption.REPLACE_EXISTING);//guarda la imagen en la ruta
            }
            else
            {
                imagen="img/Bodega/no-disponible.png";
            }
            
             HttpSession session = request.getSession(true);
             Insumo ins=new Insumo();
             ins.setNombre_insumo(nombrei);
             ins.setImagen_insumo(imagen);
             ins.setCategoria_insumo(categoriai);
             ins.setId_proveedor(proveedor);
             ins.setValor_insumo(valori);
             ins.setUnidad_insumo(unidadi);
             ins.setStock_insumo(stocki);
             ins.setDescripcion(descripcioni);
             
             
            if (connection!= null) {
                
                
                 //Agregar Insumo
                        CallableStatement cstC = connection.prepareCall("{call AGREGARINSUMO(?,?,?,?,?,?,?,?,?,?)}");
                        cstC.setString(1, null);
                        cstC.setString(2, null);
                        cstC.setString(3, ins.getNombre_insumo());
                        cstC.setString(4, ins.getImagen_insumo());
                        cstC.setString(5, ins.getCategoria_insumo());
                        cstC.setInt(6, ins.getValor_insumo());
                        cstC.setString(7, ins.getUnidad_insumo());
                        cstC.setInt(8, ins.getStock_insumo());
                        cstC.setInt(9, ins.getId_proveedor());
                        cstC.setString(10, ins.getDescripcion() );
                        
                       if(cstC.executeUpdate()!=0)
                       {
                           response.sendRedirect("bodega/bodega.jsp");
                       }
                       else
                       { 
                        session.setAttribute("error","error");
                        response.sendRedirect("bodega/bodega.jsp");
                       }
                       
                
            } 
            
            connection.close();
            
            
        } catch (Exception e) {
            
             response.sendRedirect("bodega/bodega.jsp");
        }
        break;
        
      
       case "editar":
            try {
            Connection connection = bd.getConnection();
            int idinsumo = Integer.parseInt(request.getParameter("idinsumo"));
            String nombrei = (String) request.getParameter("nombre");
            String categoriai = (String) request.getParameter("categoria");
            int proveedor = Integer.parseInt(request.getParameter("proveedor"));
            int valori = Integer.parseInt(request.getParameter("valor"));
            String unidadi = (String) request.getParameter("unidad");
            int stocki = Integer.parseInt(request.getParameter("stock"));
            String descripcioni = (String) request.getParameter("descripcion");
            String img=(String) request.getParameter("img");
            //Guardar Imagen
            
            
            String imagen;
            if(request.getPart("imagen").getSize()>0)
            {
                String context = request.getServletContext().getRealPath("img/Bodega");//rescata ruta del proyecto y agrega el destino
                File uploads = new File(context);
                Part filePart = request.getPart("imagen");
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();//rescata nombre de imagen con la extensión
                imagen="img/Bodega/"+fileName;//ruta que se envia a la bd
                File f = new File(fileName);
                File file = new File(uploads, f.getName());
                InputStream input = filePart.getInputStream();
                Files.copy(input, file.toPath(),StandardCopyOption.REPLACE_EXISTING);//guarda la imagen en la ruta
            }
            else
            {
                imagen=img;
            }
           
            
             HttpSession session = request.getSession(true);
             Insumo ins=new Insumo();
             ins.setId_insumo(idinsumo);
             ins.setNombre_insumo(nombrei);
             ins.setImagen_insumo(imagen);
             ins.setCategoria_insumo(categoriai);
             ins.setId_proveedor(proveedor);
             ins.setValor_insumo(valori);
             ins.setUnidad_insumo(unidadi);
             ins.setStock_insumo(stocki);
             ins.setDescripcion(descripcioni);
             
            if (connection!= null) {
              
                
                        CallableStatement cstC = connection.prepareCall("{call EDITARINSUMO(?,?,?,?,?,?,?,?,?)}");
                        cstC.setInt(1, ins.getId_insumo());
                        cstC.setString(2, ins.getNombre_insumo());
                        cstC.setString(3, ins.getImagen_insumo());
                        cstC.setString(4, ins.getCategoria_insumo());
                        cstC.setInt(5, ins.getValor_insumo());
                        cstC.setString(6, ins.getUnidad_insumo());
                        cstC.setInt(7, ins.getStock_insumo());
                        cstC.setInt(8, ins.getId_proveedor());
                        cstC.setString(9, ins.getDescripcion() );
                        
                        
                       if(cstC.executeUpdate()!=0)
                       {
                           response.sendRedirect("bodega/bodega.jsp?correcto");
                       }
                       else
                       {
                            
                            response.sendRedirect("bodega/bodega.jsp?error");
                       }
                       
                       
                
            } 
            connection.close();
            
        } catch (Exception e) {
             
             response.sendRedirect("bodega/bodega.jsp?error "+e);
        }
        break;

        //ELIMINAR insumos desde Bodega
        case "eliminar":
             try {
                 String idi = (String) request.getParameter("idinsumo");
                 Proveedor pro=new Proveedor();
                 pro.setRut_proveedor(idi);
                 Connection connection = bd.getConnection();
            if (connection!= null) {
                
                 //Eliminar Insumo
                        CallableStatement cstC = connection.prepareCall("{call ELIMINARINSUMO (?)}");
                        cstC.setString(1, pro.getRut_proveedor());
                        
                       cstC.executeUpdate();
                       
                       response.sendRedirect("bodega/bodega.jsp");
                
            } 
            connection.close();
            
        } catch (Exception e) {
            
             response.sendRedirect("bodega/bodega.jsp");
        }
        break;
 }
       
      
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
