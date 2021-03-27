package negocios.Servicio;

import datos.dentist.ServiciosDatos;
import recursos.clases.Servicios;

import java.util.ArrayList;
import java.util.List;

public class ServiciosNegocio {
    public String InsertarServicios( Servicios servicios) throws Exception{

        String respuesta= "ERROR";
        try {
            if (servicios.getNombre().isEmpty()){
                throw new Exception("Error el nombre esta vacio");
            }
            if (servicios.getConsulta()<=0){
                throw new Exception("Error El valor no puede ser menor que 0");
            }
            if (servicios.getMantenimiento()<=0){
                throw new Exception("ERROR El valor no puede ser menor que 0");

            }
            if (servicios.getOperacion()<=0){
                throw new Exception("Error El valor no puede ser menor que 0");
            }
            respuesta= ServiciosDatos.InsertarServicios(servicios);
            if (respuesta==null){
                respuesta="Guardado exitosamente";
            }
        }catch (Exception e){
            respuesta=e.getMessage();
        }
        finally {
            return respuesta;
        }
    }
    public List<Servicios> LeerServicios(){
        List<Servicios>serviciosList=new ArrayList<Servicios>();
        try{
            serviciosList=ServiciosDatos.LeerServicios();
        }catch (Exception e){

        }
        return serviciosList;

    }
    public void EliminarServicios(Servicios servicios){
        try{
            ServiciosDatos.EliminarServicios(servicios);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void ActualizarServicios(Servicios servicios)throws Exception{
        String respuesta= "ERROR";

        try {
            ServiciosDatos.ActualizarServicios(servicios);
            if (servicios.getNombre().isEmpty()){
                throw new Exception("Error el nombre esta vacio");
            }
            if (servicios.getConsulta()<=0){
                throw new Exception("Error El valor no puede ser menor que 0");
            }
            if (servicios.getMantenimiento()<=0){
                throw new Exception("ERROR El valor no puede ser menor que 0");

            }
            if (servicios.getOperacion()<=0){
                throw new Exception("Error El valor no puede ser menor que 0");
            }
            respuesta= ServiciosDatos.InsertarServicios(servicios);
            if (respuesta==null){
                respuesta="Guardado exitosamente";
            }



        }catch (Exception  e){

        }
    }
}
