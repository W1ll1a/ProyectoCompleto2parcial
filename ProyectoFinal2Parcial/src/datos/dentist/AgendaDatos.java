package datos.dentist;

import datos.conexion.Conexion;
import recursos.clases.Agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AgendaDatos {

public static String InsertarCita( Agenda cita ){
        try{
            Connection cn  = Conexion.obtenerConexion();
            String sql =  "INSERT INTO AgendaCitas VALUES (?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, cita.getPaciente());
            ps.setDate(2,new java.sql.Date(cita.getFechaCita().getTime()));
            ps.setString(3, cita.getProcedimientServicio());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e ){
            e.printStackTrace();
            return "Error " + e.getMessage();
        }
        return null;
}
public static String eliminarCita (Agenda cita ){
    try{
        Connection cn = Conexion.obtenerConexion();
        String sql = "DELETE FROM AgendaCitas WHERE Paciente = ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, cita.getPaciente());
        ps.execute();
        ps.close();
    }catch (Exception e){
        e.printStackTrace();
        return "ERROR " + e.getMessage();
    }
    return null;
}
public static List<Agenda> leerCitas (){
    List<Agenda> listaCitas = new ArrayList<>();
    try{
        Connection cn = Conexion .obtenerConexion();
        Statement st = cn.createStatement();
        String sql = "SELECT Paciente,FechaCita ,ServicioDental FROM AgendaCitas";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
            Agenda cita = new Agenda();
            cita.setPaciente(rs.getString(1));
            cita.setFechaCita(rs.getDate(2));
            cita.setProcedimientServicio(rs.getString(3));
            listaCitas.add(cita);
        }
        cn.close();
    }catch (Exception e){
        e.printStackTrace();
    }
    return listaCitas;
}
}
