package negocios.Sucursales;

import datos.dentist.SucursalesDatos;
import recursos.clases.Sucursales;

import java.util.ArrayList;
import java.util.List;

public class SucursalesNegocio {
    public String Insertar(Sucursales sucursales) throws Exception {

        String respuesta = "ERROR";
        try {
            if (sucursales.getSucursal()<=0) {
                throw new Exception("Error el nombre esta vacio");
            }
            if (sucursales.getCiudad().isEmpty()) {
                throw new Exception("Error el nombre esta vacio");
            }
            if (sucursales.getPais().isEmpty()) {
                throw new Exception("Error el nombre esta vacio");
            }
            if (sucursales.getTipoSucursal().isEmpty()) {
                throw new Exception("Error el dato esta vacio");
            }
            if (sucursales.getIdSucursal() <= 0) {
                throw new Exception("Error Introdusca una id valida");
            }

            respuesta = SucursalesDatos.InsertarSucursales(sucursales);
            if (respuesta == null) {
                respuesta = "Guardado exitosamente";
            }
        } catch (Exception e) {
            respuesta = e.getMessage();
        } finally {
            return respuesta;
        }


    }

    public List<Sucursales> LeerSucursales() {
        List<Sucursales> sucursalesList = new ArrayList<Sucursales>();
        try {
            sucursalesList = SucursalesDatos.LeerSucursales();
        } catch (Exception e) {

        }
        return sucursalesList;


    }

    public void Eliminar(Sucursales sucursales) {
        try {
            SucursalesDatos.EliminarSucursales(sucursales);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Actualizar(Sucursales sucursales) throws Exception {

        try {
            SucursalesDatos.ActualizarSucursales(sucursales);


            if (sucursales.getSucursal()<=0){
                throw new Exception("Error el nombre esta vacio");
            }
            if (sucursales.getCiudad().isEmpty()) {
                throw new Exception("Error el nombre esta vacio");
            }
            if (sucursales.getPais().isEmpty()) {
                throw new Exception("Error el nombre esta vacio");
            }
            if (sucursales.getTipoSucursal().isEmpty()) {
                throw new Exception("Error el nombre esta vacio");
            }

            if (sucursales.getIdSucursal() <= 0) {
                throw new Exception("Error Introdusca una id valida");
            }



        }catch (Exception e){

        }
    }
}
