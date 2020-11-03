
package Modelo;


public class Detalle_Orden_Bodega 
{ 
    
    private int Id_RecetaOB;
    private int Id_Obodega;
    private int Cantidad_Pedido;

    public Detalle_Orden_Bodega() {
    }

    public Detalle_Orden_Bodega(int Id_RecetaOB, int Id_Obodega, int Cantidad_Pedido) {
        this.Id_RecetaOB = Id_RecetaOB;
        this.Id_Obodega = Id_Obodega;
        this.Cantidad_Pedido = Cantidad_Pedido;
    }

    public int getId_RecetaOB() {
        return Id_RecetaOB;
    }

    public void setId_RecetaOB(int Id_RecetaOB) {
        this.Id_RecetaOB = Id_RecetaOB;
    }

    public int getId_Obodega() {
        return Id_Obodega;
    }

    public void setId_Obodega(int Id_Obodega) {
        this.Id_Obodega = Id_Obodega;
    }

    public int getCantidad_Pedido() {
        return Cantidad_Pedido;
    }

    public void setCantidad_Pedido(int Cantidad_Pedido) {
        this.Cantidad_Pedido = Cantidad_Pedido;
    }
    
    
    
}
