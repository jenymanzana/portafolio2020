
package Modelo;
import java.sql.Timestamp;
import java.util.Date;

public class Pedido_proveedor {
    
    private int Id_pedido;
    private int Total_pedido;
    private Timestamp Fecha_pedido;
    private String Descripcion_pedido;
    private String Estado;

    public Pedido_proveedor() {
    }

    public Pedido_proveedor(int Id_pedido, int Total_pedido, Timestamp Fecha_pedido, String Descripcion_pedido, String Estado) {
        this.Id_pedido = Id_pedido;
        this.Total_pedido = Total_pedido;
        this.Fecha_pedido = Fecha_pedido;
        this.Descripcion_pedido = Descripcion_pedido;
        this.Estado = Estado;
    }

    public int getId_pedido() {
        return Id_pedido;
    }

    public void setId_pedido(int Id_pedido) {
        this.Id_pedido = Id_pedido;
    }

    public int getTotal_pedido() {
        return Total_pedido;
    }

    public void setTotal_pedido(int Total_pedido) {
        this.Total_pedido = Total_pedido;
    }

    public Timestamp getFecha_pedido() {
        return Fecha_pedido;
    }

    public void setFecha_pedido(Timestamp Fecha_pedido) {
        this.Fecha_pedido = Fecha_pedido;
    }

    public String getDescripcion_pedido() {
        return Descripcion_pedido;
    }

    public void setDescripcion_pedido(String Descripcion_pedido) {
        this.Descripcion_pedido = Descripcion_pedido;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    
    
   
}
