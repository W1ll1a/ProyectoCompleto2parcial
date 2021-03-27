package gui.Telefonos;

import gui.Recibo.frmRecibo;
import negocios.Telefonos.TelefonoNegocios;
import negocios.pacientes.PacienteNegocio;
import negocios.recibos.ReciboNegocio;
import recursos.clases.Paciente;
import recursos.clases.Recibo;
import recursos.clases.Telefono;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmTelefonos {
    private JPanel jpaPrincipal;
    private JLabel lblNombrePaciente;
    private JLabel lblNumeroTelefono;
    private JLabel lblComaniaTelefonica;
    private JTextField txtNombre;
    private JTextField txtNumero;
    private JTextField txtCompañia;
    private JScrollPane scrlTelefonos;
    private JButton btnInsertar;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JPanel jpaSuperior;
    private JPanel jpaInferior;
    private JButton btnEliminar;
    private JButton btnEnlistar;
    private JTable tblTelefonos;
    private JButton btnBuscar;
    DefaultTableModel modeloTelefonos = new DefaultTableModel();
    public frmTelefonos() {
        iniciar();
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Telefono telefono = new Telefono();
                    telefono.setNombreCliente(txtNombre.getText());
                    telefono.setNumeroTelefono(Long.parseLong(txtNumero.getText()));
                    telefono.setCompaniaTelefonica(txtCompañia.getText());
                    new TelefonoNegocios().insertartelefono(telefono);
                    JOptionPane.showMessageDialog(null, "Guardado" , "Exito", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null , "Error al registrar" , "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Telefono telefono = new Telefono();
                    telefono.setNombreCliente(txtNombre.getText());
                    telefono.setNumeroTelefono(Long.parseLong(txtNumero.getText()));
                    telefono.setCompaniaTelefonica(txtCompañia.getText());
                    new TelefonoNegocios().Eliminar(telefono);
                    JOptionPane.showMessageDialog(null, "Eliminado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnEnlistar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        leerDatos ();

            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Telefono telefono = new Telefono();
                    telefono.setNombreCliente(txtNombre.getText());
                    List<Telefono> listaDeTelefonos = new TelefonoNegocios().Buscar(telefono);
                    modeloTelefonos.setRowCount(0);
                    for (Telefono telefono1: listaDeTelefonos){
                        Object[] registroLeido = {telefono1.getNombreCliente(),telefono1.getNumeroTelefono(),telefono1.getCompaniaTelefonica()};
                        modeloTelefonos.addRow(registroLeido);
                    }
                    tblTelefonos.setModel(modeloTelefonos);
                }catch (Exception ex ){

                }
            }
        });
        tblTelefonos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada =tblTelefonos.getSelectedRow();
                txtNombre.setText(modeloTelefonos.getValueAt(filaSeleccionada, 0 ).toString());
                txtNumero.setText(modeloTelefonos.getValueAt(filaSeleccionada,1).toString());
                txtCompañia.setText(modeloTelefonos.getValueAt(filaSeleccionada, 2).toString());
            }
        });
    }

    private void iniciar() {
        modeloTelefonos = (DefaultTableModel) tblTelefonos.getModel();
        modeloTelefonos.addColumn("Nombre del paciente ");
        modeloTelefonos.addColumn("Numero de telefono del paciente");
        modeloTelefonos.addColumn("Compañia Telefonica");
        leerDatos();
    }

    private void leerDatos() {
        try {
            List<Telefono> listatelefonos =  new TelefonoNegocios().leer();
            modeloTelefonos.setRowCount(0);
            for (Telefono telefonos: listatelefonos){
                Object[] registroLeido = {telefonos.getNombreCliente(), telefonos.getNumeroTelefono(),telefonos.getCompaniaTelefonica()};
                modeloTelefonos.addRow(registroLeido);
            }
            tblTelefonos.setModel(modeloTelefonos);
        }catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Agenda de numeros telefonicos");
        frame1.setContentPane(new frmTelefonos().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
