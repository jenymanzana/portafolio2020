
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Demo extends HttpServlet {

   
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
        try {
            
            String date = request.getParameter("date");
            String[] parts = date.split("-");
            String day = parts[2]; 
            String month = parts[1];
            String year = parts[0];
            year=year.substring(2);
            
            
        response.sendRedirect("index.jsp?fecha="+day+"-"+month+"-"+year);
        } catch (Exception e) {
            response.sendRedirect("index.jsp?error "+e);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
