
package Modelo;


public class Usuarios {
    
    private int Id_usuario;
    private String Nick_usuario;
    private String Pass_usuario;
    private String Id_empleado;

    public Usuarios(int Id_usuario, String Nick_usuario, String Pass_usuario, String Id_empleado) {
        this.Id_usuario = Id_usuario;
        this.Nick_usuario = Nick_usuario;
        this.Pass_usuario = Pass_usuario;
        this.Id_empleado = Id_empleado;
    }

    public int getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(int Id_usuario) {
        this.Id_usuario = Id_usuario;
    }

    public String getNick_usuario() {
        return Nick_usuario;
    }

    public void setNick_usuario(String Nick_usuario) {
        this.Nick_usuario = Nick_usuario;
    }

    public String getPass_usuario() {
        return Pass_usuario;
    }

    public void setPass_usuario(String Pass_usuario) {
        this.Pass_usuario = Pass_usuario;
    }

    public String getId_empleado() {
        return Id_empleado;
    }

    public void setId_empleado(String Id_empleado) {
        this.Id_empleado = Id_empleado;
    }
    
    
}
