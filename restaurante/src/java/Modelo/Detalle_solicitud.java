
package Modelo;


public class Detalle_solicitud {
    
    
    private int Cantidad_solicitud;
    private int Id_pedido_prov;
    private int Id_Insumo;

    public Detalle_solicitud() {
    }

    public Detalle_solicitud(int Cantidad_solicitud, int Id_pedido_prov, int Id_Insumo) {
        this.Cantidad_solicitud = Cantidad_solicitud;
        this.Id_pedido_prov = Id_pedido_prov;
        this.Id_Insumo = Id_Insumo;
    }

    public int getCantidad_solicitud() {
        return Cantidad_solicitud;
    }

    public void setCantidad_solicitud(int Cantidad_solicitud) {
        this.Cantidad_solicitud = Cantidad_solicitud;
    }

    public int getId_pedido_prov() {
        return Id_pedido_prov;
    }

    public void setId_pedido_prov(int Id_pedido_prov) {
        this.Id_pedido_prov = Id_pedido_prov;
    }

    public int getId_Insumo() {
        return Id_Insumo;
    }

    public void setId_Insumo(int Id_Insumo) {
        this.Id_Insumo = Id_Insumo;
    }

   
    
}
