package negocios.Afiliados;

import datos.dentist.AfiliadosDatos;
import recursos.clases.Afiliados;

import java.util.ArrayList;
import java.util.List;

public class AfiliadosNegocio {
    public String Insertar(Afiliados afiliados) throws Exception{

        String respuesta= "ERROR";
        try {
            if (afiliados.getNombre().isEmpty()){
                throw new Exception("Error el nombre esta vacio");
            }
            if (afiliados.getEdad()<=0){
                throw new Exception("Error Introdusca una edad valida");
            }
            if (afiliados.getContribucion()<=0){
                throw new Exception("ERROR introdusca una contribucion valida");

            }
            respuesta= AfiliadosDatos.InsertarAfiliados(afiliados);
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
    public List<Afiliados> LeerAfiliados(){
        List<Afiliados>afiliadosList=new ArrayList<Afiliados>();
        try{
            afiliadosList=AfiliadosDatos.LeerAfiliados();
        }catch (Exception e){

        }
        return afiliadosList;

    }
    public void Eliminar(Afiliados afiliados){
        try{
            AfiliadosDatos.EliminarAfiliados(afiliados);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void Actualizar(Afiliados afiliados)throws Exception{

        try {
            AfiliadosDatos.ActualizarAfiliados(afiliados);
            if (afiliados.getNombre().isEmpty()){
                throw new Exception("Error el nombre esta vacio");
            }
            if (afiliados.getEdad()<=0){
                throw new Exception("Error Introdusca una edad valida");
            }
            if (afiliados.getContribucion()<=0){
                throw new Exception("ERROR introdusca una contribucion valida");

            }


        }catch (Exception  e){

        }
    }

}
