package datos.dentist;

import datos.conexion.Conexion;
import recursos.clases.Inventario;
import sun.awt.OSInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class InventarioDatos {

    public static String insertarProducto(Inventario productos) {
        try {
            Connection cn  = Conexion.obtenerConexion();
            String sql  = "INSERT INTO Inventario VALUES (?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,productos.getCodigoProducto());
            ps.setString(2,productos.getNombreProducto());
            ps.setDouble(3, productos.getPrecioProducto());
            ps.setInt(4, productos.getCantidadProductos());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            return "Error : " + e.getMessage();
        }
        return null;
    }
    public static List<Inventario>Buscar (Inventario inventario)throws SQLException {
        List<Inventario> listaProductos = new ArrayList<>();
        try{
            Connection cn  = Conexion.obtenerConexion();
            String sql = "SELECT Codigo, Precio, Nombre, Cantidad FROM Inventario WHERE UPPER(Nombre) like ? ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, inventario.getNombreProducto() .toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Inventario producto =new Inventario();
                    producto.setCodigoProducto(rs.getInt(1));
                    producto.setPrecioProducto(rs.getInt(2));
                    producto.setNombreProducto(rs.getString(3));
                    producto.setCantidadProductos(rs.getInt(4));
                    listaProductos.add(producto);
                }while(rs.next());

            }else{
                throw new SQLException("ERROR, no se encontro coincidencia");
            }
            cn.close();
            ps.close();
            rs.close();

        }catch (Exception e){
            throw new SQLException(e.getMessage());

        }
        return listaProductos;
    }
     public static List<Inventario> leerProductos (){
        List<Inventario> productos = new ArrayList<>();
        try {
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Codigo, Nombre, Precio , Cantidad FROM Inventario";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Inventario producto = new Inventario();
                producto.setCodigoProducto(rs.getInt(1));
                producto.setNombreProducto(rs.getString(2));
                producto.setPrecioProducto(rs.getInt(3));
                producto.setCantidadProductos(rs.getInt(4));
                productos.add(producto);
            }
            cn.close();

        }catch (Exception e){
           e.printStackTrace();
        }
        return productos;
     }
     public static String actiualizarProducto(Inventario productos ){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Inventario SET Nombre = ? , Precio = ?, Cantidad = ? WHERE Codigo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,productos.getNombreProducto());
            ps.setDouble(2, productos.getPrecioProducto());
            ps.setInt(3, productos.getCantidadProductos());
            ps.setInt(4,productos.getCodigoProducto());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "ERROR " + e.getMessage();
        }
        return null;
     }
     public static String eliminarProducto (Inventario productos){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Inventario WHERE Codigo = ? ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, productos.getCodigoProducto());
            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e ){
            return  "ERROR " +e .getMessage();
        }
        return null;
     }
}
