
package Modelo;


public class Insumo {
    
    private int Id_insumo;
    private String Codigo_insumo;
    private String Nombre_insumo;
    private String Imagen_insumo;
    private String Categoria_insumo;
    private int Valor_insumo;
    private String Unidad_insumo;
    private int Stock_insumo;
    private String Descripcion;
    private int Id_proveedor;

    public Insumo() {
    }

    public Insumo(int Id_insumo, String Codigo_insumo, String Nombre_insumo, String Imagen_insumo, String Categoria_insumo, int Valor_insumo, String Unidad_insumo, int Stock_insumo,String insumo, String Descripcion, int Id_proveedor) {
        this.Id_insumo = Id_insumo;
        this.Codigo_insumo = Codigo_insumo;
        this.Nombre_insumo = Nombre_insumo;
        this.Imagen_insumo = Imagen_insumo;
        this.Categoria_insumo = Categoria_insumo;
        this.Valor_insumo = Valor_insumo;
        this.Unidad_insumo = Unidad_insumo;
        this.Stock_insumo = Stock_insumo;
        this.Descripcion = Descripcion;
        this.Id_proveedor = Id_proveedor;
    }



    public int getId_insumo() {
        return Id_insumo;
    }

    public void setId_insumo(int Id_insumo) {
        this.Id_insumo = Id_insumo;
    }

    public String getCodigo_insumo() {
        return Codigo_insumo;
    }

    public void setCodigo_insumo(String Codigo_insumo) {
        this.Codigo_insumo = Codigo_insumo;
    }

    public String getNombre_insumo() {
        return Nombre_insumo;
    }

    public void setNombre_insumo(String Nombre_insumo) {
        this.Nombre_insumo = Nombre_insumo;
    }

    public String getImagen_insumo() {
        return Imagen_insumo;
    }

    public void setImagen_insumo(String Imagen_insumo) {
        this.Imagen_insumo = Imagen_insumo;
    }

    public String getCategoria_insumo() {
        return Categoria_insumo;
    }

    public void setCategoria_insumo(String Categoria_insumo) {
        this.Categoria_insumo = Categoria_insumo;
    }

    public int getValor_insumo() {
        return Valor_insumo;
    }

    public void setValor_insumo(int Valor_insumo) {
        this.Valor_insumo = Valor_insumo;
    }

    public String getUnidad_insumo() {
        return Unidad_insumo;
    }

    public void setUnidad_insumo(String Unidad_insumo) {
        this.Unidad_insumo = Unidad_insumo;
    }

    public int getStock_insumo() {
        return Stock_insumo;
    }

    public void setStock_insumo(int Strock_insumo) {
        this.Stock_insumo = Strock_insumo;
    }
  
    
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getId_proveedor() {
        return Id_proveedor;
    }

    public void setId_proveedor(int Id_iproveedor) {
        this.Id_proveedor = Id_iproveedor;
    }

    
}
