package gui.Empleados;
import datos.dentist.EmpleadosDatos;
import gui.Pacientes.frmPacientes;
import negocios.Empleados.EmpleadosNegocio;
import recursos.clases.Empleados;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class frmEmpleado {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JPanel jpaSuperior;
    private JPanel jpaInferior;
    private JLabel lblCodigo;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblDNI;
    private JLabel lblFechaNacimiento;
    private JLabel lblEstadoCivil;
    private JButton btnRegistro;
    private JButton btnEliminar;
    private JTextField txtEdad;
    private JTextField txtDNI;
    private JTextField txtNombre;
    private JTextField txtCodigo;
    private JTextField txtFechaNacimiento;
    private JTextField txtEstadoCivil;
    private JTable tblEmpleados;
    private JScrollPane scrlDatosEmp;
    private JButton btnActualizar;
    SimpleDateFormat sdf  =new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modeloTablaEmpleados = new DefaultTableModel();

    public frmEmpleado() {
        iniciar();
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Empleados empleados = new Empleados();
                    empleados.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    empleados.setNombre(txtNombre.getText());
                    empleados.setEdad(Integer.parseInt(txtEdad.getText()));
                    empleados.setDNI(Long.parseLong(txtDNI.getText()));
                    empleados.setFechaNacimiento(convertirFormatoTextoFecha (txtFechaNacimiento.getText()));
                    empleados.setEstadoCivil(txtEstadoCivil.getText());
                    new EmpleadosNegocio().Insertar(empleados);
                    JOptionPane.showMessageDialog(null,"Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error no se guardo" , "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Empleados empleados= new Empleados();
                    empleados.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    empleados.setNombre(txtNombre.getText());
                    empleados.setEdad(Integer.parseInt(txtEdad.getText()));
                    empleados.setDNI(Long.parseLong(txtDNI.getText()));
                    empleados.setFechaNacimiento(convertirFormatoTextoFecha (txtFechaNacimiento.getText()));
                    empleados.setEstadoCivil(txtEstadoCivil.getText());
                    new EmpleadosNegocio().eliminarEmpleado(empleados);
                    leerDatos();
                }catch (Exception ex){

                }
            }
        });
        tblEmpleados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int infoSeleccionada = tblEmpleados.getSelectedRow();
                txtCodigo.setText(modeloTablaEmpleados.getValueAt(infoSeleccionada , 0).toString());
                txtNombre.setText(modeloTablaEmpleados.getValueAt(infoSeleccionada , 1).toString());
                txtEdad.setText(modeloTablaEmpleados.getValueAt(infoSeleccionada, 2).toString());
                txtDNI.setText(modeloTablaEmpleados.getValueAt(infoSeleccionada, 3).toString());
                txtFechaNacimiento.setText(modeloTablaEmpleados.getValueAt(infoSeleccionada, 4).toString());
                txtEstadoCivil.setText(modeloTablaEmpleados.getValueAt(infoSeleccionada, 5).toString());
            }
        });
        txtFechaNacimiento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c>='0') &&(c<='9') || (c==KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)|| (c == KeyEvent.VK_SLASH))){
                    JOptionPane.showMessageDialog(null, "Porfavor ingrese una fecha correcta");
                    e.consume();
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Empleados empleados= new Empleados();
                    empleados.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    empleados.setNombre(txtNombre.getText());
                    empleados.setEdad(Integer.parseInt(txtEdad.getText()));
                    empleados.setDNI(Long.parseLong(txtDNI.getText()));
                    empleados.setFechaNacimiento(convertirFormatoTextoFecha (txtFechaNacimiento.getText()));
                    empleados.setEstadoCivil(txtEstadoCivil.getText());
                    new EmpleadosNegocio().ActualizarEmpleado(empleados);
                    JOptionPane.showMessageDialog(null,"ACtualizado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"No se pudo actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    private void iniciar() {
        modeloTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
        modeloTablaEmpleados.addColumn( "Codigo ");
        modeloTablaEmpleados.addColumn("Nombre");
        modeloTablaEmpleados.addColumn("Edad");
        modeloTablaEmpleados.addColumn("DNI");
        modeloTablaEmpleados.addColumn("Fecha de nacimiento");
        modeloTablaEmpleados.addColumn("Estado Civil");
        leerDatos();

    }
    private void leerDatos() {
        try{
            List<Empleados >listaEmpleados = new EmpleadosNegocio().leer();
            modeloTablaEmpleados.setRowCount(0);
            for(Empleados empleados : listaEmpleados){
                Object[] registrosLeidos = {empleados.getCodigo(),empleados.getNombre(),empleados.getEdad(),empleados.getDNI(), sdf .format(empleados.getFechaNacimiento()),empleados.getEstadoCivil()};
                modeloTablaEmpleados.addRow(registrosLeidos);
            }
            tblEmpleados.setModel(modeloTablaEmpleados);
        }catch (Exception e){
        }
    }
    public Date convertirFormatoTextoFecha(String fechaTexto){
        Date fecha = null;
        try{
            fecha =  sdf.parse(fechaTexto);
        }catch (ParseException pe){
            JOptionPane.showMessageDialog(null, pe.getMessage(), "ERROr", JOptionPane.ERROR_MESSAGE);
        }
        return fecha;
    }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Empleados");
        frame1.setContentPane(new frmEmpleado().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}