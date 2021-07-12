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

    public int obtenerUltimoID() {
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
    public void GuardarVenta(){
        
    }
    public int obtenerFact(){
        int id = 0;
        sql = "SELECT MAX(id) FROM venta";
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

    public void guardarPedido(String mesa) {
        sql = "INSERT INTO pedido (estado,Mesa_id) VALUES ('NoCobrado'," + mesa + ")";
        int rs = 0;
        try {
            st = conexion.getConnection().prepareStatement(sql);
            rs = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String BuscarIDAlimento(String codigo) {
        String id = "";
        sql = "SELECT IdAl FROM alimentos WHERE Codigo_al='" + codigo + "'";
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

    public void guardarDetallePedido(PlatillosPedido platillo, int id) {
        sql = "INSERT INTO detalle_pedido(pedido_id,alimentos_Id,cantidad) VALUES (" + id + "," + platillo.getNuevo().getIdAl() + "," + platillo.getCantidad() + ")";
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

    public ArrayList<Pedido> ObtenerPedidoMesa(int idMesa) {
        ArrayList<Pedido> Disponibles = new ArrayList<Pedido>();
        sql = "SELECT * FROM pedido WHERE estado='NoCobrado' AND Mesa_id =" + idMesa;
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

    public ArrayList<PlatillosPedido> ObtenerDetallePedido(int idPedido) {
        ArrayList<PlatillosPedido> Disponibles = new ArrayList<PlatillosPedido>();

        sql = "SELECT * FROM detalle_pedido WHERE pedido_id=" + idPedido;
        try {
            st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                TAlimentos plato = new TAlimentos();
                plato = obtenerAlimento(rs.getString(2));
                PlatillosPedido temporal = new PlatillosPedido(plato, Integer.parseInt(rs.getString(3)),0);
                temporal.CalcularTotal();
                Disponibles.add(temporal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("DETALLE DE PEDIDO  " + idPedido);
        for(int a = 0; a <Disponibles.size();a++)
        {
            System.out.println("Platillo ID " + Disponibles.get(a).getNuevo().getIdAl() + " CANTIDAD " +Disponibles.get(a).getCantidad() + " PRECIO" + Disponibles.get(a).getNuevo().getPrecio_al() + " TOTAL" + Disponibles.get(a).getTotal());
        }
        return Disponibles;
    }

    private TAlimentos obtenerAlimento(String id) {
        TAlimentos platillo = new TAlimentos();
        String sql = "";
        Statement st;
        sql = "SELECT * FROM alimentos WHERE IdAl =" + id;
        try {
            st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                platillo.setIdAl(Integer.parseInt(rs.getString(1)));
                platillo.setCodigo_al(rs.getString(2));
                platillo.setNombre_al(rs.getString(3));
                platillo.setPrecio_al(rs.getString(4));
                platillo.setTipo_al(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MesaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return platillo;
    }
    
    public void CambiarEstado(int id)
    {
        sql = "UPDATE pedido SET estado='Cobrado' WHERE id=" + id;
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
