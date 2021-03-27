package negocios.MetodoDePago;

import datos.dentist.MetodosDePagoDatos;
import recursos.clases.MetodoDePago;

import java.util.ArrayList;
import java.util.List;

public class MetodoDePagoNegocio {
    public String Insertar(MetodoDePago metodosDePago)throws Exception{
        String respuesta= "ERROR";
        try {
            if (metodosDePago.getNombre().isEmpty()){
                throw new Exception("Error el nombre esta vacio");
            }
            if (metodosDePago.getMetodo().isEmpty()){
                throw new Exception("Error el metodo esta vacio");
            }
            if (metodosDePago.getCantidad()<=0){
                throw new Exception("ERROR introdusca una cantidad valida");

            }
            respuesta= MetodosDePagoDatos.InsertarMetodoDePago(metodosDePago);
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
    public List<MetodoDePago> LeerMetodosDePago(){
        List<MetodoDePago>metodosDePagoList=new ArrayList<>();
        try {
            metodosDePagoList=MetodosDePagoDatos.LeerMetodosDePago();
        }catch (Exception e){

        }
        return  metodosDePagoList;
    }
    public void Actualizar(MetodoDePago metodosDePago)throws Exception{
        try {
            MetodosDePagoDatos.ActualizarMetodosDePago(metodosDePago);
            if (metodosDePago.getNombre().isEmpty()){
                throw new Exception("Error el nombre esta vacio");
            }
            if (metodosDePago.getMetodo().isEmpty()){
                throw new Exception("Error el metodo no puede estar vacio ");
            }
            if (metodosDePago.getCantidad()<=0){
                throw new Exception("ERROR introdusca una cantidad valida");

            }


        }catch (Exception  e){

        }

    }
    public void Eliminar(MetodoDePago metodosDePago){
        try{
            MetodosDePagoDatos.EliminarMetodosDePago(metodosDePago);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
