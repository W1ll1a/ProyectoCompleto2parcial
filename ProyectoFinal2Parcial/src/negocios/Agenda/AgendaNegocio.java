package negocios.Agenda;

import datos.dentist.AgendaDatos;
import recursos.clases.Agenda;

import javax.swing.text.EditorKit;
import java.util.ArrayList;
import java.util.List;

public class AgendaNegocio {

    public List<Agenda> leerCitas(){
      List<Agenda> listaCitas = new ArrayList<>();
      try{
            listaCitas = AgendaDatos.leerCitas();
      }catch (Exception e) {
      }
      return listaCitas;
    }
    public String agregarCita(Agenda cita)throws Exception {
        String respuesta = "Error ";
        try {
                if (cita.getPaciente().isEmpty()){
                    throw new Exception("ERROR : El nombre no puede quedar vacio");
                }
                if (cita.getProcedimientServicio().isEmpty()){
                    throw new Exception("Error : Procedimiento vacio");
                }
                if (cita.getFechaCita() == null){
                    throw new Exception("Error : Fecha Vacia");
                }
                respuesta = AgendaDatos.InsertarCita(cita);
                if (respuesta == null){
                    respuesta = "Guardado Exitosamente ";
                }

        }catch (Exception e){
            respuesta = e.getMessage();
            return respuesta;
        }
        return respuesta;
    }
    public void eliminarCita (Agenda cita){
        try {
            AgendaDatos.eliminarCita(cita);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
