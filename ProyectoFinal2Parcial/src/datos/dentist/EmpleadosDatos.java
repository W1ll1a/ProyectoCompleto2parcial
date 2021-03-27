package datos.dentist;

import datos.conexion.Conexion;
import recursos.clases.Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmpleadosDatos {
    public static List<Empleados> leerEmpleados(){
        List<Empleados> listaDeEmpleados = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Codigo, Nombre, Edad,DNI,FechaNacimiento ,EstadoCivil FROM Empleados";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Empleados empleado = new Empleados();
                empleado.setCodigo(rs.getInt(1));
                empleado.setNombre(rs.getString(2));
                empleado.setEdad(rs.getInt(3));
                empleado.setDNI(rs.getLong(4));
                empleado.setFechaNacimiento(rs.getDate(5));
                empleado.setEstadoCivil(rs.getString(6));
                listaDeEmpleados.add(empleado);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaDeEmpleados;
    }
    public static String insertarEmpleado (Empleados empleados){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Empleados VALUES (?,?,?,?,?,?)";
            PreparedStatement ps  = cn.prepareStatement(sql);
            ps.setInt(1,empleados.getCodigo() );
            ps.setString(2,empleados.getNombre());
            ps.setInt(3,empleados.getEdad());
            ps.setLong(4, empleados.getDNI());
            ps.setDate(5,new java.sql.Date(empleados.getFechaNacimiento().getTime()));
            ps.setString(6, empleados.getEstadoCivil());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e ){
            return "ERROR " + e.getMessage();
        }
        return null;
    }
    public static String Actualizar (Empleados empleados ){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Empleados SET Nombre = ?,Edad =?, DNI =?,FechaNacimiento = ?, EstadoCivil = ? WHERE Codigo = ?";
            PreparedStatement ps  = cn.prepareStatement(sql);
            ps.setString(1,empleados.getNombre());
            ps.setInt(2,empleados.getEdad());
            ps.setLong(3, empleados.getDNI());
            ps.setDate(4,new java.sql.Date(empleados.getFechaNacimiento().getTime()));
            ps.setString(5, empleados.getEstadoCivil());
            ps.setInt(6,empleados.getCodigo() );
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e ){
            return "ERROR " + e.getMessage();
        }
        return null;
    }

    public static String eliminarEmpleado (Empleados empleados){
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Empleados WHERE Codigo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, empleados.getCodigo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            return "Error :" + e.getMessage();
        }
        return null;
    }
}
