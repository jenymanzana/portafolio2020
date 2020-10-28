
package Modelo;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class Detalle_pedido {
    
    private int cantidad_pedido;
    private Timestamp Hora_Pedido;
    private Timestamp Hora_Entrega;
    private Timestamp Hora_Preparacion;
    private int Id_Pedidos;
    private int Id_Mesa;
    private int Id_Menu;

    public Detalle_pedido() {
    }

    public Detalle_pedido(int cantidad_pedido, Timestamp Hora_Pedido, Timestamp Hora_Entrega, Timestamp Hora_Preparacion, int Id_Pedidos, int Id_Mesa, int Id_Menu) {
        this.cantidad_pedido = cantidad_pedido;
        this.Hora_Pedido = Hora_Pedido;
        this.Hora_Entrega = Hora_Entrega;
        this.Hora_Preparacion = Hora_Preparacion;
        this.Id_Pedidos = Id_Pedidos;
        this.Id_Mesa = Id_Mesa;
        this.Id_Menu = Id_Menu;
    }

    public int getCantidad_pedido() {
        return cantidad_pedido;
    }

    public void setCantidad_pedido(int cantidad_pedido) {
        this.cantidad_pedido = cantidad_pedido;
    }

    public Timestamp getHora_Pedido() {
        return Hora_Pedido;
    }

    public void setHora_Pedido(Timestamp Hora_Pedido) {
        this.Hora_Pedido = Hora_Pedido;
    }

    public Timestamp getHora_Entrega() {
        return Hora_Entrega;
    }

    public void setHora_Entrega(Timestamp Hora_Entrega) {
        this.Hora_Entrega = Hora_Entrega;
    }

    public Timestamp getHora_Preparacion() {
        return Hora_Preparacion;
    }

    public void setHora_Preparacion(Timestamp Hora_Preparacion) {
        this.Hora_Preparacion = Hora_Preparacion;
    }

    public int getId_Pedidos() {
        return Id_Pedidos;
    }

    public void setId_Pedidos(int Id_Pedidos) {
        this.Id_Pedidos = Id_Pedidos;
    }

    public int getId_Mesa() {
        return Id_Mesa;
    }

    public void setId_Mesa(int Id_Mesa) {
        this.Id_Mesa = Id_Mesa;
    }

    public int getId_Menu() {
        return Id_Menu;
    }

    public void setId_Menu(int Id_Menu) {
        this.Id_Menu = Id_Menu;
    }

    public String Hora(Timestamp h)
    {
        if(h!=null)
        {
            Calendar cal = Calendar.getInstance();  
        cal.setTime(h); 
        String hora,minuto;
        String hour=Integer.toString(cal.get(java.util.Calendar.HOUR_OF_DAY));
        String minute=Integer.toString(cal.get(java.util.Calendar.MINUTE));
        if(Integer.parseInt(hour)<10)
        {
            hora="0"+hour;
        }
        else
        {
            hora=hour;
        }
        if(Integer.parseInt(minute)<10)
        {
            minuto="0"+minute; 
        }
        else
        {
            minuto=minute;
                   
        }
        return (hora+":"+minuto);
        }
        else
        {
            return "";
        }
        
    }
   
    

    
    
}
