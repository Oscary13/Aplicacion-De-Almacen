/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getset;

import conexionPostsgresql.conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Embebidos
 */
public class variables {

    private static String id_opera;
    private static String matricula_opera;
    private static String grado_opera;
    private static String empleo_opera;
    private static String nombre_opera;
    private static String apellidos_opera;
    private static String contraseña_opera;
    private static String cambiar_contra;

    public String getId_opera() {
        return id_opera;
    }

    public void setId_opera(String id_opera) {
        this.id_opera = id_opera;
    }

    public String getMatricula_opera() {
        return matricula_opera;
    }

    public void setMatricula_opera(String matricula_opera) {
        this.matricula_opera = matricula_opera;
    }

    public String getGrado_opera() {
        return grado_opera;
    }

    public void setGrado_opera(String grado_opera) {
        this.grado_opera = grado_opera;
    }

    public String getEmpleo_opera() {
        return empleo_opera;
    }

    public void setEmpleo_opera(String empleo_opera) {
        this.empleo_opera = empleo_opera;
    }

    public String getNombre_opera() {
        return nombre_opera;
    }

    public void setNombre_opera(String nombre_opera) {
        this.nombre_opera = nombre_opera;
    }

    public String getApellidos_opera() {
        return apellidos_opera;
    }

    public void setApellidos_opera(String apellidos_opera) {
        this.apellidos_opera = apellidos_opera;
    }

    public String getContraseña_opera() {
        return contraseña_opera;
    }

    public void setContraseña_opera(String contraseña_opera) {
        this.contraseña_opera = contraseña_opera;
    }
    
    public String getCambiar_contra() {
        return cambiar_contra;
    }

    public void setCambiar_contra(String contraseña_opera) {
        this.cambiar_contra = contraseña_opera;
    }

    public void mostrarOpera(JTable dateOpera) {
        conexion cenectar = new conexion();

        DefaultTableModel modeloT = new DefaultTableModel();

        String sql = "";

        modeloT.addColumn("id");
        modeloT.addColumn("Matricula");
        modeloT.addColumn("Grado");
        modeloT.addColumn("Empleo");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellidos");
        modeloT.addColumn("Contraseña");

        dateOpera.setModel(modeloT);
        sql = "SELECT * FROM operador ;";

        String[] datos = new String[7];
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
                modeloT.addRow(datos);

            }
            dateOpera.setModel(modeloT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.toString());
        }
    }

    public void mostrarOpera1(JTable dateOpera, String matricula) {
        
        conexion cenectar = new conexion();

        DefaultTableModel modeloT = new DefaultTableModel();

        String sql = "";

        modeloT.addColumn("id");
        modeloT.addColumn("Matricula");
        modeloT.addColumn("Grado");
        modeloT.addColumn("Empleo");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellidos");
        modeloT.addColumn("Contraseña");

        dateOpera.setModel(modeloT);
        sql = "SELECT * FROM operador WHERE matricula_opera = '" + matricula + "';";

        String[] datos = new String[7];
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
                modeloT.addRow(datos);

            }
            dateOpera.setModel(modeloT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.toString());

        }
    }

    public void mostrarMaterial(JTable tablaMostrar_Material) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void Generar_Carta(JTable tablaMostrar_Material) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
