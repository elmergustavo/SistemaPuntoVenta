/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Conexion.Conexion;
import Library.GenerarCodigos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public void insertAlimento(Object[] dataInventarioSuministro) throws SQLException {
        conexion.getConnection().setAutoCommit(false);
        String sqlInventario1 = "INSERT INTO alimentos(Codigo_al, Nombre_al, Precio_al, Tipo_al)"
                + " VALUES(?,?,?,?)";
        final QueryRunner qr = new QueryRunner(true);
        try {
            qr.insert(conexion.getConnection(), sqlInventario1, new ColumnListHandler(), dataInventarioSuministro);
        } catch (SQLException ex) {
            conexion.getConnection().rollback();
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(AlimentoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion.getConnection().commit();
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
    
    public String extraerID() {
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(codigo_al) FROM alimentos";
        String resultado = "";
        try {
            Statement st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                //_textField.get(0).setText("AL0001");
                resultado = "AL0001";
                return resultado;
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
                resultado = "AL" + gen.serie();
                return resultado;
            }

        } catch (SQLException ex) {
            //  Logger.getLogger(OpcionesAl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
