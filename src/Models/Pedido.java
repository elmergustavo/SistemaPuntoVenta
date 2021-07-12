/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author MATXHUN
 */
public class Pedido {
    
    private int id;
    private String estado;
    private int idMesa;
    private ArrayList<PlatillosPedido> detallePedido = new ArrayList<PlatillosPedido>();

    public ArrayList<PlatillosPedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(ArrayList<PlatillosPedido> detallePedido) {
        this.detallePedido = detallePedido;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }
    public void agregarPlatillo(String id, String codigo, String Tipo, String Nombre, String precio, int cantidad)
    {
        TAlimentos temporal = new TAlimentos();
        temporal.setIdAl(Integer.parseInt(id));
        temporal.setCodigo_al(codigo);
        temporal.setTipo_al(Tipo);
        temporal.setNombre_al(Nombre);
        temporal.setPrecio_al(precio);
        PlatillosPedido nuevo = new PlatillosPedido(temporal, cantidad, 0);
        nuevo.CalcularTotal();
        detallePedido.add(nuevo);
    }
    public float ObtenerTotalPedido()
    {
        float total =  0;
        for(int a =0 ; a<detallePedido.size();a++)
        {
            total = total + detallePedido.get(a).getTotal();
        }
        return total;
    }
}
