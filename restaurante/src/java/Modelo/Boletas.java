
package Modelo;
import java.util.Date;

public class Boletas {

    private int Id_boleta;
    private String Numero_boleta;
    private Date Fecha_boleta;
    private int Propina;
    private int Sub_total;
    private int Total_boleta;
    private int Mesa_Id_mesa;

    public Boletas(int Id_boleta, String Numero_boleta, Date Fecha_boleta, int Propina, int Sub_total, int Total_boleta, int Mesa_Id_mesa) {
        this.Id_boleta = Id_boleta;
        this.Numero_boleta = Numero_boleta;
        this.Fecha_boleta = Fecha_boleta;
        this.Propina = Propina;
        this.Sub_total = Sub_total;
        this.Total_boleta = Total_boleta;
        this.Mesa_Id_mesa = Mesa_Id_mesa;
    }

    public int getId_boleta() {
        return Id_boleta;
    }

    public void setId_boleta(int Id_boleta) {
        this.Id_boleta = Id_boleta;
    }

    public String getNumero_boleta() {
        return Numero_boleta;
    }

    public void setNumero_boleta(String Numero_boleta) {
        this.Numero_boleta = Numero_boleta;
    }

    public Date getFecha_boleta() {
        return Fecha_boleta;
    }

    public void setFecha_boleta(Date Fecha_boleta) {
        this.Fecha_boleta = Fecha_boleta;
    }

    public int getPropina() {
        return Propina;
    }

    public void setPropina(int Propina) {
        this.Propina = Propina;
    }

    public int getSub_total() {
        return Sub_total;
    }

    public void setSub_total(int Sub_total) {
        this.Sub_total = Sub_total;
    }

    public int getTotal_boleta() {
        return Total_boleta;
    }

    public void setTotal_boleta(int Total_boleta) {
        this.Total_boleta = Total_boleta;
    }

    public int getMesa_Id_mesa() {
        return Mesa_Id_mesa;
    }

    public void setMesa_Id_mesa(int Mesa_Id_mesa) {
        this.Mesa_Id_mesa = Mesa_Id_mesa;
    }
    
    
    
    
}
