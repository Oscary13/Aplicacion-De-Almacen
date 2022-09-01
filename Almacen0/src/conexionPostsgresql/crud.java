/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionPostsgresql;

import getset.variables;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ventanasParaAdmin.ActualizarDatosOpera;
import ventanasParaAdmin.AltaAdmin;
import ventanasParaAdmin.AltaOperador;
import ventanasParaAdmin.CrearDB;
import ventanasParaAdmin.LoginAdministrador;
import ventanasParaAdmin.Menu_administrador;

/**
 *
 * @author Oscary Basurto Clase que nos permite establecer la conexión y
 * comunicarnos a la base de datos en PostgreSQL
 *
 */
public class crud extends conexion {

    conexion1 conexion1 = new conexion1();
    /**
     * Se declaran las variables y objetos que se utilizaran en los metodos
     */
    java.sql.Statement st;
    ResultSet rs;
    variables var = new variables();
    ActualizarDatosOpera ado = new ActualizarDatosOpera();

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
    public void insertar(String matricula, String grado, String empleo, String nombre, String apellidos, String contrasena) {
        try {

            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "INSERT INTO operador"
                    + "( matricula_opera, grado_opera, empleo_opera, nombre_opera, apellidos_opera, contrasena_opera, cambiar_contra) VALUES ('" + matricula + "','" + grado + "','" + empleo + "','" + nombre + "','" + apellidos + "','" + contrasena + "','1')";
            AltaOperador objalta = new AltaOperador();
            objalta.limpiar();
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro de 'Operador' se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertar2(String matricula, String grado, String empleo, String nombre, String apellidos, String contrasena) {
        try {

            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "INSERT INTO administrador"
                    + "( matricula_admin, grado_admin, empleo_admin, nombre_admin, apellidos_admin, contrasena_admin) VALUES ('" + matricula + "','" + grado + "','" + empleo + "','" + nombre + "','" + apellidos + "','" + contrasena + "')";
            AltaOperador objalta = new AltaOperador();
            objalta.limpiar();
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro de 'Administrador Unico' se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void CrearTablas() {

    }

    public void CrearDB() {
        try {

            Connection conexion = conexion1.conectar();
            st = conexion.createStatement();
            String sql = "CREATE DATABASE almacen0";
            AltaOperador objalta = new AltaOperador();
            objalta.limpiar();
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "SE CREO CORRECTAMENTE LA BASE DE DATOS", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "YA EXISTE UNA BASE DE DATOS" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }

        try {

            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "CREATE TABLE operador (\n"
                    + "id serial,\n"
                    + "	matricula_opera varchar(50) PRIMARY KEY ,\n"
                    + "	grado_opera varchar(50),\n"
                    + " empleo_opera varchar(50),\n"
                    + "	nombre_opera varchar(50),\n"
                    + "	apellidos_opera varchar(50),\n"
                    + "	contrasena_opera varchar (50),\n"
                    + " cambiar_contra varchar (50)\n"
                    + "	\n"
                    + "	\n"
                    + ");\n"
                    + "\n"
                    + "\n"
                    + "CREATE TABLE administrador (\n"
                    + "id serial,\n"
                    + "	matricula_admin varchar(50) PRIMARY KEY ,\n"
                    + "	grado_admin varchar(50),\n"
                    + " empleo_admin varchar(50),\n"
                    + "	nombre_admin varchar(50),\n"
                    + "	apellidos_admin varchar(50),\n"
                    + "	contrasena_admin varchar (50)\n"
                    + "	\n"
                    + "	\n"
                    + ");\n"
                    + "\n"
                    + "CREATE TABLE material (\n"
                    + "id serial  PRIMARY KEY,\n"
                    + "	matricula_opera varchar(50),\n"
                    + "	grado_opera varchar(50),\n"
                    + "	nombre_opera varchar(50),\n"
                    + "	apellidos_opera varchar(50),\n"
                    + "	fecha_ingreso varchar(20),\n"
                    + "	nombre_mate varchar(500),\n"
                    + "	descripcion_mate varchar(500),\n"
                    + "	cantidad_mate int8,\n"
                    + "	unidad_medidad_mate varchar(500),\n"
                    + "	precio_mate float8,\n"
                    + "	noSerie_mate varchar(500),\n"
                    + "	noControl_mate varchar(500),\n"
                    + "	estado_mate varchar(500),\n"
                    + "	cBarras_mate varchar(500),\n"
                    + "	ubicacion_mate varchar(500),\n"
                    + "	observaciones_mate varchar(500),\n"
                    + "	factura_mate varchar(500),\n"
                    + "	imagen_mate bytea,\n"
                    + "	imagen_qr bytea\n"
                    + ");\n"
                    + "\n"
                    + "CREATE TABLE material_extraido (\n"
                    + "id serial  PRIMARY KEY,\n"
                    + "	matricula_solicitante varchar(50),\n"
                    + "	grado_solicitante varchar(50),\n"
                    + "	nombrecompleto_solicitante varchar(50),\n"
                    + "	fecha_extraccion varchar(20),\n"
                    + "	area_entrega varchar(50),\n"
                    + "	area_recibe varchar(50),\n"
                    + "	cantidad_extraer_mate int8,\n"
                    + "	nombre_mate varchar(500),\n"
                    + "	descripcion_mate varchar(500),\n"
                    + "	unidad_medidad_mate varchar(500),\n"
                    + "	precio_mate float8,\n"
                    + "	noSerie_mate varchar(500),\n"
                    + "	noControl_mate varchar(500),\n"
                    + "	estado_mate varchar(500),\n"
                    + "	cBarras_mate varchar(500),\n"
                    + "	ubicacion_mate varchar(500),\n"
                    + "	observaciones_mate varchar(500),\n"
                    + "	factura_mate varchar(500)\n"
                    + ");";

            AltaOperador objalta = new AltaOperador();
            objalta.limpiar();
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "SE CREARON CORRECTAMENTE LAS TABLAS PARA LA BASE DE DATOS", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            AltaAdmin altaAdmin = new AltaAdmin();
            altaAdmin.setVisible(true);
            altaAdmin.setLocationRelativeTo(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "YA EXISTE UNA BASE DE DATOS" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
            LoginAdministrador login = new LoginAdministrador();
            login.setVisible(true);

        }

    }

    /**
     * Metodo "mostrar" realiza una consulta a la base de datos mediante la
     * matricula
     *
     * @param matricula
     */
    public void mostar(String matricula) {

        try {
            ActualizarDatosOpera actualizarDatosOpera = new ActualizarDatosOpera();
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "SELECT * FROM operador WHERE matricula_opera = '" + matricula + "';";

            rs = st.executeQuery(sql);

            if (rs.next()) {

                var.setId_opera(rs.getString("id"));
                var.setGrado_opera(rs.getString("grado_opera"));
                var.setEmpleo_opera(rs.getString("empleo_opera"));
                var.setMatricula_opera(rs.getString("matricula_opera"));
                var.setNombre_opera(rs.getString("nombre_opera"));
                var.setApellidos_opera(rs.getString("apellidos_opera"));
                var.setContraseña_opera(rs.getString("contrasena_opera"));
                ado.hablitarBotones();
                ado.activarBotones();

            } else {
                var.setId_opera("");
                var.setMatricula_opera("");
                var.setGrado_opera("");
                var.setEmpleo_opera("");
                var.setNombre_opera("");
                var.setApellidos_opera("");
                var.setContraseña_opera("");
                JOptionPane.showMessageDialog(null, "El registro no existe", "Sin registro", JOptionPane.ERROR_MESSAGE);
                ado.limpiar2();
            }
            st.close();
            conexion.close();
        } catch (Exception e) {

            ado.limpiar();
            JOptionPane.showMessageDialog(null, "Error en el sistema de busqueda", "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void actualizar(String id, String matricula, String grado, String empleo, String nombre, String apellidos, String contrasena) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "UPDATE operador SET id='" + id + "',matricula_opera='" + matricula + "',grado_opera='" + grado + "',empleo_opera='" + empleo + "',nombre_opera='" + nombre + "',apellidos_opera='" + apellidos + "',contrasena_opera='" + contrasena + "',cambiar_contra='1' WHERE matricula_opera = '" + matricula + "';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se actualizó correctamente el registro", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se actualizo el registro", "Actualización erronea", JOptionPane.ERROR_MESSAGE);
            ado.limpiar2();
        }
    }

    public void eliminarOpera(String matricula) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "DELETE FROM operador WHERE matricula_opera = '" + matricula + "';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se elimino el registro correctamente", "Registro Eliminado", JOptionPane.INFORMATION_MESSAGE);

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
                var.setMatricula_opera("");
                var.setContraseña_opera("");
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
