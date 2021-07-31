/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Conexion.Conexion;
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

/**
 *
 * @author MATXHUN
 */
public class MesaSQL {

    private Conexion conexion = Conexion.createInstance();
    private Mesa mesa;
    private String sql = "";
    private Statement st;

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesa obtenerMesa(int id) {
        sql = "SELECT * FROM mesa WHERE id=" + id;
        System.out.println(sql);
        try {
            st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs == null) {
                System.out.println("No existen mesa");
            } else {
                while (rs.next()) {
                    mesa = new Mesa();
                    mesa.setNumero(Integer.parseInt(rs.getString(1)));
                    mesa.setEstado(rs.getString(2));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesa;
    }

    public void marcarOcupado(int id) {
        sql = "UPDATE mesa SET estado='O' WHERE id=" + id;
        System.out.println(sql);
        int rs = 0;
        try {
            st = conexion.getConnection().prepareStatement(sql);
            rs = st.executeUpdate(sql);
            System.out.println("CORRECTO");
        } catch (SQLException ex) {
            Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void marcarDisponible(int id) {
        sql = "UPDATE mesa SET estado='D' WHERE id=" + id;
        System.out.println(sql);
        int rs = 0;
        try {
            st = conexion.getConnection().prepareStatement(sql);
            rs = st.executeUpdate(sql);
            System.out.println("CORRECTO");
        } catch (SQLException ex) {
            Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void marcarCobrado(int id) {
        sql = "UPDATE mesa SET estado='C' WHERE id=" + id;
        System.out.println(sql);
        int rs = 0;
        try {
            st = conexion.getConnection().prepareStatement(sql);
            rs = st.executeUpdate(sql);
            System.out.println("CORRECTO");
        } catch (SQLException ex) {
            Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
