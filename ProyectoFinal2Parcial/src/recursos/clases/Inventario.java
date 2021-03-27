package recursos.clases;

public class Inventario {
    private int codigoProducto ;
    private String nombreProducto;
    private double precioProducto;
    private int cantidadProductos;

    public Inventario(){

    }
    Inventario(int codigo, String nombre , double precio, int cantidad){
        this.cantidadProductos = cantidad;
        this.codigoProducto = codigo;
        this.nombreProducto = nombre ;
        this.precioProducto = precio;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }
}
