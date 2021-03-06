/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexion.Conexion;
import Library.GenerarCodigos;
import Library.Paginador;
import Models.SuministroSQL;
import Models.TSuministro;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.bolivia.combo.SComboBoxBlue;

/**
 *
 * @author elmer
 */
public class SuministroVM extends SuministroSQL {

    private String _accion = "insert";
    private  ArrayList<JLabel> _label;
    private  ArrayList<JTextField> _textField;
    private  JTable _tableSuministro, _tableBodega;
    private DefaultTableModel modelo1;
    private JSpinner _spinnerPaginas;
    private int _idCliente = 0;
    private int _reg_por_pagina = 10;
    private int _num_pagina = 1;
    public int seccion;
    private Paginador<TSuministro> _paginadorSuministro;
    private boolean Insert;
    private boolean Update;
    private SComboBoxBlue categoria;

    private  Conexion conexion;
    
    public SuministroVM (){
    }

    public void Componentes(Object[] objects, ArrayList<JLabel> label, ArrayList<JTextField> textField) {
        this.conexion = Conexion.createInstance();
        _label = label;
        _textField = textField;
        _tableSuministro = (JTable) objects[0];
        _tableBodega = (JTable) objects[1];
        _spinnerPaginas = (JSpinner) objects[2];
        categoria = (SComboBoxBlue) objects[3];
        restablecerSuministro();
        
        
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
            _label.get(0).setText("!Llenar!");
            _label.get(0).setForeground(Color.RED);
            _textField.get(0).requestFocus();
        } else {
            if (_textField.get(1).getText().equals("")) {
                _label.get(1).setText("!Llenar!");
                _label.get(1).setForeground(Color.RED);
                _textField.get(1).requestFocus();
            } else {
                if (_textField.get(2).getText().equals("")) {
                    _label.get(2).setText("!Llenar!");
                    _label.get(2).setForeground(Color.RED);
                    _textField.get(2).requestFocus();
                } else {
                    if (_textField.get(3).getText().equals("")) {
                        _label.get(3).setText("!Llenar!");
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
                                            _label.get(0).setText("!Ya existe!");
                                            _label.get(0).setForeground(Color.RED);
                                            _textField.get(0).requestFocus();
                                        }
                                        if (!listNombre.isEmpty()) {
                                            _label.get(1).setText("!Ya existe!");
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
                                                _label.get(0).setText("!Ya existe!");
                                                _label.get(0).setForeground(Color.RED);
                                                _textField.get(0).requestFocus();
                                            }
                                            if (listNombre.get(0).getIdSuministro() != _idCliente) {
                                                _label.get(1).setText("!Ya existe!");
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
                                                    _label.get(0).setText("!Ya existe!");
                                                    _label.get(0).setForeground(Color.RED);
                                                    _textField.get(0).requestFocus();
                                                }
                                            }
                                            if (!listNombre.isEmpty()) {
                                                if (listNombre.get(0).getIdSuministro() == _idCliente) {
                                                    SaveData();
                                                } else {
                                                    _label.get(1).setText("!Ya existe!");
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
            conexion.getConnection().setAutoCommit(false);
            switch (_accion) {
                case "insert":
                    Object[] dataInventarioSuministro = {
                        _textField.get(0).getText(),
                        _textField.get(1).getText(),
                        _textField.get(2).getText(),
                        _textField.get(3).getText(),
                        categoria.getSelectedItem().toString()
                            };
                    InsertSuministro(dataInventarioSuministro); 
                    Insert = true;
                    break;
                case "update":
                    Object[] dataCliente2 = {
                        _textField.get(0).getText(),
                        _textField.get(1).getText(),
                        _textField.get(2).getText(),
                        _textField.get(3).getText(),
                        categoria.getSelectedItem().toString()};
                    UpdateSuministro(dataCliente2, _idCliente);
                    Update = true;
                    break;
            }
            conexion.getConnection().commit();
            restablecerSuministro();
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
        categoria.setSelectedItem((String) modelo1.getValueAt(filas, 5));
    }
    
    

    public final void restablecerSuministro() {
        seccion = 1;
        _accion = "insert";
        categoria.setSelectedItem("CATEGORIA");
        _textField.get(0).setText("");
        _textField.get(1).setText("");
        _textField.get(2).setText("");
        _textField.get(3).setText("");
        _label.get(0).setText("");
        _label.get(0).setForeground(new Color(102, 102, 102));
        _label.get(1).setText("");
        _label.get(1).setForeground(new Color(102, 102, 102));
        _label.get(2).setText("");
        _label.get(2).setForeground(new Color(102, 102, 102));
        _label.get(3).setText("");
        _label.get(3).setForeground(new Color(102, 102, 102));
        listSuministros = suministros();
        if (!listSuministros.isEmpty()) {
            _paginadorSuministro = new Paginador<>(listSuministros,
                    _label.get(4), _reg_por_pagina);
        }
        SpinnerNumberModel model = new SpinnerNumberModel(
                new Integer(10), // Dato visualizado al inicio en el spinner 
                new Integer(1), // L??mite inferior 
                new Integer(100), // L??mite superior 
                new Integer(1) // incremento-decremento 
        );
        _spinnerPaginas.setModel(model);
        SearchClientes("");
        extraerIDSuministro();
        
    }

    private List<TSuministro> listSuministros;

    public void SearchClientes(String campo) {
        List<TSuministro> suministroFilter;
        String[] titulos = {"IdSuministro", "Codigo", "Nombre", "Stock",
            "Precio", "Categoria"};
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
                    item.getPrecio(),
                    item.getCategoria(),
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
    
    public void extraerIDSuministro() {
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(Codigo) FROM suministros";
        try {
            Statement st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                _textField.get(0).setText("SM0001");
            } else {
                char r1 = c.charAt(2);
                char r2 = c.charAt(3);
                char r3 = c.charAt(4);
                char r4 = c.charAt(5);
                String r = "";
                r = "" + r1 + r2 + r3 + r4;
                j = Integer.parseInt(r);
                GenerarCodigos gen = new GenerarCodigos();
                gen.generar(j);
                _textField.get(0).setText("SM" + gen.serie());            
            }

        } catch (SQLException ex) {
          //  Logger.getLogger(OpcionesAl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                }
                break;
            case "Anterior":
                switch (seccion) {
                    case 1:
                        if (!listSuministros.isEmpty()) {
                            _num_pagina = _paginadorSuministro.anterior();
                        }
                        break;
                }
                break;
            case "Siguiente":
                switch (seccion) {
                    case 1:
                        if (!listSuministros.isEmpty()) {
                            _num_pagina = _paginadorSuministro.siguiente();
                        }
                        break;
                }
                break;
            case "Ultimo":
                switch (seccion) {
                    case 1:
                        if (!listSuministros.isEmpty()) {
                            _num_pagina = _paginadorSuministro.ultimo();
                        }
                        break;
                }
        }
        switch (seccion) {
            case 1:
                SearchClientes("");
                break;

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
        }

    }
}
