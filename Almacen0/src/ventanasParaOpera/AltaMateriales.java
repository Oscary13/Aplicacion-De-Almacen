/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanasParaOpera;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import conexionPostsgresql.conexion;
import conexionPostsgresql.crudMaterial;
import conexionPostsgresql.encrypt;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ventanasParaAdmin.LoginAdministrador;

/**
 *
 * @author Embebidos
 */
public class AltaMateriales extends javax.swing.JFrame {

    FileInputStream fis;
    int logitudBytes;

    FileInputStream fis2;
    int logitudBytes2;
    conexion conexione = new conexion();
    Connection con = conexione.conectar();

    FondoPanel fondo = new FondoPanel();
    LoginAdministrador login = new LoginAdministrador();

    /**
     * Creates new form AltaMateriales
     */
    public AltaMateriales() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        nombre_txt.requestFocus();
        setIconImage(getIconImage());
    }
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource ("imagenes/TERMINADO.png"));
        return retValue;
    }

    public void limpiar() {
        nombre_txt.setText(null);
        descripcion_txt.setText(null);
        cantidad_txt.setText(null);
        unidadMedida_txt.setText(null);
        precio_txt.setText(null);
        noSerie_txt.setText(null);
        noControl_txt.setText(null);
        estadoMaterial_txt.setText(null);
        cantidad_txt.setText(null);
        ubicacion_txt.setText(null);
        observaciones_txt.setText(null);
        factura_txt.setText(null);
        codigoBarras_txt.setText(null);
        lblQR.setIcon(null);
        lb_foto.setIcon(null);
        

    }

    public void generaQR() {
        int size = 1000;
        String FileType = "png";
        DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("yyyy/MM/dd HH:mm:ss-> " + fecha.format(LocalDateTime.now()));

        String nombre = nombre_txt.getText();
        String descripcion = descripcion_txt.getText();
        String cantidad = cantidad_txt.getText();
        String unidadDeMedida = unidadMedida_txt.getText();
        String precio = precio_txt.getText();
        String nSerie = noSerie_txt.getText();
        String nControl = noControl_txt.getText();
        String estadoMaterial = estadoMaterial_txt.getText();
        String codigoBarras = codigoBarras_txt.getText();
        String ubicacion = ubicacion_txt.getText();
        String observaciones = observaciones_txt.getText();
        String factura = factura_txt.getText();
        String fechaI = fecha.format(LocalDateTime.now());

        String codigo = "Nombre: " + nombre + "\n" + " Descripcion: " + descripcion + "\n" + " Cantidad: " + cantidad + "\n"
                + " Unidad De Media: " + unidadDeMedida + "\n" + " Precio: $" + precio + "\n" + " Numero de serie: " + nSerie + "\n"
                + " Numero De Control : " + nControl + "\n" + " Estado de material: " + estadoMaterial + "\n"
                + " Codigo de barras: " + codigoBarras + "\n" + " Ubicacion: " + ubicacion + "\n"
                + " Observaciones: " + observaciones + "\n" + " Factura: " + factura + "\n" + " Fecha: " + fechaI;
        System.out.println(codigo);
        // Elegir la ruta de la imagen
        String filePath = "C:\\Almacen0\\QR";

        // Generar el nombre
        String randonName = nombre_txt.getText() + "_" + codigoBarras_txt.getText();

        // Generar el QR 
        QRCodeWriter qrcode = new QRCodeWriter();
        try {
            BitMatrix matrix = qrcode.encode(codigo, BarcodeFormat.QR_CODE, size, size);
            File f = new File(filePath + "/" + randonName + "." + FileType);
            int matrixWidth = matrix.getWidth();
            BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
            image.createGraphics();

            Graphics2D gd = (Graphics2D) image.getGraphics();
            gd.setColor(Color.WHITE); // Fondo
            gd.fillRect(0, 0, size, size);
            gd.setColor(Color.black); // Qr

            for (int b = 0; b < matrixWidth; b++) {
                for (int j = 0; j < matrixWidth; j++) {
                    if (matrix.get(b, j)) {
                        gd.fillRect(b, j, 1, 1);
                    }
                }
            }

            // Mostrar la imagen generada
            ImageIO.write(image, FileType, f);
            fis2 = new FileInputStream(f.getCanonicalFile());
            this.logitudBytes2 = (int) f.getCanonicalFile().length();
            Image mImagen = new ImageIcon(filePath + "/" + randonName + "." + FileType).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lblQR.getWidth(), lblQR.getHeight(), 0));
            lblQR.setIcon(mIcono);

        } catch (WriterException | IOException ex) {
            Logger.getLogger(AltaMateriales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    crudMaterial crudMaterial = new crudMaterial();
    MenuOperador menuOpera = new MenuOperador();

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        altaMaterial = new javax.swing.JPanel();
        cancelar_btn = new javax.swing.JButton();
        nombre_l = new javax.swing.JLabel();
        nombre_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        descripcion_txt = new javax.swing.JTextField();
        cantidad_l = new javax.swing.JLabel();
        unidadMedida_txt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        precio_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        noSerie_l = new javax.swing.JLabel();
        noSerie_txt = new javax.swing.JTextField();
        noControl_l = new javax.swing.JLabel();
        noControl_txt = new javax.swing.JTextField();
        estadoMaterial_l = new javax.swing.JLabel();
        estadoMaterial_txt = new javax.swing.JTextField();
        codigoBarras_l = new javax.swing.JLabel();
        cantidad_txt = new javax.swing.JTextField();
        ubicacion_txt = new javax.swing.JTextField();
        ubicacion_l = new javax.swing.JLabel();
        observaciones_l = new javax.swing.JLabel();
        observaciones_txt = new javax.swing.JTextField();
        factura_l = new javax.swing.JLabel();
        factura_txt = new javax.swing.JTextField();
        agregarMaterial_btn = new javax.swing.JButton();
        codigoBarras_txt = new javax.swing.JTextField();
        lblQR = new javax.swing.JLabel();
        anadirI_btn = new javax.swing.JButton();
        lb_foto = new javax.swing.JLabel();
        login_btn = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        altaMaterial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancelar_btn.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        cancelar_btn.setText("CANCELAR");
        cancelar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_btnActionPerformed(evt);
            }
        });
        altaMaterial.add(cancelar_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, 40));

        nombre_l.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        nombre_l.setText("NOMBRE:");
        altaMaterial.add(nombre_l, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 70, -1));

        nombre_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_txtActionPerformed(evt);
            }
        });
        altaMaterial.add(nombre_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 120, -1));

        jLabel4.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel4.setText("DESCRIPCIÓN:");
        altaMaterial.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 150, -1));

        descripcion_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcion_txtActionPerformed(evt);
            }
        });
        altaMaterial.add(descripcion_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 150, -1));

        cantidad_l.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        cantidad_l.setText("CANTIDAD:");
        altaMaterial.add(cantidad_l, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        unidadMedida_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidadMedida_txtActionPerformed(evt);
            }
        });
        altaMaterial.add(unidadMedida_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 150, -1));

        jLabel6.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel6.setText("UNIDAD DE MEDIDA:");
        altaMaterial.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        precio_txt.setText(" ");
        precio_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio_txtActionPerformed(evt);
            }
        });
        precio_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precio_txtKeyTyped(evt);
            }
        });
        altaMaterial.add(precio_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 130, -1));

        jLabel8.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel8.setText("PRECIO:");
        altaMaterial.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        noSerie_l.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        noSerie_l.setText("NO. SERIE:");
        altaMaterial.add(noSerie_l, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 110, -1));

        noSerie_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noSerie_txtActionPerformed(evt);
            }
        });
        altaMaterial.add(noSerie_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 120, -1));

        noControl_l.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        noControl_l.setText("NO. CONTROL:");
        altaMaterial.add(noControl_l, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 110, -1));

        noControl_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noControl_txtActionPerformed(evt);
            }
        });
        altaMaterial.add(noControl_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 120, -1));

        estadoMaterial_l.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        estadoMaterial_l.setText("ESTADO DEL MATERIAL:");
        altaMaterial.add(estadoMaterial_l, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 190, -1));

        estadoMaterial_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoMaterial_txtActionPerformed(evt);
            }
        });
        altaMaterial.add(estadoMaterial_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 160, -1));

        codigoBarras_l.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        codigoBarras_l.setText("CODIGO DE BARRAS:");
        altaMaterial.add(codigoBarras_l, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 160, -1));

        cantidad_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad_txtActionPerformed(evt);
            }
        });
        cantidad_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad_txtKeyTyped(evt);
            }
        });
        altaMaterial.add(cantidad_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 120, -1));

        ubicacion_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubicacion_txtActionPerformed(evt);
            }
        });
        altaMaterial.add(ubicacion_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 220, -1));

        ubicacion_l.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        ubicacion_l.setText("UBICACIÓN:");
        altaMaterial.add(ubicacion_l, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 90, -1));

        observaciones_l.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        observaciones_l.setText("OBSERVACIONES: ");
        altaMaterial.add(observaciones_l, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 130, -1));

        observaciones_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observaciones_txtActionPerformed(evt);
            }
        });
        altaMaterial.add(observaciones_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 220, -1));

        factura_l.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        factura_l.setText("FACTURA:");
        altaMaterial.add(factura_l, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 90, -1));

        factura_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factura_txtActionPerformed(evt);
            }
        });
        altaMaterial.add(factura_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 120, -1));

        agregarMaterial_btn.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        agregarMaterial_btn.setText("AÑADIR MATERIAL");
        agregarMaterial_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarMaterial_btnActionPerformed(evt);
            }
        });
        altaMaterial.add(agregarMaterial_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 500, -1, -1));

        codigoBarras_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoBarras_txtActionPerformed(evt);
            }
        });
        altaMaterial.add(codigoBarras_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 160, -1));

        lblQR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        altaMaterial.add(lblQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 210, 190));

        anadirI_btn.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        anadirI_btn.setText("AÑADIR IMAGEN");
        anadirI_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirI_btnActionPerformed(evt);
            }
        });
        altaMaterial.add(anadirI_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 210, -1));

        lb_foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        altaMaterial.add(lb_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 210, 190));

        login_btn.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        login_btn.setText("Inicio");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ALTA DE MATERIAL");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EMBEBIDOS © ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(297, 297, 297)
                        .addComponent(login_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(altaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(login_btn)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(altaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void descripcion_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcion_txtActionPerformed
        cantidad_txt.requestFocus();
    }//GEN-LAST:event_descripcion_txtActionPerformed

    private void agregarMaterial_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarMaterial_btnActionPerformed
        if (nombre_txt.getText().equals("")
                || descripcion_txt.getText().equals("")
                || cantidad_txt.getText().equals("")
                || unidadMedida_txt.getText().equals("")
                || precio_txt.getText().equals("")
                || noSerie_txt.getText().equals("")
                || noControl_txt.getText().equals("")
                || estadoMaterial_txt.getText().equals("")
                || codigoBarras_txt.getText().equals("")
                || ubicacion_txt.getText().equals("")
                || observaciones_txt.getText().equals("")
                || factura_txt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debes llenar todos los campos");
        } else {
            DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            DateTimeFormatter fecha2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            System.out.println("yyyy/MM/dd HH:mm:ss-> " + fecha.format(LocalDateTime.now()));
            System.out.println("yyyy/MM/dd HH:mm:ss-> NUevo " + fecha2.format(LocalDate.now()));

            if (lb_foto.getIcon() == null) {
                JOptionPane.showMessageDialog(this, "Debes llenar todos los campos");
            } else {
                try {
                    
                    String sql = "INSERT INTO material(matricula_opera, grado_opera, nombre_opera, apellidos_opera, fecha_ingreso, nombre_mate, descripcion_mate, cantidad_mate, unidad_medidad_mate, precio_mate, noSerie_mate, noControl_mate, estado_mate, cBarras_mate, ubicacion_mate, observaciones_mate, factura_mate, imagen_mate, imagen_qr) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                    PreparedStatement ps = conexione.conectar().prepareStatement(sql);
                    ps.setString(1, login.matriculaOpera);
                    ps.setString(2, login.gradoOpera);
                    ps.setString(3, login.nombreOpera);
                    ps.setString(4, login.apellidosOpera);
                    ps.setString(5, fecha.format(LocalDateTime.now()));
                    ps.setString(6, nombre_txt.getText());
                    ps.setString(7, descripcion_txt.getText());
                    ps.setInt(8, Integer.parseInt(cantidad_txt.getText()));
                    ps.setString(9, unidadMedida_txt.getText());
                    ps.setDouble(10, Double.parseDouble(precio_txt.getText()));
                    ps.setString(11, noSerie_txt.getText());
                    ps.setString(12, noControl_txt.getText());
                    ps.setString(13, estadoMaterial_txt.getText());
                    ps.setString(14, codigoBarras_txt.getText());
                    ps.setString(15, ubicacion_txt.getText());
                    ps.setString(16, observaciones_txt.getText());
                    ps.setString(17, factura_txt.getText());
                    generaQR();
                    ps.setBinaryStream(18, fis, logitudBytes);
                    ps.setBinaryStream(19, fis2, logitudBytes2);
                    ps.execute();
                    ps.close();

                    JOptionPane.showMessageDialog(rootPane, "Se guardo correctamente el registro de 'Material'");

                } catch (SQLException | NumberFormatException | HeadlessException x) {
                    JOptionPane.showMessageDialog(rootPane, "exception 2" + x);
                }
                //limpiar();
            }
            //crudMaterial.insertar(nombre_txt.getText(), descripcion_txt.getText(), cantidad_txt.getText(), unidadMedida_txt.getText(), precio_txt.getText(), noSerie_txt.getText(), noControl_txt.getText(), estadoMaterial_txt.getText(), cantidad_txt.getText(), ubicacion_txt.getText(), observaciones_txt.getText(), factura_txt.getText());

        }
        //limpiar();
    }//GEN-LAST:event_agregarMaterial_btnActionPerformed

    private void cancelar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_btnActionPerformed
        menuOpera.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelar_btnActionPerformed

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        LoginAdministrador login = new LoginAdministrador();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_login_btnActionPerformed

    private void anadirI_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirI_btnActionPerformed
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j.getSelectedFile());
                this.logitudBytes = (int) j.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lb_foto.getWidth(), lb_foto.getHeight(), Image.SCALE_DEFAULT);
                    lb_foto.setIcon(new ImageIcon(icono));
                    lb_foto.updateUI();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: " + e);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_anadirI_btnActionPerformed

    private void nombre_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_txtActionPerformed
        descripcion_txt.requestFocus();
    }//GEN-LAST:event_nombre_txtActionPerformed

    private void cantidad_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad_txtActionPerformed
        unidadMedida_txt.requestFocus();
    }//GEN-LAST:event_cantidad_txtActionPerformed

    private void unidadMedida_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidadMedida_txtActionPerformed
        precio_txt.requestFocus();
    }//GEN-LAST:event_unidadMedida_txtActionPerformed

    private void noSerie_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noSerie_txtActionPerformed
        noControl_txt.requestFocus();
    }//GEN-LAST:event_noSerie_txtActionPerformed

    private void precio_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio_txtActionPerformed
        noSerie_txt.requestFocus();
    }//GEN-LAST:event_precio_txtActionPerformed

    private void noControl_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noControl_txtActionPerformed
        estadoMaterial_txt.requestFocus();
    }//GEN-LAST:event_noControl_txtActionPerformed

    private void estadoMaterial_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoMaterial_txtActionPerformed
        codigoBarras_txt.requestFocus();
    }//GEN-LAST:event_estadoMaterial_txtActionPerformed

    private void codigoBarras_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoBarras_txtActionPerformed
        ubicacion_txt.requestFocus();
    }//GEN-LAST:event_codigoBarras_txtActionPerformed

    private void ubicacion_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubicacion_txtActionPerformed
        observaciones_txt.requestFocus();
    }//GEN-LAST:event_ubicacion_txtActionPerformed

    private void observaciones_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observaciones_txtActionPerformed
        factura_txt.requestFocus();
    }//GEN-LAST:event_observaciones_txtActionPerformed

    private void factura_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factura_txtActionPerformed
        anadirI_btn.requestFocus();
        anadirI_btn.doClick();
    }//GEN-LAST:event_factura_txtActionPerformed

    private void cantidad_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad_txtKeyTyped
        Character c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidad_txtKeyTyped

    private void precio_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precio_txtKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && precio_txt.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_precio_txtKeyTyped

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
            java.util.logging.Logger.getLogger(AltaMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaMateriales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarMaterial_btn;
    private javax.swing.JPanel altaMaterial;
    private javax.swing.JButton anadirI_btn;
    private javax.swing.JButton cancelar_btn;
    private javax.swing.JLabel cantidad_l;
    private javax.swing.JTextField cantidad_txt;
    private javax.swing.JLabel codigoBarras_l;
    private javax.swing.JTextField codigoBarras_txt;
    private javax.swing.JTextField descripcion_txt;
    private javax.swing.JLabel estadoMaterial_l;
    private javax.swing.JTextField estadoMaterial_txt;
    private javax.swing.JLabel factura_l;
    private javax.swing.JTextField factura_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lb_foto;
    private javax.swing.JLabel lblQR;
    private javax.swing.JToggleButton login_btn;
    private javax.swing.JLabel noControl_l;
    private javax.swing.JTextField noControl_txt;
    private javax.swing.JLabel noSerie_l;
    private javax.swing.JTextField noSerie_txt;
    private javax.swing.JLabel nombre_l;
    private javax.swing.JTextField nombre_txt;
    private javax.swing.JLabel observaciones_l;
    private javax.swing.JTextField observaciones_txt;
    private javax.swing.JTextField precio_txt;
    private javax.swing.JLabel ubicacion_l;
    private javax.swing.JTextField ubicacion_txt;
    private javax.swing.JTextField unidadMedida_txt;
    // End of variables declaration//GEN-END:variables


}
