package datos.dentist;

import datos.conexion.Conexion;
import recursos.clases.MetodoDePago;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MetodosDePagoDatos {
    public static List<MetodoDePago> LeerMetodosDePago() {
        List<MetodoDePago> metodosDePagoList = new ArrayList<MetodoDePago>();
        try {

            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();

            String sql = "SELECT Nombre, MetodoDePago, Cantidad FROM MetodoDePago";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                MetodoDePago metodosDePago = new MetodoDePago();

                metodosDePago.setNombre(rs.getString(1));
                metodosDePago.setMetodo(rs.getString(2));
                metodosDePago.setCantidad(rs.getDouble(3));
                metodosDePagoList.add(metodosDePago);
            }
            cn.close();

        } catch (Exception e) {

        }
        return metodosDePagoList;


    }
    public static String InsertarMetodoDePago(MetodoDePago metodosDePago) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO MetodoDePago VALUES(?,?,?) ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, metodosDePago.getNombre());
            ps.setString(2, metodosDePago.getMetodo());
            ps.setDouble(3, metodosDePago.getCantidad());


            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error: " + ex.getMessage();
        }
        return null;
    }
    public static String EliminarMetodosDePago(MetodoDePago metodosDePago){
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM MetodoDePago WHERE Nombre =?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, metodosDePago.getNombre());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "error: "+ e.getMessage();
        }
        return null;
    }
    public static String ActualizarMetodosDePago(MetodoDePago metodosDePago){
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE MetodoDePago SET MetodoDePago=?, Cantidad=? WHERE Nombre=? ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(3,metodosDePago.getNombre());
            ps.setString(1, metodosDePago.getMetodo());
            ps.setDouble(2, metodosDePago.getCantidad());
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
