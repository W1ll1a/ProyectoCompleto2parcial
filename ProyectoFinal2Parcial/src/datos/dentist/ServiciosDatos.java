package datos.dentist;

import datos.conexion.Conexion;
import recursos.clases.Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiciosDatos {
    public static List<Servicios> LeerServicios() {
        List<Servicios> serviciosList = new ArrayList<Servicios>();
        try {
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();

            String sql = "SELECT Nombre, Consulta, Mantenimiento, Operacion FROM Servicios";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Servicios servicios=new Servicios();
                servicios.setNombre(rs.getString(1));
                servicios.setMantenimiento(rs.getDouble(2));
                servicios.setConsulta(rs.getDouble(3));
                servicios.setOperacion(rs.getDouble(4));

                serviciosList.add(servicios);

            }
            cn.close();

        } catch (Exception e) {

        }
        return serviciosList;


    }
    public static String InsertarServicios(Servicios servicios) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Servicios VALUES(?,?,?,?) ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, servicios.getNombre());
            ps.setDouble(2, servicios.getConsulta());
            ps.setDouble(3, servicios.getMantenimiento());
            ps.setDouble(4, servicios.getOperacion());


            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error: " + ex.getMessage();
        }
        return null;
    }
    public static String EliminarServicios(Servicios servicios) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Servicios WHERE Nombre =?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, servicios.getNombre());
            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
        return null;
    }
    public static String ActualizarServicios(Servicios servicios) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Servicios SET Consulta=?, Mantenimiento=?,  Operacion=? WHERE Nombre=? ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(4,servicios.getNombre());
            ps.setDouble(1, servicios.getConsulta());
            ps.setDouble(2, servicios.getMantenimiento());
            ps.setDouble(3, servicios.getOperacion());
            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
        return null;
    }
}
