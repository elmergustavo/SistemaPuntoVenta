/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import static Views.Sistema.total;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elmer
 */
public class VentasVM {
    public void limpiaCampos(JTable tablaVentas) {
        DefaultTableModel modelo = (DefaultTableModel) tablaVentas.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        total.setText("");
    }
}
