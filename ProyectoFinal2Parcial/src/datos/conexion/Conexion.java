package datos.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String USUARIO = "sa";
    private static final String CLAVE = "ujcvlogin";
    public static Connection obtenerConexion(){
        try{
            String URL = "jdbc:sqlserver://192.168.56.1:1433;dataBaseName=ClinicaDental;";
            Connection cn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            return cn;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
