package GUI;

import Controlador.DAO_Turno;
import Modelo.HiloReloj;
import Modelo.Turno;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Genaro López jLabelReloj
 */
public class RegistroEntradasInvestigacion extends javax.swing.JFrame {

    private final HiloReloj reloj;

    /**
     * Creates new form RegistroEntradasInvestigacion
     */
    public RegistroEntradasInvestigacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/recursos/icono2.png")).getImage());
        this.setTitle("Sistema de gestión de entradas de investigación SGE");
        this.getContentPane().setBackground(java.awt.Color.white);
        this.setResizable(false);
        reloj = new HiloReloj(jLabelReloj);
        reloj.start();
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es"));
        jFecha.setText(formateador.format(reloj.getCalendario().getTime()).toUpperCase());
        cargarTurnosTabla(false, tabla);
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
        jLabelReloj = new javax.swing.JLabel();
        jLabelEntradas = new javax.swing.JLabel();
        jFecha = new javax.swing.JLabel();
        iniciarEntrada = new javax.swing.JButton();
        terminarEntrada = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelBanner1.setMaximumSize(new java.awt.Dimension(510, 100));

        jLabelReloj.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelReloj.setForeground(new java.awt.Color(255, 255, 255));
        jLabelReloj.setText("jLabel1");

        jLabelEntradas.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEntradas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelEntradas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEntradas.setText("Entradas");

        jFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jFecha.setForeground(new java.awt.Color(255, 255, 255));
        jFecha.setText("jLabel1");

        javax.swing.GroupLayout panelBanner1Layout = new javax.swing.GroupLayout(panelBanner1);
        panelBanner1.setLayout(panelBanner1Layout);
        panelBanner1Layout.setHorizontalGroup(
            panelBanner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBanner1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelEntradas)
                .addGap(79, 79, 79)
                .addGroup(panelBanner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelReloj)
                    .addComponent(jFecha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBanner1Layout.setVerticalGroup(
            panelBanner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBanner1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(panelBanner1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEntradas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFecha)
                .addContainerGap())
        );

        iniciarEntrada.setText("Iniciar Entrada");
        iniciarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarEntradaActionPerformed(evt);
            }
        });

        terminarEntrada.setText("Terminar Entrada");
        terminarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarEntradaActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Hora inicio", "Hora fin", "Duración (min)", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setColumnSelectionAllowed(true);
        tabla.setEnabled(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla);
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        cerrar.setText("Cerrar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBanner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(iniciarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(terminarEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cerrar)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBanner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iniciarEntrada)
                    .addComponent(terminarEntrada)
                    .addComponent(cerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        reloj.setContinuar(false);
    }//GEN-LAST:event_formWindowClosing

    private void iniciarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarEntradaActionPerformed
        mostrarVentanaDatos(0);
        cargarTurnosTabla(false, tabla);
    }//GEN-LAST:event_iniciarEntradaActionPerformed

    private void terminarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarEntradaActionPerformed
        mostrarVentanaDatos(1);
        cargarTurnosTabla(false, tabla);
    }//GEN-LAST:event_terminarEntradaActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        reloj.setContinuar(false);
        System.exit(0);
    }//GEN-LAST:event_cerrarActionPerformed

    public void cargarTurnosTabla(boolean sentenciaCompleta, JTable tabla) {
        DAO_Turno turno = new DAO_Turno();
        turno.consultarTurnos(sentenciaCompleta);
        turno.cargarTurnosTabla(sentenciaCompleta, tabla);
    }

    public void mostrarVentanaDatos(int tipoVentana) {
        FormDatosInicioTurno ventanaDatos = new FormDatosInicioTurno(this, true, tipoVentana);
        ventanaDatos.setVisible(true);
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
            java.util.logging.Logger.getLogger(RegistroEntradasInvestigacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroEntradasInvestigacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroEntradasInvestigacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroEntradasInvestigacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroEntradasInvestigacion().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar;
    private javax.swing.JButton iniciarEntrada;
    private javax.swing.JLabel jFecha;
    private javax.swing.JLabel jLabelEntradas;
    private javax.swing.JLabel jLabelReloj;
    private javax.swing.JScrollPane jScrollPane2;
    private GUI.PanelBanner panelBanner1;
    private javax.swing.JTable tabla;
    private javax.swing.JButton terminarEntrada;
    // End of variables declaration//GEN-END:variables
}
