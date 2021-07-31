/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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

//    public void registrar(TVentas uc) {
//        int rs = 0;
//        sql = "INSERT INTO venta (id,nombre,apellido,total,fecha) VALUES ('001',"+ uc.getNombre() + "," + uc.getApellido() + "," + uc.getTotal() + "," + uc.getFecha() + ")";
//        try {
//            st = conexion.getConnection().prepareStatement(sql);
//            rs = st.executeUpdate(sql);
//            System.out.println("venta registrado con exito");
//        } catch (SQLException ex) {
//            Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(sql);
//    }

}
