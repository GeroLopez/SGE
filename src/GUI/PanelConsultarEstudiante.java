/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controlador.DAO_Estudiante;
import Modelo.Estudiante;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Genaro López
 */
public class PanelConsultarEstudiante extends javax.swing.JPanel {

    DAO_Estudiante DAOestudiante;
    int tipo;

    /**
     * Creates new form PanelConsultarEstudiante
     *
     * @param tipo tipo de función a realizar 0 para consultar un estudiante 1
     * para desactivar un estudiante.
     */
    public PanelConsultarEstudiante(int tipo) {
        initComponents();
        this.setSize(555, 434);
        jComboBox1.setVisible(false);
        activar.setVisible(false);
        cargarEstudiantes();
        this.tipo = tipo;
        verificarFuncionPanel(tipo);
    }

    /**
     *
     * @param tipo tipo de función a realizar 0 para agregar un estudiante 1
     * para modificar un estudiante.
     */
    public void verificarFuncionPanel(int tipo) {
        if (tipo != 0) {
            activar.setVisible(true);
            boton.setText("Desactivar");
        }
    }

    /**
     * Carga en el jListEstudiantes los estudiantes en la base de datos.
     */
    public void cargarEstudiantes() {
        try {
            DAOestudiante = new DAO_Estudiante();
            DAOestudiante.conexion.conectar();
            DAOestudiante.consultarEstudiantes();
            DAOestudiante.conexion.cerrarConexion();
            jListEstudiantes.removeAll();
            DefaultListModel modelo = new DefaultListModel();
            for (Estudiante estudiante : DAOestudiante.estudiantes) {
                modelo.addElement(estudiante.getNombre().concat(" " + estudiante.getApellido()));
            }
            jListEstudiantes.setModel(modelo);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public String mostrarDatosEstudiante(Estudiante es) {
        String informacion = "\n   Nombre:\t   " + es.getNombre() + " " + es.getApellido() + "\n   "
                + "Cédula:\t   " + es.getCedula() + "\n   Teléfono1:\t   " + es.getTelefono1() + "\n   "
                + "Teléfono2:\t   " + es.getTelefono2() + "\n   e-mail:\t   " + es.getEmail() + "\n   "
                + "Username:\t   " + es.getNombreDeUsuario() + "\n   Dirección:\t   " + es.getDireccion()
                + "\n   Realiza\n   monitoreo:\t   " + ((es.isEsMonitoreo()) ? "si" : "no") + "\n   "
                + "Realiza\n   investigación:\t   " + ((es.isEsInvestigacion()) ? "si" : "no") + "\n   "
                + "Está activo:\t   " + ((es.isActivado()) ? "si" : "no") + "\n   "
                + "Departamento\n   de:\t   " + es.nombreSeccion + "\n   "
                + "Activo desde:\t   " + es.getFechaCreado() + "\n   "
                + "Activo hasta:\t   " + es.getFechaSalida() + "\n";
        return informacion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListEstudiantes = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaInformacion = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox();
        boton = new javax.swing.JButton();
        activar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jListEstudiantes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListEstudiantes.setAlignmentX(1.0F);
        jListEstudiantes.setAlignmentY(1.0F);
        jListEstudiantes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListEstudiantesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListEstudiantes);

        jTextAreaInformacion.setEditable(false);
        jTextAreaInformacion.setColumns(20);
        jTextAreaInformacion.setRows(5);
        jTextAreaInformacion.setBorder(null);
        jScrollPane2.setViewportView(jTextAreaInformacion);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        boton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boton.setForeground(new java.awt.Color(166, 187, 63));
        boton.setText("Ver resumen de actividades");
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });

        activar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        activar.setForeground(new java.awt.Color(166, 187, 63));
        activar.setText("Activar");
        activar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(activar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton)
                    .addComponent(activar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jListEstudiantesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListEstudiantesValueChanged
        try {
            String informacion = mostrarDatosEstudiante(DAOestudiante.estudiantes.get(jListEstudiantes.getSelectedIndex()));
            jTextAreaInformacion.setText(informacion);
        } catch (Exception e) {
            System.out.println("el error al cambiar el indice del  jListEstudiantes " + e.toString());
        }
    }//GEN-LAST:event_jListEstudiantesValueChanged

    public void activar_desactivarEstudiante(int opcion) {
        try {
            if (tipo != 0) {
                int indice = jListEstudiantes.getSelectedIndex();
                int idEstudiante = DAOestudiante.estudiantes.get(jListEstudiantes.getSelectedIndex()).getId();
                DAOestudiante.setId(idEstudiante);
                DAOestudiante.conexion.conectar();
                String resultado = DAOestudiante.activar_desactivarUsuario(opcion);
                DAOestudiante.conexion.cerrarConexion();
                if (resultado.equals("exito")) {
                    JOptionPane.showMessageDialog(this,
                            "Estudiante " + ((opcion == 0) ? "activado" : "desactivado") + " con éxito", "Éxito en la inserción", JOptionPane.INFORMATION_MESSAGE);
                    cargarEstudiantes();
                    jListEstudiantes.setSelectedIndex(indice);
                } else {
                    JOptionPane.showMessageDialog(this,
                            resultado.concat("\n por favor verifique."), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed
        if (tipo != 0) {
            activar_desactivarEstudiante(1);
        }
    }//GEN-LAST:event_botonActionPerformed

    private void activarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarActionPerformed
        activar_desactivarEstudiante(0);
    }//GEN-LAST:event_activarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activar;
    private javax.swing.JButton boton;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JList jListEstudiantes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaInformacion;
    // End of variables declaration//GEN-END:variables
}
