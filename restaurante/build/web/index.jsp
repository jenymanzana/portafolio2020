

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.BaseDatos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <% 
            /////////////////*****EJEMPLO BASICO PARA COMPROBAR CONEXIÓN Y VISUALIZAR DATOS*****//////////////
            BaseDatos bd = new BaseDatos();
            Connection connection = bd.getConnection();
            Statement stm=connection.createStatement();
            ResultSet rs=stm.executeQuery("select * from empleados");
            while(rs.next())
            {
                out.println(rs.getString("nombre")+" "+rs.getString("apaterno")+"<br>");
            }
            /////////////////////////BORRAR///////////////////////////
            
String idinsumo[]=request.getParameterValues("idinsumo");


 out.print(idinsumo.length);
        %>
      
    </body>
</html>
