/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanasParaAdmin;

import conexionPostsgresql.conexion;
import conexionPostsgresql.crud;
import conexionPostsgresql.encrypt;
import getset.variables;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 */
public class AltaOperador extends javax.swing.JFrame {

    /**
     * Creates new form AltaOperador
     */
    FondoPanel fondo = new FondoPanel();

    public AltaOperador() {

        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        matriculaOperador_txt.requestFocus();
        setIconImage(getIconImage());

    }
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource ("imagenes/TERMINADO.png"));
        return retValue;
    }

    public void limpiar() {
        matriculaOperador_txt.setText(null);
        grado_opera_txt.setText(null);
        nombreOperador_txt.setText(null);
        apellidosOpera_txt.setText(null);
        contrasena_txt.setText(null);
        empleo_opera_txt.setText(null);
    }
    crud objcrud = new crud();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        altaOperador_lb = new javax.swing.JLabel();
        matricula_lb = new javax.swing.JLabel();
        matriculaOperador_txt = new javax.swing.JTextField();
        nombre_lb = new javax.swing.JLabel();
        nombreOperador_txt = new javax.swing.JTextField();
        areadetrabajo_lb = new javax.swing.JLabel();
        grado_opera_txt = new javax.swing.JTextField();
        contraseña_lb = new javax.swing.JLabel();
        contrasena_txt = new javax.swing.JTextField();
        cancelar_btn = new javax.swing.JButton();
        agregarOperador_btn = new javax.swing.JButton();
        nombre_lb1 = new javax.swing.JLabel();
        apellidosOpera_txt = new javax.swing.JTextField();
        empleo_opera_txt = new javax.swing.JTextField();
        empleo_opera_lb = new javax.swing.JLabel();
        login_btn = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        altaOperador_lb.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        altaOperador_lb.setText("ALTA DE OPERADOR");
        jPanel1.add(altaOperador_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        matricula_lb.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        matricula_lb.setText("MATRICULA:");
        jPanel1.add(matricula_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        matriculaOperador_txt.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        matriculaOperador_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaOperador_txtActionPerformed(evt);
            }
        });
        jPanel1.add(matriculaOperador_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 272, 31));

        nombre_lb.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        nombre_lb.setText("APELLIDOS:");
        jPanel1.add(nombre_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        nombreOperador_txt.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        nombreOperador_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreOperador_txtActionPerformed(evt);
            }
        });
        jPanel1.add(nombreOperador_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 272, 31));

        areadetrabajo_lb.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        areadetrabajo_lb.setText("GRADO:");
        jPanel1.add(areadetrabajo_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        grado_opera_txt.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        grado_opera_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grado_opera_txtActionPerformed(evt);
            }
        });
        jPanel1.add(grado_opera_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 272, 31));

        contraseña_lb.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        contraseña_lb.setText("CONTRASEÑA:");
        jPanel1.add(contraseña_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        contrasena_txt.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        contrasena_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasena_txtActionPerformed(evt);
            }
        });
        jPanel1.add(contrasena_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 270, 31));

        cancelar_btn.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        cancelar_btn.setText("CANCELAR");
        cancelar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_btnActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 203, -1));

        agregarOperador_btn.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        agregarOperador_btn.setText("AÑADIR OPERADOR");
        agregarOperador_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarOperador_btnActionPerformed(evt);
            }
        });
        jPanel1.add(agregarOperador_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, -1));

        nombre_lb1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        nombre_lb1.setText("NOMBRE:");
        jPanel1.add(nombre_lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        apellidosOpera_txt.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        apellidosOpera_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidosOpera_txtActionPerformed(evt);
            }
        });
        jPanel1.add(apellidosOpera_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 270, 31));

        empleo_opera_txt.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        empleo_opera_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleo_opera_txtActionPerformed(evt);
            }
        });
        jPanel1.add(empleo_opera_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 272, 31));

        empleo_opera_lb.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        empleo_opera_lb.setText("EMPLEO:");
        jPanel1.add(empleo_opera_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        login_btn.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        login_btn.setText("Inicio");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EMBEBIDOS © ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(login_btn)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(login_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void cancelar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_btnActionPerformed
            // TODO add your handling code here:
            Menu_administrador menuAdministrador = new Menu_administrador();
            menuAdministrador.setVisible(true);
            menuAdministrador.setLocationRelativeTo(null);
            this.setVisible(false);
        }//GEN-LAST:event_cancelar_btnActionPerformed

        private void agregarOperador_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarOperador_btnActionPerformed
            encrypt encript = new encrypt();
            if (matriculaOperador_txt.getText().equals("")
                    || grado_opera_txt.getText().equals("")
                    || nombreOperador_txt.getText().equals("")
                    || apellidosOpera_txt.getText().equals("")
                    || contrasena_txt.getText().equals("") || empleo_opera_txt.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debes llenar todos los campos");
            } else {
                objcrud.insertar(matriculaOperador_txt.getText(), grado_opera_txt.getText(), empleo_opera_txt.getText(), nombreOperador_txt.getText(), apellidosOpera_txt.getText(), encript.getAES(contrasena_txt.getText()));
                limpiar();
            }

        }//GEN-LAST:event_agregarOperador_btnActionPerformed

    crud crud = new crud();
    variables var = new variables();

    private void matriculaOperador_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaOperador_txtActionPerformed
        grado_opera_txt.requestFocus();
    }//GEN-LAST:event_matriculaOperador_txtActionPerformed

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        LoginAdministrador login = new LoginAdministrador();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_login_btnActionPerformed

    private void grado_opera_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grado_opera_txtActionPerformed
        empleo_opera_txt.requestFocus();
    }//GEN-LAST:event_grado_opera_txtActionPerformed

    private void empleo_opera_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleo_opera_txtActionPerformed
        nombreOperador_txt.requestFocus();
    }//GEN-LAST:event_empleo_opera_txtActionPerformed

    private void nombreOperador_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreOperador_txtActionPerformed
        apellidosOpera_txt.requestFocus();
    }//GEN-LAST:event_nombreOperador_txtActionPerformed

    private void apellidosOpera_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidosOpera_txtActionPerformed
        contrasena_txt.requestFocus();
    }//GEN-LAST:event_apellidosOpera_txtActionPerformed

    private void contrasena_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasena_txtActionPerformed
        agregarOperador_btn.requestFocus();
        agregarOperador_btn.doClick();
    }//GEN-LAST:event_contrasena_txtActionPerformed

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
            java.util.logging.Logger.getLogger(AltaOperador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaOperador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaOperador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaOperador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaOperador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarOperador_btn;
    private javax.swing.JLabel altaOperador_lb;
    private javax.swing.JTextField apellidosOpera_txt;
    private javax.swing.JLabel areadetrabajo_lb;
    private javax.swing.JButton cancelar_btn;
    private javax.swing.JTextField contrasena_txt;
    private javax.swing.JLabel contraseña_lb;
    private javax.swing.JLabel empleo_opera_lb;
    private javax.swing.JTextField empleo_opera_txt;
    private javax.swing.JTextField grado_opera_txt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton login_btn;
    private javax.swing.JTextField matriculaOperador_txt;
    private javax.swing.JLabel matricula_lb;
    private javax.swing.JTextField nombreOperador_txt;
    private javax.swing.JLabel nombre_lb;
    private javax.swing.JLabel nombre_lb1;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/b.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }
}