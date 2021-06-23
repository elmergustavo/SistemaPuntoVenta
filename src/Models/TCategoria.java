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
public class TCategoria {

    private int IdCat;
    private String Categoria;
    private String Descripcion;

    public TCategoria() {
    }

    
    
    public String getCategoria() {
        return Categoria;
    }

    public int getIdCat() {
        return IdCat;
    }

    public void setIdCat(int IdCat) {
        this.IdCat = IdCat;
    }

    public void setCategoria(String categoria) {
        this.Categoria = categoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

}
