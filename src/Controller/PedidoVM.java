/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Views.ListaAlimentos;
import static Views.Sistema.tablePedidos;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elmer
 */
public class PedidoVM {

    public PedidoVM() {
    }

    
    
    public void limpiaCampos() {
        DefaultTableModel modelo = (DefaultTableModel) tablePedidos.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

    }

    public void Eliminar() {
        if (tablePedidos.getRowCount() > 0) {
            DefaultTableModel modelo = (DefaultTableModel) tablePedidos.getModel();
            int fila = tablePedidos.getSelectedRow();
            if (fila >= 0) {
                modelo.removeRow(fila);
                ListaAlimentos la = new ListaAlimentos();
                la.calcular();
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
