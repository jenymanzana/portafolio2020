
package Modelo;
import java.util.Date;

public class Reserva {
    
    private int Id_reserva;
    private Date Fecha_reserva;
    private String Hora_reseva;
    private String Numero_reserva;
    private int Acompañantes_Reserva;
    private int Id_comensal;
    private int Id_mesa;

    public Reserva(int Id_reserva, Date Fecha_reserva, String Hora_reseva, String Numero_reserva, int Acompañantes_Reserva, int Id_comensal, int Id_mesa) {
        this.Id_reserva = Id_reserva;
        this.Fecha_reserva = Fecha_reserva;
        this.Hora_reseva = Hora_reseva;
        this.Numero_reserva = Numero_reserva;
        this.Acompañantes_Reserva = Acompañantes_Reserva;
        this.Id_comensal = Id_comensal;
        this.Id_mesa = Id_mesa;
    }

    public int getId_reserva() {
        return Id_reserva;
    }

    public void setId_reserva(int Id_reserva) {
        this.Id_reserva = Id_reserva;
    }

    public Date getFecha_reserva() {
        return Fecha_reserva;
    }

    public void setFecha_reserva(Date Fecha_reserva) {
        this.Fecha_reserva = Fecha_reserva;
    }

    public String getHora_reseva() {
        return Hora_reseva;
    }

    public void setHora_reseva(String Hora_reseva) {
        this.Hora_reseva = Hora_reseva;
    }

    public String getNumero_reserva() {
        return Numero_reserva;
    }

    public void setNumero_reserva(String Numero_reserva) {
        this.Numero_reserva = Numero_reserva;
    }

    public int getAcompañantes_Reserva() {
        return Acompañantes_Reserva;
    }

    public void setAcompañantes_Reserva(int Acompañantes_Reserva) {
        this.Acompañantes_Reserva = Acompañantes_Reserva;
    }

    public int getId_comensal() {
        return Id_comensal;
    }

    public void setId_comensal(int Id_comensal) {
        this.Id_comensal = Id_comensal;
    }

    public int getId_mesa() {
        return Id_mesa;
    }

    public void setId_mesa(int Id_mesa) {
        this.Id_mesa = Id_mesa;
    }
    
    
}
