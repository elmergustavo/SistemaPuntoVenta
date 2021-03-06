/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
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
    private ArrayList<Pedido> pedidosMesa = new ArrayList<Pedido>();

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
        for (int i = 0; i < pedido.getDetallePedido().size(); i++) {
            pedidoSQL.guardarDetallePedido(pedido.getDetallePedido().get(i), pedido.getId());
        }
        new rojerusan.RSNotifyFade("Pedido", "Registrado Correctamente", 6, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
    }

    public DefaultTableModel ObtenerPedidosMesa(int idMesa) {
        String titulos[] = {"Número de Pedido", "Total"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        pedidosMesa = new ArrayList<Pedido>();
        pedidosMesa = pedidoSQL.ObtenerPedidoMesa(idMesa);
        for (int a = 0; a < pedidosMesa.size(); a++) {
            pedidosMesa.get(a).setDetallePedido(pedidoSQL.ObtenerDetallePedido(pedidosMesa.get(a).getId()));
            Object[] registro = {
                pedidosMesa.get(a).getId(),
                pedidosMesa.get(a).ObtenerTotalPedido()
            };
            modelo.addRow(registro);
        }
        return modelo;
    }

    public DefaultTableModel ObtenerDetallePedido(int idPedido) {
        String titulos[] = {"Cantidad", "Nombre", "Precio", "Monto"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        Boolean verificar = true;
        int index = 0;
        while (verificar) {
            if (pedidosMesa.get(index).getId() == idPedido) {
                pedido = pedidosMesa.get(index);
                verificar = false;
            }
            index++;
        }
        for (int a = 0; a < pedido.getDetallePedido().size(); a++) {
            Object[] registro = {
                pedido.getDetallePedido().get(a).getCantidad(),
                pedido.getDetallePedido().get(a).getNuevo().getNombre_al(),
                pedido.getDetallePedido().get(a).getNuevo().getPrecio_al(),
                pedido.getDetallePedido().get(a).getTotal()
            };
            modelo.addRow(registro);
        }
        return modelo;
    }

    public DefaultTableModel ObtenerDetallePedidoVenta() {
        String titulos[] = {"Cantidad", "Nombre", "Precio", "Monto"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        Boolean verificar = true;
        int index = 0;
        for (int i = 0; i < pedidosMesa.size(); i++) {
            for (int a = 0; a < pedidosMesa.get(i).getDetallePedido().size(); a++) {
                Object[] registro = {
                    pedidosMesa.get(i).getDetallePedido().get(a).getCantidad(),
                    pedidosMesa.get(i).getDetallePedido().get(a).getNuevo().getNombre_al(),
                    pedidosMesa.get(i).getDetallePedido().get(a).getNuevo().getPrecio_al(),
                    pedidosMesa.get(i).getDetallePedido().get(a).getTotal()
                };
                modelo.addRow(registro);
            }
        }
        return modelo;
    }
    public void EliminarPedido(int id)
    {
        Boolean verificar = true;
        int index = 0;
        while (verificar) {
            if (pedidosMesa.get(index).getId() == id) {
                verificar = false;
            }
            index++;
        }
        pedidosMesa.remove(index-1);
    }
    public void CambiarEstadoPedido (int id)
    {
        pedidoSQL.CambiarEstado(id);
    }
    public int ObtenerNumeroFactura ()
    {
        return pedidoSQL.obtenerFact() + 1;
    }
}