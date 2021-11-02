package Controller;

import Library.Encriptar;
import Library.Objectos;

import Models.Ordenador.Tordenadores;
import Models.UsuarioSQL;
import Models.Usuarios.TUsuarios;
import Library.Ordenador;
import alertas.AlertError;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

/**
 *
 * @author Gustavo
 */
public class LoginVM extends UsuarioSQL {

    private ArrayList<JLabel> _label;
    private ArrayList<JTextField> _textField;
    private List<TUsuarios> listUsuarios;

    public LoginVM(ArrayList<JLabel> label, ArrayList<JTextField> textField) {
        _label = label;
        _textField = textField;
    }

    public LoginVM() {

    }

    public Object[] Login() throws SQLException {

        if (_textField.get(0).getText().equals("")) {
            _label.get(0).setText("Ingrese el usario");
            _label.get(0).setForeground(Color.RED);
            _textField.get(0).requestFocus();
           // listUsuarios.clear();

        } else {
            if (!Objectos.eventos.isEmail(_textField.get(0).getText())) {
                _label.get(0).setText("Ingrese un email valido");
                _label.get(0).setForeground(Color.RED);
                _textField.get(0).requestFocus();
                
                //System.exit(0);
                
            } else {
                if (_textField.get(1).getText().equals("")) {
                    _label.get(1).setText("Ingrese el password");
                    _label.get(1).setForeground(Color.RED);
                    _textField.get(1).requestFocus();
                  //  listUsuarios.clear();
                } else {

                    listUsuarios = Usuarios().stream()
                            .filter(u -> u.getEmail().equals(_textField.get(0).getText()))
                            .collect(Collectors.toList());
                    if (!listUsuarios.isEmpty()) {
                        try {
                            if (listUsuarios.get(0).isState()) {
                                String password = Encriptar.decrypt(listUsuarios.get(0).getPassword());
                                if (password.equals(_textField.get(1).getText())) {

                                    Date date = new Date();
                                    String hdd = Ordenador.getSerialNumber('c');
                                    final QueryRunner qr = new QueryRunner(true);
                                    conexion.getConnection().setAutoCommit(false);
                                    Object[] usuario = {true};
                                    String sql1 = "UPDATE tusuarios SET Is_active = ? "
                                            + "WHERE IdUsuario =" + listUsuarios.get(0).getIdUsuario();
                                    qr.update(conexion.getConnection(), sql1, usuario);
                                    List<Tordenadores> dataOrdenador = Ordenadores().stream()
                                            .filter(o -> o.getOrdenador().equals(hdd))
                                            .collect(Collectors.toList());
                                    if (dataOrdenador.isEmpty()) {
                                        String sql2 = "INSERT INTO tordenadores "
                                                + "(Ordenador,Is_active,Usuario,InFecha,IdUsuario)"
                                                + " VALUES (?,?,?,?,?)";
                                        Object[] ordenador = {
                                            hdd,
                                            true,
                                            listUsuarios.get(0).getEmail(),
                                            date,
                                            listUsuarios.get(0).getIdUsuario()
                                        };
                                        qr.insert(conexion.getConnection(), sql2, new ColumnListHandler(), ordenador);
                                    } else {
                                        Object[] ordenador = {true, listUsuarios.get(0).getEmail(), date,listUsuarios.get(0).getIdUsuario()};
                                        String sql3 = "UPDATE tordenadores SET Is_active = ?,Usuario = ?,"
                                                + "InFecha = ?, IdUsuario = ? WHERE IdOrdenador ="
                                                + dataOrdenador.get(0).getIdOrdenador();
                                        qr.update(conexion.getConnection(), sql3, ordenador);
                                    }
                                    conexion.getConnection().commit();

                                } else {
                                    _label.get(1).setText("Contraseña incorrecta");
                                    _label.get(1).setForeground(Color.RED);
                                    _textField.get(1).requestFocus();
                                    listUsuarios.clear();
                                }
                            } else {
                                listUsuarios.clear();
                                AlertError error = new AlertError(null, true);
                                error.Texto("El usuario no está disponible");
                                error.setVisible(true);
                            }
                        } catch (Exception e) {
                            conexion.getConnection().rollback();
                            JOptionPane.showMessageDialog(null, e);
                        }
                    } else {
                        _label.get(0).setText("El email no esta registrado");
                        _label.get(0).setForeground(Color.RED);
                        _textField.get(0).requestFocus();
                        listUsuarios.clear();
                    }

                }
            }

        }
        Object[] objects = {listUsuarios};
        return objects;
    }

    public Object[] Verificar() {
        listUsuarios = new ArrayList<>();
        try {
            String hdd = Ordenador.getSerialNumber('c');
            List<Tordenadores> dataOrdenador = Ordenadores().stream()
                    .filter(o -> o.getOrdenador().equals(hdd)
                    && o.isIs_active() == true)
                    .collect(Collectors.toList());
            if (!dataOrdenador.isEmpty()) {
                listUsuarios = Usuarios().stream()
                        .filter(u -> u.getEmail().equals(dataOrdenador.get(0).getUsuario()))
                        .collect(Collectors.toList());
            }
        } catch (Exception e) {
        }
        Object[] objects = {listUsuarios};
        return objects;
    }

    public void Close() throws SQLException {
        listUsuarios = new ArrayList<>();
        final QueryRunner qr = new QueryRunner(true);
        conexion.getConnection().setAutoCommit(false);
        try {
            Date date = new Date();
            String hdd = Ordenador.getSerialNumber('c');
            List<Tordenadores> dataOrdenador = Ordenadores().stream()
                    .filter(o -> o.getOrdenador().equals(hdd))
                    .collect(Collectors.toList());
            listUsuarios = Usuarios().stream()
                    .filter(u -> u.getEmail().equals(dataOrdenador.get(0).getUsuario()))
                    .collect(Collectors.toList());
            Object[] usuario = {false};
            String sql1 = "UPDATE tusuarios SET Is_active = ? "
                    + "WHERE IdUsuario =" + listUsuarios.get(0).getIdUsuario();
            qr.update(conexion.getConnection(), sql1, usuario);

            Object[] ordenador = {false, date};
            String sql3 = "UPDATE tordenadores SET Is_active = ?,"
                    + "OutFecha = ? WHERE IdOrdenador ="
                    + dataOrdenador.get(0).getIdOrdenador();
            qr.update(conexion.getConnection(), sql3, ordenador);
            conexion.getConnection().commit();
        } catch (Exception e) {
            conexion.getConnection().rollback();
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
