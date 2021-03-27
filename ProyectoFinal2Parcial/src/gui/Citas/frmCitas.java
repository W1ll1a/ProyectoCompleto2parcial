package gui.Citas;

import negocios.Agenda.AgendaNegocio;
import recursos.clases.Agenda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmCitas {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JPanel jpaInferior;
    private JLabel lblProcedimiento;
    private JLabel lblPaciente;
    private JLabel lblFecha;
    private JTextField txtPaciente;
    private JTextField txtFechaCita;
    private JTextField txtProcedimiento;
    private JButton btnRegistrar;
    private JButton btnEliminar;
    private JScrollPane scrlAgenda;
    private JTable tblCitas;
    DefaultTableModel modeloCita = new DefaultTableModel();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public frmCitas() {
        inciar();

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Agenda cita = new Agenda();
                    cita.setPaciente(txtPaciente.getText());
                    cita.setFechaCita(converitrFormatoTextoFecha(txtFechaCita.getText()));
                    cita.setProcedimientServicio(txtProcedimiento.getText());
                    new AgendaNegocio().agregarCita(cita);
                    JOptionPane.showMessageDialog(null, "Guardado ", "Exito" , JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null , "Error Al guardad " , "Error " , JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Agenda cita = new Agenda();
                    cita.setPaciente(txtPaciente.getText());
                    cita.setFechaCita(converitrFormatoTextoFecha(txtFechaCita.getText()));
                    cita.setProcedimientServicio(txtProcedimiento.getText());
                    new AgendaNegocio().eliminarCita(cita);
                    JOptionPane.showMessageDialog(null, "Eliminado con Exito ", "Exito" , JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null , "Error al Eliminar " , "Error " , JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        tblCitas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblCitas.getSelectedRow();
                txtPaciente.setText(modeloCita.getValueAt(filaSeleccionada,0 ).toString());
                txtFechaCita.setText(modeloCita.getValueAt(filaSeleccionada,1).toString());
                txtProcedimiento.setText(modeloCita.getValueAt(filaSeleccionada,2).toString());
                }
        });
    }

    private void inciar() {
        modeloCita = (DefaultTableModel) tblCitas.getModel();
        modeloCita.addColumn("Paciente");
        modeloCita.addColumn("Fecha de Cita ");
        modeloCita.addColumn("Servicio que Solicito");
        leerDatos ();
    }

    private void leerDatos() {
        try {
            List<Agenda> listaDeCitas = new AgendaNegocio().leerCitas();
            modeloCita.setRowCount(0);
            for (Agenda cita : listaDeCitas) {
                Object[] registro = {cita.getPaciente(), sdf.format(cita.getFechaCita()), cita.getProcedimientServicio()};
                modeloCita.addRow(registro);
            }
            tblCitas.setModel(modeloCita);
        }catch (Exception e){

        }
    }
    private Date converitrFormatoTextoFecha (String textoFecha){
        Date fecha = null;
        try{
            fecha =  sdf.parse(textoFecha);
        }catch (ParseException pe){
            JOptionPane.showMessageDialog(null, pe.getMessage(), "ERROr", JOptionPane.ERROR_MESSAGE);
        }
        return fecha;
    }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Agenda de citas");
        frame1.setContentPane(new frmCitas().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
