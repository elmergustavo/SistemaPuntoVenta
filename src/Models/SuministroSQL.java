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
public class SuministroSQL {
    private Conexion conexion = Conexion.createInstance();
    private QueryRunner QR = new QueryRunner();
    
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
    
    public void InsertSuministro (Object[] dataInventarioSuministro){
        
        String sqlInventario1 = "INSERT INTO suministros(Codigo, Nombre, Stock,Precio,Categoria)"
                            + " VALUES(?,?,?,?,?)";
        
        try {
            final QueryRunner qr = new QueryRunner(true);
            qr.insert(conexion.getConnection(), sqlInventario1, new ColumnListHandler(), dataInventarioSuministro);
        } catch (SQLException ex) {
            Logger.getLogger(SuministroSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdateSuministro (Object[] dataCliente2, int _idCliente){
        String sqlInventario2 = "UPDATE suministros SET Codigo = ?,Nombre = ?,Stock = ?,Precio = ?,"
                            + "Categoria = ? WHERE IdSuministro =" + _idCliente;
        
        try {
            final QueryRunner qr = new QueryRunner(true);
            qr.update(conexion.getConnection(), sqlInventario2, dataCliente2);
        } catch (SQLException ex) {
            Logger.getLogger(SuministroSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
