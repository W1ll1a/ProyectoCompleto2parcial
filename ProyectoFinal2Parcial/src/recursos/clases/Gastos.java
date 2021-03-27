package recursos.clases;

public class Gastos {
    private double Impuestos;
    private double PorLocal;
    private double MantenimientoLocal;
    private double Personal;
    public Gastos(){

    }
    public Gastos (double impuestos, double porLocal, double mantenimientoLocal, double personal){
        this.Impuestos = impuestos;
        this.MantenimientoLocal=mantenimientoLocal;
        this.Personal=personal;
        this.PorLocal=porLocal;

    }


    public double getImpuestos() {
        return Impuestos;
    }

    public double getMantenimientoLocal() {
        return MantenimientoLocal;
    }

    public double getPersonal() {
        return Personal;
    }

    public double getPorLocal() {
        return PorLocal;
    }

    public void setImpuestos(double impuestos) {
        Impuestos = impuestos;
    }

    public void setMantenimientoLocal(double mantenimientoLocal) {
        MantenimientoLocal = mantenimientoLocal;
    }

    public void setPersonal(double personal) {
        Personal = personal;
    }

    public void setPorLocal(double porLocal) {
        PorLocal = porLocal;
    }
}
