
package Modelo;
import java.util.Calendar;
import java.util.Date;

public class Empleados_desvinculados {
    
    
    private int Id_desvinculado;
    private Date Fecha_despido;
    private String Descripcion;
    private String Id_empleado;

    public Empleados_desvinculados() {
    }

    
    public Empleados_desvinculados(int Id_desvinculado, Date Fecha_despido, String Descripcion, String Id_empleado) {
        this.Id_desvinculado = Id_desvinculado;
        this.Fecha_despido = Fecha_despido;
        this.Descripcion = Descripcion;
        this.Id_empleado = Id_empleado;
    }

    public int getId_desvinculado() {
        return Id_desvinculado;
    }

    public void setId_desvinculado(int Id_desvinculado) {
        this.Id_desvinculado = Id_desvinculado;
    }

    public Date getFecha_despido() {
        return Fecha_despido;
    }

    public void setFecha_despido(Date Fecha_despido) {
        this.Fecha_despido = Fecha_despido;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getId_empleado() {
        return Id_empleado;
    }

    public void setId_empleado(String Id_empleado) {
        this.Id_empleado = Id_empleado;
    }
    public String Fecha(Date d)
    {
        Calendar cal = Calendar.getInstance();  
        cal.setTime(d);
        String day=Integer.toString(cal.get(java.util.Calendar.DAY_OF_MONTH));
        int month=cal.get(java.util.Calendar.MONTH)+1;
        String year=Integer.toString(cal.get(java.util.Calendar.YEAR));
        
        return (day+"/"+month+"/"+year);
    }
    
}
