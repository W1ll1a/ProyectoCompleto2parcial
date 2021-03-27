package gui.MetodoDePago;


import negocios.MetodoDePago.MetodoDePagoNegocio;
import recursos.clases.MetodoDePago;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmMetodoDePago {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaSuperior;
    private JPanel jpaInferior;
    private JPanel jpaDerecha;
    private JButton btnIngresar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JTextField txtNombre;
    private JTextField txtMetodo;
    private JTextField txtCantidad;
    private JLabel lblNombre;
    private JLabel lblMetodo;
    private JLabel lblCantidad;
    private JTable tblMetodoDePago;
    private JButton btnListar;
    private JScrollPane scrlMetodoDePago;
    DefaultTableModel ModeloMetodosDePago= new DefaultTableModel();

    public frmMetodoDePago() {
        Iniciar();
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MetodoDePago metodosDePago = new MetodoDePago();
                    metodosDePago.setNombre(txtNombre.getText());
                    metodosDePago.setMetodo(txtMetodo.getText());
                    metodosDePago.setCantidad(Double.parseDouble(txtCantidad.getText()));
                    new MetodoDePagoNegocio().Insertar(metodosDePago);
                    JOptionPane.showMessageDialog(null, "Guardado exitosament", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    LeerDatos();


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR NO SE PUDO GUARDAR", "ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }


        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MetodoDePago metodosDePago = new MetodoDePago();
                    metodosDePago.setNombre(txtNombre.getText());
                    metodosDePago.setMetodo(txtMetodo.getText());
                    metodosDePago.setCantidad(Double.parseDouble(txtCantidad.getText()));
                    new MetodoDePagoNegocio().Eliminar(metodosDePago);
                    JOptionPane.showMessageDialog(null, "Guardado exitosament", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    LeerDatos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR NO SE PUDO GUARDAR", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MetodoDePago metodosDePago = new MetodoDePago();
                    metodosDePago.setNombre(txtNombre.getText());
                    metodosDePago.setMetodo(txtMetodo.getText());
                    metodosDePago.setCantidad(Double.parseDouble(txtCantidad.getText()));
                    new MetodoDePagoNegocio().Actualizar(metodosDePago);
                    JOptionPane.showMessageDialog(null, "Guardado exitosament", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    LeerDatos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR NO SE PUDO GUARDAR", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tblMetodoDePago.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int FilaSeleccionada = tblMetodoDePago.getSelectedRow();
                txtNombre.setText(ModeloMetodosDePago.getValueAt(FilaSeleccionada, 0).toString());
                txtMetodo.setText(ModeloMetodosDePago.getValueAt(FilaSeleccionada, 1).toString());
                txtCantidad.setText(ModeloMetodosDePago.getValueAt(FilaSeleccionada, 2).toString());
                LeerDatos();


            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             LeerDatos();
            }
        });
    }
        private void Iniciar(){
            ModeloMetodosDePago=(DefaultTableModel) tblMetodoDePago.getModel();
            ModeloMetodosDePago.addColumn("Nombre");
            ModeloMetodosDePago.addColumn("MetodoDePago");
            ModeloMetodosDePago.addColumn("Cantidad");
            LeerDatos();
        }
        private void LeerDatos(){
            try {
                List<MetodoDePago> metodosDePagoList=new MetodoDePagoNegocio().LeerMetodosDePago();
                ModeloMetodosDePago.setRowCount(0);
                for (MetodoDePago metodosDePago:metodosDePagoList) {

                    Object[] registro={metodosDePago.getNombre(),metodosDePago.getMetodo(),metodosDePago.getCantidad()};
                    ModeloMetodosDePago.addRow(registro);

                }
                tblMetodoDePago.setModel(ModeloMetodosDePago);
            }catch (Exception e){

            }
        }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("MetodoDePago");
        frame1.setContentPane(new frmMetodoDePago().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }

    }





