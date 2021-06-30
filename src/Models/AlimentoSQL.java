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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

/**
 *
 * @author elmer
 */
public class AlimentoSQL {

    private Conexion conexion = Conexion.createInstance();
    private QueryRunner QR = new QueryRunner();
    private String Id;
    private String sql;

    public List<TAlimentos> alimentos() {
        List<TAlimentos> alimento = new ArrayList();
        try {
            alimento = (List<TAlimentos>) QR.query(conexion.getConnection(), "SELECT * FROM alimentos",
                    new BeanListHandler(TAlimentos.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex);
        }
        return alimento;
    }

    public void insertAlimento(Object[] dataInventarioSuministro) {
        String sqlInventario1 = "INSERT INTO alimentos(Codigo_al, Nombre_al, Precio_al, Tipo_al)"
                + " VALUES(?,?,?,?)";
        final QueryRunner qr = new QueryRunner(true);
        try {
            qr.insert(conexion.getConnection(), sqlInventario1, new ColumnListHandler(), dataInventarioSuministro);
        } catch (SQLException ex) {
            Logger.getLogger(AlimentoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAlimento(Object[] dataCliente2, int _idCliente) {
        String sqlInventario2 = "UPDATE alimentos SET Codigo_al = ?,Nombre_al = ?,Precio_al = ?, Tipo_al = ?"
                + " WHERE IdAl =" + _idCliente;
        final QueryRunner qr = new QueryRunner(true);
        
        try {
            qr.update(conexion.getConnection(), sqlInventario2, dataCliente2);
        } catch (SQLException ex) {
            Logger.getLogger(AlimentoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        try {
            final QueryRunner qr = new QueryRunner(true);
            sql = "DELETE FROM alimentos WHERE IdAl LIKE ?";
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
