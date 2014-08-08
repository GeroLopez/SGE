package GUI;

import Controlador.DAO_Estudiante;
import Controlador.DAO_Seccion;
import Modelo.Seccion;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Genaro López
 */
public class PanelCrearEstudiante extends javax.swing.JPanel {

    int idSeccion;

    /**
     * Creates new form PanelCrearEstudiante
     */
    public PanelCrearEstudiante() {
        initComponents();
        cargarSeccionesCombo();
    }

    /**
     * Carga desde la base de datos las secciones existentes y las despliega en
     * el comboBox jComboBoxSec en orden de menor a mayor.
     */
    public void cargarSeccionesCombo() {
        try {
            DAO_Seccion DAOseccion = new DAO_Seccion();
            DAOseccion.conexion.conectar();
            LinkedList<Seccion> secciones;
            secciones = DAOseccion.consultarSecciones();
            DAOseccion.conexion.cerrarConexion();
            jComboBoxSec.removeAllItems();
            for (Seccion seccion : secciones) {
                jComboBoxSec.addItem(seccion.getNombre());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Limpia los jTextField.
     */
    public void limpiar() {
        jTextFieldNom.setText("");
        jTextFieldApe.setText("");
        jTextFieldCed.setText("");
        jTextFieldEmail.setText("");
        jTextFieldCon.setText("");
        jTextFieldTel1.setText("");
        jTextFieldTel2.setText("");
    }

    public void agregarEstudiante() {
        try {
            String nombre;
            String apellido;
            String contraseña;
            String email;
            int cedula;
            int telefono1 = 0;
            int telefono2 = -1;
            int seccion = jComboBoxSec.getSelectedIndex() + 1;
            Calendar fecha = Calendar.getInstance();
            boolean investigacion = jRadioButtonInv.isSelected();
            boolean monitoreo = jRadioButtonMon.isSelected();
            if (!jTextFieldNom.getText().equals("")) {
                nombre = jTextFieldNom.getText();
                nom.setForeground(new Color(166, 187, 63));
                if (!jTextFieldApe.getText().equals("")) {
                    apellido = jTextFieldApe.getText();
                    ape.setForeground(new Color(166, 187, 63));
                    if (!jTextFieldCon.getText().equals("")) {
                        contraseña = jTextFieldCon.getText();
                        con.setForeground(new Color(166, 187, 63));
                        if (!jTextFieldEmail.getText().equals("")) {
                            email = jTextFieldEmail.getText();
                            ema.setForeground(new Color(166, 187, 63));
                            if (!monitoreo && !investigacion) {
                                JOptionPane.showMessageDialog(this,
                                        "Seleccione al menos una de las dos opciones, "
                                        + "Investigación ó Monitoreo", "Error", 0);
                            } else {
                                if (!jTextFieldTel1.getText().equals("")) {
                                    try {
                                        telefono1 = Integer.parseInt(jTextFieldTel1.getText());
                                        tel1.setForeground(new Color(166, 187, 63));
                                    } catch (Exception e) {
                                        jTextFieldTel1.setText("");
                                        tel1.setForeground(Color.red);
                                    }
                                }
                                if (!jTextFieldTel2.getText().equals("")) {
                                    try {
                                        telefono2 = Integer.parseInt(jTextFieldTel2.getText());
                                        tel2.setForeground(new Color(166, 187, 63));
                                    } catch (Exception e) {
                                        jTextFieldTel2.setText("");
                                        tel2.setForeground(Color.red);
                                    }
                                }
                                try {
                                    cedula = Integer.parseInt(jTextFieldCed.getText());
                                    ced.setForeground(new Color(166, 187, 63));
                                    DAO_Estudiante estudiante;
                                    estudiante = new DAO_Estudiante(cedula, nombre, apellido,
                                            telefono1, 2, seccion, new Timestamp(new java.util.Date().getTime()).toString(), email, contraseña);
                                    if (telefono2 != -1) {
                                        estudiante.setTelefono2(telefono2);
                                    } else {
                                        estudiante.setTelefono2(telefono1);
                                    }
                                    String usuario;
                                    usuario = nombre.substring(0, 1).concat(apellido.split(" ")[0]);
                                    estudiante.setNombreDeUsuario(usuario);
                                    estudiante.setEsMonitoreo(monitoreo);
                                    estudiante.setEsInvestigacion(investigacion);
                                    //aca va el llamado al método del DAO
                                    estudiante.conexion.conectar();
                                    String resultado = estudiante.AgregarEstudiante();
                                    estudiante.conexion.cerrarConexion();
                                    if (resultado.equals("exito")) {
                                        limpiar();
                                        JOptionPane.showMessageDialog(this,
                                                "Estudiante agregado con éxito", "Éxito en la inserción", JOptionPane.INFORMATION_MESSAGE);
                                    }else{
                                        JOptionPane.showMessageDialog(this,
                                                resultado.concat("\n por favor verifique."), "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } catch (NumberFormatException e) {
                                    jTextFieldCed.setText("");
                                    ced.setForeground(Color.red);
                                }
                            }

                        } else {
                            ema.setForeground(Color.red);
                        }
                    } else {
                        con.setForeground(Color.red);
                    }
                } else {
                    ape.setForeground(Color.red);
                }
            } else {
                nom.setForeground(Color.red);

            }
        } catch (HeadlessException e) {
            System.out.println("error en la última excepción " + e.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nom = new javax.swing.JLabel();
        ape = new javax.swing.JLabel();
        ced = new javax.swing.JLabel();
        tel1 = new javax.swing.JLabel();
        tel2 = new javax.swing.JLabel();
        sec = new javax.swing.JLabel();
        con = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldApe = new javax.swing.JTextField();
        jTextFieldCed = new javax.swing.JTextField();
        jTextFieldTel1 = new javax.swing.JTextField();
        jTextFieldTel2 = new javax.swing.JTextField();
        jComboBoxSec = new javax.swing.JComboBox();
        jTextFieldCon = new javax.swing.JTextField();
        jRadioButtonMon = new javax.swing.JRadioButton();
        jRadioButtonInv = new javax.swing.JRadioButton();
        confirmar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        ema = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        nom.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nom.setForeground(new java.awt.Color(166, 187, 63));
        nom.setText("Nombre");

        ape.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ape.setForeground(new java.awt.Color(166, 187, 63));
        ape.setText("Apelido");

        ced.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ced.setForeground(new java.awt.Color(166, 187, 63));
        ced.setText("Cédula");

        tel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tel1.setForeground(new java.awt.Color(166, 187, 63));
        tel1.setText("Teléfono");

        tel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tel2.setForeground(new java.awt.Color(166, 187, 63));
        tel2.setText("Teléfono 2");

        sec.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sec.setForeground(new java.awt.Color(166, 187, 63));
        sec.setText("Sección ");

        con.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        con.setForeground(new java.awt.Color(166, 187, 63));
        con.setText("Contraseña");

        jTextFieldCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldConActionPerformed(evt);
            }
        });

        jRadioButtonMon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonMon.setForeground(new java.awt.Color(166, 187, 63));
        jRadioButtonMon.setText("Monitoreo");
        jRadioButtonMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMonActionPerformed(evt);
            }
        });

        jRadioButtonInv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonInv.setForeground(new java.awt.Color(166, 187, 63));
        jRadioButtonInv.setText("Investigación");

        confirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        confirmar.setForeground(new java.awt.Color(166, 187, 63));
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelar.setForeground(new java.awt.Color(166, 187, 63));
        cancelar.setText("Cancelar");

        ema.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ema.setForeground(new java.awt.Color(166, 187, 63));
        ema.setText("e-mail");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(166, 187, 63));
        jLabel1.setText("Agregar Estudiante");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nom)
                                        .addComponent(ape)
                                        .addComponent(ced)
                                        .addComponent(tel1)
                                        .addComponent(tel2)
                                        .addComponent(sec))
                                    .addGap(88, 88, 88))
                                .addComponent(jRadioButtonInv, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(ema)
                            .addComponent(con))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNom)
                            .addComponent(jTextFieldApe)
                            .addComponent(jTextFieldCed)
                            .addComponent(jTextFieldTel1)
                            .addComponent(jTextFieldTel2)
                            .addComponent(jTextFieldCon)
                            .addComponent(jComboBoxSec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jRadioButtonMon))
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ape)
                    .addComponent(jTextFieldApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ced)
                    .addComponent(jTextFieldCed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tel1)
                    .addComponent(jTextFieldTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tel2)
                    .addComponent(jTextFieldTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sec)
                    .addComponent(jComboBoxSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ema)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(con)
                    .addComponent(jTextFieldCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonMon)
                    .addComponent(jRadioButtonInv))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmar)
                    .addComponent(cancelar))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMonActionPerformed

    private void jTextFieldConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldConActionPerformed

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        agregarEstudiante();
    }//GEN-LAST:event_confirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ape;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel ced;
    private javax.swing.JLabel con;
    private javax.swing.JButton confirmar;
    private javax.swing.JLabel ema;
    private javax.swing.JComboBox jComboBoxSec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButtonInv;
    private javax.swing.JRadioButton jRadioButtonMon;
    private javax.swing.JTextField jTextFieldApe;
    private javax.swing.JTextField jTextFieldCed;
    private javax.swing.JTextField jTextFieldCon;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldTel1;
    private javax.swing.JTextField jTextFieldTel2;
    private javax.swing.JLabel nom;
    private javax.swing.JLabel sec;
    private javax.swing.JLabel tel1;
    private javax.swing.JLabel tel2;
    // End of variables declaration//GEN-END:variables
}
