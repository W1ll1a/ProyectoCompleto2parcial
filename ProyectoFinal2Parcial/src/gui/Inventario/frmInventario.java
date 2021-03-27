package gui.Inventario;

import gui.Pacientes.frmPacientes;
import negocios.Inventario.InventarioNegocios;
import recursos.clases.Inventario;

import javax.crypto.spec.IvParameterSpec;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmInventario {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JPanel jpaSuperior;
    private JPanel jpaInferior;
    private JButton btnRegistrar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JLabel lblCodigo;
    private JLabel lblNombre;
    private JLabel lblPrecio;
    private JLabel lblCantidad;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JScrollPane scrlTableProductos;
    private JTable tblProductos;
    private JButton btnBuscar;
    DefaultTableModel modeloInventario = new DefaultTableModel();

    public frmInventario() {
        iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Inventario producto = new Inventario();
                    producto.setCodigoProducto(Integer.parseInt(txtCodigo.getText()));
                    producto.setNombreProducto(txtNombre.getText());
                    producto.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
                    producto.setCantidadProductos(Integer.parseInt(txtCantidad.getText()));
                    new InventarioNegocios().insertar(producto);
                    JOptionPane.showMessageDialog(null, "Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "No se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Inventario producto = new Inventario();
                    producto.setCodigoProducto(Integer.parseInt(txtCodigo.getText()));
                    producto.setNombreProducto(txtNombre.getText());
                    producto.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
                    producto.setCantidadProductos(Integer.parseInt(txtCantidad.getText()));
                    new InventarioNegocios().eliminar(producto);
                    leerDatos();
                }catch (Exception ex){

                }
            }
        });
        tblProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada =tblProductos.getSelectedRow();
                txtCodigo.setText(modeloInventario.getValueAt(filaSeleccionada,0).toString());
                txtNombre.setText(modeloInventario.getValueAt(filaSeleccionada,1).toString());
                txtPrecio.setText(modeloInventario.getValueAt(filaSeleccionada,2).toString());
                txtCantidad.setText(modeloInventario.getValueAt(filaSeleccionada,3).toString());
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Inventario producto  = new Inventario();
                    producto.setCodigoProducto(Integer.parseInt(txtCodigo.getText()));
                    producto.setNombreProducto(txtNombre.getText());
                    producto.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
                    producto.setCantidadProductos(Integer.parseInt(txtCantidad.getText()));
                    new InventarioNegocios().actualizar(producto);
                    JOptionPane.showMessageDialog(null ,"Actualizado " , "Exito " , JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null ,"No se pudo Actualizar " , "Error " , JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                        Inventario productos  = new Inventario();
                        productos.setNombreProducto(txtNombre.getText());
                        List<Inventario> listaProductos = new InventarioNegocios().Buscar(productos);
                        modeloInventario.setRowCount(0);
                        for (Inventario producto : listaProductos){
                            Object[] Registro = {producto.getCodigoProducto(),producto.getNombreProducto(),producto.getPrecioProducto(),producto.getCantidadProductos()};
                            modeloInventario.addRow(Registro);
                        }
                        tblProductos.setModel(modeloInventario);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR" , JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void iniciar() {
        modeloInventario =(DefaultTableModel) tblProductos.getModel();
        modeloInventario .addColumn("Codigo del Producto");
        modeloInventario.addColumn("Producto");
        modeloInventario.addColumn("Precio lps.");
        modeloInventario.addColumn("Cantidad en almacen");
        leerDatos();

    }

    private void leerDatos() {
        try{
            List<Inventario> listaDeProductos = new InventarioNegocios().leer();
            modeloInventario.setRowCount(0);
            for(Inventario productos : listaDeProductos){
                Object[] infoLeida = {productos.getCodigoProducto(),productos.getNombreProducto(),productos.getPrecioProducto(),productos.getCantidadProductos()};
                modeloInventario.addRow(infoLeida);
            }
            tblProductos.setModel(modeloInventario);
        }catch (Exception e ){

        }
    }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Inventario Clinica Dental");
        frame1.setContentPane(new frmInventario().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }

}
