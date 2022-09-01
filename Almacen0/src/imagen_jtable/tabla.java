/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package imagen_jtable;

import conexionPostsgresql.conexion;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import ventanasParaOpera.MenuOperador;

/**
 *
 * @author Embebidos
 */
public class tabla extends javax.swing.JFrame {

    FileInputStream fis;
    int logitudBytes;

    conexion conexione = new conexion();
    Connection con = conexione.conectar();
    FondoPanel fondo = new FondoPanel();

    public tabla() {
        this.setContentPane(fondo);

        initComponents();
        propiedadesTabla();
        noControlConsulta_txt.requestFocus();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
    }
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource ("imagenes/TERMINADO.png"));
        return retValue;
    }

    private void propiedadesTabla() {
        tabla_prueba.setDefaultRenderer(Object.class, new imagenTable());
        String titulos[] = {"id", "Nombre", "Descripción", "Cantidad", "Unidad de medida", "Precio", "No. Serie", "No. Control", "Estado", "Codigo de barras", "Ubicación", "Observaciones", "Factura", "Imagen", "QR"};
        DefaultTableModel tm = new DefaultTableModel(null, titulos);

        java.sql.Statement st;
        ResultSet rs;
        ImageIcon foto;
        InputStream is;

        ImageIcon foto2;
        InputStream is2;

        try {
            conexion con = new conexion();
            Connection conexion = con.conectar();
            st = conexion.createStatement();
            String sql = "SELECT * FROM material;";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                is = rs.getBinaryStream(19);
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);

                ImageIcon newicon = new ImageIcon(newimg);

                is2 = rs.getBinaryStream(20);
                BufferedImage bi2 = ImageIO.read(is2);
                foto2 = new ImageIcon(bi2);
                Image img2 = foto2.getImage();
                Image newimg2 = img2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);

                ImageIcon newicon2 = new ImageIcon(newimg2);

                tm.addRow(new Object[]{rs.getString(1), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), "$ " + rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), new JLabel(new ImageIcon(newimg)), new JLabel(new ImageIcon(newimg2))
                });
                tabla_prueba.setRowHeight(100);              
                tabla_prueba.setModel(tm);
                
                //label_imagen.setIcon(newicon);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "exception : " + ex);
            
        }

    }

    private void propiedadesTabla2() {
        tabla_prueba.setDefaultRenderer(Object.class, new imagenTable());
        String titulos[] = {"id", "Nombre", "Descripción", "Cantidad", "Unidad de medida", "Precio", "No. Serie", "No. Control", "Estado", "Codigo de barras", "Ubicación", "Observaciones", "Factura", "Imagen", "QR"};
        DefaultTableModel tm = new DefaultTableModel(null, titulos);

        java.sql.Statement st;
        ResultSet rs;
        ImageIcon foto;
        InputStream is;
        ImageIcon foto2;
        InputStream is2;
        try {
            conexion con = new conexion();
            Connection conexion = con.conectar();
            st = conexion.createStatement();
            String sql = "SELECT * FROM material WHERE cBarras_mate = '" + noControlConsulta_txt.getText() + "';";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                is = rs.getBinaryStream(19);
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);

                is2 = rs.getBinaryStream(20);
                BufferedImage bi2 = ImageIO.read(is2);
                foto2 = new ImageIcon(bi2);
                Image img2 = foto2.getImage();
                Image newimg2 = img2.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);

                ImageIcon newicon2 = new ImageIcon(newimg2);

                ImageIcon newicon = new ImageIcon(newimg);
                tm.addRow(new Object[]{rs.getString(1), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), "$ " + rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), new JLabel(new ImageIcon(newimg)), new JLabel(new ImageIcon(newimg2))
                });
                tabla_prueba.setRowHeight(200);
                //tabla_prueba.getColumn(0).setPreferredWidth(100);
                tabla_prueba.setModel(tm);
                
                //label_imagen.setIcon(newicon);

            }
            if (rs.next()) {
                
            } else {
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "exception : " + ex);
            JOptionPane.showMessageDialog(null, "El registro no existe", "Sin registro", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_prueba = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ingresaMatricula_lb = new javax.swing.JLabel();
        noControlConsulta_txt = new javax.swing.JTextField();
        cancelar_btn = new javax.swing.JButton();
        buscar_btn = new javax.swing.JButton();
        mostrarTodos_txt = new javax.swing.JButton();
        btn_refrescar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla_prueba.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_prueba.setEnabled(false);
        jScrollPane1.setViewportView(tabla_prueba);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("CONSULTA DE MATERIALES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        ingresaMatricula_lb.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        ingresaMatricula_lb.setText("Ingresa el \"codigo de barras\" del Material a consultar: ");
        jPanel1.add(ingresaMatricula_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 550, 30));

        noControlConsulta_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noControlConsulta_txtActionPerformed(evt);
            }
        });
        jPanel1.add(noControlConsulta_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 315, 30));

        cancelar_btn.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        cancelar_btn.setText("CANCELAR");
        cancelar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_btnActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        buscar_btn.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        buscar_btn.setText("BUSCAR");
        buscar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_btnActionPerformed(evt);
            }
        });
        jPanel1.add(buscar_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        mostrarTodos_txt.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        mostrarTodos_txt.setText("MOSTRAR TODOS");
        mostrarTodos_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTodos_txtActionPerformed(evt);
            }
        });
        jPanel1.add(mostrarTodos_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        btn_refrescar.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        btn_refrescar.setText("ACTUALIZAR");
        btn_refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refrescarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_refrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 170, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EMBEBIDOS © ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(337, 337, 337)))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refrescarActionPerformed
        propiedadesTabla();

// TODO add your handling code here:
    }//GEN-LAST:event_btn_refrescarActionPerformed

    private void noControlConsulta_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noControlConsulta_txtActionPerformed
        buscar_btn.requestFocus();
        buscar_btn.doClick();
    }//GEN-LAST:event_noControlConsulta_txtActionPerformed

    private void cancelar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_btnActionPerformed
        // TODO add your handling code here:
        MenuOperador menuOperador = new MenuOperador();
        menuOperador.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelar_btnActionPerformed

    private void buscar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_btnActionPerformed
        //variables var = new variables();
        if (noControlConsulta_txt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingresa una matricula");
        } else {
            propiedadesTabla2();

        }

    }//GEN-LAST:event_buscar_btnActionPerformed

    private void mostrarTodos_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTodos_txtActionPerformed
        propiedadesTabla();
        noControlConsulta_txt.setText(null);
    }//GEN-LAST:event_mostrarTodos_txtActionPerformed

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
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_refrescar;
    private javax.swing.JButton buscar_btn;
    private javax.swing.JButton cancelar_btn;
    private javax.swing.JLabel ingresaMatricula_lb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mostrarTodos_txt;
    private javax.swing.JTextField noControlConsulta_txt;
    private javax.swing.JTable tabla_prueba;
    // End of variables declaration//GEN-END:variables
class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/c.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }
}
