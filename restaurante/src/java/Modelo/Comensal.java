
package Modelo;


public class Comensal {
    
    private int Id_comensal;
    private String Rut_comensal;
    private String Nombre_comensal;
    private String Apellido_comensal;
    private String Correo_comensal;
    private int Telefono_comensal;

    public Comensal(int Id_comensal, String Rut_comensal, String Nombre_comensal, String Apellido_comensal, String Correo_comensal, int Telefono_comensal) {
        this.Id_comensal = Id_comensal;
        this.Rut_comensal = Rut_comensal;
        this.Nombre_comensal = Nombre_comensal;
        this.Apellido_comensal = Apellido_comensal;
        this.Correo_comensal = Correo_comensal;
        this.Telefono_comensal = Telefono_comensal;
    }

    public int getId_comensal() {
        return Id_comensal;
    }

    public void setId_comensal(int Id_comensal) {
        this.Id_comensal = Id_comensal;
    }

    public String getRut_comensal() {
        return Rut_comensal;
    }

    public void setRut_comensal(String Rut_comensal) {
        this.Rut_comensal = Rut_comensal;
    }

    public String getNombre_comensal() {
        return Nombre_comensal;
    }

    public void setNombre_comensal(String Nombre_comensal) {
        this.Nombre_comensal = Nombre_comensal;
    }

    public String getApellido_comensal() {
        return Apellido_comensal;
    }

    public void setApellido_comensal(String Apellido_comensal) {
        this.Apellido_comensal = Apellido_comensal;
    }

    public String getCorreo_comensal() {
        return Correo_comensal;
    }

    public void setCorreo_comensal(String Correo_comensal) {
        this.Correo_comensal = Correo_comensal;
    }

    public int getTelefono_comensal() {
        return Telefono_comensal;
    }

    public void setTelefono_comensal(int Telefono_comensal) {
        this.Telefono_comensal = Telefono_comensal;
    }
    
    
}
