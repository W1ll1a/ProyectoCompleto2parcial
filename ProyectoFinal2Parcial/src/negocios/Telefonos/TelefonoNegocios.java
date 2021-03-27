package negocios.Telefonos;

import datos.dentist.DentistDatos;
import datos.dentist.ReciboDatos;
import datos.dentist.TelefonoDatos;
import recursos.clases.Paciente;
import recursos.clases.Recibo;
import recursos.clases.Telefono;

import java.util.ArrayList;
import java.util.List;


public class TelefonoNegocios {
    public String insertartelefono (Telefono telefono) throws Exception{
        String respuesta = "Error";
        try{
            if(telefono.getNombreCliente().isEmpty()){
                throw new Exception("Error nombre no puede estar Vacio");
            }
            respuesta = TelefonoDatos.insertarTelefonos(telefono);
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
    public void Eliminar (Telefono telefonos ){
        try{
            TelefonoDatos.eliminarTelefono(telefonos);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Telefono> leer() {
        List<Telefono> ListaTelefonos  = new ArrayList<>();
        try {
            ListaTelefonos = TelefonoDatos.leertelefonos();
        }catch (Exception e){

        }
        return ListaTelefonos;

    }
    public List<Telefono> Buscar (Telefono telefono){
        List<Telefono> listaTelefonos=new ArrayList<>();
        try{
            listaTelefonos = TelefonoDatos.Buscar(telefono);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return listaTelefonos;
    }
}
