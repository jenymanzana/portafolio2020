
package Modelo;

import java.sql.Timestamp;


public class Orden_Bodega {
    
    private int Id_OBodega;
    private String Estado;
    private Timestamp FechaHra;
    private String Comentario;

    public Orden_Bodega() {
    }

    public Orden_Bodega(int Id_OBodega, String Estado, Timestamp FechaHra, String Comentario) {
        this.Id_OBodega = Id_OBodega;
        this.Estado = Estado;
        this.FechaHra = FechaHra;
        this.Comentario = Comentario;
    }

    public int getId_OBodega() {
        return Id_OBodega;
    }

    public void setId_OBodega(int Id_OBodega) {
        this.Id_OBodega = Id_OBodega;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Timestamp getFechaHra() {
        return FechaHra;
    }

    public void setFechaHra(Timestamp FechaHra) {
        this.FechaHra = FechaHra;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }
    
    
    
}
