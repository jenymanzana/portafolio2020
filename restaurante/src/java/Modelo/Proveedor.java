/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author chicv
 */
public class Proveedor {
    
    private int Id_proveedor;
    private String Nombre_proveedor;
    private String Rut_proveedor;
    private int Telefono_proveedor;
    private String Correo_proveedor;
    private String Direccion_proveedor;

    public Proveedor() {
    }

    
    public Proveedor(int Id_proveedor, String Nombre_proveedor, String Rut_proveedor, int Telefono_proveedor, String Correo_proveedor, String Direccion_proveedor) {
        this.Id_proveedor = Id_proveedor;
        this.Nombre_proveedor = Nombre_proveedor;
        this.Rut_proveedor = Rut_proveedor;
        this.Telefono_proveedor = Telefono_proveedor;
        this.Correo_proveedor = Correo_proveedor;
        this.Direccion_proveedor = Direccion_proveedor;
    }

    public int getId_proveedor() {
        return Id_proveedor;
    }

    public void setId_proveedor(int Id_proveedor) {
        this.Id_proveedor = Id_proveedor;
    }

    public String getNombre_proveedor() {
        return Nombre_proveedor;
    }

    public void setNombre_proveedor(String Nombre_proveedor) {
        this.Nombre_proveedor = Nombre_proveedor;
    }

    public String getRut_proveedor() {
        return Rut_proveedor;
    }

    public void setRut_proveedor(String Rut_proveedor) {
        this.Rut_proveedor = Rut_proveedor;
    }

    public int getTelefono_proveedor() {
        return Telefono_proveedor;
    }

    public void setTelefono_proveedor(int Telefono_proveedor) {
        this.Telefono_proveedor = Telefono_proveedor;
    }

    public String getCorreo_proveedor() {
        return Correo_proveedor;
    }

    public void setCorreo_proveedor(String Correo_proveedor) {
        this.Correo_proveedor = Correo_proveedor;
    }

    public String getDireccion_proveedor() {
        return Direccion_proveedor;
    }

    public void setDireccion_proveedor(String Direccion_proveedor) {
        this.Direccion_proveedor = Direccion_proveedor;
    }
    
    
}
