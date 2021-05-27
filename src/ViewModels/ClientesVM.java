/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author elmer
 */
public class ClientesVM {

    private String _accion = "insert";
    private final ArrayList<JLabel> _label;
    private final ArrayList<JTextField> _textField;

    public ClientesVM(Object[] objects, ArrayList<JLabel> label, ArrayList<JTextField> textField) {
        _label = label;
        _textField = textField;
    }

    public void RegistrarCliente() {
        if (_textField.get(0).getText().equals("")) {
            _label.get(0).setText("Ingrese el nid");
            _label.get(0).setForeground(Color.RED);
            _textField.get(0).requestFocus();
        }
    }

}
