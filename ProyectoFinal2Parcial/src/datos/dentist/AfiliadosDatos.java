package datos.dentist;

import datos.conexion.Conexion;
import recursos.clases.Afiliados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AfiliadosDatos {
    public static List<Afiliados> LeerAfiliados() {
        List<Afiliados> afiliadosList = new ArrayList<Afiliados>();
        try {
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();

            String sql = "SELECT Nombre, Edad, Contribucion FROM Afiliados";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Afiliados afiliados = new Afiliados();

                afiliados.setNombre(rs.getString(1));
                afiliados.setEdad(rs.getInt(2));
                afiliados.setContribucion(rs.getDouble(3));
                afiliadosList.add(afiliados);

            }
            cn.close();

        } catch (Exception e) {

        }
        return afiliadosList;


    }
    public static String InsertarAfiliados(Afiliados afiliados) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Afiliados VALUES(?,?,?) ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, afiliados.getNombre());
            ps.setInt(2, afiliados.getEdad());
            ps.setDouble(3, afiliados.getContribucion());


            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error: " + ex.getMessage();
        }
        return null;
    }
    public static String EliminarAfiliados(Afiliados afiliados) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Afiliados WHERE Nombre =?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, afiliados.getNombre());
            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
        return null;
    }
    public static String ActualizarAfiliados(Afiliados afiliados) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Afiliados SET Edad=?, Contribucion=? WHERE Nombre=? ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(3,afiliados.getNombre());
            ps.setDouble(1, afiliados.getEdad());
            ps.setDouble(2, afiliados.getContribucion());
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
