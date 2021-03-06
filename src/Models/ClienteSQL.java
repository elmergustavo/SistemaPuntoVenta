/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author elmer
 */
public class ClienteSQL {
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
    
    public void delete(String sql, int id) {
        try {
            final QueryRunner qr = new QueryRunner(true);
            if (0 < id) {
                qr.update(conexion.getConnection(), sql, "%" + id + "%");
            } else {
                qr.update(conexion.getConnection(), sql);
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }

    }
}
