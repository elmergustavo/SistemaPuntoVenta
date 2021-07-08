/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import app.bolivia.swing.JCTextField;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;


/**
 *
 * @author elmer
 */
public class CotizacionesMV {
    
     private  ArrayList<JTextField> _textField;
    
    
    public void Componentes(ArrayList<JTextField> textField) {
   //     this.conexion = Conexion.createInstance();
        _textField = textField;
       
    }
    
    public void GenerarDescuento(){
        double subtotal = Double.parseDouble(_textField.get(0).getText());
        double descuento = Double.parseDouble(_textField.get(1).getText());
        
        double total = (subtotal * descuento)/ 100;
        String Total = total + "";
        _textField.get(2).setText(Total);
        System.out.println(Total);
        
    }
    
    
}
