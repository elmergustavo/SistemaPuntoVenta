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
        sql = "SELECT * FROM mesa WHERE idMesa=" + id;
        System.out.println(sql);
        String datos[] = new String[3];
        try {
            st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                mesa = new Mesa();
                mesa.setNumero(Integer.parseInt(rs.getString(1)));
                if (rs.getString(2) == "1") {
                    mesa.setDisponible(true);
                }
                else{
                    mesa.setDisponible(false);
                }
                if (rs.getString(3) == "1") {
                    mesa.setCobrado(true);
                }
                else{
                    mesa.setCobrado(false);
                }  
            }
        } catch (SQLException ex) {
            Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesa;

    }

}
