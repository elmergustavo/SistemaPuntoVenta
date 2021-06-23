/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexion.Conexion;
import Conexion.Consult;
import Library.Calendario;
import Library.Objectos;
import Library.Paginador;
import Library.Render_CheckBox;
import Library.Uploadimage;
import Models.TClientes;
import Models.TReportes_clientes;
import Models.TSuministro;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

/**
 *
 * @author elmer
 */
public class SuministroVM extends Consult {

    private String _accion = "insert";
    private final  ArrayList<JLabel> _label;
    private final  ArrayList<JTextField> _textField;
    private final  JTable _tableSuministro, _tableBodega;
    private DefaultTableModel modelo1;
    private   JSpinner _spinnerPaginas;
    private int _idCliente = 0;
    private  int _reg_por_pagina = 10;
    private  int _num_pagina = 1;
    public int seccion;
    private Paginador<TSuministro> _paginadorSuministro;
    private boolean Insert;
    private boolean Update;

    private final Conexion conexion;

    public SuministroVM(Object[] objects, ArrayList<JLabel> label, ArrayList<JTextField> textField) {
        this.conexion = Conexion.createInstance();
        _label = label;
        _textField = textField;
        _tableSuministro = (JTable) objects[0];
        _tableBodega = (JTable) objects[1];
        _spinnerPaginas = (JSpinner) objects[2];
         restablecer();
       //  RestablecerReport();
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
            _label.get(0).setText("Ingrese el codigo");
            _label.get(0).setForeground(Color.RED);
            _textField.get(0).requestFocus();
        } else {
            if (_textField.get(1).getText().equals("")) {
                _label.get(1).setText("Ingrese el nombre");
                _label.get(1).setForeground(Color.RED);
                _textField.get(1).requestFocus();
            } else {
                if (_textField.get(2).getText().equals("")) {
                    _label.get(2).setText("Ingrese el stock");
                    _label.get(2).setForeground(Color.RED);
                    _textField.get(2).requestFocus();
                } else {
                    if (_textField.get(3).getText().equals("")) {
                        _label.get(3).setText("Ingrese el precio");
                        _label.get(3).setForeground(Color.RED);
                        _textField.get(3).requestFocus();

                    } else {
                        int count;
                        List<TSuministro> listCodigo = suministros().stream()
                                .filter(u -> u.getCodigo().equals(_textField.get(0).getText()))
                                .collect(Collectors.toList());
                        count = listCodigo.size();
                        List<TSuministro> listNombre = suministros().stream()
                                .filter(u -> u.getNombre().equals(_textField.get(1).getText()))
                                .collect(Collectors.toList());
                        count += listNombre.size();
                        try {
                            switch (_accion) {
                                case "insert":
                                    if (count == 0) {
                                        SaveData();
                                    } else {
                                        if (!listCodigo.isEmpty()) {
                                            _label.get(0).setText("El Codigo ya esta registrado");
                                            _label.get(0).setForeground(Color.RED);
                                            _textField.get(0).requestFocus();
                                        }
                                        if (!listNombre.isEmpty()) {
                                            _label.get(1).setText("El nombre ya esta registrado");
                                            _label.get(1).setForeground(Color.RED);
                                            _textField.get(1).requestFocus();
                                        }
                                    }

                                    break;
                                case "update":
                                    if (count == 2) {
                                        if (listCodigo.get(0).getIdSuministro() == _idCliente
                                                && listNombre.get(0).getIdSuministro() == _idCliente) {
                                            SaveData();
                                        } else {
                                            if (listCodigo.get(0).getIdSuministro() != _idCliente) {
                                                _label.get(0).setText("El codigo ya esta registrado");
                                                _label.get(0).setForeground(Color.RED);
                                                _textField.get(0).requestFocus();
                                            }
                                            if (listNombre.get(0).getIdSuministro() != _idCliente) {
                                                _label.get(1).setText("El Nombre ya esta registrado");
                                                _label.get(1).setForeground(Color.RED);
                                                _textField.get(1).requestFocus();
                                            }
                                        }
                                    } else {
                                        if (count == 0) {
                                            SaveData();
                                        } else {
                                            if (!listCodigo.isEmpty()) {
                                                if (listCodigo.get(0).getIdSuministro() == _idCliente) {
                                                    SaveData();
                                                } else {
                                                    _label.get(0).setText("El codigo ya esta registrado");
                                                    _label.get(0).setForeground(Color.RED);
                                                    _textField.get(0).requestFocus();
                                                }
                                            }
                                            if (!listNombre.isEmpty()) {
                                                if (listNombre.get(0).getIdSuministro() == _idCliente) {
                                                    SaveData();
                                                } else {
                                                    _label.get(1).setText("El nombre ya esta registrado");
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
        }
    }

    // Guardar los suministros en la base de datos
    private void SaveData() throws SQLException {
        try {

            final QueryRunner qr = new QueryRunner(true);
            conexion.getConnection().setAutoCommit(false);
            switch (_accion) {
                case "insert":
                    String sqlInventario1 = "INSERT INTO suministros(Codigo, Nombre, Stock,Precio)"
                            + " VALUES(?,?,?,?)";
                    Object[] dataInventarioSuministro = {
                        _textField.get(0).getText(),
                        _textField.get(1).getText(),
                        _textField.get(2).getText(),
                        _textField.get(3).getText(),};
                    qr.insert(conexion.getConnection(), sqlInventario1, new ColumnListHandler(), dataInventarioSuministro);
                    List<TSuministro> suministro = suministros();
                    suministro.get(suministro.size() -1).getIdSuministro();
                    Insert = true;
                    break;
                case "update":
                    Object[] dataCliente2 = {
                        _textField.get(0).getText(),
                        _textField.get(1).getText(),
                        _textField.get(2).getText(),
                        _textField.get(3).getText(),};
                    String sqlInventario2 = "UPDATE suministros SET Codigo = ?,Nombre = ?,Stock = ?,"
                            + "Precio = ? WHERE IdSuministro =" + _idCliente;
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

     
    public void GetCliente() {
        _accion = "update";
        System.out.println("entro a getCliente");
        int filas = _tableSuministro.getSelectedRow();
        _idCliente = (Integer) modelo1.getValueAt(filas, 0);
        _textField.get(0).setText((String) modelo1.getValueAt(filas, 1));
        _textField.get(1).setText((String) modelo1.getValueAt(filas, 2));
        _textField.get(2).setText((String) modelo1.getValueAt(filas, 3));
        _textField.get(3).setText((String) modelo1.getValueAt(filas, 4));
    }

    public final void restablecer() {
        seccion = 1;
        _accion = "insert";
        _textField.get(0).setText("");
        _textField.get(1).setText("");
        _textField.get(2).setText("");
        _textField.get(3).setText("");
        _label.get(0).setText("Codigo");
        _label.get(0).setForeground(new Color(102, 102, 102));
        _label.get(1).setText("Nombre");
        _label.get(1).setForeground(new Color(102, 102, 102));
        _label.get(2).setText("Stock");
        _label.get(2).setForeground(new Color(102, 102, 102));
        _label.get(3).setText("Precio");
        _label.get(3).setForeground(new Color(102, 102, 102));
        listSuministros = suministros();
        if (!listSuministros.isEmpty()) {
            _paginadorSuministro = new Paginador<>(listSuministros,
                    _label.get(4), _reg_por_pagina);
        }
        SpinnerNumberModel model = new SpinnerNumberModel(
                new Integer(10), // Dato visualizado al inicio en el spinner 
                new Integer(1), // Límite inferior 
                new Integer(100), // Límite superior 
                new Integer(1) // incremento-decremento 
        );
        _spinnerPaginas.setModel(model);
        SearchClientes("");
    }
    
    private List<TSuministro> listSuministros;
   
    public void SearchClientes(String campo) {
        List<TSuministro> suministroFilter;
        String[] titulos = {"IdSuministro", "Codigo", "Nombre", "Stock",
            "Precio"};
        modelo1 = new DefaultTableModel(null, titulos);
        int inicio = (_num_pagina - 1) * _reg_por_pagina;
        if (campo.equals("")) {
            suministroFilter = suministros().stream()
                    .skip(inicio).limit(_reg_por_pagina) // la cantidad de datos que se muesta en la tabla
                    .collect(Collectors.toList());
        } else {
            suministroFilter = suministros().stream()
                    .filter(C -> C.getCodigo().startsWith(campo) || C.getNombre().startsWith(campo))
                    .skip(inicio).limit(_reg_por_pagina)
                    .collect(Collectors.toList());
        }
        if (!suministroFilter.isEmpty()) {
            suministroFilter.forEach(item -> {
                Object[] registros = {
                    item.getIdSuministro(),
                    item.getCodigo(),
                    item.getNombre(),
                    item.getStock(),
                    item.getPrecio()
                };
                modelo1.addRow(registros);
            });

        }
        _tableSuministro.setModel(modelo1);
        _tableSuministro.setRowHeight(30);
        _tableSuministro.getColumnModel().getColumn(0).setMaxWidth(0);
        _tableSuministro.getColumnModel().getColumn(0).setMinWidth(0);
        _tableSuministro.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        _tableBodega.setModel(modelo1);
        _tableBodega.setRowHeight(30);
        _tableBodega.getColumnModel().getColumn(0).setMaxWidth(0);
        _tableBodega.getColumnModel().getColumn(0).setMinWidth(0);
        _tableBodega.getColumnModel().getColumn(0).setPreferredWidth(0);
      
    }
    
    public void Paginador(String metodo) {
        switch (metodo) {
            case "Primero":
                switch (seccion) {
                    case 1:
                        if (!listSuministros.isEmpty()) {
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
                        if (!listSuministros.isEmpty()) {
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
                        if (!listSuministros.isEmpty()) {
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
                        if (!listSuministros.isEmpty()) {
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
                if (!listSuministros.isEmpty()) {
                    _paginadorSuministro = new Paginador<>(listSuministros,
                            _label.get(4), _reg_por_pagina);
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
