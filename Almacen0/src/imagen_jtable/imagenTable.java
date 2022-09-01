/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imagen_jtable;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Embebidos
 */
public class imagenTable extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o,
            boolean bln, boolean bln1, int i, int i1) {
         
        if (o instanceof JLabel ) {
            JLabel lbl = (JLabel)o;
            return lbl;
        }
        return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
    }

}
