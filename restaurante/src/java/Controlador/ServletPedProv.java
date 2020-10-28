
package Controlador;

import Modelo.BaseDatos;
import Modelo.Detalle_solicitud;
import Modelo.Pedido_proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServletPedProv", urlPatterns = {"/ServletPedProv"})
public class ServletPedProv extends HttpServlet {

    
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
       
        //1	Aprobado	22/10/20 15:19:05,416475000	hola
        String estado=(String)request.getParameter("estado");
        BaseDatos bd = new BaseDatos();
       switch (estado) {

        case "Pendiente":
             try {
                Connection connection = bd.getConnection();
                ResultSet resultSet;
                int total = Integer.parseInt(request.getParameter("total"));
                String comentario = (String) request.getParameter("comentario");
                
                 Pedido_proveedor pprov=new Pedido_proveedor();
                 pprov.setTotal_pedido(total);
                 pprov.setFecha_pedido(Timestamp.valueOf(LocalDateTime.now()));
                 pprov.setDescripcion_pedido(comentario);
                 pprov.setEstado(estado);
                
             if(connection!=null)
                {
                    //Guardar Oproveedor
                     String sqlOproveedor = "insert into oproveedor values(?,?,?,?,?)";
                     PreparedStatement pst = connection.prepareStatement(sqlOproveedor);
                     pst.setString(1, null);
                     pst.setInt(2, pprov.getTotal_pedido());
                     pst.setTimestamp(3, pprov.getFecha_pedido());
                     pst.setString(4, pprov.getDescripcion_pedido());
                     pst.setString(5, pprov.getEstado());
                     pst.executeQuery();
                    
                    //rescatar ultimo id
                     String sqlSelectOprov="select *  from oproveedor ORDER BY idoproveedor DESC";
                     pst=connection.prepareStatement(sqlSelectOprov);
                     resultSet = pst.executeQuery();
                     Detalle_solicitud ds=new Detalle_solicitud();
                     if (resultSet.next()) 
                     {
                        ds.setId_pedido_prov(resultSet.getInt("IDOPROVEEDOR")); 
                     }
                     
                     //guardar DSOLICITUD
                     
                     String[] idinsumo = request.getParameterValues("idinsumo");
                     String[] cantidad = request.getParameterValues("cantidad");
                     for (int i = 0; i < cantidad.length ; i++) 
                     {
                         
                         if (Integer.parseInt(cantidad[i])>0) 
                         {
                            ds.setCantidad_solicitud(Integer.parseInt(cantidad[i]));
                            ds.setId_Insumo(Integer.parseInt(idinsumo[i]));
                            
                            String sqlDSolicitud="insert into dsolicitud values (?,?,?)";
                            pst = connection.prepareStatement(sqlDSolicitud);
                            pst.setInt(1, ds.getCantidad_solicitud());
                            pst.setInt(2, ds.getId_Insumo());
                            pst.setInt(3, ds.getId_pedido_prov());
                            resultSet = pst.executeQuery();
                         }
                        
                     }
                     
                     
                     response.sendRedirect("bodega/solicitudes.jsp");  
                     
                     
                }
             
             } catch (Exception e) 
             {
                  response.sendRedirect("bodega/crear-pedido.jsp?error="+e+"");
             }
           

        break;

 

       
 

       }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
