/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author elmer
 */
public class TAlimentos {
    private int IdAl;
    private String Codigo_al;
    private String Tipo_al;
    private String Nombre_al;
    private String Precio_al;

    public TAlimentos() {
    }
    

    public int getIdAl() {
        return IdAl;
    }

    public void setIdAl(int IdAl) {
        this.IdAl = IdAl;
    }

    public String getCodigo_al() {
        return Codigo_al;
    }

    public void setCodigo_al(String Codigo_al) {
        this.Codigo_al = Codigo_al;
    }

    public String getTipo_al() {
        return Tipo_al;
    }

    public void setTipo_al(String Tipo_al) {
        this.Tipo_al = Tipo_al;
    }

    public String getNombre_al() {
        return Nombre_al;
    }

    public void setNombre_al(String Nombre_al) {
        this.Nombre_al = Nombre_al;
    }

    public String getPrecio_al() {
        return Precio_al;
    }

    public void setPrecio_al(String Precio_al) {
        this.Precio_al = Precio_al;
    }
}
