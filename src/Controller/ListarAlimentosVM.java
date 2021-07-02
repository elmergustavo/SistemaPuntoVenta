/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Library.Paginador;
import Models.AlimentoSQL;
import Models.TAlimentos;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.bolivia.combo.SComboBoxBlue;

/**
 *
 * @author elmer
 */
public class ListarAlimentosVM extends AlimentoSQL{

    private String _accion = "insert";
    
    private final JTable _tableListarPedidos;
    private DefaultTableModel modelo1;
    private int _idAlimento = 0;
    private int _reg_por_pagina = 10;
    private int _num_pagina = 1;
    public int seccion;
    private Paginador<TAlimentos> _paginadorAlimentos;
   // private final SComboBoxBlue TipoAl;
    private List<TAlimentos> listAlimentos;
    private boolean Insert;
    private boolean Update;
    
    
    public ListarAlimentosVM(JTable tabla) {
        this._tableListarPedidos = tabla;
        SearchClientes("");
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
        _tableListarPedidos.setModel(modelo1);
        _tableListarPedidos.setRowHeight(30);
        _tableListarPedidos.getColumnModel().getColumn(0).setMaxWidth(0);
        _tableListarPedidos.getColumnModel().getColumn(0).setMinWidth(0);
        _tableListarPedidos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
}
