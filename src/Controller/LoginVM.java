/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Library.Objectos;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo
 */
public class LoginVM {

    private ArrayList<JLabel> _label;
    private ArrayList<JTextField> _textField;

    public LoginVM(ArrayList<JLabel> label, ArrayList<JTextField> textField) {
        _label = label;
        _textField = textField;
    }

    public Object[] Login() {
        if (_textField.get(0).getText().equals("")) {
            _label.get(0).setText("Ingrese el usario");
            _label.get(0).setForeground(Color.RED);
            _textField.get(0).requestFocus();
        } else {
            if (!Objectos.eventos.isEmail(_textField.get(0).getText())) {
                _label.get(0).setText("Ingrese un email valido");
                _label.get(0).setForeground(Color.RED);
                _textField.get(0).requestFocus();
            } else {
                if (_textField.get(1).getText().equals("")) {
                    _label.get(1).setText("Ingrese el password");
                    _label.get(1).setForeground(Color.RED);
                    _textField.get(1).requestFocus();
                } else {

                }
            }

        }
        return null;
    }

}
