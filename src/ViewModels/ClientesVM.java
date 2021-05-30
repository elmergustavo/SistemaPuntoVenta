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
import javax.swing.ImageIcon;
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
    public boolean valor;

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }
    
    public ClientesVM(Object[] objects, ArrayList<JLabel> label, ArrayList<JTextField> textField) {
        _label = label;
        _textField = textField;
        _checkBoxCredito = (JCheckBox) objects[0];
        valor = false;
        new Conexion();
    }

    public void RegistrarCliente() {
        if (_textField.get(0).getText().equals("")) {
            _label.get(0).setText("Ingrese el nid");
            _label.get(0).setForeground(Color.RED);
            _textField.get(0).requestFocus();
            valor = false;
        } else {
            if (_textField.get(1).getText().equals("")) {
                _label.get(1).setText("Ingrese el nombre");
                _label.get(1).setForeground(Color.RED);
                _textField.get(1).requestFocus();
                valor = false;
            } else {
                if (_textField.get(2).getText().equals("")) {
                    _label.get(2).setText("Ingrese el apellido");
                    _label.get(2).setForeground(Color.RED);
                    _textField.get(2).requestFocus();
                    valor = false;
                } else {
                    if (_textField.get(3).getText().equals("")) {
                        _label.get(3).setText("Ingrese el email");
                        _label.get(3).setForeground(Color.RED);
                        _textField.get(3).requestFocus();
                        valor = false;
                    } else {
                        if (!Objetos.eventos.isEmail(_textField.get(3).getText())) {
                            _label.get(3).setText("Ingrese un email valido");
                            _label.get(3).setForeground(Color.RED);
                            _textField.get(3).requestFocus();
                            valor = false;
                        } else {
                            if (_textField.get(4).getText().equals("")) {
                                _label.get(4).setText("Ingrese el telefono");
                                _label.get(4).setForeground(Color.RED);
                                _textField.get(4).requestFocus();
                                valor = false;
                            } else {
                                if (_textField.get(5).getText().equals("")) {
                                    _label.get(5).setText("Ingrese la direccion");
                                    _label.get(5).setForeground(Color.RED);
                                    _textField.get(5).requestFocus();
                                    valor = false;
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
                                                    valor = false;
                                                }
                                                if (!listNid.isEmpty()) {
                                                    _label.get(0).setText("El nid ya esta registrado");
                                                    _label.get(0).setForeground(Color.RED);
                                                    _textField.get(0).requestFocus();
                                                    valor = false;
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
            valor = true;
            restablecer();
        } catch (SQLException ex) {
            getConn().rollback();
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public final void restablecer() {
        _accion = "insert";
        _textField.get(0).setText("");
        _textField.get(1).setText("");
        _textField.get(2).setText("");
        _textField.get(3).setText("");
        _textField.get(4).setText("");
        _textField.get(5).setText("");
        _checkBoxCredito.setSelected(false);
        _checkBoxCredito.setForeground(new Color(102, 102, 102));
        _label.get(0).setText("Nid");
        _label.get(0).setForeground(new Color(102, 102, 102));
        _label.get(1).setText("Nombre");
        _label.get(1).setForeground(new Color(102, 102, 102));
        _label.get(2).setText("Apellido");
        _label.get(2).setForeground(new Color(102, 102, 102));
        _label.get(3).setText("Email");
        _label.get(3).setForeground(new Color(102, 102, 102));
        _label.get(4).setText("Telefono");
        _label.get(4).setForeground(new Color(102, 102, 102));
        _label.get(5).setText("Direccion");
        _label.get(5).setForeground(new Color(102, 102, 102));

//        _label.get(6).setIcon(new ImageIcon(getClass().getClassLoader()
//                .getResource("Recursos/xd.png")));

    }

}
