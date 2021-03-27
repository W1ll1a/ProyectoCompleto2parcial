package datos.dentist;

import datos.conexion.Conexion;
import recursos.clases.Paciente;
import recursos.clases.Recibo;
import recursos.clases.Telefono;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefonoDatos {
    public static List<Telefono> leertelefonos() {
        List<Telefono> listaTelefonos = new ArrayList<>();
        try {
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn .createStatement();
            String sql = "SELECT NombrePaciente, NumeroTelefono, CompaniaTelefonica FROM Telefonos";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Telefono telefono = new Telefono();
                telefono.setNombreCliente(rs.getString(1));
                telefono.setNumeroTelefono(rs.getLong(2));
                telefono.setCompaniaTelefonica(rs.getString(3));
                listaTelefonos.add(telefono);
            }
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaTelefonos;
    }
    public static String eliminarTelefono (Telefono telefono) {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Telefonos WHERE NombrePaciente = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, telefono.getNombreCliente());
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            return " Error "+e.getMessage();
        }
        return null;
    }
    public static List<Telefono> Buscar (Telefono telefono) throws SQLException {
        List<Telefono> listatelefono = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT NombrePaciente,NumeroTelefono,CompaniaTelefonica FROM Telefonos WHERE UPPER (NombrePaciente) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, telefono.getNombreCliente().toUpperCase() + "%");
            ResultSet rs  = ps.executeQuery();
            if (rs.next()){
                do {
                    Telefono objetoTelefono = new Telefono();
                    objetoTelefono.setNombreCliente(rs.getString(1));
                    objetoTelefono.setNumeroTelefono(rs.getLong(2));
                    objetoTelefono.setCompaniaTelefonica(rs.getString(3));
                    listatelefono.add(objetoTelefono);
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
        return listatelefono;

    }
    public static String insertarTelefonos (Telefono telefono){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Telefonos VALUES (?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1 ,telefono.getNombreCliente());
            ps.setLong(2, telefono.getNumeroTelefono());
            ps.setString(3, telefono.getCompaniaTelefonica());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "ERROR "+ e.getMessage();
        }
        return null;
    }
}
