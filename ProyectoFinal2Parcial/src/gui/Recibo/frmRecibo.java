package gui.Recibo;

import datos.dentist.ReciboDatos;
import gui.Pacientes.frmPacientes;
import negocios.recibos.ReciboNegocio;
import recursos.clases.Recibo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmRecibo {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JPanel jpaSuperior;
    private JPanel jpaInferior;
    private JScrollPane scrTablaDatos;
    private JLabel lblNombre;
    private JLabel lblPrecioProcedimiento;
    private JLabel lblImpuesto;
    private JLabel lblTotalPagar;
    private JTextField txtNombre;
    private JTextField txtPrecioProcedimiento;
    private JTextField txtImpuesto;
    private JTextField txtTotalPagar;
    private JButton btnRegistrar;
    private JButton btnCalcularTotal;
    private JTable tblRecibosDatos;
    private JButton btnActualizar;
    private JButton btnEliminar;
    DefaultTableModel modelo = new DefaultTableModel();

    public frmRecibo() {
        iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Recibo recibo = new Recibo();
                    recibo.setNombre(txtNombre.getText());
                    recibo.setPrecioProcedimiento(Double.parseDouble(txtPrecioProcedimiento.getText()));
                    recibo.setPrecioImpuesto(Double.parseDouble(txtImpuesto.getText()));
                    recibo.setTotalPagar(Double.parseDouble(txtTotalPagar.getText()));
                    new ReciboNegocio().insertarRecibo(recibo);
                    JOptionPane.showMessageDialog(null, "Guardado", "Exito ", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "No se ha podido insertar" , "Error" ,  JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCalcularTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double procedimiento ;
                double impuesto;
                double total;
                try {
                    impuesto =Double.parseDouble(txtImpuesto.getText());
                    procedimiento = Double.parseDouble(txtPrecioProcedimiento.getText());
                    Recibo recibo = new Recibo();
                    recibo.setPrecioProcedimiento(procedimiento);
                    recibo.setPrecioImpuesto(impuesto);
                    total = impuesto + procedimiento;
                    txtTotalPagar.setText(String.valueOf(total));
                } catch (Exception ex) {
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Recibo recibo = new Recibo();
                    recibo.setNombre(txtNombre.getText());
                    recibo.setPrecioProcedimiento(Double.parseDouble(txtPrecioProcedimiento.getText()));
                    recibo.setPrecioImpuesto(Double.parseDouble(txtImpuesto.getText()));
                    recibo.setTotalPagar(Double.parseDouble(txtTotalPagar.getText()));
                    new ReciboNegocio().ActualizarRecibo(recibo);
                    JOptionPane.showMessageDialog(null,"Actualizacion Exitosa" , "Exito ", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,"No se pudo Actualizar " , "Error ", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Recibo recibo = new Recibo();
                    recibo.setNombre(txtNombre.getText());
                    recibo.setPrecioProcedimiento(Double.parseDouble(txtPrecioProcedimiento.getText()));
                    recibo.setPrecioImpuesto(Double.parseDouble(txtImpuesto.getText()));
                    recibo.setTotalPagar(Double.parseDouble(txtTotalPagar.getText()));
                    new ReciboNegocio().Eliminar(recibo);
                    JOptionPane.showMessageDialog(null, "Eliminado Exitoso", "Exito ", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                } catch (Exception ex) {

                }
            }
        });
        tblRecibosDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblRecibosDatos.getSelectedRow();
                txtNombre.setText(modelo.getValueAt(filaSeleccionada,0 ).toString());
                txtPrecioProcedimiento.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                txtImpuesto.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                txtTotalPagar.setText(modelo.getValueAt(filaSeleccionada, 3).toString());

            }
        });
    }

    private void iniciar() {
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio por procedimiento");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Total a Pagar ");
        leerDatos ();
    }

    private void leerDatos() {
        try{
            List<Recibo> listaRecibos = new ReciboNegocio().leer();
            modelo.setRowCount(0);
            for(Recibo recibos : listaRecibos){
                Object[] registrosLeidos = {recibos.getNombre(),recibos.getPrecioProcedimiento(),recibos.getPrecioImpuesto(),recibos.getTotalPagar()};
                modelo.addRow(registrosLeidos);
            }
            tblRecibosDatos.setModel(modelo);
        }catch (Exception e){

        }
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Recibo");
        frame1.setContentPane(new frmRecibo().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
