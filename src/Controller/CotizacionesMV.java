/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Views.ListaAlimentos;
import static Views.Sistema.Subtotal;
import static Views.Sistema.tablaCotizaciones;
import static Views.Sistema.tablePedidos;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elmer
 */
public class CotizacionesMV {

    private ArrayList<JTextField> _textField;

    public void Componentes(ArrayList<JTextField> textField) {

        _textField = textField;
        GenerarDescuento();
    }
    
    
    
    public void limpiaCampos() {
        DefaultTableModel modelo = (DefaultTableModel) tablaCotizaciones.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        Subtotal.setText("");
    }

    public void Eliminar() {
        if (tablaCotizaciones.getRowCount() > 0) {
            DefaultTableModel modelo = (DefaultTableModel) tablaCotizaciones.getModel();
            int fila = tablaCotizaciones.getSelectedRow();
            if (fila >= 0) {
                modelo.removeRow(fila);
                ListaAlimentos la = new ListaAlimentos();
                la.calcular2();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Caja de cobro", 0,
                        new ImageIcon(getClass().getResource("/Resources/info.png")));
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros\npara eliminar.", "Caja de cobro", 0,
                    new ImageIcon(getClass().getResource("/Resources/info.png")));
        }
    }

    public void GenerarDescuento() {
        double subtotal = Double.parseDouble(_textField.get(0).getText());
        double descuento = 1.00;
        
        
        if ("".equals(_textField.get(1).getText())){
            _textField.get(2).setText("");
            _textField.get(3).setText(subtotal+"");
        } else {
            descuento = Double.parseDouble(_textField.get(1).getText());

        double total = (subtotal * descuento) / 100;
        String Total = total + "";
        _textField.get(2).setText(Total);
        
        double totalCotizacion = subtotal - total;
        _textField.get(3).setText(totalCotizacion+"");
        System.out.println(Total);
        }
        

    }

}
