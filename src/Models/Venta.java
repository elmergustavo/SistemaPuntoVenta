/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Views.ListaAlimentos;
import static Views.Sistema.tablaPedidosVenta;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MATXHUN
 */
public class Venta {

    
    public void eliminar(){
        if (tablaPedidosVenta.getRowCount() > 0) {
            DefaultTableModel modelo = (DefaultTableModel) tablaPedidosVenta.getModel();
            int fila = tablaPedidosVenta.getSelectedRow();
            if (fila >= 0) {
                modelo.removeRow(fila);
                ListaAlimentos la = new ListaAlimentos();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Caja de cobro", 0,
                        new ImageIcon(getClass().getResource("/Resources/info.png")));
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros\npara eliminar.", "Caja de cobro", 0,
                    new ImageIcon(getClass().getResource("/Resources/info.png")));
        }
    }
    
}
