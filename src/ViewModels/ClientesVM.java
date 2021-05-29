/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import Conexion.Conexion;
import Conexion.Cosult;
import Libreria.Calendario;
import Libreria.Objetos;
import static Libreria.Objetos.uploadimagen;
import Libreria.UploadImage;
import Models.TClientes;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

/**
 *
 * @author elmer
 */
public class ClientesVM extends Cosult {

    private String _accion = "insert";
    private final ArrayList<JLabel> _label;
    private final ArrayList<JTextField> _textField;
    private JCheckBox _checkBoxCredito;

    public ClientesVM(Object[] objects, ArrayList<JLabel> label, ArrayList<JTextField> textField) {
        _label = label;
        _textField = textField;
        _checkBoxCredito = (JCheckBox) objects[0];
        new Conexion();
    }

    public void RegistrarCliente() {
        if (_textField.get(0).getText().equals("")) {
            _label.get(0).setText("Ingrese el nid");
            _label.get(0).setForeground(Color.RED);
            _textField.get(0).requestFocus();
        } else {
            if (_textField.get(1).getText().equals("")) {
                _label.get(1).setText("Ingrese el nombre");
                _label.get(1).setForeground(Color.RED);
                _textField.get(1).requestFocus();
            } else {
                if (_textField.get(2).getText().equals("")) {
                    _label.get(2).setText("Ingrese el apellido");
                    _label.get(2).setForeground(Color.RED);
                    _textField.get(2).requestFocus();
                } else {
                    if (_textField.get(3).getText().equals("")) {
                        _label.get(3).setText("Ingrese el email");
                        _label.get(3).setForeground(Color.RED);
                        _textField.get(3).requestFocus();
                    } else {
                        if (!Objetos.eventos.isEmail(_textField.get(3).getText())) {
                            _label.get(3).setText("Ingrese un email valido");
                            _label.get(3).setForeground(Color.RED);
                            _textField.get(3).requestFocus();
                        } else {
                            if (_textField.get(4).getText().equals("")) {
                                _label.get(4).setText("Ingrese el telefono");
                                _label.get(4).setForeground(Color.RED);
                                _textField.get(4).requestFocus();
                            } else {
                                if (_textField.get(5).getText().equals("")) {
                                    _label.get(5).setText("Ingrese la direccion");
                                    _label.get(5).setForeground(Color.RED);
                                    _textField.get(5).requestFocus();
                                } else {
                                    int count;
                                    List<TClientes> listEmail = clientes().stream()
                                            .filter(u -> u.getEmail().equals(_textField.get(3).getText()))
                                            .collect(Collectors.toList());
                                    count = listEmail.size();
                                    List<TClientes> listNid = clientes().stream()
                                            .filter(u -> u.getNid().equals(_textField.get(0).getText()))
                                            .collect(Collectors.toList());
                                    count += listNid.size();
                                    switch (_accion) {
                                        case "insert":
                                             try {
                                            if (count == 0) {
                                                Insert();
                                            } else {
                                                if (!listEmail.isEmpty()) {
                                                    _label.get(3).setText("El email ya esta registrado");
                                                    _label.get(3).setForeground(Color.RED);
                                                    _textField.get(3).requestFocus();
                                                }
                                                if (!listNid.isEmpty()) {
                                                    _label.get(0).setText("El nid ya esta registrado");
                                                    _label.get(0).setForeground(Color.RED);
                                                    _textField.get(0).requestFocus();
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            JOptionPane.showMessageDialog(null, ex);
                                        }
                                        break;
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void Insert() throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner(true);
            getConn().setAutoCommit(false);
            byte[] image = uploadimagen.getImageByte();
            if (image == null) {
                image = Objetos.uploadimagen.getTransFoto(_label.get(6));
            }
            String sqlCliente = "INSERT INTO tclientes(Nid,Nombre, Apellido,Email,"
                    + " Telefono,Direccion,Credito,Fecha,Imagen) VALUES(?,?,?,?,?,?,?,?,?)";
            Object[] dataCliente = {
                _textField.get(0).getText(),
                _textField.get(1).getText(),
                _textField.get(2).getText(),
                _textField.get(3).getText(),
                _textField.get(4).getText(),
                _textField.get(5).getText(),
                _checkBoxCredito.isSelected(),//tynyint
                new Calendario().getFecha(),
                image,};
            qr.insert(getConn(), sqlCliente, new ColumnListHandler(), dataCliente);
            String sqlReport = "INSERT INTO treportes_clientes (DeudaActual,FechaDeuda,"
                    + " UltimoPago,FechaPago,Ticket,FechaLimite,IdCliente)"
                    + " VALUES (?,?,?,?,?,?,?)";
            List<TClientes> cliente = clientes();
            Object[] dataReport = {
                0,
                "--/--/--",
                0,
                "--/--/--",
                "0000000000",
                "--/--/--",
                cliente.get(cliente.size() - 1).getID(),};
            qr.insert(getConn(), sqlReport, new ColumnListHandler(), dataReport);
            getConn().commit();

        } catch (SQLException ex) {
            getConn().rollback();
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
