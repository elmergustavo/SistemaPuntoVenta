/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Library.Encriptar;
import Library.Objectos;
import Library.Uploadimage;
import Models.UsuarioSQL;
import Models.Usuarios.TRoles;
import Models.Usuarios.TUsuarios;
import alertas.AlertError;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import rojerusan.RSFotoSquare;

/**
 *
 * @author Gustavo
 */
public class UsuariosVM extends UsuarioSQL {

    private static TUsuarios _dataUsuario;
    private static JLabel _nombrePerfil;
    private static JLabel _picturePerfil;
    private JLabel _imagePicture;
    private List<JTextField> _textField;
    private List<JLabel> _label;
    private JCheckBox _checkBoxState;
    private JComboBox _comboBoxRoles;
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
        _imagePicture = (JLabel) objectos[0];
        _checkBoxState = (JCheckBox) objectos[1];
        _tableUser = (JTable) objectos[2];
        _comboBoxRoles = (JComboBox) objectos[3];
        Restablecer();
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
                                            int count;
                                            List<TUsuarios> listEmail = Usuarios().stream()
                                                    .filter(u -> u.getEmail().equals(_textField.get(2).getText()))
                                                    .collect(Collectors.toList());
                                            count = listEmail.size();
                                            List<TUsuarios> listNid = Usuarios().stream()
                                                    .filter(u -> u.getNid().equals(_textField.get(0).getText()))
                                                    .collect(Collectors.toList());
                                            count += listNid.size();
                                            try {
                                                switch (_accion) {
                                                    case "insert":
                                                        if (count == 0) {
                                                            SaveData();
                                                        } else {
                                                            if (!listEmail.isEmpty()) {
                                                                AlertError error = new AlertError(null, true);
                                                                error.Texto("El Email ya esta registrado");
                                                                error.setVisible(true);
                                                            }
                                                            if (!listNid.isEmpty()) {
                                                                AlertError error = new AlertError(null, true);
                                                                error.Texto("El Nid ya esta registrado");
                                                                error.setVisible(true);
                                                            }
                                                        }
                                                        break;
                                                }
                                            } catch (Exception e) {
                                                JOptionPane.showMessageDialog(null, e);
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
    }

    private void SaveData() throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner(true);
            conexion.getConnection().setAutoCommit(false);
            byte[] image = Uploadimage.getImageByte();
            if (image == null) {
                image = Objectos.uploadimage.getTransFoto(_imagePicture);
            }
            switch (_accion) {
                case "insert":
                    String sqlUsuario1 = "INSERT INTO tusuarios(Nid,Nombre,Apellido,Direccion"
                            + ",Telefono,Email,Usuario,Password,Role,Imagen,Is_active"
                            + ",State,Fecha) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    TRoles role = (TRoles) _comboBoxRoles.getSelectedItem();
                    Object[] dataUsuario1 = {
                        _textField.get(0).getText(),
                        _textField.get(1).getText(),
                        _textField.get(3).getText(),
                        _textField.get(5).getText(),
                        _textField.get(4).getText(),
                        _textField.get(2).getText(),
                        _textField.get(6).getText(),
                        Encriptar.encrypt(_textField.get(7).getText()),
                        role.getRole(),
                        image,
                        true,
                        _checkBoxState.isSelected(),//tynyint
                        new Date()
                    };
                    qr.insert(conexion.getConnection(), sqlUsuario1, new ColumnListHandler(), dataUsuario1);
                    break;
            }
            conexion.getConnection().commit();
            Restablecer();
        } catch (Exception e) {
            conexion.getConnection().rollback();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public final void Restablecer() {
        _accion = "insert";
        for (int i = 0; i < _textField.size(); i++) {
            _textField.get(i).setText("");
        }
        _checkBoxState.setSelected(false);
        _checkBoxState.setForeground(new Color(102, 102, 102));
        _imagePicture.setIcon(new ImageIcon(getClass().getClassLoader()
                .getResource("Resources/login.png")));
        getRoles();

    }

    public void getRoles() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        roles().forEach(item -> {
            model.addElement(item);
        });
        _comboBoxRoles.setModel(model);
    }

    // </editor-fold>
}
