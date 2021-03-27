package recursos.clases;

public class Sucursales {
    private int Sucursal;
    private String Ciudad;
    private String pais;
    private String TipoSucursal;
    private int IdSucursal;
    public Sucursales(){

    }
    public Sucursales (int  sucursal, String Ciudad, String pais, String TipoSucursal, int IdSucursal){
        this.Sucursal= sucursal;
        this.Ciudad= Ciudad;
        this.pais= pais;
        this.TipoSucursal= TipoSucursal;
        this.IdSucursal= IdSucursal;

    }

    public int getIdSucursal() {
        return IdSucursal;
    }

    public int getSucursal() {
        return Sucursal;
    }

    public String getCiudad() {
        return Ciudad;
    }
    public String getPais(){
        return pais;

    }

    public String getTipoSucursal() {
        return TipoSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        IdSucursal = idSucursal;
    }

    public void setSucursal(int  sucursal) {
        Sucursal = sucursal;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setTipoSucursal(String tipoSucursal) {
        TipoSucursal = tipoSucursal;
    }
}
