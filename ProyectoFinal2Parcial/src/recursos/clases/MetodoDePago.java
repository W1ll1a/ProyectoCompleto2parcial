package recursos.clases;

public class MetodoDePago {
    private String Metodo;
    private String Nombre;
    private double Cantidad;
    public MetodoDePago(){

    }
    public MetodoDePago(String metodo, String nombre, double cantidad){
        this.Cantidad=  cantidad;
        this.Nombre=    nombre;
        this.Metodo=    metodo;
    }


    public String getNombre(){
        return Nombre;
    }
    public String getMetodo(){
        return Metodo;
    }
    public double getCantidad(){
        return Cantidad;

    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setMetodo(String metodo) {
        Metodo = metodo;
    }

    public void setCantidad(double cantidad) {
        Cantidad = cantidad;
    }
}
