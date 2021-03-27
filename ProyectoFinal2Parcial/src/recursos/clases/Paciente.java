package recursos.clases;

import java.util.Date;

public class Paciente {
     private String nombre;
     private int Codigo;
     private int Edad;
     private long DNI ;
     private Date fechaNacimiento;

     public Paciente(){

     }
     Paciente(String nombre, int codigo,int edad, Date fechaNacimiento ,long DNI){
         this.Codigo=codigo;
         this.DNI = DNI;
         this.nombre = nombre;
         this.fechaNacimiento =fechaNacimiento;
         this.Edad = edad;
     }

    public void setDNI(long DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return Codigo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad() {
        return Edad;
    }

}
