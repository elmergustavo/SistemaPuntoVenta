/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Models.TCategoria;
import Models.TClientes;
import Models.TReportes_clientes;
import Models.TSuministro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Gustavo
 */
public class Consult /*extends Conexion*/ {
    private Conexion conexion = Conexion.createInstance();
    private QueryRunner QR = new QueryRunner();

    public List<TClientes> clientes() {
        List<TClientes> cliente = new ArrayList();
        try {
            cliente = (List<TClientes>) QR.query(conexion.getConnection(), "SELECT * FROM tclientes",
                    new BeanListHandler(TClientes.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex);
        }
        return cliente;
    }

    public List<TReportes_clientes> reportesClientes() {
        String where = "";
        List<TReportes_clientes> reportes = new ArrayList();
        String condicion = " tclientes.ID = treportes_clientes.IdCliente ";
        String campos = " tclientes.ID,tclientes.Nid,tclientes.Nombre,tclientes.Apellido,"
                + "treportes_clientes.IdReporte,treportes_clientes.DeudaActual,"
                + "treportes_clientes.FechaDeuda,treportes_clientes.UltimoPago,"
                + "treportes_clientes.FechaPago, treportes_clientes.Ticket,"
                + "treportes_clientes.FechaLimite";
        try {
            reportes = (List<TReportes_clientes>) QR.query(conexion.getConnection(),
                    "SELECT" + campos + " FROM treportes_clientes Inner Join tclientes ON"
                    + condicion + where, new BeanListHandler(TReportes_clientes.class));
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
        return reportes;
    }
    
    
    public List<TSuministro> suministros() {
        List<TSuministro> suministro = new ArrayList();
        try {
            suministro = (List<TSuministro>) QR.query(conexion.getConnection(), "SELECT * FROM suministros",
                    new BeanListHandler(TSuministro.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex);
        }
        return suministro;
    }
    
    public List<TCategoria> categorias() {
        List<TCategoria> categoria = new ArrayList();
        try {
            categoria = (List<TCategoria>) QR.query(conexion.getConnection(), "SELECT * FROM categorias",
                    new BeanListHandler(TCategoria.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex);
        }
        return categoria;
    }

}

