package gui.Pacientes;

import negocios.pacientes.PacienteNegocio;
import netscape.security.UserTarget;
import recursos.clases.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmPacientes {
    private JPanel JpaPrincipal;
    private JPanel JpaIzquierdo;
    private JPanel JpaDerecho;
    private JPanel JpaSuperior;
    private JButton btnRegistrar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblCodigoPaciente;
    private JLabel lblFechaNacimiento;
    private JLabel lblDNI;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtCodigo;
    private JTextField txtFechaNacimiento;
    private JTextField txtDNI;
    private JPanel JpaInferior;
    private JTable tblPacientes;
    private JScrollPane scrlPanDatos;
    private JButton btnActualizar;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel modeloTabla = new DefaultTableModel();
    public frmPacientes() {
        iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Paciente paciente = new Paciente() ;
                    paciente.setNombre(txtNombre.getText());
                    paciente.setEdad(Integer.parseInt(txtEdad.getText()));
                    paciente.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    paciente.setFechaNacimiento(convertirFormatoTextoFecha (txtFechaNacimiento.getText()));
                    paciente.setDNI(Long.parseLong(txtDNI.getText()));
                    new PacienteNegocio().Insertar(paciente);
                    JOptionPane.showMessageDialog(null, "Guardad " , "Exito ", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(),"Error" , JOptionPane.ERROR_MESSAGE);
                }

            }

        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Paciente paciente = new Paciente();
                    paciente.setNombre(txtNombre.getText());
                    paciente.setEdad(Integer.parseInt(txtEdad.getText()));
                    paciente.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    paciente.setFechaNacimiento(convertirFormatoTextoFecha (txtFechaNacimiento.getText()));
                    paciente.setDNI(Long.parseLong(txtDNI.getText()));
                    new PacienteNegocio().Eliminar(paciente);
                    leerDatos();
                }catch (Exception ex ){
                }
            }
        });
        tblPacientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               int infoSeleccionado = tblPacientes.getSelectedRow();
               txtNombre.setText(modeloTabla.getValueAt(infoSeleccionado, 0).toString());
               txtEdad.setText(modeloTabla.getValueAt(infoSeleccionado,1).toString());
               txtCodigo.setText(modeloTabla.getValueAt(infoSeleccionado, 2).toString());
               txtFechaNacimiento.setText(modeloTabla.getValueAt(infoSeleccionado,3) .toString());
               txtDNI.setText(modeloTabla.getValueAt(infoSeleccionado , 4).toString());

            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatos();
            }
        });
        txtFechaNacimiento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char error = e.getKeyChar();
                if (!((error>='0')&& (error<= '9') ||(error ==KeyEvent.VK_BACK_SPACE) || (error== KeyEvent.VK_DELETE) ||(error == KeyEvent.VK_SLASH))){
                    JOptionPane.showMessageDialog(null,"Ingrese una fecha Valida");
                    e.consume();
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Paciente paciente = new Paciente();
                    paciente.setNombre(txtNombre.getText());
                    paciente.setEdad(Integer.parseInt(txtEdad.getText()));
                    paciente.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    paciente.setFechaNacimiento(convertirFormatoTextoFecha (txtFechaNacimiento.getText()));
                    paciente.setDNI(Long.parseLong(txtDNI.getText()));
                    new PacienteNegocio().actualizar(paciente);
                    JOptionPane.showMessageDialog(null, "Actualizacion con exito " , "Exito", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                }catch (Exception ex ){
                    JOptionPane.showMessageDialog(null,"No se pudo actualizar" , "Error ", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Paciente paciente = new Paciente();
                    paciente.setNombre(txtNombre.getText());
                    List<Paciente> listaDePacientes = new PacienteNegocio().Buscar(paciente);
                    modeloTabla.setRowCount(0);
                    for (Paciente cadaPacienteRegistrado : listaDePacientes){
                        Object[] registroLeido = {cadaPacienteRegistrado.getNombre(),cadaPacienteRegistrado.getEdad(), cadaPacienteRegistrado.getCodigo(),cadaPacienteRegistrado.getFechaNacimiento(),cadaPacienteRegistrado.getDNI()};
                        modeloTabla.addRow(registroLeido);
                    }
                    tblPacientes.setModel(modeloTabla);
                }catch (Exception ex ){

                }
            }
        });
    }
    private Date convertirFormatoTextoFecha (String textoFecha){
        Date fecha = null;
        try{
            fecha =  sdf.parse(textoFecha);
        }catch (ParseException pe){
            JOptionPane.showMessageDialog(null, pe.getMessage(), "ERROr", JOptionPane.ERROR_MESSAGE);
        }
        return fecha;
    }

    private void iniciar() {
        modeloTabla = ( DefaultTableModel)tblPacientes.getModel();
        modeloTabla.addColumn("Nombre ");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("Codigo");
        modeloTabla.addColumn("Fecha de nacimiento");
        modeloTabla.addColumn("DNI");
        leerDatos();

    }

    private void leerDatos() {
        try {
            List<Paciente> listaPaciente =  new PacienteNegocio().leer();
            modeloTabla.setRowCount(0);
            for (Paciente paciente : listaPaciente){
                Object[] registroLeido = {paciente.getNombre(),paciente.getEdad(),paciente.getCodigo(),sdf.format(paciente.getFechaNacimiento()),paciente.getDNI()};
                modeloTabla.addRow(registroLeido);
            }
            tblPacientes.setModel(modeloTabla);
        }catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Pacientes");
        frame1.setContentPane(new frmPacientes().JpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
