/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexion.Conexion;
import Library.Paginador;
import Models.AlimentoSQL;
import Models.TAlimentos;
import app.bolivia.swing.JCTextField;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import org.bolivia.combo.SComboBoxBlue;

/**
 *
 * @author elmer
 */
public final class AlimentosVM extends AlimentoSQL {

    private String _accion = "insert";
    private  ArrayList<JLabel> _label;
    private  ArrayList<JCTextField> _textField;
    private  JTable _tableAlimentos;
    private DefaultTableModel modelo1;
    private  JSpinner _spinnerPaginas;
    private int _idAlimento = 0;
    private int _reg_por_pagina = 10;
    private int _num_pagina = 1;
    public int seccion;
    private Paginador<TAlimentos> _paginadorAlimentos;
    private  SComboBoxBlue TipoAl;
    private List<TAlimentos> listAlimentos;
    private boolean Insert;
    private boolean Update;

   // private final Conexion conexion;
    static PreparedStatement ps;
    
    public AlimentosVM (){
        
    }

    public void Componentes(Object[] objects, ArrayList<JLabel> label, ArrayList<JCTextField> textField) {
   //     this.conexion = Conexion.createInstance();
        _label = label;
        _textField = textField;
        _tableAlimentos = (JTable) objects[0];
        _spinnerPaginas = (JSpinner) objects[1];
        TipoAl = (SComboBoxBlue) objects[2];
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
            _label.get(0).setText("llenar");
            _label.get(0).setForeground(Color.RED);
            _textField.get(0).requestFocus();
        } else {
            if (_textField.get(1).getText().equals("")) {
                _label.get(1).setText("llenar");
                _label.get(1).setForeground(Color.RED);
                _textField.get(1).requestFocus();
            } else {
                if (_textField.get(2).getText().equals("")) {
                    _label.get(2).setText("llenar");
                    _label.get(2).setForeground(Color.RED);
                    _textField.get(2).requestFocus();
                } else {
                    int count;
                    List<TAlimentos> listCodigo = alimentos().stream()
                            .filter(u -> u.getCodigo_al().equals(_textField.get(0).getText()))
                            .collect(Collectors.toList());
                    count = listCodigo.size();
                    List<TAlimentos> listNombre = alimentos().stream()
                            .filter(u -> u.getNombre_al().equals(_textField.get(1).getText()))
                            .collect(Collectors.toList());
                    count += listNombre.size();
                    try {
                        switch (_accion) {
                            case "insert":
                                if (count == 0) {
                                    SaveData();
                                } else {
                                    if (!listCodigo.isEmpty()) {
                                        _label.get(0).setText("!Ya existe¡");
                                        _label.get(0).setForeground(Color.RED);
                                        _textField.get(0).requestFocus();
                                    }
                                    if (!listNombre.isEmpty()) {
                                        _label.get(1).setText("!Ya existe¡");
                                        _label.get(1).setForeground(Color.RED);
                                        _textField.get(1).requestFocus();
                                    }
                                }
                                break;
                            case "update":
                                if (count == 2) {
                                    if (listCodigo.get(0).getIdAl() == _idAlimento
                                            && listNombre.get(0).getIdAl() == _idAlimento) {
                                        SaveData();
                                    } else {
                                        if (listCodigo.get(0).getIdAl() != _idAlimento) {
                                            _label.get(0).setText("!Ya existe¡");
                                            _label.get(0).setForeground(Color.RED);
                                            _textField.get(0).requestFocus();
                                        }
                                        if (listNombre.get(0).getIdAl() != _idAlimento) {
                                            _label.get(1).setText("!Ya existe¡");
                                            _label.get(1).setForeground(Color.RED);
                                            _textField.get(1).requestFocus();
                                        }
                                    }
                                } else {
                                    if (count == 0) {
                                        SaveData();
                                    } else {
                                        if (!listCodigo.isEmpty()) {
                                            if (listCodigo.get(0).getIdAl() == _idAlimento) {
                                                SaveData();
                                            } else {
                                                _label.get(0).setText("!Ya existe¡");
                                                _label.get(0).setForeground(Color.RED);
                                                _textField.get(0).requestFocus();
                                            }
                                        }
                                        if (!listNombre.isEmpty()) {
                                            if (listNombre.get(0).getIdAl() == _idAlimento) {
                                                SaveData();
                                            } else {
                                                _label.get(1).setText("!Ya existe¡");
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

    // Guardar los suministros en la base de datos
    private void SaveData() throws SQLException {
        switch (_accion) {
            case "insert":
                Object[] dataInventarioSuministro = {
                    _textField.get(0).getText(),
                    _textField.get(1).getText(),
                    _textField.get(2).getText(),
                    TipoAl.getSelectedItem().toString()
                };
                insertAlimento(dataInventarioSuministro);
                Insert = true;
                break;
            case "update":
                Object[] dataCliente2 = {
                    _textField.get(0).getText(),
                    _textField.get(1).getText(),
                    _textField.get(2).getText(),
                    TipoAl.getSelectedItem().toString()
                };
                updateAlimento(dataCliente2, _idAlimento);
                Update = true;
                break;
        }
        restablecer();
    }

    public void GetCliente() {
        _accion = "update";
        int filas = _tableAlimentos.getSelectedRow();
        _idAlimento = (Integer) modelo1.getValueAt(filas, 0);
        _textField.get(0).setText((String) modelo1.getValueAt(filas, 1));
        _textField.get(1).setText((String) modelo1.getValueAt(filas, 2));
        _textField.get(2).setText((String) modelo1.getValueAt(filas, 3));
        TipoAl.setSelectedItem((String) modelo1.getValueAt(filas, 4));
    }

    public final void restablecer() {
        seccion = 1;
        _accion = "insert";
        TipoAl.setSelectedItem("TIPO ALIMENTO");
        _textField.get(0).setText("");
        _textField.get(1).setText("");
        _textField.get(2).setText("");
        _label.get(0).setText("");
        _label.get(0).setForeground(new Color(102, 102, 102));
        _label.get(1).setText("");
        _label.get(1).setForeground(new Color(102, 102, 102));
        _label.get(2).setText("");
        _label.get(2).setForeground(new Color(102, 102, 102));
        listAlimentos = alimentos();
        if (!listAlimentos.isEmpty()) {
            _paginadorAlimentos = new Paginador<>(listAlimentos,
                    _label.get(3), _reg_por_pagina);
        }
        SpinnerNumberModel model = new SpinnerNumberModel(
                new Integer(10), // Dato visualizado al inicio en el spinner 
                new Integer(1), // Límite inferior 
                new Integer(100), // Límite superior 
                new Integer(1) // incremento-decremento 
        );
        _spinnerPaginas.setModel(model);
        SearchClientes("");
        _textField.get(0).setText(extraerID());
    }

    public void SearchClientes(String campo) {
        List<TAlimentos> AlimentosFilter;
        String[] titulos = {"IdAl", "Codigo", "Nombre", "Precio $", "Tipo Alimento"};
        modelo1 = new DefaultTableModel(null, titulos);
        int inicio = (_num_pagina - 1) * _reg_por_pagina;
        if (campo.equals("")) {
            AlimentosFilter = alimentos().stream()
                    .skip(inicio).limit(_reg_por_pagina) // la cantidad de datos que se muesta en la tabla
                    .collect(Collectors.toList());
        } else {
            AlimentosFilter = alimentos().stream()
                    .filter(C -> C.getCodigo_al().startsWith(campo) || C.getNombre_al().startsWith(campo)
                    || C.getTipo_al().startsWith(campo))
                    .skip(inicio).limit(_reg_por_pagina)
                    .collect(Collectors.toList());
        }
        if (!AlimentosFilter.isEmpty()) {
            AlimentosFilter.forEach(item -> {
                Object[] registros = {
                    item.getIdAl(),
                    item.getCodigo_al(),
                    item.getNombre_al(),
                    item.getPrecio_al(),
                    item.getTipo_al()
                };
                modelo1.addRow(registros);
            });
        }
        _tableAlimentos.setModel(modelo1);
        _tableAlimentos.setRowHeight(30);
        _tableAlimentos.getColumnModel().getColumn(0).setMaxWidth(0);
        _tableAlimentos.getColumnModel().getColumn(0).setMinWidth(0);
        _tableAlimentos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    public void deleteCliente() {
        delete(_idAlimento);
    }
}
