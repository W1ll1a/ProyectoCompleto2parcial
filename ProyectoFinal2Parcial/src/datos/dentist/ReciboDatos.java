package datos.dentist;

import datos.conexion.Conexion;
import recursos.clases.Recibo;
import sun.security.mscapi.CRSACipher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReciboDatos {
    public static String insertarRecibo (Recibo recibo){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Recibo VALUES (?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1 ,recibo.getNombre());
            ps.setDouble(2, recibo.getPrecioProcedimiento());
            ps.setDouble(3, recibo.getPrecioImpuesto());
            ps.setDouble(4, recibo.getTotalPagar());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "ERROR "+ e.getMessage();
        }
        return null;
    }
    public static String eliminarRecibo (Recibo recibo) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Recibo WHERE Nombre = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, recibo.getNombre());
            ps.execute();
            ps.close();
            cn.close();

        } catch (Exception e) {
          return " Error "+e.getMessage();
        }
        return null;
    }
        public static String actualizarRecibo (Recibo recibo ){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Recibo SET Procedimiento = ? , Impuesto = ?, TotalPagar = ? WHERE Nombre =?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDouble(1 , recibo.getPrecioProcedimiento());
            ps.setDouble(2, recibo.getPrecioImpuesto());
            ps.setDouble(3, recibo.getTotalPagar());
            ps.setString(4, recibo.getNombre());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            return "Error" + e.getMessage();
        }
        return null;
    }

    public static List<Recibo> leerDatos() {
        List<Recibo> listaDeRecibosCompletos = new ArrayList<>();
        try {
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn .createStatement();
            String sql = "SELECT Nombre, Procedimiento, Impuesto , TotalPagar FROM Recibo";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Recibo recibo = new Recibo();
                recibo.setNombre(rs.getString(1));
                recibo.setPrecioProcedimiento(rs.getDouble(2));
                recibo.setPrecioImpuesto(rs.getDouble(3));
                recibo.setTotalPagar(rs.getDouble(4));
                listaDeRecibosCompletos.add(recibo);
            }
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaDeRecibosCompletos;
    }
}
