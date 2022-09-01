/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionPostsgresql;

import getset.variables;
import getset.variablesMaterial;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ventanasParaAdmin.ActualizarDatosOpera;
import ventanasParaAdmin.AltaOperador;
import ventanasParaAdmin.Menu_administrador;
import ventanasParaOpera.ActualizarDatosMateriales;

/**

/**
 *
 * @author Embebidos
 */
public class crudMaterial extends conexion {
    
    /**
     * Se declaran las variables y objetos que se utilizaran en los metodos
     */
    java.sql.Statement st;
    ResultSet rs;
    variablesMaterial var = new variablesMaterial();

    /**
     * Metodo "Mostrar" nos permite subir registros a la base de datos
     *
     * @param matricula
     * @param grado
     * @param empleo
     * @param nombre
     * @param apellidos
     * @param contrasena
     */
    public void insertar(String nombre, String descripcion, String cantidad, String um, String precio, String noSerie , String noControl, String estadoMaterial, String cBarras, String ubicacion, String observaciones, String factura) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "INSERT INTO material(nombre_mate, descripcion_mate, cantidad_mate, unidad_medidad_mate, precio_mate, noSerie_mate, noControl_mate, estado_mate, cBarras_mate, ubicacion_mate, observaciones_mate, factura_mate) VALUES ('"+nombre+"','"+descripcion+"','"+cantidad+"','"+um+"','"+precio+"','"+noSerie+"','"+noControl+"','"+estadoMaterial+"','"+cBarras+"','"+ubicacion+"','"+observaciones+"','"+factura+"');";
            AltaOperador objalta = new AltaOperador();
            objalta.limpiar();
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo "mostrar" realiza una consulta a la base de datos mediante la
     * matricula
     *
     * @param matricula
     */
    public void mostar(String cBarras_mate) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "SELECT * FROM material WHERE cBarras_mate = '" + cBarras_mate + "';";

            rs = st.executeQuery(sql);

            if (rs.next()) {
                var.setId_material(rs.getString("id"));
                var.setNombre_mate(rs.getString("nombre_mate"));
                var.setDescripcion_mate(rs.getString("descripcion_mate"));
                var.setCantidad_mate(rs.getString("cantidad_mate"));
                var.setUnidad_medidad_mate(rs.getString("unidad_medidad_mate"));
                var.setPrecio_mate(rs.getString("precio_mate"));
                var.setNoSerie_mate(rs.getString("noSerie_mate"));
                var.setNoControl_mate(rs.getString("noControl_mate"));
                var.setEstado_mate(rs.getString("estado_mate"));
                var.setcBarras_mate(rs.getString("cBarras_mate"));
                var.setUbicacion_mate(rs.getString("ubicacion_mate"));
                var.setObservaciones_mate(rs.getString("observaciones_mate"));
                var.setFactura_mate(rs.getString("factura_mate"));
            } else {
                var.setId_material("");
                var.setNombre_mate("");
                var.setDescripcion_mate("");
                var.setCantidad_mate("");
                var.setUnidad_medidad_mate("");
                var.setPrecio_mate("");
                var.setNoSerie_mate("");
                var.setNoControl_mate("");
                var.setEstado_mate("");
                var.setcBarras_mate("");
                var.setUbicacion_mate("");
                var.setObservaciones_mate("");
                var.setFactura_mate("");
                JOptionPane.showMessageDialog(null, "El registro no existe", "Sin registro", JOptionPane.ERROR_MESSAGE);
            }
            st.close();
            conexion.close();
        } catch (Exception e) {
            ActualizarDatosOpera ado = new ActualizarDatosOpera();
            ado.limpiar();
            JOptionPane.showMessageDialog(null, "Error en el sistema de busqueda", "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void actualizar(String nombre, String descripcion, String cantidad, String um, String precio, String noSerie , String noControl, String estadoMaterial, String cBarras, String ubicacion, String observaciones, String factura) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "UPDATE material SET nombre_mate='"+nombre+"',descripcion_mate='"+descripcion+"',cantidad_mate='"+cantidad+"',unidad_medidad_mate='"+um+"',precio_mate='"+precio+"',noSerie_mate='"+noSerie+"',noControl_mate='"+noControl+"',estado_mate='"+estadoMaterial+"',cBarras_mate='"+cBarras+"',ubicacion_mate='"+ubicacion+"',observaciones_mate='"+observaciones+"',factura_mate='"+factura+"' WHERE cBarras_mate = '"+cBarras+"';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            
            
            JOptionPane.showMessageDialog(null, "Se actualizó correctamente el registro", "Actualización de registro", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se actualizo el registro", "Actualización de registro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarOpera(String noControl) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "DELETE FROM material WHERE noControl_mate = '" + noControl + "';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se elimino el registro correctamente", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se elimino el registro", "Eliminación erronea", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostar1(String matricula, String contrasena) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "SELECT matricula_opera,contrasena_opera FROM operador WHERE matricula_opera = '" + matricula + "'and contrasena_opera = '" + contrasena + "';";

            rs = st.executeQuery(sql);

            if (rs.next()) {
                Menu_administrador menu = new Menu_administrador();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
                JOptionPane.showMessageDialog(null, "Se enecontro registro", "Sin registro", JOptionPane.INFORMATION_MESSAGE);
            } else {
                //var.setMatricula_opera("");
                //var.setContraseña_opera("");
                JOptionPane.showMessageDialog(null, "No senecontro registro", "Sin registro", JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        } catch (Exception e) {
            //ActualizarDatosOperador ado = new ActualizarDatosOpera();
            //ado.limpiar();
            JOptionPane.showMessageDialog(null, "Error en el sistema de busqueda", "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void mostar2(JTable dateOpera, String matricula) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String[] datos = new String[7];
            
            DefaultTableModel modeloT = new DefaultTableModel();
            modeloT.addColumn("id");
            modeloT.addColumn("Matricula");
            modeloT.addColumn("Grado");
            modeloT.addColumn("Empleo");
            modeloT.addColumn("Nombre");
            modeloT.addColumn("Apellidos");
            modeloT.addColumn("Contraseña");

            dateOpera.setModel(modeloT);
            String sql = "SELECT * FROM operador WHERE matricula_opera = '" + matricula + "';";

            rs = st.executeQuery(sql);
            
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

            
            st.close();
            conexion.close();
        } catch (Exception e) {
            ActualizarDatosOpera ado = new ActualizarDatosOpera();
            ado.limpiar();
            JOptionPane.showMessageDialog(null, "Error en el sistema de busqueda", "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }

    }
    
}
