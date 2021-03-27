package gui.Ventas;


import negocios.Ventas.VentasNegocios;

import recursos.clases.Ventas;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class fmrVentas {
    private JPanel JpaPrincipal;
    private JButton btnIngresar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JTextField txtTotalAnual;
    private JTextField txtTotalMensual;
    private JTextField txtTotalSemanal;
    private JTable tblVentas;
    private JLabel lblTotalAnual;
    private JLabel lblTotalMensual;
    private JLabel lblTotalSemanal;
    private JScrollPane scrlVentas;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JPanel jpaInferior;
    private JPanel jpaSuperior;
    DefaultTableModel ModeloVentas=new DefaultTableModel();
    public fmrVentas() {
        Iniciar();
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Ventas ventas = new Ventas();
                    ventas.setTotalAnual(Double.parseDouble(txtTotalAnual.getText()));
                    ventas.setTotalMes(Double.parseDouble(txtTotalMensual.getText()));
                    ventas.setTotalSemanal(Double.parseDouble(txtTotalSemanal.getText()));


                    new VentasNegocios().Insertar(ventas);
                    JOptionPane.showMessageDialog(null, "Guardado exitosament", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR NO SE PUDO GUARDAR", "ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Ventas ventas = new Ventas();
                    ventas.setTotalAnual(Double.parseDouble(txtTotalAnual.getText()));
                    ventas.setTotalMes(Double.parseDouble(txtTotalMensual.getText()));
                    ventas.setTotalSemanal(Double.parseDouble(txtTotalSemanal.getText()));

                    new VentasNegocios().EliminarVentas(ventas);
                    JOptionPane.showMessageDialog(null, "Guardado Exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR NO SE PUDO GUARDAR", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Ventas ventas=new Ventas();

                    ventas.setTotalAnual(Double.parseDouble(txtTotalAnual.getText()));
                    ventas.setTotalMes(Double.parseDouble(txtTotalMensual.getText()));
                    ventas.setTotalSemanal(Double.parseDouble(txtTotalSemanal.getText()));
                    new VentasNegocios().ActualizarVentas(ventas);

                    JOptionPane.showMessageDialog(null, "Guardado Exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR NO SE PUDO GUARDAR", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tblVentas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int FilaSeleccionada = tblVentas.getSelectedRow();
                txtTotalAnual.setText(ModeloVentas.getValueAt(FilaSeleccionada, 0).toString());
                txtTotalMensual.setText(ModeloVentas.getValueAt(FilaSeleccionada, 1).toString());
                txtTotalSemanal.setText(ModeloVentas.getValueAt(FilaSeleccionada, 2).toString());

            }
        });
    }
    private void Iniciar() {
        ModeloVentas=(DefaultTableModel)tblVentas.getModel();
        ModeloVentas.addColumn("TotalAnual");
        ModeloVentas.addColumn("TotalMensual");
        ModeloVentas.addColumn("TotalSemanal");
        leerDatos();
    }

        private void leerDatos(){
            try {
                List<Ventas> ventasList=new VentasNegocios().LeerVentas();
                ModeloVentas.setRowCount(0);
                for (Ventas ventas:ventasList
                ) {
                    Object[] registro={ventas.getTotalAnual(),ventas.getTotalMes(),ventas.getTotalSemanal()};
                    ModeloVentas.addRow(registro);

                }
                tblVentas.setModel(ModeloVentas);
            }catch (Exception e){

            }
        }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Ventas");
        frame1.setContentPane(new fmrVentas().JpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }



    }

