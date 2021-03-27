package negocios.Gastos;

import datos.dentist.GastosDatos;
import recursos.clases.Gastos;

import java.util.ArrayList;
import java.util.List;

public class GastosNegocio {
    public List<Gastos> LeerGastos(){
        List<Gastos>gastosList=new ArrayList<Gastos>();
        try {
            gastosList=GastosDatos.LeerGastos();
        }catch (Exception e){

        }
        return gastosList;
    }

    public String Insertar(Gastos gastos) throws Exception{

        String respuesta= "ERROR";
        try {
            if (gastos.getPorLocal()<=0){
                throw new Exception("Error el dato no puede ser menor a 0");
            }
            if (gastos.getImpuestos()<=0){
                throw new Exception("Error el dato no puede ser menor a 0");
            }
            if (gastos.getMantenimientoLocal()<=0){
                throw new Exception("Error el dato no puede ser menor a 0");
            }
            if (gastos.getPersonal()<=0){
                throw new Exception("Error el dato no puede ser menor a 0");
            }


            respuesta= GastosDatos.InsertarGastos(gastos);
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
    public void EliminarGastos(Gastos gastos) {
        try {
            GastosDatos.EliminarGastos(gastos);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void ActualizarGastos(Gastos gastos)throws Exception{

        try {
            if (gastos.getPorLocal()<=0){
                throw new Exception("ERROR el dato es menor que 0 ");
            }
            if (gastos.getImpuestos()<=0){
                throw new Exception("Error el dato es menor que 0 ");
            }
            if (gastos.getMantenimientoLocal()<=0){
                throw new Exception("ERROR el dato es menor que 0 ");

            }
            if (gastos.getPersonal()<=0){
                throw new Exception("ERROR el dato es menor que 0 ");

            }
            GastosDatos.ActualizarGastos(gastos);

        }catch (Exception  e){
            e.printStackTrace();
        }
    }

}
