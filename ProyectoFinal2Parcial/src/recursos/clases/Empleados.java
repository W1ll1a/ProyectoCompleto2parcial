package recursos.clases;

import java.util.Date;

public class Empleados {
    private int codigo;
    private String nombre ;
    private int edad;
    private long DNI ;
    private Date fechaNacimiento;
    private  String estadoCivil;
    public Empleados(){
    }
    Empleados (int Codigo, String Nombre, int Edad , long DNI, Date FechaNacimiento, String EstadoCivil){
        this.codigo = Codigo;
        this.nombre = Nombre;
        this.edad = Edad;
        this.DNI =DNI;
        this.fechaNacimiento =FechaNacimiento;
        this.estadoCivil = EstadoCivil;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDNI(long DNI) {
        this.DNI = DNI;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getCodigo() {
        return codigo;
    }

    public long getDNI() {
        return DNI;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

}
