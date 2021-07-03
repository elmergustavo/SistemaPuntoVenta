/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Conexion.Conexion;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.bolivia.combo.SComboBoxBlue;

/**
 *
 * @author elmer
 */
public class CategoriaSQL {
    private Conexion conexion = Conexion.createInstance();
    private QueryRunner QR = new QueryRunner();
    
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
