
package Modelo;


public class Mesa {
    
    private int Id_mesa;
    private int Numero_mesa;
    private int Capacidad_mesa;

    public Mesa(int Id_mesa, int Numero_mesa, int Capacidad_mesa) {
        this.Id_mesa = Id_mesa;
        this.Numero_mesa = Numero_mesa;
        this.Capacidad_mesa = Capacidad_mesa;
    }

    public int getId_mesa() {
        return Id_mesa;
    }

    public void setId_mesa(int Id_mesa) {
        this.Id_mesa = Id_mesa;
    }

    public int getNumero_mesa() {
        return Numero_mesa;
    }

    public void setNumero_mesa(int Numero_mesa) {
        this.Numero_mesa = Numero_mesa;
    }

    public int getCapacidad_mesa() {
        return Capacidad_mesa;
    }

    public void setCapacidad_mesa(int Capacidad_mesa) {
        this.Capacidad_mesa = Capacidad_mesa;
    }
    
    
}
