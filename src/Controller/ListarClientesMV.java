/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Library.Paginador;
import Library.Render_CheckBox;
import Models.ClienteSQL;
import Models.TAlimentos;
import Models.TClientes;
import static Views.ListarClientes.TablaListadoClientes;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elmer
 */
public class ListarClientesMV extends ClienteSQL {

    private JTable _tableListarClientes;
    private DefaultTableModel modelo1;
    public int seccion;
    private Paginador<TAlimentos> _paginadorAlimentos;
    private List<TAlimentos> listAlimentos;
    private boolean Insert;
    private boolean Update;

    public ListarClientesMV(JTable tabla) {
        this._tableListarClientes = tabla;
        SearchClientess("");
    }

    public void SearchClientess(String campo) {
        List<TClientes> clienteFilter;
        String[] titulos = {"Id", "Nid", "Nombre", "Apellido",
            "Email", "Direccion", "Telefono", "Credito", "Image"};
        modelo1 = new DefaultTableModel(null, titulos);
        //int inicio = (_num_pagina - 1) * _reg_por_pagina;
        if (campo.equals("")) {
            clienteFilter = clientes().stream()
                    .skip(0).limit(100)
                    .collect(Collectors.toList());
        } else {
            clienteFilter = clientes().stream()
                    .filter(C -> C.getNid().startsWith(campo) || C.getNombre().startsWith(campo)
                    || C.getApellido().startsWith(campo))
                    .skip(0).limit(100)
                    .collect(Collectors.toList());
        }
        if (!clienteFilter.isEmpty()) {
            clienteFilter.forEach(item -> {
                Object[] registros = {
                    item.getID(),
                    item.getNid(),
                    item.getNombre(),
                    item.getApellido(),
                    item.getEmail(),
                    item.getDireccion(),
                    item.getTelefono(),
                    item.isCredito(),
                    item.getImagen()
                };
                modelo1.addRow(registros);
            });

        }     
        _tableListarClientes.setModel(modelo1);
        _tableListarClientes.setRowHeight(30);
        _tableListarClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        _tableListarClientes.getColumnModel().getColumn(0).setMinWidth(0);
        _tableListarClientes.getColumnModel().getColumn(0).setPreferredWidth(0);
        _tableListarClientes.getColumnModel().getColumn(8).setMaxWidth(0);
        _tableListarClientes.getColumnModel().getColumn(8).setMinWidth(0);
        _tableListarClientes.getColumnModel().getColumn(8).setPreferredWidth(0);

        _tableListarClientes.getColumnModel().getColumn(4).setMaxWidth(0);
        _tableListarClientes.getColumnModel().getColumn(4).setMinWidth(0);
        _tableListarClientes.getColumnModel().getColumn(4).setPreferredWidth(0);

        _tableListarClientes.getColumnModel().getColumn(5).setMaxWidth(0);
        _tableListarClientes.getColumnModel().getColumn(5).setMinWidth(0);
        _tableListarClientes.getColumnModel().getColumn(5).setPreferredWidth(0);

        _tableListarClientes.getColumnModel().getColumn(7).setMaxWidth(0);
        _tableListarClientes.getColumnModel().getColumn(7).setMinWidth(0);
        _tableListarClientes.getColumnModel().getColumn(7).setPreferredWidth(0);

        _tableListarClientes.getColumnModel().getColumn(7).setCellRenderer(new Render_CheckBox());
    }
}
