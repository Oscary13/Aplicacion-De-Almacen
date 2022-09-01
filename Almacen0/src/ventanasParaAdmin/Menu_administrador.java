/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanasParaAdmin;

import conexionPostsgresql.crud;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 */
public class Menu_administrador extends javax.swing.JFrame {

    /**
     * Creates new form Menu_administrador
     */
    FondoPanel fondo = new FondoPanel();

    public Menu_administrador() {

        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        LoginAdministrador login = new LoginAdministrador();
        titulo0_lb.setText(login.nombreAdmin + " " + login.apellidosAdmin);
        System.out.println(login.gradoAdmin);
        System.out.println(login.matriculaAdmin);
        System.out.println(login.empleoAdmin);
        setIconImage(getIconImage());

    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/TERMINADO.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        altaOperador_btn = new javax.swing.JButton();
        cambiarContra_btn = new javax.swing.JButton();
        consultaOperador_btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        titulo0_lb1 = new javax.swing.JLabel();
        titulo0_lb = new javax.swing.JLabel();
        login_btn = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        altaOperador_btn.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        altaOperador_btn.setText("ALTA DE OPERADOR");
        altaOperador_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaOperador_btnActionPerformed(evt);
            }
        });

        cambiarContra_btn.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        cambiarContra_btn.setText("ACTUALIZAR DATOS DE OPERADOR");
        cambiarContra_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarContra_btnActionPerformed(evt);
            }
        });

        consultaOperador_btn.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        consultaOperador_btn.setText("CONSULTA DE OPERADOR");
        consultaOperador_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaOperador_btnActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo0_lb1.setBackground(new java.awt.Color(51, 51, 0));
        titulo0_lb1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        titulo0_lb1.setText("BIENVENIDO AL ALMACEN :");
        jPanel1.add(titulo0_lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, -1));

        titulo0_lb.setBackground(new java.awt.Color(51, 51, 0));
        titulo0_lb.setFont(new java.awt.Font("Impact", 0, 25)); // NOI18N
        titulo0_lb.setText("admin");
        jPanel1.add(titulo0_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 8, 300, 50));

        login_btn.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        login_btn.setText("Inicio");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });
        jPanel1.add(login_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EMBEBIDOS © ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(altaOperador_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(consultaOperador_btn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cambiarContra_btn)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(altaOperador_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(consultaOperador_btn)
                .addGap(97, 97, 97)
                .addComponent(cambiarContra_btn)
                .addGap(28, 28, 28)
                .addComponent(jLabel2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void altaOperador_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaOperador_btnActionPerformed
            // TODO add your handling code here:

            AltaOperador AltaOperador = new AltaOperador();
            AltaOperador.setVisible(true);
            AltaOperador.setLocationRelativeTo(null);
            this.setVisible(false);
        }//GEN-LAST:event_altaOperador_btnActionPerformed

        private void consultaOperador_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaOperador_btnActionPerformed
            ConsultaOperador ConsultaOperador = new ConsultaOperador();
            ConsultaOperador.setVisible(true);
            ConsultaOperador.setLocationRelativeTo(null);
            this.setVisible(false);

// TODO add your handling code here:
        }//GEN-LAST:event_consultaOperador_btnActionPerformed

        private void cambiarContra_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarContra_btnActionPerformed
            // TODO add your handling code here:
            ActualizarDatosOpera actualizarDatosOpera = new ActualizarDatosOpera();
            actualizarDatosOpera.setVisible(true);
            actualizarDatosOpera.setLocationRelativeTo(null);
            actualizarDatosOpera.setLocationRelativeTo(null);
            this.setVisible(false);
        }//GEN-LAST:event_cambiarContra_btnActionPerformed

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        LoginAdministrador login = new LoginAdministrador();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_login_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_administrador().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton altaOperador_btn;
    private javax.swing.JButton cambiarContra_btn;
    private javax.swing.JButton consultaOperador_btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton login_btn;
    public javax.swing.JLabel titulo0_lb;
    public javax.swing.JLabel titulo0_lb1;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/k.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }

}