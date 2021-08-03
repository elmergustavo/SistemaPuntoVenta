/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Conexion.Conexion;
import static Views.Sistema.tablaVentas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MATXHUN
 */
public class ventaSQL {

    private Conexion conexion = Conexion.createInstance();
    private String sql = "";
    private Statement st;
    
    PreparedStatement ps;
    public  int registrar(TVentas uc) {
        int rsu = 0;
        String sql = "INSERT INTO venta(id, nombre, apellido, total, fecha) "
            + "VALUES(?,?,?,?,?)";
        try {
            ps = conexion.getConnection().prepareStatement(sql);
            ps.setString(1, uc.getId());
            ps.setString(2, uc.getNombre());
            ps.setString(3, uc.getApellido());
            ps.setString(4, uc.getTotal());
            ps.setString(5, uc.getFecha());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    
    public int eliminar(String id) {
        int rsu = 0;
        String sql = "DELETE FROM venta WHERE id = ?";

        try {
            ps = conexion.getConnection().prepareStatement(sql);
            ps.setString(1, id);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    
    public int eliminaTodos() {
        int rsu = 0;
        String sql = "DELETE FROM venta";
        try {
            ps = conexion.getConnection().prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }


    
    public  void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) tablaVentas.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = "SELECT * FROM venta ORDER BY fecha";
        } else {
            sql = "SELECT * FROM venta WHERE (id like'" + busca + "%' or fecha='" + busca + "')"
                    + " ORDER BY fecha";
        }
        String datos[] = new String[5];
        try {
            Statement st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("apellido");
                datos[3] = rs.getString("total");
                datos[4] = rs.getString("fecha");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ventaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
