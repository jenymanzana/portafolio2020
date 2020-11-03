
package Modelo;
import java.sql.Timestamp;
import java.util.Date;

public class Pedidos {
    
    private int Id_pedido;
    private String Codigo_pedido;
    private Timestamp Fecha_pedido;
    private int Id_mesa;
    private String Estado;
    private int Id_Empleado;

    public Pedidos() {
    }

    public Pedidos(int Id_pedido, String Codigo_pedido, Timestamp Fecha_pedido, int Id_mesa, String Estado, int Id_Empleado) {
        this.Id_pedido = Id_pedido;
        this.Codigo_pedido = Codigo_pedido;
        this.Fecha_pedido = Fecha_pedido;
        this.Id_mesa = Id_mesa;
        this.Estado = Estado;
        this.Id_Empleado = Id_Empleado;
    }

    public int getId_pedido() {
        return Id_pedido;
    }

    public void setId_pedido(int Id_pedido) {
        this.Id_pedido = Id_pedido;
    }

    public String getCodigo_pedido() {
        return Codigo_pedido;
    }

    public void setCodigo_pedido(String Codigo_pedido) {
        this.Codigo_pedido = Codigo_pedido;
    }

    public Timestamp getFecha_pedido() {
        return Fecha_pedido;
    }

    public void setFecha_pedido(Timestamp Fecha_pedido) {
        this.Fecha_pedido = Fecha_pedido;
    }

    public int getId_mesa() {
        return Id_mesa;
    }

    public void setId_mesa(int Id_mesa) {
        this.Id_mesa = Id_mesa;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getId_Empleado() {
        return Id_Empleado;
    }

    public void setId_Empleado(int Id_Empleado) {
        this.Id_Empleado = Id_Empleado;
    }

   
    
    
    
}
