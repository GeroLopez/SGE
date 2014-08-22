/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controlador.DAO_Turno;
import javax.swing.JOptionPane;

/**
 *
 * @author Genaro López
 */
public class FormDatosInicioTurno extends javax.swing.JDialog {

    private static int tipo;

    /**
     * Creates new form FormDatosInicioTurno
     *
     * @param parent
     * @param modal
     * @param tipo
     */
    public FormDatosInicioTurno(java.awt.Frame parent, boolean modal, int tipo) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(java.awt.Color.white);
        this.tipo = tipo;
        if (tipo == 0) {
            areaTexto.setEnabled(false);
        } else {
            titulo.setText("Registro fin turno");
        }
    }

    /**
     *
     * @param tipo
     */
    public void decidirTipoFuncio(int tipo) {
        int cedula;
        String password;
        try {
            cedula = Integer.parseInt(usuario.getText());
            password = contraseña.getText();
            DAO_Turno turno = new DAO_Turno();
            if (tipo == 0) {
                turno.conexion.conectar();
                int resultado = turno.agregarTurno(cedula, password);
                turno.conexion.cerrarConexion();
                if (resultado == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Registro éxitoso", "Registro éxitoso", JOptionPane.INFORMATION_MESSAGE);
                } else if (resultado == 1) {
                    JOptionPane.showMessageDialog(rootPane, "Ya tiene un turno activo en este momento", "Error de registro", JOptionPane.ERROR_MESSAGE);
                } else if (resultado == 2) {
                    JOptionPane.showMessageDialog(rootPane, "No tiene permisos de  investigador, solicite el permiso e intentelo de nuevo", "Error de registro", JOptionPane.ERROR_MESSAGE);
                } else if (resultado == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Los datos de usuario no son correctos, verifiquelos e intentelo de nuevo", "Error de registro", JOptionPane.ERROR_MESSAGE);
                }
                limpiarCampos(0);
            } else {
                if (!areaTexto.getText().equals("")) {
                    String descripcionTareas = areaTexto.getText();
                    turno.conexion.conectar();
                    int resultado = turno.cerrarTurno(cedula, password, descripcionTareas);
                    turno.conexion.cerrarConexion();
                    if (resultado == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Turno terminado éxitosamente", "Registro éxitoso", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos(0);

                    } else if (resultado == 1) {
                        JOptionPane.showMessageDialog(rootPane, "No tiene un turno activo en este momento", "Error de registro", JOptionPane.ERROR_MESSAGE);
                    } else if (resultado == -1) {
                        JOptionPane.showMessageDialog(rootPane, "Los datos de usuario no son correctos, verifiquelos e intentelo de nuevo", "Error de registro", JOptionPane.ERROR_MESSAGE);
                    }
                    limpiarCampos(1);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Es necesario que de una descripción de que tareas realizó en el turno", "Petición de descripción", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Error los datos no son correctos", "Error de registro", JOptionPane.ERROR_MESSAGE);
            limpiarCampos(1);
        }
    }

    public void limpiarCampos(int tipo) {
        usuario.setText("");
        contraseña.setText("");
        if (tipo == 0) {
            areaTexto.setText("");
            this.dispose();
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

        titulo = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        jLabelContraseña = new javax.swing.JLabel();
        contraseña = new javax.swing.JPasswordField();
        descripcion = new javax.swing.JLabel();
        confirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(166, 187, 63));
        titulo.setText("Registro inicio turno");
        titulo.setPreferredSize(new java.awt.Dimension(15, 30));

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(166, 187, 63));
        jLabelUsuario.setText("Usuario");

        usuario.setToolTipText("Número de cédula");

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        jLabelContraseña.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelContraseña.setForeground(new java.awt.Color(166, 187, 63));
        jLabelContraseña.setText("Contraseña");

        descripcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        descripcion.setForeground(new java.awt.Color(166, 187, 63));
        descripcion.setText("Descripción de tareas realizadas");

        confirmar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        confirmar.setForeground(new java.awt.Color(166, 187, 63));
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(contraseña)
                        .addComponent(descripcion)
                        .addComponent(jLabelUsuario)
                        .addComponent(jLabelContraseña)
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(confirmar, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelContraseña)
                .addGap(11, 11, 11)
                .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(confirmar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        decidirTipoFuncio(tipo);
    }//GEN-LAST:event_confirmarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormDatosInicioTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDatosInicioTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDatosInicioTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDatosInicioTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormDatosInicioTurno dialog = new FormDatosInicioTurno(new javax.swing.JFrame(), true, tipo);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton confirmar;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
