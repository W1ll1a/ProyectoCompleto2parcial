package datos.dentist;

import com.sun.javafx.binding.StringFormatter;
import datos.conexion.Conexion;
import recursos.clases.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DentistDatos {
    public static List<Paciente> leerPacientes() {
       List<Paciente> listaPaciente = new ArrayList<>();
        try {
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Nombre,Edad,Codigo,FechaNacimiento,DNI FROM Paciente";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Paciente paciente = new Paciente();
                paciente.setNombre(rs.getString(1));
                paciente.setEdad(rs.getInt(2));
                paciente.setCodigo(rs.getInt(3));
                paciente.setFechaNacimiento(rs.getDate(4));
                paciente.setDNI(rs.getLong(5));
                listaPaciente.add(paciente);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPaciente;
    }

    public static String Insertarpaciente(Paciente paciente ){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql= "INSERT INTO Paciente VALUES (?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,paciente.getCodigo());
            ps.setString(2,paciente.getNombre());
            ps.setInt(3,paciente.getEdad());
            ps.setDate(4,new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            ps.setLong(5, paciente.getDNI());
            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e ){
            e.printStackTrace();
            return "ERROR : " + e.getMessage();
        }
        return null;
    }
    public static String ActualizarPaciente(Paciente paciente){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql= "UPDATE Paciente SET Nombre = ?, Edad = ? ,  DNI = ? ,FechaNacimiento =? WHERE Codigo = ? ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,paciente.getNombre());
            ps.setInt(2,paciente.getEdad());
            ps.setLong(3, paciente.getDNI());
            ps.setDate(4,new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            ps.setInt(5,paciente.getCodigo());
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "ERROR : "+ e.getMessage();
        }
     return null;
    }
    public static String eliminaPacientes (Paciente paciente){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Paciente WHERE Codigo = ? ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, paciente.getCodigo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e ){
            e.printStackTrace();
            return "Error : " + e.getMessage();
        }
        return null;
    }
    public static List<Paciente> Buscar (Paciente paciente) throws SQLException {
        List<Paciente> pacienteslistas = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT Nombre, Edad, Codigo, FechaNacimiento, DNI FROM Paciente WHERE UPPER (Nombre) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, paciente.getNombre().toUpperCase() + "%");
            ResultSet rs  = ps.executeQuery();
            if (rs.next()){
                do {
                    Paciente objetoPaciente = new Paciente();
                    objetoPaciente.setNombre(rs.getString(1));
                    objetoPaciente.setEdad(rs.getInt(2));
                    objetoPaciente.setCodigo(rs.getInt(3));
                    objetoPaciente.setFechaNacimiento(rs.getDate(4));
                    objetoPaciente.setDNI(rs.getLong(5));
                    pacienteslistas.add(objetoPaciente);
                }while (rs.next());
            }else {
                throw  new SQLException("ERRO no se encontro coincidencia");
            }
            cn.close();
            ps.close();
            rs.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return pacienteslistas;

    }


}
