package gui.Afiliados;

import recursos.clases.Afiliados;
import negocios.Afiliados.AfiliadosNegocio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmAfiliados {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JPanel jpaInferior;
    private JPanel jpaSuperior;
    private JButton btnRegistrar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblContribucion;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtContribucion;
    private JTable tblAfiliados;
    private JScrollPane scrlAfiliados;
    DefaultTableModel ModeloAfiliados=new DefaultTableModel();

    public frmAfiliados() {
        Iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Afiliados afiliados=new Afiliados();
                    afiliados.setNombre(txtNombre.getText());
                    afiliados.setEdad(Integer.parseInt(txtEdad.getText()));
                    afiliados.setContribucion(Double.parseDouble(txtContribucion.getText()));
                    new AfiliadosNegocio().Insertar(afiliados);
                    JOptionPane.showMessageDialog(null,"Guardado exitosament","Exito",JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();



                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"ERROR NO SE PUDO GUARDAR","ERROR",JOptionPane.ERROR_MESSAGE);

                }


            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Afiliados afiliados=new Afiliados();
                    afiliados.setNombre(txtNombre.getText());
                    afiliados.setEdad(Integer.parseInt(txtEdad.getText()));
                    afiliados.setContribucion(Double.parseDouble(txtContribucion.getText()));
                    new AfiliadosNegocio().Actualizar(afiliados);
                    JOptionPane.showMessageDialog(null,"Guardado Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"ERROR NO SE PUDO GUARDAR","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Afiliados afiliados=new Afiliados();
                    afiliados.setNombre(txtNombre.getText());
                    afiliados.setEdad(Integer.parseInt(txtEdad.getText()));
                    afiliados.setContribucion(Double.parseDouble(txtContribucion.getText()));
                    new AfiliadosNegocio().Eliminar(afiliados);
                    JOptionPane.showMessageDialog(null,"Guardado Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"ERROR NO SE PUDO GUARDAR","ERROR",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        tblAfiliados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int FilaSeleccionada=tblAfiliados.getSelectedRow();
                txtNombre.setText(ModeloAfiliados.getValueAt(FilaSeleccionada,0).toString());
                txtEdad.setText(ModeloAfiliados.getValueAt(FilaSeleccionada,1).toString());
                txtContribucion.setText(ModeloAfiliados.getValueAt(FilaSeleccionada,2).toString());


            }
        });
    }

    private void Iniciar() {
        ModeloAfiliados=(DefaultTableModel)tblAfiliados.getModel();
        ModeloAfiliados.addColumn("Nombre");
        ModeloAfiliados.addColumn("Edad");
        ModeloAfiliados.addColumn("Contribucion");
        leerDatos();
    }

    private void leerDatos() {
        try {
            List<Afiliados>afiliadosList=new AfiliadosNegocio().LeerAfiliados();
            ModeloAfiliados.setRowCount(0);
            for (Afiliados afiliados:afiliadosList
                 ) {
                Object[] registro={afiliados.getNombre(),afiliados.getEdad(),afiliados.getContribucion()};
                ModeloAfiliados.addRow(registro);

            }
            tblAfiliados.setModel(ModeloAfiliados);
        }catch (Exception e){

        }
    }


    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Afiliados");
        frame1.setContentPane(new frmAfiliados().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
