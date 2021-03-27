package datos.dentist;

import datos.conexion.Conexion;
import recursos.clases.Ventas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VentasDatos {
    public static List<Ventas> LeerVentas() {
        List<Ventas> ventasList = new ArrayList<Ventas>();
        try {
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();

            String sql = "SELECT TotalAnual, TotalMensual,TotalSemanal FROM Ventas";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Ventas ventas= new Ventas();
                ventas.setTotalAnual(rs.getDouble(1));
                ventas.setTotalMes(rs.getDouble(2));
                ventas.setTotalSemanal(rs.getDouble(3));

                ventasList.add(ventas);

            }
            cn.close();

        } catch (Exception e) {

        }
        return ventasList;


    }
    public static String InsertarVentas(Ventas ventas) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Ventas VALUES(?,?,?) ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDouble(1, ventas.getTotalAnual());
            ps.setDouble(2, ventas.getTotalMes());
            ps.setDouble(3, ventas.getTotalSemanal());


            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error: " + ex.getMessage();
        }
        return null;
    }
    public static String EliminarVentas(Ventas ventas) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Ventas WHERE TotalAnual=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDouble(1, ventas.getTotalAnual());
            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
        return null;
    }
    public static String ActualizarVentas(Ventas ventas) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Ventas SET TotalMensual=?, TotalSemanal=? WHERE TotalAnual=? ";
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setDouble(1, ventas.getTotalMes());
            ps.setDouble(2, ventas.getTotalSemanal());
            ps.setDouble(3,ventas.getTotalAnual());
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
