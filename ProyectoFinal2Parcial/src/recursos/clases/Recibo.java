package recursos.clases;

public class Recibo {
    private String nombre;
    private double precioProcedimiento;
    private double precioImpuesto;
    private double totalPagar;
    public Recibo(){

    }
    Recibo(String nombre, double precioProcedimiento, double precioImpuesto, double totalPagar){
        this.nombre = nombre;
        this.precioImpuesto= precioImpuesto;
        this.precioProcedimiento = precioProcedimiento;
        this.totalPagar =totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioImpuesto(double precioImpuesto) {
        this.precioImpuesto = precioImpuesto;
    }

    public void setPrecioProcedimiento(double precioProcedimiento) {
        this.precioProcedimiento = precioProcedimiento;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioImpuesto() {
        return precioImpuesto;
    }

    public double getPrecioProcedimiento() {
        return precioProcedimiento;
    }
}
