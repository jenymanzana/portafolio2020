
package Modelo;


public class Menu {
    
    private int Id_menu;
    private String Nombre_menu;
    private String Tipo_menu;
    private int Precio_base_menu;
    private int Precio_menu;
    private String Descripcion_menu;
    private String Ruta_imagen;
    private String Categoria_menu;
    private int Id_receta;

    public Menu(int Id_menu, String Nombre_menu, String Tipo_menu, int Precio_base_menu, int Precio_menu, String Descripcion_menu, String Ruta_imagen, String Categoria_menu, int Id_receta) {
        this.Id_menu = Id_menu;
        this.Nombre_menu = Nombre_menu;
        this.Tipo_menu = Tipo_menu;
        this.Precio_base_menu = Precio_base_menu;
        this.Precio_menu = Precio_menu;
        this.Descripcion_menu = Descripcion_menu;
        this.Ruta_imagen = Ruta_imagen;
        this.Categoria_menu = Categoria_menu;
        this.Id_receta = Id_receta;
    }

    public int getId_menu() {
        return Id_menu;
    }

    public void setId_menu(int Id_menu) {
        this.Id_menu = Id_menu;
    }

    public String getNombre_menu() {
        return Nombre_menu;
    }

    public void setNombre_menu(String Nombre_menu) {
        this.Nombre_menu = Nombre_menu;
    }

    public String getTipo_menu() {
        return Tipo_menu;
    }

    public void setTipo_menu(String Tipo_menu) {
        this.Tipo_menu = Tipo_menu;
    }

    public int getPrecio_base_menu() {
        return Precio_base_menu;
    }

    public void setPrecio_base_menu(int Precio_base_menu) {
        this.Precio_base_menu = Precio_base_menu;
    }

    public int getPrecio_menu() {
        return Precio_menu;
    }

    public void setPrecio_menu(int Precio_menu) {
        this.Precio_menu = Precio_menu;
    }

    public String getDescripcion_menu() {
        return Descripcion_menu;
    }

    public void setDescripcion_menu(String Descripcion_menu) {
        this.Descripcion_menu = Descripcion_menu;
    }

    public String getRuta_imagen() {
        return Ruta_imagen;
    }

    public void setRuta_imagen(String Ruta_imagen) {
        this.Ruta_imagen = Ruta_imagen;
    }

    public String getCategoria_menu() {
        return Categoria_menu;
    }

    public void setCategoria_menu(String Categoria_menu) {
        this.Categoria_menu = Categoria_menu;
    }

    public int getId_receta() {
        return Id_receta;
    }

    public void setId_receta(int Id_receta) {
        this.Id_receta = Id_receta;
    }
    
    
    
}
