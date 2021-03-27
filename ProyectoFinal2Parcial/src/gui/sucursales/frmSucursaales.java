package gui.sucursales;

import recursos.clases.Sucursales;
import negocios.Sucursales.SucursalesNegocio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmSucursaales {
    private JPanel jpaPrincipal;
    private JPanel jpaDerecho;
    private JPanel jpaIzquierdo;
    private JPanel jpaSuperior;
    private JPanel jpaInferior;
    private JLabel jblSucursal;
    private JLabel lblCiudad;
    private JLabel lblPais;
    private JLabel lblTipoSucursal;
    private JLabel lblIdSucursal;
    private JTextField txtSucursal;
    private JTextField txtCiudad;
    private JTextField txtPais;
    private JTextField txtTipoSucursal;
    private JTextField txtIdSucursal;
    private JButton btnIngresar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JTable tblSucursales;
    private JScrollPane scrlSucursales;
    DefaultTableModel ModelSucursales = new DefaultTableModel();

    public frmSucursaales() {
        Iniciar();
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Sucursales sucursales=new Sucursales();
                    sucursales.setSucursal(Integer.parseInt(txtSucursal.getText()));
                    sucursales.setCiudad(txtCiudad.getText());
                    sucursales.setPais(txtPais.getText());
                    sucursales.setTipoSucursal(txtTipoSucursal.getText());
                    sucursales.setIdSucursal(Integer.parseInt(txtIdSucursal.getText()));
                    new SucursalesNegocio().Insertar(sucursales);
                    JOptionPane.showMessageDialog(null,"Guardado exitosament","Exito",JOptionPane.INFORMATION_MESSAGE);
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
                    Sucursales sucursales=new Sucursales();
                    sucursales.setSucursal(Integer.parseInt(txtSucursal.getText()));
                    sucursales.setCiudad(txtCiudad.getText());
                    sucursales.setPais(txtPais.getText());
                    sucursales.setTipoSucursal(txtTipoSucursal.getText());
                    sucursales.setIdSucursal(Integer.parseInt(txtIdSucursal.getText()));
                    new SucursalesNegocio().Actualizar(sucursales);
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
                    Sucursales sucursales=new Sucursales();
                    sucursales.setSucursal(Integer.parseInt(txtSucursal.getText()));
                    sucursales.setCiudad(txtCiudad.getText());
                    sucursales.setPais(txtPais.getText());
                    sucursales.setTipoSucursal(txtTipoSucursal.getText());
                    sucursales.setIdSucursal(Integer.parseInt(txtIdSucursal.getText()));
                    new SucursalesNegocio().Eliminar(sucursales);
                    JOptionPane.showMessageDialog(null,"Borrado Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"ERROR NO SE PUDO BORRAR","ERROR",JOptionPane.ERROR_MESSAGE);
                }



            }
        });
        tblSucursales.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int FilaSeleccionada=tblSucursales.getSelectedRow();
                txtSucursal.setText(ModelSucursales.getValueAt(FilaSeleccionada,0).toString());
                txtCiudad.setText(ModelSucursales.getValueAt(FilaSeleccionada,1).toString());
                txtPais.setText(ModelSucursales.getValueAt(FilaSeleccionada,2).toString());
                txtTipoSucursal.setText(ModelSucursales.getValueAt(FilaSeleccionada,3).toString());
                txtIdSucursal.setText(ModelSucursales.getValueAt(FilaSeleccionada,4).toString());
                leerDatos();


            }
        });




    }
    private void Iniciar() {
        ModelSucursales =(DefaultTableModel)tblSucursales.getModel();
        ModelSucursales.addColumn("Sucursal");
        ModelSucursales.addColumn("Ciudad");
        ModelSucursales.addColumn("Pais");
        ModelSucursales.addColumn("TipoSucursal");
        ModelSucursales.addColumn("IdSucursal");

        leerDatos();
    }
    private void leerDatos() {
        try {
            List<Sucursales>sucursalesList= new SucursalesNegocio().LeerSucursales();
            ModelSucursales.setRowCount(0);
            for (Sucursales sucursales:sucursalesList) {
                Object[] registro={sucursales.getSucursal(),sucursales.getCiudad(),sucursales.getPais(),sucursales.getTipoSucursal(),sucursales.getIdSucursal()};
                ModelSucursales.addRow(registro);

            }
            tblSucursales.setModel(ModelSucursales);
        }catch (Exception e){

        }
    }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Sucursales");
        frame1.setContentPane(new frmSucursaales().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
