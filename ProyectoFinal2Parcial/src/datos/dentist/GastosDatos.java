package datos.dentist;

import datos.conexion.Conexion;
import recursos.clases.Gastos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GastosDatos {
    public static List<Gastos> LeerGastos() {
        List<Gastos> gastosList = new ArrayList<Gastos>();
        try {
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();

            String sql = "SELECT PorLocal,Impuesto, Mantenimiento,Personal FROM Gastos";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Gastos gastos = new Gastos();

                gastos.setPorLocal(rs.getDouble(1));
                gastos.setImpuestos(rs.getDouble(2));
                gastos.setMantenimientoLocal(rs.getDouble(3));
                gastos.setPersonal(rs.getDouble(4));
                gastosList.add(gastos);

            }
            cn.close();

        } catch (Exception e) {

        }
        return gastosList;


    }
    public static String InsertarGastos(Gastos gastos) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Gastos VALUES(?,?,?,?) ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDouble(1, gastos.getPorLocal());
            ps.setDouble(2, gastos.getImpuestos());
            ps.setDouble(3, gastos.getMantenimientoLocal());
            ps.setDouble(4, gastos.getPersonal());

            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error: " + ex.getMessage();
        }
        return null;
    }
    public static String EliminarGastos(Gastos gastos) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Gastos WHERE PorLocal =?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDouble(1, gastos.getPorLocal());
            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
        return null;
    }
    public static String ActualizarGastos(Gastos gastos) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Gastos SET  Impuesto=?, Mantenimiento=?, Personal=? WHERE PorLocal=? ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDouble(1, gastos.getImpuestos());
            ps.setDouble(2, gastos.getMantenimientoLocal());
            ps.setDouble(3, gastos.getPersonal());
            ps.setDouble(4, gastos.getPorLocal());
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
