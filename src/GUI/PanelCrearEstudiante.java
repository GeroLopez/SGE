package GUI;

import Controlador.DAO_Estudiante;
import Controlador.DAO_Seccion;
import Modelo.Seccion;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Genaro López
 */
public class PanelCrearEstudiante extends javax.swing.JPanel {

    int tipo;
    int idEstudianteActualizar;

    /**
     * Creates new form PanelCrearEstudiante
     *
     * @param tipo tipo de función a realizar 0 para agregar un estudiante 1
     * para modificar un estudiante.
     */
    public PanelCrearEstudiante(int tipo) {
        initComponents();
        this.tipo = tipo;
        this.setSize(552, 411);
        cargarSeccionesCombo();
        verificarFuncionPanel(tipo);

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
     * Carga desde la base de datos las cédulas de los estudiantes en el
     * jComboBox jComboBoxCedulas.
     */
    public void cargarCedulas() {
        jComboBoxCedulas.removeAllItems();
        try {
            LinkedList<Integer> cedulas;
            DAO_Estudiante DAOestudiante = new DAO_Estudiante();
            DAOestudiante.conexion.conectar();
            cedulas = DAOestudiante.consultarCedulas();
            DAOestudiante.conexion.cerrarConexion();

            for (Integer cedula : cedulas) {
                jComboBoxCedulas.addItem(cedula);
            }
        } catch (Exception e) {
            System.out.println("es por aca " + e.toString());
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
        jTextFieldDir.setText("");
        contra.setText("");
        jTextFieldTel1.setText("");
        jTextFieldTel2.setText("");
    }

    /**
     * Agrega el estudiante a la base de datos.
     */
    public void agregarEstudiante() {
        try {
            String nombre;
            String apellido;
            String contraseña;
            String email;
            String direccion = jTextFieldDir.getText();
            long cedula;
            long telefono1 = 0;
            long telefono2 = -1;
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
                    if (!contra.getText().equals("")) {
                        contraseña = contra.getText();
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
                                        telefono1 = Long.parseLong(jTextFieldTel1.getText());
                                        tel1.setForeground(new Color(166, 187, 63));
                                    } catch (Exception e) {
                                        jTextFieldTel1.setText("");
                                        tel1.setForeground(Color.red);
                                    }
                                }
                                if (!jTextFieldTel2.getText().equals("")) {
                                    try {
                                        telefono2 = Long.parseLong(jTextFieldTel2.getText());
                                        tel2.setForeground(new Color(166, 187, 63));
                                    } catch (Exception e) {
                                        jTextFieldTel2.setText("");
                                        tel2.setForeground(Color.red);
                                    }
                                }
                                try {
                                    cedula = Long.parseLong(jTextFieldCed.getText());
                                    ced.setForeground(new Color(166, 187, 63));
                                    Timestamp fecha2;
                                    fecha2 = new Timestamp(new java.util.Date().getTime());
                                    DAO_Estudiante estudiante;
                                    estudiante = new DAO_Estudiante(cedula, nombre, apellido,
                                            telefono1, 2, seccion, fecha2.toString(), email, contraseña);
                                    if (telefono2 != -1) {
                                        estudiante.setTelefono2(telefono2);
                                    } else {
                                        estudiante.setTelefono2(telefono1);
                                    }
                                    String usuario;
                                    usuario = nombre.substring(0, 1).concat(apellido.split(" ")[0]).concat(fecha2.toString().substring(0, 10));
                                    estudiante.setNombreDeUsuario(usuario);
                                    estudiante.setEsMonitoreo(monitoreo);
                                    estudiante.setEsInvestigacion(investigacion);
                                    estudiante.setDireccion(direccion);
                                    //aca va el llamado al método del DAO
                                    estudiante.conexion.conectar();

                                    String resultado;
                                    if (tipo == 0) {
                                        resultado = estudiante.AgregarEstudiante();
                                    } else {
                                        estudiante.setId(idEstudianteActualizar);
                                        resultado = estudiante.actualizarEstudiante();
                                        cargarCedulas();
                                    }
                                    estudiante.conexion.cerrarConexion();
                                    if (resultado.equals("exito")) {
                                        limpiar();
                                        JOptionPane.showMessageDialog(this,
                                                "Estudiante "+((tipo==0)?"agregado":"actualizado")+" con éxito", "Éxito en la inserción", JOptionPane.INFORMATION_MESSAGE);
                                    } else {
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

    public void cargarDatosModificar(int cedulaConsultar) {
        DAO_Estudiante estudiante = new DAO_Estudiante();
        estudiante.conexion.conectar();
        estudiante.cargarEstudianteActualizar(cedulaConsultar);
        estudiante.conexion.cerrarConexion();

        jTextFieldNom.setText(estudiante.getNombre());
        jTextFieldApe.setText(estudiante.getApellido());
        jTextFieldCed.setText("" + estudiante.getCedula());
        jTextFieldTel1.setText("" + estudiante.getTelefono1());
        jTextFieldTel2.setText("" + estudiante.getTelefono2());
        jTextFieldDir.setText(estudiante.getDireccion());
        jComboBoxSec.setSelectedIndex(estudiante.getSeccion() - 1);
        jTextFieldEmail.setText(estudiante.getEmail());
        contra.setText(estudiante.getPassword());
        jRadioButtonMon.setSelected(estudiante.isEsMonitoreo());
        jRadioButtonInv.setSelected(estudiante.isEsInvestigacion());
        idEstudianteActualizar = estudiante.getId();
    }

    /**
     *
     * @param tipo tipo de función a realizar 0 para agregar un estudiante 1
     * para modificar un estudiante.
     */
    public void verificarFuncionPanel(int tipo) {
        if (tipo == 0) {
            jLabelCedAct.setVisible(false);
            jComboBoxCedulas.setVisible(false);
        } else {
            jLabelTitulo.setText("Actualizar Estudiante");
            boton.setText("Actualizar");
            cargarCedulas();
            int cedulaConsultar = Integer.parseInt(jComboBoxCedulas.getItemAt(jComboBoxCedulas.getSelectedIndex()).toString());
            cargarDatosModificar(cedulaConsultar);
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
        jRadioButtonMon = new javax.swing.JRadioButton();
        jRadioButtonInv = new javax.swing.JRadioButton();
        boton = new javax.swing.JButton();
        ema = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelTitulo = new javax.swing.JLabel();
        dir = new javax.swing.JLabel();
        jTextFieldDir = new javax.swing.JTextField();
        jLabelCedAct = new javax.swing.JLabel();
        jComboBoxCedulas = new javax.swing.JComboBox();
        contra = new javax.swing.JPasswordField();

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

        boton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boton.setForeground(new java.awt.Color(166, 187, 63));
        boton.setText("Confirmar");
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });

        ema.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ema.setForeground(new java.awt.Color(166, 187, 63));
        ema.setText("e-mail");

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(166, 187, 63));
        jLabelTitulo.setText("Agregar Estudiante");

        dir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dir.setForeground(new java.awt.Color(166, 187, 63));
        dir.setText("Dirección");

        jTextFieldDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDirActionPerformed(evt);
            }
        });

        jLabelCedAct.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelCedAct.setText("Seleccione la cédula del estudiante a actualizar");

        jComboBoxCedulas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCedulasItemStateChanged(evt);
            }
        });
        jComboBoxCedulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCedulasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nom)
                                    .addComponent(ape)
                                    .addComponent(ced)
                                    .addComponent(tel1)
                                    .addComponent(tel2))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNom)
                                    .addComponent(jTextFieldApe)
                                    .addComponent(jTextFieldCed)
                                    .addComponent(jTextFieldTel1)
                                    .addComponent(jTextFieldTel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelCedAct))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxCedulas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sec)
                                            .addComponent(dir))
                                        .addGap(31, 31, 31))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(con)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(ema)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxSec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(jTextFieldDir)
                                    .addComponent(contra)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jRadioButtonInv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(jRadioButtonMon)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabelTitulo)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dir)
                    .addComponent(jTextFieldDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ape)
                    .addComponent(jTextFieldApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sec)
                    .addComponent(jComboBoxSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ced)
                    .addComponent(jTextFieldCed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ema)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tel1)
                    .addComponent(jTextFieldTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(con)
                    .addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tel2)
                    .addComponent(jTextFieldTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonInv)
                    .addComponent(jRadioButtonMon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton)
                    .addComponent(jLabelCedAct)
                    .addComponent(jComboBoxCedulas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMonActionPerformed

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed
        agregarEstudiante();
    }//GEN-LAST:event_botonActionPerformed

    private void jTextFieldDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDirActionPerformed

    private void jComboBoxCedulasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCedulasItemStateChanged

    }//GEN-LAST:event_jComboBoxCedulasItemStateChanged

    private void jComboBoxCedulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCedulasActionPerformed
        try {
            int cedulaConsultar = Integer.parseInt(jComboBoxCedulas.getItemAt(jComboBoxCedulas.getSelectedIndex()).toString());
            cargarDatosModificar(cedulaConsultar);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jComboBoxCedulasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ape;
    private javax.swing.JButton boton;
    private javax.swing.JLabel ced;
    private javax.swing.JLabel con;
    private javax.swing.JPasswordField contra;
    private javax.swing.JLabel dir;
    private javax.swing.JLabel ema;
    private javax.swing.JComboBox jComboBoxCedulas;
    private javax.swing.JComboBox jComboBoxSec;
    private javax.swing.JLabel jLabelCedAct;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JRadioButton jRadioButtonInv;
    private javax.swing.JRadioButton jRadioButtonMon;
    private javax.swing.JTextField jTextFieldApe;
    private javax.swing.JTextField jTextFieldCed;
    private javax.swing.JTextField jTextFieldDir;
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
