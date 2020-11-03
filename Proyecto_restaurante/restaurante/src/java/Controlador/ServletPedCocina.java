
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


@WebServlet(name = "ServletPedCocina", urlPatterns = {"/ServletPedCocina"})
public class ServletPedCocina extends HttpServlet {

   
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
        String estado=(String)request.getParameter("estado");
        PreparedStatement pst,st;
        ResultSet resultSet,rs;
        switch (estado) {
           
        case "Pendiente":
            try 
            {
                Connection connection = bd.getConnection();
                
                
                
                String[] idinsumo=request.getParameterValues("idinsumo");
                String[] cantidad=request.getParameterValues("cantidad");
                String[] stock=request.getParameterValues("stock");
                boolean stockdisp=true;
                for (int i = 0; i < stock.length ; i++) 
                {
                    if (Integer.parseInt(cantidad[i])>Integer.parseInt(stock[i])) 
                    {
                        stockdisp=false;
                    }
                }
                if(stockdisp)
                {
                if (connection!=null) 
                   {
                       
                       String nuevoestado=(String)request.getParameter("nuevoestado");
                        
                        if(stockdisp==true && estado.equals("Pendiente") && nuevoestado.equals("Aprobado"))
                        {
                            for (int i = 0; i < stock.length; i++) 
                            {
                                int nuevostock=Integer.parseInt(stock[i])-Integer.parseInt(cantidad[i]);
                                String sqlInsumo="update insumo set STOCK=? where IDINSUMO=?";
                                pst = connection.prepareStatement(sqlInsumo);
                                pst.setInt(1, nuevostock);
                                pst.setInt(2, Integer.parseInt(idinsumo[i]));
                                pst.executeUpdate();
                            }
                        }
                        int idpedido=Integer.parseInt(request.getParameter("idpedido"));
                        String comentario=(String)(String)request.getParameter("comentario");

                         String sqlpedido="update obodega set estado=?, comentario=? where IDOBODEGA=?";
                         pst = connection.prepareStatement(sqlpedido);
                         pst.setString(1,nuevoestado);
                         pst.setString(2, comentario);
                         pst.setInt(3, idpedido);
                         pst.executeUpdate();

                        response.sendRedirect("bodega/pedidos-cocina.jsp?correcto");  
                    } 
                }
                else
                {
                    response.sendRedirect("bodega/pedidos-cocina.jsp?error=stockinsuficiente");   
                }
                
             }
            catch (Exception e) 
            {
                response.sendRedirect("bodega/pedidos-cocina.jsp?error "+e);  
            }
            break;
            
        case "ingresar":
            //IDOBODEGA ESTADO FECHAHRA  COMENTARIO   obodega
            //1|| Pendiente||22/10/20 15:19:05,416475000|| hola
            try {
                    int idreceta=Integer.parseInt(request.getParameter("idreceta"));
                    int porciones=Integer.parseInt(request.getParameter("porciones"));
                    int cantidad=Integer.parseInt(request.getParameter("cantidad"));
                    Timestamp ts=Timestamp.valueOf(LocalDateTime.now());
                    Connection connection = bd.getConnection();
                     if (connection!=null) 
                       {
                    if(cantidad>0)
                    {
                        String sqlpedido="select * from dreceta where RECETAS_IDRECETA=?";
                             st = connection.prepareStatement(sqlpedido);
                             st.setInt(1,idreceta);
                             resultSet= st.executeQuery();

                             if(resultSet.next())
                             {

                                 String sqlingresar="insert into obodega values(?,?,?,?)";
                                 pst=connection.prepareStatement(sqlingresar);
                                 pst.setString(1, null);
                                 pst.setString(2,"Pendiente");
                                 pst.setTimestamp(3, ts);
                                 pst.setString(4, "");
                                 pst.executeQuery();
                                 String sqlid="select * from obodega order by IDOBODEGA DESC";
                                 pst=connection.prepareStatement(sqlid);
                                 rs=pst.executeQuery();
                                 int idobodega=0;
                                 if (rs.next()) 
                                 {
                                     idobodega=rs.getInt("IDOBODEGA");
                                     //RECETAS_IDRECETA OBODEGA_IDOBODEGA CANTIDADPEDIDO(CANTIDAD SOLICITADA)
                                    String sqlped="insert into dobodega values(?,?,?)";
                                    pst=connection.prepareStatement(sqlped);
                                    pst.setInt(1, idreceta);
                                    pst.setInt(2, idobodega);
                                    pst.setInt(3, cantidad);
                                    pst.executeQuery();
                                    response.sendRedirect("cocina/jefe-cocina.jsp?correcto");  
                                 }  
                             }

                    }
                    }
                
                
            
            } catch (Exception e) {
                response.sendRedirect("cocina/jefe-cocina.jsp?error "+e);  
            }
            
            
            
            
            break;
        }
    }
            
        
        
        @Override
    public String getServletInfo() {
        return "Short description";
    }
}


   
