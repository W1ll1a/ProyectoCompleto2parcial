package recursos.clases;

public class Afiliados {
    private String Nombre;
    private int Edad;
    private double Contribucion;


    public Afiliados(String nombre, double contribucion,int edad){
        this.Contribucion= contribucion;
        this.Nombre=  nombre;
        this.Edad= edad;


    }


    public Afiliados() {

    }

    public int getEdad() {
        return Edad;
    }

    public String getNombre(){
        return Nombre;

    }


    public double getContribucion() {
        return Contribucion;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setContribucion(double contribucion) {
        Contribucion = contribucion;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
}
