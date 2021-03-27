package recursos.clases;

public class Servicios {
    private double Operacion;
    private double Consulta;
    private double Mantenimiento;
    private String Nombre;


    public Servicios(double operacion, double consulta, double mantenimiento, String nombre){
        this.Consulta=consulta;
        this.Mantenimiento=mantenimiento;
        this.Operacion=operacion;
        this.Nombre=nombre;
    }

    public Servicios(){

    }

    public String getNombre() {
        return Nombre;
    }

    public double getConsulta() {
        return Consulta;
    }

    public double getMantenimiento() {
        return Mantenimiento;
    }

    public double getOperacion() {
        return Operacion;
    }

    public void setConsulta(double consulta) {
        Consulta = consulta;
    }

    public void setMantenimiento(double mantenimiento) {
        Mantenimiento = mantenimiento;
    }

    public void setOperacion(double operacion) {
        Operacion = operacion;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
