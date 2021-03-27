package gui.Servicios;



import negocios.Servicio.ServiciosNegocio;
import recursos.clases.Servicios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class frmServicios {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquiero;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JPanel jpaInferior;
    private JButton btnIngresar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JTextField txtNombre;
    private JTextField txtConsulta;
    private JTextField txtMantenimiento;
    private JTextField txtOperacion;
    private JTable tblServicios;
    private JLabel lblNombre;
    private JScrollPane scrlServicios;
    private JLabel lblConsulta;
    private JLabel lblMantenimiento;
    private JLabel lblOperacion;
    DefaultTableModel ModeloServicios=new DefaultTableModel();
    public frmServicios() {
        Iniciar();
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    Servicios servicios=new Servicios();
                    servicios.setNombre(txtNombre.getText());
                    servicios.setConsulta(Double.parseDouble(txtConsulta.getText()));
                    servicios.setMantenimiento(Double.parseDouble(txtMantenimiento.getText()));
                    servicios.setOperacion(Double.parseDouble(txtOperacion.getText()));
                    new ServiciosNegocio().InsertarServicios(servicios);
                    JOptionPane.showMessageDialog(null,"Guardado exitosament","Exito",JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();



                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"ERROR NO SE PUDO GUARDAR","ERROR",JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Servicios servicios=new Servicios();
                    servicios.setNombre(txtNombre.getText());
                    servicios.setConsulta(Double.parseDouble(txtConsulta.getText()));
                    servicios.setMantenimiento(Double.parseDouble(txtMantenimiento.getText()));
                    servicios.setOperacion(Double.parseDouble(txtOperacion.getText()));
                    new ServiciosNegocio().EliminarServicios(servicios);
                    JOptionPane.showMessageDialog(null,"Guardado Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"ERROR NO SE PUDO GUARDAR","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Servicios servicios=new Servicios();
                    servicios.setNombre(txtNombre.getText());
                    servicios.setConsulta(Double.parseDouble(txtConsulta.getText()));
                    servicios.setMantenimiento(Double.parseDouble(txtMantenimiento.getText()));
                    servicios.setOperacion(Double.parseDouble(txtOperacion.getText()));
                    new ServiciosNegocio().ActualizarServicios(servicios);
                    JOptionPane.showMessageDialog(null,"Guardado Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"ERROR NO SE PUDO GUARDAR","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    }
    private void Iniciar() {
        ModeloServicios=(DefaultTableModel)tblServicios.getModel();
        ModeloServicios.addColumn("Nombre");
        ModeloServicios.addColumn("Consulta");
        ModeloServicios.addColumn("Mantenimiento");
        ModeloServicios.addColumn("Operacion");
        leerDatos();
    }
    private void leerDatos() {
        try {
            List<Servicios> serviciosList=new ServiciosNegocio().LeerServicios();
            ModeloServicios.setRowCount(0);
            for (Servicios servicios:serviciosList
            ) {
                Object[] registro={servicios.getNombre(),servicios.getConsulta(),servicios.getMantenimiento(),servicios.getOperacion()};
                ModeloServicios.addRow(registro);

            }
            tblServicios.setModel(ModeloServicios);
        }catch (Exception e){

        }

    }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Servicios");
        frame1.setContentPane(new frmServicios().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }

}
