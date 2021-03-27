package negocios.Inventario;

import datos.dentist.InventarioDatos;
import recursos.clases.Inventario;

import java.util.ArrayList;
import java.util.List;

public class InventarioNegocios {
    public List<Inventario> leer (){
        List<Inventario> listaProducto = new ArrayList<>();
        try{
            listaProducto = InventarioDatos.leerProductos();
        }catch (Exception e){

        }
        return listaProducto;
    }

    public String insertar (Inventario producto){
        String respuesta = "ERROR ";
        try {
            if (producto.getCodigoProducto()<=0){
                throw new Exception("ERROR : Codigo invalido ");
            }
            if (producto.getNombreProducto().isEmpty()){
                throw new Exception("ERROR : Nombre Vacio");
            }
            if (producto.getCantidadProductos()<0){
                throw new Exception("ERROR, No pueden haber menos de 0 Productos ");
            }

            respuesta = InventarioDatos.insertarProducto(producto);
            if (respuesta == null){
                respuesta ="Guardad Con Exito";
            }
        }catch (Exception e){
            respuesta = e.getMessage();
        }
        finally {
            return respuesta;
        }

    }
    public List<Inventario> Buscar (Inventario inventario)throws Exception{
        List<Inventario > ListaProductos = new ArrayList<>();
        try{
            ListaProductos = InventarioDatos.Buscar(inventario);
        }catch (Exception e){

        }
        return ListaProductos;
    }
    public void eliminar(Inventario producto ){
        try{
            InventarioDatos.eliminarProducto(producto);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
    public void actualizar (Inventario producto )throws Exception{
        try {
            if (producto.getCodigoProducto()<=0){
                throw new Exception("ERROR : Codigo invalido ");
            }
            if (producto.getNombreProducto().isEmpty()){
                throw new Exception("ERROR : Nombre Vacio");
            }
            if (producto.getCantidadProductos()<0){
                throw new Exception("ERROR, No pueden haber menos de 0 Productos ");
            }
            InventarioDatos.actiualizarProducto(producto);

        }catch (Exception e){

        }

    }
}
