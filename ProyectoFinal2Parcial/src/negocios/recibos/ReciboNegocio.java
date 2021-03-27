package negocios.recibos;

import datos.dentist.ReciboDatos;
import recursos.clases.Recibo;

import java.util.ArrayList;
import java.util.List;

public class ReciboNegocio {

    public String insertarRecibo (Recibo recibo) throws Exception{
        String respuesta = "Error";
         try{
             if(recibo.getNombre().isEmpty()){
                 throw new Exception("Error nombre no puede estar Vacio");
             }
             respuesta = ReciboDatos.insertarRecibo(recibo);
                if (respuesta==null){
                    respuesta = "Guardado con exito";

                }
         }catch (Exception e){
             respuesta = e.getMessage();
         }
         finally {
             return respuesta;
         }
    }
    public void ActualizarRecibo(Recibo recibo)throws Exception{
        try{
            if (recibo.getNombre().isEmpty()){
                throw new Exception("Error Nombre vacio");
            }
            ReciboDatos.actualizarRecibo(recibo);
        }catch (Exception e ){
           e.printStackTrace();
        }
    }
    public void Eliminar (Recibo recibo ){
        try{
            ReciboDatos.eliminarRecibo(recibo);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Recibo> leer() {
        List<Recibo> listaDeRecibos = new ArrayList<>();
        try {
            listaDeRecibos = ReciboDatos.leerDatos();
        }catch (Exception e){

        }
        return listaDeRecibos;

    }
}
