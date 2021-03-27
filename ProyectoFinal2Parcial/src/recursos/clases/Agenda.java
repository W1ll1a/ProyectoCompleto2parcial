package recursos.clases;

import java.util.Date;

public class Agenda {
    private String paciente;
    private Date fechaCita;
    private String procedimientServicio;

    public Agenda(){

    }
    Agenda (String paciente,Date fecha,String Servico){
        this.fechaCita =fecha;
        this.paciente = paciente;
        this.procedimientServicio = Servico;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public void setProcedimientServicio(String procedimientServicio) {
        this.procedimientServicio = procedimientServicio;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getProcedimientServicio() {
        return procedimientServicio;
    }

}
