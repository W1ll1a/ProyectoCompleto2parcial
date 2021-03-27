package gui.Gastos;

import recursos.clases.Gastos;
import negocios.Gastos.GastosNegocio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmGastos {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JPanel jpaInferior;
    private JLabel lblPorLocal;
    private JLabel lblImpuesto;
    private JLabel lblMantenimiento;
    private JLabel lblPersonal;
    private JTextField txtPorLocal;
    private JTextField txtImpuesto;
    private JTextField txtMantenimiento;
    private JTextField txtPersonal;
    private JButton btnRegistrar;
    private JButton eliminarButton;
    private JButton actualizarButton;
    private JTable tblGastos;
    private JScrollPane scrlAfiliados;
    DefaultTableModel ModeloGastos= new DefaultTableModel();

    public frmGastos() {
        Iniciar();

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                Gastos gastos= new Gastos();
                gastos.setPorLocal(Double.parseDouble(txtPorLocal.getText()));
                gastos.setImpuestos(Double.parseDouble(txtImpuesto.getText()));
                gastos.setMantenimientoLocal(Double.parseDouble(txtMantenimiento.getText()));
                gastos.setPersonal(Double.parseDouble(txtPersonal.getText()));
                new GastosNegocio().Insertar(gastos);
                JOptionPane.showMessageDialog(null,"Guardado exitosament","Exito",JOptionPane.INFORMATION_MESSAGE);
                leerDatos();



            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"ERROR NO SE PUDO GUARDAR","ERROR",JOptionPane.ERROR_MESSAGE);

            }

            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Gastos gastos = new Gastos();
                    gastos.setPorLocal(Double.parseDouble(txtPorLocal.getText()));
                    gastos.setImpuestos(Double.parseDouble(txtImpuesto.getText()));
                    gastos.setMantenimientoLocal(Double.parseDouble(txtMantenimiento.getText()));
                    gastos.setPersonal(Double.parseDouble(txtPersonal.getText()));

                    new GastosNegocio().EliminarGastos(gastos);
                    JOptionPane.showMessageDialog(null, "Guardado Exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR NO SE PUDO GUARDAR", "ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
        });


        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Gastos gastos=new Gastos();
                    gastos.setPorLocal(Double.parseDouble(txtPorLocal.getText()));
                    gastos.setImpuestos(Double.parseDouble(txtImpuesto.getText()));
                    gastos.setMantenimientoLocal(Double.parseDouble(txtMantenimiento.getText()));
                    gastos.setPersonal(Double.parseDouble(txtPersonal.getText()));
                    new GastosNegocio().ActualizarGastos(gastos);
                    JOptionPane.showMessageDialog(null,"Guardado Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();


                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"ERROR NO SE PUDO GUARDAR","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        tblGastos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int FilaSeleccionada=tblGastos.getSelectedRow();
                txtPorLocal.setText(ModeloGastos.getValueAt(FilaSeleccionada,0).toString());
                txtImpuesto.setText(ModeloGastos.getValueAt(FilaSeleccionada,1).toString());
                txtMantenimiento.setText(ModeloGastos.getValueAt(FilaSeleccionada,2).toString());
                txtPersonal.setText(ModeloGastos.getValueAt(FilaSeleccionada,3).toString());

            }
        });


    }
    private void Iniciar(){
        ModeloGastos=(DefaultTableModel)tblGastos.getModel();
        ModeloGastos.addColumn("PorLocal");
        ModeloGastos.addColumn("Impuesto");
        ModeloGastos.addColumn("Mantenimiento");
        ModeloGastos.addColumn("Personal");
        leerDatos();

    }
    private void leerDatos(){
        try {
            List<Gastos>gastosList= new GastosNegocio().LeerGastos();
            ModeloGastos.setRowCount(0);
            for (Gastos gastos:gastosList
            ) {
                Object[] resgistro={gastos.getPorLocal(),gastos.getImpuestos(),gastos.getMantenimientoLocal(),gastos.getPersonal()};
                ModeloGastos.addRow(resgistro);

            }
            tblGastos.setModel(ModeloGastos);
        }catch (Exception e){

        }
    }

public static void main (String [] args){
    JFrame frame1 = new JFrame("Gastos");
    frame1.setContentPane(new frmGastos().jpaPrincipal);
    frame1.setResizable(false);
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.pack();
    frame1.setLocationRelativeTo(null);
    frame1.setVisible(true);
}
}

