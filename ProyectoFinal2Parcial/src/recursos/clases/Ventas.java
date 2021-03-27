package recursos.clases;

public class Ventas {
    private double TotalMes;
    private double TotalSemanal;
    private double TotalAnual;


    public Ventas (double totalMes, double totalSemanal, double totalAnual){
        this.TotalAnual= totalAnual;
        this.TotalMes=totalMes;
        this.TotalSemanal=totalSemanal;
    }
    public Ventas(){

    }

    public double getTotalAnual() {
        return TotalAnual;
    }

    public double getTotalMes() {
        return TotalMes;
    }

    public double getTotalSemanal() {
        return TotalSemanal;
    }

    public void setTotalAnual(double totalAnual) {
        TotalAnual = totalAnual;
    }

    public void setTotalMes(double totalMes) {
        TotalMes = totalMes;
    }

    public void setTotalSemanal(double totalSemanal) {
        TotalSemanal = totalSemanal;
    }
}
