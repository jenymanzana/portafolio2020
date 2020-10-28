
package Modelo;


public class Recetas {
 
    private int Id_receta;
    private String Nombre_receta;
    private String Descripcion_receta;
    private int Porciones_receta;
    private String Categoria_receta;

    public Recetas() {
    }

    
    public Recetas(int Id_receta, String Nombre_receta, String Descripcion_receta, int Porciones_receta, String Categoria_receta) {
        this.Id_receta = Id_receta;
        this.Nombre_receta = Nombre_receta;
        this.Descripcion_receta = Descripcion_receta;
        this.Porciones_receta = Porciones_receta;
        this.Categoria_receta = Categoria_receta;
    }

    public int getId_receta() {
        return Id_receta;
    }

    public void setId_receta(int Id_receta) {
        this.Id_receta = Id_receta;
    }

    public String getNombre_receta() {
        return Nombre_receta;
    }

    public void setNombre_receta(String Nombre_receta) {
        this.Nombre_receta = Nombre_receta;
    }

    public String getDescripcion_receta() {
        return Descripcion_receta;
    }

    public void setDescripcion_receta(String Descripcion_receta) {
        this.Descripcion_receta = Descripcion_receta;
    }

    public int getPorciones_receta() {
        return Porciones_receta;
    }

    public void setPorciones_receta(int Porciones_receta) {
        this.Porciones_receta = Porciones_receta;
    }

    public String getCategoria_receta() {
        return Categoria_receta;
    }

    public void setCategoria_receta(String Categoria_receta) {
        this.Categoria_receta = Categoria_receta;
    }
    
    
}
