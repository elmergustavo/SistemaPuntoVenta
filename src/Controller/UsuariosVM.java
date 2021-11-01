/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Library.Objectos;
import Library.Uploadimage;
import Models.Usuarios.TUsuarios;
import alertas.AlertError;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import rojerusan.RSFotoSquare;

/**
 *
 * @author Gustavo
 */
public class UsuariosVM {

    private static TUsuarios _dataUsuario;
    private static JLabel _nombrePerfil;
    private static JLabel _picturePerfil;
    private RSFotoSquare _imagePicture;
    private List<JTextField> _textField;
    private List<JLabel> _label;
    private JCheckBox _checkBoxState;
    private JComboBox _comboBoxRole;
    private JTable _tableUser;
    private JSpinner _spinnerPaginas;
    private String _accion = "insert";
    private Uploadimage _uploadimage = new Uploadimage();

    public UsuariosVM(TUsuarios dataUsuario, Object[] perfil) {
        _dataUsuario = dataUsuario;
        _nombrePerfil = (JLabel) perfil[0];
        _picturePerfil = (JLabel) perfil[1];
        Perfil();
    }

    public UsuariosVM(Object[] objectos, List<JTextField> textField) {
        _textField = textField;
        _imagePicture = (RSFotoSquare) objectos[0];
        _checkBoxState = (JCheckBox) objectos[1];
        _tableUser = (JTable) objectos[2];
        _comboBoxRole = (JComboBox) objectos[3];
    }

    private void Perfil() {
        _nombrePerfil.setText(_dataUsuario.getUsuario());
        if (null != _dataUsuario.getImagen()) {
            _uploadimage.byteImage(_picturePerfil, _dataUsuario.getImagen());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="CODIGO DE REGISTRAR USUARIOS">
    public void RegistrarUsuario() {
        if (_textField.get(0).getText().equals("")) {
            AlertError error = new AlertError(null, true);
            error.Texto("Todos los campos son requeridos");
            error.setVisible(true);
        } else {
            if (_textField.get(1).getText().equals("")) {
                AlertError error = new AlertError(null, true);
                error.Texto("Todos los campos son requeridos");
                error.setVisible(true);
            } else {
                if (_textField.get(2).getText().equals("")) {
                    AlertError error = new AlertError(null, true);
                    error.Texto("Todos los campos son requeridos");
                    error.setVisible(true);
                } else {
                    if (!Objectos.eventos.isEmail(_textField.get(2).getText())) {
                        AlertError error = new AlertError(null, true);
                        error.Texto("Ingrese un email valido");
                        error.setVisible(true);
                    } else {
                        if (_textField.get(3).getText().equals("")) {
                            AlertError error = new AlertError(null, true);
                            error.Texto("Todos los campos son requeridos");
                            error.setVisible(true);
                        } else {
                            if (_textField.get(4).getText().equals("")) {
                                AlertError error = new AlertError(null, true);
                                error.Texto("Todos los campos son requeridos");
                                error.setVisible(true);
                            } else {
                                if (_textField.get(5).getText().equals("")) {
                                    AlertError error = new AlertError(null, true);
                                    error.Texto("Todos los campos son requeridos");
                                    error.setVisible(true);
                                } else {
                                    if (_textField.get(6).getText().equals("")) {
                                        AlertError error = new AlertError(null, true);
                                        error.Texto("Todos los campos son requeridos");
                                        error.setVisible(true);
                                    } else {
                                        if (_textField.get(7).getText().equals("")) {
                                            AlertError error = new AlertError(null, true);
                                            error.Texto("Todos los campos son requeridos");
                                            error.setVisible(true);
                                        } else {

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void Restablecer() {
        for (int i = 0; i < _textField.size(); i++) {
            _textField.get(i).setText("");
        }
        _checkBoxState.setSelected(false);
        _checkBoxState.setForeground(new Color(102, 102, 102));
//        _imagePicture.setImagenDefault(new ImageIcon(getClass().getClassLoader()
//                .getResource("Resources/login.png")));

    }
    // </editor-fold>
}
