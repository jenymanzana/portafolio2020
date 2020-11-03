
package Modelo;
import java.util.Calendar;
import java.util.Date;

public class Empleados {
    
    private int Id_empleado;
    private String Rut_empleado;
    private String Nombre_empleado;
    private String Apellido_paterno;
    private String Apellido_materno;
    private String rol_empleado;
    private Date Fecha_nacimiento;
    private Date Fecha_contrato;
    private int Horas_trabajo;
    private String Email_empleado;
    private int Telefono;
    private char Plataforma_empleado;
    private int Sueldo_empleado;
    private char Estado_empleado;

    public Empleados() {
    }

    public Empleados(int Id_empleado, String Rut_empleado, String Nombre_empleado, String Apellido_paterno, String Apellido_materno, String rol_empleado, Date Fecha_nacimiento, Date Fecha_contrato, int Horas_trabajo, String Email_empleado, int Telefono, char Plataforma_empleado, int Sueldo_empleado, char Estado_empleado) {
        this.Id_empleado = Id_empleado;
        this.Rut_empleado = Rut_empleado;
        this.Nombre_empleado = Nombre_empleado;
        this.Apellido_paterno = Apellido_paterno;
        this.Apellido_materno = Apellido_materno;
        this.rol_empleado = rol_empleado;
        this.Fecha_nacimiento = Fecha_nacimiento;
        this.Fecha_contrato = Fecha_contrato;
        this.Horas_trabajo = Horas_trabajo;
        this.Email_empleado = Email_empleado;
        this.Telefono = Telefono;
        this.Plataforma_empleado = Plataforma_empleado;
        this.Sueldo_empleado = Sueldo_empleado;
        this.Estado_empleado = Estado_empleado;
    }

    public int getId_empleado() {
        return Id_empleado;
    }

    public void setId_empleado(int Id_empleado) {
        this.Id_empleado = Id_empleado;
    }

    public String getRut_empleado() {
        return Rut_empleado;
    }

    public void setRut_empleado(String Rut_empleado) {
        this.Rut_empleado = Rut_empleado;
    }

    public String getNombre_empleado() {
        return Nombre_empleado;
    }

    public void setNombre_empleado(String Nombre_empleado) {
        this.Nombre_empleado = Nombre_empleado;
    }

    public String getApellido_paterno() {
        return Apellido_paterno;
    }

    public void setApellido_paterno(String Apellido_paterno) {
        this.Apellido_paterno = Apellido_paterno;
    }

    public String getApellido_materno() {
        return Apellido_materno;
    }

    public void setApellido_materno(String Apellido_materno) {
        this.Apellido_materno = Apellido_materno;
    }

    public String getRol_empleado() {
        return rol_empleado;
    }

    public void setRol_empleado(String rol_empleado) {
        this.rol_empleado = rol_empleado;
    }

    public Date getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date Fecha_nacimiento) {
        this.Fecha_nacimiento = Fecha_nacimiento;
    }

    public Date getFecha_contrato() {
        return Fecha_contrato;
    }

    public void setFecha_contrato(Date Fecha_contrato) {
        this.Fecha_contrato = Fecha_contrato;
    }

    public int getHoras_trabajo() {
        return Horas_trabajo;
    }

    public void setHoras_trabajo(int Horas_trabajo) {
        this.Horas_trabajo = Horas_trabajo;
    }

    public String getEmail_empleado() {
        return Email_empleado;
    }

    public void setEmail_empleado(String Email_empleado) {
        this.Email_empleado = Email_empleado;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public char isPlataforma_empleado() {
        return Plataforma_empleado;
    }

    public void setPlataforma_empleado(char Plataforma_empleado) {
        this.Plataforma_empleado = Plataforma_empleado;
    }

    public int getSueldo_empleado() {
        return Sueldo_empleado;
    }

    public void setSueldo_empleado(int Sueldo_empleado) {
        this.Sueldo_empleado = Sueldo_empleado;
    }

    public char isEstado_empleado() {
        return Estado_empleado;
    }

    public void setEstado_empleado(char Estado_empleado) {
        this.Estado_empleado = Estado_empleado;
    }

    public String NombreAp()
    {
        return Nombre_empleado+" "+Apellido_paterno;
    }
    public int Edad()
    {
       Calendar fechaActual = Calendar.getInstance();
       Calendar fechaNac=Calendar.getInstance();
       fechaNac.setTime(this.Fecha_nacimiento);
        
        int years = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int months = fechaActual.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int days = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
 
        if(months < 0  || (months==0 && days < 0)) 
        { 
            years--;
        }
        return years;
    }
    public String Plataforma()
    {
        if (Plataforma_empleado=='s' ) 
        {
          return  "Sí";
        }
        else
        if(Plataforma_empleado=='n')
        {
            return "No";
        }
        else
        {
             return"";
        }
       
    }
    public String Fecha(String f)
    {
            String[] parts = f.split("-");
            String day = parts[2]; 
            String month = parts[1];
            String year = parts[0];
            year=year.substring(2);
            
            return day+"-"+month+"-"+year;
    }
    
}
