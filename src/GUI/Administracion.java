package GUI;

/**
 *
 * @author Genaro López
 */
public class Administracion extends javax.swing.JFrame {

    PanelCrearEstudiante crearEstudiante;
    PanelConsultarEstudiante consul;
    PanelEditarTurnos editarTurnos;
    int panelActual;

    /**
     * Creates new form Administracion
     */
    public Administracion() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(570, 500);
        this.setResizable(false);
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/recursos/icono2.png")).getImage());
        this.setTitle("Sistema de gestión de entradas de investigación SGE");
        this.getContentPane().setBackground(java.awt.Color.white);
        panelActual = -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBanner1 = new GUI.PanelBanner();
        titulo = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        configuracion = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        gestionarEstudiante = new javax.swing.JMenu();
        agregarEstudiante = new javax.swing.JMenuItem();
        consultarEstudiante = new javax.swing.JMenuItem();
        actualizarEstudiante = new javax.swing.JMenuItem();
        desactivarEstudiante = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        editarTurno = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setPreferredSize(new java.awt.Dimension(15, 30));

        javax.swing.GroupLayout panelBanner1Layout = new javax.swing.GroupLayout(panelBanner1);
        panelBanner1.setLayout(panelBanner1Layout);
        panelBanner1Layout.setHorizontalGroup(
            panelBanner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBanner1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panelBanner1Layout.setVerticalGroup(
            panelBanner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBanner1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        archivo.setText("Archivo");

        configuracion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        configuracion.setText("Configuración");
        configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configuracionActionPerformed(evt);
            }
        });
        archivo.add(configuracion);

        salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        salir.setText("Salir");
        archivo.add(salir);

        barraMenu.add(archivo);

        gestionarEstudiante.setText("Gestionar Estudiante");

        agregarEstudiante.setText("Agregar");
        agregarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEstudianteActionPerformed(evt);
            }
        });
        gestionarEstudiante.add(agregarEstudiante);

        consultarEstudiante.setText("Consultar");
        consultarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarEstudianteActionPerformed(evt);
            }
        });
        gestionarEstudiante.add(consultarEstudiante);

        actualizarEstudiante.setText("Actualizar");
        actualizarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarEstudianteActionPerformed(evt);
            }
        });
        gestionarEstudiante.add(actualizarEstudiante);

        desactivarEstudiante.setText("Desactivar");
        desactivarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desactivarEstudianteActionPerformed(evt);
            }
        });
        gestionarEstudiante.add(desactivarEstudiante);

        barraMenu.add(gestionarEstudiante);

        jMenu1.setText("Editar Turno");

        editarTurno.setText("Editar");
        editarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarTurnoActionPerformed(evt);
            }
        });
        jMenu1.add(editarTurno);

        barraMenu.add(jMenu1);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBanner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBanner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 274, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_configuracionActionPerformed

    private void actualizarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarEstudianteActionPerformed
        crearEstudiante(1);
        titulo.setText("Actualizar Estudiante");
    }//GEN-LAST:event_actualizarEstudianteActionPerformed

    private void agregarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEstudianteActionPerformed
        crearEstudiante(0);
        titulo.setText("Agregar Estudiante");
    }//GEN-LAST:event_agregarEstudianteActionPerformed

    private void consultarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarEstudianteActionPerformed
        consultarEst(0);
        titulo.setText("Consultar Estudiante");
    }//GEN-LAST:event_consultarEstudianteActionPerformed

    private void desactivarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desactivarEstudianteActionPerformed
        consultarEst(1);
        titulo.setText("Activar/Desactivar Estudiante");
    }//GEN-LAST:event_desactivarEstudianteActionPerformed

    private void editarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarTurnoActionPerformed
        editarTurno();
        titulo.setText("Editar Turnos Sin Cerrar");
    }//GEN-LAST:event_editarTurnoActionPerformed

    /**
     * Crear el panel donde se despliega la función para agregar estudiantes o
     * para actualizar un estudiante dependiendo del valor del parámetro tipo.
     *
     * @param tipo tipo de función a realizar 0 para agregar un estudiante 1
     * para modificar un estudiante.
     */
    public void crearEstudiante(int tipo) {
        liberarPaneles(0);
        crearEstudiante = new PanelCrearEstudiante(tipo);
        crearEstudiante.setBounds(0, 100, crearEstudiante.getSize().width, crearEstudiante.getSize().height);
        crearEstudiante.setVisible(true);
        this.getContentPane().add(crearEstudiante);
        this.repaint();
    }

    /**
     * Crear el panel donde se despliega la función para consultar estudiantes o
     * para desactivar un estudiante dependiendo del valor del parámetro tipo.
     *
     * @param tipo tipo de función a realizar 0 para consultar un estudiante 1
     * para desactivar un estudiante.
     */
    public void consultarEst(int tipo) {
        liberarPaneles(1);
        consul = new PanelConsultarEstudiante(tipo);
        consul.setBounds(0, 100, consul.getSize().width, consul.getSize().height);
        consul.setVisible(true);
        this.getContentPane().add(consul);
        this.repaint();
    }

    /**
     * Remueve el panel que este desplegado en la pantalla y setea el
     * panelActual con el que se cambia al panel nuevo, esto es para cambiar de
     * visualización entre las opciones de la barra de menú.
     *
     * @param idPanel identificador del panel.
     */
    public void liberarPaneles(int idPanel) {
        if (panelActual != -1) {
            switch (panelActual) {
                case 0:
                    this.remove(crearEstudiante);
                    break;
                case 1:
                    this.remove(consul);
                    break;
                case 2:
                    this.remove(editarTurnos);
                    break;
                case 3:
                    break;
            }
        }
        panelActual = idPanel;
    }

    public void editarTurno() {
        liberarPaneles(2);
        editarTurnos = new PanelEditarTurnos();
        editarTurnos.setBounds(5, 100, editarTurnos.getSize().width, editarTurnos.getSize().height);
        editarTurnos.setVisible(true);
        this.getContentPane().add(editarTurnos);
        this.repaint();
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
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem actualizarEstudiante;
    private javax.swing.JMenuItem agregarEstudiante;
    private javax.swing.JMenu archivo;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem configuracion;
    private javax.swing.JMenuItem consultarEstudiante;
    private javax.swing.JMenuItem desactivarEstudiante;
    private javax.swing.JMenuItem editarTurno;
    private javax.swing.JMenu gestionarEstudiante;
    private javax.swing.JMenu jMenu1;
    private GUI.PanelBanner panelBanner1;
    private javax.swing.JMenuItem salir;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
