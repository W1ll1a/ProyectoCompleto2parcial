package negocios.Empleados;

import datos.dentist.EmpleadosDatos;
import datos.dentist.ReciboDatos;
import recursos.clases.Empleados;
import recursos.clases.Recibo;

import java.util.ArrayList;
import java.util.List;

public class EmpleadosNegocio {
    public  List<Empleados > leer(){
        List <Empleados> listaDeEmpleados = new ArrayList<>();
        try{
            listaDeEmpleados = EmpleadosDatos.leerEmpleados();
        }catch (Exception e){

        }
        return listaDeEmpleados;
    }
    public  String Insertar (Empleados empleados) throws Exception{
        try {
            if (empleados.getNombre().isEmpty()){
                throw new Exception("ERROR : Nombre vacio ");
            }
            if (empleados.getCodigo()<=0){
                throw new Exception("ERROR :  Codigo invalido");
            }
            if (empleados.getEdad()<=0){
                throw new Exception("Error: Edad Invalida" );
            }
            EmpleadosDatos.insertarEmpleado(empleados);
        }catch (Exception e){
            return "Error " + e.getMessage();
        }
        return "Guardado Exitosamente.";
    }
    public void eliminarEmpleado (Empleados empleado){
        try {
            EmpleadosDatos.eliminarEmpleado(empleado);
        }catch (Exception e ){
        }
    }
    public void ActualizarEmpleado(Empleados empleados)throws Exception{
        try{
            if (empleados.getNombre().isEmpty()){
                throw new Exception("Error Nombre vacio");
            }
            EmpleadosDatos.Actualizar(empleados);

        }catch (Exception e ){
            e.printStackTrace();
        }
     }
}
