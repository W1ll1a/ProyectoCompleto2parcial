package recursos.clases;

public class Telefono {
    private long numeroTelefono ;
    private String nombreCliente;
    private String companiaTelefonica;

    public Telefono(){

    }
    Telefono(long numero , String nombreCliente , String companiaTelefonica){
        this.numeroTelefono = numero;
        this.nombreCliente = nombreCliente;
        this.companiaTelefonica = companiaTelefonica;

    }

    public void setCompaniaTelefonica(String companiaTelefonica) {
        this.companiaTelefonica = companiaTelefonica;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setNumeroTelefono(long numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public long getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCompaniaTelefonica() {
        return companiaTelefonica;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

}
