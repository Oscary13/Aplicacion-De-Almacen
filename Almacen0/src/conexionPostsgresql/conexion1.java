/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionPostsgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Embebidos
 */
public class conexion1 {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/";
    String usuario = "postgres";
    String clave = "obb13pam";
    public Connection conectar(){
	    try {
		    Class.forName("org.postgresql.Driver");
		    conn = DriverManager.getConnection(url,usuario,clave);
		    //JOptionPane.showMessageDialog(null,"Conexion establecida", "EXITO",JOptionPane.INFORMATION_MESSAGE);
		    
	    } catch (Exception e) {
		    //JOptionPane.showMessageDialog(null,"Error al establecer conexión" +e, "Error",JOptionPane.ERROR_MESSAGE);
	    }
	    return conn;
    }
}
