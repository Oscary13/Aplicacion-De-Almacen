/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getset;

import conexionPostsgresql.conexion;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Embebidos
 */
public class variablesMaterial {

    private static String id_material;
    private static String nombre_mate;
    private static String descripcion_mate;
    private static String cantidad_mate;
    private static String unidad_medidad_mate;
    private static String precio_mate;
    private static String noSerie_mate;
    private static String noControl_mate;
    private static String estado_mate;
    private static String cBarras_mate;
    private static String ubicacion_mate;
    private static String observaciones_mate;
    private static String factura_mate;

    public static String getId_material() {
        return id_material;
    }

    public static void setId_material(String id_material) {
        variablesMaterial.id_material = id_material;
    }

    public static String getNombre_mate() {
        return nombre_mate;
    }

    public static void setNombre_mate(String nombre_mate) {
        variablesMaterial.nombre_mate = nombre_mate;
    }

    public static String getDescripcion_mate() {
        return descripcion_mate;
    }

    public static void setDescripcion_mate(String descripcion_mate) {
        variablesMaterial.descripcion_mate = descripcion_mate;
    }

    public static String getCantidad_mate() {
        return cantidad_mate;
    }

    public static void setCantidad_mate(String cantidad_mate) {
        variablesMaterial.cantidad_mate = cantidad_mate;
    }

    public static String getUnidad_medidad_mate() {
        return unidad_medidad_mate;
    }

    public static void setUnidad_medidad_mate(String unidad_medidad_mate) {
        variablesMaterial.unidad_medidad_mate = unidad_medidad_mate;
    }

    public static String getPrecio_mate() {
        return precio_mate;
    }

    public static void setPrecio_mate(String precio_mate) {
        variablesMaterial.precio_mate = precio_mate;
    }

    public static String getNoSerie_mate() {
        return noSerie_mate;
    }

    public static void setNoSerie_mate(String noSerie_mate) {
        variablesMaterial.noSerie_mate = noSerie_mate;
    }

    public static String getNoControl_mate() {
        return noControl_mate;
    }

    public static void setNoControl_mate(String noControl_mate) {
        variablesMaterial.noControl_mate = noControl_mate;
    }

    public static String getEstado_mate() {
        return estado_mate;
    }

    public static void setEstado_mate(String estado_mate) {
        variablesMaterial.estado_mate = estado_mate;
    }

    public static String getcBarras_mate() {
        return cBarras_mate;
    }

    public static void setcBarras_mate(String cBarras_mate) {
        variablesMaterial.cBarras_mate = cBarras_mate;
    }

    public static String getUbicacion_mate() {
        return ubicacion_mate;
    }

    public static void setUbicacion_mate(String ubicacion_mate) {
        variablesMaterial.ubicacion_mate = ubicacion_mate;
    }

    public static String getObservaciones_mate() {
        return observaciones_mate;
    }

    public static void setObservaciones_mate(String observaciones_mate) {
        variablesMaterial.observaciones_mate = observaciones_mate;
    }

    public static String getFactura_mate() {
        return factura_mate;
    }

    public static void setFactura_mate(String factura_mate) {
        variablesMaterial.factura_mate = factura_mate;
    }

    public void mostrarMaterial(JTable dateMateria) {
        ImageIcon foto;
        InputStream is;
        String nombre;
        conexion cenectar = new conexion();

        DefaultTableModel modeloT = new DefaultTableModel();

        String sql = "";

        modeloT.addColumn("id");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Descripción");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Unidad de medida");
        modeloT.addColumn("Precio");
        modeloT.addColumn("No. Serie");
        modeloT.addColumn("No. Control");
        modeloT.addColumn("Estado");
        modeloT.addColumn("Codigo de barras");
        modeloT.addColumn("Ubicación");
        modeloT.addColumn("Observaciones");
        modeloT.addColumn("Factura");
        modeloT.addColumn("Imagen");

        dateMateria.setModel(modeloT);
        sql = "SELECT * FROM material ;";

        Object[] datos = new Object[14];
        //JLabel[] imagen = new JLabel[14];

        Statement st;

        try {
            st = cenectar.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                datos[11] = rs.getString(12);
                datos[12] = rs.getString(13);

                //is = rs.getBinaryStream(14);
                //BufferedImage bi =ImageIO.read(is);
                //foto = new ImageIcon(bi);
                //Image img = foto.getImage();
                //Image newimg = img.getScaledInstance(187, 217, java.awt.Image.SCALE_SMOOTH);
                //ImageIcon newicon = new ImageIcon(newimg);
                datos[13] = rs.getBinaryStream(14);
                modeloT.addRow(datos);

            }
            dateMateria.setModel(modeloT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

    public void mostrarMarteria1(JTable dateOpera, String noControl) {

        conexion cenectar = new conexion();

        DefaultTableModel modeloT = new DefaultTableModel();

        String sql = "";

        modeloT.addColumn("id");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Descripción");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Unidad de medida");
        modeloT.addColumn("Precio");
        modeloT.addColumn("No. Serie");
        modeloT.addColumn("No. Control");
        modeloT.addColumn("Estado");
        modeloT.addColumn("Codigo de barras");
        modeloT.addColumn("Ubicación");
        modeloT.addColumn("Observaciones");
        modeloT.addColumn("Factura");
        modeloT.addColumn("imagen");
        

        dateOpera.setModel(modeloT);
        sql = "SELECT * FROM material WHERE noControl_mate = '" + noControl + "';";

        Object[] datos = new Object[14];
        Statement st;

        try {
            st = cenectar.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                datos[11] = rs.getString(12);
                datos[12] = rs.getString(13);

                ImageIcon foto;
                InputStream is;
                String nombre;
                is = rs.getBinaryStream(14);
                BufferedImage bi =ImageIO.read(is);
                foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(187, 217, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newicon = new ImageIcon(newimg);
                datos[13] = rs.getBinaryStream(14);

                modeloT.addRow(datos);

            }
            dateOpera.setModel(modeloT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.toString());

        }
    }

}
