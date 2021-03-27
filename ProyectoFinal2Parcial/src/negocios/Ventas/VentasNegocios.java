package negocios.Ventas;

import datos.dentist.VentasDatos;
import recursos.clases.Ventas;

import java.util.ArrayList;
import java.util.List;

public class VentasNegocios {
    public List<Ventas> LeerVentas(){
        List<Ventas>ventasList=new ArrayList<Ventas>();
        try {
            ventasList= VentasDatos.LeerVentas();
        }catch (Exception e){

        }
        return ventasList;
    }

    public String Insertar(Ventas ventas) throws Exception{

        String respuesta= "ERROR";
        try {
            if (ventas.getTotalAnual()<=0){
                throw new Exception("Error el dato no puede ser menor a 0");
            }
            if (ventas.getTotalMes()<=0){
                throw new Exception("Error el dato no puede ser menor a 0");
            }
            if (ventas.getTotalSemanal()<=0){
                throw new Exception("Error el dato no puede ser menor a 0");
            }



            respuesta= VentasDatos.InsertarVentas(ventas);
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
    public void EliminarVentas(Ventas ventas) {
        try {

            VentasDatos.EliminarVentas(ventas);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void ActualizarVentas(Ventas ventas)throws  Exception{
        try {
            VentasDatos.ActualizarVentas(ventas);
            if (ventas.getTotalAnual()<=0){
                throw new Exception("Error El dato no puede ser menor que 0");
            }

            if (ventas.getTotalMes()<=0){
                throw new Exception("ERROR El dato no puede ser menor que 0");

            }
            if (ventas.getTotalSemanal()<=0){
                throw new Exception("Error El dato no puede ser menor que 0");
            }
        }catch (Exception e){

        }
    }




}
