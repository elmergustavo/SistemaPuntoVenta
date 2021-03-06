/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexion.Conexion;
import Library.Paginador;
import Models.CategoriaSQL;
import Models.TCategoria;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.bolivia.combo.SComboBoxBlue;

/**
 *
 * @author elmer
 */
public class CategoriaVM extends CategoriaSQL {

    private String _accion = "insert";
    private  ArrayList<JLabel> _label;
    private  ArrayList<JTextField> _textField;
    private  JTable _tableCategoria;
    private DefaultTableModel modelo1;
    private  JSpinner _spinnerPaginas;
    private int _idCliente = 0;
    private int _reg_por_pagina = 100;
    private int _num_pagina = 1;
    public int seccion;
    private Paginador<TCategoria> _paginadorSuministro;
    private boolean Insert;
    private boolean Update;
    private SComboBoxBlue categoria;

    private  Conexion conexion;
    
    public CategoriaVM (){
        
    }

    public void Componentes(Object[] objects, ArrayList<JLabel> label, ArrayList<JTextField> textField) {
        this.conexion = Conexion.createInstance();
        _label = label;
        _textField = textField;
        _tableCategoria = (JTable) objects[0];
        _spinnerPaginas = (JSpinner) objects[1];
        categoria = (SComboBoxBlue) objects[2];
        restablecer();
        this.Insert = false;
        this.Update = false;
    }

    // <editor-fold defaultstate="collapsed" desc="SET AND GET Alertas">  
    public boolean getInsert() {
        return Insert;
    }

    public void setInsert(boolean Insert) {
        this.Insert = Insert;
    }

    public boolean getUpdate() {
        return Update;
    }

    public void setUpdate(boolean Update) {
        this.Update = Update;
    }
    // </editor-fold>

