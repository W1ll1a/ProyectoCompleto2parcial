package negocios.pacientes;

import datos.dentist.DentistDatos;
import recursos.clases.Paciente;
import java.util.ArrayList;
import java.util.List;

public class PacienteNegocio {
    public List<Paciente> leer(){
        List<Paciente> listaPaciente = new ArrayList<>();
        try{
            listaPaciente = DentistDatos.leerPacientes();

        }catch (Exception e ){

        }
        return listaPaciente;
    }

    public String Insertar (Paciente paciente)throws Exception{
        String Respuesta = "Error";
        try{
            if (paciente.getNombre().isEmpty()){
                throw new Exception("Error  : Nombre no puede quedar vacio");
            }
            if (paciente.getEdad()<=0){
                throw new Exception("Error : Debe ingresar edad valida");
            }
            if (paciente.getCodigo()<=0|| paciente.getCodigo()>999999){
                throw new Exception("Error : Ingrese un codigo Valido");
            }
            Respuesta = DentistDatos.Insertarpaciente(paciente);
            if (Respuesta == null){
                Respuesta = "Guardado Exitosamente";
            }

        }catch (Exception e){
            Respuesta= e.getMessage();
        }
        finally {
            return Respuesta;
        }
    }
    public void Eliminar (Paciente paciente){
        try {
            DentistDatos.eliminaPacientes(paciente);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
    public void actualizar (Paciente paciente)throws Exception{
        try {
            if (paciente.getNombre().isEmpty()){
                throw new Exception("Error : Nombre vacio");
            }
            if (paciente.getEdad()<=0){
                throw new Exception("Error : Debe ingresar edad valida");
            }
            if (paciente.getCodigo()<=0|| paciente.getCodigo()>999999){
                throw new Exception("Error : Ingrese un codigo Valido");
            }
            DentistDatos.ActualizarPaciente(paciente);

        }catch (Exception e ){
            e.printStackTrace();
        }
    }
    public List<Paciente> Buscar (Paciente paciente){
        List<Paciente> listaPacientes =new ArrayList<>();
        try{
            listaPacientes = DentistDatos.Buscar(paciente);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return listaPacientes;
    }

}
