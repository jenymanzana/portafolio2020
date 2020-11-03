
package Controlador;

import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletEmpleado extends HttpServlet {

    
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
        //nombre rut nacimiento rol contrato horas email telefono plataforma nick pass sueldo
        BaseDatos bd = new BaseDatos();
            ResultSet resultSet;
            PreparedStatement statement;
            String action=(String) request.getParameter("action");
         
             switch (action) {
                 case "agregar":
                            try {
                            Connection connection = bd.getConnection();
                            String nombre=(String)request.getParameter("nombre");
                            String apaterno=(String)request.getParameter("apaterno");
                            String amaterno=(String)request.getParameter("amaterno");
                            String rut=(String)request.getParameter("rut");
                            String rol=(String)request.getParameter("rol");
                            int horas= Integer.parseInt(request.getParameter("horas"));
                            String email=(String)request.getParameter("email");
                            int telefono= Integer.parseInt(request.getParameter("telefono"));
                            String plataforma=(String)request.getParameter("plataforma");
                            Usuarios us=new Usuarios();
                                if (plataforma.equals("s"))
                                {
                                    String nick=(String)request.getParameter("nick");
                                    String pass=(String)request.getParameter("pass");
                                    
                                    us.setNick_usuario(nick);
                                    us.setPass_usuario(pass);
                                }
                            int sueldo= Integer.parseInt(request.getParameter("sueldo"));

                            Empleados emp=new Empleados();
                            emp.setNombre_empleado(nombre);
                            emp.setApellido_paterno(apaterno);
                            emp.setApellido_materno(amaterno);
                            emp.setRut_empleado(rut);
                            emp.setRol_empleado(rol);
                            emp.setHoras_trabajo(horas);
                            emp.setEmail_empleado(email);
                            emp.setTelefono(telefono);
                            emp.setPlataforma_empleado(plataforma.charAt(0));
                            emp.setSueldo_empleado(sueldo);
                            emp.setEstado_empleado('s');
                        
                        if (connection!= null) {
                            CallableStatement cstC = connection.prepareCall("{call AGREGAREMPLEADO(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                            cstC.setString(1, null);
                            cstC.setString(2, emp.getRut_empleado());
                            cstC.setString(3, emp.getNombre_empleado());
                            cstC.setString(4, emp.getApellido_paterno());
                            cstC.setString(5, emp.getApellido_materno());
                            cstC.setString(6, emp.getRol_empleado());
                            cstC.setString(7,  emp.Fecha(request.getParameter("nacimiento")));  
                            cstC.setString(8,  emp.Fecha(request.getParameter("contrato"))); 
                            cstC.setString(9, emp.getEmail_empleado());
                            cstC.setInt(10, emp.getTelefono());
                            cstC.setInt(11, emp.getHoras_trabajo());
                            cstC.setString(12, String.valueOf(emp.isPlataforma_empleado()));
                            cstC.setInt(13, emp.getSueldo_empleado());
                            cstC.setString(14, String.valueOf(emp.isEstado_empleado()));
                            
                            if(cstC.executeUpdate()!=0)
                            {
                                if (plataforma.equals("s"))
                                {
                                    PreparedStatement pst;
                                    String sqlempl="select * from empleados order by idempl desc";
                                    pst=connection.prepareStatement(sqlempl);
                                    resultSet = pst.executeQuery();
                                    if(resultSet.next())
                                    {
                                        us.setId_empleado(resultSet.getInt("IDEMPL"));
                                    }
                                    String sqlus="insert into usuarios values(?,?,?,?)";
                                    pst=connection.prepareStatement(sqlus);
                                    pst.setString(1, null);
                                    pst.setString(2, us.getNick_usuario());
                                    pst.setString(3, us.getMD5(us.getPass_usuario()));
                                    pst.setInt(4, us.getId_empleado());
                                    pst.executeQuery();
                                }
                                
                                
                                response.sendRedirect("administrador/empleados.jsp?correcto");
                            }
                            else
                            { 
                             response.sendRedirect("administrador/empleados.jsp?error");
                            } 
                        }
                     } catch (Exception e) {
                         response.sendRedirect("administrador/empleados.jsp?error "+e);
                     }
                     break;
                     
                case "editar":
                            try {
                            Connection connection = bd.getConnection();
                            int idempleado= Integer.parseInt(request.getParameter("idempleado"));
                            String nombre=(String)request.getParameter("nombre");
                            String apaterno=(String)request.getParameter("apaterno");
                            String amaterno=(String)request.getParameter("amaterno");
                            String rol=(String)request.getParameter("rol");
                            int horas= Integer.parseInt(request.getParameter("horas"));
                            String email=(String)request.getParameter("email");
                            int telefono= Integer.parseInt(request.getParameter("telefono"));
                            String plataforma=(String)request.getParameter("plataforma");
                            int sueldo= Integer.parseInt(request.getParameter("sueldo"));
                            Empleados emp=new Empleados();
                            emp.setId_empleado(idempleado);
                            emp.setNombre_empleado(nombre);
                            emp.setApellido_paterno(apaterno);
                            emp.setApellido_materno(amaterno);
                            emp.setRol_empleado(rol);
                            emp.setHoras_trabajo(horas);
                            emp.setEmail_empleado(email);
                            emp.setTelefono(telefono);
                            emp.setPlataforma_empleado(plataforma.charAt(0));
                            emp.setSueldo_empleado(sueldo);
                            emp.setEstado_empleado('s');
                            
                            CallableStatement cstC = connection.prepareCall("{call EDITAREMPLEADO(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                            cstC.setInt(1, emp.getId_empleado());
                            cstC.setString(2, emp.getNombre_empleado());
                            cstC.setString(3, emp.getApellido_paterno());
                            cstC.setString(4, emp.getApellido_materno());
                            cstC.setString(5, emp.getRol_empleado());
                            cstC.setString(6,  emp.Fecha(request.getParameter("nacimiento")));  
                            cstC.setString(7,  emp.Fecha(request.getParameter("contrato"))); 
                            cstC.setString(8, emp.getEmail_empleado());
                            cstC.setInt(9, emp.getTelefono());
                            cstC.setInt(10, emp.getHoras_trabajo());
                            cstC.setString(11, String.valueOf(emp.isPlataforma_empleado()));
                            cstC.setInt(12, emp.getSueldo_empleado());
                            cstC.setString(13, String.valueOf(emp.isEstado_empleado()));
                            
                             if(cstC.executeUpdate()!=0)
                            {
                                response.sendRedirect("administrador/empleados.jsp?correcto");
                            } 
                    } catch (Exception e) {
                        response.sendRedirect("administrador/empleados.jsp?error "+e);
                    }
                    break;
                    
                    
                case "desvincular":
                        try {
                            Connection connection = bd.getConnection();
                             int idempleado= Integer.parseInt(request.getParameter("idempleado"));
                             String descripcion=(String)request.getParameter("descripcion");
                             char estado='n';
                             PreparedStatement pst;
                             String sqldesv="update empleados set ESTADO=? where IDEMPL=?";
                             pst = connection.prepareStatement(sqldesv);
                             pst.setString(1,String.valueOf(estado));
                             pst.setInt(2, idempleado); 
                             
                             if(pst.executeUpdate()!=0)
                            {
                                
                                    String sqlus="insert into edesvinculados values(?,?,?,?)";
                                    pst=connection.prepareStatement(sqlus);
                                    pst.setString(1, null);
                                    pst.setDate(2, getCurrentDate());
                                    pst.setString(3, descripcion);
                                    pst.setInt(4, idempleado);
                                    pst.executeQuery();
                                    response.sendRedirect("administrador/empleados.jsp?correcto");
                            } 
                    } catch (Exception e) {
                        response.sendRedirect("administrador/empleados.jsp?error "+e);
                    }
                    break;
                    
            case "recontratar":
                        try {
                             Connection connection = bd.getConnection();
                             int idempleado= Integer.parseInt(request.getParameter("idempleado"));
                             int iddesvinculado= Integer.parseInt(request.getParameter("iddesvinculado"));
                             char estado='s';
                             PreparedStatement pst;
                             String sqldesv="delete edesvinculados where IDDESVIN=?";
                             pst = connection.prepareStatement(sqldesv);
                             pst.setInt(1,iddesvinculado);
                             if(pst.executeUpdate()!=0)
                            {
                                String sqlrein="update empleados set ESTADO=? where IDEMPL=?";
                                pst = connection.prepareStatement(sqlrein);
                                pst.setString(1,String.valueOf(estado));
                                pst.setInt(2, idempleado);
                                pst.executeQuery();
                                
                                response.sendRedirect("administrador/empleados.jsp?correcto");
                            }
                             
                             
                } catch (Exception e) {
                    response.sendRedirect("administrador/empleados.jsp?error "+e);
                }
                break;
                
                case "eliminar":
                        try {
                             Connection connection = bd.getConnection();
                             int idempleado= Integer.parseInt(request.getParameter("idempleado"));
                             int iddesvinculado= Integer.parseInt(request.getParameter("iddesvinculado"));
                             PreparedStatement pst;
                             String sqldesv="delete edesvinculados where IDDESVIN=?";
                             pst = connection.prepareStatement(sqldesv);
                             pst.setInt(1,iddesvinculado);
                             if(pst.executeUpdate()!=0)
                            {
                                String sqlrein="delete empleados where IDEMPL=?";
                                pst = connection.prepareStatement(sqlrein);
                                pst.setInt(1, idempleado);
                                pst.executeQuery();
                                
                                response.sendRedirect("administrador/empleados.jsp?correcto");
                            }
                             
                             
                } catch (Exception e) {
                    response.sendRedirect("administrador/empleados.jsp?error "+e);
                }
                break;
                
             }
             
    }
    
    private static java.sql.Date getCurrentDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    

}