    public void RegistrarSuministro() {
        if (_textField.get(0).getText().equals("")) {
            _label.get(0).setText("Ingrese el Nombre");
            _label.get(0).setForeground(Color.RED);
            _textField.get(0).requestFocus();
        } else {
            if (_textField.get(1).getText().equals("")) {
                _label.get(1).setText("Ingrese el Descripcion");
                _label.get(1).setForeground(Color.RED);
                _textField.get(1).requestFocus();
            } else {
                int count;
                List<TCategoria> listNombre = categorias().stream()
                        .filter(u -> u.getCategoria().equals(_textField.get(0).getText()))
                        .collect(Collectors.toList());
                count = listNombre.size();
                List<TCategoria> listDescripcion = categorias().stream()
                        .filter(u -> u.getDescripcion().equals(_textField.get(1).getText()))
                        .collect(Collectors.toList());
                count += listNombre.size();
                try {
                    switch (_accion) {
                        case "insert":
                            if (count == 0) {
                                SaveData();
                            } else {
                                if (!listNombre.isEmpty()) {
                                    _label.get(0).setText("El Nombre ya esta registrado");
                                    _label.get(0).setForeground(Color.RED);
                                    _textField.get(0).requestFocus();
                                }
                                if (!listDescripcion.isEmpty()) {
                                    _label.get(1).setText("la descrip ya esta registrado");
                                    _label.get(1).setForeground(Color.RED);
                                    _textField.get(1).requestFocus();
                                }
                            }
                            break;
                        case "update":
                            if (count == 2) {
                                if (listNombre.get(0).getIdCat()== _idCliente
                                        && listDescripcion.get(0).getIdCat()== _idCliente) {
                                    SaveData();
                                } else {
                                    if (listNombre.get(0).getIdCat()!= _idCliente) {
                                        _label.get(0).setText("El Nombre ya esta registrado");
                                        _label.get(0).setForeground(Color.RED);
                                        _textField.get(0).requestFocus();
                                    }
                                    if (listDescripcion.get(0).getIdCat()!= _idCliente) {
                                        _label.get(1).setText("la descrip ya esta registrado");
                                        _label.get(1).setForeground(Color.RED);
                                        _textField.get(1).requestFocus();
                                    }
                                }
                            } else {
                                if (count == 0) {
                                    SaveData();
                                } else {
                                    if (!listNombre.isEmpty()) {
                                        if (listNombre.get(0).getIdCat()== _idCliente) {
                                            SaveData();
                                        } else {
                                            _label.get(0).setText("El Nombre ya esta registrado");
                                            _label.get(0).setForeground(Color.RED);
                                            _textField.get(0).requestFocus();
                                        }
                                    }
                                    if (!listDescripcion.isEmpty()) {
                                        if (listDescripcion.get(0).getIdCat()== _idCliente) {
                                            SaveData();
                                        } else {
                                            _label.get(1).setText("La descrip ya esta registrado");
                                            _label.get(1).setForeground(Color.RED);
                                            _textField.get(1).requestFocus();
                                        }
                                    }
                                }
                            }
                            break;
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }

    // Guardar los suministros en la base de datos
    private void SaveData() throws SQLException {
        try {

            final QueryRunner qr = new QueryRunner(true);
            conexion.getConnection().setAutoCommit(false);
            switch (_accion) {
                case "insert":
                    String sqlInventario1 = "INSERT INTO categorias(Categoria, Descripcion)"
                            + " VALUES(?,?)";
                    Object[] dataInventarioSuministro = {
                        _textField.get(0).getText(),
                        _textField.get(1).getText()};
                    qr.insert(conexion.getConnection(), sqlInventario1, new ColumnListHandler(), dataInventarioSuministro);
//                    List<TCategoria> categoria = categorias();
//                    categoria.get(categoria.size() - 1).getIdCat();
                    Insert = true;
                    break;
                case "update":
                    Object[] dataCliente2 = {
                        _textField.get(0).getText(),
                        _textField.get(1).getText(),
                        };
                    String sqlInventario2 = "UPDATE categorias SET Categoria = ?,Descripcion = ?"
                            + " WHERE idCat =" + _idCliente;
                    qr.update(conexion.getConnection(), sqlInventario2, dataCliente2);
                    Update = true;
                    break;
            }

            conexion.getConnection().commit();
            restablecer();
        } catch (SQLException ex) {
            conexion.getConnection().rollback();
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void GetCategoria() {
        _accion = "update";
        int filas = _tableCategoria.getSelectedRow();
        _idCliente = (Integer) modelo1.getValueAt(filas, 0);
        _textField.get(0).setText((String) modelo1.getValueAt(filas, 1));
        _textField.get(1).setText((String) modelo1.getValueAt(filas, 2));
    }
private List<TCategoria> listCategorias;
    public final void restablecer() {
        seccion = 1;
        _accion = "insert";
        _textField.get(0).setText("");
        _textField.get(1).setText("");
        _label.get(0).setText("Nombre");
        _label.get(0).setForeground(new Color(102, 102, 102));
        _label.get(1).setText("Descripci??n");
        _label.get(1).setForeground(new Color(102, 102, 102));
        listCategorias = categorias();
        if (!listCategorias.isEmpty()) {
            _paginadorSuministro = new Paginador<>(listCategorias,
                    _label.get(2), _reg_por_pagina);
        }
        SpinnerNumberModel model = new SpinnerNumberModel(
                new Integer(10), // Dato visualizado al inicio en el spinner 
                new Integer(1), // L??mite inferior 
                new Integer(100), // L??mite superior 
                new Integer(1) // incremento-decremento 
        );
        _spinnerPaginas.setModel(model);
        categoria.removeAllItems();
        SearchClientes("");
    }

    

    public void SearchClientes(String campo) {
        List<TCategoria> categoriaFilter;
        String[] titulos = {"IdCat", "Nombre", "Descripcion"};
        modelo1 = new DefaultTableModel(null, titulos);
        int inicio = (_num_pagina - 1) * _reg_por_pagina;
        if (campo.equals("")) {
            categoriaFilter = categorias().stream()
                    .skip(inicio).limit(_reg_por_pagina) // la cantidad de datos que se muesta en la tabla
                    .collect(Collectors.toList());
        } else {
            categoriaFilter = categorias().stream()
                    .filter(C -> C.getCategoria().startsWith(campo) || C.getDescripcion().startsWith(campo))
                    .skip(inicio).limit(_reg_por_pagina)
                    .collect(Collectors.toList());
        }
        if (!categoriaFilter.isEmpty()) {
            categoriaFilter.forEach(item -> {
                Object[] registros2 = {
                    item.getIdCat(),
                    item.getCategoria(),
                    item.getDescripcion(),
                    
                };
                categoria.addItem(item.getCategoria());
                modelo1.addRow(registros2);
            });

        }
        _tableCategoria.setModel(modelo1);
        _tableCategoria.setRowHeight(30);
        _tableCategoria.getColumnModel().getColumn(0).setMaxWidth(0);
        _tableCategoria.getColumnModel().getColumn(0).setMinWidth(0);
        _tableCategoria.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    public void Paginador(String metodo) {
        switch (metodo) {
            case "Primero":
                switch (seccion) {
                    case 1:
                        if (!listCategorias.isEmpty()) {
                            _num_pagina = _paginadorSuministro.primero();
                        }
                        break;
//                    case 2:
//                        if (!listReportes.isEmpty()) {
//                            _num_pagina = _paginadorReportes.primero();
//                        }
//                        break;
                }
                break;
            case "Anterior":
                switch (seccion) {
                    case 1:
                        if (!listCategorias.isEmpty()) {
                            _num_pagina = _paginadorSuministro.anterior();
                        }
                        break;
//                    case 2:
//                        if (!listReportes.isEmpty()) {
//                            _num_pagina = _paginadorReportes.anterior();
//                        }
//                        break;
                }
                break;
            case "Siguiente":
                switch (seccion) {
                    case 1:
                        if (!listCategorias.isEmpty()) {
                            _num_pagina = _paginadorSuministro.siguiente();
                        }
                        break;
//                    case 2:
//                        if (!listReportes.isEmpty()) {
//                            _num_pagina = _paginadorReportes.siguiente();
//                        }
//                        break;
                }
                break;
            case "Ultimo":
                switch (seccion) {
                    case 1:
                        if (!listCategorias.isEmpty()) {
                            _num_pagina = _paginadorSuministro.ultimo();
                        }
                        break;
//                    case 2:
//                        if (!listReportes.isEmpty()) {
//                            _num_pagina = _paginadorReportes.ultimo();
//                        }
//                        break;
                }
                break;
        }
        switch (seccion) {
            case 1:
                SearchClientes("");
                break;
//            case 2:
//                SearchReportes("");
//                break;
        }
    }

    public void Registro_PaginasInventario() {
        _num_pagina = 1;
        Number caja = (Number) _spinnerPaginas.getValue();
        _reg_por_pagina = caja.intValue();
        switch (seccion) {
            case 1:
                if (!listCategorias.isEmpty()) {
                    _paginadorSuministro = new Paginador<>(listCategorias,
                            _label.get(3), _reg_por_pagina);
                }
                SearchClientes("");
                break;
//            case 2:
//                if (!listReportes.isEmpty()) {
//                    _paginadorReportes = new Paginador<>(listReportes,
//                            _label.get(7), _reg_por_pagina);
//                }
//                SearchReportes("");
//                break;
        }

    }
}
