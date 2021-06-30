/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Conexion.Conexion;
import Models.Mesa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public Mesa getMesa() {
        return mesa;
    }
    
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    public void obtenerMesa(int numero){
        
    }
    public List<Mesa> Mesas() {
        List<Mesa> mesas = new ArrayList();
        try {
            mesas = (List<Mesa>) QR.query(conexion.getConnection(), "SELECT * FROM Mesa",
                    new BeanListHandler(TAlimentos.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex);
        }
        return mesas;
    }
            
}
