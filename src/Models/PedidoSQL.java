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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MATXHUN
 */
public class PedidoSQL {
    private Pedido pedido = new Pedido();
    private Conexion conexion = Conexion.createInstance();
    private String sql = "";
    private Statement st;
    
    public int obtenerUltimoID(){
        int id = 0;
        sql = "SELECT MAX(id) FROM pedido";
        try {
            st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public void guardarPedido(String mesa)
    {
        sql = "INSERT INTO pedido (estado,Mesa_id) VALUES ('NoCobrado',"+mesa+")";
        int rs = 0;
        try {
            st = conexion.getConnection().prepareStatement(sql);
            rs = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String BuscarIDAlimento(String codigo)
    {
        String id = "";
        sql = "SELECT IdAl FROM alimentos WHERE Codigo_al='" + codigo+"'";
        try {
            st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    
    public void guardarDetallePedido(PlatillosPedido platillo, int id)
    {
        sql = "INSERT INTO detalle_pedido(pedido_id,alimentos_Id,cantidad) VALUES ("+id+","+platillo.getNuevo().getIdAl()+","+platillo.getCantidad()+")";
        int rs = 0;
        System.out.println(sql);
        try {
            st = conexion.getConnection().prepareStatement(sql);
            rs = st.executeUpdate(sql);
            System.out.println("exito");
        } catch (SQLException ex) {
            Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Pedido> ObtenerPedidosDisponibles()
    {
        ArrayList<Pedido> Disponibles = new ArrayList<Pedido>();
        
        sql = "SELECT * FROM pedido WHERE estado='NoCobrado'";
        try {
            st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Pedido nuevo = new Pedido();
                nuevo.setId(Integer.parseInt(rs.getString(1)));
                nuevo.setEstado(rs.getString(2));
                nuevo.setIdMesa(Integer.parseInt(rs.getString(3)));
                Disponibles.add(nuevo);
            }
        } catch (SQLException ex) {
             Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Disponibles;
    }
}
