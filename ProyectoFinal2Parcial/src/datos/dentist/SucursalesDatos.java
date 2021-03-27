package datos.dentist;

import datos.conexion.Conexion;
import recursos.clases.Sucursales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SucursalesDatos {
    public static String InsertarSucursales(Sucursales sucursales) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Sucursales VALUES(?,?,?,?,?) ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, sucursales.getSucursal());
            ps.setString(2, sucursales.getCiudad());
            ps.setString(3, sucursales.getPais());
            ps.setString(4, sucursales.getTipoSucursal());
            ps.setInt(5, sucursales.getIdSucursal());
            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error: " + ex.getMessage();
        }
        return null;
    }

    public static String ActualizarSucursales(Sucursales sucursales) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Sucursales SET  Ciudad=?, Pais=?, TipoSucursal=?, IdSucursal=?  WHERE Sucursal=? ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, sucursales.getCiudad());
            ps.setString(2, sucursales.getPais());
            ps.setString(3, sucursales.getTipoSucursal());
            ps.setInt(4, sucursales.getIdSucursal());
            ps.setInt(5, sucursales.getSucursal());
            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
        return null;
    }

    public static String EliminarSucursales(Sucursales sucursales) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Sucursales WHERE Sucursal =?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, sucursales.getSucursal());
            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
        return null;
    }

    public static List<Sucursales> LeerSucursales() {
        List<Sucursales> sucursalesList = new ArrayList<Sucursales>();
        try {
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();

            String sql = "SELECT Sucursal, Ciudad, Pais, TipoSucursal, IdSucursal FROM Sucursales";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Sucursales sucursales = new Sucursales();

                sucursales.setSucursal(rs.getInt(1));
                sucursales.setCiudad(rs.getString(2));
                sucursales.setPais(rs.getString(3));
                sucursales.setTipoSucursal(rs.getString(4));
                sucursales.setIdSucursal(rs.getInt(5));
                sucursalesList.add(sucursales);
            }
            cn.close();
        } catch (Exception e) {

        }
        return sucursalesList;
    }
}
