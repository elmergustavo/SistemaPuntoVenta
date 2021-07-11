/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author MATXHUN
 */
public class PlatillosPedido {
    private TAlimentos nuevo ;
    private int cantidad;
    private float total;

    public TAlimentos getNuevo() {
        return nuevo;
    }

    public void setNuevo(TAlimentos nuevo) {
        this.nuevo = nuevo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public PlatillosPedido(TAlimentos nuevo, int cantidad, int total) {
        this.nuevo = nuevo;
        this.cantidad = cantidad;
        this.total = total;
    }
    
    public void CalcularTotal()
    {
        total = Float.parseFloat(nuevo.getPrecio_al())*cantidad;
    }
}
