/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.swing.table.DefaultTableModel;
import rojerusan.RSNotifyFade;
import rojerusan.RSTableMetro;

/**
 *
 * @author MATXHUN
 */
public class controlPedido {

    private PedidoSQL pedidoSQL = new PedidoSQL();
    private Pedido pedido = new Pedido();

    public int ObtenerIDPedido() {
        int id = pedidoSQL.obtenerUltimoID() + 1;
        pedido.setId(id);
        return id;
    }

    public void GuardarPedido(int mesa, RSTableMetro platillos) {
        int cantidad = platillos.getRowCount();
        for (int i = 0; i < cantidad; i++) {
            String codigo = platillos.getValueAt(i, 0).toString();
            String Tipo = platillos.getValueAt(i, 1).toString();
            String nombre = platillos.getValueAt(i, 2).toString();
            String Precio = platillos.getValueAt(i, 3).toString();
            String can = platillos.getValueAt(i, 4).toString();
            String id = pedidoSQL.BuscarIDAlimento(codigo); 
            pedido.agregarPlatillo(id, codigo, Tipo, nombre, Precio, Integer.parseInt(can));
        }
        pedido.setIdMesa(mesa);
        pedido.setEstado("noCobrado");
        
        
        
        
        
        
        pedidoSQL.guardarPedido(String.valueOf(mesa));
        for(int i=0; i < pedido.getDetallePedido().size();i++)
        {
            pedidoSQL.guardarDetallePedido(pedido.getDetallePedido().get(i), pedido.getId());
        }
        new rojerusan.RSNotifyFade("Pedido", "Registrado Correctamente", 6, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
    }
    
    public void obtenerPedidos(RSTableMetro platillos)
    {
        if(pedidoSQL.ObtenerPedidosDisponibles().size()==0)
        {
            System.out.println("NO HAY PEDIDOS");
        }
        else
        {
            DefaultTableModel tabla = new DefaultTableModel();
            
            platillos.setModel(tabla);
        }
    }

}
