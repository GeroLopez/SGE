package GUI;

import Controlador.DAO_Login;

/**
 *
 * @author Genaro López
 */
public class Login extends javax.swing.JFrame {

    /**
     * Constructor del formulario
     */
    public Login() {
        initComponents();
        etiquetaError.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/recursos/icono2.png")).getImage());
        this.setTitle("Sistema de gestión de entradas de investigación SGE");
        this.getContentPane().setBackground(java.awt.Color.white);
        this.panelBanner1.setFondo(new javax.swing.ImageIcon(getClass().getResource("/recursos/banner.png")));
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLogo = new javax.swing.JLabel();
        jPanelLogin = new javax.swing.JPanel();
        usuario = new javax.swing.JTextField();
        jButtonEntrar = new javax.swing.JButton();
        jLabelContraseña = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        contraseña = new javax.swing.JPasswordField();
        panelBanner1 = new GUI.PanelBanner();
        etiquetaError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icono.png"))); // NOI18N

        jPanelLogin.setBackground(new java.awt.Color(255, 255, 255));

        usuario.setToolTipText("Número de cédula");

        jButtonEntrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonEntrar.setForeground(new java.awt.Color(166, 187, 63));
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        jLabelContraseña.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelContraseña.setForeground(new java.awt.Color(166, 187, 63));
        jLabelContraseña.setText("Contraseña");

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(166, 187, 63));
        jLabelUsuario.setText("Usuario");

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelContraseña, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEntrar)
                            .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jButtonEntrar))
        );

        javax.swing.GroupLayout panelBanner1Layout = new javax.swing.GroupLayout(panelBanner1);
        panelBanner1.setLayout(panelBanner1Layout);
        panelBanner1Layout.setHorizontalGroup(
            panelBanner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBanner1Layout.setVerticalGroup(
            panelBanner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        etiquetaError.setBackground(new java.awt.Color(255, 255, 255));
        etiquetaError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        etiquetaError.setForeground(new java.awt.Color(255, 0, 0));
        etiquetaError.setText("Error en los datos de inicio de sesión");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etiquetaError)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(panelBanner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBanner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLogo)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaError)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        entrar();
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    /**
     * Verifica que los datos para el inicio sean validos, y realiza la petición
     * para el inicio de sesión.
     */
    public void entrar() {
        try {
            int cedula = Integer.parseInt(usuario.getText());
            String password = contraseña.getText();
            DAO_Login login = new DAO_Login(cedula, password);
            login.conexion.conectar();
            int tipoUsuario = login.login();
            login.conexion.cerrarConexion();
            if (tipoUsuario == 2) {
                RegistroEntradasInvestigacion entradas = new RegistroEntradasInvestigacion();
                entradas.setVisible(true);
                this.dispose();
            } else if (tipoUsuario == 1) {
                Administracion admin = new Administracion();
                admin.setVisible(true);
                this.dispose();
            } else {
                limpiarCampos();
            }
        } catch (NumberFormatException e) {
            limpiarCampos();
        }
    }

    public void limpiarCampos() {
        etiquetaError.setVisible(true);
        usuario.setText("");
        contraseña.setText("");
    }

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JLabel etiquetaError;
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelLogin;
    private GUI.PanelBanner panelBanner1;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
